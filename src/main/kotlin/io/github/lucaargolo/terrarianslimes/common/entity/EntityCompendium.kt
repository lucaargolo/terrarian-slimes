
package io.github.lucaargolo.terrarianslimes.common.entity

import io.github.lucaargolo.terrarianslimes.common.entity.slimes.*
import io.github.lucaargolo.terrarianslimes.utils.RegistryCompendium
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.util.registry.Registry
import net.minecraft.world.World

@Suppress("UNCHECKED_CAST")
object EntityCompendium: RegistryCompendium<EntityType<*>>(Registry.ENTITY_TYPE) {

    val GREEN_SLIME = register ("green_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 1.0, 1.0, 1.0)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val BLUE_SLIME = register ("blue_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 1.66, 1.0,1.16)
         }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val RED_SLIME = register ("red_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 2.33, 1.0,2.0)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val PURPLE_SLIME = register ("purple_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 2.66, 1.0,2.0)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val YELLOW_SLIME = register ("yellow_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 3.0, 1.0,2.5)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val BLACK_SLIME = register ("black_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            StatusEffectSlimeEntity(type, world, 3.0, 1.0,2.5, StatusEffects.BLINDNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val ICE_SLIME = register ("ice_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            StatusEffectSlimeEntity(type, world, 2.0, 1.0,1.5, StatusEffects.SLOWNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val SAND_SLIME = register ("sand_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            StatusEffectSlimeEntity(type, world, 3.33, 1.0,3.0, StatusEffects.HUNGER)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val JUNGLE_SLIME = register ("jungle_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 4.0, 1.0,3.0)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val MOTHER_SLIME = register ("mother_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            MotherSlimeEntity(type, world, 6.0, 1.0,4.0)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val BABY_SLIME = register ("baby_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 2.0, 1.0,2.0)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val LAVA_SLIME = register ("lava_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            LavaSlimeEntity(type, world, 3.33, 2.0,3.0)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val PINKY = register ("pinky",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            PinkyEntity(type, world, 10.66, 2.0,1.0)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            20
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val UMBRELLA_SLIME = register ("umbrella_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            UmbrellaSlimeEntity(type, world, 2.33, 1.0,1.8)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val RAINBOW_SLIME = register ("rainbow_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            RainbowSlimeEntity(type, world, 28.5, 1.0,14.166)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>


}