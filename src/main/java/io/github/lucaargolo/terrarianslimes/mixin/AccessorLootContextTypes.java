package io.github.lucaargolo.terrarianslimes.mixin;

import com.google.common.collect.BiMap;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LootContextTypes.class)
public interface AccessorLootContextTypes {

    @Accessor("MAP")
    static BiMap<Identifier, LootContextType> getMap() {
        return null;
    }

}
