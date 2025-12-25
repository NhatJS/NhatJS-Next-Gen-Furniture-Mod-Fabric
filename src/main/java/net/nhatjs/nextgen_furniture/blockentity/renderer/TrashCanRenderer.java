package net.nhatjs.nextgen_furniture.blockentity.renderer;

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
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureModClient;
import net.nhatjs.nextgen_furniture.block.ConsoleBlock;
import net.nhatjs.nextgen_furniture.block.ModBlocks;
import net.nhatjs.nextgen_furniture.blockentity.client.ConsoleBlockEntity;
import net.nhatjs.nextgen_furniture.blockentity.client.TrashCanBlockEntity;

public class TrashCanRenderer implements BlockEntityRenderer<TrashCanBlockEntity> {
    private final MinecraftClient mc = MinecraftClient.getInstance();

    public TrashCanRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public void render(TrashCanBlockEntity entity, float tickDelta,
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

        BakedModel black = mc.getBakedModelManager().getModel(NhatJSNextGenFurnitureModClient.TRASH_CAN_BLACK_EXTRA);
        BakedModel white = mc.getBakedModelManager().getModel(NhatJSNextGenFurnitureModClient.TRASH_CAN_WHITE_EXTRA);
        BlockModelRenderer bmr = mc.getBlockRenderManager().getModelRenderer();
        VertexConsumer vc = vertexConsumers.getBuffer(RenderLayer.getCutoutMipped());

        matrices.push();
        matrices.translate(0.5, 0, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(yaw));
        matrices.translate(-0.5, -0, -0.5);

        matrices.push();
        matrices.translate(0.5, 0.4942, 0.2357);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-10F));
        matrices.translate(-0.5, -0.5, -0.5);
        if (state.getBlock() == ModBlocks.TRASH_CAN_BLACK) {
            bmr.render(world, black, state, entity.getPos(), matrices, vc, false, world.random, 0L, overlay);
        }
        else if (state.getBlock() == ModBlocks.TRASH_CAN_WHITE) {
            bmr.render(world, white, state, entity.getPos(), matrices, vc, false, world.random, 0L, overlay);
        }
        matrices.pop();

        matrices.push();
        matrices.translate(0, 0, 1);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90F));
        matrices.translate(0.5, 0.4942, 0.2357);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-10F));
        matrices.translate(-0.5, -0.5, -0.5);
        if (state.getBlock() == ModBlocks.TRASH_CAN_BLACK) {
            bmr.render(world, black, state, entity.getPos(), matrices, vc, false, world.random, 0L, overlay);
        }
        else if (state.getBlock() == ModBlocks.TRASH_CAN_WHITE) {
            bmr.render(world, white, state, entity.getPos(), matrices, vc, false, world.random, 0L, overlay);
        }
        matrices.pop();

        matrices.push();
        matrices.translate(1, 0, 1);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180F));
        matrices.translate(0.5, 0.4942, 0.2357);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-10F));
        matrices.translate(-0.5, -0.5, -0.5);
        if (state.getBlock() == ModBlocks.TRASH_CAN_BLACK) {
            bmr.render(world, black, state, entity.getPos(), matrices, vc, false, world.random, 0L, overlay);
        }
        else if (state.getBlock() == ModBlocks.TRASH_CAN_WHITE) {
            bmr.render(world, white, state, entity.getPos(), matrices, vc, false, world.random, 0L, overlay);
        }
        matrices.pop();

        matrices.push();
        matrices.translate(1, 0, 0);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(270F));
        matrices.translate(0.5, 0.4942, 0.2357);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-10F));
        matrices.translate(-0.5, -0.5, -0.5);
        if (state.getBlock() == ModBlocks.TRASH_CAN_BLACK) {
            bmr.render(world, black, state, entity.getPos(), matrices, vc, false, world.random, getLightLevel(entity.getWorld(),
                    entity.getPos()), overlay);
        }
        else if (state.getBlock() == ModBlocks.TRASH_CAN_WHITE) {
            bmr.render(world, white, state, entity.getPos(), matrices, vc, false, world.random, getLightLevel(entity.getWorld(),
                    entity.getPos()), overlay);
        }
        matrices.pop();

        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
