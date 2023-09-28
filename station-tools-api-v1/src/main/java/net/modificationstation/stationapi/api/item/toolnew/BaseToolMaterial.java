package net.modificationstation.stationapi.api.item.toolnew;

import lombok.Getter;
import net.modificationstation.stationapi.api.registry.Identifier;

@Getter
public class BaseToolMaterial implements StationToolMaterial {

    protected Identifier miningLevel;
    protected int durability;
    protected float miningSpeed;
    protected float attackDamage;

    public BaseToolMaterial(Identifier miningLevel, int durability, float miningSpeed, float attackDamage) {
        this.miningLevel = miningLevel;
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
    }
}
