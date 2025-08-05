package com.jumjumsrpg.skills.mining.effect;

import com.jumjumsrpg.skills.mining.model.MiningSkillTree;
import com.jumjumsrpg.skills.mining.player.MiningSkillState;
import com.jumjumsrpg.skills.mining.player.MiningSkillStateProvider;
import com.jumjumsrpg.skills.mining.registry.MiningSkillTreeRegistry;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import static com.jumjumsrpg.util.ModIdUtils.id;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MiningSpeedHandler {
    public static void register() {
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            applyMiningSpeed(player, state.getBlock(), pos, world);
            return true;
        });
    }

    private static void applyMiningSpeed(PlayerEntity player, Block block, BlockPos pos, World world) {
        // Get the block category — use a tag or category key
        String category = getBlockCategory(block);

        MiningSkillTree tree = MiningSkillTreeRegistry.get(id(category));

        if (tree == null) return;

        MiningSkillState state = MiningSkillStateProvider.get(player); // we'll implement this
        int rank = state.getUpgradeRank(tree.id(), MiningSkillEffectKeys.MINING_SPEED);
        if (rank == 0) return;

        float multiplier = 1.0f + (rank * 0.10f); // 10% per rank

        // Apply mining speed buff (could use attribute modifiers or context-based boosts)
        // For now we’ll simulate the idea via a message
        if (!world.isClient) {
            player.sendMessage(
                    net.minecraft.text.Text.literal("Mining speed for " + category + " boosted by " + (int)(multiplier * 100) + "%"),
                    true
            );
        }

        // Full real application would require injecting into mining time calculations or tools
    }

    private static String getBlockCategory(Block block) {
        // Temporary approach — later we'll map tags to skill trees more formally
        if (block.getDefaultState().isIn(BlockTags.DIRT)) return "dirt";
        return "general";
    }
}
