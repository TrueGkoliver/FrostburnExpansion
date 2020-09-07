package com.teamaurora.frostburn_expansion.core;

import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;

public class FrostburnExpansionConfig {
    public static class Common {
        public final ForgeConfigSpec.ConfigValue<Boolean> alwaysBriskSpawn;
        public final ForgeConfigSpec.ConfigValue<ArrayList<String>> briskBiomes;
        public final ForgeConfigSpec.ConfigValue<Integer> glacierWeight;

        Common(ForgeConfigSpec.Builder builder) {
            builder.comment("Common configurations for Frostburn Expansion").push("common");

            builder.comment("Brisk config options").push("brisks");
            alwaysBriskSpawn = builder.define("Whether Brisks should always spawn in place of Creepers in snowy biomes", false);
            ArrayList<String> defBriskBiomes = new ArrayList<>();
            //if (biomeIn == Biomes.SNOWY_BEACH || biomeIn == Biomes.SNOWY_MOUNTAINS || biomeIn == Biomes.SNOWY_TAIGA || biomeIn == Biomes.SNOWY_TAIGA_HILLS || biomeIn == Biomes.SNOWY_TAIGA_MOUNTAINS || biomeIn == Biomes.SNOWY_TUNDRA || biomeIn == Biomes.ICE_SPIKES) {
            defBriskBiomes.add("minecraft:snowy_beach");
            defBriskBiomes.add("minecraft:snowy_mountains");
            defBriskBiomes.add("minecraft:snowy_taiga");
            defBriskBiomes.add("minecraft:snowy_taiga_hills");
            defBriskBiomes.add("minecraft:snowy_taiga_mountains");
            defBriskBiomes.add("minecraft:snowy_tundra");
            defBriskBiomes.add("minecraft:ice_spikes");
            defBriskBiomes.add("frostburn_expansion:aurora_glacier");
            defBriskBiomes.add("frostburn_expansion:aurora_glacier_edge");
            briskBiomes = builder.define("List of biomes Brisks can spawn in", defBriskBiomes);
            builder.pop();

            glacierWeight = builder.define("Weight of Aurora Glacier biome", 5);

            builder.pop();
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;
    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}
