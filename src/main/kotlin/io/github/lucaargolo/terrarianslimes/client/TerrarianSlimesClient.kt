package io.github.lucaargolo.terrarianslimes.client

import io.github.lucaargolo.terrarianslimes.client.render.bakedmodel.BakedModelCompendium
import io.github.lucaargolo.terrarianslimes.client.render.blockentity.BlockEntityRendererCompendium
import io.github.lucaargolo.terrarianslimes.client.render.entity.EntityRendererCompendium
import io.github.lucaargolo.terrarianslimes.common.block.BlockCompendium
import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import io.github.lucaargolo.terrarianslimes.network.PacketCompendium
import net.fabricmc.api.ClientModInitializer

class TerrarianSlimesClient: ClientModInitializer {

    override fun onInitializeClient() {
        PacketCompendium.initializeClient()
        BlockCompendium.initializeClient()
        ItemCompendium.initializeClient()
        BlockEntityRendererCompendium.initialize()
        EntityRendererCompendium.initialize()
        BakedModelCompendium.initialize()
    }

}