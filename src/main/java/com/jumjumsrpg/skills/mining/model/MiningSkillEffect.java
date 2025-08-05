package com.jumjumsrpg.skills.mining.model;

public record MiningSkillEffect(
        String description,
        String effectType,
        double valuePerRank
) {
    public double getTotalEffectValue(int rank) {
        return rank * valuePerRank;
    }
}
