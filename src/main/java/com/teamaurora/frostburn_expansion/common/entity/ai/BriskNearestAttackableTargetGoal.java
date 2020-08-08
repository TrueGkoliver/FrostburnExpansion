package com.teamaurora.frostburn_expansion.common.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import com.teamaurora.frostburn_expansion.common.entity.BriskEntity;

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
