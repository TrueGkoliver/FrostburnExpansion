package com.teamaurora.frostburnexpansion.core;

import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import com.teamaurora.frostburnexpansion.core.other.FrostburnExpansionBlockData;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.teamaurora.frostburnexpansion.core.registry.FrostburnExpansionBiomes;
import com.teamaurora.frostburnexpansion.core.registry.FrostburnExpansionEffects;
import com.teamaurora.frostburnexpansion.core.registry.FrostburnExpansionFeatures;

@Mod(FrostburnExpansion.MODID)
@Mod.EventBusSubscriber(modid=FrostburnExpansion.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("deprecation")
public class FrostburnExpansion {
	public static final String MODID = "frostburnexpansion";
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

	}

	private void setup(final FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(() -> {
			FrostburnExpansionBiomes.registerBiomesToDictionary();
			FrostburnExpansionBlockData.registerCompostables();
			FrostburnExpansionBlockData.registerFlammables();
		});
	}

	private void clientSetup(final FMLClientSetupEvent event) {
		DeferredWorkQueue.runLater(() -> {
			FrostburnExpansionBlockData.setupRenderLayer();
		});
	}

}
