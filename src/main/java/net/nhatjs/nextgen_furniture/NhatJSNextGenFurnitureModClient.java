package net.nhatjs.nextgen_furniture;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.block.ModBlocks;
import net.nhatjs.nextgen_furniture.block.blockentity.ModBlockEntities;
import net.nhatjs.nextgen_furniture.block.blockentity.client.renderer.LaptopRenderer;
import net.nhatjs.nextgen_furniture.entity.ModEntities;
import net.nhatjs.nextgen_furniture.entity.client.renderer.ChairRenderer;


public class NhatJSNextGenFurnitureModClient implements ClientModInitializer{
    public static final Identifier LAPTOP_SCREEN = Identifier.of(
            NhatJSNextGenFurnitureMod.MOD_ID, "block/laptop_screen_off");

    public static final Identifier LAPTOP_SCREEN_ON = Identifier.of(
            NhatJSNextGenFurnitureMod.MOD_ID, "block/laptop_screen_on");

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

        EntityRendererRegistry.register(ModEntities.CHAIR, ChairRenderer::new);
        EntityRendererRegistry.register(ModEntities.SOFA, ChairRenderer::new);

        BlockEntityRendererFactories.register(ModBlockEntities.LAPTOP, LaptopRenderer::new);

        ModelLoadingPlugin.register(ctx -> ctx.addModels(LAPTOP_SCREEN, LAPTOP_SCREEN_ON));
    }
}
