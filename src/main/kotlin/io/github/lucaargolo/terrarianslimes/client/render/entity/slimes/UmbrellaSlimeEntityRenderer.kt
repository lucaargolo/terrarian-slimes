package io.github.lucaargolo.terrarianslimes.client.render.entity.slimes

import io.github.lucaargolo.terrarianslimes.common.entity.slimes.ModdedSlimeEntity
import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import io.github.lucaargolo.terrarianslimes.utils.ItemLayerReplacement
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.*
import net.minecraft.client.render.entity.EntityRenderDispatcher
import net.minecraft.client.render.entity.LivingEntityRenderer
import net.minecraft.client.render.model.json.ModelTransformation
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.client.util.math.Vector3f
import net.minecraft.item.ItemStack
import net.minecraft.screen.PlayerScreenHandler

class UmbrellaSlimeEntityRenderer(entityRenderDispatcher: EntityRenderDispatcher): ModdedSlimeEntityRenderer(entityRenderDispatcher) {

    override fun render(slimeEntity: ModdedSlimeEntity, yaw: Float, tickDelta: Float, matrixStack: MatrixStack, vertexConsumers: VertexConsumerProvider?, light: Int) {
        matrixStack.push()
        val offset = slimeEntity.boundingBox.center.subtract(slimeEntity.pos)
        matrixStack.translate(offset.x, offset.y - 0.25, offset.z)
        matrixStack.scale(4f, 4f, 4f)
        ItemLayerReplacement.setupReplacementLayer(RenderLayer.getItemEntityTranslucentCull(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE))
        MinecraftClient.getInstance().itemRenderer.renderItem(ItemStack(ItemCompendium.UMBRELLA), ModelTransformation.Mode.GROUND, light, LivingEntityRenderer.getOverlay(slimeEntity, 0f), matrixStack, vertexConsumers)
        matrixStack.pop()
        super.render(slimeEntity, yaw, tickDelta, matrixStack, vertexConsumers, light)
    }

}