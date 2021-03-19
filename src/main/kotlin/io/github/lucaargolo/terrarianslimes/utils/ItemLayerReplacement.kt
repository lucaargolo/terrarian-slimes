package io.github.lucaargolo.terrarianslimes.utils

import net.minecraft.client.render.RenderLayer

object ItemLayerReplacement {

    var isReplacingItemLayer = false
    var replacementLayer: RenderLayer = RenderLayer.getSolid()

    fun setupReplacementLayer(renderLayer: RenderLayer) {
        isReplacingItemLayer = true
        replacementLayer = renderLayer
    }

}