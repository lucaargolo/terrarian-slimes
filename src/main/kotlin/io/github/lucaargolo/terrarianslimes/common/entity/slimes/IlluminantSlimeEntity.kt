package io.github.lucaargolo.terrarianslimes.common.entity.slimes

import net.minecraft.entity.EntityType
import net.minecraft.entity.ai.pathing.PathNodeType
import net.minecraft.entity.damage.DamageSource
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.ItemScatterer
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World
import org.apache.commons.lang3.tuple.MutablePair

class IlluminantSlimeEntity(entityType: EntityType<ModdedSlimeEntity>, world: World, healthMultiplier: Double, speedMultiplier: Double, attackMultiplier: Double): ModdedSlimeEntity(entityType, world, healthMultiplier, speedMultiplier, attackMultiplier) {

    override fun hasBonusDrops() = false

    val previousPositions = mutableListOf<MutablePair<Vec3d, Float>>()

}