package io.github.lucaargolo.terrarianslimes.common.blockentity.glowstick

import io.github.lucaargolo.terrarianslimes.common.block.glowstick.GlowstickLightBlock
import io.github.lucaargolo.terrarianslimes.common.blockentity.BlockEntityCompendium
import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import net.minecraft.block.Blocks
import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.Tickable
import net.minecraft.util.math.Box

class GlowstickLightBlockEntity: BlockEntity(BlockEntityCompendium.GLOWSTICK_LIGHT_BLOCK_TYPE), Tickable {

    private var delay = 20

    override fun tick() {
        if(delay-- <= 0 && world?.isClient == false) {
            delay = 20
            var isBlockEntityValid = false
            world?.getEntitiesByType(EntityCompendium.GLOWSTICK, Box(pos, pos.add(1, 1, 1))){!it.removed}?.forEach { glowstick ->
                if(glowstick.throwableType == cachedState[GlowstickLightBlock.GLOWSTICK]) {
                    isBlockEntityValid = true
                }
            }
            if(!isBlockEntityValid) {
                world?.setBlockState(pos, Blocks.AIR.defaultState)
            }
        }
    }


}