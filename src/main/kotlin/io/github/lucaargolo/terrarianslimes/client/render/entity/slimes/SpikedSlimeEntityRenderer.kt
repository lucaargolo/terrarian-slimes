package io.github.lucaargolo.terrarianslimes.client.render.entity.slimes

import io.github.lucaargolo.terrarianslimes.TerrarianSlimes
import io.github.lucaargolo.terrarianslimes.client.render.entity.feature.SpikedSlimeOverlayFeatureRenderer
import io.github.lucaargolo.terrarianslimes.client.render.entity.model.SpikedSlimeEntityModel
import io.github.lucaargolo.terrarianslimes.common.entity.slimes.ModdedSlimeEntity
import io.github.lucaargolo.terrarianslimes.utils.ItemLayerReplacement
import io.github.lucaargolo.terrarianslimes.utils.ModIdentifier
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRenderDispatcher
import net.minecraft.client.render.entity.LivingEntityRenderer
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.model.json.ModelTransformation
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.client.util.math.Vector3f
import net.minecraft.screen.PlayerScreenHandler
import net.minecraft.util.Identifier
import net.minecraft.util.math.MathHelper
import net.minecraft.util.registry.Registry

class SpikedSlimeEntityRenderer(entityRenderDispatcher: EntityRenderDispatcher): MobEntityRenderer<ModdedSlimeEntity, SpikedSlimeEntityModel>(entityRenderDispatcher, SpikedSlimeEntityModel(), 0.25f) {

    init {
        this.addFeature(SpikedSlimeOverlayFeatureRenderer(this))
    }

    override fun getTexture(slimeEntity: ModdedSlimeEntity): Identifier {
        return ModIdentifier("textures/entity/${Registry.ENTITY_TYPE.getId(slimeEntity.type).path}.png")
    }

    override fun getRenderLayer(slimeEntity: ModdedSlimeEntity, showBody: Boolean, translucent: Boolean, showOutline: Boolean): RenderLayer? {
        return if(TerrarianSlimes.isCanvasLoaded) RenderLayer.getEntityTranslucentCull(getTexture(slimeEntity)) else RenderLayer.getEntityTranslucent(getTexture(slimeEntity))
    }

    override fun render(slimeEntity: ModdedSlimeEntity, yaw: Float, tickDelta: Float, matrixStack: MatrixStack, vertexConsumers: VertexConsumerProvider?, light: Int) {
        if(slimeEntity.hasBonusDrops() && !slimeEntity.getBonusDrops().isEmpty) {
            matrixStack.push()
            val offset = slimeEntity.boundingBox.center.subtract(slimeEntity.pos)
            matrixStack.translate(offset.x, offset.y - 0.25, offset.z)
            val angle = (slimeEntity.itemRotation + tickDelta) / 20f
            matrixStack.multiply(Vector3f.POSITIVE_Y.getRadialQuaternion(angle))
            ItemLayerReplacement.setupReplacementLayer(RenderLayer.getItemEntityTranslucentCull(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE))
            MinecraftClient.getInstance().itemRenderer.renderItem(slimeEntity.getBonusDrops(), ModelTransformation.Mode.GROUND, light, LivingEntityRenderer.getOverlay(slimeEntity, 0f), matrixStack, vertexConsumers)
            matrixStack.pop()
        }
        super.render(slimeEntity, yaw, tickDelta, matrixStack, vertexConsumers, light)
    }

    override fun scale(slimeEntity: ModdedSlimeEntity, matrixStack: MatrixStack, f: Float) {
        matrixStack.scale(0.999f, 0.999f, 0.999f)
        matrixStack.translate(0.0, 0.0010000000474974513, 0.0)
        val smoothStretch = MathHelper.lerp(f, slimeEntity.lastStretch, slimeEntity.stretch) / (slimeEntity.size * 0.5f + 1.0f)
        val correctedSmoothStretch = 1.0f / (smoothStretch + 1.0f)
        matrixStack.scale(correctedSmoothStretch * slimeEntity.size, 1.0f / correctedSmoothStretch * slimeEntity.size, correctedSmoothStretch * slimeEntity.size)
    }

}