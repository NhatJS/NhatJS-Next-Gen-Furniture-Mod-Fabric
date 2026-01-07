package net.nhatjs.nextgen_furniture.blockentity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureModClient;
import net.nhatjs.nextgen_furniture.block.LaptopBlock;
import net.nhatjs.nextgen_furniture.blockentity.client.LaptopBlockEntity;

@Environment(EnvType.CLIENT)
public class LaptopRenderer implements BlockEntityRenderer<LaptopBlockEntity> {
    private final MinecraftClient mc = MinecraftClient.getInstance();

    public LaptopRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public void render(LaptopBlockEntity be,
                       float tickDelta,
                       MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers,
                       int light, int overlay) {
        World world = be.getWorld();
        if (world == null) return;

        BlockState state = be.getCachedState();
        Direction f = state.get(LaptopBlock.FACING);
        float yaw = switch (f) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };

        float t = MathHelper.lerp(tickDelta, be.getPrevOpen(), be.getOpen());
        float openDeg = t * 110f;

        boolean powered = be.isPowered();

        BakedModel screen = mc.getBakedModelManager().getModel(NhatJSNextGenFurnitureModClient.LAPTOP_SCREEN);
        BakedModel screen_on = mc.getBakedModelManager().getModel(NhatJSNextGenFurnitureModClient.LAPTOP_SCREEN_ON);

        BlockModelRenderer bmr = mc.getBlockRenderManager().getModelRenderer();

        VertexConsumer vc = vertexConsumers.getBuffer(RenderLayer.getCutoutMipped());

        matrices.push();
        matrices.translate(0.5, 0, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(yaw));
        matrices.translate(-0.5, 0, -0.5);

        matrices.push();
        matrices.translate(0.1, 0.04, 0.735);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(openDeg));
        matrices.translate(-0.1, -0.04, -0.735);

        bmr.render(matrices.peek(), vc, state, screen, 1, 1, 1, light, overlay);
        if (powered) {
            bmr.render(matrices.peek(), vc, state, screen_on, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
        }
        matrices.pop();
        matrices.pop();
    }
}
