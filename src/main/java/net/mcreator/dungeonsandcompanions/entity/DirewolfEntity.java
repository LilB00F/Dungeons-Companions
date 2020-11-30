
package net.mcreator.dungeonsandcompanions.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.FollowMobGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockState;

import net.mcreator.dungeonsandcompanions.procedures.CompanionRalfThisEntityKillsAnotherOneProcedure;
import net.mcreator.dungeonsandcompanions.procedures.CompanionRalfItIsStruckByLightningProcedure;
import net.mcreator.dungeonsandcompanions.itemgroup.CreativeCompanionModtabItemGroup;
import net.mcreator.dungeonsandcompanions.DungeonsAndCompanionsModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@DungeonsAndCompanionsModElements.ModElement.Tag
public class DirewolfEntity extends DungeonsAndCompanionsModElements.ModElement {
	public static EntityType entity = null;
	public DirewolfEntity(DungeonsAndCompanionsModElements instance) {
		super(instance, 55);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(2f, 1.7999999999999998f)).build("direwolf")
						.setRegistryName("direwolf");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -6684673, -16724788, new Item.Properties().group(CreativeCompanionModtabItemGroup.tab))
				.setRegistryName("direwolf_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("mountains")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("taiga")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("frozen_river")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_tundra")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_mountains")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("taiga_hills")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("mountain_edge")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("dark_forest")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_taiga")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_taiga_hills")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("giant_tree_taiga")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("giant_tree_taiga_hills")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("wooded_mountains")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("taiga_mountains")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("ice_spikes")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_taiga_mountains")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("giant_spruce_taiga")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("giant_spruce_taiga_hills")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("modified_gravelly_mountains")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 20, 3, 5));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelDireWolfBIG(), 0.7f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("dungeons_and_companions:textures/direwolfbig.png");
				}
			};
		});
	}
	public static class CustomEntity extends TameableEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 20;
			setNoAI(false);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new FollowOwnerGoal(this, 1, (float) 8, (float) 2, false));
			this.goalSelector.addGoal(2, new OwnerHurtByTargetGoal(this));
			this.goalSelector.addGoal(3, new OwnerHurtTargetGoal(this));
			this.targetSelector.addGoal(4, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.3, false));
			this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, SkeletonEntity.class, true, true));
			this.goalSelector.addGoal(7, new FollowMobGoal(this, (float) 1, 15, 5));
			this.goalSelector.addGoal(8, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, (float) 6));
			this.goalSelector.addGoal(10, new LookAtGoal(this, ServerPlayerEntity.class, (float) 6));
			this.goalSelector.addGoal(11, new LeapAtTargetGoal(this, (float) 0.5));
			this.goalSelector.addGoal(12, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(13, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.ambient"));
		}

		@Override
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.step")), 0.15f, 1);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.howl"));
		}

		@Override
		public void onStruckByLightning(LightningBoltEntity entityLightningBolt) {
			super.onStruckByLightning(entityLightningBolt);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				CompanionRalfItIsStruckByLightningProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public boolean processInteract(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			boolean retval = true;
			Item item = itemstack.getItem();
			if (itemstack.getItem() instanceof SpawnEggItem) {
				retval = super.processInteract(sourceentity, hand);
			} else if (this.world.isRemote) {
				retval = this.isTamed() && this.isOwner(sourceentity) || this.isBreedingItem(itemstack);
			} else {
				if (this.isTamed()) {
					if (this.isOwner(sourceentity)) {
						if (item.isFood() && this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
							this.consumeItemFromStack(sourceentity, itemstack);
							this.heal((float) item.getFood().getHealing());
							retval = true;
						} else if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
							this.consumeItemFromStack(sourceentity, itemstack);
							this.heal(4);
							retval = true;
						} else {
							retval = super.processInteract(sourceentity, hand);
						}
					}
				} else if (this.isBreedingItem(itemstack)) {
					this.consumeItemFromStack(sourceentity, itemstack);
					if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
						this.setTamedBy(sourceentity);
						this.world.setEntityState(this, (byte) 7);
					} else {
						this.world.setEntityState(this, (byte) 6);
					}
					this.enablePersistence();
					retval = true;
				} else {
					retval = super.processInteract(sourceentity, hand);
					if (retval)
						this.enablePersistence();
				}
			}
			sourceentity.startRiding(this);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			return retval;
		}

		@Override
		public void onKillEntity(LivingEntity entity) {
			super.onKillEntity(entity);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity sourceentity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				CompanionRalfThisEntityKillsAnotherOneProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(15);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12);
		}

		@Override
		public AgeableEntity createChild(AgeableEntity ageable) {
			return (CustomEntity) entity.create(this.world);
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (new ItemStack(Items.MUTTON, (int) (1)).getItem() == stack.getItem())
				return true;
			return false;
		}

		@Override
		public void travel(Vec3d dir) {
			Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
			if (this.isBeingRidden()) {
				this.rotationYaw = entity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = entity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.15F;
				this.renderYawOffset = entity.rotationYaw;
				this.rotationYawHead = entity.rotationYaw;
				this.stepHeight = 1.0F;
				if (entity instanceof LivingEntity) {
					this.setAIMoveSpeed((float) this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
					float forward = ((LivingEntity) entity).moveForward;
					float strafe = ((LivingEntity) entity).moveStrafing;
					super.travel(new Vec3d(strafe, 0, forward));
				}
				this.prevLimbSwingAmount = this.limbSwingAmount;
				double d1 = this.getPosX() - this.prevPosX;
				double d0 = this.getPosZ() - this.prevPosZ;
				float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
				if (f1 > 1.0F)
					f1 = 1.0F;
				this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
				this.limbSwing += this.limbSwingAmount;
				return;
			}
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = 0.02F;
			super.travel(dir);
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelDireWolfBIG extends EntityModel<Entity> {
		private final ModelRenderer DireWolf;
		private final ModelRenderer BODY;
		private final ModelRenderer bone;
		private final ModelRenderer Tailmain_r1;
		private final ModelRenderer HEAD;
		private final ModelRenderer hornmain;
		private final ModelRenderer hornmainleft_r1;
		private final ModelRenderer hornmainright_r1;
		private final ModelRenderer hornend;
		private final ModelRenderer hornmidleft_r1;
		private final ModelRenderer hornmidright_r1;
		private final ModelRenderer hornendend;
		private final ModelRenderer LEFTLEG;
		private final ModelRenderer RIGHTLEG;
		public ModelDireWolfBIG() {
			textureWidth = 128;
			textureHeight = 128;
			DireWolf = new ModelRenderer(this);
			DireWolf.setRotationPoint(-2.0F, 24.0F, 8.0F);
			BODY = new ModelRenderer(this);
			BODY.setRotationPoint(2.0F, 0.0F, -8.0F);
			DireWolf.addChild(BODY);
			BODY.setTextureOffset(0, 0).addBox(-9.0F, -28.0F, -3.0F, 14.0F, 14.0F, 13.0F, 0.0F, false);
			BODY.setTextureOffset(0, 27).addBox(-7.5F, -27.0F, 10.0F, 11.0F, 12.0F, 15.0F, 0.0F, false);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, -14.8043F, 9.0F);
			BODY.addChild(bone);
			Tailmain_r1 = new ModelRenderer(this);
			Tailmain_r1.setRotationPoint(-2.0F, -8.9431F, 15.3932F);
			bone.addChild(Tailmain_r1);
			setRotationAngle(Tailmain_r1, -0.1745F, 0.0F, 0.0F);
			Tailmain_r1.setTextureOffset(40, 13).addBox(-1.5F, -2.5F, 0.0F, 3.0F, 3.0F, 14.0F, 0.0F, false);
			HEAD = new ModelRenderer(this);
			HEAD.setRotationPoint(2.0F, 0.0F, -8.0F);
			DireWolf.addChild(HEAD);
			HEAD.setTextureOffset(42, 44).addBox(-8.0F, -27.0F, -13.0F, 12.0F, 12.0F, 10.0F, 0.0F, false);
			HEAD.setTextureOffset(41, 0).addBox(-6.0F, -21.0F, -20.0F, 8.0F, 6.0F, 7.0F, 0.0F, false);
			HEAD.setTextureOffset(0, 6).addBox(-1.0F, -31.0F, -9.5F, 5.0F, 5.0F, 1.0F, 0.0F, false);
			HEAD.setTextureOffset(0, 0).addBox(-8.0F, -31.0F, -9.5F, 5.0F, 5.0F, 1.0F, 0.0F, false);
			hornmain = new ModelRenderer(this);
			hornmain.setRotationPoint(0.0F, -14.0F, 3.0F);
			HEAD.addChild(hornmain);
			hornmainleft_r1 = new ModelRenderer(this);
			hornmainleft_r1.setRotationPoint(3.7193F, -13.0009F, -9.7452F);
			hornmain.addChild(hornmainleft_r1);
			setRotationAngle(hornmainleft_r1, 0.5236F, 0.7854F, 0.0F);
			hornmainleft_r1.setTextureOffset(0, 54).addBox(-2.5F, -2.5F, -3.5F, 5.0F, 5.0F, 7.0F, 0.0F, false);
			hornmainright_r1 = new ModelRenderer(this);
			hornmainright_r1.setRotationPoint(-7.4786F, -12.9926F, -9.7554F);
			hornmain.addChild(hornmainright_r1);
			setRotationAngle(hornmainright_r1, -0.5236F, 2.3562F, 0.0F);
			hornmainright_r1.setTextureOffset(37, 30).addBox(-2.5F, -2.5F, -3.5F, 5.0F, 5.0F, 7.0F, 0.0F, false);
			hornend = new ModelRenderer(this);
			hornend.setRotationPoint(0.0F, 14.0F, -3.0F);
			hornmain.addChild(hornend);
			hornmidleft_r1 = new ModelRenderer(this);
			hornmidleft_r1.setRotationPoint(6.7719F, -25.9041F, -5.7529F);
			hornend.addChild(hornmidleft_r1);
			setRotationAngle(hornmidleft_r1, 0.0F, -0.3927F, -0.6109F);
			hornmidleft_r1.setTextureOffset(61, 30).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
			hornmidright_r1 = new ModelRenderer(this);
			hornmidright_r1.setRotationPoint(-10.637F, -25.6307F, -5.7231F);
			hornend.addChild(hornmidright_r1);
			setRotationAngle(hornmidright_r1, 0.0F, 0.3927F, 0.6109F);
			hornmidright_r1.setTextureOffset(60, 13).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
			hornendend = new ModelRenderer(this);
			hornendend.setRotationPoint(5.8755F, -17.3218F, 2.6242F);
			hornend.addChild(hornendend);
			hornendend.setTextureOffset(71, 18).addBox(0.6245F, -8.2782F, -13.6242F, 3.0F, 3.0F, 5.0F, 0.0F, false);
			hornendend.setTextureOffset(71, 0).addBox(-19.3755F, -8.2782F, -13.6242F, 3.0F, 3.0F, 5.0F, 0.0F, false);
			LEFTLEG = new ModelRenderer(this);
			LEFTLEG.setRotationPoint(2.0F, 0.0F, -8.0F);
			DireWolf.addChild(LEFTLEG);
			LEFTLEG.setTextureOffset(0, 66).addBox(-7.0F, -15.0F, 19.5F, 4.0F, 15.0F, 4.0F, 0.0F, false);
			LEFTLEG.setTextureOffset(56, 66).addBox(0.0F, -15.0F, -2.0F, 4.0F, 15.0F, 4.0F, 0.0F, false);
			RIGHTLEG = new ModelRenderer(this);
			RIGHTLEG.setRotationPoint(2.0F, 0.0F, -8.0F);
			DireWolf.addChild(RIGHTLEG);
			RIGHTLEG.setTextureOffset(24, 54).addBox(-1.0F, -15.0F, 19.5F, 4.0F, 15.0F, 4.0F, 0.0F, false);
			RIGHTLEG.setTextureOffset(40, 66).addBox(-8.0F, -15.0F, -2.0F, 4.0F, 15.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			DireWolf.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.HEAD.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.HEAD.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.hornmain.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.hornmain.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.hornmainleft_r1.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.hornmainleft_r1.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.hornendend.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.hornendend.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.hornmainright_r1.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.hornmainright_r1.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.hornend.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.hornend.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.hornmidleft_r1.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.hornmidleft_r1.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.hornmidright_r1.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.hornmidright_r1.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.LEFTLEG.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.RIGHTLEG.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
