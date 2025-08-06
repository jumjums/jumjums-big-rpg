package com.jumjumsrpg.item;

import com.jumjumsrpg.registry.ModDataComponents;
import net.minecraft.client.item.TooltipType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TooltipContext;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class MiningSkillPointItem extends Item {

    public MiningSkillPointItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        String material = stack.get(ModDataComponents.MINING_MATERIAL);
        if (material != null && !material.isBlank()) {
            tooltip.add(Text.literal("Used for advancing " + capitalize(material) + " mining abilities")
                    .formatted(Formatting.GRAY));
        } else {
            tooltip.add(Text.literal("Unassigned Mining XP").formatted(Formatting.RED));
        }
    }

    private static String capitalize(String word) {
        if (word == null || word.isEmpty()) return "";
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
}
