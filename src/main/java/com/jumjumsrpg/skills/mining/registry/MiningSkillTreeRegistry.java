package com.jumjumsrpg.skills.mining.registry;

import com.jumjumsrpg.skills.mining.model.MiningSkillTree;
import net.minecraft.util.Identifier;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MiningSkillTreeRegistry {
    private static final Map<Identifier, MiningSkillTree> SKILL_TREES = new HashMap<>();

    public static void load(Map<Identifier, MiningSkillTree> loadedTrees) {
        SKILL_TREES.clear();
        SKILL_TREES.putAll(loadedTrees);
    }

    public static MiningSkillTree get(Identifier id) {
        return SKILL_TREES.get(id);
    }

    public static Map<Identifier, MiningSkillTree> getAll() {
        return Collections.unmodifiableMap(SKILL_TREES);
    }
}
