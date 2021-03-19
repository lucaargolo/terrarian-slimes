package io.github.lucaargolo.terrarianslimes.common.item

import io.github.lucaargolo.terrarianslimes.TerrarianSlimes.Companion.creativeGroupSettings
import io.github.lucaargolo.terrarianslimes.common.block.BlockCompendium
import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import io.github.lucaargolo.terrarianslimes.utils.RegistryCompendium
import net.minecraft.item.Item
import net.minecraft.item.SpawnEggItem
import net.minecraft.util.registry.Registry

object ItemCompendium: RegistryCompendium<Item>(Registry.ITEM) {

    val GREEN_SLIME_EGG = register("green_slime_spawn_egg", SpawnEggItem(EntityCompendium.GREEN_SLIME, 5349438, 8306542, creativeGroupSettings()))
    val BLUE_SLIME_EGG = register("blue_slime_spawn_egg", SpawnEggItem(EntityCompendium.BLUE_SLIME, 0x1F2DB1, 0x1F2DB1, creativeGroupSettings()))
    val RED_SLIME_EGG = register("red_slime_spawn_egg", SpawnEggItem(EntityCompendium.RED_SLIME, 0xB11F1F, 0xCD5555, creativeGroupSettings()))
    val PURPLE_SLIME_EGG = register("purple_slime_spawn_egg", SpawnEggItem(EntityCompendium.PURPLE_SLIME, 0x941FB1, 0xB555CD, creativeGroupSettings()))
    val YELLOW_SLIME_EGG = register("yellow_slime_spawn_egg", SpawnEggItem(EntityCompendium.YELLOW_SLIME, 0xB5AF18, 0xD0CA4F, creativeGroupSettings()))
    val BLACK_SLIME_EGG = register("black_slime_spawn_egg", SpawnEggItem(EntityCompendium.BLACK_SLIME, 0x4E4E4E, 0x525252, creativeGroupSettings()))

    val ICE_SLIME_EGG = register("ice_slime_spawn_egg", SpawnEggItem(EntityCompendium.ICE_SLIME, 0x083C8B, 0x47B1CA, creativeGroupSettings()))
    val SAND_SLIME_EGG = register("sand_slime_spawn_egg", SpawnEggItem(EntityCompendium.SAND_SLIME, 0x8A693A, 0xF4B76C, creativeGroupSettings()))
    val JUNGLE_SLIME_EGG = register("jungle_slime_spawn_egg", SpawnEggItem(EntityCompendium.JUNGLE_SLIME, 0x7FAC27, 0xA4C95B, creativeGroupSettings()))

    val MOTHER_SLIME_EGG = register("mother_slime_spawn_egg", SpawnEggItem(EntityCompendium.MOTHER_SLIME, 0x131313, 0x181818, creativeGroupSettings()))
    val BABY_SLIME_EGG = register("baby_slime_spawn_egg", SpawnEggItem(EntityCompendium.BABY_SLIME, 0x4E4E4E, 0x525252, creativeGroupSettings()))

    val LAVA_SLIME_EGG = register("lava_slime_spawn_egg", SpawnEggItem(EntityCompendium.LAVA_SLIME, 0xC94D00, 0xE27C3C, creativeGroupSettings()))

    val PINKY_EGG = register("pinky_spawn_egg", SpawnEggItem(EntityCompendium.PINKY, 0xC3588D, 0xD880AC, creativeGroupSettings()))

    val UMBRELLA_SLIME_EGG = register("umbrella_slime_spawn_egg", SpawnEggItem(EntityCompendium.UMBRELLA_SLIME, 0x1F2DB1, 0xFF0000, creativeGroupSettings()))

    val RAINBOW_SLIME_EGG = register("rainbow_slime_spawn_egg", SpawnEggItem(EntityCompendium.RAINBOW_SLIME, 0xFFFFFF, 0xFFFFFF, creativeGroupSettings()))

    val UMBRELLA = register("umbrella", Item(creativeGroupSettings().maxCount(1)))

    override fun initialize() {
        BlockCompendium.registerBlockItems(map)
        super.initialize()
    }

}