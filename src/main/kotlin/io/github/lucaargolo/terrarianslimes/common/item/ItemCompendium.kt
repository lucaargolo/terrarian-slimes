package io.github.lucaargolo.terrarianslimes.common.item

import io.github.lucaargolo.terrarianslimes.TerrarianSlimes.Companion.creativeGroupSettings
import io.github.lucaargolo.terrarianslimes.common.block.BlockCompendium
import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import io.github.lucaargolo.terrarianslimes.common.entity.throwable.ThrowableEntity
import io.github.lucaargolo.terrarianslimes.common.item.summonable.SummonableItem
import io.github.lucaargolo.terrarianslimes.common.item.throwable.ThrowableItem
import io.github.lucaargolo.terrarianslimes.common.item.wearable.WearableItem
import io.github.lucaargolo.terrarianslimes.utils.RegistryCompendium
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
import net.minecraft.client.MinecraftClient
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.*
import net.minecraft.util.registry.Registry
import java.awt.Color

object ItemCompendium: RegistryCompendium<Item>(Registry.ITEM) {

    init {
        BlockCompendium.registerBlockItems(map)
    }

    val ROYAL_GEL = register("royal_gel", Item(creativeGroupSettings().maxCount(1)))

    val APPLE_PIE = register("apple_pie", Item(creativeGroupSettings().food(FoodComponent.Builder().hunger(16).saturationModifier(0.6F).build())))
    val ICE_CREAM = register("ice_cream", Item(creativeGroupSettings().food(FoodComponent.Builder().hunger(8).saturationModifier(1.2F).build())))
    val BLESSED_APPLE = register("blessed_apple", EnchantedGoldenAppleItem(creativeGroupSettings().food(FoodComponent.Builder().hunger(8).saturationModifier(2.4F).statusEffect(StatusEffectInstance(StatusEffects.REGENERATION, 400, 1), 1.0F).statusEffect(StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 1), 1.0F).statusEffect(StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 1), 1.0F).statusEffect(StatusEffectInstance(StatusEffects.ABSORPTION, 6000, 3), 1.0F).alwaysEdible().build())))

    val GRENADE = register("grenade", ThrowableItem(EntityCompendium.GRENADE, ThrowableEntity.Type.NORMAL, creativeGroupSettings()))
    val STICKY_GRENADE = register("sticky_grenade", ThrowableItem(EntityCompendium.GRENADE, ThrowableEntity.Type.STICKY, creativeGroupSettings()))
    val BOUNCY_GRENADE = register("bouncy_grenade", ThrowableItem(EntityCompendium.GRENADE, ThrowableEntity.Type.BOUNCY, creativeGroupSettings()))

    val BOMB = register("bomb", ThrowableItem(EntityCompendium.BOMB, ThrowableEntity.Type.NORMAL, creativeGroupSettings()))
    val STICKY_BOMB = register("sticky_bomb", ThrowableItem(EntityCompendium.BOMB, ThrowableEntity.Type.STICKY, creativeGroupSettings()))
    val BOUNCY_BOMB = register("bouncy_bomb", ThrowableItem(EntityCompendium.BOMB, ThrowableEntity.Type.BOUNCY, creativeGroupSettings()))

    val DIRT_BOMB = register("dirt_bomb", ThrowableItem(EntityCompendium.DIRT_BOMB, ThrowableEntity.Type.NORMAL, creativeGroupSettings()))
    val STICKY_DIRT_BOMB = register("sticky_dirt_bomb", ThrowableItem(EntityCompendium.DIRT_BOMB, ThrowableEntity.Type.STICKY, creativeGroupSettings()))
    val BOUNCY_DIRT_BOMB = register("bouncy_dirt_bomb", ThrowableItem(EntityCompendium.DIRT_BOMB, ThrowableEntity.Type.BOUNCY, creativeGroupSettings()))

    val DYNAMITE = register("dynamite", ThrowableItem(EntityCompendium.DYNAMITE, ThrowableEntity.Type.NORMAL, creativeGroupSettings()))
    val STICKY_DYNAMITE = register("sticky_dynamite", ThrowableItem(EntityCompendium.DYNAMITE, ThrowableEntity.Type.STICKY, creativeGroupSettings()))
    val BOUNCY_DYNAMITE = register("bouncy_dynamite", ThrowableItem(EntityCompendium.DYNAMITE, ThrowableEntity.Type.BOUNCY, creativeGroupSettings()))

    val GLOWSTICK = register("glowstick", ThrowableItem(EntityCompendium.GLOWSTICK, ThrowableEntity.Type.NORMAL, creativeGroupSettings()))
    val STICKY_GLOWSTICK = register("sticky_glowstick", ThrowableItem(EntityCompendium.GLOWSTICK, ThrowableEntity.Type.STICKY, creativeGroupSettings()))
    val BOUNCY_GLOWSTICK = register("bouncy_glowstick", ThrowableItem(EntityCompendium.GLOWSTICK, ThrowableEntity.Type.BOUNCY, creativeGroupSettings()))

    val UMBRELLA = register("umbrella", Item(creativeGroupSettings().maxCount(1)))
    val UMBRELLA_HAT = register("umbrella_hat", WearableItem(creativeGroupSettings().maxCount(1).equipmentSlot { EquipmentSlot.HEAD }))

    val GOLD_CROWN = register("gold_crown", WearableItem(creativeGroupSettings().maxCount(1).equipmentSlot { EquipmentSlot.HEAD }))
    val SLIME_CROWN = register("slime_crown", SummonableItem(creativeGroupSettings().maxCount(1)))

    val GREEN_SLIME_GEL = register("green_gel", Item(creativeGroupSettings()))
    val BLUE_SLIME_GEL = register("blue_gel", Item(creativeGroupSettings()))
    val RED_SLIME_GEL = register("red_gel", Item(creativeGroupSettings()))
    val PURPLE_SLIME_GEL = register("purple_gel", Item(creativeGroupSettings()))
    val YELLOW_SLIME_GEL = register("yellow_gel", Item(creativeGroupSettings()))
    val BLACK_SLIME_GEL = register("black_gel", Item(creativeGroupSettings()))
    val ICE_SLIME_GEL = register("ice_gel", Item(creativeGroupSettings()))
    val SAND_SLIME_GEL = register("sand_gel", Item(creativeGroupSettings()))
    val JUNGLE_SLIME_GEL = register("jungle_gel", Item(creativeGroupSettings()))
    val PINKY_SLIME_GEL = register("pinky_gel", Item(creativeGroupSettings()))
    val CORRUPT_SLIME_GEL = register("corrupt_gel", Item(creativeGroupSettings()))
    val CRIMSON_SLIME_GEL = register("crimson_gel", Item(creativeGroupSettings()))
    val ILLUMINANT_SLIME_GEL = register("illuminant_gel", Item(creativeGroupSettings()))
    val RAINBOW_SLIME_GEL = register("rainbow_gel", Item(creativeGroupSettings()))

    val BLUE_SLIME_BALL = register("blue_slime_ball", Item(creativeGroupSettings()))
    val RED_SLIME_BALL = register("red_slime_ball", Item(creativeGroupSettings()))
    val PURPLE_SLIME_BALL = register("purple_slime_ball", Item(creativeGroupSettings()))
    val YELLOW_SLIME_BALL = register("yellow_slime_ball", Item(creativeGroupSettings()))
    val BLACK_SLIME_BALL = register("black_slime_ball", Item(creativeGroupSettings()))
    val ICE_SLIME_BALL = register("ice_slime_ball", Item(creativeGroupSettings()))
    val SAND_SLIME_BALL = register("sand_slime_ball", Item(creativeGroupSettings()))
    val JUNGLE_SLIME_BALL = register("jungle_slime_ball", Item(creativeGroupSettings()))
    val PINKY_SLIME_BALL = register("pinky_slime_ball", Item(creativeGroupSettings()))
    val CORRUPT_SLIME_BALL = register("corrupt_slime_ball", Item(creativeGroupSettings()))
    val CRIMSON_SLIME_BALL = register("crimson_slime_ball", Item(creativeGroupSettings()))
    val ILLUMINANT_SLIME_BALL = register("illuminant_slime_ball", Item(creativeGroupSettings()))
    val RAINBOW_SLIME_BALL = register("rainbow_slime_ball", Item(creativeGroupSettings()))
    
    val GREEN_SLIME_EGG = register("green_slime_spawn_egg", SpawnEggItem(EntityCompendium.GREEN_SLIME, 0x6BC659, 0x3C9830, creativeGroupSettings()))
    val BLUE_SLIME_EGG = register("blue_slime_spawn_egg", SpawnEggItem(EntityCompendium.BLUE_SLIME, 0x5974C6, 0x304598, creativeGroupSettings()))
    val RED_SLIME_EGG = register("red_slime_spawn_egg", SpawnEggItem(EntityCompendium.RED_SLIME, 0xC65960, 0xA73E40, creativeGroupSettings()))
    val PURPLE_SLIME_EGG = register("purple_slime_spawn_egg", SpawnEggItem(EntityCompendium.PURPLE_SLIME, 0xAC64CF, 0x8437A3, creativeGroupSettings()))
    val YELLOW_SLIME_EGG = register("yellow_slime_spawn_egg", SpawnEggItem(EntityCompendium.YELLOW_SLIME, 0xC6C659, 0x939830, creativeGroupSettings()))
    val BLACK_SLIME_EGG = register("black_slime_spawn_egg", SpawnEggItem(EntityCompendium.BLACK_SLIME, 0x4E4E4E, 0x525252, creativeGroupSettings()))
    val ICE_SLIME_EGG = register("ice_slime_spawn_egg", SpawnEggItem(EntityCompendium.ICE_SLIME, 0x95E8E5, 0x88BEE8, creativeGroupSettings()))
    val SAND_SLIME_EGG = register("sand_slime_spawn_egg", SpawnEggItem(EntityCompendium.SAND_SLIME, 0xFBE17F, 0xD27F6B, creativeGroupSettings()))
    val JUNGLE_SLIME_EGG = register("jungle_slime_spawn_egg", SpawnEggItem(EntityCompendium.JUNGLE_SLIME, 0xA6D83A, 0x6EA413, creativeGroupSettings()))
    val SPIKED_ICE_SLIME_EGG = register("spiked_ice_slime_spawn_egg", SpawnEggItem(EntityCompendium.SPIKED_ICE_SLIME, 0x95E8E5, 0x3D5568, creativeGroupSettings()))
    val SPIKED_JUNGLE_SLIME_EGG = register("spiked_jungle_slime_spawn_egg", SpawnEggItem(EntityCompendium.SPIKED_JUNGLE_SLIME, 0xA6D83A, 0x522E0A, creativeGroupSettings()))
    val MOTHER_SLIME_EGG = register("mother_slime_spawn_egg", SpawnEggItem(EntityCompendium.MOTHER_SLIME, 0x131313, 0x181818, creativeGroupSettings()))
    val BABY_SLIME_EGG = register("baby_slime_spawn_egg", SpawnEggItem(EntityCompendium.BABY_SLIME, 0x4E4E4E, 0x525252, creativeGroupSettings()))
    val LAVA_SLIME_EGG = register("lava_slime_spawn_egg", SpawnEggItem(EntityCompendium.LAVA_SLIME, 0xF08010, 0xBB7800, creativeGroupSettings()))
    val PINKY_EGG = register("pinky_spawn_egg", SpawnEggItem(EntityCompendium.PINKY, 0xC65998, 0xC65998, creativeGroupSettings()))
    val SPIKED_SLIME_EGG = register("spiked_slime_spawn_egg", SpawnEggItem(EntityCompendium.SPIKED_SLIME, 0x5974C6, 0x151E42, creativeGroupSettings()))
    val UMBRELLA_SLIME_EGG = register("umbrella_slime_spawn_egg", SpawnEggItem(EntityCompendium.UMBRELLA_SLIME, 0x1F2DB1, 0xFFFFFF, creativeGroupSettings()))
    val CORRUPT_SLIME_EGG = register("corrupt_slime_spawn_egg", SpawnEggItem(EntityCompendium.CORRUPT_SLIME, 0x943BE8, 0x310DA1, creativeGroupSettings()))
    val SLIMELING_EGG = register("slimeling_spawn_egg", SpawnEggItem(EntityCompendium.SLIMELING, 0xB687E5, 0x5640A0, creativeGroupSettings()))
    val CRIMSLIME_SLIME_EGG = register("crimslime_spawn_egg", SpawnEggItem(EntityCompendium.CRIMSLIME, 0xAE2334, 0xA10D35, creativeGroupSettings()))
    val ILLUMINANT_SLIME_EGG = register("illuminant_slime_spawn_egg", SpawnEggItem(EntityCompendium.ILLUMINANT_SLIME, 0xC410F0, 0xB600D1, creativeGroupSettings()))
    val RAINBOW_SLIME_EGG = register("rainbow_slime_spawn_egg", SpawnEggItem(EntityCompendium.RAINBOW_SLIME, 0xFFFFFF, 0xFFFFFF, creativeGroupSettings()))

    fun initializeClient() {
        ColorProviderRegistry.ITEM.register({ _, tintIndex ->
            val client = MinecraftClient.getInstance()
            val time = client.world?.time ?: 0
            Color.getHSBColor((time + client.tickDelta) / 200, when(tintIndex) { 0 -> 1.0f else -> 0.7f }, 1.0f).rgb
        }, RAINBOW_SLIME_BALL, RAINBOW_SLIME_GEL, RAINBOW_SLIME_EGG, BlockCompendium.RAINBOW_SLIME_BLOCK)
    }

}