package io.github.lucaargolo.terrarianslimes.common.entity.throwable

import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import net.minecraft.entity.EntityType
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion

class ThrowableGlowstickEntity: ThrowableEntity {

    constructor(entityType: EntityType<ThrowableEntity>, world: World): super(entityType, world)

    constructor(world: World, x: Double, y: Double, z: Double): super(EntityCompendium.GLOWSTICK, x, y, z, world)

    override fun getNormalVariant() = ItemCompendium.GLOWSTICK

    override fun getStickyVariant() = ItemCompendium.STICKY_GLOWSTICK

    override fun getBouncyVariant() = ItemCompendium.BOUNCY_GLOWSTICK

    override fun tick() {
        super.tick()
    }

}