package com.jumjumsrpg.skills.mining.model.effect;

import net.minecraft.entity.player.PlayerEntity;

public interface UpgradeEffect {
    /**
     * Apply the effect to the player, based on the rank.
     */
    void apply(PlayerEntity player, int rank);

    /**
     * Returns a display string or stat preview for UI/debugging.
     */
    String describeEffect(int rank);
}
