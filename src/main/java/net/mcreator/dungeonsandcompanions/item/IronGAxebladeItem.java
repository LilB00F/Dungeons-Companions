
package net.mcreator.dungeonsandcompanions.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.dungeonsandcompanions.DungeonsAndCompanionsModElements;

@DungeonsAndCompanionsModElements.ModElement.Tag
public class IronGAxebladeItem extends DungeonsAndCompanionsModElements.ModElement {
	@ObjectHolder("dungeons_and_companions:iron_g_axeblade")
	public static final Item block = null;
	public IronGAxebladeItem(DungeonsAndCompanionsModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("iron_g_axeblade");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
