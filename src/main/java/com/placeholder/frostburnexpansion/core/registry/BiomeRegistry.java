package com.placeholder.frostburnexpansion.core.registry;

import com.placeholder.frostburnexpansion.FrostburnExpansion;
import com.placeholder.frostburnexpansion.common.world.biome.BiomeAuroraOasis;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Builder;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeRegistry {
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<Biome>(ForgeRegistries.BIOMES, FrostburnExpansion.MODID);
	
	public static Biome.Builder B_OASIS = new Biome.Builder()
			.precipitation(RainType.SNOW)
			.scale(1F)
			.category(Category.ICY)
			.temperature(-0.1F)
			.surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
			.depth(0.5F)
			.downfall(0.4F)
			.waterColor(0x967bb6)
			.waterFogColor(0x967bb6)
			.parent((String)null);
	
	
	public static final RegistryObject<Biome> AURORA_OASIS = BIOMES.register("aurora_oasis", ()->new BiomeAuroraOasis(B_OASIS));
}
