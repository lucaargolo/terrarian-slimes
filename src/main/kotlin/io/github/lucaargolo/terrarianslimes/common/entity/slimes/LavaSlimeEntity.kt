package io.github.lucaargolo.terrarianslimes.common.entity.slimes

import net.minecraft.entity.EntityType
import net.minecraft.entity.ai.pathing.PathNodeType
import net.minecraft.entity.damage.DamageSource
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.ItemScatterer
import net.minecraft.world.World

class LavaSlimeEntity(entityType: EntityType<ModdedSlimeEntity>, world: World, healthMultiplier: Double, speedMultiplier: Double, attackMultiplier: Double): ModdedSlimeEntity(entityType, world, healthMultiplier, speedMultiplier, attackMultiplier) {

    init {
        setPathfindingPenalty(PathNodeType.WATER, -1.0f)
        setPathfindingPenalty(PathNodeType.LAVA, 8.0f)
        setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0f)
        setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, 0.0f)
    }

    override fun hurtByWater() = true
    override fun isFireImmune() = true
    override fun hasBonusDrops() = false

    override fun onDeath(source: DamageSource) {
        if(source == DamageSource.DROWN && !this.world.isClient) {
            ItemScatterer.spawn(this.world, this.pos.x, this.pos.y, this.pos.z, ItemStack(Items.OBSIDIAN))
        }
        super.onDeath(source)
    }

}