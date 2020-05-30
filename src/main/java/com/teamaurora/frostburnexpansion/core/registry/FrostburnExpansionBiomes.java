package com.teamaurora.frostburnexpansion.core.registry;

import com.teamaurora.frostburnexpansion.core.FrostburnExpansion;
import com.teamaurora.frostburnexpansion.common.world.biome.BiomeAuroraOasis;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FrostburnExpansionBiomes {
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<Biome>(ForgeRegistries.BIOMES, FrostburnExpansion.MODID);

	// NOTE: Moved biome builder into the biome class to make this class less of a clusterfuck and more of a registry

	public static final RegistryObject<BiomeAuroraOasis> AURORA_OASIS = BIOMES.register("aurora_oasis", ()->new BiomeAuroraOasis());

	public static void registerBiomesToDictionary() {
		// biome dictionary stuff here
	}
	
	public static void registerSpawns() {
		AURORA_OASIS.get().registerSpawns();
	}
}
