package com.teamaurora.frostburnexpansion.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;

public class BrassCreeperEntity extends MonsterEntity {

	public BrassCreeperEntity(EntityType<? extends MonsterEntity> entityTypeIn, World worldIn) {
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
