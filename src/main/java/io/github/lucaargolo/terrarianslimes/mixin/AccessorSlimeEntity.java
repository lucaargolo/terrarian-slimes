package io.github.lucaargolo.terrarianslimes.mixin;

import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.mob.SlimeEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SlimeEntity.class)
public interface AccessorSlimeEntity {

    @Accessor("SLIME_SIZE") @Final
    static TrackedData<Integer> getSlimeSize() {
        return null;
    }


}
