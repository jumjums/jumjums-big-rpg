package com.jumjums.rpg.client;

import net.fabricmc.api.ClientModInitializer;
import com.jumjums.rpg.JumjumsBigRpg;

public class JumjumsBigRpgClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		JumjumsBigRpg.LOGGER.info("Initializing client-side features for Jumjums Big RPG.");
		// Register renderers, GUIs, client events, etc.
	}
}
