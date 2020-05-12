package com.placeholder.frostburnexpansion.common.world.biome;

import java.util.Random;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;

public class BiomeAuroraOasis extends Biome {
	public BiomeAuroraOasis(Builder biomeBuilder) {
		super(biomeBuilder);
		DefaultBiomeFeatures.addFreezeTopLayer(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addCarvers(this);
	}
	int i = 0;
	boolean direction = true;
	@Override
	public int getSkyColor() {
		if (direction==false&&i==0) {
			direction=true;
		}
		if (direction==true&&i==16777215) {
			direction=false;
		}
		if (direction) {
			i++;
		} else {
			i--;
		}
		
		return i;
	}
}
