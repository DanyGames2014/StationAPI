package net.modificationstation.sltest.item;

import net.modificationstation.stationapi.api.item.toolnew.MineableTag;
import net.modificationstation.stationapi.api.item.toolnew.ToolItem;
import net.modificationstation.stationapi.api.registry.Identifier;

public class NewTool extends ToolItem {
    public NewTool(Identifier identifier, int miningLevel) {
        super(identifier, miningLevel, 500, 8F, 9000F);
    }
}
