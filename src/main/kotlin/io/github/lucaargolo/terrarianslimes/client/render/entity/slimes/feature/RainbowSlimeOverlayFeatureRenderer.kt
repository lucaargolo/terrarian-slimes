package io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.feature

import io.github.lucaargolo.terrarianslimes.TerrarianSlimes
import io.github.lucaargolo.terrarianslimes.common.entity.slimes.ModdedSlimeEntity
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.LivingEntityRenderer
import net.minecraft.client.render.entity.feature.FeatureRenderer
import net.minecraft.client.render.entity.feature.FeatureRendererContext
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.render.entity.model.EntityModelLayers
import net.minecraft.client.render.entity.model.EntityModelLoader
import net.minecraft.client.render.entity.model.SlimeEntityModel
import net.minecraft.client.util.math.MatrixStack
import java.awt.Color

class RainbowSlimeOverlayFeatureRenderer<T: ModdedSlimeEntity<*>, M: EntityModel<T>>(context: FeatureRendererContext<T, M>, loader: EntityModelLoader): FeatureRenderer<T, M>(context) {

    private val model: SlimeEntityModel<ModdedSlimeEntity<*>> = SlimeEntityModel(loader.getModelPart(EntityModelLayers.SLIME_OUTER))

    override fun render(matrices: MatrixStack, vertexConsumers: VertexConsumerProvider, light: Int, slimeEntity: T, limbAngle: Float, limbDistance: Float, tickDelta: Float, animationProgress: Float, headYaw: Float, headPitch: Float) {
        if (!slimeEntity.isInvisible) {
            val overlayLayer = if(TerrarianSlimes.CANVAS) RenderLayer.getEntityTranslucent(getTexture(slimeEntity)) else RenderLayer.getItemEntityTranslucentCull(getTexture(slimeEntity))
            val vertexConsumer = vertexConsumers.getBuffer(overlayLayer)
            val color = Color.getHSBColor((slimeEntity.world.time + tickDelta) / 200, 1.0f, 1.0f)
            this.model.render(matrices, vertexConsumer, light, LivingEntityRenderer.getOverlay(slimeEntity, 0.0f), color.red/255f, color.green/255f, color.blue/255f, 1.0f)
        }
    }

}
