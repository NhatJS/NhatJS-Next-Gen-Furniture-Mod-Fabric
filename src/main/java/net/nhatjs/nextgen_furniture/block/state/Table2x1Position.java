package net.nhatjs.nextgen_furniture.block.state;

import net.minecraft.util.StringIdentifiable;

public enum Table2x1Position implements StringIdentifiable {
    CENTER("center"),
    LEFT("left"),
    RIGHT("right");

    private final String name;
    Table2x1Position(String name) {
        this.name = name;
    }
    @Override public String asString() { return name; }
    @Override public String toString() { return name; }
}
