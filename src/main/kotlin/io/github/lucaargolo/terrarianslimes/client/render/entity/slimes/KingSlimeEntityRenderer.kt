package io.github.lucaargolo.terrarianslimes.client.render.entity.slimes

import io.github.lucaargolo.terrarianslimes.common.entity.slimes.ModdedSlimeEntity
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRenderDispatcher
import net.minecraft.client.render.entity.feature.FeatureRenderer
import net.minecraft.client.render.entity.feature.FeatureRendererContext
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.util.math.MatrixStack

class KingSlimeEntityRenderer<T: ModdedSlimeEntity<*>, M: EntityModel<T>>(entityRenderDispatcher: EntityRenderDispatcher, model: M, overlayFeature: (FeatureRendererContext<T, M>) -> FeatureRenderer<T, M>): ModdedSlimeEntityRenderer<T, M>(entityRenderDispatcher, model, overlayFeature) {

    override fun render(slimeEntity: T, yaw: Float, tickDelta: Float, matrixStack: MatrixStack, vertexConsumers: VertexConsumerProvider?, light: Int) {
        super.render(slimeEntity, yaw, tickDelta, matrixStack, vertexConsumers, light)
    }

}