package com.example.fishingmod.entity;

import com.example.fishingmod.FishingMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;

import java.util.List;

public class LureEntity extends ThrowableItemProjectile {

    private int life = 0;

    public LureEntity(EntityType<? extends LureEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected Item getDefaultItem() {
        return FishingMod.FISHING_ROD.get();
    }

    @Override
    public void tick() {
        super.tick();
        life++;

        if (level().isClientSide) return;

        // 在水中：缓慢下沉（米诺可改成上浮；VIB 匀速下沉）
        if (isInWater()) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0, 0.92, 1.0).add(0, -0.008, 0));
            this.hasImpulse = true;
        }

        // 诱鱼：6 格内的鱼把本饵设为目标
        AABB attractBox = this.getBoundingBox().inflate(6.0);
        List<FishEntity> nearby = level().getEntitiesOfClass(FishEntity.class, attractBox);
        for (FishEntity fish : nearby) {
            fish.setLureTarget(this);
        }

        // 咬钩判定：1.2 格内有鱼 → 上鱼，掉落渔获
        AABB biteBox = this.getBoundingBox().inflate(1.2);
        List<FishEntity> biters = level().getEntitiesOfClass(FishEntity.class, biteBox);
        if (!biters.isEmpty()) {
            FishEntity caught = biters.get(0);
            caught.discard();
            ItemEntity drop = new ItemEntity(level(), getX(), getY(), getZ(),
                    new ItemStack(FishingMod.BASS.get()));
            level().addFreshEntity(drop);
            this.discard();
            return;
        }

        // 60 秒未咬钩自动回收
        if (life > 1200) {
            this.discard();
        }
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        // 撞上方块后停住（饵留在原地继续诱鱼），超时回收见 life 上限
    }
}
