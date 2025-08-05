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

    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(JumjumsBigRpg.MOD_ID, id), item);
    }

    public static final Item MINING_SKILL_POINT = register("mining_skill_point",
            new MiningSkillPointItem(new Item.Settings()));

}
