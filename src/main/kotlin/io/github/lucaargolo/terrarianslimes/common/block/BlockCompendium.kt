package io.github.lucaargolo.terrarianslimes.common.block

import io.github.lucaargolo.terrarianslimes.TerrarianSlimes.Companion.creativeGroupSettings
import io.github.lucaargolo.terrarianslimes.common.block.rainbow.RainbowSlimeBlock
import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import io.github.lucaargolo.terrarianslimes.utils.ModIdentifier
import io.github.lucaargolo.terrarianslimes.utils.RegistryCompendium
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.SlimeBlock
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.RenderLayer
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import java.awt.Color

object BlockCompendium: RegistryCompendium<Block>(Registry.BLOCK) {

    val BLUE_SLIME_BLOCK = register("blue_slime_block", SlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK)))
    val RED_SLIME_BLOCK = register("red_slime_block", SlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK)))
    val PURPLE_SLIME_BLOCK = register("purple_slime_block", SlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK)))
    val YELLOW_SLIME_BLOCK = register("yellow_slime_block", SlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK)))
    val BLACK_SLIME_BLOCK = register("black_slime_block", SlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK)))
    val ICE_SLIME_BLOCK = register("ice_slime_block", SlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK)))
    val SAND_SLIME_BLOCK = register("sand_slime_block", SlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK)))
    val JUNGLE_SLIME_BLOCK = register("jungle_slime_block", SlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK)))
    val PINKY_SLIME_BLOCK = register("pinky_slime_block", SlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK)))
    val CORRUPT_SLIME_BLOCK = register("corrupt_slime_block", SlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK)))
    val CRIMSON_SLIME_BLOCK = register("crimson_slime_block", SlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK)))
    val ILLUMINANT_SLIME_BLOCK = register("illuminant_slime_block", SlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK)))
    val RAINBOW_SLIME_BLOCK = register("rainbow_slime_block", RainbowSlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK)))

    fun registerBlockItems(itemMap: MutableMap<Identifier, Item>) {
        map.forEach { (identifier, block) ->
            itemMap[identifier] = BlockItem(block, creativeGroupSettings())
        }
    }

    fun initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderLayer.getTranslucent(),
            BLACK_SLIME_BLOCK,
            BLUE_SLIME_BLOCK,
            CORRUPT_SLIME_BLOCK,
            CRIMSON_SLIME_BLOCK,
            ICE_SLIME_BLOCK,
            ILLUMINANT_SLIME_BLOCK,
            JUNGLE_SLIME_BLOCK,
            PINKY_SLIME_BLOCK,
            PURPLE_SLIME_BLOCK,
            RAINBOW_SLIME_BLOCK,
            RED_SLIME_BLOCK,
            SAND_SLIME_BLOCK,
            YELLOW_SLIME_BLOCK
        )
        ColorProviderRegistry.BLOCK.register({ _, _, _, tintIndex ->
            val client = MinecraftClient.getInstance()
            val time = client.world?.time ?: 0
            Color.getHSBColor((time + client.tickDelta) / 200, when(tintIndex) { 0 -> 1.0f else -> 0.7f }, 1.0f).rgb
        }, RAINBOW_SLIME_BLOCK)
    }

}