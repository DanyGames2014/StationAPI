package net.modificationstation.stationapi.api.template.item.tool;

import net.minecraft.item.tool.ToolMaterial;
import net.modificationstation.stationapi.api.item.toolnew.StationToolShovel;
import net.modificationstation.stationapi.api.item.toolnew.material.StationToolMaterial;
import net.modificationstation.stationapi.api.item.toolnew.material.StationToolMaterialBase;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.ItemTemplate;

public class TemplateShovel extends StationToolShovel implements ItemTemplate {

    public TemplateShovel(Identifier identifier, StationToolMaterial toolMaterial){
        super(identifier,toolMaterial);
    }

    @Deprecated
    public TemplateShovel(Identifier identifier, ToolMaterial toolMaterial){
        this(identifier, StationToolMaterialBase.fromToolMaterial(toolMaterial));
    }
}
