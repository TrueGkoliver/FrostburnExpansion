package com.teamaurora.frostburnexpansion.core.registry;

import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import com.teamaurora.frostburnexpansion.core.FrostburnExpansion;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
@Mod.EventBusSubscriber(modid=FrostburnExpansion.MODID)
public class FrostburnExpansionSounds {
	public static final RegistryHelper HELPER = FrostburnExpansion.REGISTRY_HELPER;
	
	public static final RegistryObject<SoundEvent> BRISK_HURT = HELPER.createSoundEvent("entity.brisk.hurt");
	public static final RegistryObject<SoundEvent> BRISK_DEATH = HELPER.createSoundEvent("entity.brisk.death");
	
	public static final SoundEvent BRISKSONG = new SoundEvent(new ResourceLocation(FrostburnExpansion.MODID, "music.record.brisksong")).setRegistryName("music.record.brisksong");
	@SubscribeEvent
	public static void onSoundEventRegister(Register<SoundEvent> event) {
		event.getRegistry().register(BRISKSONG);
	}

}
