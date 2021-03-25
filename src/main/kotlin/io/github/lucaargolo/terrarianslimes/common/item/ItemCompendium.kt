package io.github.lucaargolo.terrarianslimes.common.item

import io.github.lucaargolo.terrarianslimes.TerrarianSlimes.Companion.creativeGroupSettings
import io.github.lucaargolo.terrarianslimes.common.block.BlockCompendium
import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import io.github.lucaargolo.terrarianslimes.utils.RegistryCompendium
import net.minecraft.item.Item
import net.minecraft.item.SpawnEggItem
import net.minecraft.util.registry.Registry

object ItemCompendium: RegistryCompendium<Item>(Registry.ITEM) {

    val GREEN_SLIME_EGG = register("green_slime_spawn_egg", SpawnEggItem(EntityCompendium.GREEN_SLIME, 0x6BC659, 0x3C9830, creativeGroupSettings()))
    val BLUE_SLIME_EGG = register("blue_slime_spawn_egg", SpawnEggItem(EntityCompendium.BLUE_SLIME, 0x5974C6, 0x304598, creativeGroupSettings()))
    val RED_SLIME_EGG = register("red_slime_spawn_egg", SpawnEggItem(EntityCompendium.RED_SLIME, 0xC65960, 0xA73E40, creativeGroupSettings()))
    val PURPLE_SLIME_EGG = register("purple_slime_spawn_egg", SpawnEggItem(EntityCompendium.PURPLE_SLIME, 0xAC64CF, 0x8437A3, creativeGroupSettings()))
    val YELLOW_SLIME_EGG = register("yellow_slime_spawn_egg", SpawnEggItem(EntityCompendium.YELLOW_SLIME, 0xC6C659, 0x939830, creativeGroupSettings()))
    val BLACK_SLIME_EGG = register("black_slime_spawn_egg", SpawnEggItem(EntityCompendium.BLACK_SLIME, 0x4E4E4E, 0x525252, creativeGroupSettings()))

    val ICE_SLIME_EGG = register("ice_slime_spawn_egg", SpawnEggItem(EntityCompendium.ICE_SLIME, 0x95E8E5, 0x88BEE8, creativeGroupSettings()))
    val SAND_SLIME_EGG = register("sand_slime_spawn_egg", SpawnEggItem(EntityCompendium.SAND_SLIME, 0xFBE17F, 0xD27F6B, creativeGroupSettings()))
    val JUNGLE_SLIME_EGG = register("jungle_slime_spawn_egg", SpawnEggItem(EntityCompendium.JUNGLE_SLIME, 0xA6D83A, 0x6EA413, creativeGroupSettings()))

    val SPIKED_ICE_SLIME_EGG = register("spiked_ice_slime_spawn_egg", SpawnEggItem(EntityCompendium.SPIKED_ICE_SLIME, 0x95E8E5, 0x88BEE8, creativeGroupSettings()))
    val SPIKED_JUNGLE_SLIME_EGG = register("spiked_jungle_slime_spawn_egg", SpawnEggItem(EntityCompendium.SPIKED_JUNGLE_SLIME, 0xA6D83A, 0x522E0A, creativeGroupSettings()))

    val MOTHER_SLIME_EGG = register("mother_slime_spawn_egg", SpawnEggItem(EntityCompendium.MOTHER_SLIME, 0x131313, 0x181818, creativeGroupSettings()))
    val BABY_SLIME_EGG = register("baby_slime_spawn_egg", SpawnEggItem(EntityCompendium.BABY_SLIME, 0x4E4E4E, 0x525252, creativeGroupSettings()))
    val LAVA_SLIME_EGG = register("lava_slime_spawn_egg", SpawnEggItem(EntityCompendium.LAVA_SLIME, 0xF08010, 0xBB7800, creativeGroupSettings()))

    val PINKY_EGG = register("pinky_spawn_egg", SpawnEggItem(EntityCompendium.PINKY, 0xC65998, 0xC65998, creativeGroupSettings()))
    val SPIKED_SLIME_EGG = register("spiked_slime_spawn_egg", SpawnEggItem(EntityCompendium.SPIKED_SLIME, 0x5974C6, 0x304598, creativeGroupSettings()))
    val UMBRELLA_SLIME_EGG = register("umbrella_slime_spawn_egg", SpawnEggItem(EntityCompendium.UMBRELLA_SLIME, 0x1F2DB1, 0xFFFFFF, creativeGroupSettings()))

    val CORRUPT_SLIME_EGG = register("corrupt_slime_spawn_egg", SpawnEggItem(EntityCompendium.CORRUPT_SLIME, 0x943BE8, 0x310DA1, creativeGroupSettings()))
    val SLIMELING_EGG = register("slimeling_spawn_egg", SpawnEggItem(EntityCompendium.SLIMELING, 0xB687E5, 0x5640A0, creativeGroupSettings()))
    val CRIMSLIME_SLIME_EGG = register("crimslime_spawn_egg", SpawnEggItem(EntityCompendium.CRIMSLIME, 0xAE2334, 0xA10D35, creativeGroupSettings()))

    val ILLUMINANT_SLIME_EGG = register("illuminant_slime_spawn_egg", SpawnEggItem(EntityCompendium.ILLUMINANT_SLIME, 0xC410F0, 0xB600D1, creativeGroupSettings()))
    val RAINBOW_SLIME_EGG = register("rainbow_slime_spawn_egg", SpawnEggItem(EntityCompendium.RAINBOW_SLIME, 0xFFFFFF, 0xFFFFFF, creativeGroupSettings()))

    val UMBRELLA = register("umbrella", Item(creativeGroupSettings().maxCount(1)))

    override fun initialize() {
        BlockCompendium.registerBlockItems(map)
        super.initialize()
    }

}