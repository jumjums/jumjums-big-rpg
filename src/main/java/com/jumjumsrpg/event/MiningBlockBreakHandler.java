package com.jumjumsrpg.event;

import com.jumjumsrpg.registry.ModItems;
import com.jumjumsrpg.skills.mining.MiningSkillConfig;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class MiningBlockBreakHandler {
    public static void register() {
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            if (!world.isClient) {
                Identifier id = Registries.BLOCK.getId(state.getBlock());
                double chance = MiningSkillConfig.getDropChance(id);
                if (chance > 0 && world.random.nextDouble() < chance) {
                    ItemStack drop = new ItemStack(ModItems.MINING_SKILL_POINT);
                    world.spawnEntity(new ItemEntity(world, pos.getX()+0.5, pos.getY()+1, pos.getZ()+0.5, drop));
                }
            }
        });
    }
}
