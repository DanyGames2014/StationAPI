package net.modificationstation.stationapi.api.common.util;

import net.minecraft.client.sound.SoundEntry;

import java.net.URL;

public interface CustomSoundMap {
    SoundEntry putSound(String id, URL url);
}
