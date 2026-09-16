package com.example.fishingmod.item;

import com.example.fishingmod.FishingMod;
import com.example.fishingmod.entity.LureEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FishingRodItem extends Item {

    public FishingRodItem(Properties properties) {
        super(properties);
    }

    // 按住右键开始蓄力（和弓一样）
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    // 松开右键：按蓄力时长抛出拟饵
    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeCharged) {
        if (!(entity instanceof Player player)) return;
        int charge = this.getUseDuration(stack) - timeCharged;
        float power = Math.min(1.0F, charge / 20.0F); // 1 秒蓄满

        if (!level.isClientSide) {
            LureEntity lure = new LureEntity(FishingMod.LURE.get(), level);
            lure.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
            // 蓄力越足，抛得越远、越准
            lure.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F,
                    0.8F + 1.6F * power, 2.0F * (1.0F - power) + 0.2F);
            level.addFreshEntity(lure);
            level.playSound(null, player.blockPosition(), SoundEvents.FISHING_BOBBER_THROW,
                    SoundSource.PLAYERS, 0.5F, 0.4F / (level.random.nextFloat() * 0.4F + 0.8F));
        }
    }
}
