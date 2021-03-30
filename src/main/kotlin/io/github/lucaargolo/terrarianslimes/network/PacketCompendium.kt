package io.github.lucaargolo.terrarianslimes.network

import io.github.lucaargolo.terrarianslimes.common.entity.spike.SpikeEntity
import io.github.lucaargolo.terrarianslimes.utils.ModIdentifier
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking

object PacketCompendium {

    val SPAWN_SPIKE_ENTITY = ModIdentifier("spawn_spike_entity")

    fun initializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(SPAWN_SPIKE_ENTITY) { client, handler, buf, _ ->
            val id = buf.readVarInt()
            val uuid = buf.readUuid()
            val x = buf.readDouble()
            val y = buf.readDouble()
            val z = buf.readDouble()
            val pitch = buf.readByte().toInt()
            val yaw = buf.readByte().toInt()
            val entityData = buf.readInt()

            client.execute {
                val world = handler.world
                val entity = SpikeEntity(world, x, y, z)

                world.getEntityById(entityData)?.let{
                    entity.owner = it
                }

                entity.updateTrackedPosition(x, y, z)
                entity.refreshPositionAfterTeleport(x, y, z)
                entity.pitch = (pitch * 360f) / 256.0f
                entity.yaw = (yaw * 360f) / 256.0f
                entity.entityId = id
                entity.uuid = uuid
                world.addEntity(id, entity)

            }
        }
    }

    fun initialize() {

    }

}