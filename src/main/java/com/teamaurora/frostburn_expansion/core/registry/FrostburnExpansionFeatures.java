package com.teamaurora.frostburn_expansion.core.registry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraftforge.registries.ForgeRegistries;

public class FrostburnExpansionFeatures {

    public static void generateFeatures() {
        ForgeRegistries.BIOMES.forEach(FrostburnExpansionFeatures::generate);
    }

    public static void generate(Biome biome) {
        if (biome == Biomes.SNOWY_TUNDRA || biome == Biomes.SNOWY_MOUNTAINS) {
            DefaultBiomeFeatures.addSparseBerryBushes(biome);
        }
    }
}
