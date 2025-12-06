package net.nhatjs.nextgen_furniture.blockentity.renderer;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;

public class LaptopRenderState extends BlockEntityRenderState {
    public BlockState state;
    public int light;
    public int overlay;
    public float yaw;
    public float openDeg;
    public boolean powered;
}
