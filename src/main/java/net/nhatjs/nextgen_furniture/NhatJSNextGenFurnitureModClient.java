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
import net.nhatjs.nextgen_furniture.entity.ModEntities;
import net.nhatjs.nextgen_furniture.entity.renderer.ChairRenderer;


public class NhatJSNextGenFurnitureModClient implements ClientModInitializer {
    public static final Identifier LAPTOP_SCREEN = Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "block/laptop_screen_off");
    public static final ExtraModelKey<BlockStateModel> LAPTOP_SCREEN_ID = ExtraModelKey.<BlockStateModel>create(LAPTOP_SCREEN::toString);
    public static final Identifier LAPTOP_SCREEN_ON = Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "block/laptop_screen_on");
    public static final ExtraModelKey<BlockStateModel> LAPTOP_SCREEN_ON_ID = ExtraModelKey.<BlockStateModel>create(LAPTOP_SCREEN_ON::toString);

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

        ModelLoadingPlugin.register(ctx -> {
            ctx.addModel(LAPTOP_SCREEN_ID, SimpleUnbakedExtraModel.blockStateModel(LAPTOP_SCREEN));
            ctx.addModel(LAPTOP_SCREEN_ON_ID, SimpleUnbakedExtraModel.blockStateModel(LAPTOP_SCREEN_ON));
        });
    }

}
