package net.modificationstation.stationapi.api.template.item.tool;

import net.minecraft.item.tool.ToolMaterial;
import net.modificationstation.stationapi.api.item.toolnew.StationToolPickaxe;
import net.modificationstation.stationapi.api.item.toolnew.material.StationToolMaterial;
import net.modificationstation.stationapi.api.item.toolnew.material.StationToolMaterialBase;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.ItemTemplate;

public class TemplatePickaxe extends StationToolPickaxe implements ItemTemplate {

    public TemplatePickaxe(Identifier identifier, StationToolMaterial toolMaterial){
        super(identifier, toolMaterial);
    }

    @Deprecated
    public TemplatePickaxe(Identifier identifier, ToolMaterial material) {
        this(identifier, StationToolMaterialBase.fromToolMaterial(material));
    }
}
