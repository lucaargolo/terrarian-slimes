package io.github.lucaargolo.terrarianslimes.common.entity.slimes

import io.github.lucaargolo.terrarianslimes.common.entity.goals.ShootSpikeGoal
import io.github.lucaargolo.terrarianslimes.common.entity.spike.SpikeEntity
import io.github.lucaargolo.terrarianslimes.utils.ModConfig
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.ai.RangedAttackMob
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.mob.SlimeEntity
import net.minecraft.item.ItemConvertible
import net.minecraft.sound.SoundEvents
import net.minecraft.util.math.MathHelper
import net.minecraft.world.World

class SpikedSlimeEntity(
    entityType: EntityType<out SlimeEntity>,
    world: World,
    particleItem: ItemConvertible,
    config: ModConfig.SpikedSlimeConfig,
    defaultSize: Int,
    private val spikeStatusEffect: StatusEffect? = null,
    ownStatusEffect: StatusEffect? = null
): ModdedSlimeEntity<ModConfig.SpikedSlimeConfig>(entityType, world, particleItem, config, defaultSize, ownStatusEffect), RangedAttackMob {

    private val baseSpikeAttack = config.baseSpikeAttack
    private val spikeAttackCooldown = config.spikeAttackCooldown

    init {
        goalSelector.add(1, ShootSpikeGoal(this, spikeAttackCooldown))
    }

    override fun attack(target: LivingEntity, pullProgress: Float) {
        val persistentProjectileEntity = SpikeEntity(this.world, this, this.baseSpikeAttack, this.spikeStatusEffect)
        val velocityX = target.x - this.x
        val velocityY = target.getBodyY(1.0/3.0) - persistentProjectileEntity.y
        val velocityZ = target.z - this.z
        val h = MathHelper.sqrt((velocityX * velocityX + velocityZ * velocityZ).toFloat()).toDouble()
        persistentProjectileEntity.setVelocity(velocityX, velocityY + h * 0.2, velocityZ, 1.0f, 10f)
        playSound(SoundEvents.ENTITY_HOSTILE_SPLASH, 1.0f, 0.4f / (this.random.nextFloat() * 0.4f + 0.8f))
        world.spawnEntity(persistentProjectileEntity)
    }

}