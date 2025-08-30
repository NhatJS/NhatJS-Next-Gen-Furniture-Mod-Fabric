package net.nhatjs.nextgen_furniture;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.nhatjs.nextgen_furniture.block.NextGenFurnitureBlocks;

public class NhatJSNextGenFurnitureModClient implements ClientModInitializer{
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(NextGenFurnitureBlocks.MODERN_TABLE, RenderLayer.getCutoutMipped());

    }
}
