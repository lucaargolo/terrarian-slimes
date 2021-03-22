package io.github.lucaargolo.terrarianslimes.common.entity.slimes

import io.github.lucaargolo.terrarianslimes.common.entity.spike.SpikeEntity
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.ai.RangedAttackMob
import net.minecraft.entity.ai.goal.ProjectileAttackGoal
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.sound.SoundEvents
import net.minecraft.util.math.MathHelper
import net.minecraft.world.World

class SpikedSlimeEntity(
    entityType: EntityType<ModdedSlimeEntity>,
    world: World,
    healthMultiplier: Double,
    speedMultiplier: Double,
    attackMultiplier: Double,
    defaultSize: Int,
    hasBonusDrops: Boolean,
    private val spikeDamage: Double,
    private val spikeStatusEffect: StatusEffect? = null,
    ownStatusEffect: StatusEffect? = null
): ModdedSlimeEntity(entityType, world, healthMultiplier, speedMultiplier, attackMultiplier, defaultSize, hasBonusDrops, ownStatusEffect), RangedAttackMob {

    init {
        goalSelector.add(1, ProjectileAttackGoal(this, 1.25, 30, 10.0f))
    }

    override fun attack(target: LivingEntity, pullProgress: Float) {
        val persistentProjectileEntity = SpikeEntity(this.world, this, this.spikeDamage, this.spikeStatusEffect)
        val velocityX = target.x - this.x
        val velocityY = target.getBodyY(0.3333333333333333) - persistentProjectileEntity.y
        val velocityZ = target.z - this.z
        val h = MathHelper.sqrt(velocityX * velocityX + velocityZ * velocityZ).toDouble()
        persistentProjectileEntity.setVelocity(velocityX, velocityY + h * 0.20000000298023224, velocityZ, 1.6f, (14 - world.difficulty.id * 4).toFloat())
        playSound(SoundEvents.ENTITY_HOSTILE_SPLASH, 1.0f, 0.4f / (this.random.nextFloat() * 0.4f + 0.8f))
        world.spawnEntity(persistentProjectileEntity)
    }

}