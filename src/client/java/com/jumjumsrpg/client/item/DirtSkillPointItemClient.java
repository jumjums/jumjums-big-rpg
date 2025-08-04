package com.jumjumsrpg.client.item;

import com.jumjumsrpg.item.DirtSkillPointItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DirtSkillPointItemClient extends DirtSkillPointItem {

    public DirtSkillPointItemClient(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.jumjums_big_rpg.dirt_skill_point.tooltip")
                .formatted(Formatting.GRAY));
    }
}
