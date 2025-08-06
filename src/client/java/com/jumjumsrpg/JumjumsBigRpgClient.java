package com.jumjumsrpg;

import com.jumjumsrpg.client.gui.MiningSkillScreenButton;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;

public class JumjumsBigRpgClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		JumjumsBigRpg.LOGGER.info("Initializing client-side features for Jumjums Big RPG.");

		Screens.register(InventoryScreen.class, (inv, add) -> {
			add.accept(new MiningSkillScreenButton(inv.getX() + 5, inv.getY() + 5));
		});
	}
}
