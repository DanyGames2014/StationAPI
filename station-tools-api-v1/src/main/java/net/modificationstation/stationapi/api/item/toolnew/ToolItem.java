package net.modificationstation.stationapi.api.item.toolnew;

import lombok.Getter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Living;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.StationAPI;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.block.MiningLevels;
import net.modificationstation.stationapi.api.client.gui.CustomTooltipProvider;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.tag.TagKey;

public class ToolItem extends ItemBase implements ItemTemplate, CustomTooltipProvider {

    private TagKey<BlockBase> effectiveTags;
    private ToolMaterial material;

    protected int durability;
    @Getter
    protected int miningLevel;
    @Getter
    protected float miningSpeed;
    @Getter
    protected float attackDamage;

    // Base Constructor with Raw ID
    private ToolItem(int rawId) {
        super(rawId);
        this.maxStackSize = 1;
    }

    // Base Constructor with Identifier
    public ToolItem(Identifier identifier){
        this(ItemTemplate.getNextId());
        ItemTemplate.onConstructor(this, identifier);
    }

    // Constructor to create the tool from a Material
    public ToolItem(Identifier identifier, ToolMaterial toolMaterial){
        this(identifier);
        this.material = toolMaterial;
        this.durability = toolMaterial.getDurability();
        this.miningSpeed = toolMaterial.getMiningSpeed();
        this.attackDamage = toolMaterial.getAttackDamage();
        this.miningLevel = toolMaterial.getMiningLevel();
    }

    // Constructor to create the tool from its raw properties
    public ToolItem(Identifier identifier, int miningLevel, int durability, float miningSpeed, float attackDamage){
        this(identifier, new BaseToolMaterial(miningLevel, durability, miningSpeed, attackDamage));
    }

    // Effective Blocks
    public ToolItem setEffectiveBlocks(TagKey<BlockBase> effectiveBlocks) {
        this.effectiveTags = effectiveBlocks;
        return this;
    }

    public ToolItem setEffectiveBlocks(MineableTag tag){
        this.effectiveTags = tag.getTagKey();
        return this;
    }

    public TagKey<BlockBase> getEffectiveBlocks() {
        return effectiveTags;
    }

    // DEBUG
    @Override
    public String[] getTooltip(ItemInstance itemInstance, String originalTooltip) {
        if(StationAPI.LOGGER.isDebugEnabled() || true){
            return new String[]{
                    originalTooltip,
                    "Drability : " + this.durability,
                    "Mining Level : " + this.miningLevel,
                    "Mining Speed  : " + this.miningSpeed,
                    "Attack Damage : " + this.attackDamage,
                    "Effective Tag : " + this.getEffectiveBlocks().id()
            };
        }else{
            return new String[]{
                    originalTooltip
            };
        }
    }

    // Legacy Stuff
    @Deprecated
    public ToolMaterial getMaterial(ItemInstance itemInstance) {
        return material;
    }

    @Override
    public boolean isSuitableFor(ItemInstance itemStack, BlockState state) {
        return state.isIn(effectiveTags) && (this.miningLevel >= state.getBlock().getMiningLevel());
    }

    @Override
    public float getMiningSpeedMultiplier(ItemInstance itemStack, BlockState state) {
        return isSuitableFor(itemStack, state) ? this.miningSpeed : 1F;
    }

    @Override
    public int getAttack(EntityBase arg) {
        return (int)this.attackDamage;
    }


    // Durability
    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public ItemBase setDurability(int durability) {
        this.durability = durability;
        return this;
    }

    // Attack
    public ItemBase setAttackDamage(float attackDamage) {
        this.attackDamage = attackDamage;
        return this;
    }

    // Mining Speed
    public ItemBase setMiningSpeed(float miningSpeed) {
        this.miningSpeed = miningSpeed;
        return this;
    }

    // Mining Level
    public ItemBase setMiningLevel(int miningLevel) {
        this.miningLevel = miningLevel;
        return this;
    }


    // PostHit and PostMine
    @Override
    public boolean postHit(ItemInstance itemInstance, Living otherEntity, Living player) {
        itemInstance.applyDamage(2, player);
        return true;
    }

    @Override
    public boolean postMine(ItemInstance itemInstance, int x, int y, int z, int side, Living player) {
        itemInstance.applyDamage(1, player);
        return true;
    }

    // Render
    @Environment(EnvType.CLIENT)
    public boolean isRendered3d() {
        return true;
    }
}
