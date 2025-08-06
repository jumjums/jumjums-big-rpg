package com.jumjumsrpg.item;

import net.minecraft.item.Item;

import java.util.List;

public class MiningSkillPointItem extends Item {
    public MiningSkillPointItem(Settings settings) {
        super(settings);
    }

    private static String capitalize(String word) {
        if (word == null || word.isEmpty()) return "";
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
}
