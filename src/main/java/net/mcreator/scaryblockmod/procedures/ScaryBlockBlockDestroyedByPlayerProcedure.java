package net.mcreator.scaryblockmod.procedures;

import net.mcreator.scaryblockmod.item.BloodBottleItem;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.scaryblockmod.block.ScaryBlockBlock;
import net.mcreator.scaryblockmod.ScaryblockmodMod;

import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import static net.minecraft.stats.Stats.CUSTOM;

public class ScaryBlockBlockDestroyedByPlayerProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBlockBreak(BlockEvent.BreakEvent event) {
			Entity entity = event.getPlayer();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("xpAmount", event.getExpToDrop());
			dependencies.put("x", event.getPos().getX());
			dependencies.put("y", event.getPos().getY());
			dependencies.put("z", event.getPos().getZ());
			dependencies.put("px", entity.getPosX());
			dependencies.put("py", entity.getPosY());
			dependencies.put("pz", entity.getPosZ());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getState());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					ScaryblockmodMod.LOGGER.warn("Failed to load dependency world for procedure ScaryBlockBlockDestroyedByPlayer!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					ScaryblockmodMod.LOGGER.warn("Failed to load dependency x for procedure ScaryBlockBlockDestroyedByPlayer!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					ScaryblockmodMod.LOGGER.warn("Failed to load dependency y for procedure ScaryBlockBlockDestroyedByPlayer!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					ScaryblockmodMod.LOGGER.warn("Failed to load dependency z for procedure ScaryBlockBlockDestroyedByPlayer!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					ScaryblockmodMod.LOGGER.warn("Failed to load dependency entity for procedure ScaryBlockBlockDestroyedByPlayer!");
				return;
			}
				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");
				Entity entity = (Entity) dependencies.get("entity");
double r = 0;List<Object> blocks = new ArrayList<>();
		if (ScaryBlockBlock.block == (world.getBlockState(new BlockPos(x,y,z))).getBlock()) {if (!((entity instanceof PlayerEntity)?((PlayerEntity)entity).abilities.isCreativeMode:false)) {if(dependencies.get("event")!=null){
	Object _obj = dependencies.get("event");
	if(_obj instanceof Event) {
		Event _evt = (Event) _obj;
		if(_evt.isCancelable())
			_evt.setCanceled(true);
	}
}r = Math.random();if (r<=0.1) {blocks.add(Items.IRON_HELMET);blocks.add(Items.IRON_CHESTPLATE);blocks.add(Items.IRON_LEGGINGS);blocks.add(Items.IRON_BOOTS);blocks.add(Items.STONE_SWORD);blocks.add(Items.STONE_SHOVEL);blocks.add(Items.STONE_PICKAXE);blocks.add(Items.STONE_AXE);blocks.add(Items.STONE_HOE);blocks.add(Items.ZOMBIE_HEAD);blocks.add(Blocks.ZOMBIE_HEAD);blocks.add(Blocks.SKELETON_SKULL);blocks.add(Items.ROTTEN_FLESH);blocks.add(Blocks.WITHER_ROSE);blocks.add(BloodBottleItem.block);if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack((IItemProvider) blocks.get((int) (MathHelper.nextInt(new Random(), 0, (int)(blocks.size()-1))))));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}else{blocks.add(Blocks.REDSTONE_BLOCK);blocks.add(Blocks.NETHERRACK);blocks.add(Blocks.SOUL_SAND);blocks.add(Blocks.COBWEB);blocks.add(Blocks.COARSE_DIRT);if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack((IItemProvider) blocks.get((int) (MathHelper.nextInt(new Random(), 0, (int)(blocks.size()-1))))));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}}}
	}
}
