package io.github.lucaargolo.terrarianslimes.common.item

import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.mob.MobEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.Formatting
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class SummonableItem(private val entityType: EntityType<*>, settings: Settings): Item(settings) {

    override fun appendTooltip(stack: ItemStack?, world: World?, tooltip: MutableList<Text>, context: TooltipContext?) {
        super.appendTooltip(stack, world, tooltip, context)
        tooltip.add(TranslatableText("tooltip.terrarianslimes.summonable", entityType.name).formatted(Formatting.DARK_PURPLE, Formatting.ITALIC))
    }

    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        val stack = user.getStackInHand(hand)
        if(!world.isClient) {
            if (!user.abilities.creativeMode) {
                stack.decrement(1)
            }
            val entity = entityType.create(world) as? MobEntity ?: return TypedActionResult.consume(stack)
            (world as? ServerWorld)?.let { serverWorld ->
                entity.initialize(serverWorld, world.getLocalDifficulty(user.blockPos), SpawnReason.SPAWN_EGG, null, null)
            }
            entity.refreshPositionAndAngles(user.x, user.y, user.z, 0.0f, 0.0f)
            world.spawnEntity(entity)
            user.sendMessage(TranslatableText("chat.terrarianslimes.summonable_awoken", entity.displayName).formatted(Formatting.DARK_PURPLE), false)
        }
        return TypedActionResult.consume(stack)
    }

}