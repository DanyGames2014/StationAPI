package net.modificationstation.stationapi.api.block;

import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;

import java.util.HashMap;

public class MiningLevels {
    //TODO : Event that fires before Blocks and Items are registered to manipulate the mining levels because once the blocks and items are initialized they only take the int to prevent lookups here for every mining level check

    public static final Identifier WOOD = ModID.MINECRAFT.id("wood");
    public static final Identifier STONE = ModID.MINECRAFT.id("stone");
    public static final Identifier IRON = ModID.MINECRAFT.id("iron");
    public static final Identifier DIAMOND = ModID.MINECRAFT.id("diamond");

    private static HashMap<Identifier, Integer> miningLevels = new HashMap<>();

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

    public static Identifier getFirstIdentifierWithMiningLevel(int miningLevel){
       for(var item : miningLevels.entrySet()){
           if(item.getValue() == miningLevel){
               return item.getKey();
           }
       }
       return null;
    }

    public static void addMiningLevelBefore(Identifier identifier, Identifier identifierToAddBefore, int miningLevel){
        //TODO : addBefore method which takes in Identifier and then puts the specified mining level before the mining level with that identifier, shifting all following mining level ints by 1
    }

    public static void addMiningLevel(Identifier identifier, int miningLevel){
        miningLevels.put(identifier, miningLevel);
    }


}
