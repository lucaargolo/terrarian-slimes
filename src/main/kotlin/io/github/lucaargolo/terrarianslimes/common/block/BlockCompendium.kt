package io.github.lucaargolo.terrarianslimes.common.block

import io.github.lucaargolo.terrarianslimes.TerrarianSlimes.Companion.creativeGroupSettings
import io.github.lucaargolo.terrarianslimes.utils.RegistryCompendium
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object BlockCompendium: RegistryCompendium<Block>(Registry.BLOCK) {


    fun registerBlockItems(itemMap: MutableMap<Identifier, Item>) {
        map.forEach { (identifier, block) ->
            itemMap[identifier] = BlockItem(block, creativeGroupSettings())
        }
    }

}