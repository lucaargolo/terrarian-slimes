
package io.github.lucaargolo.terrarianslimes.common.entity

import io.github.lucaargolo.terrarianslimes.common.entity.slimes.IlluminantSlimeEntity
import io.github.lucaargolo.terrarianslimes.common.entity.slimes.LavaSlimeEntity
import io.github.lucaargolo.terrarianslimes.common.entity.slimes.ModdedSlimeEntity
import io.github.lucaargolo.terrarianslimes.common.entity.slimes.SpikedSlimeEntity
import io.github.lucaargolo.terrarianslimes.common.entity.spike.SpikeEntity
import io.github.lucaargolo.terrarianslimes.utils.ModConfig
import io.github.lucaargolo.terrarianslimes.utils.RegistryCompendium
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.util.registry.Registry
import net.minecraft.world.World

@Suppress("UNCHECKED_CAST")
object EntityCompendium: RegistryCompendium<EntityType<*>>(Registry.ENTITY_TYPE) {

    val GREEN_SLIME = register ("green_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.GREEN_SLIME, 2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val BLUE_SLIME = register ("blue_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.BLUE_SLIME, 2)
         }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val RED_SLIME = register ("red_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.RED_SLIME, 2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val PURPLE_SLIME = register ("purple_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.PURPLE_SLIME, 2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val YELLOW_SLIME = register ("yellow_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.YELLOW_SLIME, 2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val BLACK_SLIME = register ("black_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.BLACK_SLIME, 2, StatusEffects.BLINDNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val ICE_SLIME = register ("ice_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.ICE_SLIME,2, StatusEffects.SLOWNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val SAND_SLIME = register ("sand_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.SAND_SLIME,2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val JUNGLE_SLIME = register ("jungle_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.JUNGLE_SLIME,2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val SPIKED_ICE_SLIME = register ("spiked_ice_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            SpikedSlimeEntity(type, world, ModConfig.SPIKED_ICE_SLIME, 2, StatusEffects.SLOWNESS, StatusEffects.SLOWNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val SPIKED_JUNGLE_SLIME = register ("spiked_jungle_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            SpikedSlimeEntity(type, world, ModConfig.SPIKED_JUNGLE_SLIME, 2, StatusEffects.POISON)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val MOTHER_SLIME = register ("mother_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.MOTHER_SLIME, 3, null, BABY_SLIME, 1..3)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val BABY_SLIME = register ("baby_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.BABY_SLIME, 2, StatusEffects.BLINDNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val LAVA_SLIME = register ("lava_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            LavaSlimeEntity(type, world, ModConfig.LAVA_SLIME, 2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val PINKY = register ("pinky",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.PINKY, 1)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            20
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val SPIKED_SLIME = register ("spiked_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            SpikedSlimeEntity(type, world, ModConfig.SPIKED_SLIME, 2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val UMBRELLA_SLIME = register ("umbrella_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.UMBRELLA_SLIME, 3)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val CORRUPT_SLIME = register ("corrupt_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.CORRUPT_SLIME, 3, StatusEffects.BLINDNESS, SLIMELING, 2..3)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val SLIMELING = register ("slimeling",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.SLIMELING, 2, StatusEffects.BLINDNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val CRIMSLIME = register ("crimslime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.CRIMSLIME, 3, StatusEffects.BLINDNESS)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val ILLUMINANT_SLIME = register ("illuminant_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            IlluminantSlimeEntity(type, world, ModConfig.ILLUMINANT_SLIME, 2)
        }.dimensions(EntityDimensions.changing(2.04F, 2.04F)).trackRangeChunks(
            10
        ).build()
    ) as EntityType<ModdedSlimeEntity<*>>

    val RAINBOW_SLIME = register ("rainbow_slime",
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) { type: EntityType<ModdedSlimeEntity<*>>, world: World ->
            ModdedSlimeEntity(type, world, ModConfig.RAINBOW_SLIME, 4)
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

    override fun initialize() {
        super.initialize()
        FabricDefaultAttributeRegistry.register(GREEN_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(BLUE_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(RED_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(PURPLE_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(YELLOW_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(BLACK_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(ICE_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(SAND_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(JUNGLE_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(SPIKED_ICE_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(SPIKED_JUNGLE_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(MOTHER_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(BABY_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(LAVA_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(PINKY, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(SPIKED_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(UMBRELLA_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(CORRUPT_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(SLIMELING, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(CRIMSLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(ILLUMINANT_SLIME, HostileEntity.createHostileAttributes())
        FabricDefaultAttributeRegistry.register(RAINBOW_SLIME, HostileEntity.createHostileAttributes())


    }

}