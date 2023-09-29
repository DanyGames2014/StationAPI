package net.modificationstation.stationapi.api.item.toolnew.material;

import net.minecraft.item.tool.ToolMaterial;
import net.modificationstation.stationapi.api.block.MiningLevels;
import net.modificationstation.stationapi.api.item.toolnew.ToolClass;
import net.modificationstation.stationapi.api.registry.Identifier;

@SuppressWarnings({"unused"})
public class StationToolMaterialBase implements StationToolMaterial{
    private final Identifier miningLevel;
    private final int durability;
    private final float miningSpeed;
    private final float[] attackDamage;

    public StationToolMaterialBase(Identifier miningLevel, int durability, float miningSpeed, float[] attackDamage) {
        this.miningLevel = miningLevel;
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
    }

    public static StationToolMaterialBase fromToolMaterial(ToolMaterial material){
        return new StationToolMaterialBase(
                MiningLevels.getFirstIdentifierWithMiningLevel(material.getMiningLevel()),
                material.getDurability(),
                material.getMiningSpeed(),
                new float[]{material.getAttackDamage(),material.getAttackDamage()+2,material.getAttackDamage()+3,material.getAttackDamage()+1,4+material.getAttackDamage()*2}
        );
    }

    @Override
    public Identifier getMiningLevel() {
        return miningLevel;
    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public float getMiningSpeed() {
        return miningSpeed;
    }

    @Override
    public float getAttackDamage(int index) {
        if(attackDamage.length == 0){
            return 1F;
        }else if(attackDamage.length < index+1){
            return attackDamage[0];
        }else{
            return attackDamage[index];
        }
    }

    public float getAttackDamage(ToolClass toolClass){
        return getAttackDamage(toolClass.getIndex());
    }
}
