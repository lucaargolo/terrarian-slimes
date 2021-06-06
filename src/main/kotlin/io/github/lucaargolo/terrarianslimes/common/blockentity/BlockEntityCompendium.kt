package io.github.lucaargolo.terrarianslimes.common.blockentity

import io.github.lucaargolo.terrarianslimes.common.block.BlockCompendium
import io.github.lucaargolo.terrarianslimes.utils.RegistryCompendium
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.registry.Registry

object BlockEntityCompendium: RegistryCompendium<BlockEntityType<*>>(Registry.BLOCK_ENTITY_TYPE) {

    val RAINBOW_SLIME_BLOCK_TYPE = register(
        "rainbow_slime_block",
        BlockEntityType.Builder.create({ pos, state -> RainbowSlimeBlockEntity(pos, state) }, BlockCompendium.RAINBOW_SLIME_BLOCK).build(null)
    )

    @Suppress("UNCHECKED_CAST")
    val GLOWSTICK_LIGHT_BLOCK_TYPE = register(
        "glowstick_light",
        BlockEntityType.Builder.create({ pos, state ->GlowstickLightBlockEntity(pos, state) }, BlockCompendium.GLOWSTICK_LIGHT).build(null)
    ) as BlockEntityType<GlowstickLightBlockEntity>

}