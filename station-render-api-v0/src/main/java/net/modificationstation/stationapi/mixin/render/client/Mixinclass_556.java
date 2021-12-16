package net.modificationstation.stationapi.mixin.render.client;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.class_556;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.entity.Living;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlas;
import net.modificationstation.stationapi.api.client.texture.atlas.CustomAtlasProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.*;

@Mixin(class_556.class)
@Environment(EnvType.CLIENT)
public class Mixinclass_556 {

    @Unique
    private final Stack<Atlas> method_1862_customLocals_atlas = new Stack<>();

    @Inject(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            at = @At("HEAD")
    )
    private void method_1862_initCustomLocals(Living arg, ItemInstance arg1, CallbackInfo ci) {
        int itemId = arg1.itemId;
        Object item = itemId < BlockBase.BY_ID.length ? BlockBase.BY_ID[itemId] : ItemBase.byId[itemId];
        method_1862_customLocals_atlas.push(item instanceof CustomAtlasProvider ? ((CustomAtlasProvider) item).getAtlas().of(arg.method_917(arg1)) : null);
    }

    @Redirect(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/texture/TextureManager;getTextureId(Ljava/lang/String;)I",
                    ordinal = 2
            )
    )
    private int redirectItemAtlasID(TextureManager textureManager, String string, Living arg, ItemInstance arg1) {
        Atlas atlas = method_1862_customLocals_atlas.peek();
        return atlas == null ? textureManager.getTextureId(string) : atlas.getAtlasTextureID();
    }

    private final IntStack method_1862_capturedLocals_texturePosition = new IntArrayList();

    @ModifyVariable(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            index = 4,
            at = @At("STORE")
    )
    private int captureTexturePosition(int texturePosition) {
        method_1862_capturedLocals_texturePosition.push(texturePosition);
        return texturePosition;
    }

    @Unique
    private final Stack<Atlas.Sprite> method_1862_customLocals_texture = new Stack<>();

    @ModifyVariable(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            index = 5,
            at = @At("STORE")
    )
    private float modifyStartU(float originalStartU) {
        Atlas atlas = method_1862_customLocals_atlas.peek();
        Atlas.Sprite texture = atlas == null ? null : atlas.getTexture(method_1862_capturedLocals_texturePosition.peekInt(0));
        method_1862_customLocals_texture.push(texture);
        return texture == null ? originalStartU : (float) texture.getStartU();
    }

    @ModifyVariable(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            index = 6,
            at = @At("STORE")
    )
    private float modifyEndU(float originalEndU) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? originalEndU : (float) texture.getEndU();
    }

    @ModifyVariable(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            index = 7,
            at = @At("STORE")
    )
    private float modifyStartV(float originalStartV) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? originalStartV : (float) texture.getStartV();
    }

    @ModifyVariable(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            index = 8,
            at = @At("STORE")
    )
    private float modifyEndV(float originalEndV) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? originalEndV : (float) texture.getEndV();
    }

    @ModifyConstant(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            constant = @Constant(
                    ordinal = 8,
                    intValue = 16
            )
    )
    private int modifyAmountOfNorthVertexes(int constant) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? constant : texture.getHeight();
    }

    @ModifyConstant(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            constant = @Constant(
                    ordinal = 0,
                    floatValue = 16
            )
    )
    private float modifyNorthVertexesDenominator(float constant) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? constant : texture.getHeight();
    }

    @ModifyConstant(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            constant = @Constant(
                    ordinal = 0,
                    floatValue = 0.001953125F
            )
    )
    private float modifyNorthVertexesNudge(float constant) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? constant : 1F / (texture.getHeight() * texture.getHeight() * 2);
    }

    @ModifyConstant(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            constant = @Constant(
                    ordinal = 9,
                    intValue = 16
            )
    )
    private int modifyAmountOfSouthVertexes(int constant) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? constant : texture.getHeight();
    }

    @ModifyConstant(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            constant = @Constant(
                    ordinal = 1,
                    floatValue = 16
            )
    )
    private float modifySouthVertexesDenominator(float constant) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? constant : texture.getHeight();
    }

    @ModifyConstant(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            constant = @Constant(
                    ordinal = 1,
                    floatValue = 0.001953125F
            )
    )
    private float modifySouthVertexesNudge(float constant) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? constant : 1F / (texture.getHeight() * texture.getHeight() * 2);
    }

    @ModifyConstant(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            constant = @Constant(
                    ordinal = 1,
                    floatValue = 0.0625F
            )
    )
    private float modifySouthVertexesReciprocal(float constant) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? constant : 1F / texture.getHeight();
    }

    @ModifyConstant(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            constant = @Constant(
                    ordinal = 10,
                    intValue = 16
            )
    )
    private int modifyAmountOfTopVertexes(int constant) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? constant : texture.getWidth();
    }

    @ModifyConstant(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            constant = @Constant(
                    ordinal = 2,
                    floatValue = 16
            )
    )
    private float modifyTopVertexesDenominator(float constant) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? constant : texture.getWidth();
    }

    @ModifyConstant(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            constant = @Constant(
                    ordinal = 2,
                    floatValue = 0.001953125F
            )
    )
    private float modifyTopVertexesNudge(float constant) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? constant : 1F / (texture.getWidth() * texture.getWidth() * 2);
    }

    @ModifyConstant(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            constant = @Constant(
                    ordinal = 2,
                    floatValue = 0.0625F
            )
    )
    private float modifyTopVertexesReciprocal(float constant) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? constant : 1F / texture.getWidth();
    }

    @ModifyConstant(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            constant = @Constant(
                    ordinal = 11,
                    intValue = 16
            )
    )
    private int modifyAmountOfBottomVertexes(int constant) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? constant : texture.getWidth();
    }

    @ModifyConstant(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            constant = @Constant(
                    ordinal = 3,
                    floatValue = 16
            )
    )
    private float modifyBottomVertexesDenominator(float constant) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? constant : texture.getWidth();
    }

    @ModifyConstant(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            constant = @Constant(
                    ordinal = 3,
                    floatValue = 0.001953125F
            )
    )
    private float modifyBottomVertexesNudge(float constant) {
        Atlas.Sprite texture = method_1862_customLocals_texture.peek();
        return texture == null ? constant : 1F / (texture.getWidth() * texture.getWidth() * 2);
    }

    @Inject(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/Tessellator;draw()V",
                    shift = At.Shift.BEFORE,
                    ordinal = 5
            )
    )
    private void popTexture(Living arg, ItemInstance arg1, CallbackInfo ci) {
        method_1862_customLocals_texture.pop();
    }

    @Inject(
            method = "method_1862(Lnet/minecraft/entity/Living;Lnet/minecraft/item/ItemInstance;)V",
            at = @At("RETURN")
    )
    private void method_1862_clearCustomLocals(Living arg, ItemInstance arg1, CallbackInfo ci) {
        method_1862_customLocals_atlas.pop();
    }
}
