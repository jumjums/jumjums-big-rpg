package com.jumjumsrpg.skills.mining.model;

import java.util.Map;

public record MiningSkillTree(
        String id,
        String displayName,
        int requiredTotalPoints,
        Map<String, MiningSkillUpgrade> upgrades
) {
    public MiningSkillUpgrade getUpgrade(String upgradeId) {
        return upgrades.get(upgradeId);
    }

    public boolean hasUpgrade(String upgradeId) {
        return upgrades.containsKey(upgradeId);
    }

    public int getMaxRank(String upgradeId) {
        MiningSkillUpgrade upgrade = upgrades.get(upgradeId);
        return upgrade != null ? upgrade.maxRank() : 0;
    }

    public int getCostPerRank(String upgradeId) {
        MiningSkillUpgrade upgrade = upgrades.get(upgradeId);
        return upgrade != null ? upgrade.cost().amount() : 0;
    }

    public int getRequiredTotalPoints(String upgradeId) {
        MiningSkillUpgrade upgrade = upgrades.get(upgradeId);
        return upgrade != null ? upgrade.requiredTotalPoints() : 0;
    }
}
