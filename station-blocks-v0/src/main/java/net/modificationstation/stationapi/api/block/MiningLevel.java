package net.modificationstation.stationapi.api.block;

import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;

import java.util.HashMap;

public class MiningLevel {
    private static HashMap<Identifier, Integer> miningLevels = new HashMap<Identifier, Integer>();

    static {
        miningLevels.put(ModID.MINECRAFT.id("wood"),0);
        miningLevels.put(ModID.MINECRAFT.id("stone"),1);
        miningLevels.put(ModID.MINECRAFT.id("iron"),2);
        miningLevels.put(ModID.MINECRAFT.id("diamond"),3);
    }

    public static int getMiningLevel(Identifier identifier){
        if(miningLevels.containsKey(identifier)){
            return miningLevels.get(identifier);
        }
        return 0;
    }
}
