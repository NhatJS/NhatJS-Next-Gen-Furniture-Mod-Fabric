package net.nhatjs.nextgen_furniture.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;
import net.nhatjs.nextgen_furniture.entity.client.ChairBlockEntity;

public class ModEntities {
    private static final RegistryKey<EntityType<?>> CHAIR_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "chair_key"));

    public static final EntityType<ChairBlockEntity> CHAIR = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "chair_entity"),
            EntityType.Builder.create(ChairBlockEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.7f).build(CHAIR_KEY));

    public static void registerModEntities() {
        NhatJSNextGenFurnitureMod.LOGGER.info("Registering Mod Entities for " + NhatJSNextGenFurnitureMod.MOD_ID);
    }
}