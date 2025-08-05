package com.jumjumsrpg.skills.mining.player;

import net.minecraft.entity.player.PlayerEntity;

import java.util.WeakHashMap;

/**
 * Temporary provider for accessing per-player MiningSkillState.
 * Will be replaced with NBT-backed storage later.
 */
public class MiningSkillStateProvider {
    private static final WeakHashMap<PlayerEntity, MiningSkillState> STATE_MAP = new WeakHashMap<>();

    public static MiningSkillState get(PlayerEntity player) {
        return STATE_MAP.computeIfAbsent(player, p -> new MiningSkillState());
    }

    public static void set(PlayerEntity player, MiningSkillState state) {
        STATE_MAP.put(player, state);
    }
}
