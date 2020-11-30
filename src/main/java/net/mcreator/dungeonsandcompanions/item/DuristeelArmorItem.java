
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
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.dungeonsandcompanions.itemgroup.CreativeCompanionModtabItemGroup;
import net.mcreator.dungeonsandcompanions.DungeonsAndCompanionsModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@DungeonsAndCompanionsModElements.ModElement.Tag
public class DuristeelArmorItem extends DungeonsAndCompanionsModElements.ModElement {
	@ObjectHolder("dungeons_and_companions:duristeel_armor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("dungeons_and_companions:duristeel_armor_chestplate")
	public static final Item body = null;
	@ObjectHolder("dungeons_and_companions:duristeel_armor_leggings")
	public static final Item legs = null;
	@ObjectHolder("dungeons_and_companions:duristeel_armor_boots")
	public static final Item boots = null;
	public DuristeelArmorItem(DungeonsAndCompanionsModElements instance) {
		super(instance, 139);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 50;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{5, 10, 10, 5}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 17;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DuristeelIngotItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "duristeel_armor";
			}

			public float getToughness() {
				return 3.5f;
			}
		};
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeCompanionModtabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedHead = new ModelDuristeelHelmetModel().Head;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "dungeons_and_companions:textures/models/armor/duristeelhelmtex_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}
				}.setRegistryName("duristeel_armor_helmet"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeCompanionModtabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedBody = new ModelDuristeelModelRe3().Body;
						armorModel.bipedLeftArm = new ModelDuristeelModelRe3().LeftArm;
						armorModel.bipedRightArm = new ModelDuristeelModelRe3().RightArm;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "dungeons_and_companions:textures/duristeel_layer_1.png";
					}
				}.setRegistryName("duristeel_armor_chestplate"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeCompanionModtabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedLeftLeg = new ModelDuristeelModelRe3().LeftLeg;
						armorModel.bipedRightLeg = new ModelDuristeelModelRe3().RightLeg;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "dungeons_and_companions:textures/duristeel_layer_2.png";
					}
				}.setRegistryName("duristeel_armor_leggings"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(CreativeCompanionModtabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedLeftLeg = new ModelDuristeelBootsModel().bootL;
						armorModel.bipedRightLeg = new ModelDuristeelBootsModel().bootR;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "dungeons_and_companions:textures/models/armor/duristeelhelmtex_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}
				}.setRegistryName("duristeel_armor_boots"));
	}
	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelDuristeelModelRe3 extends EntityModel<Entity> {
		private final ModelRenderer Duirsteelarmor;
		private final ModelRenderer Head;
		private final ModelRenderer Body;
		private final ModelRenderer LeftArm;
		private final ModelRenderer RightArm;
		private final ModelRenderer RightLeg;
		private final ModelRenderer LeftLeg;
		private final ModelRenderer bootL;
		private final ModelRenderer bootR;
		public ModelDuristeelModelRe3() {
			textureWidth = 128;
			textureHeight = 128;
			Duirsteelarmor = new ModelRenderer(this);
			Duirsteelarmor.setRotationPoint(0.0F, 24.0F, 0.0F);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, -24.0F, 0.0F);
			Duirsteelarmor.addChild(Head);
			Head.setTextureOffset(6, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.3F, false);
			Head.setTextureOffset(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.9F, false);
			Head.setTextureOffset(23, 23).addBox(-0.5F, -9.0F, -4.5F, 1.0F, 1.0F, 9.0F, 0.5F, false);
			Head.setTextureOffset(0, 0).addBox(-8.5F, -8.8F, -1.0F, 4.0F, 3.0F, 3.0F, 0.2F, false);
			Head.setTextureOffset(32, 0).addBox(-9.0F, -8.3F, -4.0F, 2.0F, 2.0F, 4.0F, 0.2F, false);
			Head.setTextureOffset(0, 0).addBox(4.5F, -8.8F, -1.0F, 4.0F, 3.0F, 3.0F, 0.2F, false);
			Head.setTextureOffset(32, 0).addBox(7.0F, -8.3F, -3.0F, 2.0F, 2.0F, 4.0F, 0.2F, false);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, -24.0F, 0.0F);
			Duirsteelarmor.addChild(Body);
			Body.setTextureOffset(34, 33).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.3F, false);
			Body.setTextureOffset(58, 33).addBox(-3.5F, 0.1F, -2.7F, 7.0F, 5.0F, 1.0F, 0.3F, false);
			Body.setTextureOffset(59, 40).addBox(-2.5F, 5.0F, -2.4F, 5.0F, 6.0F, 1.0F, 0.3F, false);
			LeftArm = new ModelRenderer(this);
			LeftArm.setRotationPoint(5.0F, -22.0F, 0.0F);
			Duirsteelarmor.addChild(LeftArm);
			LeftArm.setTextureOffset(75, 33).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.3F, false);
			LeftArm.setTextureOffset(93, 33).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.7F, false);
			RightArm = new ModelRenderer(this);
			RightArm.setRotationPoint(-5.0F, -22.0F, 0.0F);
			Duirsteelarmor.addChild(RightArm);
			RightArm.setTextureOffset(93, 33).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.7F, false);
			RightArm.setTextureOffset(75, 33).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.3F, false);
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(-2.0F, -12.0F, 0.0F);
			Duirsteelarmor.addChild(RightLeg);
			RightLeg.setTextureOffset(2, 58).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.3F, false);
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(1.9F, -12.0F, 0.0F);
			Duirsteelarmor.addChild(LeftLeg);
			LeftLeg.setTextureOffset(2, 58).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.3F, false);
			bootL = new ModelRenderer(this);
			bootL.setRotationPoint(0.0F, 0.0F, 0.0F);
			Duirsteelarmor.addChild(bootL);
			bootL.setTextureOffset(1, 40).addBox(-0.1F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.6F, false);
			bootR = new ModelRenderer(this);
			bootR.setRotationPoint(0.0F, 0.0F, 0.0F);
			Duirsteelarmor.addChild(bootR);
			bootR.setTextureOffset(1, 40).addBox(-3.9F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.6F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Duirsteelarmor.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelDuristeelHelmetModel extends EntityModel<Entity> {
		private final ModelRenderer Head;
		public ModelDuristeelHelmetModel() {
			textureWidth = 128;
			textureHeight = 128;
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 0.0F, 0.0F);
			Head.setTextureOffset(6, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.3F, false);
			Head.setTextureOffset(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.9F, false);
			Head.setTextureOffset(23, 23).addBox(-0.5F, -9.0F, -4.5F, 1.0F, 1.0F, 9.0F, 0.5F, false);
			Head.setTextureOffset(0, 0).addBox(-8.5F, -8.8F, -1.0F, 4.0F, 3.0F, 3.0F, 0.2F, false);
			Head.setTextureOffset(32, 0).addBox(-9.0F, -8.3F, -4.0F, 2.0F, 2.0F, 4.0F, 0.2F, false);
			Head.setTextureOffset(0, 0).addBox(4.5F, -8.8F, -1.0F, 4.0F, 3.0F, 3.0F, 0.2F, false);
			Head.setTextureOffset(32, 0).addBox(7.0F, -8.3F, -3.0F, 2.0F, 2.0F, 4.0F, 0.2F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelDuristeelBootsModel extends EntityModel<Entity> {
		private final ModelRenderer Duristeelboots;
		private final ModelRenderer bootL;
		private final ModelRenderer bootR;
		public ModelDuristeelBootsModel() {
			textureWidth = 128;
			textureHeight = 128;
			Duristeelboots = new ModelRenderer(this);
			Duristeelboots.setRotationPoint(0.0F, 24.0F, 0.0F);
			bootL = new ModelRenderer(this);
			bootL.setRotationPoint(0.0F, 0.0F, 0.0F);
			Duristeelboots.addChild(bootL);
			bootL.setTextureOffset(1, 40).addBox(-0.1F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.6F, false);
			bootR = new ModelRenderer(this);
			bootR.setRotationPoint(0.0F, 0.0F, 0.0F);
			Duristeelboots.addChild(bootR);
			bootR.setTextureOffset(1, 40).addBox(-3.9F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.6F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Duristeelboots.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
