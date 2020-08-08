package com.teamaurora.frostburn_expansion.client.render.entity;

import com.teamaurora.frostburn_expansion.client.model.entity.BriskModel;
import com.teamaurora.frostburn_expansion.common.entity.BriskEntity;

import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.EnergyLayer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class BriskChargeLayer extends EnergyLayer<BriskEntity, BriskModel<BriskEntity>> {
	public BriskChargeLayer(IEntityRenderer<BriskEntity, BriskModel<BriskEntity>> p_i226038_1_) {
		super(p_i226038_1_);
		// TODO Auto-generated constructor stub
	}

	private final BriskModel<BriskEntity> briskModel = new BriskModel<>();
	private static final ResourceLocation LIGHTNING_TEXTURE = new ResourceLocation(
			"textures/entity/creeper/creeper_armor.png");

	protected float func_225634_a_(float p_225634_1_) {
		return p_225634_1_ * 0.01F;
	}

	protected ResourceLocation func_225633_a_() {
		return LIGHTNING_TEXTURE;
	}

	@Override
	protected EntityModel<BriskEntity> func_225635_b_() {
		// TODO Auto-generated method stub
		return this.briskModel;
	}
}
