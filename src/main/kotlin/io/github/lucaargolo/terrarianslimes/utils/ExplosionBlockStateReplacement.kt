package io.github.lucaargolo.terrarianslimes.utils

import io.github.lucaargolo.terrarianslimes.network.PacketCompendium
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.server.world.ServerWorld

open class ExplosionBlockStateReplacement {

    var isReplacingBlockState = false
    var replacementBlockState: BlockState = Blocks.AIR.defaultState

    fun setupReplacementBlockState(blockState: BlockState) {
        isReplacingBlockState = true
        replacementBlockState = blockState
    }

    open fun setupReplacementBlockState(world: ServerWorld, x: Double, y: Double, z: Double, blockState: BlockState) {

    }

    open class Client: ExplosionBlockStateReplacement() {
        companion object INSTANCE: Client()
    }

    open class Server: ExplosionBlockStateReplacement() {
        override fun setupReplacementBlockState(world: ServerWorld, x: Double, y: Double, z: Double, blockState: BlockState) {
            world.players.forEach { serverPlayer ->
                if (serverPlayer.squaredDistanceTo(x, y, z) < 4096.0) {
                    val buf = PacketByteBufs.create()
                    buf.writeVarInt(Block.getRawIdFromState(blockState))
                    ServerPlayNetworking.send(serverPlayer, PacketCompendium.REPLACE_EXPLOSION_BLOCK_STATE, buf)
                }
            }
            setupReplacementBlockState(blockState)
        }

        companion object INSTANCE: Server()
    }


}