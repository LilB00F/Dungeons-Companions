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
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Duristeelboots.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}