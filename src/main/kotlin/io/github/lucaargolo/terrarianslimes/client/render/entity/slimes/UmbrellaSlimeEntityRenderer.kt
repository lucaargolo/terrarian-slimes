package io.github.lucaargolo.terrarianslimes.client.render.entity.slimes

import io.github.lucaargolo.terrarianslimes.common.entity.slimes.ModdedSlimeEntity
import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import io.github.lucaargolo.terrarianslimes.utils.ItemLayerReplacement
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.LivingEntityRenderer
import net.minecraft.client.render.entity.feature.FeatureRenderer
import net.minecraft.client.render.entity.feature.FeatureRendererContext
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.render.entity.model.EntityModelLoader
import net.minecraft.client.render.model.json.ModelTransformation
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.item.ItemStack
import net.minecraft.screen.PlayerScreenHandler
import net.minecraft.util.math.MathHelper
import net.minecraft.util.math.Vec3f

class UmbrellaSlimeEntityRenderer<T: ModdedSlimeEntity<*>, M: EntityModel<T>>(context: EntityRendererFactory.Context, model: M, overlayFeature: (FeatureRendererContext<T, M>, EntityModelLoader) -> FeatureRenderer<T, M>): ModdedSlimeEntityRenderer<T, M>(context, model, overlayFeature) {

    override fun render(slimeEntity: T, yaw: Float, tickDelta: Float, matrixStack: MatrixStack, vertexConsumers: VertexConsumerProvider?, light: Int) {
        matrixStack.push()
        val offset = slimeEntity.boundingBox.center.subtract(slimeEntity.pos)
        matrixStack.translate(offset.x, offset.y - 0.25, offset.z)
        val bodyYaw = MathHelper.lerpAngleDegrees(tickDelta, slimeEntity.prevBodyYaw, slimeEntity.bodyYaw)
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180.0f - bodyYaw))
        matrixStack.scale(4f, 4f, 4f)
        ItemLayerReplacement.setupReplacementLayer(RenderLayer.getItemEntityTranslucentCull(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE))
        MinecraftClient.getInstance().itemRenderer.renderItem(ItemStack(ItemCompendium.UMBRELLA), ModelTransformation.Mode.GROUND, light, LivingEntityRenderer.getOverlay(slimeEntity, 0f), matrixStack, vertexConsumers, 0)
        matrixStack.pop()
        super.render(slimeEntity, yaw, tickDelta, matrixStack, vertexConsumers, light)
    }

}