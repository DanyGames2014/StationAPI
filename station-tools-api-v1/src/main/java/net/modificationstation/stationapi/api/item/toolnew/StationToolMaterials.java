package net.modificationstation.stationapi.api.item.toolnew;

import net.modificationstation.stationapi.api.block.MiningLevel;
import net.modificationstation.stationapi.api.block.MiningLevels;
import net.modificationstation.stationapi.api.registry.Identifier;

public enum StationToolMaterials implements StationToolMaterial {

    WOOD(MiningLevels.WOOD.getIdentifier(), 59, 2.0F, 0),
    STONE(MiningLevels.STONE.getIdentifier(), 131, 4.0F, 1),
    IRON(MiningLevels.IRON.getIdentifier(), 250, 6.0F, 2),
    DIAMOND(MiningLevels.DIAMOND.getIdentifier(), 1561, 8.0F, 3),
    GOLD(MiningLevels.WOOD.getIdentifier(), 32, 12.0F, 0);

    private final float attackDamage;
    private final Identifier miningLevel;
    private final float miningSpeed;
    private final int durability;

    StationToolMaterials(Identifier miningLevel, int durability, float miningSpeed, float attackDamage) {
        this.miningLevel = miningLevel;
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public Identifier getMiningLevel() {
        return miningLevel;
    }

    @Override
    public float getMiningSpeed() {
        return miningSpeed;
    }

    @Override
    public int getDurability() {
        return durability;
    }
}
