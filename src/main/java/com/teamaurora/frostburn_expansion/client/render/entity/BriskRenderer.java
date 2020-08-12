package com.teamaurora.frostburn_expansion.client.render.entity;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.teamaurora.frostburn_expansion.client.model.entity.BriskModel;
import com.teamaurora.frostburn_expansion.common.entity.BriskEntity;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class BriskRenderer extends MobRenderer<BriskEntity, BriskModel<BriskEntity>>{
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(FrostburnExpansion.MODID+":textures/entity/brisk.png");
	public BriskRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new BriskModel<BriskEntity>(), 0.5F);
		this.addLayer(new BriskChargeLayer(this));
	}
	@Override
	protected void preRenderCallback(BriskEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
	      float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);
	      float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
	      f = MathHelper.clamp(f, 0.0F, 1.0F);
	      f = f * f;
	      f = f * f;
	      float f2 = (1.0F + f * 0.4F) * f1;
	      float f3 = (1.0F + f * 0.1F) / f1;
	      matrixStackIn.scale(f2, f3, f2);
	   }

	   protected float getOverlayProgress(BriskEntity livingEntityIn, float partialTicks) {
	      float f = livingEntityIn.getCreeperFlashIntensity(partialTicks);
	      return (int)(f * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(f, 0.5F, 1.0F);
	   }
	@Override
	public ResourceLocation getEntityTexture(BriskEntity entity) {
		// TODO Auto-generated method stub
		return TEXTURE;
	}

}
