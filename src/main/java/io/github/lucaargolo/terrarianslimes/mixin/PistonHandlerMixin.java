package io.github.lucaargolo.terrarianslimes.mixin;

import io.github.lucaargolo.terrarianslimes.TerrarianSlimes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PistonHandler.class)
public class PistonHandlerMixin {

    @Inject(at = @At("HEAD"), method = "isBlockSticky", cancellable = true)
    private static void isBlockSticky(Block block, CallbackInfoReturnable<Boolean> info) {
        if(block.isIn(TerrarianSlimes.Companion.getSlimeBlocksTag())) {
            info.setReturnValue(true);
        }
    }

    @Inject(at = @At("HEAD"), method = "isAdjacentBlockStuck", cancellable = true)
    private static void isAdjacentBlockStuck(Block block1, Block block2, CallbackInfoReturnable<Boolean> info) {
        boolean isFirstBlockSlimy = block1.isIn(TerrarianSlimes.Companion.getSlimeBlocksTag());
        boolean isSecondBlockSlimy = block2.isIn(TerrarianSlimes.Companion.getSlimeBlocksTag());
        if(isFirstBlockSlimy || isSecondBlockSlimy) {
            boolean isFirstBlockVanilla = block1 == Blocks.HONEY_BLOCK || block1 == Blocks.SLIME_BLOCK;
            boolean isSecondBlockVanilla = block2 == Blocks.HONEY_BLOCK || block2 == Blocks.SLIME_BLOCK;
            if((isFirstBlockSlimy || isFirstBlockVanilla) && (isSecondBlockSlimy || isSecondBlockVanilla)) {
                info.setReturnValue(block1 == block2);
            }
        }
    }

}
