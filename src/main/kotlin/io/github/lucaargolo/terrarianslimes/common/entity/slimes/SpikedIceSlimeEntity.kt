package io.github.lucaargolo.terrarianslimes.common.entity.slimes

import net.minecraft.entity.EntityType
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.world.World

class SpikedIceSlimeEntity(entityType: EntityType<ModdedSlimeEntity>, world: World, healthMultiplier: Double, speedMultiplier: Double, attackMultiplier: Double): StatusEffectSlimeEntity(entityType, world, healthMultiplier, speedMultiplier, attackMultiplier, StatusEffects.SLOWNESS) {

    override fun getDefaultSize() = 2
    override fun hasBonusDrops() = false


}