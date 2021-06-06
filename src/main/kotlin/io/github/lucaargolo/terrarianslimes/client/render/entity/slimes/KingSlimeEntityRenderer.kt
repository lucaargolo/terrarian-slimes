package io.github.lucaargolo.terrarianslimes.client.render.entity.slimes

import io.github.lucaargolo.terrarianslimes.common.entity.slimes.KingSlimeEntity
import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import net.minecraft.client.MinecraftClient
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
import net.minecraft.util.math.MathHelper
import net.minecraft.util.math.Vec3f

class KingSlimeEntityRenderer<T: KingSlimeEntity<*>, M: EntityModel<T>>(context: EntityRendererFactory.Context, model: M, overlayFeature: (FeatureRendererContext<T, M>, EntityModelLoader) -> FeatureRenderer<T, M>): ModdedSlimeEntityRenderer<T, M>(context, model, overlayFeature) {

    override fun render(slimeEntity: T, yaw: Float, tickDelta: Float, matrixStack: MatrixStack, vertexConsumers: VertexConsumerProvider?, light: Int) {
        matrixStack.push()
        val offset = slimeEntity.boundingBox.center.subtract(slimeEntity.pos)
        matrixStack.translate(offset.x, offset.y - 0.25, offset.z)
        val bodyYaw = MathHelper.lerpAngleDegrees(tickDelta, slimeEntity.prevBodyYaw, slimeEntity.bodyYaw)
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180.0f - bodyYaw))
        val t = MathHelper.abs((slimeEntity.teleportingProgress - 50)/50f) * (1f - slimeEntity.spawnProgress/200f)
        matrixStack.scale(4f * t, 4f * t, 4f * t)
        matrixStack.translate(0.0, 0.5375 * t, 0.0)
        MinecraftClient.getInstance().itemRenderer.renderItem(ItemStack(ItemCompendium.GOLD_CROWN), ModelTransformation.Mode.GROUND, light, LivingEntityRenderer.getOverlay(slimeEntity, 0f), matrixStack, vertexConsumers, 0)
        matrixStack.pop()
        super.render(slimeEntity, yaw, tickDelta, matrixStack, vertexConsumers, light)
    }

    override fun scale(slimeEntity: T, matrixStack: MatrixStack, f: Float) {
        matrixStack.scale(0.999f, 0.999f, 0.999f)
        matrixStack.translate(0.0, 0.0010000000474974513, 0.0)
        val size = slimeEntity.size * MathHelper.abs((slimeEntity.teleportingProgress - 50)/50f) * (1f - slimeEntity.spawnProgress/200f)
        val smoothStretch = MathHelper.lerp(f, slimeEntity.lastStretch, slimeEntity.stretch) / (size * 0.5f + 1.0f)
        val correctedSmoothStretch = 1.0f / (smoothStretch + 1.0f)
        matrixStack.scale(correctedSmoothStretch * size, 1.0f / correctedSmoothStretch * size, correctedSmoothStretch * size)
    }

}