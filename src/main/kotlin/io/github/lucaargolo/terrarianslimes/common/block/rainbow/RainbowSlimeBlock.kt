package io.github.lucaargolo.terrarianslimes.common.block.rainbow

import io.github.lucaargolo.terrarianslimes.common.blockentity.rainbow.RainbowSlimeBlockEntity
import net.minecraft.block.BlockEntityProvider
import net.minecraft.block.BlockRenderType
import net.minecraft.block.BlockState
import net.minecraft.block.SlimeBlock
import net.minecraft.world.BlockView

class RainbowSlimeBlock(settings: Settings): SlimeBlock(settings), BlockEntityProvider {

    override fun createBlockEntity(world: BlockView?) = RainbowSlimeBlockEntity()

    override fun getRenderType(state: BlockState?) = BlockRenderType.ENTITYBLOCK_ANIMATED

}