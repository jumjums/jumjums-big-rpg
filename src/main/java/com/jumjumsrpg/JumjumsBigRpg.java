package com.jumjumsrpg;

import com.jumjumsrpg.registry.ModDataComponents;
import com.jumjumsrpg.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jumjumsrpg.skills.mining.MiningSkillTreeLoader;

public class JumjumsBigRpg implements ModInitializer {
	public static final String MOD_ID = "jumjums_big_rpg";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		LOGGER.info("Initializing Jumjums Big RPG!");
		// Register items, blocks, events, etc.
		ModDataComponents.register();
		MiningSkillTreeLoader.register();

	}
}
