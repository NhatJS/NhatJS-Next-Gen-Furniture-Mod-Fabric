package net.nhatjs.nextgen_furniture;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.BlockRenderLayer;
import net.nhatjs.nextgen_furniture.block.ModBlocks;
import net.nhatjs.nextgen_furniture.entity.ModEntities;
import net.nhatjs.nextgen_furniture.entity.client.renderer.ChairRenderer;


public class NhatJSNextGenFurnitureModClient implements ClientModInitializer{
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
    }

}
