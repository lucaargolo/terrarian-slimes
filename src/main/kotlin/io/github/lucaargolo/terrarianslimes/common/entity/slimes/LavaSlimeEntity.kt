package io.github.lucaargolo.terrarianslimes.common.entity.slimes

import net.minecraft.entity.EntityType
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.ItemScatterer
import net.minecraft.world.World

class LavaSlimeEntity(entityType: EntityType<ModdedSlimeEntity>, world: World, healthMultiplier: Double, speedMultiplier: Double, attackMultiplier: Double): ModdedSlimeEntity(entityType, world, healthMultiplier, speedMultiplier, attackMultiplier) {

    override fun isFireImmune() = true
    override fun hasBonusDrops() = false

    override fun tick() {
        if(isTouchingWaterOrRain) {
            this.remove()
            if(!this.world.isClient) {
                ItemScatterer.spawn(this.world, pos.x, pos.y, pos.z, ItemStack(Items.OBSIDIAN))
            }
        }
        super.tick()
    }

}