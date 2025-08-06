package com.jumjumsrpg.registry;

import com.jumjumsrpg.JumjumsBigRpg;
import com.jumjumsrpg.item.MiningSkillPointItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static void registerModItems() {
        JumjumsBigRpg.LOGGER.info("Registering items for " + JumjumsBigRpg.MOD_ID);
    }

    private static Item register(Item item) {
        return Registry.register(Registries.ITEM, new Identifier(JumjumsBigRpg.MOD_ID, "mining_skill_point"), item);
    }

    public static final Item MINING_SKILL_POINT = register(
            new MiningSkillPointItem(new Item.Settings()));

}
