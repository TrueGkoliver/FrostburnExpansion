package com.teamaurora.frostburnexpansion.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IChargeableMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class BriskEntity extends MonsterEntity implements IChargeableMob {
	private static final DataParameter<Integer> STATE = EntityDataManager.createKey(BriskEntity.class, DataSerializers.VARINT);
	   private static final DataParameter<Boolean> POWERED = EntityDataManager.createKey(BriskEntity.class, DataSerializers.BOOLEAN);
	   private static final DataParameter<Boolean> IGNITED = EntityDataManager.createKey(BriskEntity.class, DataSerializers.BOOLEAN);
	public BriskEntity(EntityType<? extends MonsterEntity> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
	}
	
	protected void registerAttributes() {
	      super.registerAttributes();
	      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}
	
	@Override
	protected void registerData() {
		super.registerData();
	    this.dataManager.register(STATE, -1);
	    this.dataManager.register(POWERED, false);
	    this.dataManager.register(IGNITED, false);
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

	@Override
	public boolean isCharged() {
		return false;
	}
	

}
