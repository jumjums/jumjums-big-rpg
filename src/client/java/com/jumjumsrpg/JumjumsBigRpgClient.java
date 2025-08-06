package com.jumjumsrpg;

import com.jumjumsrpg.client.gui.MiningSkillScreenButton;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;


public class JumjumsBigRpgClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		JumjumsBigRpg.LOGGER.info("Client initialize");

		ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
			String screenName = screen.getClass().getSimpleName();
			if (screenName.contains("Crafting") || screenName.contains("CraftingTable")) {
				int x = 5;
				int y = 5;
				Screens.getButtons(screen).add(new MiningSkillScreenButton(x, y));
			}
		});

	}

	private static String capitalize(String w) {
		if (w == null || w.isEmpty()) return "";
		return Character.toUpperCase(w.charAt(0)) + w.substring(1);
	}
}
