package io.github.lucaargolo.terrarianslimes.common.entity.slimes

import net.minecraft.entity.EntityType
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.world.World

class NoBonusStatusEffectSlimeEntity(entityType: EntityType<ModdedSlimeEntity>, world: World, healthMultiplier: Double, speedMultiplier: Double, attackMultiplier: Double, statusEffect: StatusEffect): StatusEffectSlimeEntity(entityType, world, healthMultiplier, speedMultiplier, attackMultiplier, statusEffect) {

    override fun hasBonusDrops() = false

}