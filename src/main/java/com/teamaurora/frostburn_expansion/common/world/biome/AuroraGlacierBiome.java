package com.teamaurora.frostburn_expansion.common.world.biome;

import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionBiomes;
import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class AuroraGlacierBiome extends Biome {
    public AuroraGlacierBiome() {
        super(new Biome.Builder()
                .surfaceBuilder(FrostburnExpansionFeatures.GLACIER, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
                .precipitation(RainType.SNOW).category(Category.ICY)
                .depth(0.45F)
                .scale(0.3F)
                .temperature(0.0F)
                .downfall(0.5F)
                .func_235097_a_((new BiomeAmbience.Builder())
                        .setWaterColor(4159204)
                        .setWaterFogColor(329011)
                        .setFogColor(12638463)
                        .setMoodSound(MoodSoundAmbience.field_235027_b_)
                        .build())
                .parent((String)null));

        DefaultBiomeFeatures.func_235196_b_(this);
        this.func_235063_a_(DefaultBiomeFeatures.RUINED_PORTAL_MOUNTAIN);
        DefaultBiomeFeatures.addCarvers(this);
        //DefaultBiomeFeatures.addLakes(this);
        DefaultBiomeFeatures.addMonsterRooms(this);
        DefaultBiomeFeatures.addStoneVariants(this);
        FrostburnExpansionBiomeFeatures.addIceVariants(this);
        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addSedimentDisks(this);
        //DefaultBiomeFeatures.addScatteredSpruceTrees(this);
        FrostburnExpansionBiomeFeatures.addAuroralTrees(this);
        DefaultBiomeFeatures.addDefaultFlowers(this);
        DefaultBiomeFeatures.addSparseGrass(this);
        DefaultBiomeFeatures.addMushrooms(this);
        DefaultBiomeFeatures.addReedsAndPumpkins(this);
        DefaultBiomeFeatures.addSprings(this);
        FrostburnExpansionBiomeFeatures.addGlacierFreezeTopLayer(this);
        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.RABBIT, 10, 2, 3));
        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.POLAR_BEAR, 1, 1, 2));
        this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 20, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.STRAY, 80, 4, 4));
    }

    @Override
    public Biome getEdge(INoiseRandom rand, Biome northBiome, Biome westBiome, Biome southBiome, Biome eastBiome) {
        if (northBiome == this && westBiome == this && southBiome == this && eastBiome == this) {
            return null;
        } else {
            return FrostburnExpansionBiomes.AURORA_GLACIER_EDGE.get();
        }
    }
}
