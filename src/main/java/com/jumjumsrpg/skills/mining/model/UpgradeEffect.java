package com.jumjumsrpg.skills.mining.model;

public class UpgradeEffect {
    private String type;       // "additive" or "multiplicative"
    private double value;      // e.g. 0.1 for 10%
    private String target;     // e.g. "mining_speed", "stack_size"

    // Required for Gson
    public UpgradeEffect() {}

    public String getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public String getTarget() {
        return target;
    }
}
