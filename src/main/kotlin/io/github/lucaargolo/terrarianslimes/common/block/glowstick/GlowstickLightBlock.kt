package io.github.lucaargolo.terrarianslimes.common.block.glowstick

import io.github.lucaargolo.terrarianslimes.common.blockentity.glowstick.GlowstickLightBlockEntity
import io.github.lucaargolo.terrarianslimes.common.entity.throwable.ThrowableEntity
import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import net.minecraft.block.*
import net.minecraft.fluid.FluidState
import net.minecraft.fluid.Fluids
import net.minecraft.item.ItemStack
import net.minecraft.particle.ItemStackParticleEffect
import net.minecraft.particle.ParticleTypes
import net.minecraft.state.StateManager
import net.minecraft.state.property.EnumProperty
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView
import net.minecraft.world.World
import net.minecraft.world.WorldAccess
import java.util.*

class GlowstickLightBlock(settings: Settings): Block(settings), Waterloggable, BlockEntityProvider {

    init {
        defaultState = stateManager.defaultState.with(Properties.WATERLOGGED, false).with(GLOWSTICK, ThrowableEntity.Type.NORMAL)
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(Properties.WATERLOGGED)
        builder.add(GLOWSTICK)
    }

    @Suppress("DEPRECATION")
    override fun getFluidState(state: BlockState): FluidState? {
        return if (state.get(Properties.WATERLOGGED) as Boolean) Fluids.WATER.getStill(false)
        else super.getFluidState(state)
    }

    @Suppress("DEPRECATION")
    override fun getStateForNeighborUpdate(state: BlockState, direction: Direction, newState: BlockState, world: WorldAccess, pos: BlockPos?, posFrom: BlockPos?): BlockState? {
        if (state.get(Properties.WATERLOGGED) as Boolean) {
            world.fluidTickScheduler.schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world))
        }
        return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom)
    }

    override fun randomDisplayTick(state: BlockState, world: World, pos: BlockPos, random: Random) {
        (0..2).forEach { _ ->
            val vx = (random.nextDouble()-0.5)/5.0
            val vy = (random.nextDouble()-0.5)/5.0
            val vz = (random.nextDouble()-0.5)/5.0
            val vvy = (random.nextDouble()-0.5)/30.0
            val glowstick = when(state[GLOWSTICK]) {
                ThrowableEntity.Type.NORMAL -> ItemCompendium.GLOWSTICK
                ThrowableEntity.Type.BOUNCY -> ItemCompendium.BOUNCY_GLOWSTICK
                ThrowableEntity.Type.STICKY -> ItemCompendium.STICKY_GLOWSTICK
                null -> return@forEach
            }
            world.addParticle(ItemStackParticleEffect(ParticleTypes.ITEM, ItemStack(glowstick)), pos.x+0.5+vx, pos.y+0.5+vy, pos.z+0.5+vz, 0.0, 0.0+vvy, 0.0)
        }
    }

    override fun getOutlineShape(state: BlockState, world: BlockView, pos: BlockPos, context: ShapeContext): VoxelShape = VoxelShapes.empty()

    override fun createBlockEntity(world: BlockView?) = GlowstickLightBlockEntity()

    override fun getRenderType(state: BlockState?) = BlockRenderType.INVISIBLE

    companion object {
        val GLOWSTICK = EnumProperty.of("glowstick", ThrowableEntity.Type::class.java)
    }

}