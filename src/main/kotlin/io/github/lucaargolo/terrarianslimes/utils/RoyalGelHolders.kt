package io.github.lucaargolo.terrarianslimes.utils

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.minecraft.entity.LivingEntity
import net.minecraft.server.network.ServerPlayerEntity

object RoyalGelHolders {

    private val lastTickHolders = linkedSetOf<ServerPlayerEntity>()
    private val holders = linkedSetOf<ServerPlayerEntity>()

    fun isHolding(entity: LivingEntity) = lastTickHolders.contains(entity)

    fun addHolder(player: ServerPlayerEntity) = holders.add(player)

    fun initialize() {
        ServerTickEvents.END_SERVER_TICK.register {
            lastTickHolders.clear()
            lastTickHolders.addAll(holders)
            holders.clear()
        }
    }

}