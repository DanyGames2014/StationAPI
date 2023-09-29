package net.modificationstation.stationapi.api.item.toolnew;

import net.modificationstation.stationapi.api.registry.Identifier;

public interface StationToolMaterial {
    /**
     * Index specifies the tool for which attack damage is requested in order of : Base, Pickaxe, Axe, Shovel, Sword
     */
    float getAttackDamage(int index);
    Identifier getMiningLevel();
    float getMiningSpeed();
    int getDurability();

}
