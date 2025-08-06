package com.jumjumsrpg;

import com.jumjumsrpg.client.gui.MiningSkillScreenButton;
import com.jumjumsrpg.item.MiningSkillPointItem;
import com.jumjumsrpg.registry.ModDataComponents;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class JumjumsBigRpgClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		JumjumsBigRpg.LOGGER.info("Initializing client-side features for Jumjums Big RPG.");

		// Tooltip logic
		ItemTooltipCallback.EVENT.register((ItemStack stack, Item.TooltipContext context, TooltipContext type, List<Text> lines) -> {
			if (stack.getItem() instanceof MiningSkillPointItem) {
				String material = stack.get(ModDataComponents.MINING_MATERIAL);
				if (material != null && !material.isEmpty()) {
					lines.add(Text.literal("Used for advancing " + capitalize(material) + " mining abilities").formatted(Formatting.GRAY));
				} else {
					lines.add(Text.literal("Unassigned Mining XP").formatted(Formatting.RED));
				}
			}
		});

		// Add skill button to InventoryScreen
		ScreenEvents.AFTER_INIT.register((client, screen, w, h) -> {
			if (screen instanceof InventoryScreen inv) {
				inv.addDrawableChild(new MiningSkillScreenButton(inv.x + 5, inv.y + 5));
			}
		});
	}

	private static String capitalize(String word) {
		if (word == null || word.isEmpty()) return "";
		return Character.toUpperCase(word.charAt(0)) + word.substring(1);
	}
}
