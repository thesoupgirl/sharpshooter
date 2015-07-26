package com.example.lisacampbell.backend;

import com.google.api.server.spi.response.ConflictException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by kieran on 7/25/15.
 */
public class Game {

    private HashMap<UUID, Player> players;
    private int globalKillCount;
    private boolean inProgress;

    public Game() {
        this.players = new HashMap<UUID, Player>();
        this.globalKillCount = 0;
        this.inProgress = false;
    }

    public void addPlayer(Player player) {
        players.put(player.getId(), player);
        System.out.println("Player added: " + player.getName());
    }

    public boolean startGame() {
        if (this.inProgress) {
            return true;
        }

        this.inProgress = assignTargets();
        return this.inProgress;
    }

    private boolean assignTargets() {
        if (players.size() <= 1) {
            return false;
        }

        ArrayList<Player> playerList = new ArrayList<>();

        for(Player player : players.values()) {
            playerList.add(player);
        }

        for (int i = 0; i < playerList.size() - 1; i++) {
            playerList.get(i).setTarget(playerList.get(i + 1));
        }
        playerList.get(playerList.size() - 1).setTarget(playerList.get(0));

        return true;
    }

    public HashMap<UUID, Player> getPlayers() {
        return players;
    }

    public void setPlayers(HashMap<UUID, Player> players) {
        this.players = players;
    }

    public int getGlobalKillCount() {
        return globalKillCount;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }


    public boolean attemptKill(Player killer, String killNumber) throws ConflictException {
        if (!players.values().contains(killer)) {
            return false;
        }

        if(killer.getTarget().getKillNumber().equals(killNumber)) {
            return executeKill(killer);
        }

        throw new ConflictException("wrong kill number");
    }

    //return true if the game is over, false otherwise
    private boolean executeKill(Player killer) {
        players.remove(killer.getTarget().getId());
        killer.killTarget();
        globalKillCount++;

        if(players.size() == 1) {
            inProgress = false;
        }
        return !inProgress;
    }


}
