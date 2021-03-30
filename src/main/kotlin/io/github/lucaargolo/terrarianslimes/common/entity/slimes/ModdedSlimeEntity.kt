package io.github.lucaargolo.terrarianslimes.common.entity.slimes

import io.github.lucaargolo.terrarianslimes.mixin.AccessorLootContextTypes
import io.github.lucaargolo.terrarianslimes.utils.ModConfig
import io.github.lucaargolo.terrarianslimes.utils.ModIdentifier
import net.minecraft.block.Blocks
import net.minecraft.entity.*
import net.minecraft.entity.attribute.EntityAttributeModifier
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.mob.SlimeEntity
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemStack
import net.minecraft.loot.context.LootContext
import net.minecraft.loot.context.LootContextType
import net.minecraft.nbt.CompoundTag
import net.minecraft.particle.ItemStackParticleEffect
import net.minecraft.particle.ParticleEffect
import net.minecraft.particle.ParticleTypes
import net.minecraft.sound.SoundEvents
import net.minecraft.state.property.Properties
import net.minecraft.tag.BlockTags
import net.minecraft.util.ItemScatterer
import net.minecraft.util.math.MathHelper
import net.minecraft.world.Difficulty
import net.minecraft.world.LocalDifficulty
import net.minecraft.world.ServerWorldAccess
import net.minecraft.world.World

