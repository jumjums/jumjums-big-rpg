package com.jumjumsrpg.item;

import com.jumjumsrpg.registry.ModDataComponents;
import com.jumjumsrpg.registry.ModItems;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
}
