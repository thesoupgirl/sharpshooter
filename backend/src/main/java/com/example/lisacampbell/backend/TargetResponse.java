package com.example.lisacampbell.backend;

import java.util.UUID;

/**
 * Created by kieran on 7/25/15.
 */
public class TargetResponse {
    private UUID id;
    private String name;

    public TargetResponse(Player player) {
        this.id = player.getId();
        this.name = player.getName();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
