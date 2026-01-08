package net.nhatjs.nextgen_furniture.blockentity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureModClient;
import net.nhatjs.nextgen_furniture.block.ModernLightBlock;
import net.nhatjs.nextgen_furniture.blockentity.client.LightBlockEntity;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class LightRenderer implements BlockEntityRenderer<LightBlockEntity, LightRenderState> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BlockStateModel led;

    public LightRenderer(BlockEntityRendererFactory.Context ctx) {
        led = mc.getBakedModelManager().getModel(NhatJSNextGenFurnitureModClient.LIGHT_MODERN_EXTRA_ID);
    }

    @Override
    public LightRenderState createRenderState() {
        return new LightRenderState();
    }

    @Override
    public void updateRenderState(LightBlockEntity entity, LightRenderState renderState, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(entity, renderState, tickProgress, cameraPos, crumblingOverlay);
        World world = entity.getWorld();
        if (world == null) return;

        renderState.pos = entity.getPos();
        renderState.blockState = entity.getCachedState();
        BlockState state = entity.getCachedState();
        Direction f = state.get(ModernLightBlock.FACING);
        renderState.yaw = 0f;
        renderState.pitch = 0f;
        switch (f) {
            default -> renderState.yaw = 0f;
            case SOUTH -> renderState.yaw = 180f;
            case WEST -> renderState.yaw = 90f;
            case EAST -> renderState.yaw = 270f;
            case UP -> renderState.pitch = 90f;
            case DOWN -> renderState.pitch = -90f;
        };
        renderState.powered = entity.isPowered();
        renderState.light = WorldRenderer.getLightmapCoordinates(world, renderState.pos);
        renderState.overlay = OverlayTexture.DEFAULT_UV;
    }

    @Override
    public void render(LightRenderState renderState, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(renderState.pitch));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(renderState.yaw));
        matrices.translate(-0.5, -0.5, -0.5);

        queue.submitBlockStateModel(matrices, RenderLayer.getCutoutMipped(), led,
                1f, 1f, 1f, renderState.light, renderState.overlay, 0);

        if (renderState.powered) {
            queue.submitBlockStateModel(matrices, RenderLayer.getCutoutMipped(), led,
                    1f, 1f, 1f, LightmapTextureManager.MAX_LIGHT_COORDINATE, renderState.overlay, 0);
        }
        matrices.pop();
    }
}