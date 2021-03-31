package io.github.lucaargolo.terrarianslimes.common.entity.throwable

import io.github.lucaargolo.terrarianslimes.network.PacketCompendium
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.entity.EntityType
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.nbt.CompoundTag
import net.minecraft.network.Packet
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.MathHelper
import net.minecraft.util.math.Vec3d
import net.minecraft.util.registry.Registry
import net.minecraft.world.World

abstract class ThrowableEntity: ThrownItemEntity {

    constructor(entityType: EntityType<ThrowableEntity>, world: World): super(entityType, world)

    constructor(entityType: EntityType<ThrowableEntity>, x: Double, y: Double, z: Double, world: World): super(entityType, x, y, z, world)

    enum class Type(val coefficientOfRestitution: Double) {
        NORMAL(0.25),
        STICKY(0.00),
        BOUNCY(0.95)
    }

    var throwableType = Type.NORMAL
    var disableGravity = false

    abstract fun getNormalVariant(): Item
    abstract fun getStickyVariant(): Item
    abstract fun getBouncyVariant(): Item

    override fun getDefaultItem(): Item = when(throwableType) {
        Type.NORMAL -> getNormalVariant()
        Type.STICKY -> getStickyVariant()
        Type.BOUNCY -> getBouncyVariant()
    }

    override fun onBlockHit(blockHitResult: BlockHitResult) {
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
            disableGravity = true
        }
        super.onBlockHit(blockHitResult)
    }

    override fun getGravity() = if(disableGravity) 0f else super.getGravity()

    override fun writeCustomDataToTag(tag: CompoundTag) {
        super.writeCustomDataToTag(tag)
        tag.putString("throwableType", throwableType.name)
        tag.putBoolean("disableGravity", disableGravity)
    }

    override fun readCustomDataFromTag(tag: CompoundTag) {
        super.readCustomDataFromTag(tag)
        throwableType = try{Type.valueOf(tag.getString("throwableType"))}catch(ignored: Exception){Type.NORMAL}
        disableGravity = tag.getBoolean("disableGravity")
    }

    override fun createSpawnPacket(): Packet<*> {
        val buf = PacketByteBufs.create()
        buf.writeVarInt(entityId)
        buf.writeUuid(getUuid())
        buf.writeVarInt(Registry.ENTITY_TYPE.getRawId(type))
        buf.writeDouble(x)
        buf.writeDouble(y)
        buf.writeDouble(z)
        buf.writeByte(MathHelper.floor(pitch * 256.0f / 360.0f))
        buf.writeByte(MathHelper.floor(yaw * 256.0f / 360.0f))
        buf.writeInt(owner?.entityId ?: 0)
        buf.writeEnumConstant(throwableType)
        buf.writeBoolean(disableGravity)

        return ServerPlayNetworking.createS2CPacket(PacketCompendium.SPAWN_THROWABLE_ENTITY, buf)
    }

}