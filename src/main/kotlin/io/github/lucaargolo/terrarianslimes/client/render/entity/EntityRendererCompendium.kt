package io.github.lucaargolo.terrarianslimes.client.render.entity

import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.LavaSlimeEntityRenderer
import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.ModdedSlimeEntityRenderer
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
        register("jungle_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("mother_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("baby_slime") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("pinky") { dispatcher, _ -> ModdedSlimeEntityRenderer(dispatcher) }
        register("lava_slime") { dispatcher, _ -> LavaSlimeEntityRenderer(dispatcher) }
    }

    override fun initialize() {
        map.forEach { (entityIdentifier, entityRendererRegistryFactory) ->
            EntityRendererRegistry.INSTANCE.register(EntityCompendium.get(entityIdentifier), entityRendererRegistryFactory)
        }
    }
}