package net.nhatjs.nextgen_furniture.entity.client.renderer;

import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.nhatjs.nextgen_furniture.entity.client.ChairBlockEntity;

public class ChairRenderer extends EntityRenderer<ChairBlockEntity, EntityRenderState> {
    public ChairRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }

    @Override
    public boolean shouldRender(ChairBlockEntity entity, Frustum frustum, double x, double y, double z) {
        return true;
    }
}