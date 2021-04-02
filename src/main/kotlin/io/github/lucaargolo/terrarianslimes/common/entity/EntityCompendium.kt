@file:Suppress("DEPRECATION")

package io.github.lucaargolo.terrarianslimes.common.entity

import io.github.lucaargolo.terrarianslimes.common.entity.slimes.*
import io.github.lucaargolo.terrarianslimes.common.entity.spike.SpikeEntity
import io.github.lucaargolo.terrarianslimes.common.entity.throwable.*
import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import io.github.lucaargolo.terrarianslimes.utils.ModConfig
import io.github.lucaargolo.terrarianslimes.utils.RegistryCompendium
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.fabricmc.fabric.mixin.`object`.builder.SpawnRestrictionAccessor
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.entity.SpawnRestriction
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.item.Items
import net.minecraft.util.registry.Registry
import net.minecraft.world.Heightmap
import net.minecraft.world.World
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeKeys

@Suppress("UNCHECKED_CAST")
object EntityCompendium: RegistryCompendium<EntityType<*>>(Registry.ENTITY_TYPE) {

    val GREEN_SLIME = register ("green_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, Items.SLIME_BALL, ModConfig.GREEN_SLIME, 2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val BLUE_SLIME = register ("blue_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ItemCompendium.BLUE_SLIME_BALL, ModConfig.BLUE_SLIME, 2)
         }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val RED_SLIME = register ("red_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ItemCompendium.RED_SLIME_BALL, ModConfig.RED_SLIME, 2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val PURPLE_SLIME = register ("purple_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ItemCompendium.PURPLE_SLIME_BALL, ModConfig.PURPLE_SLIME, 2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val YELLOW_SLIME = register ("yellow_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ItemCompendium.YELLOW_SLIME_BALL, ModConfig.YELLOW_SLIME, 2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val BLACK_SLIME = register ("black_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ItemCompendium.BLACK_SLIME_BALL, ModConfig.BLACK_SLIME, 2, StatusEffects.BLINDNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val ICE_SLIME = register ("ice_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ItemCompendium.ICE_SLIME_BALL, ModConfig.ICE_SLIME,2, StatusEffects.SLOWNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val SAND_SLIME = register ("sand_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ItemCompendium.SAND_SLIME_BALL, ModConfig.SAND_SLIME,2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val JUNGLE_SLIME = register ("jungle_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ItemCompendium.JUNGLE_SLIME_BALL, ModConfig.JUNGLE_SLIME,2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val SPIKED_ICE_SLIME = register ("spiked_ice_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            SpikedSlimeEntity(type, world, ItemCompendium.ICE_SLIME_BALL, ModConfig.SPIKED_ICE_SLIME, 2, StatusEffects.SLOWNESS, StatusEffects.SLOWNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val SPIKED_JUNGLE_SLIME = register ("spiked_jungle_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            SpikedSlimeEntity(type, world, ItemCompendium.JUNGLE_SLIME_BALL, ModConfig.SPIKED_JUNGLE_SLIME, 2, StatusEffects.POISON)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val MOTHER_SLIME = register ("mother_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ItemCompendium.BLACK_SLIME_BALL, ModConfig.MOTHER_SLIME, 3, null, BABY_SLIME, 1..3)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val BABY_SLIME = register ("baby_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ItemCompendium.BLACK_SLIME_BALL, ModConfig.BABY_SLIME, 2, StatusEffects.BLINDNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val LAVA_SLIME = register ("lava_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            LavaSlimeEntity(type, world, Items.BLAZE_POWDER, ModConfig.LAVA_SLIME, 2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val PINKY = register ("pinky",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ItemCompendium.PINKY_SLIME_BALL, ModConfig.PINKY, 1)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            20
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val KING_SLIME = register ("king_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            KingSlimeEntity(type, world, ItemCompendium.BLUE_SLIME_BALL, ModConfig.KING_SLIME, 10)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val SPIKED_SLIME = register ("spiked_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            SpikedSlimeEntity(type, world, ItemCompendium.BLUE_SLIME_BALL, ModConfig.SPIKED_SLIME, 2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val UMBRELLA_SLIME = register ("umbrella_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ItemCompendium.BLUE_SLIME_BALL, ModConfig.UMBRELLA_SLIME, 3)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val CORRUPT_SLIME = register ("corrupt_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ItemCompendium.CORRUPT_SLIME_BALL, ModConfig.CORRUPT_SLIME, 3, StatusEffects.BLINDNESS, SLIMELING, 2..3)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val SLIMELING = register ("slimeling",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ItemCompendium.CORRUPT_SLIME_BALL, ModConfig.SLIMELING, 2, StatusEffects.BLINDNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val CRIMSLIME = register ("crimslime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ItemCompendium.CRIMSON_SLIME_BALL, ModConfig.CRIMSLIME, 3, StatusEffects.BLINDNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val ILLUMINANT_SLIME = register ("illuminant_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            IlluminantSlimeEntity(type, world, ItemCompendium.ILLUMINANT_SLIME_BALL, ModConfig.ILLUMINANT_SLIME, 2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val RAINBOW_SLIME = register ("rainbow_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            RainbowSlimeEntity(type, world, ItemCompendium.RAINBOW_SLIME_BALL, ModConfig.RAINBOW_SLIME, 4)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val SPIKE = register ("spike",
        FabricEntityTypeBuilder.create(SpawnGroup.MISC) { type: EntityType<SpikeEntity>, world: World ->
            SpikeEntity(type, world)
        }.dimensions(EntityDimensions.changing(0.25F, 0.25F)).trackRangeChunks(
            4
        ).trackedUpdateRate(
            10
        ).build()
    ) as EntityType<SpikeEntity>

    val GRENADE = register ("grenade",
        FabricEntityTypeBuilder.create(SpawnGroup.MISC) { type: EntityType<ThrowableEntity>, world: World ->
            ThrowableGrenadeEntity(type, world)
        }.dimensions(EntityDimensions.changing(0.25F, 0.25F)).trackRangeChunks(
            4
        ).trackedUpdateRate(
            10
        ).build()
    ) as EntityType<ThrowableEntity>

    val BOMB = register ("bomb",
        FabricEntityTypeBuilder.create(SpawnGroup.MISC) { type: EntityType<ThrowableEntity>, world: World ->
            ThrowableBombEntity(type, world)
        }.dimensions(EntityDimensions.changing(0.25F, 0.25F)).trackRangeChunks(
            4
        ).trackedUpdateRate(
            10
        ).build()
    ) as EntityType<ThrowableEntity>

    val DIRT_BOMB = register ("dirt_bomb",
        FabricEntityTypeBuilder.create(SpawnGroup.MISC) { type: EntityType<ThrowableEntity>, world: World ->
            ThrowableDirtBombEntity(type, world)
        }.dimensions(EntityDimensions.changing(0.25F, 0.25F)).trackRangeChunks(
            4
        ).trackedUpdateRate(
            10
        ).build()
    ) as EntityType<ThrowableEntity>

    val DYNAMITE = register ("dynamite",
        FabricEntityTypeBuilder.create(SpawnGroup.MISC) { type: EntityType<ThrowableEntity>, world: World ->
            ThrowableDynamiteEntity(type, world)
        }.dimensions(EntityDimensions.changing(0.25F, 0.25F)).trackRangeChunks(
            4
        ).trackedUpdateRate(
            10
        ).build()
    ) as EntityType<ThrowableEntity>

    val GLOWSTICK = register ("glowstick",
        FabricEntityTypeBuilder.create(SpawnGroup.MISC) { type: EntityType<ThrowableEntity>, world: World ->
            ThrowableGlowstickEntity(type, world)
        }.dimensions(EntityDimensions.changing(0.25F, 0.25F)).trackRangeChunks(
            4
        ).trackedUpdateRate(
            10
        ).build()
    ) as EntityType<ThrowableEntity>

    override fun initialize() {
        super.initialize()

        //Green Slime
        FabricDefaultAttributeRegistry.register(GREEN_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.GREEN_SLIME.enabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld().and(BiomeSelectors.categories(Biome.Category.PLAINS, Biome.Category.FOREST, Biome.Category.TAIGA, Biome.Category.SAVANNA, Biome.Category.SAVANNA, Biome.Category.EXTREME_HILLS)), SpawnGroup.MONSTER, GREEN_SLIME, ModConfig.GREEN_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(GREEN_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getSurfaceSpawnPredicate(ModConfig.GREEN_SLIME.spawnProbability))
        }

        //Blue Slime
        FabricDefaultAttributeRegistry.register(BLUE_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.BLUE_SLIME.enabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld().and(BiomeSelectors.categories(Biome.Category.PLAINS, Biome.Category.FOREST, Biome.Category.TAIGA, Biome.Category.SAVANNA, Biome.Category.SAVANNA, Biome.Category.EXTREME_HILLS)), SpawnGroup.MONSTER, BLUE_SLIME, ModConfig.BLUE_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(BLUE_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getSurfaceSpawnPredicate(ModConfig.BLUE_SLIME.spawnProbability))
        }

        //Red Slime
        FabricDefaultAttributeRegistry.register(RED_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.RED_SLIME.enabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), SpawnGroup.MONSTER, RED_SLIME, ModConfig.RED_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(RED_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getUnderGroundSpawnPredicate(ModConfig.RED_SLIME.spawnProbability))
        }

        //Purple Slime
        FabricDefaultAttributeRegistry.register(PURPLE_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.PURPLE_SLIME.enabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld() , SpawnGroup.MONSTER, PURPLE_SLIME, ModConfig.PURPLE_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(PURPLE_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getFarSurfaceSpawnPredicate(ModConfig.PURPLE_SLIME.spawnProbability))
        }

        //Yellow Slime
        FabricDefaultAttributeRegistry.register(YELLOW_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.YELLOW_SLIME.enabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), SpawnGroup.MONSTER, YELLOW_SLIME, ModConfig.YELLOW_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(YELLOW_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getUnderGroundSpawnPredicate(ModConfig.YELLOW_SLIME.spawnProbability))
        }

        //Black Slime
        FabricDefaultAttributeRegistry.register(BLACK_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.BLACK_SLIME.enabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), SpawnGroup.MONSTER, BLACK_SLIME, ModConfig.BLACK_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(BLACK_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getCavernsSpawnPredicate(ModConfig.BLACK_SLIME.spawnProbability))
        }

        //Ice Slime
        FabricDefaultAttributeRegistry.register(ICE_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.ICE_SLIME.enabled) {
            BiomeModifications.addSpawn( BiomeSelectors.foundInOverworld().and { biomeSelector ->
                biomeSelector.biome.temperature < 0.15F
            }, SpawnGroup.MONSTER, ICE_SLIME, ModConfig.ICE_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(ICE_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getSnowSpawnPredicate(ModConfig.ICE_SLIME.spawnProbability))
        }

        //Sand Slime
        FabricDefaultAttributeRegistry.register(SAND_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.SAND_SLIME.enabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld().and(BiomeSelectors.categories(Biome.Category.DESERT, Biome.Category.MESA)), SpawnGroup.MONSTER, SAND_SLIME, ModConfig.SAND_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(SAND_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getSandSpawnPredicate(ModConfig.SAND_SLIME.spawnProbability))
        }

        //Jungle Slime
        FabricDefaultAttributeRegistry.register(JUNGLE_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.JUNGLE_SLIME.enabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld().and(BiomeSelectors.categories(Biome.Category.JUNGLE)), SpawnGroup.MONSTER, JUNGLE_SLIME, ModConfig.JUNGLE_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(JUNGLE_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getJungleSpawnPredicate(ModConfig.JUNGLE_SLIME.spawnProbability))
        }

        //Spiked Ice Slime
        FabricDefaultAttributeRegistry.register(SPIKED_ICE_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.SPIKED_ICE_SLIME.enabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld().and { biomeSelector ->
                biomeSelector.biome.temperature < 0.15F
            }, SpawnGroup.MONSTER, SPIKED_ICE_SLIME, ModConfig.SPIKED_ICE_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(SPIKED_ICE_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getSnowSpawnPredicate(ModConfig.SPIKED_ICE_SLIME.spawnProbability))
        }

        //Spiked Jungle Slime
        FabricDefaultAttributeRegistry.register(SPIKED_JUNGLE_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.SPIKED_JUNGLE_SLIME.enabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld().and(BiomeSelectors.categories(Biome.Category.JUNGLE)), SpawnGroup.MONSTER, SPIKED_JUNGLE_SLIME, ModConfig.SPIKED_JUNGLE_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(SPIKED_JUNGLE_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getJungleSpawnPredicate(ModConfig.SPIKED_JUNGLE_SLIME.spawnProbability))
        }

        //Mother Slime & Baby Slime
        FabricDefaultAttributeRegistry.register(MOTHER_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.MOTHER_SLIME.enabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), SpawnGroup.MONSTER, MOTHER_SLIME, ModConfig.MOTHER_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(MOTHER_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getCavernsSpawnPredicate(ModConfig.MOTHER_SLIME.spawnProbability))
        }
        FabricDefaultAttributeRegistry.register(BABY_SLIME, HostileEntity.createHostileAttributes())

        //Lava Slime
        FabricDefaultAttributeRegistry.register(LAVA_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.LAVA_SLIME.enabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInTheNether(), SpawnGroup.MONSTER, LAVA_SLIME, ModConfig.LAVA_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(LAVA_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getHellSpawnPredicate(ModConfig.LAVA_SLIME.spawnProbability))
        }

        //Pinky Slime
        FabricDefaultAttributeRegistry.register(PINKY, HostileEntity.createHostileAttributes())
        if(ModConfig.PINKY.enabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), SpawnGroup.MONSTER, PINKY, ModConfig.PINKY.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(PINKY, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getSurfaceSpawnPredicate(ModConfig.PINKY.spawnProbability))
        }

        //King Slime
        FabricDefaultAttributeRegistry.register(KING_SLIME, HostileEntity.createHostileAttributes())

        //Spiked Slime (To be used on the King Slime boss fight)
        FabricDefaultAttributeRegistry.register(SPIKED_SLIME, HostileEntity.createHostileAttributes())

        //Umbrella Slime
        FabricDefaultAttributeRegistry.register(UMBRELLA_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.UMBRELLA_SLIME.enabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld().and(BiomeSelectors.categories(Biome.Category.PLAINS, Biome.Category.FOREST, Biome.Category.TAIGA, Biome.Category.SAVANNA, Biome.Category.SAVANNA, Biome.Category.EXTREME_HILLS)), SpawnGroup.MONSTER, UMBRELLA_SLIME, ModConfig.UMBRELLA_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(UMBRELLA_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getRainySurfaceSpawnPredicate(ModConfig.UMBRELLA_SLIME.spawnProbability))
        }

        //Corrupt Slime & Slimeling
        FabricDefaultAttributeRegistry.register(CORRUPT_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.CORRUPT_SLIME.enabled) {
            BiomeModifications.addSpawn( {biomeSelector ->
                biomeSelector.biomeKey == BiomeKeys.WARPED_FOREST
            }, SpawnGroup.MONSTER, CORRUPT_SLIME, ModConfig.CORRUPT_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(CORRUPT_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getHellSpawnPredicate(ModConfig.CORRUPT_SLIME.spawnProbability))
        }
        FabricDefaultAttributeRegistry.register(SLIMELING, HostileEntity.createHostileAttributes())

        //Crimslime
        FabricDefaultAttributeRegistry.register(CRIMSLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.CRIMSLIME.enabled) {
            BiomeModifications.addSpawn( {biomeSelector ->
                biomeSelector.biomeKey == BiomeKeys.CRIMSON_FOREST
            }, SpawnGroup.MONSTER, CRIMSLIME, ModConfig.CRIMSLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(CRIMSLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getHellSpawnPredicate(ModConfig.CRIMSLIME.spawnProbability))
        }

        //Illuminant Slime
        FabricDefaultAttributeRegistry.register(ILLUMINANT_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.ILLUMINANT_SLIME.enabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInTheEnd(), SpawnGroup.MONSTER, ILLUMINANT_SLIME, ModConfig.ILLUMINANT_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(ILLUMINANT_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getTheEndSpawnPredicate(ModConfig.ILLUMINANT_SLIME.spawnProbability))
        }

        //Rainbow Slime
        FabricDefaultAttributeRegistry.register(RAINBOW_SLIME, HostileEntity.createHostileAttributes())
        if(ModConfig.RAINBOW_SLIME.enabled) {
            BiomeModifications.addSpawn(BiomeSelectors.foundInTheEnd(), SpawnGroup.MONSTER, RAINBOW_SLIME, ModConfig.RAINBOW_SLIME.spawnWeight, 1, 1)
            SpawnRestrictionAccessor.callRegister(RAINBOW_SLIME, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModdedSlimeEntity.getTheEndSpawnPredicate(ModConfig.RAINBOW_SLIME.spawnProbability))
        }

    }

}