package com.blade7777.cursedcraft.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

import com.blade7777.cursedcraft.CursedCraftModElements;
import com.blade7777.cursedcraft.CursedCraftMod;

@CursedCraftModElements.ModElement.Tag
public class CursedZombieOnEntityTickUpdateProcedure extends CursedCraftModElements.ModElement {
	public CursedZombieOnEntityTickUpdateProcedure(CursedCraftModElements instance) {
		super(instance, 41);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CursedCraftMod.LOGGER.warn("Failed to load dependency entity for procedure CursedZombieOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CursedCraftMod.LOGGER.warn("Failed to load dependency x for procedure CursedZombieOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CursedCraftMod.LOGGER.warn("Failed to load dependency y for procedure CursedZombieOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CursedCraftMod.LOGGER.warn("Failed to load dependency z for procedure CursedZombieOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CursedCraftMod.LOGGER.warn("Failed to load dependency world for procedure CursedZombieOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((world.canBlockSeeSky(new BlockPos((int) x, (int) (y + 1), (int) z)))) {
			if ((((world instanceof World) ? ((World) world).isDaytime() : false)
					&& (!(world.getWorldInfo().isRaining() || world.getWorldInfo().isThundering())))) {
				if ((!((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.WATER.getDefaultState().getBlock())
						|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.WATER.getDefaultState()
								.getBlock()))
						|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.WATER.getDefaultState().getBlock())
								|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.WATER.getDefaultState()
										.getBlock()))))) {
					if ((!(entity.isBurning()))) {
						if ((!(world.isRemote()))) {
							entity.setFire((int) 15);
						}
					}
				}
			}
			if ((world.getWorldInfo().isRaining() || world.getWorldInfo().isThundering())) {
				if ((!(world.isRemote()))) {
					entity.extinguish();
				}
			}
		}
	}
}
