package com.teamaurora.frostburnexpansion.client.model.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.teamabnormals.abnormals_core.core.library.endimator.EndimatorEntityModel;
import com.teamabnormals.abnormals_core.core.library.endimator.EndimatorModelRenderer;
import com.teamaurora.frostburnexpansion.common.entity.BriskEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class BriskModel<T extends BriskEntity> extends EndimatorEntityModel<T> {

	private final EndimatorModelRenderer head;
	private final EndimatorModelRenderer body;
	private final EndimatorModelRenderer leg1;
	private final EndimatorModelRenderer leg2;
	private final EndimatorModelRenderer leg3;
	private final EndimatorModelRenderer leg4;

	public BriskModel() {
		textureWidth = 48;
		textureHeight = 48;

		head = new EndimatorModelRenderer(this);
		head.setRotationPoint(0.0F, 6.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(0, 32).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);
		
		body = new EndimatorModelRenderer(this);
		body.setRotationPoint(0.0F, 6.0F, 0.0F);
		body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		
		leg1 = new EndimatorModelRenderer(this);
		leg1.setRotationPoint(2.0F, 18.0F, 4.0F);
		leg1.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		
		leg2 = new EndimatorModelRenderer(this);
		leg2.setRotationPoint(-2.0F, 18.0F, 4.0F);
		leg2.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		
		leg3 = new EndimatorModelRenderer(this);
		leg3.setRotationPoint(2.0F, 18.0F, -4.0F);
		leg3.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		
		leg4 = new EndimatorModelRenderer(this);
		leg4.setRotationPoint(-2.0F, 18.0F, -4.0F);
		leg4.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		this.setDefaultBoxValues();
	
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		super.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		leg1.render(matrixStack, buffer, packedLight, packedOverlay);
		leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg3.render(matrixStack, buffer, packedLight, packedOverlay);
		leg4.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T arg0, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setRotationAngles(arg0, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}
	
	@Override
	public void animateModel(T endimatedEntity) {
		super.animateModel(endimatedEntity);
		if(this.tryToPlayEndimation(BriskEntity.DANCE)) {
			this.startKeyframe(20);
			this.rotate(head, 0, 0, (float) Math.toRadians(30));
			this.endKeyframe();
			this.startKeyframe(40);
			this.rotate(head, 0, 0, (float) Math.toRadians(-30));
			this.endKeyframe();
			this.startKeyframe(60);
			this.rotate(head, 0, 0, (float) Math.toRadians(0));
			this.endKeyframe();
			this.startKeyframe(0);
			this.endKeyframe();
		}
	}

}
