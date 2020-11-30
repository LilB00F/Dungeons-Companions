// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends EntityModel<Entity> {
	private final ModelRenderer bear;
	private final ModelRenderer legright;
	private final ModelRenderer legleft;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer bone;
	private final ModelRenderer ear1_r1;
	private final ModelRenderer ear2_r1;

	public Modelcustom_model() {
		textureWidth = 64;
		textureHeight = 64;

		bear = new ModelRenderer(this);
		bear.setRotationPoint(0.0F, 24.0F, 0.0F);

		legright = new ModelRenderer(this);
		legright.setRotationPoint(0.0F, 0.0F, 0.0F);
		bear.addChild(legright);
		legright.setTextureOffset(0, 46).addBox(-4.5F, -6.0F, -8.5F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		legright.setTextureOffset(17, 46).addBox(0.4F, -7.0F, 5.5F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		legleft = new ModelRenderer(this);
		legleft.setRotationPoint(0.0F, 0.0F, 0.0F);
		bear.addChild(legleft);
		legleft.setTextureOffset(0, 46).addBox(0.5F, -6.0F, -8.5F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		legleft.setTextureOffset(17, 46).addBox(-4.4F, -7.0F, 5.5F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		bear.addChild(body);
		body.setTextureOffset(0, 17).addBox(-5.0F, -16.0F, -9.0F, 10.0F, 10.0F, 7.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-4.5F, -15.3F, -2.0F, 9.0F, 9.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(0, 34).addBox(-4.5F, -14.6F, 6.0F, 9.0F, 8.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-1.0F, -12.4F, 9.2F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		bear.addChild(head);
		head.setTextureOffset(29, 29).addBox(-4.0F, -15.0F, -14.0F, 8.0F, 8.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(26, 0).addBox(-3.0F, -11.3F, -18.0F, 6.0F, 4.0F, 4.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -11.0F, 3.0F);
		head.addChild(bone);

		ear1_r1 = new ModelRenderer(this);
		ear1_r1.setRotationPoint(3.1079F, -3.5834F, -2.5F);
		bone.addChild(ear1_r1);
		setRotationAngle(ear1_r1, 0.0F, 0.0F, 0.3927F);
		ear1_r1.setTextureOffset(0, 4).addBox(-1.5F, -1.5F, -12.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		ear2_r1 = new ModelRenderer(this);
		ear2_r1.setRotationPoint(-3.1079F, -3.5834F, -2.5F);
		bone.addChild(ear2_r1);
		setRotationAngle(ear2_r1, 0.0F, 0.0F, -0.3927F);
		ear2_r1.setTextureOffset(0, 4).addBox(-1.5F, -1.5F, -12.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bear.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.legright.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.legleft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}