package com.teamaurora.frostburn_expansion.core;

import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import com.teamaurora.frostburn_expansion.common.entity.BriskEntity;
import com.teamaurora.frostburn_expansion.core.other.FrostburnExpansionData;
import com.teamaurora.frostburn_expansion.core.other.FrostburnExpansionRender;
import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionEntities;
import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionFeatures;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionBiomes;
import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionEffects;

@Mod(FrostburnExpansion.MODID)
@Mod.EventBusSubscriber(modid=FrostburnExpansion.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("deprecation")
public class FrostburnExpansion {
	public static final String MODID = "frostburn_expansion";
	public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);
	private static final Logger LOGGER = LogManager.getLogger();

	public FrostburnExpansion() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		REGISTRY_HELPER.getDeferredItemRegister().register(eventBus);
		REGISTRY_HELPER.getDeferredBlockRegister().register(eventBus);
		REGISTRY_HELPER.getDeferredEntityRegister().register(eventBus);
		REGISTRY_HELPER.getDeferredSoundRegister().register(eventBus);

		FrostburnExpansionBiomes.BIOMES.register(eventBus);
		FrostburnExpansionEffects.POTION_EFFECTS.register(eventBus);
		FrostburnExpansionEffects.POTIONS.register(eventBus);


		eventBus.addListener(this::setup);
		DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
			eventBus.addListener(this::clientSetup);
		});

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FrostburnExpansionConfig.COMMON_SPEC);
	}

	private void setup(final FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(() -> {
			FrostburnExpansionBiomes.registerBiomesToDictionary();
			FrostburnExpansionData.registerCompostables();
			FrostburnExpansionData.registerFlammables();
			FrostburnExpansionEffects.registerBrewingRecipes();
			FrostburnExpansionFeatures.generateFeatures();
			GlobalEntityTypeAttributes.put(FrostburnExpansionEntities.BRISK.get(), BriskEntity.setCustomAttributes().create());
		});
	}

	private void clientSetup(final FMLClientSetupEvent event) {
		DeferredWorkQueue.runLater(() -> {
			FrostburnExpansionRender.setupRenderLayer();
		});
	}

}
