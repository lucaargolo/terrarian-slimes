package io.github.lucaargolo.terrarianslimes

import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import io.github.lucaargolo.terrarianslimes.common.block.BlockCompendium
import io.github.lucaargolo.terrarianslimes.common.blockentity.BlockEntityCompendium
import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import io.github.lucaargolo.terrarianslimes.network.PacketCompendium
import io.github.lucaargolo.terrarianslimes.utils.ModConfig
import io.github.lucaargolo.terrarianslimes.utils.ModIdentifier
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.tag.TagRegistry
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.block.Block
import net.minecraft.item.ItemStack
import net.minecraft.tag.Tag
import net.minecraft.util.Identifier
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.io.File
import java.io.PrintWriter
import java.nio.file.Files

class TerrarianSlimes: ModInitializer {

    override fun onInitialize() {
        CONFIG.load()
        PacketCompendium.initialize()
        BlockCompendium.initialize()
        ItemCompendium.initialize()
        BlockEntityCompendium.initialize()
        EntityCompendium.initialize()
    }

    companion object {
        const val MOD_ID = "terrarianslimes"

        private val creativeTab = FabricItemGroupBuilder.create(ModIdentifier("creative_tab")).icon{ ItemStack(ItemCompendium.RAINBOW_SLIME_BALL) }.build()
        private val parser = JsonParser()
        private val gson = GsonBuilder().setPrettyPrinting().create()
        private val logger: Logger = LogManager.getLogger("Terrarian Slimes")

        val CONFIG: ModConfig by lazy {
            val configFile = File("${FabricLoader.getInstance().configDir}${File.separator}terrarianslimes.json")
            var finalConfig: ModConfig
            logger.info("Trying to read config file...")
            try {
                if (configFile.createNewFile()) {
                    logger.info("No config file found, creating a new one...")
                    val json: String = gson.toJson(parser.parse(gson.toJson(ModConfig())))
                    PrintWriter(configFile).use { out -> out.println(json) }
                    finalConfig = ModConfig()
                    logger.info("Successfully created default config file.")
                } else {
                    logger.info("A config file was found, loading it..")
                    finalConfig = gson.fromJson(String(Files.readAllBytes(configFile.toPath())), ModConfig::class.java)
                    if (finalConfig == null) {
                        throw NullPointerException("The config file was empty.")
                    } else {
                        logger.info("Successfully loaded config file.")
                    }
                }
            } catch (exception: Exception) {
                logger.error("There was an error creating/loading the config file!", exception)
                finalConfig = ModConfig()
                logger.warn("Defaulting to original config.")
            }
            finalConfig
        }

        val CANVAS: Boolean by lazy {
            FabricLoader.getInstance().isModLoaded("canvas")
        }

        val slimeBlocksTag: Tag<Block> by lazy {
            TagRegistry.block(Identifier("c", "slime_blocks"))
        }

        fun creativeGroupSettings(): FabricItemSettings = FabricItemSettings().group(creativeTab)
    }

}