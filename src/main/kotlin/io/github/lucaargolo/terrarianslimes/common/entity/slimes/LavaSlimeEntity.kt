package io.github.lucaargolo.terrarianslimes.common.entity.slimes

import io.github.lucaargolo.terrarianslimes.utils.ModConfig
import net.minecraft.entity.EntityType
import net.minecraft.entity.ai.pathing.PathNodeType
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.mob.SlimeEntity
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.ItemScatterer
import net.minecraft.world.World

class LavaSlimeEntity<C: ModConfig.ModdedSlimeConfig>(
    entityType: EntityType<out SlimeEntity>,
    world: World,
    particleItem: ItemConvertible,
    config: C,
    defaultSize: Int
): ModdedSlimeEntity<C>(entityType, world, particleItem, config, defaultSize) {

    init {
        setPathfindingPenalty(PathNodeType.WATER, -1.0f)
        setPathfindingPenalty(PathNodeType.LAVA, 8.0f)
        setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0f)
        setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, 0.0f)
    }

    override fun hurtByWater() = true
    override fun isFireImmune() = true

}