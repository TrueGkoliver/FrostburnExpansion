package com.teamaurora.frostburn_expansion.core.registry;

import com.teamaurora.frostburn_expansion.common.world.gen.feature.OlenyaTreeFeature;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.registries.ForgeRegistries;

public class FrostburnExpansionFeatures {

    public static final Feature<BaseTreeFeatureConfig> OLENYA_TREE = new OlenyaTreeFeature(BaseTreeFeatureConfig.CODEC_BASE_TREE_FEATURE_CONFIG);

    public static void generateFeatures() {
        ForgeRegistries.BIOMES.forEach(FrostburnExpansionFeatures::generate);
    }

    public static void generate(Biome biome) {
        if (biome == Biomes.SNOWY_TUNDRA || biome == Biomes.SNOWY_MOUNTAINS) {
            DefaultBiomeFeatures.addSparseBerryBushes(biome);
            DefaultBiomeFeatures.addSparseBerryBushes(biome);
            DefaultBiomeFeatures.addSparseBerryBushes(biome);
        } else if (biome == Biomes.SNOWY_TAIGA || biome == Biomes.SNOWY_TAIGA_HILLS || biome == Biomes.SNOWY_TAIGA_MOUNTAINS) {
            DefaultBiomeFeatures.addSparseBerryBushes(biome);
            DefaultBiomeFeatures.addSparseBerryBushes(biome);
            DefaultBiomeFeatures.addSparseBerryBushes(biome);
            DefaultBiomeFeatures.addSparseBerryBushes(biome);
        }
    }
}
