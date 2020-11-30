// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelDuirsteelarmorRE extends EntityModel<Entity> {
	private final ModelRenderer Duirsteelarmor;
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer bootL;
	private final ModelRenderer bootR;

	public ModelDuirsteelarmorRE() {
		textureWidth = 128;
		textureHeight = 128;

		Duirsteelarmor = new ModelRenderer(this);
		Duirsteelarmor.setRotationPoint(0.0F, 24.0F, 0.0F);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -24.0F, 0.0F);
		Duirsteelarmor.addChild(Head);
		Head.setTextureOffset(6, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Head.setTextureOffset(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.6F, false);
		Head.setTextureOffset(23, 23).addBox(-0.5F, -9.0F, -4.5F, 1.0F, 1.0F, 9.0F, 0.2F, false);
		Head.setTextureOffset(0, 0).addBox(-7.5F, -8.8F, -1.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(32, 0).addBox(-8.0F, -8.5F, -3.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		Head.setTextureOffset(0, 0).addBox(3.5F, -8.8F, -1.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(32, 0).addBox(6.0F, -8.5F, -3.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -24.0F, 0.0F);
		Duirsteelarmor.addChild(Body);
		Body.setTextureOffset(34, 33).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(58, 33).addBox(-3.5F, 0.1F, -2.7F, 7.0F, 5.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(59, 40).addBox(-2.5F, 5.0F, -2.4F, 5.0F, 6.0F, 1.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, -22.0F, 0.0F);
		Duirsteelarmor.addChild(LeftArm);
		LeftArm.setTextureOffset(75, 33).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		LeftArm.setTextureOffset(93, 33).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.4F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, -22.0F, 0.0F);
		Duirsteelarmor.addChild(RightArm);
		RightArm.setTextureOffset(93, 33).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.4F, false);
		RightArm.setTextureOffset(75, 33).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-2.0F, -12.0F, 0.0F);
		Duirsteelarmor.addChild(RightLeg);
		RightLeg.setTextureOffset(2, 58).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, -12.0F, 0.0F);
		Duirsteelarmor.addChild(LeftLeg);
		LeftLeg.setTextureOffset(2, 58).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		bootL = new ModelRenderer(this);
		bootL.setRotationPoint(0.0F, 0.0F, 0.0F);
		Duirsteelarmor.addChild(bootL);
		bootL.setTextureOffset(1, 40).addBox(-0.1F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.3F, false);

		bootR = new ModelRenderer(this);
		bootR.setRotationPoint(0.0F, 0.0F, 0.0F);
		Duirsteelarmor.addChild(bootR);
		bootR.setTextureOffset(1, 40).addBox(-3.9F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.3F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Duirsteelarmor.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}