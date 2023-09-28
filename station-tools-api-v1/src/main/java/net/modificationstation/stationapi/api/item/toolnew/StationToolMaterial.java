package net.modificationstation.stationapi.api.item.toolnew;

import net.modificationstation.stationapi.api.registry.Identifier;

public interface StationToolMaterial {
    float getAttackDamage();
    Identifier getMiningLevel();
    float getMiningSpeed();
    int getDurability();

}
