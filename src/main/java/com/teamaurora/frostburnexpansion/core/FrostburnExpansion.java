package com.teamaurora.frostburnexpansion.core;

import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
@Mod.EventBusSubscriber(modid=FrostburnExpansion.MODID)
public class FrostburnExpansion
{
	public static final String MODID = "frostburnexpansion";
	public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);
    private static final Logger LOGGER = LogManager.getLogger();

    public FrostburnExpansion() {
    	IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		REGISTRY_HELPER.getDeferredItemRegister().register(eventBus);
		REGISTRY_HELPER.getDeferredBlockRegister().register(eventBus);
		REGISTRY_HELPER.getDeferredEntityRegister().register(eventBus);
		// features do not need to be registered: for an example as to how they work see SwampEx or Atmospheric source
		//haha lol no
		FrostburnExpansionFeatures.FEATURES.register(eventBus);
    	FrostburnExpansionBiomes.BIOMES.register(eventBus);
    	FrostburnExpansionEffects.POTION_EFFECTS.register(eventBus);
  

		eventBus.addListener(this::setup);
		DistExecutor.runWhenOn(Dist.CLIENT, ()->()->{
			eventBus.addListener(this::clientSetup);
		});
       
    }

    private void setup(final FMLCommonSetupEvent event) {
		FrostburnExpansionBiomes.registerBiomesToDictionary();
<<<<<<< Updated upstream
=======
		FrostburnExpansionBiomes.registerSpawns();
		FrostburnExpansionBlockData.registerCompostables();
		FrostburnExpansionBlockData.registerFlammables();
>>>>>>> Stashed changes
	}

	private void clientSetup(final FMLClientSetupEvent event) {

	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {

		}

		@SubscribeEvent
		public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {

		}
	}
}
