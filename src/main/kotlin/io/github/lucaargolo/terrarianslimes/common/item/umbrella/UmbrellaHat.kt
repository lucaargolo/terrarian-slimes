package io.github.lucaargolo.terrarianslimes.common.item.umbrella

import io.github.lucaargolo.terrarianslimes.common.item.ItemCompendium
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvents

class UmbrellaHat(settings: Settings): ArmorItem(object : ArmorMaterial {
    override fun getRepairIngredient() = Ingredient.ofItems(ItemCompendium.UMBRELLA)
    override fun getToughness() = 1.0F
    override fun getKnockbackResistance() = 0F
    override fun getEquipSound() = SoundEvents.ITEM_ARMOR_EQUIP_GENERIC
    override fun getName() = "umbrella"
    override fun getDurability(slot: EquipmentSlot) = 0
    override fun getEnchantability() = 9
    override fun getProtectionAmount(slot: EquipmentSlot?) = 2
}, EquipmentSlot.HEAD, settings)