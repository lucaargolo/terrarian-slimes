package io.github.lucaargolo.terrarianslimes.common.blockentity

import io.github.lucaargolo.terrarianslimes.common.block.GlowstickLightBlock
import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Box
import net.minecraft.world.World

class GlowstickLightBlockEntity(pos: BlockPos, state: BlockState): BlockEntity(BlockEntityCompendium.GLOWSTICK_LIGHT_BLOCK_TYPE, pos, state) {

    private var delay = 20

    companion object {

        fun serverTick(world: World, pos: BlockPos, state: BlockState, entity: GlowstickLightBlockEntity) {
            if(entity.delay-- <= 0) {
                entity.delay = 20
                var isBlockEntityValid = false
                world.getEntitiesByType(EntityCompendium.GLOWSTICK, Box(pos, pos.add(1, 1, 1))){!it.isRemoved}?.forEach { glowstick ->
                    if(glowstick.throwableType == state[GlowstickLightBlock.GLOWSTICK]) {
                        isBlockEntityValid = true
                    }
                }
                if(!isBlockEntityValid) {
                    world.setBlockState(pos, Blocks.AIR.defaultState)
                }
            }
        }

    }

}