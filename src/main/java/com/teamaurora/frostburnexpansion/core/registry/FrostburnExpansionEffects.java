package com.teamaurora.frostburnexpansion.core.registry;

import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import com.teamaurora.frostburnexpansion.common.effect.FralityEffect;
import com.teamaurora.frostburnexpansion.core.FrostburnExpansion;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FrostburnExpansionEffects {

	public static final DeferredRegister<Effect> POTION_EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, FrostburnExpansion.MODID);
	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, FrostburnExpansion.MODID);
	public static final RegistryObject<FralityEffect> FRALITY = POTION_EFFECTS.register("fraility", ()->new FralityEffect());
	
	public static final RegistryObject<Potion> POTION_FRALITY = POTIONS.register("fraility", ()->new Potion(new EffectInstance(FRALITY.get(), 3600)));
	public static final RegistryObject<Potion> POTION_FRALITY_LONG = POTIONS.register("long_fraility", ()->new Potion(new EffectInstance(FRALITY.get(), 9600)));
	public static final RegistryObject<Potion> POTION_FRALITY_STRONG = POTIONS.register("strong_fraility", ()->new Potion(new EffectInstance(FRALITY.get(), 1800, 1)));
}
