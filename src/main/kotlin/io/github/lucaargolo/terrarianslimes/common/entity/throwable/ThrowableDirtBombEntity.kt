package io.github.lucaargolo.terrarianslimes.common.entity.throwable

import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import io.github.lucaargolo.terrarianslimes.utils.ExplosionBlockStateReplacement
import net.minecraft.block.Blocks
import net.minecraft.entity.EntityType
import net.minecraft.server.world.ServerWorld
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
            (world as? ServerWorld)?.let { serverWorld ->
                ExplosionBlockStateReplacement.Server.setupReplacementBlockState(serverWorld, x, y, z, Blocks.DIRT.defaultState)
                serverWorld.createExplosion(this, null, null, x, y, z, 2f, false, Explosion.DestructionType.DESTROY)
            }
            remove(RemovalReason.DISCARDED)
        }
    }

}