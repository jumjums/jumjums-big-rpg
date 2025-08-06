package com.jumjumsrpg.registry;

import com.jumjumsrpg.skills.mining.MiningSkillConfig;
import com.jumjumsrpg.skills.mining.effect.MiningSpeedHandler;
import com.jumjumsrpg.skills.mining.loader.MiningSkillTreeLoader;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

public class ModMining {
    public static void register() {
        // Register resource reload listener
        ResourceManagerHelper.get(ResourceType.SERVER_DATA)
                .registerReloadListener(new MiningSkillTreeLoader());
        Identifier dirtId = Registries.BLOCK.getId(Blocks.DIRT);
        MiningSkillConfig.setDropChance(dirtId, 1.0);

        MiningSpeedHandler.register();
    }
}
