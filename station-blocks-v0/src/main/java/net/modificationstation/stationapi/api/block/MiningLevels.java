package net.modificationstation.stationapi.api.block;

import lombok.Getter;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;

@Getter
public enum MiningLevels {
    WOOD(ModID.MINECRAFT.id("wood")),
    STONE(ModID.MINECRAFT.id("stone")),
    IRON(ModID.MINECRAFT.id("iron")),
    DIAMOND(ModID.MINECRAFT.id("diamond"));

    private final Identifier identifier;

    MiningLevels(Identifier identifier) {
        this.identifier = identifier;
    }

}
