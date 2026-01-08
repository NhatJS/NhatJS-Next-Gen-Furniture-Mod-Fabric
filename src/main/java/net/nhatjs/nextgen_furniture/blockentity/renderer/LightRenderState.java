package net.nhatjs.nextgen_furniture.blockentity.renderer;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.util.math.BlockPos;

public class LightRenderState extends BlockEntityRenderState {
    public BlockState blockState;
    public BlockPos pos;
    public float yaw;
    public float pitch;
    public int light;
    public int overlay;
    public boolean powered;
}