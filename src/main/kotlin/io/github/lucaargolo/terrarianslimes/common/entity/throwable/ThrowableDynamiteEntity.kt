package io.github.lucaargolo.terrarianslimes.common.entity.throwable

import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import net.minecraft.entity.EntityType
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion

class ThrowableDynamiteEntity: ThrowableEntity {

    constructor(entityType: EntityType<ThrowableEntity>, world: World): super(entityType, world)

    constructor(world: World, x: Double, y: Double, z: Double): super(EntityCompendium.DYNAMITE, x, y, z, world)

    override fun getNormalVariant() = ItemCompendium.DYNAMITE

    override fun getStickyVariant() = ItemCompendium.STICKY_DYNAMITE

    override fun getBouncyVariant() = ItemCompendium.BOUNCY_DYNAMITE

    override fun tick() {
        super.tick()
        if(age >= 60) {
            if(!world.isClient) {
                world.createExplosion(this, x, y, z, 4f, Explosion.DestructionType.BREAK)
            }
            remove(RemovalReason.DISCARDED)
        }
    }

}