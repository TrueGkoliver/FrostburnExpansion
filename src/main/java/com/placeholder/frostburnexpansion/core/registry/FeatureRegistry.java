package com.placeholder.frostburnexpansion.core.registry;

import com.placeholder.frostburnexpansion.FrostburnExpansion;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureRegistry {
	public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<Feature<?>>(ForgeRegistries.FEATURES, FrostburnExpansion.MODID);

}
