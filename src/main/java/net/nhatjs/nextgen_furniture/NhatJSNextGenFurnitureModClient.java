package net.nhatjs.nextgen_furniture;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ExtraModelKey;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.model.loading.v1.SimpleUnbakedExtraModel;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.block.ModBlocks;
import net.nhatjs.nextgen_furniture.blockentity.ModBlockEntities;
import net.nhatjs.nextgen_furniture.blockentity.renderer.LaptopRenderer;
import net.nhatjs.nextgen_furniture.blockentity.renderer.LightRenderer;
import net.nhatjs.nextgen_furniture.entity.ModEntities;
import net.nhatjs.nextgen_furniture.entity.renderer.ChairRenderer;


public class NhatJSNextGenFurnitureModClient implements ClientModInitializer {
    public static final Identifier LAPTOP_SCREEN = Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "extra/laptop_screen");
    public static final ExtraModelKey<BlockStateModel> LAPTOP_SCREEN_ID = ExtraModelKey.<BlockStateModel>create(LAPTOP_SCREEN::toString);
    public static final Identifier LAPTOP_SCREEN_ON = Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "extra/laptop_screen_on");
    public static final ExtraModelKey<BlockStateModel> LAPTOP_SCREEN_ON_ID = ExtraModelKey.<BlockStateModel>create(LAPTOP_SCREEN_ON::toString);

    public static final Identifier LIGHT_MODERN_EXTRA = Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "extra/light_modern_extra");
    public static final ExtraModelKey<BlockStateModel> LIGHT_MODERN_EXTRA_ID = ExtraModelKey.<BlockStateModel>create(LIGHT_MODERN_EXTRA::toString);

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.CHAIR_WHITE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.CHAIR_WOOD_OAK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_2X1_BLACK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_2X1_BLACK_ALT, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_2X1_BLACK_ALT_2, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_2X1_WHITE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_2X1_WHITE_ALT, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_2X1_WHITE_ALT_2, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_3X1_BLACK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_3X1_WHITE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.COFFEE_TABLE_WHITE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_DINING_WHITE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_DINING_WOOD_OAK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TV_STAND_WOOD_OAK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PICTURE_FRAME, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TRASH_CAN_BLACK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TRASH_CAN_WHITE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.SOFA_GRAY, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.SOFA_WHITE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.FLOOR_LAMP, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.LAPTOP, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TV_OLED, BlockRenderLayer.CUTOUT_MIPPED);

        BlockRenderLayerMap.putBlock(ModBlocks.CHAIR_WOOD_BIRCH, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TV_STAND_WOOD_BIRCH, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_DINING_WOOD_BIRCH, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_1X1_BLACK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_1X1_WHITE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.FLOOR_LAMP_B, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.BED_GRAY_WOOD_OAK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.BED_GRAY_WOOD_BIRCH, BlockRenderLayer.CUTOUT_MIPPED);;
        BlockRenderLayerMap.putBlock(ModBlocks.BED_WHITE_WOOD_OAK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.BED_WHITE_WOOD_BIRCH, BlockRenderLayer.CUTOUT_MIPPED);

        EntityRendererRegistry.register(ModEntities.CHAIR, ChairRenderer::new);
        EntityRendererRegistry.register(ModEntities.SOFA, ChairRenderer::new);

        BlockEntityRendererFactories.register(ModBlockEntities.LAPTOP, LaptopRenderer::new);
        BlockRenderLayerMap.putBlock(ModBlocks.MONITOR, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.MONITOR_GAMING_MINIMALIST, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.MOUSE_GAMING_BLACK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.KEYBOARD_MECHANICAL_BLACK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.GAME_CONSOLE, BlockRenderLayer.CUTOUT_MIPPED);

        BlockRenderLayerMap.putBlock(ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_OAK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_BIRCH, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WARDROBE_MODERN_WOOD_OAK_LEFT, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WARDROBE_MODERN_WOOD_BIRCH_LEFT, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WARDROBE_MODERN_WOOD_OAK_RIGHT, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WARDROBE_MODERN_WOOD_BIRCH_RIGHT, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.CHAIR_2_WHITE_GRAY, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.CHAIR_2_WHITE_WHITE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.CHAIR_2_WOOD_OAK_GRAY, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.CHAIR_2_WOOD_OAK_WHITE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.CHAIR_2_WOOD_BIRCH_GRAY, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.CHAIR_2_WOOD_BIRCH_WHITE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_GAMING, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.COMPUTER_CASE_GAMING, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.COMPUTER_POWER_SUPPLY, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.MAINBOARD_GAMING, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.GRAPHICS_CARD_GAMING, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.AIO_COOLER_3_FANS, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_GAMING_ADDED_1, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_GAMING_ADDED_2, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_GAMING_ADDED_3, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_GAMING_ADDED_4, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_GAMING_ADDED_5, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_GAMING_ADDED_6, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_GAMING_ADDED_7, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_GAMING_ADDED_8, BlockRenderLayer.CUTOUT_MIPPED);

        BlockRenderLayerMap.putBlock(ModBlocks.MONITOR_DUAL, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.MONITOR_DUAL_ALT, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.MONITOR_DUAL_ALT_2, BlockRenderLayer.CUTOUT_MIPPED);

        BlockRenderLayerMap.putBlock(ModBlocks.DRAWER_3_K_M_WOOD_OAK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.DRAWER_3_K_M_WOOD_BIRCH, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.DRAWER_3_K_M_WOOD_OAK_BASE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.DRAWER_3_K_M_WOOD_BIRCH_BASE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.DRAWER_2_K_M_WOOD_OAK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.DRAWER_2_K_M_WOOD_BIRCH, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.DRAWER_2_K_M_WOOD_OAK_BASE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.DRAWER_2_K_M_WOOD_BIRCH_BASE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.LIGHT_MODERN, BlockRenderLayer.CUTOUT_MIPPED);
        BlockEntityRendererFactories.register(ModBlockEntities.LIGHT_EXTRA, LightRenderer::new);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_1X1_WOOD_OAK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_1X1_WOOD_BIRCH, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_2X1_WOOD_OAK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_2X1_WOOD_OAK_ALT, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_2X1_WOOD_OAK_ALT_2, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_2X1_WOOD_BIRCH, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_2X1_WOOD_BIRCH_ALT, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_2X1_WOOD_BIRCH_ALT_2, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_3X1_WOOD_OAK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TABLE_3X1_WOOD_BIRCH, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WASHING_MACHINE, BlockRenderLayer.CUTOUT_MIPPED);

        ModelLoadingPlugin.register(ctx -> {
            ctx.addModel(LAPTOP_SCREEN_ID, SimpleUnbakedExtraModel.blockStateModel(LAPTOP_SCREEN));
            ctx.addModel(LAPTOP_SCREEN_ON_ID, SimpleUnbakedExtraModel.blockStateModel(LAPTOP_SCREEN_ON));
            ctx.addModel(LIGHT_MODERN_EXTRA_ID, SimpleUnbakedExtraModel.blockStateModel(LIGHT_MODERN_EXTRA));
        });
    }

}
