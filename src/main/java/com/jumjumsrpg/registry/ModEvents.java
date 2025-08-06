package com.jumjumsrpg.registry;

import com.jumjumsrpg.event.MiningBlockBreakHandler;

public class ModEvents {
    public static void register() {
        MiningBlockBreakHandler.register();
    }
}
