package io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.model

import io.github.lucaargolo.terrarianslimes.common.entity.slimes.ModdedSlimeEntity
import io.github.lucaargolo.terrarianslimes.utils.createModelData
import io.github.lucaargolo.terrarianslimes.utils.createModelPartData
import io.github.lucaargolo.terrarianslimes.utils.addChild
import net.minecraft.client.model.*
import net.minecraft.client.render.entity.model.SinglePartEntityModel

class SpikedSlimeEntityModel(private val root: ModelPart): SinglePartEntityModel<ModdedSlimeEntity<*>>() {

    override fun getPart(): ModelPart = root

    override fun setAngles(entity: ModdedSlimeEntity<*>?, limbAngle: Float, limbDistance: Float, animationProgress: Float, headYaw: Float, headPitch: Float) { }

    companion object {
        fun getTexturedModelData(isJungle: Boolean): TexturedModelData {
            val y = if(isJungle) 12 else 0

            val slime = createModelPartData(ModelTransform.pivot(0.0F, 20.0F, 0.0F)).also {
                it.addChild("body", ModelPartBuilder.create().uv(0, 16).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F))
                it.addChild("right_eye", ModelPartBuilder.create().uv(32, 0).cuboid(-3.25F, -2.0F, -3.5F, 2.0F, 2.0F, 2.0F))
                it.addChild("left_eye", ModelPartBuilder.create().uv(32, 4).cuboid(1.25F, -2.0F, -3.5F, 2.0F, 2.0F, 2.0F))
                it.addChild("mouth", ModelPartBuilder.create().uv(32, 8).cuboid(0.0F, 1.0F, -3.5F, 1.0F, 1.0F, 1.0F))

                it.addChild("bone1", createModelPartData(ModelTransform.pivot(4.0F, -1.0F, -2.0F)).also { bone ->
                    bone.addChild("spike1", createModelPartData(ModelTransform.pivot(0.0F, -1.0F, 4.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(14, 14 + y).cuboid(-1.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F), ModelTransform.rotation(0.3568F, 0.5351F, 0.7846F))
                    })
                    bone.addChild("spike2", createModelPartData(ModelTransform.pivot(0.0F, -1.0F, 4.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(14, 14 + y).cuboid(-1.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F), ModelTransform.rotation(0.936F, -0.1382F, 0.9089F))
                    })
                    bone.addChild("spike3", createModelPartData(ModelTransform.pivot(0.0F, -1.0F, 4.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(14, 14 + y).cuboid(-1.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F), ModelTransform.rotation(1.0187F, -0.2409F, 0.806F))
                    })
                    bone.addChild("spike4", createModelPartData(ModelTransform.pivot(0.0F, -1.0F, 4.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(12, 12 + y).cuboid(-2.5F, -1.0F, -0.5F, 2.0F, 2.0F, 2.0F), ModelTransform.rotation(0.829F, 0.0F, 0.9163F))
                    })
                })

                it.addChild("bone2", createModelPartData(ModelTransform.of(2.0F, -1.0F, 4.0F, 0.0F, -1.5708F, 0.0F)).also { bone ->
                    bone.addChild("spike5", createModelPartData(ModelTransform.pivot(0.0F, 0.0F, 0.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(14, 14 + y).cuboid(-2.2813F, -1.277F, 0.0593F, 1.0F, 1.0F, 1.0F), ModelTransform.rotation(0.936F, -0.1382F, 0.9089F))
                    })
                    bone.addChild("spike6", createModelPartData(ModelTransform.pivot(0.0F, 1.0F, 3.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(14, 14 + y).cuboid(-1.9771F, -2.6537F, -1.5187F, 1.0F, 1.0F, 1.0F), ModelTransform.rotation(1.0187F, -0.2409F, 0.806F))
                    })
                    bone.addChild("spike7", createModelPartData(ModelTransform.pivot(0.0F, 0.0F, 2.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(12, 12 + y).cuboid(-2.1033F, -1.4329F, -1.3095F, 2.0F, 2.0F, 2.0F), ModelTransform.rotation(0.491F, 0.4079F, 0.8458F))
                    })
                    bone.addChild("spike8", createModelPartData(ModelTransform.pivot(0.0F, -1.0F, 4.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(14, 14 + y).cuboid(-0.8923F, -0.211F, -0.4096F, 1.0F, 1.0F, 1.0F), ModelTransform.rotation(0.3568F, 0.5351F, 0.7846F))
                    })
                })

                it.addChild("bone3", createModelPartData(ModelTransform.of(-4.0F, -1.0F, 2.0F, -3.1416F, 0.0F, 3.1416F)).also { bone ->
                    bone.addChild("spike9", createModelPartData(ModelTransform.pivot(0.0F, 0.0F, 0.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(14, 14 + y).cuboid(-1.5826F, -1.0917F, -0.4981F, 1.0F, 1.0F, 1.0F), ModelTransform.rotation(0.9907F, -0.2068F, 0.8995F))
                    })
                    bone.addChild("spike10", createModelPartData(ModelTransform.pivot(0.0F, 0.0F, 2.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(12, 12 + y).cuboid(-1.4163F, -0.7081F, -1.3604F, 2.0F, 2.0F, 2.0F), ModelTransform.rotation(0.491F, 0.4079F, 0.8458F))
                    })
                    bone.addChild("spike11", createModelPartData(ModelTransform.pivot(0.0F, -1.0F, 4.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(14, 14 + y).cuboid(-1.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F), ModelTransform.rotation(0.2426F, 0.6248F, 0.7219F))
                    })
                })

                it.addChild("bone4", createModelPartData(ModelTransform.pivot(4.0F, -1.0F, -2.0F)).also { bone ->
                    bone.addChild("spike12", createModelPartData(ModelTransform.pivot(-5.0F, -2.0F, 3.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(10, 10 + y).cuboid(-2.3F, -1.0F, -1.5F, 3.0F, 3.0F, 3.0F), ModelTransform.rotation(0.7053F, -0.1039F, 0.5721F))
                    })
                    bone.addChild("spike13", createModelPartData(ModelTransform.pivot(-1.0F, -5.0F, 4.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(10, 10 + y).cuboid(0.9F, 1.0F, -1.5F, 1.0F, 1.0F, 1.0F), ModelTransform.rotation(1.0187F, 0.3189F, 0.6485F))
                    })
                    bone.addChild("spike14", createModelPartData(ModelTransform.pivot(-4.0F, -5.0F, -1.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(10, 10 + y).cuboid(0.9F, 1.0F, -1.5F, 1.0F, 1.0F, 1.0F), ModelTransform.rotation(1.1357F, 0.4557F, 0.6929F))
                    })
                    bone.addChild("spike15", createModelPartData(ModelTransform.pivot(-2.0F, -3.0F, 3.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(10, 10 + y).cuboid(-1.3F, 0.0F, -1.5F, 2.0F, 2.0F, 2.0F), ModelTransform.rotation(1.1357F, 0.4557F, 0.6929F))
                    })
                    bone.addChild("spike16", createModelPartData(ModelTransform.pivot(-5.0F, -3.0F, 0.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(10, 10 + y).cuboid(-1.3F, 0.0F, -1.5F, 2.0F, 2.0F, 2.0F), ModelTransform.rotation(1.0187F, 0.3189F, 0.6485F))
                    })
                    bone.addChild("spike17", createModelPartData(ModelTransform.pivot(-3.0F, -2.0F, 1.0F)).also { spike ->
                        spike.addChild("self", ModelPartBuilder.create().uv(10, 10 + y).cuboid(-2.3F, -1.0F, -1.5F, 3.0F, 3.0F, 3.0F), ModelTransform.rotation(1.9874F, 0.9269F, 1.271F))
                    })
                })
            }

            return TexturedModelData.of(createModelData(slime), 64, 32)
        }
    }

}



