// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelspearmodel extends EntityModel<Entity> {
	private final ModelRenderer group;
	private final ModelRenderer tiptip_r1;

	public Modelspearmodel() {
		textureWidth = 64;
		textureHeight = 64;

		group = new ModelRenderer(this);
		group.setRotationPoint(-8.0F, 21.0F, 8.0F);
		setRotationAngle(group, -0.7854F, 0.0F, 0.0F);

		tiptip_r1 = new ModelRenderer(this);
		tiptip_r1.setRotationPoint(0.0F, 1.0F, 0.0F);
		group.addChild(tiptip_r1);
		setRotationAngle(tiptip_r1, -0.7854F, 0.0F, 0.0F);
		tiptip_r1.setTextureOffset(9, 9).addBox(8.0F, 5.0F, -14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		tiptip_r1.setTextureOffset(0, 0).addBox(8.0F, 4.5F, -13.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		tiptip_r1.setTextureOffset(0, 0).addBox(8.0F, 4.0F, -12.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		tiptip_r1.setTextureOffset(6, 7).addBox(8.0F, 4.5F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		tiptip_r1.setTextureOffset(6, 0).addBox(7.0F, 4.0F, -7.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		tiptip_r1.setTextureOffset(0, 0).addBox(8.0F, 5.0F, -6.0F, 1.0F, 1.0F, 19.0F, 0.0F, false);
		tiptip_r1.setTextureOffset(0, 7).addBox(7.5F, 4.5F, 13.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		group.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}