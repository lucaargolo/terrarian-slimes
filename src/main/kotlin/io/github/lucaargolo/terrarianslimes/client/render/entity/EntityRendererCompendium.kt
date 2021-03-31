package io.github.lucaargolo.terrarianslimes.client.render.entity

import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.ModdedSlimeEntityRenderer
import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.UmbrellaSlimeEntityRenderer
import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.feature.IlluminantSlimeOverlayFeatureRenderer
import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.feature.ModdedSlimeOverlayFeatureRenderer
import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.feature.RainbowSlimeOverlayFeatureRenderer
import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.model.SpikedJungleSlimeEntityModel
import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.model.SpikedSlimeEntityModel
import io.github.lucaargolo.terrarianslimes.client.render.entity.spike.SpikeEntityRenderer
import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import io.github.lucaargolo.terrarianslimes.utils.GenericCompendium
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.client.render.entity.ItemEntityRenderer
import net.minecraft.client.render.entity.model.SlimeEntityModel
import net.minecraft.entity.projectile.thrown.ThrownItemEntity

object EntityRendererCompendium: GenericCompendium<EntityRendererRegistry.Factory>() {

    init {
        register("green_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) })  }
        register("blue_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) }) }
        register("red_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) }) }
        register("purple_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) }) }
        register("yellow_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) }) }
        register("black_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) }) }
        register("ice_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) }) }
        register("sand_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) }) }
        register("jungle_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) }) }
        register("spiked_ice_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SpikedSlimeEntityModel(), { ModdedSlimeOverlayFeatureRenderer(it) })}
        register("spiked_jungle_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SpikedJungleSlimeEntityModel(), { ModdedSlimeOverlayFeatureRenderer(it) })}
        register("mother_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) }) }
        register("baby_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) }) }
        register("lava_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) }, true) }
        register("pinky") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) }) }
        register("spiked_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SpikedSlimeEntityModel(), { ModdedSlimeOverlayFeatureRenderer(it) })}
        register("umbrella_slime") { dispatcher, _ -> UmbrellaSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) }) }
        register("corrupt_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) }) }
        register("slimeling") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) }) }
        register("crimslime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { ModdedSlimeOverlayFeatureRenderer(it) }) }
        register("illuminant_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { IlluminantSlimeOverlayFeatureRenderer(it) }, true) }
        register("rainbow_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher, SlimeEntityModel(16), { RainbowSlimeOverlayFeatureRenderer(it) }, true) }
        register("spike") { dispatcher, _ -> SpikeEntityRenderer(dispatcher) }
        register("grenade") { dispatcher, context -> FlyingItemEntityRenderer(dispatcher, context.itemRenderer) }
        register("bomb") { dispatcher, context -> FlyingItemEntityRenderer(dispatcher, context.itemRenderer) }
        register("dirt_bomb") { dispatcher, context -> FlyingItemEntityRenderer(dispatcher, context.itemRenderer) }
        register("dynamite") { dispatcher, context -> FlyingItemEntityRenderer(dispatcher, context.itemRenderer) }
        register("glowstick") { dispatcher, context -> FlyingItemEntityRenderer(dispatcher, context.itemRenderer) }
    }

    override fun initialize() {
        map.forEach { (entityIdentifier, entityRendererRegistryFactory) ->
            EntityRendererRegistry.INSTANCE.register(EntityCompendium.get(entityIdentifier), entityRendererRegistryFactory)
        }
    }
}