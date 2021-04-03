package io.github.lucaargolo.terrarianslimes.common.item

import io.github.lucaargolo.terrarianslimes.utils.RoyalGelHolders
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.Formatting
import net.minecraft.world.World

class RoyalGelItem(settings: Settings): Item(settings) {

    override fun appendTooltip(stack: ItemStack?, world: World?, tooltip: MutableList<Text>, context: TooltipContext?) {
        super.appendTooltip(stack, world, tooltip, context)
        tooltip.add(TranslatableText("tooltip.terrarianslimes.royal_gel").formatted(Formatting.DARK_PURPLE, Formatting.ITALIC))
    }

    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        super.inventoryTick(stack, world, entity, slot, selected)
        (entity as? ServerPlayerEntity)?.let {
            RoyalGelHolders.addHolder(it)
        }
    }

    override fun hasGlint(stack: ItemStack?) = true

}