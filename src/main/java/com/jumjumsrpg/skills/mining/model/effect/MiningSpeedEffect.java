package com.jumjumsrpg.skills.mining.model.effect;

import net.minecraft.entity.player.PlayerEntity;

public class MiningSpeedEffect implements UpgradeEffect {

    @Override
    public void apply(PlayerEntity player, int rank) {
        // Temporary placeholder; real application logic will depend on how we modify mining speed.
        // This could involve attribute modifiers or custom hooks.
    }

    @Override
    public String describeEffect(int rank) {
        int percent = 10 * rank;
        return "Mining speed +" + percent + "%";
    }
}
