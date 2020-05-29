package com.teamaurora.frostburnexpansion.client.render.entity;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class BriskModel<T extends Entity> extends SegmentedModel<T> {

	@Override
	public Iterable<ModelRenderer> getParts() {
		return null;
	}

	@Override
	public void setRotationAngles(T arg0, float arg1, float arg2, float arg3, float arg4, float arg5) {
		
	}

}
