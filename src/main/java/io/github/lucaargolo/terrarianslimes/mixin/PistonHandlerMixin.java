package io.github.lucaargolo.terrarianslimes.mixin;

import io.github.lucaargolo.terrarianslimes.TerrarianSlimes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PistonHandler.class)
public class PistonHandlerMixin {

    @Inject(at = @At("HEAD"), method = "isBlockSticky", cancellable = true)
    private static void isBlockSticky(BlockState state, CallbackInfoReturnable<Boolean> info) {
        if(state.isIn(TerrarianSlimes.Companion.getSlimeBlocksTag())) {
            info.setReturnValue(true);
        }
    }

    @Inject(at = @At("HEAD"), method = "isAdjacentBlockStuck", cancellable = true)
    private static void isAdjacentBlockStuck(BlockState state, BlockState adjacentState, CallbackInfoReturnable<Boolean> info) {
        boolean isFirstBlockSlimy = state.isIn(TerrarianSlimes.Companion.getSlimeBlocksTag());
        boolean isSecondBlockSlimy = adjacentState.isIn(TerrarianSlimes.Companion.getSlimeBlocksTag());
        if(isFirstBlockSlimy || isSecondBlockSlimy) {
            boolean isFirstBlockVanilla = state.isOf(Blocks.HONEY_BLOCK) || state.isOf(Blocks.SLIME_BLOCK);
            boolean isSecondBlockVanilla = adjacentState.isOf(Blocks.HONEY_BLOCK) || adjacentState.isOf(Blocks.SLIME_BLOCK);
            if((isFirstBlockSlimy || isFirstBlockVanilla) && (isSecondBlockSlimy || isSecondBlockVanilla)) {
                info.setReturnValue(state.getBlock() == adjacentState.getBlock());
            }
        }
    }

}
