package com.jumjumsrpg.skills.mining.player;

import com.jumjumsrpg.skills.mining.model.MiningSkillTree;
import com.jumjumsrpg.skills.mining.model.MiningSkillUpgrade;

import java.util.HashMap;
import java.util.Map;

public class MiningSkillState {
    // Format: treeId -> upgradeId -> rank
    private final Map<String, Map<String, Integer>> upgradeRanks = new HashMap<>();

    public int getUpgradeRank(String treeId, String upgradeId) {
        return upgradeRanks
                .getOrDefault(treeId, Map.of())
                .getOrDefault(upgradeId, 0);
    }

    public int getTotalPointsInTree(String treeId) {
        return upgradeRanks
                .getOrDefault(treeId, Map.of())
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public boolean canUpgrade(MiningSkillTree tree, String upgradeId) {
        if (!tree.hasUpgrade(upgradeId)) return false;

        MiningSkillUpgrade upgrade = tree.getUpgrade(upgradeId);
        int currentRank = getUpgradeRank(tree.id(), upgradeId);

        return currentRank < upgrade.maxRank()
                && getTotalPointsInTree(tree.id()) >= upgrade.requiredTotalPoints();
    }

    public boolean applyUpgrade(MiningSkillTree tree, String upgradeId) {
        if (!canUpgrade(tree, upgradeId)) return false;

        String treeId = tree.id();
        upgradeRanks.putIfAbsent(treeId, new HashMap<>());
        Map<String, Integer> upgrades = upgradeRanks.get(treeId);

        upgrades.put(upgradeId, upgrades.getOrDefault(upgradeId, 0) + 1);
        return true;
    }

    public Map<String, Map<String, Integer>> getAllRanks() {
        return upgradeRanks;
    }
}
