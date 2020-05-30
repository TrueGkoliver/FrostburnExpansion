package com.teamaurora.frostburnexpansion.core.event;

import com.teamaurora.frostburnexpansion.core.registry.FrostburnExpansionEntities;
import com.teamaurora.frostburnexpansion.core.FrostburnExpansion;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
@Mod.EventBusSubscriber(modid=FrostburnExpansion.MODID, bus=Bus.MOD, value=Dist.CLIENT)
public class ClientEvents {
	@SubscribeEvent
	public static void onClientSetup(final FMLClientSetupEvent event) {
		FrostburnExpansionEntities.registerRendering();
	}
}
