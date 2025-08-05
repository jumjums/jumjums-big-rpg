package com.jumjumsrpg;

import com.jumjumsrpg.registry.ModDataComponents;
import com.jumjumsrpg.registry.ModItems;
import com.jumjumsrpg.skills.mining.effect.MiningSpeedHandler;
import com.jumjumsrpg.skills.mining.registry.MiningSkillTreeRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jumjumsrpg.skills.mining.loader.MiningSkillTreeLoader;

public class JumjumsBigRpg implements ModInitializer {
	public static final String MOD_ID = "jumjums_big_rpg";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		LOGGER.info("Initializing Jumjums Big RPG!");
		MiningSkillTreeRegistry.getAll().forEach((id, tree) -> {});
		// Register items, blocks, events, etc.
		ModDataComponents.register();
		// Register resource reload listener for mining skill trees
		ResourceManagerHelper.get(ResourceType.SERVER_DATA)
				.registerReloadListener(new MiningSkillTreeLoader());
		MiningSpeedHandler.register();

	}
}
