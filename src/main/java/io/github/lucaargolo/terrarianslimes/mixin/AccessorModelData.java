package io.github.lucaargolo.terrarianslimes.mixin;

import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPartData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ModelData.class)
public interface AccessorModelData {

    @Accessor
    void setData(ModelPartData data);

}
