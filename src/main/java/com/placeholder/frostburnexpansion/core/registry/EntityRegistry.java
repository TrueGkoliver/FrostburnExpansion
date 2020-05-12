package com.placeholder.frostburnexpansion.core.registry;

import com.placeholder.frostburnexpansion.FrostburnExpansion;

import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityRegistry {
	public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<EntityType<?>>(ForgeRegistries.ENTITIES, FrostburnExpansion.MODID);

}
