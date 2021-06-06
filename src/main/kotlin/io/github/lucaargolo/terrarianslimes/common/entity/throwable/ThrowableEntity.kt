package io.github.lucaargolo.terrarianslimes.common.entity.throwable

import io.github.lucaargolo.terrarianslimes.network.PacketCompendium
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.entity.EntityType
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.nbt.NbtCompound
import net.minecraft.network.Packet
import net.minecraft.util.StringIdentifiable
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.MathHelper
import net.minecraft.util.math.Vec3d
import net.minecraft.util.registry.Registry
import net.minecraft.world.World
import kotlin.math.abs

abstract class ThrowableEntity: ThrownItemEntity {

    constructor(entityType: EntityType<ThrowableEntity>, world: World): super(entityType, world)

    constructor(entityType: EntityType<ThrowableEntity>, x: Double, y: Double, z: Double, world: World): super(entityType, x, y, z, world)

    enum class Type(val coefficientOfRestitution: Double): StringIdentifiable {
        NORMAL(0.25),
        STICKY(0.00),
        BOUNCY(0.80);

        override fun asString() = name.lowercase()
    }

    var throwableType = Type.NORMAL
    var isMoving = true
    var isColliding = false

    abstract fun getNormalVariant(): Item
    abstract fun getStickyVariant(): Item
    abstract fun getBouncyVariant(): Item

    override fun getDefaultItem(): Item = when(throwableType) {
        Type.NORMAL -> getNormalVariant()
        Type.STICKY -> getStickyVariant()
        Type.BOUNCY -> getBouncyVariant()
    }

    override fun tick() {
        isColliding = false
        if(abs(velocity.x) < 0.05)
            velocity = velocity.multiply(0.0, 1.0, 1.0)
        if(abs(velocity.z) < 0.05)
            velocity = velocity.multiply(1.0, 1.0, 0.0)
        super.tick()
        if(isColliding && abs(velocity.y) < 0.05) {
            velocity = velocity.multiply(1.0, 0.0, 1.0)
        }
        isMoving = velocity.x != 0.0 && velocity.y != 0.0 && velocity.z != 0.0
    }

    override fun onBlockHit(blockHitResult: BlockHitResult) {
        isColliding = true
        val side = Vec3d.of(blockHitResult.side.opposite.vector)
        val cor = throwableType.coefficientOfRestitution
        var newVelocity = Vec3d(velocity.x*cor, velocity.y*cor, velocity.z*cor)
        if(side.x != 0.0)
            newVelocity = newVelocity.multiply(side.x, 1.0, 1.0)
        if(side.y != 0.0)
            newVelocity = newVelocity.multiply(1.0, side.y, 1.0)
        if(side.z != 0.0)
            newVelocity = newVelocity.multiply(1.0, 1.0, side.z)
        velocity = newVelocity
        if(throwableType == Type.STICKY) {
            setNoGravity(true)
        }
        super.onBlockHit(blockHitResult)
    }

    override fun writeCustomDataToNbt(tag: NbtCompound) {
        super.writeCustomDataToNbt(tag)
        tag.putString("throwableType", throwableType.name)
    }

    override fun readCustomDataFromNbt(tag: NbtCompound) {
        super.readCustomDataFromNbt(tag)
        throwableType = try{Type.valueOf(tag.getString("throwableType"))}catch(ignored: Exception){Type.NORMAL}
    }

    override fun createSpawnPacket(): Packet<*> {
        val buf = PacketByteBufs.create()
        buf.writeVarInt(id)
        buf.writeUuid(getUuid())
        buf.writeVarInt(Registry.ENTITY_TYPE.getRawId(type))
        buf.writeDouble(x)
        buf.writeDouble(y)
        buf.writeDouble(z)
        buf.writeByte(MathHelper.floor(pitch * 256.0f / 360.0f))
        buf.writeByte(MathHelper.floor(yaw * 256.0f / 360.0f))
        buf.writeInt(owner?.id ?: 0)
        buf.writeEnumConstant(throwableType)

        return ServerPlayNetworking.createS2CPacket(PacketCompendium.SPAWN_THROWABLE_ENTITY, buf)
    }

}