package io.github.lucaargolo.terrarianslimes.mixin;

import io.github.lucaargolo.terrarianslimes.common.block.RainbowSlimeBlock;
import net.minecraft.block.Block;
import net.minecraft.block.PistonBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = PistonBlock.class, priority = 200)
public class PistonBlockMixin {

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;hasBlockEntity()Z"), method = "isMovable", require = 0, expect = 0)
    private static boolean redirectIsMovableBlockEntityCheck(Block block) {
        if(block instanceof RainbowSlimeBlock) {
            return false;
        }
        return block.hasBlockEntity();
    }

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;hasBlockEntity()Z"), method = "move", require = 0, expect = 0)
    private boolean redirectOnMoveBlockEntityCheck(Block block) {
        if(block instanceof RainbowSlimeBlock) {
            return false;
        }
        return block.hasBlockEntity();
    }

}
