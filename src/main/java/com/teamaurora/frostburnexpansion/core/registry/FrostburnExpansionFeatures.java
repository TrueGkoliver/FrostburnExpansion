package com.teamaurora.frostburnexpansion.core.registry;

import com.teamaurora.frostburnexpansion.common.world.feature.BorealeneSpikesFeature;
import com.teamaurora.frostburnexpansion.core.FrostburnExpansion;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.gen.feature.NoFeatureConfig;

@Mod.EventBusSubscriber(modid=FrostburnExpansion.MODID)
public class FrostburnExpansionFeatures {
	public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<Feature<?>>(ForgeRegistries.FEATURES, FrostburnExpansion.MODID);

	// do something with this idk. there's no feature registry in AbC
	public static final Feature<NoFeatureConfig> BOREALENE_SPIKES = new BorealeneSpikesFeature(NoFeatureConfig::deserialize);
	
	@SubscribeEvent
	public static void onFeatureRegistryEvent(Register<Feature<?>> event) 
	{
		BOREALENE_SPIKES.setRegistryName("borealene_spikes");
		event.getRegistry().register(BOREALENE_SPIKES);
		
	}
	
	
	
	//I'm putting this here, because there's no need to make an entirely new class.
	//NOTE
	//It's not that much right now, but I'm saving it for later.
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = new DeferredRegister<SurfaceBuilder<?>>(ForgeRegistries.SURFACE_BUILDERS, FrostburnExpansion.MODID);

}
