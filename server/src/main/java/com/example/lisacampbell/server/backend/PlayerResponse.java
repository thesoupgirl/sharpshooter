package com.example.lisacampbell.server.backend;

import java.util.UUID;

/**
 * Created by kieran on 7/25/15.
 */
public class PlayerResponse {
    private UUID id;
    private String name;
    private String killNumber;
    private TargetResponse target;

    public PlayerResponse(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.killNumber = player.getKillNumber();
        this.target = new TargetResponse(player.getTarget());
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TargetResponse getTarget() {
        return target;
    }

    public String getKillNumber() {
        return killNumber;
    }
}
