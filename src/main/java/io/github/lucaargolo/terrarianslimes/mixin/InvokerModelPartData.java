package io.github.lucaargolo.terrarianslimes.mixin;

import net.minecraft.client.model.ModelCuboidData;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;
import java.util.Map;

@Mixin(ModelPartData.class)
public interface InvokerModelPartData {

    @Invoker("<init>")
    static ModelPartData create(List<ModelCuboidData> cuboidData, ModelTransform rotationData) {
        throw new AssertionError("");
    }

}
