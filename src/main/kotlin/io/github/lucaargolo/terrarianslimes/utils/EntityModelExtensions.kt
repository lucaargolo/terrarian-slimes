package io.github.lucaargolo.terrarianslimes.utils

import io.github.lucaargolo.terrarianslimes.mixin.AccessorModelData
import io.github.lucaargolo.terrarianslimes.mixin.AccessorModelPartData
import io.github.lucaargolo.terrarianslimes.mixin.InvokerModelPartData
import net.minecraft.client.model.ModelData
import net.minecraft.client.model.ModelPartBuilder
import net.minecraft.client.model.ModelPartData
import net.minecraft.client.model.ModelTransform

fun createModelData(modelPartData: ModelPartData): ModelData {
    return ModelData().also { (it as AccessorModelData).setData(modelPartData) }
}

fun createModelPartData(transform: ModelTransform): ModelPartData {
    return InvokerModelPartData.create(listOf(), transform)
}

fun ModelPartData.addChild(key: String, value: ModelPartData) {
    (this as AccessorModelPartData).children[key] = value
}

fun ModelPartData.addChild(key: String, value: ModelPartBuilder?) {
    this.addChild(key, value, ModelTransform.NONE)
}