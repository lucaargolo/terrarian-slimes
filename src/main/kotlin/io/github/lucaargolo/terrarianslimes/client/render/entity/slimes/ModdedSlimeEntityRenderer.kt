package io.github.lucaargolo.terrarianslimes.client.render.entity.slimes

import io.github.lucaargolo.terrarianslimes.TerrarianSlimes
import io.github.lucaargolo.terrarianslimes.common.entity.slimes.ModdedSlimeEntity
import io.github.lucaargolo.terrarianslimes.utils.ItemLayerReplacement
import io.github.lucaargolo.terrarianslimes.utils.ModIdentifier
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.LivingEntityRenderer
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.entity.feature.FeatureRenderer
import net.minecraft.client.render.entity.feature.FeatureRendererContext
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.render.entity.model.EntityModelLoader
import net.minecraft.client.render.model.json.ModelTransformation
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.screen.PlayerScreenHandler
import net.minecraft.util.Identifier
import net.minecraft.util.math.MathHelper
import net.minecraft.util.math.Vec3f
import net.minecraft.util.registry.Registry

open class ModdedSlimeEntityRenderer<T: ModdedSlimeEntity<*>, M: EntityModel<T>>(context: EntityRendererFactory.Context, model: M, overlayFeature: (FeatureRendererContext<T, M>, EntityModelLoader) -> FeatureRenderer<T, M>, private val isEmissive: Boolean = false): MobEntityRenderer<T, M>(context, model, 0.25f) {

    init {
        @Suppress("LeakingThis")
        this.addFeature(overlayFeature.invoke(this, context.modelLoader))
    }

    override fun getTexture(slimeEntity: T): Identifier {
        return ModIdentifier("textures/entity/${Registry.ENTITY_TYPE.getId(slimeEntity.type).path}.png")
    }

    override fun getRenderLayer(slimeEntity: T, showBody: Boolean, translucent: Boolean, showOutline: Boolean): RenderLayer? {
        return if(TerrarianSlimes.CANVAS) RenderLayer.getEntityTranslucentCull(getTexture(slimeEntity)) else RenderLayer.getEntityTranslucent(getTexture(slimeEntity))
    }

    override fun render(slimeEntity: T, yaw: Float, tickDelta: Float, matrixStack: MatrixStack, vertexConsumers: VertexConsumerProvider?, light: Int) {
        if(slimeEntity.hasBonusDrops && !slimeEntity.getBonusDrops().isEmpty) {
            matrixStack.push()
            val offset = slimeEntity.boundingBox.center.subtract(slimeEntity.pos)
            matrixStack.translate(offset.x, offset.y - 0.25, offset.z)
            val angle = (slimeEntity.world.time + tickDelta) / 20f
            matrixStack.multiply(Vec3f.POSITIVE_Y.getRadialQuaternion(angle))
            ItemLayerReplacement.setupReplacementLayer(RenderLayer.getItemEntityTranslucentCull(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE))
            MinecraftClient.getInstance().itemRenderer.renderItem(slimeEntity.getBonusDrops(), ModelTransformation.Mode.GROUND, light, LivingEntityRenderer.getOverlay(slimeEntity, 0f), matrixStack, vertexConsumers, 0)
            matrixStack.pop()
        }
        super.render(slimeEntity, yaw, tickDelta, matrixStack, vertexConsumers, if(isEmissive) 15728880 else light)
    }

    override fun scale(slimeEntity: T, matrixStack: MatrixStack, f: Float) {
        matrixStack.scale(0.999f, 0.999f, 0.999f)
        matrixStack.translate(0.0, 0.0010000000474974513, 0.0)
        val smoothStretch = MathHelper.lerp(f, slimeEntity.lastStretch, slimeEntity.stretch) / (slimeEntity.size * 0.5f + 1.0f)
        val correctedSmoothStretch = 1.0f / (smoothStretch + 1.0f)
        matrixStack.scale(correctedSmoothStretch * slimeEntity.size, 1.0f / correctedSmoothStretch * slimeEntity.size, correctedSmoothStretch * slimeEntity.size)
    }

}