package io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.feature

import io.github.lucaargolo.terrarianslimes.TerrarianSlimes
import io.github.lucaargolo.terrarianslimes.common.entity.slimes.IlluminantSlimeEntity
import io.github.lucaargolo.terrarianslimes.common.entity.slimes.ModdedSlimeEntity
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.LivingEntityRenderer
import net.minecraft.client.render.entity.feature.FeatureRenderer
import net.minecraft.client.render.entity.feature.FeatureRendererContext
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.render.entity.model.SlimeEntityModel
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.client.util.math.Vector3f
import net.minecraft.util.math.MathHelper

class IlluminantSlimeOverlayFeatureRenderer<T: ModdedSlimeEntity, M: EntityModel<T>>(context: FeatureRendererContext<T, M>): FeatureRenderer<T, M>(context) {

    private val model: SlimeEntityModel<ModdedSlimeEntity> = SlimeEntityModel(0)

    override fun render(matrices: MatrixStack, vertexConsumers: VertexConsumerProvider, light: Int, slimeEntity: T, limbAngle: Float, limbDistance: Float, tickDelta: Float, animationProgress: Float, headYaw: Float, headPitch: Float) {
        if (!slimeEntity.isInvisible) {
            val overlayLayer = if(TerrarianSlimes.isCanvasLoaded) RenderLayer.getEntityTranslucent(getTexture(slimeEntity)) else RenderLayer.getItemEntityTranslucentCull(getTexture(slimeEntity))
            val vertexConsumer = vertexConsumers.getBuffer(overlayLayer)
            (slimeEntity as? IlluminantSlimeEntity)?.let {
                slimeEntity.previousPositions.forEach { prevPos ->
                    if(slimeEntity.pos.distanceTo(prevPos.left) > 0.2) {
                        matrices.push()
                        matrices.translate(0.0, 1.5010000467300415, 0.0)
                        descale(slimeEntity, matrices, tickDelta)
                        matrices.scale(-1.0F, -1.0F, 1.0F)
                        val bodyYaw = MathHelper.lerpAngleDegrees(tickDelta, slimeEntity.prevBodyYaw, slimeEntity.bodyYaw)
                        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-1.0f * (180.0f - bodyYaw)))
                        val cameraPos = MinecraftClient.getInstance().gameRenderer.camera.pos
                        val d = MathHelper.lerp(tickDelta.toDouble(), slimeEntity.lastRenderX, slimeEntity.x) - cameraPos.x
                        val e = MathHelper.lerp(tickDelta.toDouble(), slimeEntity.lastRenderY, slimeEntity.y) - cameraPos.y
                        val f = MathHelper.lerp(tickDelta.toDouble(), slimeEntity.lastRenderZ, slimeEntity.z) - cameraPos.z
                        matrices.translate(-d, -e, -f)
                        matrices.translate(prevPos.left.x - cameraPos.x, prevPos.left.y - cameraPos.y, prevPos.left.z - cameraPos.z)
                        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(180.0f - bodyYaw))
                        matrices.scale(-1.0F, -1.0F, 1.0F)
                        scale(slimeEntity, matrices, tickDelta)
                        matrices.translate(0.0, -1.5010000467300415, 0.0)
                        matrices.scale(0.95f, 0.95f, 0.95f)
                        this.model.render(matrices, vertexConsumer, light, LivingEntityRenderer.getOverlay(slimeEntity, 0.0f), 1.0f, 1.0f, 1.0f, prevPos.right/20f)
                        matrices.pop()
                    }
                }
            }
            this.model.render(matrices, vertexConsumer, light, LivingEntityRenderer.getOverlay(slimeEntity, 0.0f), 1.0f, 1.0f, 1.0f, 1.0f)
        }
    }

    private fun scale(slimeEntity: ModdedSlimeEntity, matrixStack: MatrixStack, f: Float) {
        matrixStack.scale(0.999f, 0.999f, 0.999f)
        matrixStack.translate(0.0, 0.0010000000474974513, 0.0)
        val smoothStretch = MathHelper.lerp(f, slimeEntity.lastStretch, slimeEntity.stretch) / (slimeEntity.size * 0.5f + 1.0f)
        val correctedSmoothStretch = 1.0f / (smoothStretch + 1.0f)
        matrixStack.scale(correctedSmoothStretch * slimeEntity.size, 1.0f / correctedSmoothStretch * slimeEntity.size, correctedSmoothStretch * slimeEntity.size)
    }

    private fun descale(slimeEntity: ModdedSlimeEntity, matrixStack: MatrixStack, f: Float) {
        val smoothStretch = MathHelper.lerp(f, slimeEntity.lastStretch, slimeEntity.stretch) / (slimeEntity.size * 0.5f + 1.0f)
        val correctedSmoothStretch = 1.0f / (smoothStretch + 1.0f)
        matrixStack.scale(1.0f/(correctedSmoothStretch * slimeEntity.size), 1.0f/(1.0f / correctedSmoothStretch * slimeEntity.size), 1.0f/(correctedSmoothStretch * slimeEntity.size))
        matrixStack.translate(0.0, -0.0010000000474974513, 0.0)
        matrixStack.scale(1.0f/(0.999f), 1.0f/(0.999f), 1.0f/(0.999f))
    }

}