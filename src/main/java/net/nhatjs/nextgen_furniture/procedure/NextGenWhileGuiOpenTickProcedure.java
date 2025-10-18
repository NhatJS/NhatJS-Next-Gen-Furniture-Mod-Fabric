package net.nhatjs.nextgen_furniture.procedure;

import net.minecraft.client.MinecraftClient;

public class NextGenWhileGuiOpenTickProcedure {
    public static void execute() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc == null || mc.player == null) return;
        NextGenUpdateOutputProcedure.execute(mc.player);
    }
}