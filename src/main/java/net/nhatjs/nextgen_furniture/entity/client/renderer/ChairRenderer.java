package net.nhatjs.nextgen_furniture.entity.client.renderer;

import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.entity.client.ChairBlockEntity;

public class ChairRenderer extends EntityRenderer<ChairBlockEntity> {
    public ChairRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(ChairBlockEntity entity) {
        return null;
    }

    @Override
    public boolean shouldRender(ChairBlockEntity entity, Frustum frustum, double x, double y, double z) {
        return true;
    }
}
