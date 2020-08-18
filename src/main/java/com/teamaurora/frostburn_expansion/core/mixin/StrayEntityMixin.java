package com.teamaurora.frostburn_expansion.core.mixin;

import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StrayEntity.class)
public abstract class StrayEntityMixin extends AbstractSkeletonEntity {

    protected StrayEntityMixin(EntityType<? extends AbstractSkeletonEntity> entity, World world) {
        super(entity, world);
    }

    @Shadow
    protected SoundEvent getStepSound() {
        return SoundEvents.ENTITY_STRAY_STEP;
    }

    @Inject(at = @At("HEAD"), method = "fireArrow(Lnet/minecraft/item/ItemStack;F)Lnet/minecraft/entity/projectile/AbstractArrowEntity;", cancellable = true)
    protected void fireArrow(ItemStack arrowStack, float distanceFactor, CallbackInfoReturnable<AbstractArrowEntity> cir) {
        AbstractArrowEntity abstractarrowentity = super.fireArrow(arrowStack, distanceFactor);
        if (abstractarrowentity instanceof ArrowEntity) {
            if (world.rand.nextBoolean()) {
                ((ArrowEntity) abstractarrowentity).addEffect(new EffectInstance(Effects.SLOWNESS, 600));
            } else {
                ((ArrowEntity) abstractarrowentity).addEffect(new EffectInstance(FrostburnExpansionEffects.FRAILTY.get(), 600));
            }
        }
        System.out.println("mixin fired");
        cir.setReturnValue(abstractarrowentity);
    }
}
