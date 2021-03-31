package io.github.lucaargolo.terrarianslimes.common.entity.throwable

import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import net.minecraft.entity.EntityType
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion

class ThrowableDirtBombEntity: ThrowableEntity {

    constructor(entityType: EntityType<ThrowableEntity>, world: World): super(entityType, world)

    constructor(world: World, x: Double, y: Double, z: Double): super(EntityCompendium.DIRT_BOMB, x, y, z, world)

    override fun getNormalVariant() = ItemCompendium.DIRT_BOMB

    override fun getStickyVariant() = ItemCompendium.STICKY_DIRT_BOMB

    override fun getBouncyVariant() = ItemCompendium.BOUNCY_DIRT_BOMB

    override fun tick() {
        super.tick()
        if(age >= 60) {
            if(!world.isClient) {
                world.createExplosion(this, x, y, z, 2f, Explosion.DestructionType.BREAK)
            }
            remove()
        }
    }

}