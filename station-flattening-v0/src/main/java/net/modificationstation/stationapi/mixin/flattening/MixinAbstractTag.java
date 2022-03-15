package net.modificationstation.stationapi.mixin.flattening;

import net.minecraft.util.io.AbstractTag;
import net.minecraft.util.io.LongArrayTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractTag.class)
public class MixinAbstractTag {

    @Inject(
            method = "getTagFromId(B)Lnet/minecraft/util/io/AbstractTag;",
            at = @At(
                    value = "RETURN",
                    ordinal = 11
            ),
            cancellable = true
    )
    private static void getCustomTag(byte id, CallbackInfoReturnable<AbstractTag> cir) {
        if (id == 12)
            cir.setReturnValue(new LongArrayTag());
    }

    @ModifyConstant(
            method = "getTagTypeById(B)Ljava/lang/String;",
            constant = @Constant(stringValue = "UNKNOWN")
    )
    private static String getCustomTagName(String constant, byte id) {
        return id == 12 ? "TAG_Long_Array" : constant;
    }
}