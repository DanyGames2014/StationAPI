package net.modificationstation.stationapi.api.item.toolnew;

import lombok.Getter;

@Getter
public class BaseToolMaterial implements ToolMaterial{

    protected int miningLevel;
    protected int durability;
    protected float miningSpeed;
    protected float attackDamage;

    public BaseToolMaterial(int miningLevel, int durability, float miningSpeed, float attackDamage) {
        this.miningLevel = miningLevel;
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
    }
}
