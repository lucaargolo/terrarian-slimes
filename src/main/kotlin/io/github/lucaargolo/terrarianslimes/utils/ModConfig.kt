package io.github.lucaargolo.terrarianslimes.utils

@Suppress("PropertyName")
class ModConfig {

    open class ModdedSlimeConfig(
        val baseHealth: Double,
        val baseSpeed: Double,
        val baseAttack: Double,
        val hasBonusDrops: Boolean
    )

    class SpikedSlimeConfig(
        baseHealth: Double,
        baseSpeed: Double,
        baseAttack: Double,
        hasBonusDrops: Boolean,
        val baseSpikeAttack: Double
    ): ModdedSlimeConfig(baseHealth, baseSpeed, baseAttack, hasBonusDrops)

    val GREEN_SLIME = ModdedSlimeConfig(4.0, 0.4, 2.0, true)
    val BLUE_SLIME = ModdedSlimeConfig(6.5, 0.4,2.3, true)
    val RED_SLIME = ModdedSlimeConfig(9.0, 0.4,4.0, true)
    val PURPLE_SLIME = ModdedSlimeConfig(9.0, 0.4,4.0, true)
    val YELLOW_SLIME = ModdedSlimeConfig(12.0, 0.4,5.0, true)
    val BLACK_SLIME = ModdedSlimeConfig(12.0, 0.4,5.0, true)
    val ICE_SLIME = ModdedSlimeConfig(8.0, 0.4,3.0, false)
    val SAND_SLIME = ModdedSlimeConfig(13.0, 0.4,6.0, false)
    val JUNGLE_SLIME = ModdedSlimeConfig(16.0, 0.4,6.0, true)
    val SPIKED_ICE_SLIME = SpikedSlimeConfig(16.0, 0.4,4.0, false, 6.0)
    val SPIKED_JUNGLE_SLIME = SpikedSlimeConfig(17.0, 0.4,8.4,  false, 8.5)
    val MOTHER_SLIME = ModdedSlimeConfig(24.0, 0.5,8.0, false)
    val BABY_SLIME = ModdedSlimeConfig(8.0, 0.4,4.0, true)
    val LAVA_SLIME = ModdedSlimeConfig(13.0, 0.8,6.0, false)
    val PINKY = ModdedSlimeConfig(45.0, 0.6,2.0, true)
    val SPIKED_SLIME = SpikedSlimeConfig(15.0, 0.4,4.8, false, 6.0)
    val UMBRELLA_SLIME = ModdedSlimeConfig(9.0, 0.5,3.6, false)
    val CORRUPT_SLIME = ModdedSlimeConfig(50.0, 0.5,18.3, false)
    val SLIMELING = ModdedSlimeConfig(25.0, 0.4,15.0, false)
    val CRIMSLIME = ModdedSlimeConfig(57.0, 0.5,20.0, false)
    val ILLUMINANT_SLIME = ModdedSlimeConfig(51.4, 0.8,23.2, false)
    val RAINBOW_SLIME = ModdedSlimeConfig(115.0, 0.6,28.3, false)

    fun load() {
        //Dummy method just to force the config load.
    }

}