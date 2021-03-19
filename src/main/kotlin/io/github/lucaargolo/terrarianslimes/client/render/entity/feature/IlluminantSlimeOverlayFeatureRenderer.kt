package io.github.lucaargolo.terrarianslimes.client.render.entity.feature

import io.github.lucaargolo.terrarianslimes.TerrarianSlimes
import io.github.lucaargolo.terrarianslimes.common.entity.slimes.IlluminantSlimeEntity
import io.github.lucaargolo.terrarianslimes.common.entity.slimes.ModdedSlimeEntity
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.LivingEntityRenderer
import net.minecraft.client.render.entity.feature.FeatureRenderer
import net.minecraft.client.render.entity.feature.FeatureRendererContext
import net.minecraft.client.render.entity.model.SlimeEntityModel
import net.minecraft.client.util.math.MatrixStack
import org.apache.commons.lang3.tuple.MutablePair

class IlluminantSlimeOverlayFeatureRenderer(context: FeatureRendererContext<ModdedSlimeEntity, SlimeEntityModel<ModdedSlimeEntity>>): FeatureRenderer<ModdedSlimeEntity, SlimeEntityModel<ModdedSlimeEntity>>(context) {

    private val model: SlimeEntityModel<ModdedSlimeEntity> = SlimeEntityModel(0)

    override fun render(matrices: MatrixStack, vertexConsumers: VertexConsumerProvider, light: Int, slimeEntity: ModdedSlimeEntity, limbAngle: Float, limbDistance: Float, tickDelta: Float, animationProgress: Float, headYaw: Float, headPitch: Float) {
        if (!slimeEntity.isInvisible) {
            this.contextModel?.copyStateTo(this.model)
            this.model.animateModel(slimeEntity, limbAngle, limbDistance, tickDelta)
            this.model.setAngles(slimeEntity, limbAngle, limbDistance, animationProgress, headYaw, headPitch)
            val overlayLayer = if(TerrarianSlimes.isCanvasLoaded) RenderLayer.getEntityTranslucent(getTexture(slimeEntity)) else RenderLayer.getItemEntityTranslucentCull(getTexture(slimeEntity))
            val vertexConsumer = vertexConsumers.getBuffer(overlayLayer)
            (slimeEntity as? IlluminantSlimeEntity)?.let {
                if(slimeEntity.velocity.length() != 0.0) {
                    slimeEntity.previousPositions.add(0, MutablePair(slimeEntity.pos, 50f))
                }
                val iterator = slimeEntity.previousPositions.iterator()
                while(iterator.hasNext()) {
                    val prevPos = iterator.next()
                    prevPos.setRight(prevPos.right-tickDelta)
                    if(prevPos.right > 0) {
                        matrices.push()
                        val offsetPos = slimeEntity.pos.subtract(prevPos.left)
                        matrices.translate(offsetPos.x, offsetPos.y, offsetPos.z)
                        this.model.render(matrices, vertexConsumer, light, LivingEntityRenderer.getOverlay(slimeEntity, 0.0f), 1.0f, 1.0f, 1.0f, prevPos.right/50f)
                        matrices.push()
                    }else{
                        iterator.remove()
                    }
                }
            }
            this.model.render(matrices, vertexConsumer, light, LivingEntityRenderer.getOverlay(slimeEntity, 0.0f), 1.0f, 1.0f, 1.0f, 1.0f)
        }
    }

}