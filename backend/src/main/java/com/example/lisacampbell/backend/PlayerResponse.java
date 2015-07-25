package com.example.lisacampbell.backend;

import java.util.UUID;

/**
 * Created by kieran on 7/25/15.
 */
public class PlayerResponse {
    private UUID id;
    private String name;
    private TargetResponse target;

    public PlayerResponse(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.target = new TargetResponse(player.getTarget());
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

    public TargetResponse getTarget() {
        return target;
    }

    public void setTarget(TargetResponse target) {
        this.target = target;
    }
}
