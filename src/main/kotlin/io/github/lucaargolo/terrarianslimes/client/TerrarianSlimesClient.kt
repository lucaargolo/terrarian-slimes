package io.github.lucaargolo.terrarianslimes.client

import io.github.lucaargolo.terrarianslimes.client.render.bakedmodel.BakedModelCompendium
import io.github.lucaargolo.terrarianslimes.client.render.entity.EntityRendererCompendium
import io.github.lucaargolo.terrarianslimes.network.PacketCompendium
import net.fabricmc.api.ClientModInitializer

class TerrarianSlimesClient: ClientModInitializer {

    override fun onInitializeClient() {
        PacketCompendium.onInitializeClient()
        EntityRendererCompendium.initialize()
        BakedModelCompendium.initialize()
    }

}