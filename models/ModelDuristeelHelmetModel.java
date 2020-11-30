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
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}