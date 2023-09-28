package net.modificationstation.sltest.item;

import net.modificationstation.stationapi.api.item.toolnew.StationToolBase;
import net.modificationstation.stationapi.api.registry.Identifier;

public class NewTool extends StationToolBase {
    public NewTool(Identifier identifier, Identifier miningLevel) {
        super(identifier, miningLevel, 500, 8F, 9000F);
    }
}
