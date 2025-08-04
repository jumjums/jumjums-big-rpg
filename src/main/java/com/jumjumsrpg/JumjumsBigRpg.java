package com.jumjumsrpg;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JumjumsBigRpg implements ModInitializer {
	public static final String MOD_ID = "jumjums_big_rpg";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Jumjums Big RPG!");
		// Register items, blocks, events, etc.
	}
}
