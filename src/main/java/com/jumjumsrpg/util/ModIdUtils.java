package com.jumjumsrpg.util;

import net.minecraft.util.Identifier;

public class ModIdUtils {
    public static final String MOD_ID = "jumjums_big_rpg";

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
