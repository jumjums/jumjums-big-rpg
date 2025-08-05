package com.jumjumsrpg.skills.mining;

import com.jumjumsrpg.skills.mining.model.MiningSkillTree;

import java.util.HashMap;
import java.util.Map;

public class MiningSkillTreeRegistry {
    private static final Map<String, MiningSkillTree> TREES = new HashMap<>();

    public static void register(MiningSkillTree tree) {
        TREES.put(tree.id, tree);
    }

    public static MiningSkillTree get(String id) {
        return TREES.get(id);
    }

    public static Iterable<MiningSkillTree> all() {
        return TREES.values();
    }

    public static void clear() {
        TREES.clear();
    }
}
