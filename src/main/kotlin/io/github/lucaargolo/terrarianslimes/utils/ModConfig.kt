package io.github.lucaargolo.terrarianslimes.utils

import io.github.lucaargolo.terrarianslimes.TerrarianSlimes

class ModConfig {

    open class ModdedSlimeConfig(
        val enabled: Boolean = false,
        val spawnWeight: Int = 1,
        val spawnProbability: Float = 0f,
        val baseHealth: Double = 1.0,
        val baseSpeed: Double = 1.0,
        val baseAttack: Double = 1.0,
        val hasBonusDrops: Boolean = false
    )

    class SpikedSlimeConfig(
        enabled: Boolean = false,
        spawnWeight: Int = 1,
        spawnProbability: Float = 0f,
        baseHealth: Double = 1.0,
        baseSpeed: Double = 1.0,
        baseAttack: Double = 1.0,
        hasBonusDrops: Boolean = false,
        val baseSpikeAttack: Double = 1.0
    ): ModdedSlimeConfig(enabled, spawnWeight, spawnProbability, baseHealth, baseSpeed, baseAttack, hasBonusDrops)

    class SlimeConfig {
        val greenSlime = ModdedSlimeConfig(true, 40, 0.5f,  4.0, 0.4, 2.0, true)
        val blueSlime = ModdedSlimeConfig(true, 40, 0.1f, 6.5, 0.4, 2.3, true)
        val redSlime = ModdedSlimeConfig(true, 100, 0.3f, 9.0, 0.4, 4.0, true)
        val purpleSlime = ModdedSlimeConfig(true, 40, 0.05f, 9.0, 0.4, 4.0, true)
        val yellowSlime = ModdedSlimeConfig(true, 100, 0.2f, 12.0, 0.4, 5.0, true)
        val blackSlime = ModdedSlimeConfig(true, 100, 0.5f, 12.0, 0.4, 5.0, true)
        val iceSlime = ModdedSlimeConfig(true, 40, 0.4f, 8.0, 0.4, 3.0, false)
        val sandSlime = ModdedSlimeConfig(true, 40, 0.4f, 13.0, 0.4, 6.0, false)
        val jungleSlime = ModdedSlimeConfig(true, 40, 0.4f,  16.0, 0.4, 6.0, true)
        val spikedIceSlime = SpikedSlimeConfig(true, 20, 0.1f, 16.0, 0.4, 4.0, false, 6.0)
        val spikedJungleSlime = SpikedSlimeConfig(true, 20, 0.1f, 17.0, 0.4, 8.4, false, 8.5)
        val motherSlime = ModdedSlimeConfig(true, 100, 0.2f, 24.0, 0.5, 8.0, false)
        val babySlime = ModdedSlimeConfig(true, 0, 0f, 8.0, 0.4, 4.0, true)
        val lavaSlime = ModdedSlimeConfig(true, 10, 0.5f, 13.0, 0.8, 6.0, false)
        val pinky = ModdedSlimeConfig(true, 1, 0.25f, 45.0, 0.6, 2.0, true)
        val spikedSlime = SpikedSlimeConfig(true, 0, 0f, 15.0, 0.4, 4.8, false, 6.0)
        val umbrellaSlime = ModdedSlimeConfig(true, 40, 0.1f, 9.0, 0.5, 3.6, false)
        val corruptSlime = ModdedSlimeConfig(true, 10, 0.5f, 50.0, 0.5, 18.3, false)
        val slimeling = ModdedSlimeConfig(true, 0, 0f, 25.0, 0.4, 15.0, false)
        val crimslime = ModdedSlimeConfig(true, 10, 0.5f, 57.0, 0.5, 20.0, false)
        val illuminantSlime = ModdedSlimeConfig(true, 1, 0.4f, 51.4, 0.8, 23.2, false)
        val rainbowSlime = ModdedSlimeConfig(true, 1, 0.1f, 115.0, 0.6, 28.3, false)
    }

    private val slimeConfig = SlimeConfig()

    companion object {
        val GREEN_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.greenSlime
        val BLUE_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.blueSlime
        val RED_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.redSlime
        val PURPLE_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.purpleSlime
        val YELLOW_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.yellowSlime
        val BLACK_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.blackSlime
        val ICE_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.iceSlime
        val SAND_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.sandSlime
        val JUNGLE_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.jungleSlime
        val SPIKED_ICE_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.spikedIceSlime
        val SPIKED_JUNGLE_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.spikedJungleSlime
        val MOTHER_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.motherSlime
        val BABY_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.babySlime
        val LAVA_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.lavaSlime
        val PINKY
            get() = TerrarianSlimes.CONFIG.slimeConfig.pinky
        val SPIKED_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.spikedSlime
        val UMBRELLA_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.umbrellaSlime
        val CORRUPT_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.corruptSlime
        val SLIMELING
            get() = TerrarianSlimes.CONFIG.slimeConfig.slimeling
        val CRIMSLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.crimslime
        val ILLUMINANT_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.illuminantSlime
        val RAINBOW_SLIME
            get() = TerrarianSlimes.CONFIG.slimeConfig.rainbowSlime
    }

    fun load() {
        //Dummy method just to force the config load.
    }

}