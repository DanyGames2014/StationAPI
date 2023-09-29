package net.modificationstation.stationapi.api.item.toolnew;

import net.modificationstation.stationapi.api.item.toolnew.material.StationToolMaterial;
import net.modificationstation.stationapi.api.item.toolnew.material.StationToolMaterialBase;
import net.modificationstation.stationapi.api.registry.Identifier;

public class StationToolShovel extends StationToolBase{
    public StationToolShovel(Identifier identifier, StationToolMaterial toolMaterial) {
        super(identifier, toolMaterial);
        this.attackDamage = toolMaterial.getAttackDamage(ToolClass.SHOVEL.getIndex());
        this.setEffectiveBlocks(MineableTag.SHOVEL);
    }

    public StationToolShovel(Identifier identifier, Identifier miningLevel, int durability, float miningSpeed, float attackDamage){
        this(identifier, new StationToolMaterialBase(miningLevel, durability, miningSpeed, new float[]{1F,1F,1F,attackDamage,1F}));
    }
}
