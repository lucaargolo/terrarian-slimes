package io.github.lucaargolo.terrarianslimes.common.entity.slimes

import io.github.lucaargolo.terrarianslimes.utils.ModConfig
import net.minecraft.entity.EntityType
import net.minecraft.entity.mob.SlimeEntity
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World
import org.apache.commons.lang3.tuple.MutablePair

class IlluminantSlimeEntity<C: ModConfig.ModdedSlimeConfig>(
    entityType: EntityType<out SlimeEntity>,
    world: World,
    config: C,
    defaultSize: Int
): ModdedSlimeEntity<C>(entityType, world, config, defaultSize) {

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