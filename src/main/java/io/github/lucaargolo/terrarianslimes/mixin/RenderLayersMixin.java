package io.github.lucaargolo.terrarianslimes.mixin;

import io.github.lucaargolo.terrarianslimes.utils.ItemLayerReplacement;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderLayers.class)
public class RenderLayersMixin {

    @Inject(at = @At("HEAD"), method = "getItemLayer", cancellable = true)
    private static void getItemLayer(ItemStack stack, boolean direct, CallbackInfoReturnable<RenderLayer> info) {
        ItemLayerReplacement layerReplacement = ItemLayerReplacement.INSTANCE;
        if(layerReplacement.isReplacingItemLayer()) {
            layerReplacement.setReplacingItemLayer(false);
            info.setReturnValue(layerReplacement.getReplacementLayer());
        }
    }

}