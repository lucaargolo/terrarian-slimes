package io.github.lucaargolo.terrarianslimes

import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import io.github.lucaargolo.terrarianslimes.network.PacketCompendium
import io.github.lucaargolo.terrarianslimes.utils.ModIdentifier
import io.github.lucaargolo.terrarianslimes.utils.ModConfig
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.block.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.io.File
import java.io.PrintWriter
import java.nio.file.Files
import com.google.gson.JsonParser
import com.google.gson.GsonBuilder

class TerrarianSlimes: ModInitializer {

    override fun onInitialize() {
        CONFIG.load()
        PacketCompendium.onInitialize()
        ItemCompendium.initialize()
        EntityCompendium.initialize()
    }

    companion object {
        const val MOD_ID = "terrarianslimes"

        private val creativeTab = FabricItemGroupBuilder.create(ModIdentifier("creative_tab")).icon{ ItemStack(Blocks.SLIME_BLOCK) }.build()
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

        fun creativeGroupSettings(): Item.Settings = Item.Settings().group(creativeTab)
    }

}