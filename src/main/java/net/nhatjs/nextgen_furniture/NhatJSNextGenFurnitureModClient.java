package net.nhatjs.nextgen_furniture;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.block.ModBlocks;
import net.nhatjs.nextgen_furniture.blockentity.ModBlockEntities;
import net.nhatjs.nextgen_furniture.blockentity.renderer.ConsoleRenderer;
import net.nhatjs.nextgen_furniture.blockentity.renderer.LaptopRenderer;
import net.nhatjs.nextgen_furniture.blockentity.renderer.LightRenderer;
import net.nhatjs.nextgen_furniture.blockentity.renderer.TrashCanRenderer;
import net.nhatjs.nextgen_furniture.entity.ModEntities;
import net.nhatjs.nextgen_furniture.entity.renderer.ChairRenderer;

public class NhatJSNextGenFurnitureModClient implements ClientModInitializer{
    public static final Identifier LAPTOP_SCREEN = Identifier.of(
            NhatJSNextGenFurnitureMod.MOD_ID, "extra/laptop_screen");
    public static final Identifier LAPTOP_SCREEN_ON = Identifier.of(
            NhatJSNextGenFurnitureMod.MOD_ID, "extra/laptop_screen_on");

    public static final Identifier GAME_CONSOLE_EXTRA = Identifier.of(
            NhatJSNextGenFurnitureMod.MOD_ID, "extra/game_console_extra");
    public static final Identifier TRASH_CAN_BLACK_EXTRA = Identifier.of(
            NhatJSNextGenFurnitureMod.MOD_ID, "extra/trash_can_black_extra");
    public static final Identifier TRASH_CAN_WHITE_EXTRA = Identifier.of(
            NhatJSNextGenFurnitureMod.MOD_ID, "extra/trash_can_white_extra");

    public static final Identifier LIGHT_MODERN_EXTRA = Identifier.of(
            NhatJSNextGenFurnitureMod.MOD_ID, "extra/light_modern_extra");

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIR_WHITE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIR_WOOD_OAK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_2X1_BLACK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_2X1_BLACK_ALT, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_2X1_BLACK_ALT_2, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_2X1_WHITE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_2X1_WHITE_ALT, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_2X1_WHITE_ALT_2, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_3X1_BLACK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_3X1_WHITE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COFFEE_TABLE_WHITE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_DINING_WHITE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_DINING_WOOD_OAK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TV_STAND_WOOD_OAK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PICTURE_FRAME, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRASH_CAN_BLACK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRASH_CAN_WHITE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SOFA_GRAY, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SOFA_WHITE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLOOR_LAMP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LAPTOP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TV_OLED, RenderLayer.getCutoutMipped());

        EntityRendererRegistry.register(ModEntities.CHAIR, ChairRenderer::new);
        EntityRendererRegistry.register(ModEntities.SOFA, ChairRenderer::new);
        
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIR_WOOD_BIRCH, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TV_STAND_WOOD_BIRCH, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_DINING_WOOD_BIRCH, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_1X1_BLACK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_1X1_WHITE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLOOR_LAMP_B, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BED_GRAY_WOOD_OAK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BED_GRAY_WOOD_BIRCH, RenderLayer.getCutoutMipped());;
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BED_WHITE_WOOD_OAK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BED_WHITE_WOOD_BIRCH, RenderLayer.getCutoutMipped());
        
        BlockEntityRendererFactories.register(ModBlockEntities.LAPTOP, LaptopRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MONITOR, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MONITOR_GAMING_MINIMALIST, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MOUSE_GAMING_BLACK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KEYBOARD_MECHANICAL_BLACK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GAME_CONSOLE, RenderLayer.getCutoutMipped());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_OAK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_BIRCH, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WARDROBE_MODERN_WOOD_OAK_LEFT, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WARDROBE_MODERN_WOOD_BIRCH_LEFT, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WARDROBE_MODERN_WOOD_OAK_RIGHT, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WARDROBE_MODERN_WOOD_BIRCH_RIGHT, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIR_2_WHITE_GRAY, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIR_2_WHITE_WHITE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIR_2_WOOD_OAK_GRAY, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIR_2_WOOD_OAK_WHITE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIR_2_WOOD_BIRCH_GRAY, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIR_2_WOOD_BIRCH_WHITE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_GAMING, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COMPUTER_CASE_GAMING, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COMPUTER_POWER_SUPPLY, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAINBOARD_GAMING, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRAPHICS_CARD_GAMING, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AIO_COOLER_3_FANS, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_GAMING_ADDED_1, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_GAMING_ADDED_2, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_GAMING_ADDED_3, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_GAMING_ADDED_4, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_GAMING_ADDED_5, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_GAMING_ADDED_6, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_GAMING_ADDED_7, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_GAMING_ADDED_8, RenderLayer.getCutoutMipped());

        BlockEntityRendererFactories.register(ModBlockEntities.CONSOLE, ConsoleRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.TRASH_CAN, TrashCanRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MONITOR_DUAL, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MONITOR_DUAL_ALT, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MONITOR_DUAL_ALT_2, RenderLayer.getCutoutMipped());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAWER_3_K_M_WOOD_OAK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAWER_3_K_M_WOOD_BIRCH, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAWER_3_K_M_WOOD_OAK_BASE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAWER_3_K_M_WOOD_BIRCH_BASE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAWER_2_K_M_WOOD_OAK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAWER_2_K_M_WOOD_BIRCH, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAWER_2_K_M_WOOD_OAK_BASE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAWER_2_K_M_WOOD_BIRCH_BASE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIGHT_MODERN, RenderLayer.getCutoutMipped());
        BlockEntityRendererFactories.register(ModBlockEntities.LIGHT_EXTRA, LightRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_1X1_WOOD_OAK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_1X1_WOOD_BIRCH, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_2X1_WOOD_OAK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_2X1_WOOD_OAK_ALT, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_2X1_WOOD_OAK_ALT_2, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_2X1_WOOD_BIRCH, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_2X1_WOOD_BIRCH_ALT, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_2X1_WOOD_BIRCH_ALT_2, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_3X1_WOOD_OAK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TABLE_3X1_WOOD_BIRCH, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WASHING_MACHINE, RenderLayer.getCutoutMipped());

        ModelLoadingPlugin.register(ctx -> ctx.addModels(LAPTOP_SCREEN, LAPTOP_SCREEN_ON, GAME_CONSOLE_EXTRA,
                TRASH_CAN_BLACK_EXTRA, TRASH_CAN_WHITE_EXTRA, LIGHT_MODERN_EXTRA));
    }
}
