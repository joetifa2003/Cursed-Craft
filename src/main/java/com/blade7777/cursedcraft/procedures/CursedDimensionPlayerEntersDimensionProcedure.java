package com.blade7777.cursedcraft.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.blade7777.cursedcraft.CursedCraftModElements;
import com.blade7777.cursedcraft.CursedCraftMod;

@CursedCraftModElements.ModElement.Tag
public class CursedDimensionPlayerEntersDimensionProcedure extends CursedCraftModElements.ModElement {
	public CursedDimensionPlayerEntersDimensionProcedure(CursedCraftModElements instance) {
		super(instance, 47);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CursedCraftMod.LOGGER.warn("Failed to load dependency entity for procedure CursedDimensionPlayerEntersDimension!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 60, (int) 1));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 1));
	}
}
