package com.jumjumsrpg.skills.mining.model;

public class MiningSkillUpgrade {
    private String id;
    private String display_name;
    private int cost;
    private int max_rank;
    private int required_total_points;
    private UpgradeEffect effect;

    // Required for Gson
    public MiningSkillUpgrade() {}

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return display_name;
    }

    public int getCost() {
        return cost;
    }

    public int getMaxRank() {
        return max_rank;
    }

    public int getRequiredTotalPoints() {
        return required_total_points;
    }

    public UpgradeEffect getEffect() {
        return effect;
    }
}
