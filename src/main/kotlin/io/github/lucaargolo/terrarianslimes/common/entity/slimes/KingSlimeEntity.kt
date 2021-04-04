package io.github.lucaargolo.terrarianslimes.common.entity.slimes

import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import io.github.lucaargolo.terrarianslimes.utils.ModConfig
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.boss.BossBar
import net.minecraft.entity.boss.ServerBossBar
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.mob.SlimeEntity
import net.minecraft.item.ItemConvertible
import net.minecraft.nbt.CompoundTag
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.math.MathHelper
import net.minecraft.world.World

class KingSlimeEntity<C: ModConfig.ModdedSlimeConfig>(
    entityType: EntityType<out SlimeEntity>,
    world: World,
    particleItem: ItemConvertible,
    config: C,
    defaultSize: Int
): ModdedSlimeEntity<C>(entityType, world, particleItem, config, defaultSize) {

    private val bossBar = ServerBossBar(displayName, BossBar.Color.PURPLE, BossBar.Style.PROGRESS)

    private var isTeleporting: Boolean
        get() = dataTracker.get(TELEPORTING)
        set(value) = dataTracker.set(TELEPORTING, value)

    private var teleportingTarget: Entity?
        get() = world.getEntityById(dataTracker.get(TELEPORTING_TARGET))
        set(value) = dataTracker.set(TELEPORTING_TARGET, value?.entityId ?: -1)

    var teleportingProgress: Int
        get() = dataTracker.get(TELEPORTING_PROGRESS)
        set(value) = dataTracker.set(TELEPORTING_PROGRESS, value)

    var spawnProgress: Int
        get() = dataTracker.get(SPAWN_PROGRESS)
        set(value) = dataTracker.set(SPAWN_PROGRESS, value)

    override fun onStartedTrackingBy(player: ServerPlayerEntity) {
        super.onStartedTrackingBy(player)
        bossBar.addPlayer(player)
    }

    override fun onStoppedTrackingBy(player: ServerPlayerEntity?) {
        super.onStoppedTrackingBy(player)
        bossBar.removePlayer(player)
    }

    override fun writeCustomDataToTag(tag: CompoundTag) {
        super.writeCustomDataToTag(tag)
        tag.putInt("spawnProgress", spawnProgress)
    }

    override fun readCustomDataFromTag(tag: CompoundTag) {
        super.readCustomDataFromTag(tag)
        if (hasCustomName()) {
            bossBar.name = this.displayName
        }
        spawnProgress = tag.getInt("spawnProgress")
        bossBar.percent = this.health / this.maxHealth
    }

    override fun isAiDisabled() = spawnProgress > 0 || super.isAiDisabled()

    override fun isAffectedBySplashPotions() = spawnProgress <= 0 && super.isAttackable()

    override fun isAttackable() = spawnProgress <= 0 && super.isAttackable()

    override fun canAttack() = spawnProgress <= 0 && super.canAttack()

    override fun ignoreRoyalGel() = false

    override fun setTarget(target: LivingEntity?) {
        if(target == null && this.target != null) {
            isTeleporting = true
            teleportingProgress = 100
            teleportingTarget = this.target
        }
        super.setTarget(target)
    }

    override fun setCustomName(name: Text?) {
        super.setCustomName(name)
        bossBar.name = this.displayName
    }

    override fun tick() {
        super.tick()
        if(isTeleporting || spawnProgress > 0) {
            if(!world.isClient) {
                if(isTeleporting) {
                    when (teleportingProgress--) {
                        50 -> {
                            val tpPos = teleportingTarget?.pos ?: pos
                            teleport(tpPos.x, tpPos.y, tpPos.z, true)
                        }
                        0 -> isTeleporting = false
                    }
                }
                if(spawnProgress > 0) {
                    spawnProgress--
                    bossBar.percent = (200f-spawnProgress) / 200f
                }
            }
            for (j in 0 until size * 8) {
                val f = random.nextFloat() * 6.2831855f
                val g = random.nextFloat() * 0.5f + 0.5f
                val h = MathHelper.sin(f) * size * 0.5f * g
                val k = MathHelper.cos(f) * size * 0.5f * g
                world.addParticle(this.particles, this.x + h.toDouble(), this.y, this.z + k.toDouble(), 0.0, 0.0, 0.0)
            }
        }
    }

    override fun damage(source: DamageSource, amount: Float): Boolean {
        val oldHealth = this.health
        val damage = super.damage(source, amount)
        bossBar.percent = this.health / this.maxHealth
        if(!world.isClient && ModConfig.SPIKED_SLIME.enabled && (this.health % 100 == 0f || this.health % 100 > oldHealth % 100)) {
            repeat((1..3).random()) { l ->
                val g = ((l % 2) - 0.5f) * this.size/4
                val h = ((l / 2) - 0.5f) * this.size/4
                val childrenEntity = EntityCompendium.SPIKED_SLIME.create(this.world) ?: return@repeat
                childrenEntity.setPersistent()
                childrenEntity.customName = this.customName
                childrenEntity.isAiDisabled = this.isAiDisabled
                childrenEntity.isInvulnerable = this.isInvulnerable
                childrenEntity.setDefaultSize(true)
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
        return damage
    }

    override fun initDataTracker() {
        super.initDataTracker()
        this.dataTracker.startTracking(TELEPORTING_PROGRESS, 100)
        this.dataTracker.startTracking(TELEPORTING_TARGET, -1)
        this.dataTracker.startTracking(TELEPORTING, false)
        this.dataTracker.startTracking(SPAWN_PROGRESS, 200)
    }

    companion object {
        val TELEPORTING_PROGRESS: TrackedData<Int> = DataTracker.registerData(KingSlimeEntity::class.java, TrackedDataHandlerRegistry.INTEGER)
        val TELEPORTING_TARGET: TrackedData<Int> = DataTracker.registerData(KingSlimeEntity::class.java, TrackedDataHandlerRegistry.INTEGER)
        val TELEPORTING: TrackedData<Boolean> = DataTracker.registerData(KingSlimeEntity::class.java, TrackedDataHandlerRegistry.BOOLEAN)
        val SPAWN_PROGRESS: TrackedData<Int> = DataTracker.registerData(KingSlimeEntity::class.java, TrackedDataHandlerRegistry.INTEGER)
    }

}