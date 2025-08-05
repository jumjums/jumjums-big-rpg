package com.jumjumsrpg.skills.mining;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jumjumsrpg.JumjumsBigRpg;
import com.jumjumsrpg.skills.mining.model.MiningSkillTree;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

import java.io.InputStreamReader;
import java.util.Map;

public class MiningSkillTreeLoader {
    private static final Gson GSON = new GsonBuilder().create();
    private static final String PATH = "skills/mining";

    public static void register() {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA)
                .registerReloadListener(new SimpleSynchronousResourceReloadListener() {
                    @Override
                    public Identifier getFabricId() {
                        return new Identifier(JumjumsBigRpg.MOD_ID, "mining_skill_tree_loader");
                    }

                    @Override
                    public void reload(ResourceManager manager) {
                        MiningSkillTreeRegistry.clear();

                        for (Map.Entry<Identifier, net.minecraft.resource.Resource> entry :
                                manager.findResources(PATH, path -> path.getPath().endsWith(".json")).entrySet()) {
                            try (InputStreamReader reader = new InputStreamReader(entry.getValue().getInputStream())) {
                                MiningSkillTree tree = GSON.fromJson(reader, MiningSkillTree.class);
                                MiningSkillTreeRegistry.register(tree);
                            } catch (Exception e) {
                                JumjumsBigRpg.LOGGER.error("Failed to load mining skill tree from " + entry.getKey(), e);
                            }
                        }

                        JumjumsBigRpg.LOGGER.info("Loaded {} mining skill trees.",
                                MiningSkillTreeRegistry.all().spliterator().getExactSizeIfKnown());
                    }
                });
    }
}
