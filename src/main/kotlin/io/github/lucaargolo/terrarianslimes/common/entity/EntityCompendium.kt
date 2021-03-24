
package io.github.lucaargolo.terrarianslimes.common.entity

import io.github.lucaargolo.terrarianslimes.common.entity.slimes.IlluminantSlimeEntity
import io.github.lucaargolo.terrarianslimes.common.entity.slimes.LavaSlimeEntity
import io.github.lucaargolo.terrarianslimes.common.entity.slimes.ModdedSlimeEntity
import io.github.lucaargolo.terrarianslimes.common.entity.slimes.SpikedSlimeEntity
import io.github.lucaargolo.terrarianslimes.common.entity.spike.SpikeEntity
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
            ModdedSlimeEntity(type, world, 4.0, 0.4, 2.0, 2, true)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val BLUE_SLIME = register ("blue_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 6.5, 0.4,2.3, 2, true)
         }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val RED_SLIME = register ("red_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 9.0, 0.4,4.0, 2, true)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val PURPLE_SLIME = register ("purple_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 9.0, 0.4,4.0, 2, true)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val YELLOW_SLIME = register ("yellow_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 12.0, 0.4,5.0, 2, true)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val BLACK_SLIME = register ("black_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 12.0, 0.4,5.0, 2, true, StatusEffects.BLINDNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val ICE_SLIME = register ("ice_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 8.0, 0.4,3.0, 2, false, StatusEffects.SLOWNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val SAND_SLIME = register ("sand_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 13.0, 0.4,6.0, 2, false)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val JUNGLE_SLIME = register ("jungle_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 16.0, 0.4,6.0, 2, true)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val SPIKED_ICE_SLIME = register ("spiked_ice_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            SpikedSlimeEntity(type, world, 16.0, 0.4,4.0, 2, false, 6.0, StatusEffects.SLOWNESS, StatusEffects.SLOWNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val SPIKED_JUNGLE_SLIME = register ("spiked_jungle_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            SpikedSlimeEntity(type, world, 17.0, 0.4,8.4, 2, false, 8.5, StatusEffects.POISON)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val MOTHER_SLIME = register ("mother_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 24.0, 0.4,8.0, 3, false, null, BABY_SLIME, 1..3)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val BABY_SLIME = register ("baby_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 8.0, 0.4,4.0, 2, true, StatusEffects.BLINDNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val LAVA_SLIME = register ("lava_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            LavaSlimeEntity(type, world, 13.0, 0.8,6.0, 2, false)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val PINKY = register ("pinky",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 45.0, 0.8,2.0, 1, true)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            20
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val SPIKED_SLIME = register ("spiked_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            SpikedSlimeEntity(type, world, 15.0, 0.4,4.8, 2, false, 6.0)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val UMBRELLA_SLIME = register ("umbrella_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 9.0, 0.4,3.6, 3, false)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val CORRUPT_SLIME = register ("corrupt_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 50.0, 0.4,18.3, 3, false, StatusEffects.BLINDNESS, SLIMELING, 2..3)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val SLIMELING = register ("slimeling",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 25.0, 0.4,15.0, 2, false, StatusEffects.BLINDNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val CRIMSLIME = register ("crimslime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 57.0, 0.4,20.0, 3, false, StatusEffects.BLINDNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val ILLUMINANT_SLIME = register ("illuminant_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            IlluminantSlimeEntity(type, world, 51.4, 1.2,23.2, 2, false)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val RAINBOW_SLIME = register ("rainbow_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity>, world: World ->
            ModdedSlimeEntity(type, world, 115.0, 0.4,28.3, 4, false)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity>

    val SPIKE = register ("spike",
        FabricEntityTypeBuilder.create(SpawnGroup.MISC) { type: EntityType<SpikeEntity>, world: World ->
            SpikeEntity(type, world)
        }.dimensions(EntityDimensions.changing(0.25F, 0.25F)).trackRangeChunks(
            4
        ).trackedUpdateRate(
            10
        ).build()
    ) as EntityType<SpikeEntity>


}