open class ModdedSlimeEntity<C: ModConfig.ModdedSlimeConfig>(
    entityType: EntityType<out SlimeEntity>,
    world: World,
    private val particleItem: ItemConvertible,
    private val config: C,
    private val defaultSize: Int,
    private val statusEffect: StatusEffect? = null,
    private val childrenType: EntityType<out ModdedSlimeEntity<*>>? = null,
    private val childrenQnt: IntRange = 0..0
): SlimeEntity(entityType, world) {

    private val baseHealth = config.baseHealth
    private val baseSpeed = config.baseSpeed
    private val baseAttack = config.baseAttack

    val hasBonusDrops = config.hasBonusDrops
    fun getBonusDrops(): ItemStack = this.dataTracker.get(BONUS_DROPS)

    override fun canAttack() = this.canMoveVoluntarily()

    override fun damage(target: LivingEntity) {
        if (this.isAlive) {
            if (this.canSee(target) && target.damage(DamageSource.mob(this), this.damageAmount)) {
                playSound(SoundEvents.ENTITY_SLIME_ATTACK, 1.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f)
                dealDamage(this, target)
                statusEffect?.let {
                    if(random.nextFloat() < 0.25f) {
                        target.addStatusEffect(StatusEffectInstance(statusEffect, 200, 0))
                    }
                }
            }
        }
    }


    override fun setSize(size: Int, heal: Boolean) {
        super.setSize(size, heal)
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)?.baseValue = this.baseHealth
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)?.baseValue = this.baseSpeed
        this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE)?.baseValue = this.baseAttack
        if (heal) {
            this.health = this.maxHealth
        }
        this.experiencePoints = MathHelper.floor(size * baseAttack)
    }

    override fun getParticles(): ParticleEffect {
        return ItemStackParticleEffect(ParticleTypes.ITEM, ItemStack(particleItem))
    }

    override fun remove() {
        if (!world.isClient && this.isDead) {
            if(this.hasBonusDrops && !this.getBonusDrops().isEmpty) {
                ItemScatterer.spawn(world, pos.x, pos.y, pos.z, this.getBonusDrops())
            }
            for (l in 0 until this.childrenQnt.random()) {
                val g = ((l % 2) - 0.5f) * this.size/4
                val h = ((l / 2) - 0.5f) * this.size/4
                val childrenEntity = this.childrenType?.create(this.world) ?: break
                if(childrenEntity.config.enabled) {
                    if (this.isPersistent) {
                        childrenEntity.setPersistent()
                    }
                    childrenEntity.customName = this.customName
                    childrenEntity.isAiDisabled = this.isAiDisabled
                    childrenEntity.isInvulnerable = this.isInvulnerable
                    childrenEntity.setSize(childrenEntity.defaultSize, true)
                    childrenEntity.refreshPositionAndAngles(
                        this.x + g.toDouble(),
                        this.y + 0.5,
                        this.z + h.toDouble(),
                        this.random.nextFloat() * 360.0f,
                        0.0f
                    )
                    this.world.spawnEntity(childrenEntity)
                }
            }
        }
        this.removed = true
    }

    override fun initialize(world: ServerWorldAccess, difficulty: LocalDifficulty, spawnReason: SpawnReason, entityData: EntityData?, entityTag: CompoundTag?): EntityData? {
        this.getAttributeInstance(EntityAttributes.GENERIC_FOLLOW_RANGE)?.addPersistentModifier(EntityAttributeModifier("Random spawn bonus", random.nextGaussian() * 0.05, EntityAttributeModifier.Operation.MULTIPLY_BASE))
        this.isLeftHanded = this.random.nextFloat() < 0.05f
        this.setSize(this.defaultSize, true)
        if(this.hasBonusDrops) {
            val serverWorld = world.toServerWorld()
            val table = serverWorld.server.lootManager.getTable(ModIdentifier("slimes/default_drops"))
            val ctx = LootContext.Builder(serverWorld).random(this.random).build(SLIMES_LOOT_CONTEXT)
            val stackList = table.generateLoot(ctx)
            this.dataTracker.set(BONUS_DROPS, stackList.firstOrNull() ?: ItemStack.EMPTY)
        }
        return entityData
    }

    override fun readCustomDataFromTag(tag: CompoundTag) {
        if(this.hasBonusDrops && tag.contains("bonusDrops")) {
           this.dataTracker.set(BONUS_DROPS, ItemStack.fromTag(tag.getCompound("bonusDrops")))
        }
        super.readCustomDataFromTag(tag)
    }

    override fun writeCustomDataToTag(tag: CompoundTag) {
        if(this.hasBonusDrops && !this.getBonusDrops().isEmpty) {
            tag.put("bonusDrops", this.getBonusDrops().toTag(CompoundTag()))
        }
        super.writeCustomDataToTag(tag)
    }

    override fun initDataTracker() {
        super.initDataTracker()
        this.dataTracker.startTracking(BONUS_DROPS, ItemStack.EMPTY)
    }

    @Suppress("DEPRECATION", "UNUSED_ANONYMOUS_PARAMETER")
    companion object {
        private val BONUS_DROPS: TrackedData<ItemStack> = DataTracker.registerData(ModdedSlimeEntity::class.java, TrackedDataHandlerRegistry.ITEM_STACK)
        private val SLIMES_LOOT_CONTEXT: LootContextType = LootContextType.Builder().build()

        fun getJungleSpawnPredicate(spawnProbability: Float) = SpawnRestriction.SpawnPredicate<ModdedSlimeEntity<*>> { type, serverWorldAccess, spawnReason, pos, random ->
            val isPeaceful = serverWorldAccess.difficulty == Difficulty.PEACEFUL
            val isSpawner = spawnReason == SpawnReason.SPAWNER

            val downBlockState = serverWorldAccess.getBlockState(pos.down())
            val isDownBlockValid = downBlockState.isOf(Blocks.GRASS_BLOCK) || downBlockState.isIn(BlockTags.LEAVES)
            val isSkyVisible = serverWorldAccess.isSkyVisible(pos)
            
            val meetsProbability = random.nextFloat() <= spawnProbability
            meetsProbability && !isPeaceful && (isSpawner || (isDownBlockValid && isSkyVisible))
        }

        fun getSnowSpawnPredicate(spawnProbability: Float) = SpawnRestriction.SpawnPredicate<ModdedSlimeEntity<*>> { type, serverWorldAccess, spawnReason, pos, random ->
            val isPeaceful = serverWorldAccess.difficulty == Difficulty.PEACEFUL
            val isSpawner = spawnReason == SpawnReason.SPAWNER

            val downBlockState = serverWorldAccess.getBlockState(pos.down())
            val isDownBlockValid = downBlockState.isIn(BlockTags.ICE) || downBlockState.isOf(Blocks.SNOW_BLOCK) || (downBlockState.isOf(Blocks.GRASS_BLOCK) && downBlockState[Properties.SNOWY])
            val isSkyVisible = serverWorldAccess.isSkyVisible(pos)

            val meetsProbability = random.nextFloat() <= spawnProbability
            meetsProbability && !isPeaceful && (isSpawner || (isDownBlockValid && isSkyVisible))
        }

        fun getSandSpawnPredicate(spawnProbability: Float) = SpawnRestriction.SpawnPredicate<ModdedSlimeEntity<*>> { type, serverWorldAccess, spawnReason, pos, random ->
            val isPeaceful = serverWorldAccess.difficulty == Difficulty.PEACEFUL
            val isSpawner = spawnReason == SpawnReason.SPAWNER

            val downBlockState = serverWorldAccess.getBlockState(pos.down())
            val isDownBlockValid = downBlockState.isIn(BlockTags.SAND)
            val isSkyVisible = serverWorldAccess.isSkyVisible(pos)

            val meetsProbability = random.nextFloat() <= spawnProbability
            meetsProbability && !isPeaceful && (isSpawner || (isDownBlockValid && isSkyVisible))
        }

        fun getHellSpawnPredicate(spawnProbability: Float) = SpawnRestriction.SpawnPredicate<ModdedSlimeEntity<*>> { type, serverWorldAccess, spawnReason, pos, random ->
            val isPeaceful = serverWorldAccess.difficulty == Difficulty.PEACEFUL
            val isSpawner = spawnReason == SpawnReason.SPAWNER

            val downBlockState = serverWorldAccess.getBlockState(pos.down())
            val isDownBlockValid = downBlockState.isOf(Blocks.NETHERRACK) || downBlockState.isIn(BlockTags.NYLIUM)

            val meetsProbability = random.nextFloat() <= spawnProbability
            meetsProbability && !isPeaceful && (isSpawner || isDownBlockValid)
        }

        fun getTheEndSpawnPredicate(spawnProbability: Float) = SpawnRestriction.SpawnPredicate<ModdedSlimeEntity<*>> { type, serverWorldAccess, spawnReason, pos, random ->
            val isPeaceful = serverWorldAccess.difficulty == Difficulty.PEACEFUL
            val isSpawner = spawnReason == SpawnReason.SPAWNER

            val downBlockState = serverWorldAccess.getBlockState(pos.down())
            val isDownBlockValid = downBlockState.isOf(Blocks.END_STONE)

            val meetsProbability = random.nextFloat() <= spawnProbability
            meetsProbability && !isPeaceful && (isSpawner || isDownBlockValid)
        }

        fun getSurfaceSpawnPredicate(spawnProbability: Float) = SpawnRestriction.SpawnPredicate<ModdedSlimeEntity<*>> { type, serverWorldAccess, spawnReason, pos, random ->
            val isPeaceful = serverWorldAccess.difficulty == Difficulty.PEACEFUL
            val isSpawner = spawnReason == SpawnReason.SPAWNER

            val downBlockState = serverWorldAccess.getBlockState(pos.down())
            val isDownBlockValid = downBlockState.isOf(Blocks.GRASS_BLOCK)
            val isSkyVisible = serverWorldAccess.isSkyVisible(pos)

            val meetsProbability = random.nextFloat() <= spawnProbability
            meetsProbability && !isPeaceful && (isSpawner || (isDownBlockValid && isSkyVisible))
        }

        fun getFarSurfaceSpawnPredicate(spawnProbability: Float) = SpawnRestriction.SpawnPredicate<ModdedSlimeEntity<*>> { type, serverWorldAccess, spawnReason, pos, random ->
            val isPeaceful = serverWorldAccess.difficulty == Difficulty.PEACEFUL
            val isSpawner = spawnReason == SpawnReason.SPAWNER

            val downBlockState = serverWorldAccess.getBlockState(pos.down())
            val isDownBlockValid = downBlockState.isOf(Blocks.GRASS_BLOCK)
            val isSkyVisible = serverWorldAccess.isSkyVisible(pos)
            val isSpawnFar = !serverWorldAccess.toServerWorld().spawnPos.isWithinDistance(pos, 400.0)

            val meetsProbability = random.nextFloat() <= spawnProbability
            meetsProbability && !isPeaceful && (isSpawner || (isDownBlockValid && isSkyVisible && isSpawnFar))
        }

        fun getRainySurfaceSpawnPredicate(spawnProbability: Float) = SpawnRestriction.SpawnPredicate<ModdedSlimeEntity<*>> { type, serverWorldAccess, spawnReason, pos, random ->
            val isPeaceful = serverWorldAccess.difficulty == Difficulty.PEACEFUL
            val isSpawner = spawnReason == SpawnReason.SPAWNER

            val downBlockState = serverWorldAccess.getBlockState(pos.down())
            val isDownBlockValid = downBlockState.isOf(Blocks.GRASS_BLOCK)
            val isSkyVisible = serverWorldAccess.isSkyVisible(pos)
            val isRaining = serverWorldAccess.toServerWorld().isRaining

            val meetsProbability = random.nextFloat() <= spawnProbability
            meetsProbability && !isPeaceful && (isSpawner || (isDownBlockValid && isSkyVisible && isRaining))
        }

        fun getUnderGroundSpawnPredicate(spawnProbability: Float) = SpawnRestriction.SpawnPredicate<ModdedSlimeEntity<*>> { type, serverWorldAccess, spawnReason, pos, random ->
            val isPeaceful = serverWorldAccess.difficulty == Difficulty.PEACEFUL
            val isSpawner = spawnReason == SpawnReason.SPAWNER

            val downBlockState = serverWorldAccess.getBlockState(pos.down())
            val isDownBlockValid = pos.y < serverWorldAccess.seaLevel && downBlockState.allowsSpawning(serverWorldAccess, pos, type)
            val isSkyVisible = serverWorldAccess.isSkyVisible(pos)

            val meetsProbability = random.nextFloat() <= spawnProbability
            meetsProbability && !isPeaceful && (isSpawner || (isDownBlockValid && !isSkyVisible))
        }

        fun getCavernsSpawnPredicate(spawnProbability: Float) = SpawnRestriction.SpawnPredicate<ModdedSlimeEntity<*>> { type, serverWorldAccess, spawnReason, pos, random ->
            val isPeaceful = serverWorldAccess.difficulty == Difficulty.PEACEFUL
            val isSpawner = spawnReason == SpawnReason.SPAWNER

            val downBlockState = serverWorldAccess.getBlockState(pos.down())
            val isDownBlockValid = pos.y < serverWorldAccess.seaLevel/2 && downBlockState.allowsSpawning(serverWorldAccess, pos, type)
            val isSkyVisible = serverWorldAccess.isSkyVisible(pos)

            val meetsProbability = random.nextFloat() <= spawnProbability
            meetsProbability && !isPeaceful && (isSpawner || (isDownBlockValid && !isSkyVisible))
        }

        init {
            AccessorLootContextTypes.getMap()[ModIdentifier("slimes")] = SLIMES_LOOT_CONTEXT
        }
    }

}