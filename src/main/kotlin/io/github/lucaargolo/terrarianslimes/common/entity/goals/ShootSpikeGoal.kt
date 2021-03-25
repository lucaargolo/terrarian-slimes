package io.github.lucaargolo.terrarianslimes.common.entity.goals

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.ai.RangedAttackMob
import net.minecraft.entity.ai.goal.Goal
import net.minecraft.entity.mob.MobEntity

class ShootSpikeGoal(private val mob: MobEntity): Goal() {

    private var target: LivingEntity? = null
    private var cooldown = 100

    override fun canStart(): Boolean {
        return cooldown > 10 && mob.target?.let{
            if(it.isAlive && it.distanceTo(mob) < 12.0) {
                target = it
                true
            }else {
                false
            }
        } ?: false
    }

    override fun stop() {
        cooldown = 100
        target = null
    }

    override fun tick() {
        cooldown--
    }

    override fun start() {
        cooldown = 100
        (mob as? RangedAttackMob)?.attack(target, 1.25f)
    }

}