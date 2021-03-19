package io.github.lucaargolo.terrarianslimes.common.entity.slimes

import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import net.minecraft.entity.EntityType
import net.minecraft.world.World

class MotherSlimeEntity(entityType: EntityType<ModdedSlimeEntity>, world: World, healthMultiplier: Double, speedMultiplier: Double, attackMultiplier: Double): ModdedSlimeEntity(entityType, world, healthMultiplier, speedMultiplier, attackMultiplier) {

    override fun getDefaultSize() = 3

    override fun getChildrenType() = EntityCompendium.BABY_SLIME
    override fun getChildrenQnt() = 3..3

    override fun hasBonusDrops() = false

}