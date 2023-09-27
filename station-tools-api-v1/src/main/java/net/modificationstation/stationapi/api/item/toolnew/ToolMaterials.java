package net.modificationstation.stationapi.api.item.toolnew;

public enum ToolMaterials implements ToolMaterial{

    WOOD(0, 59, 2.0F, 0),
    STONE(1, 131, 4.0F, 1),
    IRON(2, 250, 6.0F, 2),
    DIAMOND(3, 1561, 8.0F, 3),
    GOLD(0, 32, 12.0F, 0);

    private final float attackDamage;
    private final int miningLevel;
    private final float miningSpeed;
    private final int durability;

    ToolMaterials( int miningLevel, int durability, float miningSpeed, float attackDamage) {
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
    public int getMiningLevel() {
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
