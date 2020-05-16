package com.teamaurora.frostburnexpansion.core;

import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.teamaurora.frostburnexpansion.core.registry.FrostburnExpansionBiomes;

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

    	FrostburnExpansionBiomes.BIOMES.register(eventBus);
		MinecraftForge.EVENT_BUS.register(this);

		eventBus.addListener(this::setup);
		DistExecutor.runWhenOn(Dist.CLIENT, ()->()->{
			eventBus.addListener(this::clientSetup);
		});
       
    }

    private void setup(final FMLCommonSetupEvent event) {
		FrostburnExpansionBiomes.registerBiomesToDictionary();
	}

	private void clientSetup(final FMLClientSetupEvent event) {

	}
}
