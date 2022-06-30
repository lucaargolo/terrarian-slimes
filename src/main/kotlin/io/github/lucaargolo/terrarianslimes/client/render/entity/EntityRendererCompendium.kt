package io.github.lucaargolo.terrarianslimes.client.render.entity

import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.KingSlimeEntityRenderer
import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.ModdedSlimeEntityRenderer
import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.UmbrellaSlimeEntityRenderer
import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.feature.IlluminantSlimeOverlayFeatureRenderer
import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.feature.ModdedSlimeOverlayFeatureRenderer
import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.feature.RainbowSlimeOverlayFeatureRenderer
import io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.model.SpikedSlimeEntityModel
import io.github.lucaargolo.terrarianslimes.client.render.entity.spike.SpikeEntityRenderer
import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import io.github.lucaargolo.terrarianslimes.utils.ModIdentifier
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.client.render.entity.model.EntityModelLayers
import net.minecraft.client.render.entity.model.SlimeEntityModel

object EntityRendererCompendium {

    @Suppress("UnstableApiUsage", "Deprecation")
    fun initialize() {
        val spikedSlimeModelLayer = EntityModelLayer(ModIdentifier("spiked_slime"), "slime")
        EntityModelLayerRegistry.registerModelLayer(spikedSlimeModelLayer) { SpikedSlimeEntityModel.getTexturedModelData(false) }
        val spikedJungleSlimeModelLayer = EntityModelLayer(ModIdentifier("spiked_jungle_slime"), "slime")
        EntityModelLayerRegistry.registerModelLayer(spikedJungleSlimeModelLayer) { SpikedSlimeEntityModel.getTexturedModelData(true) }

        EntityRendererRegistry.register(EntityCompendium.GREEN_SLIME) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer)  }
        EntityRendererRegistry.register(EntityCompendium.BLUE_SLIME) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.RED_SLIME) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.PURPLE_SLIME) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.YELLOW_SLIME) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.BLACK_SLIME) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.ICE_SLIME) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.SAND_SLIME) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.JUNGLE_SLIME) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.SPIKED_ICE_SLIME) { ModdedSlimeEntityRenderer(it, SpikedSlimeEntityModel(it.getPart(spikedSlimeModelLayer)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.SPIKED_JUNGLE_SLIME) { ModdedSlimeEntityRenderer(it, SpikedSlimeEntityModel(it.getPart(spikedJungleSlimeModelLayer)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.MOTHER_SLIME) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.BABY_SLIME) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.LAVA_SLIME) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer, true) }
        EntityRendererRegistry.register(EntityCompendium.PINKY) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.KING_SLIME) { KingSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.SPIKED_SLIME) { ModdedSlimeEntityRenderer(it, SpikedSlimeEntityModel(it.getPart(spikedSlimeModelLayer)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.UMBRELLA_SLIME) { UmbrellaSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.CORRUPT_SLIME) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer ) }
        EntityRendererRegistry.register(EntityCompendium.SLIMELING) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.CRIMSLIME) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::ModdedSlimeOverlayFeatureRenderer) }
        EntityRendererRegistry.register(EntityCompendium.ILLUMINANT_SLIME) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::IlluminantSlimeOverlayFeatureRenderer, true) }
        EntityRendererRegistry.register(EntityCompendium.RAINBOW_SLIME) { ModdedSlimeEntityRenderer(it, SlimeEntityModel(it.getPart(EntityModelLayers.SLIME)), ::RainbowSlimeOverlayFeatureRenderer, true) }
        EntityRendererRegistry.register(EntityCompendium.SPIKE, ::SpikeEntityRenderer)
        EntityRendererRegistry.register(EntityCompendium.GRENADE, ::FlyingItemEntityRenderer)
        EntityRendererRegistry.register(EntityCompendium.BOMB, ::FlyingItemEntityRenderer)
        EntityRendererRegistry.register(EntityCompendium.DIRT_BOMB, ::FlyingItemEntityRenderer)
        EntityRendererRegistry.register(EntityCompendium.DYNAMITE, ::FlyingItemEntityRenderer)
        EntityRendererRegistry.register(EntityCompendium.GLOWSTICK, ::FlyingItemEntityRenderer)
    }

}