package com.jumjumsrpg.client.gui;

import com.jumjumsrpg.client.screen.MiningSkillScreen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class MiningSkillScreenButton extends ButtonWidget {
    public MiningSkillScreenButton(int x, int y) {
        super(x, y, 20, 20, Text.literal("⛏"), button -> {
            button.client.setScreen(new MiningSkillScreen());
        }, DEFAULT_NARRATION_SUPPLIER);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
    }
}
