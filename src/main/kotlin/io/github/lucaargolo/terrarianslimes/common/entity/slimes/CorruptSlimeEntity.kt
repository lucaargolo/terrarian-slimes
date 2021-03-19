package io.github.lucaargolo.terrarianslimes.common.entity.slimes

import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import net.minecraft.entity.EntityType
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.world.World

class CorruptSlimeEntity(entityType: EntityType<ModdedSlimeEntity>, world: World, healthMultiplier: Double, speedMultiplier: Double, attackMultiplier: Double): StatusEffectSlimeEntity(entityType, world, healthMultiplier, speedMultiplier, attackMultiplier, StatusEffects.BLINDNESS) {

    override fun getDefaultSize() = 3

    override fun getChildrenType() = EntityCompendium.SLIMELING
    override fun getChildrenQnt() = 2..3

    override fun hasBonusDrops() = false

}