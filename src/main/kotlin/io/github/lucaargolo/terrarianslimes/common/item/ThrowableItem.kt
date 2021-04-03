package io.github.lucaargolo.terrarianslimes.common.item

import io.github.lucaargolo.terrarianslimes.common.entity.throwable.ThrowableEntity
import net.minecraft.entity.EntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.util.math.MathHelper
import net.minecraft.world.World

class ThrowableItem(private val throwableEntity: EntityType<ThrowableEntity>, val throwableType: ThrowableEntity.Type, settings: Settings): Item(settings) {

    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        val stack = user.getStackInHand(hand)
        val throwable = throwableEntity.create(world) ?: return TypedActionResult.pass(stack)
        if(!world.isClient) {
            throwable.setPos(user.x, user.eyeY - 0.1, user.z)
            throwable.owner = user
            throwable.throwableType = throwableType
            val target = user.raycast(4.5, 0f, false).pos
            val velocityX = target.x - user.x
            val velocityY = target.y - throwable.y
            val velocityZ = target.z - user.z
            val h = MathHelper.sqrt(velocityX * velocityX + velocityZ * velocityZ).toDouble()
            throwable.setVelocity(velocityX, velocityY + h * 0.2, velocityZ, 1.0f, 0f)
            world.spawnEntity(throwable)
            world.playSound(user, user.blockPos, SoundEvents.ENTITY_HOSTILE_SPLASH, SoundCategory.PLAYERS, 1.0f, 0.4f / (world.random.nextFloat() * 0.4f + 0.8f))
        }
        return TypedActionResult.success(stack)
    }

}