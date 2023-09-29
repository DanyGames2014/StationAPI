package net.modificationstation.stationapi.api.item.toolnew.material;

import net.modificationstation.stationapi.api.block.MiningLevels;

@SuppressWarnings("unused")
public class StationToolMaterials {
    public static final StationToolMaterialBase WOOD = new StationToolMaterialBase(MiningLevels.WOOD, 59, 2.0F, new float[]{0, 2, 3, 1, 4});
    public static final StationToolMaterialBase STONE = new StationToolMaterialBase(MiningLevels.STONE, 131, 4.0F, new float[]{1, 3, 4, 2, 6});
    public static final StationToolMaterialBase IRON = new StationToolMaterialBase(MiningLevels.IRON, 250, 6.0F, new float[]{2, 4, 5, 3, 8});
    public static final StationToolMaterialBase DIAMOND = new StationToolMaterialBase(MiningLevels.DIAMOND, 1561, 8.0F, new float[]{3, 5, 6, 4, 10});
    public static final StationToolMaterialBase GOLD = new StationToolMaterialBase(MiningLevels.WOOD, 32, 12.0F, new float[]{0, 2, 3, 1, 4});
}
