package com.jumjumsrpg.skills.mining.player;

import com.jumjumsrpg.skills.mining.model.MiningSkillTree;
import com.mojang.serialization.Codec;

import java.util.HashMap;
import java.util.Map;

public class MiningSkillState {
    private final Map<String, Integer> skillPoints = new HashMap<>();

    public int getPoints(String treeId) {
        return skillPoints.getOrDefault(treeId, 0);
    }

    public void setPoints(String treeId, int points) {
        skillPoints.put(treeId, points);
    }

    public Map<String, Integer> getAll() {
        return skillPoints;
    }

    // Basic codec using a map of string->int for now
    public static final Codec<MiningSkillState> CODEC = Codec.unboundedMap(
            Codec.STRING, Codec.INT
    ).xmap(MiningSkillState::fromMap, MiningSkillState::getAll);

    private static MiningSkillState fromMap(Map<String, Integer> map) {
        MiningSkillState state = new MiningSkillState();
        state.skillPoints.putAll(map);
        return state;
    }

    public int getUpgradeRank(String id, String miningSpeed) {
        return 0;
    }
}
