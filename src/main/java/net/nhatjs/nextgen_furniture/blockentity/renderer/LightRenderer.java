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
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureModClient;
import net.nhatjs.nextgen_furniture.block.ModernLightBlock;
import net.nhatjs.nextgen_furniture.blockentity.client.LightBlockEntity;

@Environment(EnvType.CLIENT)
public class LightRenderer implements BlockEntityRenderer<LightBlockEntity> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BlockStateModel led;

    public LightRenderer(BlockEntityRendererFactory.Context ctx) {
        led = mc.getBakedModelManager().getModel(NhatJSNextGenFurnitureModClient.LIGHT_MODERN_EXTRA_ID);
    }

    @Override
    public void render(LightBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d vec3d) {
        World world = entity.getWorld();
        if (world == null) return;

        BlockState state = entity.getCachedState();
        Direction f = state.get(ModernLightBlock.FACING);
        float yaw = 0f;
        float pitch = 0f;
        switch (f) {
            default -> yaw = 0f;
            case SOUTH -> yaw = 180f;
            case WEST -> yaw = 90f;
            case EAST -> yaw = 270f;
            case UP -> pitch = 90f;
            case DOWN -> pitch = -90f;
        };
        boolean powered = entity.isPowered();
        VertexConsumer vc = vertexConsumers.getBuffer(RenderLayer.getCutoutMipped());

        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(pitch));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(yaw));
        matrices.translate(-0.5, -0.5, -0.5);

        BlockModelRenderer.render(matrices.peek(), vc, led, 1, 1, 1, light, overlay);
        if (powered) {
            BlockModelRenderer.render(matrices.peek(), vc, led, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
        }
        matrices.pop();
    }
}