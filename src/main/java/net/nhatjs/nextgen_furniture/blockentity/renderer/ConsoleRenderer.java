package net.nhatjs.nextgen_furniture.blockentity.renderer;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureModClient;
import net.nhatjs.nextgen_furniture.block.ConsoleBlock;
import net.nhatjs.nextgen_furniture.blockentity.client.ConsoleBlockEntity;

public class ConsoleRenderer implements BlockEntityRenderer<ConsoleBlockEntity> {
    private final MinecraftClient mc = MinecraftClient.getInstance();

    public ConsoleRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public void render(ConsoleBlockEntity entity, float tickDelta,
                       MatrixStack matrices, VertexConsumerProvider vertexConsumers,
                       int light, int overlay) {
        World world = entity.getWorld();
        if (world == null) return;

        BlockState state = entity.getCachedState();
        Direction facing = state.get(ConsoleBlock.FACING);
        float yaw = switch (facing) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };

        BakedModel screen = mc.getBakedModelManager().getModel(NhatJSNextGenFurnitureModClient.GAME_CONSOLE_EXTRA);
        BlockModelRenderer bmr = mc.getBlockRenderManager().getModelRenderer();
        VertexConsumer vc = vertexConsumers.getBuffer(RenderLayer.getCutoutMipped());

        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(yaw));
        matrices.translate(-0.5, -0.5, -0.5);

        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(30F));
        matrices.translate(-0.5, -0.5, -0.5);
        bmr.render(world, screen, state, entity.getPos(), matrices, vc, false, world.random, 0L, overlay);
        matrices.pop();

        matrices.pop();
    }
}
