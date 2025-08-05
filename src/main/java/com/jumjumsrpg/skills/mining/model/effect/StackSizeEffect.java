package com.jumjumsrpg.skills.mining.model.effect;

import net.minecraft.entity.player.PlayerEntity;

public class StackSizeEffect implements UpgradeEffect {

    @Override
    public void apply(PlayerEntity player, int rank) {
        // Placeholder; actual stack size logic would likely affect inventory management.
    }

    @Override
    public String describeEffect(int rank) {
        return "Dirt stack size +" + (64 * rank);
    }
}
