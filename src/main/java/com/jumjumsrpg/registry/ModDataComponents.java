package com.jumjumsrpg.registry;

import com.jumjumsrpg.JumjumsBigRpg;
import com.jumjumsrpg.skills.mining.player.MiningSkillState;
import com.mojang.serialization.Codec;
import net.minecraft.component.DataComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModDataComponents {

    public static final DataComponentType<String> MINING_MATERIAL =
            Registry.register(
                    Registries.DATA_COMPONENT_TYPE,
                    new Identifier(JumjumsBigRpg.MOD_ID, "mining_material"),
                    DataComponentType.<String>builder()
                            .codec(Codec.STRING)
                            .build()
            );

    public static final DataComponentType<MiningSkillState> MINING_SKILL_STATE =
            Registry.register(
                    Registries.DATA_COMPONENT_TYPE,
                    new Identifier(JumjumsBigRpg.MOD_ID, "mining_skill_state"),
                    DataComponentType.<MiningSkillState>builder()
                            .codec(MiningSkillState.CODEC)
                            .build()
            );

    public static void register() {
        JumjumsBigRpg.LOGGER.info("Registering Data Components for " + JumjumsBigRpg.MOD_ID);
    }
}
