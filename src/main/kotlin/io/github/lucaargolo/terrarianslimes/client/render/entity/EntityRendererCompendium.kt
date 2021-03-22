package io.github.lucaargolo.terrarianslimes.client.render.entity

import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.*
import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import io.github.lucaargolo.terrarianslimes.utils.GenericCompendium
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry

object EntityRendererCompendium: GenericCompendium<EntityRendererRegistry.Factory>() {

    init {
        register("green_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("blue_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("red_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("purple_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("yellow_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("black_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("ice_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("sand_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("jungle_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("spiked_ice_slime") { dispatcher, _ -> SpikedSlimeEntityRenderer(dispatcher)}
        register("spiked_jungle_slime") { dispatcher, _ -> SpikedJungleSlimeEntityRenderer(dispatcher)}
        register("mother_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("baby_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("lava_slime") { dispatcher, _ -> LavaSlimeEntityRenderer(dispatcher) }
        register("pinky") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("spiked_slime") { dispatcher, _ -> SpikedSlimeEntityRenderer(dispatcher)}
        register("umbrella_slime") { dispatcher, _ -> UmbrellaSlimeEntityRenderer(dispatcher) }
        register("corrupt_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("slimeling") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("crimslime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("illuminant_slime") { dispatcher, _ -> IlluminantSlimeEntityRenderer(dispatcher) }
        register("rainbow_slime") { dispatcher, _ -> RainbowSlimeEntityRenderer(dispatcher) }
    }

    override fun initialize() {
        map.forEach { (entityIdentifier, entityRendererRegistryFactory) ->
            EntityRendererRegistry.INSTANCE.register(EntityCompendium.get(entityIdentifier), entityRendererRegistryFactory)
        }
    }
}