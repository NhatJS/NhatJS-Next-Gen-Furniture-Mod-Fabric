package net.nhatjs.nextgen_furniture.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;
import net.nhatjs.nextgen_furniture.entity.client.ChairBlockEntity;

public class ModEntities {
    public static final EntityType<ChairBlockEntity> CHAIR = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "chair_entity"),
            EntityType.Builder.create(ChairBlockEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.7f).build());

    public static void registerModEntities() {
        NhatJSNextGenFurnitureMod.LOGGER.info("Registering Mod Entities for " + NhatJSNextGenFurnitureMod.MOD_ID);
    }
}
