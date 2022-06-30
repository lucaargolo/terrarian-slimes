package io.github.lucaargolo.terrarianslimes.client.render.blockentity

import io.github.lucaargolo.terrarianslimes.common.block.BlockCompendium
import io.github.lucaargolo.terrarianslimes.common.blockentity.RainbowSlimeBlockEntity
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.OverlayTexture
import net.minecraft.client.render.RenderLayers
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.block.entity.BlockEntityRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.math.random.Random

class RainbowSlimeBlockEntityRenderer: BlockEntityRenderer<RainbowSlimeBlockEntity> {

    override fun render(entity: RainbowSlimeBlockEntity, tickDelta: Float, matrices: MatrixStack, vertexConsumers: VertexConsumerProvider, light: Int, overlay: Int) {
        val client = MinecraftClient.getInstance()
        val state = BlockCompendium.RAINBOW_SLIME_BLOCK.defaultState
        client.blockRenderManager.modelRenderer.render(
            entity.world,
            client.blockRenderManager.getModel(state),
            state,
            entity.pos,
            matrices,
            vertexConsumers.getBuffer(RenderLayers.getMovingBlockLayer(state)),
            true,
            entity.world?.random ?: Random.create(),
            state.getRenderingSeed(entity.pos),
            OverlayTexture.DEFAULT_UV)

    }

}