package com.jumjumsrpg;

import com.jumjumsrpg.registry.ModDataComponents;
import com.jumjumsrpg.registry.ModEvents;
import com.jumjumsrpg.registry.ModItems;
import com.jumjumsrpg.registry.ModMining;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JumjumsBigRpg implements ModInitializer {
	public static final String MOD_ID = "jumjums_big_rpg";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		LOGGER.info("Initializing Jumjums Big RPG!");
		// Register items, blocks, events, etc.
		ModDataComponents.register();
		ModMining.register();
		ModEvents.register();

	}
}
