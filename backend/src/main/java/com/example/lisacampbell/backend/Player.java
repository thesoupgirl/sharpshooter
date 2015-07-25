package com.example.lisacampbell.backend;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by kieran on 7/25/15.
 */
public class Player {
    private UUID id;
    private String name;
    private Player target;
    private int killCount;
    private String personId;

    public Player(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.killCount = 0;
        this.target = null;
        this.personId = createPerson();
    }

    public static String createPerson() {
        return "paceholder person id";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getTarget() {
        return target;
    }

    public void setTarget(Player target) {
        this.target = target;
        System.out.println("Set target for " + this.name + ": " + this.target.name);
    }

    public int getKillCount() {
        return killCount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public void killTarget() {
        this.target = this.target.getTarget();
        killCount++;
    }
}
