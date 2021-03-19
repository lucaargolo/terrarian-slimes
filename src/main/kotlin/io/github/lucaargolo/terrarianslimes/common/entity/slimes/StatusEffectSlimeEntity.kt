package io.github.lucaargolo.terrarianslimes.common.entity.slimes

import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.world.World

class StatusEffectSlimeEntity(entityType: EntityType<ModdedSlimeEntity>, world: World, healthMultiplier: Double, speedMultiplier: Double, attackMultiplier: Double, private val statusEffect: StatusEffect): ModdedSlimeEntity(entityType, world, healthMultiplier, speedMultiplier, attackMultiplier) {

    override fun onAttacking(target: Entity) {
        if(this.random.nextFloat() < 0.25f && target is LivingEntity && !this.world.isClient) {
            target.addStatusEffect(StatusEffectInstance(statusEffect, 10, 1))
        }
        super.onAttacking(target)
    }

}