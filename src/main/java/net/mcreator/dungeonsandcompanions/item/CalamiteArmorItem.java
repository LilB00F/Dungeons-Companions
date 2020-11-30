
package net.mcreator.dungeonsandcompanions.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import net.mcreator.dungeonsandcompanions.itemgroup.CreativeCompanionModtabItemGroup;
import net.mcreator.dungeonsandcompanions.DungeonsAndCompanionsModElements;

@DungeonsAndCompanionsModElements.ModElement.Tag
public class CalamiteArmorItem extends DungeonsAndCompanionsModElements.ModElement {
	@ObjectHolder("dungeons_and_companions:calamite_armor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("dungeons_and_companions:calamite_armor_chestplate")
	public static final Item body = null;
	@ObjectHolder("dungeons_and_companions:calamite_armor_leggings")
	public static final Item legs = null;
	@ObjectHolder("dungeons_and_companions:calamite_armor_boots")
	public static final Item boots = null;
	public CalamiteArmorItem(DungeonsAndCompanionsModElements instance) {
		super(instance, 144);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 45;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{5, 10, 10, 5}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 18;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CalamiteIngotItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "calamite_armor";
			}

			public float getToughness() {
				return 3f;
			}
		};
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeCompanionModtabItemGroup.tab)) {
					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "dungeons_and_companions:textures/models/armor/calamite_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}
				}.setRegistryName("calamite_armor_helmet"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeCompanionModtabItemGroup.tab)) {
					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "dungeons_and_companions:textures/models/armor/calamite_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}
				}.setRegistryName("calamite_armor_chestplate"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeCompanionModtabItemGroup.tab)) {
					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "dungeons_and_companions:textures/models/armor/calamite_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}
				}.setRegistryName("calamite_armor_leggings"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(CreativeCompanionModtabItemGroup.tab)) {
					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "dungeons_and_companions:textures/models/armor/calamite_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}
				}.setRegistryName("calamite_armor_boots"));
	}
}
