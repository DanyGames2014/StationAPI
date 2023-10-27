package net.modificationstation.stationapi.mixin.worldgen;

import net.minecraft.level.biome.Biome;
import net.minecraft.level.dimension.Dimension;
import net.minecraft.level.dimension.Nether;
import net.modificationstation.stationapi.api.worldgen.BiomeAPI;
import net.modificationstation.stationapi.impl.level.StationDimension;
import net.modificationstation.stationapi.impl.worldgen.NetherBiomeSourceImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;

@Mixin(Nether.class)
public class MixinNether extends Dimension implements StationDimension {
    @Inject(
            method = "initBiomeSource()V",
            at = @At("TAIL")
    )
    private void setNetherBiomeSource(CallbackInfo info) {
        this.biomeSource = NetherBiomeSourceImpl.getInstance();
    }
    
    @Override
    public Collection<Biome> getBiomes() {
        return BiomeAPI.getNetherProvider().getBiomes();
    }
}
