package com.jumjumsrpg.skills.mining.model;

import com.jumjumsrpg.skills.mining.model.MiningSkillEffect;
import java.util.List;

public record MiningSkillUpgrade(
        String id,
        String displayName,
        String description,
        SkillCost cost,
        int maxRank,
        int requiredTotalPoints,
        List<MiningSkillEffect> effects
) {
    public boolean canUnlock(int currentTotalPoints) {
        return currentTotalPoints >= requiredTotalPoints;
    }

    public MiningSkillEffect getEffectByType(String effectType) {
        return effects.stream()
                .filter(effect -> effect.effectType().equalsIgnoreCase(effectType))
                .findFirst()
                .orElse(null);
    }

    public double getTotalEffectValue(String effectType, int rank) {
        MiningSkillEffect effect = getEffectByType(effectType);
        return effect != null ? effect.getTotalEffectValue(rank) : 0;
    }
}
