
package net.mcreator.dungeonsandcompanions.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.dungeonsandcompanions.itemgroup.CreativeCompanionModtabItemGroup;
import net.mcreator.dungeonsandcompanions.DungeonsAndCompanionsModElements;

@DungeonsAndCompanionsModElements.ModElement.Tag
public class MageTokenItem extends DungeonsAndCompanionsModElements.ModElement {
	@ObjectHolder("dungeons_and_companions:mage_token")
	public static final Item block = null;
	public MageTokenItem(DungeonsAndCompanionsModElements instance) {
		super(instance, 173);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(CreativeCompanionModtabItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("mage_token");
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
