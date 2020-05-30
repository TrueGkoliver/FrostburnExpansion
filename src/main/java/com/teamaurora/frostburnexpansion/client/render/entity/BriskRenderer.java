package com.teamaurora.frostburnexpansion.client.render.entity;


import com.teamaurora.frostburnexpansion.client.model.entity.BriskModel;
import com.teamaurora.frostburnexpansion.common.entity.BriskEntity;
import com.teamaurora.frostburnexpansion.core.FrostburnExpansion;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BriskRenderer extends MobRenderer<BriskEntity, BriskModel<BriskEntity>>{
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(FrostburnExpansion.MODID+":textures/entity/brisk.png");
	public BriskRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new BriskModel<BriskEntity>(), 0.5F);
	}
	@Override
	public ResourceLocation getEntityTexture(BriskEntity entity) {
		// TODO Auto-generated method stub
		return TEXTURE;
	}

}
