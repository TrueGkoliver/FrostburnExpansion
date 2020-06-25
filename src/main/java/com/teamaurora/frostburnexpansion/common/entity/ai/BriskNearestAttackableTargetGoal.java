package com.teamaurora.frostburnexpansion.common.entity.ai;

import java.util.EnumSet;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import com.teamaurora.frostburnexpansion.common.entity.BriskEntity;

public class BriskNearestAttackableTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
	public BriskNearestAttackableTargetGoal(BriskEntity brisk, Class<T> classTarget) {
        super(brisk, classTarget, true);
     }

     /**
      * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
      * method as well.
      */
     public boolean shouldExecute() {
        boolean f = ((BriskEntity) this.goalOwner).getIsDancing();
        if (f) {
        	return false;
        }
        return super.shouldExecute();
     }

}
