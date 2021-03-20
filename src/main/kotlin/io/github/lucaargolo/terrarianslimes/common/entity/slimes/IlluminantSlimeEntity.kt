package io.github.lucaargolo.terrarianslimes.common.entity.slimes

import net.minecraft.entity.EntityType
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World
import org.apache.commons.lang3.tuple.MutablePair

class IlluminantSlimeEntity(entityType: EntityType<ModdedSlimeEntity>, world: World, healthMultiplier: Double, speedMultiplier: Double, attackMultiplier: Double): ModdedSlimeEntity(entityType, world, healthMultiplier, speedMultiplier, attackMultiplier) {

    override fun hasBonusDrops() = false

    val previousPositions = mutableListOf<MutablePair<Vec3d, Float>>()

    override fun tick() {
        super.tick()
        if(world.isClient && previousPositions.size < 10 && velocity.length() != 0.0) {
            previousPositions.add(0, MutablePair(Vec3d(pos.x, pos.y, pos.z), 10f))
        }
        val iterator = previousPositions.iterator()
        while(iterator.hasNext()) {
            val prevPos = iterator.next()
            prevPos.setRight(prevPos.right - 1)
            if(prevPos.right <= 0) {
                iterator.remove()
            }
        }
    }

}