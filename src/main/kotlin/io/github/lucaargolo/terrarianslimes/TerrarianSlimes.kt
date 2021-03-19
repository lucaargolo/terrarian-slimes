package io.github.lucaargolo.terrarianslimes

import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import io.github.lucaargolo.terrarianslimes.network.PacketCompendium
import io.github.lucaargolo.terrarianslimes.utils.ModIdentifier
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.block.Blocks
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.entity.mob.SlimeEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack

class TerrarianSlimes: ModInitializer {

    override fun onInitialize() {
        PacketCompendium.onInitialize()
        ItemCompendium.initialize()
        EntityCompendium.initialize()

        FabricDefaultAttributeRegistry.register(EntityCompendium.GREEN_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(EntityCompendium.BLUE_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(EntityCompendium.RED_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(EntityCompendium.PURPLE_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(EntityCompendium.YELLOW_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(EntityCompendium.BLACK_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(EntityCompendium.JUNGLE_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(EntityCompendium.MOTHER_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(EntityCompendium.BABY_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(EntityCompendium.PINKY, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(EntityCompendium.LAVA_SLIME, HostileEntity.createHostileAttributes())

    }

    companion object {
        const val MOD_ID = "terrarianslimes"

        private val creativeTab = FabricItemGroupBuilder.create(ModIdentifier("creative_tab")).icon{ ItemStack(Blocks.SLIME_BLOCK) }.build()
        fun creativeGroupSettings(): Item.Settings = Item.Settings().group(creativeTab)
    }

}