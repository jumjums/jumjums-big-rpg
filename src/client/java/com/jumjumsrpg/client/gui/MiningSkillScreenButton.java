package com.jumjumsrpg.client.gui;

import com.jumjumsrpg.client.screen.MiningSkillScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MiningSkillScreenButton extends ButtonWidget {
    private static final Identifier ICON = new Identifier("jumjums_big_rpg", "textures/gui/mining_button.png");

    public MiningSkillScreenButton(int x, int y) {
        super(
                x, y,
                20, 20,
                Text.literal("⛏️"),
                btn -> MinecraftClient.getInstance().setScreen(new MiningSkillScreen()),
                ButtonWidget.DEFAULT_NARRATION_SUPPLIER
        );
    }

    @Override
    protected void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        int px = getX(), py = getY();
        context.drawTexture(ICON, px, py, 0, 0, width, height, width, height);
    }
}
