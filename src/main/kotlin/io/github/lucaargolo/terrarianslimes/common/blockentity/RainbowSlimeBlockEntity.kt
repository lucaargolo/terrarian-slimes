package io.github.lucaargolo.terrarianslimes.common.blockentity

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.math.BlockPos

class RainbowSlimeBlockEntity(pos: BlockPos, state: BlockState): BlockEntity(BlockEntityCompendium.RAINBOW_SLIME_BLOCK_TYPE, pos, state)