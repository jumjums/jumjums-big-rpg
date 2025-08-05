package com.jumjumsrpg;

import com.jumjumsrpg.registry.ModDataComponents;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.client.item.TooltipType;
import net.minecraft.item.Item;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import com.jumjumsrpg.item.MiningSkillPointItem;


public class JumjumsBigRpgClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		JumjumsBigRpg.LOGGER.info("Initializing client-side features for Jumjums Big RPG.");

		// Correctly scoped: inside the initializer
		ItemTooltipCallback.EVENT.register((ItemStack stack, Item.TooltipContext context, TooltipType type, List<Text> lines) -> {
			if (stack.getItem() instanceof MiningSkillPointItem) {
				String material = stack.get(ModDataComponents.MINING_MATERIAL);
				if (material != null && !material.isEmpty()) {
					lines.add(Text.literal("Used for advancing " + capitalize(material) + " mining abilities").formatted(Formatting.GRAY));
				} else {
					lines.add(Text.literal("Unassigned Mining XP").formatted(Formatting.RED));
				}
			}
		});
	}

	private static String capitalize(String word) {
		if (word == null || word.isEmpty()) return "";
		return Character.toUpperCase(word.charAt(0)) + word.substring(1);
	}
}
