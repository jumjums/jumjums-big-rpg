package com.jumjumsrpg.registry;

import com.jumjumsrpg.JumjumsBigRpg;
import com.jumjumsrpg.item.DirtSkillPointItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DIRT_SKILL_POINT = register("dirt_skill_point",
            new DirtSkillPointItem(new Item.Settings()));

    public static void registerModItems() {
        JumjumsBigRpg.LOGGER.info("Registering items for " + JumjumsBigRpg.MOD_ID);
    }

    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(JumjumsBigRpg.MOD_ID, id), item);
    }
}
