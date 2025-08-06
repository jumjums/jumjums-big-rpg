package com.jumjumsrpg.item;

import com.jumjumsrpg.registry.ModDataComponents;
import com.jumjumsrpg.registry.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class MiningSkillPointItem extends Item {

    public MiningSkillPointItem(Settings settings) {
        super(settings);
    }

    public static ItemStack createForMaterial(String materialId) {
        ItemStack stack = new ItemStack(ModItems.MINING_SKILL_POINT);
        stack.set(ModDataComponents.MINING_MATERIAL, materialId);
        return stack;
    }

    public static String getMaterial(ItemStack stack) {
        return stack.getOrDefault(ModDataComponents.MINING_MATERIAL, "unknown");
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        String material = getMaterial(stack);
        if (material != null && !material.isBlank()) {
            tooltip.add(Text.literal("Used for advancing " + capitalize(material) + " mining abilities").formatted(Formatting.GRAY));
        } else {
            tooltip.add(Text.literal("Unassigned Mining XP").formatted(Formatting.RED));
        }
    }

    private static String capitalize(String word) {
        if (word == null || word.isEmpty()) return "";
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
}
