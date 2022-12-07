
package net.mcreator.scaryblockmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.block.BlockState;

import net.mcreator.scaryblockmod.itemgroup.ScaryBlockModItemGroup;
import net.mcreator.scaryblockmod.ScaryblockmodModElements;

@ScaryblockmodModElements.ModElement.Tag
public class BloodBottleItem extends ScaryblockmodModElements.ModElement {
	@ObjectHolder("scaryblockmod:blood_bottle")
	public static final Item block = null;

	public BloodBottleItem(ScaryblockmodModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ScaryBlockModItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(0).saturation(0f)

							.build()));
			setRegistryName("blood_bottle");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
