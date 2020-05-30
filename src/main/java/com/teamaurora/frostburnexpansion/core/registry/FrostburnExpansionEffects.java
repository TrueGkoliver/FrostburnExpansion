package com.teamaurora.frostburnexpansion.core.registry;

import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import com.teamaurora.frostburnexpansion.common.effect.FralityEffect;
import com.teamaurora.frostburnexpansion.core.FrostburnExpansion;

import net.minecraft.potion.Effect;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FrostburnExpansionEffects {

	public static final DeferredRegister<Effect> POTION_EFFECTS = new DeferredRegister<Effect>(ForgeRegistries.POTIONS, FrostburnExpansion.MODID);

	public static final RegistryObject<FralityEffect> FRALITY = POTION_EFFECTS.register("fraility", ()->new FralityEffect());
}
