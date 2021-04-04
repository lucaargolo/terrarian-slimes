package io.github.lucaargolo.terrarianslimes.mixin;

import io.github.lucaargolo.terrarianslimes.utils.ExplosionBlockStateReplacement;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Explosion.class, priority = 200)
public class ExplosionMixin {

    @Shadow @Final private World world;

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getDefaultState()Lnet/minecraft/block/BlockState;"), method = "affectWorld", require = 0, expect = 0)
    public BlockState getExplosionBlockState(Block block) {
        if(world.isClient) {
            if (ExplosionBlockStateReplacement.Client.INSTANCE.isReplacingBlockState()) {
                return ExplosionBlockStateReplacement.Client.INSTANCE.getReplacementBlockState();
            }
        }else{
            if (ExplosionBlockStateReplacement.Server.INSTANCE.isReplacingBlockState()) {
                return ExplosionBlockStateReplacement.Server.INSTANCE.getReplacementBlockState();
            }
        }
        return block.getDefaultState();
    }

    @Inject(at = @At("TAIL"), method = "affectWorld")
    public void onExplosionEnded(boolean bl, CallbackInfo info) {
        if(world.isClient) {
            ExplosionBlockStateReplacement.Client.INSTANCE.setReplacingBlockState(false);
        }else{
            ExplosionBlockStateReplacement.Server.INSTANCE.setReplacingBlockState(false);
        }
    }

}
