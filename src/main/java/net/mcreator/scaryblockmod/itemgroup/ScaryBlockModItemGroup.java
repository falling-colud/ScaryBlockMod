
package net.mcreator.scaryblockmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.scaryblockmod.block.ScaryBlockBlock;
import net.mcreator.scaryblockmod.ScaryblockmodModElements;

@ScaryblockmodModElements.ModElement.Tag
public class ScaryBlockModItemGroup extends ScaryblockmodModElements.ModElement {
	public ScaryBlockModItemGroup(ScaryblockmodModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabscary_block_mod") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ScaryBlockBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
