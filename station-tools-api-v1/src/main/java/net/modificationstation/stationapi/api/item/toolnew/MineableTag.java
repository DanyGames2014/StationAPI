package net.modificationstation.stationapi.api.item.toolnew;

import net.minecraft.block.BlockBase;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.tag.TagKey;

@SuppressWarnings("LombokGetterMayBeUsed")
public enum MineableTag {
    PICKAXE(TagKey.of(BlockRegistry.INSTANCE.getKey(), Identifier.of("mineable/pickaxe"))),
    AXE(TagKey.of(BlockRegistry.INSTANCE.getKey(), Identifier.of("mineable/axe"))),
    SHOVEL(TagKey.of(BlockRegistry.INSTANCE.getKey(), Identifier.of("mineable/shovel"))),
    SWORD(TagKey.of(BlockRegistry.INSTANCE.getKey(), Identifier.of("mineable/sword"))),
    HOE(TagKey.of(BlockRegistry.INSTANCE.getKey(), Identifier.of("mineable/hoe"))),
    SHEARS(TagKey.of(BlockRegistry.INSTANCE.getKey(), Identifier.of("mineable/shears")));

    private final TagKey<BlockBase> tagKey;

    MineableTag(TagKey<BlockBase> tagKey) {
        this.tagKey = tagKey;
    }

    public TagKey<BlockBase> getTagKey(){
        return tagKey;
    }
}
