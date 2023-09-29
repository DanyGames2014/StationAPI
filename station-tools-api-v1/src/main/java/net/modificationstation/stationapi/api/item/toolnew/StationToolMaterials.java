package net.modificationstation.stationapi.api.item.toolnew;

import net.modificationstation.stationapi.api.block.MiningLevels;
import net.modificationstation.stationapi.api.registry.Identifier;

public enum StationToolMaterials implements StationToolMaterial {

    WOOD(MiningLevels.WOOD, 59, 2.0F, new float[]{0,2,3,1,4}),
    STONE(MiningLevels.STONE, 131, 4.0F, new float[]{1,3,4,2,6}),
    IRON(MiningLevels.IRON, 250, 6.0F, new float[]{2,4,5,3,8}),
    DIAMOND(MiningLevels.DIAMOND, 1561, 8.0F, new float[]{3,5,6,4,10}),
    GOLD(MiningLevels.WOOD, 32, 12.0F, new float[]{0,2,3,1,4});

    private final float[] attackDamage;
    private final Identifier miningLevel;
    private final float miningSpeed;
    private final int durability;

    StationToolMaterials(Identifier miningLevel, int durability, float miningSpeed, float[] attackDamage) {
        this.miningLevel = miningLevel;
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
    }

    @Override
    public float getAttackDamage(int index) {
        return attackDamage[index];
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
