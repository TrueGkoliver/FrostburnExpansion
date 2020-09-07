package com.teamaurora.frostburn_expansion.core.registry;

import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import com.teamaurora.frostburn_expansion.common.world.biome.AuroraGlacierBiome;
import com.teamaurora.frostburn_expansion.common.world.biome.AuroraGlacierEdgeBiome;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;

import com.teamaurora.frostburn_expansion.core.FrostburnExpansionConfig;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = FrostburnExpansion.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FrostburnExpansionBiomes {
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, FrostburnExpansion.MODID);

	public static final RegistryObject<Biome> AURORA_GLACIER = BIOMES.register("aurora_glacier", AuroraGlacierBiome::new);
	public static final RegistryObject<Biome> AURORA_GLACIER_EDGE = BIOMES.register("aurora_glacier_edge", AuroraGlacierEdgeBiome::new);

	public static void registerBiomesToDictionary() {
		BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(AURORA_GLACIER.get(), FrostburnExpansionConfig.COMMON.glacierWeight.get()));
	}

	public static void addBiomeTypes() {
		BiomeDictionary.addTypes(AURORA_GLACIER.get(), BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.RARE);
	}
}
