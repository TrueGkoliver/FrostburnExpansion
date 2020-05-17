package com.placeholder.frostburnexpansion.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;

public class BriskEntity extends MonsterEntity {

	public BriskEntity(EntityType<? extends MonsterEntity> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
	}
	
	protected void registerAttributes() {
	      super.registerAttributes();
	      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}
	
	@Override
	protected void registerData() {
		
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return null;
	}
	

}
