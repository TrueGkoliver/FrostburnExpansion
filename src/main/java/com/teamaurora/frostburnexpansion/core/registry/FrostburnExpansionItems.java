package com.teamaurora.frostburnexpansion.core.registry;

import com.teamaurora.frostburnexpansion.core.FrostburnExpansion;

import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FrostburnExpansion.MODID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class FrostburnExpansionItems {

	public static final RegistryHelper HELPER = FrostburnExpansion.REGISTRY_HELPER;
	//Add items here
	public static final RegistryObject<Item> BRISK_SPAWN_EGG = HELPER.createSpawnEggItem("brisk", ()->FrostburnExpansionEntities.BRISK.get(), 0x84D6DB, 0x359289);

}
