package com.teamaurora.frostburnexpansion.common.entity;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import com.teamaurora.frostburnexpansion.common.entity.ai.BriskSwellGoal;
import com.teamaurora.frostburnexpansion.core.registry.FrostburnExpansionEffects;

import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IChargeableMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.CreeperSwellGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
/**
 * Brisk
 * @author mostly mojang lol
 *
 */
public class BriskEntity extends MonsterEntity implements IChargeableMob {
	private static final DataParameter<Integer> STATE = EntityDataManager.createKey(BriskEntity.class, DataSerializers.VARINT);
	   private static final DataParameter<Boolean> POWERED = EntityDataManager.createKey(BriskEntity.class, DataSerializers.BOOLEAN);
	   private static final DataParameter<Boolean> IGNITED = EntityDataManager.createKey(BriskEntity.class, DataSerializers.BOOLEAN);
	   private int lastActiveTime;
	   private int timeSinceIgnited;
	   private int fuseTime = 30;
	   private int explosionRadius = 3;
	   private int droppedSkulls;
	   
	   
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
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(2, new BriskSwellGoal(this));
		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, OcelotEntity.class, 6.0F, 1.0D, 1.2D));
		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, CatEntity.class, 6.0F, 1.0D, 1.2D));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
	      this.dataManager.set(POWERED, compound.getBoolean("powered"));
	      if (compound.contains("Fuse", 99)) {
	         this.fuseTime = compound.getShort("Fuse");
	      }

	      if (compound.contains("ExplosionRadius", 99)) {
	         this.explosionRadius = compound.getByte("ExplosionRadius");
	      }

	      if (compound.getBoolean("ignited")) {
	         this.ignite();
	      }
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
	      if (this.dataManager.get(POWERED)) {
	         compound.putBoolean("powered", true);
	      }

	      compound.putShort("Fuse", (short)this.fuseTime);
	      compound.putByte("ExplosionRadius", (byte)this.explosionRadius);
	      compound.putBoolean("ignited", this.hasIgnited());
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return super.createSpawnPacket();
	}

	@Override
	public boolean isCharged() {
		return this.dataManager.get(POWERED);
	}
	public int getMaxFallHeight() {
	      return this.getAttackTarget() == null ? 3 : 3 + (int)(this.getHealth() - 1.0F);
	}

   public boolean onLivingFall(float distance, float damageMultiplier) {
      boolean flag = super.onLivingFall(distance, damageMultiplier);
      this.timeSinceIgnited = (int)((float)this.timeSinceIgnited + distance * 1.5F);
      if (this.timeSinceIgnited > this.fuseTime - 5) {
         this.timeSinceIgnited = this.fuseTime - 5;
      }

      return flag;
   }
	public int getCreeperState() {
	      return this.dataManager.get(STATE);
	   }

	   /**
	    * Sets the state of creeper, -1 to idle and 1 to be 'in fuse'
	    */
	   public void setCreeperState(int state) {
	      this.dataManager.set(STATE, state);
	   }

	   /**
	    * Called when a lightning bolt hits the entity.
	    */
	   public void onStruckByLightning(LightningBoltEntity lightningBolt) {
	      super.onStruckByLightning(lightningBolt);
	      this.dataManager.set(POWERED, true);
	   }
	   public void ignite() {
		   this.dataManager.set(IGNITED, true);
	   }
	   @Override
	   protected boolean processInteract(PlayerEntity player, Hand hand) {
	      ItemStack itemstack = player.getHeldItem(hand);
	      if (itemstack.getItem() == Items.FLINT_AND_STEEL) {
	         this.world.playSound(player, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ITEM_FLINTANDSTEEL_USE, this.getSoundCategory(), 0.5F, this.rand.nextFloat() * 0.4F + 0.8F);
	         if (!this.world.isRemote) {
	            this.ignite();
	            itemstack.damageItem(1, player, (p_213625_1_) -> {
	               p_213625_1_.sendBreakAnimation(hand);
	            });
	         }
	
	         return true;
	      } else {
	         return super.processInteract(player, hand);
	      }
	   }

	   /**
	    * Creates an explosion as determined by this creeper's power and explosion radius.
	    */
	   private void explode() {
	      if (!this.world.isRemote) {
	         Explosion.Mode explosion$mode = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this) ? Explosion.Mode.NONE : Explosion.Mode.NONE;
	 		
	         
	         
	         float f = this.getPowered() ? 1.5F : 0.75F;
	         List<LivingEntity> bi = world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(this.getPosition()).grow(f*5));
	         BlockPos pos = this.getPosition();
	         Stream<BlockPos> b = BlockPos.getAllInBox(pos.add(-2, -2, -2), pos.add(2, 2, 2));
	         Iterator<BlockPos> iter = b.iterator();
	         this.world.playSound(Minecraft.getInstance().player, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.BLOCK_SNOW_PLACE, this.getSoundCategory(), 1.0F, this.rand.nextFloat() * 0.4F + 0.8F);
	         while(iter.hasNext()) {
	        	 BlockPos poser = iter.next();
	        	 if (poser.withinDistance(pos, 2)) {
	        		 if (world.isAirBlock(poser) && world.getBlockState(poser.down()).isSolid() && world.getBlockState(poser.down()).getBlock()!=Blocks.SNOW) {
	        			 world.setBlockState(poser, Blocks.SNOW.getDefaultState().with(SnowBlock.LAYERS, new Random().nextInt(1)+1));
	        		 } else if (world.getBlockState(poser).getBlock() == Blocks.SNOW) {
	        			 int i = world.getBlockState(poser).get(SnowBlock.LAYERS);
	        			 if (i==7) {
	        				 
	        			 } else if (new Random().nextBoolean()){
	        				 i++;
	        			 }
	        			 world.setBlockState(poser, world.getBlockState(poser).with(SnowBlock.LAYERS, i));
	        		 }
	        	 }
	         }
	         for (LivingEntity entity : bi) {
	        	 if (entity instanceof BriskEntity) {
	        		 
	        	 } else {
	        		 if (entity.isPotionActive(FrostburnExpansionEffects.FRALITY.get())) {
		        		 int lv = entity.getActivePotionEffect(FrostburnExpansionEffects.FRALITY.get()).getAmplifier();
		        		 if ((!this.getPowered() && lv==4)||(this.getPowered() && lv==7)) {
		        			 
		        		 } else {
		        			 EffectInstance i = new EffectInstance(FrostburnExpansionEffects.FRALITY.get(), 3600, entity.getActivePotionEffect(FrostburnExpansionEffects.FRALITY.get()).getAmplifier()+1);
		        			 entity.addPotionEffect(i);
		        		 }
		        	 } else {
		        		 System.out.println(entity.toString());
		        		 entity.addPotionEffect(new EffectInstance(FrostburnExpansionEffects.FRALITY.get(), 3600, 0));
		        	 }
	        	 }
	   
	         }
	         this.dead = true;
	         this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), (float)this.explosionRadius * f, explosion$mode);
	         this.remove();
	         this.spawnLingeringCloud();
	      }

	   }
	   

	   @Override
	protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
		return SoundEvents.ENTITY_CREEPER_HURT;
	}
	   @Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_CREEPER_DEATH;
	}
	   private void spawnLingeringCloud() {
	      Collection<EffectInstance> collection = this.getActivePotionEffects();
	      if (!collection.isEmpty()) {
	         AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ());
	         areaeffectcloudentity.setRadius(2.5F);
	         areaeffectcloudentity.setRadiusOnUse(-0.5F);
	         areaeffectcloudentity.setWaitTime(10);
	         areaeffectcloudentity.setDuration(areaeffectcloudentity.getDuration() / 2);
	         areaeffectcloudentity.setRadiusPerTick(-areaeffectcloudentity.getRadius() / (float)areaeffectcloudentity.getDuration());
	
	         for(EffectInstance effectinstance : collection) {
	            areaeffectcloudentity.addEffect(new EffectInstance(effectinstance));
	         }
	
	         this.world.addEntity(areaeffectcloudentity);
	      }
	
	   }
   public void tick() {
      if (this.isAlive()) {
         this.lastActiveTime = this.timeSinceIgnited;
         if (this.hasIgnited()) {
            this.setCreeperState(1);
         }

         int i = this.getCreeperState();
         if (i > 0 && this.timeSinceIgnited == 0) {
            this.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
         }

         this.timeSinceIgnited += i;
         if (this.timeSinceIgnited < 0) {
            this.timeSinceIgnited = 0;
         }

         if (this.timeSinceIgnited >= this.fuseTime) {
            this.timeSinceIgnited = this.fuseTime;
            this.explode();
         }
      }
      super.tick();
   }
   @OnlyIn(Dist.CLIENT)
   public float getCreeperFlashIntensity(float partialTicks) {
      return MathHelper.lerp(partialTicks, (float)this.lastActiveTime, (float)this.timeSinceIgnited) / (float)(this.fuseTime - 2);
   }
	      
  public boolean hasIgnited() {
      return this.dataManager.get(IGNITED);
   }
   public boolean getPowered() {
	      return this.dataManager.get(POWERED);
   }
   @Override
	public boolean attackEntityAsMob(Entity entityIn) {
		return true;
	}
	

}
