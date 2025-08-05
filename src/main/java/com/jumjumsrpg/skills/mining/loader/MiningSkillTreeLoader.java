package com.jumjumsrpg.skills.mining.loader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jumjumsrpg.skills.mining.model.MiningSkillTree;
import com.jumjumsrpg.skills.mining.registry.MiningSkillTreeRegistry;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MiningSkillTreeLoader extends JsonDataLoader implements IdentifiableResourceReloadListener {

    private static final Gson GSON = new Gson();
    private static final Type TYPE = new TypeToken<MiningSkillTree>() {}.getType();
    public static final Identifier ID = new Identifier("jumjumsrpg", "mining_skill_tree_loader");

    public MiningSkillTreeLoader() {
        super(GSON, "skills/mining");
    }

    @Override
    protected void apply(Map<Identifier, com.google.gson.JsonElement> jsonElements, ResourceManager resourceManager, Profiler profiler) {
        Map<Identifier, MiningSkillTree> loadedTrees = new HashMap<>();

        for (Map.Entry<Identifier, com.google.gson.JsonElement> entry : jsonElements.entrySet()) {
            Identifier id = entry.getKey();
            try {
                MiningSkillTree tree = GSON.fromJson(entry.getValue(), TYPE);
                loadedTrees.put(id, tree);
            } catch (Exception e) {
                throw new RuntimeException("Failed to load mining skill tree: " + id, e);
            }
        }

        MiningSkillTreeRegistry.load(loadedTrees);
    }

    @Override
    public Identifier getFabricId() {
        return ID;
    }
}
