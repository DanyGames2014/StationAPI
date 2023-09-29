package net.modificationstation.stationapi.api.item.toolnew;

import net.modificationstation.stationapi.api.item.toolnew.material.StationToolMaterial;
import net.modificationstation.stationapi.api.item.toolnew.material.StationToolMaterialBase;
import net.modificationstation.stationapi.api.registry.Identifier;

public class StationToolSword extends StationToolBase {
    public StationToolSword(Identifier identifier, StationToolMaterial toolMaterial) {
        super(identifier, toolMaterial);
        this.attackDamage = toolMaterial.getAttackDamage(ToolClass.SWORD.getIndex());
        this.setEffectiveBlocks(MineableTag.SWORD);
    }

    public StationToolSword(Identifier identifier, Identifier miningLevel, int durability, float miningSpeed, float attackDamage){
        this(identifier, new StationToolMaterialBase(miningLevel, durability, miningSpeed, new float[]{1F,1F,1F,1F,attackDamage}));
    }

    public StationToolSword(int rawId, StationToolMaterial toolMaterial){
        super(rawId, toolMaterial);
    }
}

