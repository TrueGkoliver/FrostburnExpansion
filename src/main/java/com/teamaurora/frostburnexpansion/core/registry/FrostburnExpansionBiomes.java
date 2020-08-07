package com.teamaurora.frostburnexpansion.core.registry;

import com.teamaurora.frostburnexpansion.core.FrostburnExpansion;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FrostburnExpansionBiomes {
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, FrostburnExpansion.MODID);

	// NOTE: Moved biome builder into the biome class to make this class less of a clusterfuck and more of a registry

	//public static final RegistryObject<BiomeAuroraOasis> AURORA_OASIS = BIOMES.register("aurora_oasis", ()->new BiomeAuroraOasis());

	public static void registerBiomesToDictionary() {
		//BiomeManager.addBiome(BiomeType.ICY, new BiomeEntry(AURORA_OASIS.get(), 5));
		//BiomeDictionary.addTypes(AURORA_OASIS.get(), BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.RARE);
	}
	
	public static void registerSpawns() {
		//AURORA_OASIS.get().registerSpawns();
	}
}
