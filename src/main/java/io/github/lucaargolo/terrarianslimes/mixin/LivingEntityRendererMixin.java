package io.github.lucaargolo.terrarianslimes.mixin;

import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin<T extends LivingEntity, M extends EntityModel<T>> {

    @Shadow protected M model;

    @Shadow @Nullable protected abstract RenderLayer getRenderLayer(T entity, boolean showBody, boolean translucent, boolean showOutline);

    @Shadow protected abstract float getAnimationCounter(T entity, float tickDelta);

    private VertexConsumerProvider terrarianslimes_TempVertexConsumerProvider = null;
    private MatrixStack terrarianslimes_TempMatrixStack = null;
    private int terrarianslimes_TempLight = 0;
    private float terrarianslimes_TempTickDelta = 0f;

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;getInstance()Lnet/minecraft/client/MinecraftClient;"), method = "render", cancellable = true)
    public void render(T livingEntity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, CallbackInfo ci) {
        terrarianslimes_TempVertexConsumerProvider = vertexConsumerProvider;
        terrarianslimes_TempMatrixStack = matrixStack;
        terrarianslimes_TempLight = light;
        terrarianslimes_TempTickDelta = tickDelta;
    }

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/LivingEntityRenderer;getRenderLayer(Lnet/minecraft/entity/LivingEntity;ZZZ)Lnet/minecraft/client/render/RenderLayer;"), method = "render")
    public RenderLayer interceptAtRenderLayer(LivingEntityRenderer<T, M> livingEntityRenderer, T livingEntity, boolean showBody, boolean translucent, boolean showOutline) {
        VertexConsumerProvider vertexConsumerProvider = terrarianslimes_TempVertexConsumerProvider;
        MatrixStack matrixStack = terrarianslimes_TempMatrixStack;
        int light = terrarianslimes_TempLight;
        float tickDelta = terrarianslimes_TempTickDelta;
        RenderLayer renderLayer = this.getRenderLayer(livingEntity, showBody, translucent, showOutline);
        if(livingEntity.getType() == EntityCompendium.INSTANCE.getRAINBOW_SLIME()) {
            Color color = Color.getHSBColor((livingEntity.world.getTime() + tickDelta) / 200.0f, 1.0f, 1.0f);
            if(renderLayer != null) {
                VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(renderLayer);
                int overlay = LivingEntityRenderer.getOverlay(livingEntity, this.getAnimationCounter(livingEntity, tickDelta));
                this.model.render(matrixStack, vertexConsumer, light, overlay, color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f, 1.0f);
            }
            return null;
        }
        return renderLayer;
    }

}
