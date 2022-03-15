package net.modificationstation.stationapi.mixin.item;

import net.minecraft.stat.Stats;
import net.modificationstation.stationapi.api.StationAPI;
import net.modificationstation.stationapi.api.event.registry.AfterBlockAndItemRegisterEvent;
import net.modificationstation.stationapi.api.registry.ItemRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Stats.class)
public class MixinStats {

    @ModifyConstant(
            method = "setupCrafting()V",
            constant = @Constant(intValue = 32000)
    )
    private static int getItemsSize(int constant) {
        return ItemRegistry.INSTANCE.getSize();
    }

    @SuppressWarnings({"InvalidMemberReference", "UnresolvedMixinReference", "MixinAnnotationTarget"})
    @Inject(
            method = "setupCrafting()V",
            at = @At(
                    value = "NEW",
                    target = "()Ljava/util/HashSet;",
                    shift = At.Shift.BEFORE
            )
    )
    private static void afterBlockAndItemRegister(CallbackInfo ci) {
        StationAPI.EVENT_BUS.post(new AfterBlockAndItemRegisterEvent());
    }
}