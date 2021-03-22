package io.github.lucaargolo.terrarianslimes.client.render.entity.slimes.model

import io.github.lucaargolo.terrarianslimes.common.entity.slimes.ModdedSlimeEntity
import net.minecraft.client.model.ModelPart
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.util.math.MatrixStack

class SpikedJungleSlimeEntityModel: EntityModel<ModdedSlimeEntity>() {

    private val slime: ModelPart

    private val bone: ModelPart
    private val spike1: ModelPart
    private val spike2: ModelPart
    private val spike3: ModelPart
    private val spike4: ModelPart

    private val bone2: ModelPart
    private val spike5: ModelPart
    private val spike6: ModelPart
    private val spike7: ModelPart
    private val spike8: ModelPart

    private val bone3: ModelPart
    private val spike9: ModelPart
    private val spike10: ModelPart
    private val spike11: ModelPart

    private val bone4: ModelPart
    private val spike12: ModelPart
    private val spike13: ModelPart
    private val spike14: ModelPart
    private val spike15: ModelPart
    private val spike16: ModelPart
    private val spike17: ModelPart

    init {
        textureWidth = 64
        textureHeight = 32

        slime = ModelPart(this)
        slime.setPivot(0.0F, 20.0F, 0.0F)
        slime.setTextureOffset(0, 16).addCuboid(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false)
        slime.setTextureOffset(32, 0).addCuboid(-3.25F, -2.0F, -3.5F, 2.0F, 2.0F, 2.0F, 0.0F, false)
        slime.setTextureOffset(32, 4).addCuboid(1.25F, -2.0F, -3.5F, 2.0F, 2.0F, 2.0F, 0.0F, false)
        slime.setTextureOffset(32, 8).addCuboid(0.0F, 1.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false)

        bone = ModelPart(this)
        bone.setPivot(4.0F, -1.0F, -2.0F)
        slime.addChild(bone)

        spike1 = ModelPart(this)
        spike1.setPivot(0.0F, -1.0F, 4.0F)
        bone.addChild(spike1)
        spike1.setRotation(0.3568F, 0.5351F, 0.7846F)
        spike1.setTextureOffset(14, 14 + 12).addCuboid(-1.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false)

        spike2 = ModelPart(this)
        spike2.setPivot(0.0F, 0.0F, 0.0F)
        bone.addChild(spike2)
        spike2.setRotation(0.936F, -0.1382F, 0.9089F)
        spike2.setTextureOffset(14, 14 + 12).addCuboid(-1.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false)

        spike3 = ModelPart(this)
        spike3.setPivot(0.0F, 1.0F, 3.0F)
        bone.addChild(spike3)
        spike3.setRotation(1.0187F, -0.2409F, 0.806F)
        spike3.setTextureOffset(14, 14 + 12).addCuboid(-1.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false)

        spike4 = ModelPart(this)
        spike4.setPivot(0.0F, 0.0F, 2.0F)
        bone.addChild(spike4)
        spike4.setRotation(0.829F, 0.0F, 0.9163F)
        spike4.setTextureOffset(12, 12 + 12).addCuboid(-2.5F, -1.0F, -0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false)

        bone2 = ModelPart(this)
        bone2.setPivot(2.0F, -1.0F, 4.0F)
        slime.addChild(bone2)
        bone2.setRotation(0.0F, -1.5708F, 0.0F)


        spike5 = ModelPart(this)
        spike5.setPivot(0.0F, 0.0F, 0.0F)
        bone2.addChild(spike5)
        spike5.setRotation(0.936F, -0.1382F, 0.9089F)
        spike5.setTextureOffset(14, 14 + 12).addCuboid(-2.2813F, -1.277F, 0.0593F, 1.0F, 1.0F, 1.0F, 0.0F, false)

        spike6 = ModelPart(this)
        spike6.setPivot(0.0F, 1.0F, 3.0F)
        bone2.addChild(spike6)
        spike6.setRotation(1.0187F, -0.2409F, 0.806F)
        spike6.setTextureOffset(14, 14 + 12).addCuboid(-1.9771F, -2.6537F, -1.5187F, 1.0F, 1.0F, 1.0F, 0.0F, false)

        spike7 = ModelPart(this)
        spike7.setPivot(0.0F, 0.0F, 2.0F)
        bone2.addChild(spike7)
        spike7.setRotation(0.491F, 0.4079F, 0.8458F)
        spike7.setTextureOffset(12, 12 + 12).addCuboid(-2.1033F, -1.4329F, -1.3095F, 2.0F, 2.0F, 2.0F, 0.0F, false)

        spike8 = ModelPart(this)
        spike8.setPivot(0.0F, -1.0F, 4.0F)
        bone2.addChild(spike8)
        spike8.setRotation(0.3568F, 0.5351F, 0.7846F)
        spike8.setTextureOffset(14, 14 + 12).addCuboid(-0.8923F, -0.211F, -0.4096F, 1.0F, 1.0F, 1.0F, 0.0F, false)

        bone3 = ModelPart(this)
        bone3.setPivot(-4.0F, -1.0F, 2.0F)
        slime.addChild(bone3)
        bone3.setRotation(-3.1416F, 0.0F, 3.1416F)


        spike9 = ModelPart(this)
        spike9.setPivot(0.0F, 0.0F, 0.0F)
        bone3.addChild(spike9)
        spike9.setRotation(0.9907F, -0.2068F, 0.8995F)
        spike9.setTextureOffset(14, 14 + 12).addCuboid(-1.5826F, -1.0917F, -0.4981F, 1.0F, 1.0F, 1.0F, 0.0F, false)

        spike10 = ModelPart(this)
        spike10.setPivot(0.0F, 0.0F, 2.0F)
        bone3.addChild(spike10)
        spike10.setRotation(0.491F, 0.4079F, 0.8458F)
        spike10.setTextureOffset(12, 12 + 12).addCuboid(-1.4163F, -0.7081F, -1.3604F, 2.0F, 2.0F, 2.0F, 0.0F, false)

        spike11 = ModelPart(this)
        spike11.setPivot(0.0F, -1.0F, 4.0F)
        bone3.addChild(spike11)
        spike11.setRotation(0.2426F, 0.6248F, 0.7219F)
        spike11.setTextureOffset(14, 14 + 12).addCuboid(-1.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false)

        bone4 = ModelPart(this)
        bone4.setPivot(4.0F, -1.0F, -2.0F)
        slime.addChild(bone4)


        spike12 = ModelPart(this)
        spike12.setPivot(-5.0F, -2.0F, 3.0F)
        bone4.addChild(spike12)
        spike12.setRotation(0.7053F, -0.1039F, 0.5721F)
        spike12.setTextureOffset(10, 10 + 12).addCuboid(-2.3F, -1.0F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false)

        spike13 = ModelPart(this)
        spike13.setPivot(-1.0F, -5.0F, 4.0F)
        bone4.addChild(spike13)
        spike13.setRotation(1.0187F, 0.3189F, 0.6485F)
        spike13.setTextureOffset(10, 10 + 12).addCuboid(0.9F, 1.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false)

        spike14 = ModelPart(this)
        spike14.setPivot(-4.0F, -5.0F, -1.0F)
        bone4.addChild(spike14)
        spike14.setRotation(1.1357F, 0.4557F, 0.6929F)
        spike14.setTextureOffset(10, 10 + 12).addCuboid(0.9F, 1.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false)

        spike15 = ModelPart(this)
        spike15.setPivot(-2.0F, -3.0F, 3.0F)
        bone4.addChild(spike15)
        spike15.setRotation(1.1357F, 0.4557F, 0.6929F)
        spike15.setTextureOffset(10, 10 + 12).addCuboid(-1.3F, 0.0F, -1.5F, 2.0F, 2.0F, 2.0F, 0.0F, false)

        spike16 = ModelPart(this)
        spike16.setPivot(-5.0F, -3.0F, 0.0F)
        bone4.addChild(spike16)
        spike16.setRotation(1.0187F, 0.3189F, 0.6485F)
        spike16.setTextureOffset(10, 10 + 12).addCuboid(-1.3F, 0.0F, -1.5F, 2.0F, 2.0F, 2.0F, 0.0F, false)

        spike17 = ModelPart(this)
        spike17.setPivot(-3.0F, -2.0F, 1.0F)
        bone4.addChild(spike17)
        spike17.setRotation(1.9874F, 0.9269F, 1.271F)
        spike17.setTextureOffset(10, 10 + 12).addCuboid(-2.3F, -1.0F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false)
    }
    
    override fun render(matrices: MatrixStack?, vertices: VertexConsumer?, light: Int, overlay: Int, red: Float, green: Float, blue: Float, alpha: Float) {
        slime.render(matrices, vertices, light, overlay, red, green, blue, alpha)
    }

    override fun setAngles(entity: ModdedSlimeEntity?, limbAngle: Float, limbDistance: Float, animationProgress: Float, headYaw: Float, headPitch: Float) {
    }

    private fun ModelPart.setRotation(pitch: Float, yaw: Float, roll: Float) {
        this.pitch = pitch
        this.yaw = yaw
        this.roll = roll
    }
}