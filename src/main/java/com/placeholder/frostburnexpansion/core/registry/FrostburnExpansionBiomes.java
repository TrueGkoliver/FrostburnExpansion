package com.placeholder.frostburnexpansion.core.registry;

import com.placeholder.frostburnexpansion.core.FrostburnExpansion;
import com.placeholder.frostburnexpansion.common.world.biome.BiomeAuroraOasis;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FrostburnExpansionBiomes {
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<Biome>(ForgeRegistries.BIOMES, FrostburnExpansion.MODID);

	// NOTE: Moved biome builder into the biome class to make this class less of a clusterfuck and more of a registry

	public static final RegistryObject<Biome> AURORA_OASIS = BIOMES.register("aurora_oasis", ()->new BiomeAuroraOasis());

	public static void registerBiomesToDictionary() {
		// biome dictionary stuff here
	}
}
