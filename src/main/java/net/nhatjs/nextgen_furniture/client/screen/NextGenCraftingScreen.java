package net.nhatjs.nextgen_furniture.client.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.procedure.NextGenWhileGuiOpenTickProcedure;

public class NextGenCraftingScreen extends HandledScreen<NextGenCraftingMenu> {
    private static final Identifier BG = Identifier.of("nextgen_furniture","textures/gui/container/nextgen_crafting.png");

    public NextGenCraftingScreen(NextGenCraftingMenu handler, PlayerInventory inv, Text title) {
        super(handler, inv, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 166;
        this.playerInventoryTitleY = this.backgroundHeight - 94;
    }

    @Override protected void handledScreenTick() {
        super.handledScreenTick();
        NextGenWhileGuiOpenTickProcedure.execute(); // tuỳ, có thể bỏ nếu muốn chỉ update theo onContentChanged
    }

    @Override
    protected void drawBackground(DrawContext ctx, float delta, int mouseX, int mouseY) {
        int x = (this.width - this.backgroundWidth) / 2;
        int y = (this.height - this.backgroundHeight) / 2;
        ctx.drawTexture(BG, x, y, 0, 0, backgroundWidth, backgroundHeight, 176, 166);
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        this.renderBackground(ctx, mouseX, mouseY, delta);
        super.render(ctx, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(ctx, mouseX, mouseY);
    }
}
