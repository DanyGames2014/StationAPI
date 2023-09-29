package net.modificationstation.stationapi.api.template.item.tool;

import net.minecraft.item.tool.ToolMaterial;
import net.modificationstation.stationapi.api.item.toolnew.StationToolAxe;
import net.modificationstation.stationapi.api.item.toolnew.material.StationToolMaterial;
import net.modificationstation.stationapi.api.item.toolnew.material.StationToolMaterialBase;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.ItemTemplate;

public class TemplateHatchet extends StationToolAxe implements ItemTemplate {
    
    public TemplateHatchet(Identifier identifier, StationToolMaterial toolMaterial){
        super(identifier, toolMaterial);
    }

    @Deprecated
    public TemplateHatchet(Identifier identifier, ToolMaterial toolMaterial){
        this(identifier, StationToolMaterialBase.fromToolMaterial(toolMaterial));
    }
}
