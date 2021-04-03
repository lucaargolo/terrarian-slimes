package io.github.lucaargolo.terrarianslimes.common.item

import io.github.lucaargolo.terrarianslimes.utils.RoyalGelHolders
import net.minecraft.entity.Entity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.world.World

class RoyalGelItem(settings: Settings): Item(settings) {

    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        super.inventoryTick(stack, world, entity, slot, selected)
        (entity as? ServerPlayerEntity)?.let {
            RoyalGelHolders.addHolder(it)
        }
    }

    override fun hasGlint(stack: ItemStack?) = true

}