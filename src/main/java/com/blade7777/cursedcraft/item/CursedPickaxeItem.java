
package com.blade7777.cursedcraft.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import com.blade7777.cursedcraft.itemgroup.CursedCraftItemGroup;
import com.blade7777.cursedcraft.CursedCraftModElements;

@CursedCraftModElements.ModElement.Tag
public class CursedPickaxeItem extends CursedCraftModElements.ModElement {
	@ObjectHolder("cursed_craft:cursed_pickaxe")
	public static final Item block = null;
	public CursedPickaxeItem(CursedCraftModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2000;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CursedGemItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(CursedCraftItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("cursed_pickaxe"));
	}
}
