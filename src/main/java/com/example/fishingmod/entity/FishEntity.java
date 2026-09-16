package com.example.fishingmod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;

public class FishEntity extends WaterAnimal {

    private LureEntity lureTarget;

    public FishEntity(EntityType<? extends FishEntity> type, Level level) {
        super(type, level);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.02F, 0.1F, true);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 6.0)
                .add(Attributes.MOVEMENT_SPEED, 0.55);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.5));
        // TODO: 接 GeckoLib 动画后，中鱼时在此切换对应游动/挣扎动画
    }
    
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    public void setLureTarget(LureEntity lure) {
        this.lureTarget = lure;
    }

    @Override
    public void tick() {
        super.tick();

        // 目标失效则放弃
        if (lureTarget != null && (!lureTarget.isAlive() || lureTarget.isRemoved())) {
            lureTarget = null;
        }

        if (lureTarget != null && this.distanceTo(lureTarget) < 8.0) {
            // 追饵：向饵的方向加速（简化版巡游 AI）
            var dir = lureTarget.position().subtract(this.position()).normalize().scale(0.06);
            this.setDeltaMovement(this.getDeltaMovement().add(dir));
            this.hasImpulse = true;
        } else if (this.random.nextInt(120) == 0) {
            // 无饵时随机游动
            double rx = (this.random.nextDouble() - 0.5) * 0.1;
            double rz = (this.random.nextDouble() - 0.5) * 0.1;
            this.setDeltaMovement(this.getDeltaMovement().add(rx, 0, rz));
        }
    }
}
