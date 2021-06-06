package io.github.lucaargolo.terrarianslimes.common.block

import io.github.lucaargolo.terrarianslimes.common.blockentity.RainbowSlimeBlockEntity
import net.minecraft.block.BlockEntityProvider
import net.minecraft.block.BlockRenderType
import net.minecraft.block.BlockState
import net.minecraft.block.SlimeBlock
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView

class RainbowSlimeBlock(settings: Settings): SlimeBlock(settings), BlockEntityProvider {

    override fun createBlockEntity(pos: BlockPos, state: BlockState) = RainbowSlimeBlockEntity(pos, state)

    override fun getRenderType(state: BlockState?) = BlockRenderType.INVISIBLE


}