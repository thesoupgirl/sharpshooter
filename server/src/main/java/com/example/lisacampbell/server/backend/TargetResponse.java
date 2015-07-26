package com.example.lisacampbell.server.backend;

import java.util.UUID;

/**
 * Created by kieran on 7/25/15.
 */
public class TargetResponse {
    private UUID id;
    private String name;
    private String pictureByteString;

    public TargetResponse(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.pictureByteString = player.getPictureByteString();
    }

    public UUID getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getPictureByteString() {
        return pictureByteString;
    }
}
