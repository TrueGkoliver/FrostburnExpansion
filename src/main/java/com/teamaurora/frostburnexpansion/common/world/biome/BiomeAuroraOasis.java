package com.teamaurora.frostburnexpansion.common.world.biome;

import java.util.Random;

import com.teamaurora.frostburnexpansion.core.registry.FrostburnExpansionFeatures;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class BiomeAuroraOasis extends Biome {
	public BiomeAuroraOasis() {
		super(new Biome.Builder()
				.precipitation(RainType.SNOW)
				.scale(0.05F)
				.category(Category.ICY)
				.temperature(-0.1F)
				.surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
				.depth(0.125F)
				.downfall(0.4F)
				.waterColor(0x967bb6)
				.waterFogColor(0x967bb6)
				.parent((String)null));
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addFreezeTopLayer(this);
		DefaultBiomeFeatures.addBlueIce(this);
		this.addStructure(Feature.IGLOO.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, FrostburnExpansionFeatures.BOREALENE_SPIKES.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
	}
	int i = 0;
	/*
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
	}*/
}
