package io.github.lucaargolo.terrarianslimes.client

import io.github.lucaargolo.terrarianslimes.client.render.bakedmodel.BakedModelCompendium
import io.github.lucaargolo.terrarianslimes.client.render.entity.EntityRendererCompendium
import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import io.github.lucaargolo.terrarianslimes.network.PacketCompendium
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
import net.minecraft.client.MinecraftClient
import java.awt.Color

class TerrarianSlimesClient: ClientModInitializer {

    override fun onInitializeClient() {
        PacketCompendium.onInitializeClient()
        EntityRendererCompendium.initialize()
        BakedModelCompendium.initialize()

        ColorProviderRegistry.ITEM.register({ _, tintIndex ->
            val client = MinecraftClient.getInstance()
            val time = client.world?.time ?: 0
            Color.getHSBColor((time + client.tickDelta) / 200, when(tintIndex) { 0 -> 1.0f else -> 0.7f }, 1.0f).rgb
        }, ItemCompendium.RAINBOW_SLIME_EGG)

    }

}