package com.jumjumsrpg.skills.mining;

import net.minecraft.util.Identifier;
import java.util.HashMap;
import java.util.Map;

public class MiningSkillConfig {
    // Map block identifier → drop chance (0.0–1.0)
    private static final Map<Identifier, Double> dropChances = new HashMap<>();

    // Registers or updates a block’s drop chance
    public static void setDropChance(Identifier blockId, double chance) {
        dropChances.put(blockId, chance);
    }

    public static double getDropChance(Identifier blockId) {
        return dropChances.getOrDefault(blockId, 0.0);
    }
}
