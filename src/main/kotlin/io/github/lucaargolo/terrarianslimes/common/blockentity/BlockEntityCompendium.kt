package io.github.lucaargolo.terrarianslimes.common.blockentity

import io.github.lucaargolo.terrarianslimes.common.block.BlockCompendium
import io.github.lucaargolo.terrarianslimes.common.blockentity.glowstick.GlowstickLightBlockEntity
import io.github.lucaargolo.terrarianslimes.common.blockentity.rainbow.RainbowSlimeBlockEntity
import io.github.lucaargolo.terrarianslimes.utils.RegistryCompendium
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.registry.Registry

object BlockEntityCompendium: RegistryCompendium<BlockEntityType<*>>(Registry.BLOCK_ENTITY_TYPE) {

    val RAINBOW_SLIME_BLOCK_TYPE = register(
        "rainbow_slime_block",
        BlockEntityType.Builder.create({ RainbowSlimeBlockEntity() }, BlockCompendium.RAINBOW_SLIME_BLOCK).build(null)
    )

    val GLOWSTICK_LIGHT_BLOCK_TYPE = register(
        "glowstick_light",
        BlockEntityType.Builder.create({ GlowstickLightBlockEntity() }, BlockCompendium.GLOWSTICK_LIGHT).build(null)
    )

}