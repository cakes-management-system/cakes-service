package com.koltsov.cms.service.cakes;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class CakeHelper {

    public static final long ID = 1L;
    public static final String NAME = "Наполеон";
    public static final UUID RANDOM_UUID = UUID.randomUUID();
    public static final Long IMAGE_LENGTH = 1_000L;
    public static final String IMAGE_MIMO_TYPE = "image/jpeg";

    public static Cake createCake() {
        return createCake(NAME);
    }

    public static Cake createCake(String name) {
        Cake cake = new Cake();
        cake.setId(ID);
        cake.setName(name);
        cake.setImageId(RANDOM_UUID);
        cake.setImageLength(IMAGE_LENGTH);
        cake.setImageMimeType(IMAGE_MIMO_TYPE);
        return cake;
    }
}
