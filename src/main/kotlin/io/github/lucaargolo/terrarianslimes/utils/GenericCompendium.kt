package io.github.lucaargolo.terrarianslimes.utils

import net.minecraft.util.Identifier

abstract class GenericCompendium<T: Any> {

    protected val map = mutableMapOf<Identifier, T>()

    protected open fun register(string: String, entry: T): T {
        return register(ModIdentifier(string), entry)
    }

    protected open fun register(identifier: Identifier, entry: T): T {
        map[identifier] = entry
        return entry
    }

    abstract fun initialize()

}