package com.jumjumsrpg.skills.mining.model;

import java.util.List;

public class MiningSkillTree {
    private String id;
    private String display_name;
    private List<MiningSkillUpgrade> upgrades;

    // Required for Gson
    public MiningSkillTree() {}

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return display_name;
    }

    public List<MiningSkillUpgrade> getUpgrades() {
        return upgrades;
    }

    public MiningSkillUpgrade getUpgradeById(String upgradeId) {
        for (MiningSkillUpgrade upgrade : upgrades) {
            if (upgrade.getId().equals(upgradeId)) {
                return upgrade;
            }
        }
        return null;
    }
}
