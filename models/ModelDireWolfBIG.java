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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		DireWolf.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
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