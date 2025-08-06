package com.jumjumsrpg.client.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MiningSkillScreen extends Screen {
    private static final Identifier BACKGROUND = new Identifier("jumjums_big_rpg", "textures/gui/mining_skills.png");

    public MiningSkillScreen() {
        super(Text.literal("Mining Skill Tree"));
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        int centerX = (width - 176) / 2;
        int centerY = (height - 166) / 2;
        context.drawTexture(BACKGROUND, centerX, centerY, 0, 0, 176, 166);
        context.drawCenteredTextWithShadow(textRenderer, title, width / 2, centerY + 6, 0xFFFFFF);
        super.render(context, mouseX, mouseY, delta);
    }
}
