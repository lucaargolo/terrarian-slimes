package io.github.lucaargolo.terrarianslimes.client.render.item

import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import io.github.lucaargolo.terrarianslimes.mixin.ItemRendererInvoker
import io.github.lucaargolo.terrarianslimes.utils.ModIdentifier
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.model.EntityModelLayers
import net.minecraft.client.render.entity.model.SlimeEntityModel
import net.minecraft.client.render.item.ItemRenderer
import net.minecraft.client.render.model.BakedModel
import net.minecraft.client.render.model.json.ModelTransformation
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.mob.SlimeEntity
import net.minecraft.item.ItemStack
import net.minecraft.screen.PlayerScreenHandler
import net.minecraft.util.math.Vec3f

class SlimeCrownBuiltinItemRenderer: BuiltinItemRendererRegistry.DynamicItemRenderer {

    private val itemRenderer: ItemRenderer by lazy {
        MinecraftClient.getInstance().itemRenderer
    }

    private val texture = ModIdentifier("textures/entity/king_slime.png")

    private val overlayModel: SlimeEntityModel<SlimeEntity> by lazy {
        SlimeEntityModel(MinecraftClient.getInstance().entityModelLoader.getModelPart(EntityModelLayers.SLIME_OUTER))
    }
    private val slimeModel: SlimeEntityModel<SlimeEntity> by lazy {
        SlimeEntityModel(MinecraftClient.getInstance().entityModelLoader.getModelPart(EntityModelLayers.SLIME))
    }
    private val crownModel: BakedModel by lazy {
        itemRenderer.getModel(ItemStack(ItemCompendium.GOLD_CROWN), null, null, 0)
    }

    override fun render(stack: ItemStack, mode: ModelTransformation.Mode, matrices: MatrixStack, vertexConsumers: VertexConsumerProvider, light: Int, overlay: Int) {
        val slimeLayer = when(mode) {
            ModelTransformation.Mode.FIRST_PERSON_LEFT_HAND -> RenderLayer.getEntityCutout(texture)
            ModelTransformation.Mode.FIRST_PERSON_RIGHT_HAND -> RenderLayer.getEntityCutout(texture)
            else -> RenderLayer.getEntityTranslucent(texture)
        }
        matrices.push()
        matrices.translate(0.5, 1.25, 0.5)
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180f))
        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(180f))
        slimeModel.render(matrices, vertexConsumers.getBuffer(slimeLayer), light, overlay, 1.0f, 1.0f, 1.0f, 1.0f)
        val overlayLayer = when(mode) {
            ModelTransformation.Mode.GUI -> RenderLayer.getEntityTranslucentCull(texture)
            ModelTransformation.Mode.FIRST_PERSON_LEFT_HAND -> RenderLayer.getEntityTranslucent(texture)
            ModelTransformation.Mode.FIRST_PERSON_RIGHT_HAND -> RenderLayer.getEntityTranslucent(texture)
            else -> RenderLayer.getItemEntityTranslucentCull(texture)
        }
        overlayModel.render(matrices, vertexConsumers.getBuffer(overlayLayer), light, overlay, 1.0f, 1.0f, 1.0f, 1.0f)
        matrices.pop()
        matrices.push()
        matrices.translate(0.0, 0.25, 0.0)
        (itemRenderer as? ItemRendererInvoker)?.invokeRenderBakedItemModel(crownModel, ItemStack(ItemCompendium.GOLD_CROWN), light, overlay, matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE)))
        matrices.translate(0.0, 0.25, 0.0)
        matrices.pop()
    }

}


