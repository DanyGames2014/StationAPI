package net.modificationstation.stationapi.api.item.toolnew;

import java.util.HashMap;


@SuppressWarnings("LombokGetterMayBeUsed")
public enum ToolClass {
    BASE(0),
    PICKAXE(1),
    AXE(2),
    SHOVEL(3),
    SWORD(4);

    private final int index;

    ToolClass(int index) {
        this.index = index;
    }

    public int getIndex(){
        return this.index;
    }
}
