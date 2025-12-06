package net.nhatjs.nextgen_furniture.blockentity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.renderer.v1.render.BlockVertexConsumerProvider;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureModClient;
import net.nhatjs.nextgen_furniture.block.LaptopBlock;
import net.nhatjs.nextgen_furniture.blockentity.client.LaptopBlockEntity;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class LaptopRenderer implements BlockEntityRenderer<LaptopBlockEntity, LaptopRenderState> {
    public LaptopRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public LaptopRenderState createRenderState() {
        return new LaptopRenderState();
    }

    @Override
    public void updateRenderState(LaptopBlockEntity blockEntity,
                                  LaptopRenderState state,
                                  float tickProgress, Vec3d cameraPos,
                                  @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);

        state.pos = blockEntity.getPos();
        state.blockState = blockEntity.getCachedState();

        World world = blockEntity.getWorld();
        if (world == null) return;

        state.yaw = switch (state.blockState.get(LaptopBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };

        float t = MathHelper.lerp(tickProgress, blockEntity.getPrevOpen(), blockEntity.getOpen());
        state.openDeg = t * 110f;
        state.powered = blockEntity.isPowered();

        state.light = WorldRenderer.getLightmapCoordinates(world, state.pos);
        state.overlay = OverlayTexture.DEFAULT_UV;
    }

    @Override
    public void render(LaptopRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        matrices.push();
        matrices.translate(0.5, 0, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.yaw));
        matrices.translate(-0.5, 0, -0.5);

        matrices.push();
        matrices.translate(0.1, 0.04, 0.735);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(state.openDeg));
        matrices.translate(-0.1, -0.04, -0.735);

        queue.submitBlockStateModel(matrices, RenderLayer.getCutout(),
                MinecraftClient.getInstance().getBakedModelManager().getModel(
                        NhatJSNextGenFurnitureModClient.LAPTOP_SCREEN_ID),
                1f, 1f, 1f, state.light, state.overlay, 0);

        if (state.powered) {
            queue.submitBlockStateModel(matrices, RenderLayer.getCutout(),
                    MinecraftClient.getInstance().getBakedModelManager().getModel(
                            NhatJSNextGenFurnitureModClient.LAPTOP_SCREEN_ON_ID),
                    1f, 1f, 1f, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
        }

        matrices.pop();
        matrices.pop();
    }
}