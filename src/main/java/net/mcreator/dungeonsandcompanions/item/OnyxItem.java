
package net.mcreator.dungeonsandcompanions.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.dungeonsandcompanions.DungeonsAndCompanionsModElements;

@DungeonsAndCompanionsModElements.ModElement.Tag
public class OnyxItem extends DungeonsAndCompanionsModElements.ModElement {
	@ObjectHolder("dungeons_and_companions:onyx")
	public static final Item block = null;
	public OnyxItem(DungeonsAndCompanionsModElements instance) {
		super(instance, 108);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("onyx");
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
