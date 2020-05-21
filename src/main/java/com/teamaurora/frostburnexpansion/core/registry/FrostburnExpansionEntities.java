package com.teamaurora.frostburnexpansion.core.registry;

import com.teamaurora.frostburnexpansion.core.FrostburnExpansion;

import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = FrostburnExpansion.MODID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class FrostburnExpansionEntities {
	public static final RegistryHelper HELPER = FrostburnExpansion.REGISTRY_HELPER;

	// Put RegistryObjects here

	@OnlyIn(Dist.CLIENT)
	public static void registerRendering() {
		// Put RenderingRegistry shit here
	}

	public static void addEntitySpawns() {
		ForgeRegistries.BIOMES.getValues().stream().forEach(FrostburnExpansionEntities::processSpawning);
	}

	private static void processSpawning(Biome biome) {
		// Process entity spawning here
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
		// Register entities into EntitySpawnPlacementRegistry
	}
}
