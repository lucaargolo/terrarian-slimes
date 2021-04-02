package io.github.lucaargolo.terrarianslimes.common.entity.slimes

import io.github.lucaargolo.terrarianslimes.utils.ModConfig
import net.minecraft.entity.EntityType
import net.minecraft.entity.boss.BossBar
import net.minecraft.entity.boss.ServerBossBar
import net.minecraft.entity.mob.SlimeEntity
import net.minecraft.item.ItemConvertible
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.world.World

class KingSlimeEntity<C: ModConfig.ModdedSlimeConfig>(
    entityType: EntityType<out SlimeEntity>,
    world: World,
    particleItem: ItemConvertible,
    config: C,
    defaultSize: Int
): ModdedSlimeEntity<C>(entityType, world, particleItem, config, defaultSize) {

    private val bossBar = ServerBossBar(displayName, BossBar.Color.BLUE, BossBar.Style.PROGRESS)

    override fun onStartedTrackingBy(player: ServerPlayerEntity) {
        super.onStartedTrackingBy(player)
        bossBar.addPlayer(player)
    }

    override fun onStoppedTrackingBy(player: ServerPlayerEntity?) {
        super.onStoppedTrackingBy(player)
        bossBar.removePlayer(player)
    }

    override fun tick() {
        super.tick()
        bossBar.percent = this.health / this.maxHealth
    }

}