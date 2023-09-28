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
import net.modificationstation.stationapi.api.block.MiningLevel;
import net.modificationstation.stationapi.api.client.gui.CustomTooltipProvider;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.tag.TagKey;

public class StationToolBase extends ItemBase implements ItemTemplate, CustomTooltipProvider {

    /**
     * The tag this tool will be effective on
     */
    private TagKey<BlockBase> effectiveTag;
    /**
     * The material this tool was generated from
     */
    private StationToolMaterial material;


    protected int durability;
    @Getter
    protected int miningLevel;
    @Getter
    protected float miningSpeed;
    @Getter
    protected float attackDamage;

    /**
     * Base constructor with Raw ID
     * @param rawId Raw ID of the Item
     */
    private StationToolBase(int rawId) {
        super(rawId);
        this.maxStackSize = 1;
    }


    /**
     * Base constructor with only modifier, this will generate a tool where all the parameters are 0 and isnt effective on anything
     * @param identifier Identifier
     */
    public StationToolBase(Identifier identifier){
        this(ItemTemplate.getNextId());
        ItemTemplate.onConstructor(this, identifier);
    }

    /**
     * Creates a tool using a specified material
     * @param identifier Identifier
     * @param toolMaterial Material to take the tool properties from
     */
    public StationToolBase(Identifier identifier, StationToolMaterial toolMaterial){
        this(identifier);
        this.material = toolMaterial;
        this.durability = toolMaterial.getDurability();
        this.miningSpeed = toolMaterial.getMiningSpeed();
        this.attackDamage = toolMaterial.getAttackDamage();
        this.miningLevel = MiningLevel.getMiningLevel(toolMaterial.getMiningLevel());
    }


    /**
     * Creates a tool using the specified properties
     * @param identifier Identifier
     * @param miningLevel Mining Level
     * @param durability Duabilitiy
     * @param miningSpeed Mining Speed
     * @param attackDamage Attack Damage
     */
    public StationToolBase(Identifier identifier, Identifier miningLevel, int durability, float miningSpeed, float attackDamage){
        this(identifier, new BaseToolMaterial(miningLevel, durability, miningSpeed, attackDamage));
    }

    // Effective Blocks
    public StationToolBase setEffectiveBlocks(TagKey<BlockBase> effectiveBlocks) {
        this.effectiveTag = effectiveBlocks;
        return this;
    }

    public StationToolBase setEffectiveBlocks(MineableTag tag){
        this.effectiveTag = tag.getTagKey();
        return this;
    }

    public TagKey<BlockBase> getEffectiveBlocks() {
        return effectiveTag;
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
    public StationToolMaterial getMaterial(ItemInstance itemInstance) {
        return material;
    }

    @Override
    public boolean isSuitableFor(ItemInstance itemStack, BlockState state) {
        return state.isIn(effectiveTag) && (this.miningLevel >= state.getBlock().getMiningLevel());
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
