package com.placeholder.frostburnexpansion;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod(FrostburnExpansion.MODID)
@Mod.EventBusSubscriber(modid=FrostburnExpansion.MODID)
public class FrostburnExpansion
{
	public static final String MODID = "frostburnexpansion";
    private static final Logger LOGGER = LogManager.getLogger();

    public FrostburnExpansion() {
    	IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	eventBus.addListener(this::setup);
       
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }
}
