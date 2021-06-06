package io.github.lucaargolo.terrarianslimes.mixin;

import io.github.lucaargolo.terrarianslimes.TerrarianSlimes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.PistonBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = PistonBlockEntity.class, priority = 200)
public class PistonBlockEntityMixin {

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"), method = "pushEntities", require = 0, expect = 0)
    private static boolean redirectOnSlimeBlockCheck(BlockState blockState, Block block) {
        return blockState.isIn(TerrarianSlimes.Companion.getSlimeBlocksTag());
    }

}
