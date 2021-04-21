package net.modificationstation.stationapi.impl.client.model;

import lombok.Data;

@Data
public class JsonModel {
    private HashMap<String, String> textures;
    private JsonCuboid[] elements;
}