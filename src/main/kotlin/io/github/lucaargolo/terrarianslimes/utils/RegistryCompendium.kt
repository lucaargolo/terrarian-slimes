package io.github.lucaargolo.terrarianslimes.utils

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

open class RegistryCompendium<T: Any>(private val registry: Registry<T>): GenericCompendium<T>() {

    fun get(identifier: Identifier): T? {
        return registry.get(identifier)
    }

    fun getId(entry: T): Identifier? {
        return registry.getId(entry)
    }

    override fun initialize() {
        map.forEach { (identifier, entry) ->
            Registry.register(registry, identifier, entry)
        }
    }

}