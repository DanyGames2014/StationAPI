package net.modificationstation.stationapi.api.template.item.tool;

import net.minecraft.item.tool.ToolMaterial;
import net.modificationstation.stationapi.api.item.toolnew.StationToolBase;
import net.modificationstation.stationapi.api.item.toolnew.material.StationToolMaterial;
import net.modificationstation.stationapi.api.item.toolnew.material.StationToolMaterialBase;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.ItemTemplate;

public class TemplateToolBase extends StationToolBase implements ItemTemplate {

    public TemplateToolBase(Identifier identifier, StationToolMaterial toolMaterial){
        super(identifier, toolMaterial);
    }

    @Deprecated
    public TemplateToolBase(Identifier identifier, ToolMaterial toolMaterial) {
        this(identifier, StationToolMaterialBase.fromToolMaterial(toolMaterial));
    }
}
