package io.github.lucaargolo.terrarianslimes.common.entity.throwable

import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import net.minecraft.entity.EntityType
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion

class ThrowableGrenadeEntity: ThrowableEntity {

    constructor(entityType: EntityType<ThrowableEntity>, world: World): super(entityType, world)

    constructor(world: World, x: Double, y: Double, z: Double): super(EntityCompendium.GRENADE, x, y, z, world)

    override fun getNormalVariant() = ItemCompendium.GRENADE

    override fun getStickyVariant() = ItemCompendium.STICKY_GRENADE

    override fun getBouncyVariant() = ItemCompendium.BOUNCY_GRENADE

    override fun tick() {
        super.tick()
        if(age >= 60) {
            if(!world.isClient) {
                world.createExplosion(this, x, y, z, 1f, Explosion.DestructionType.NONE)
            }
            remove()
        }
    }

}