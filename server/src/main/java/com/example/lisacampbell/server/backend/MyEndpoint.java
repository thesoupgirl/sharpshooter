/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.lisacampbell.server.backend;


import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(name = "myApi", version = "v1", namespace = @ApiNamespace(ownerDomain = "backend.lisacampbell.example.com", ownerName = "backend.lisacampbell.example.com", packagePath = ""))
public class MyEndpoint {

    private static Game game = new Game();

    static{
        game.addPlayer(new Player("george"));
        game.addPlayer(new Player("kieran"));
        game.addPlayer(new Player("lisa"));
        game.addPlayer(new Player("jordan"));
        game.addPlayer(new Player("sally"));
        game.addPlayer(new Player("claire"));
    }


    @ApiMethod(name = "startGame", httpMethod = "POST")
    public BooleanResponse startGame() {
        BooleanResponse response = new BooleanResponse();
        response.setResponse(game.startGame());
        return response;
    }

    @ApiMethod(name = "attemptKill", httpMethod = "DELETE")
    public BooleanResponse attemptKill(@Named("killerId") String killerId,@Named("killNumber") String killNumber) throws NotFoundException, ConflictException {
        if (!game.getPlayers().containsKey(UUID.fromString(killerId))) {
            throw new NotFoundException("player not found");
        }

        Player killer = game.getPlayers().get(UUID.fromString(killerId));
        BooleanResponse response = new BooleanResponse();
        response.setResponse(game.attemptKill(killer, killNumber));
        return response;
    }

    @ApiMethod(name = "getPlayers", httpMethod = "GET")
    public Set<PlayerResponse> getPlayers() {
        Set<PlayerResponse> players = new HashSet<PlayerResponse>();
        for (Player player : game.getPlayers().values()){
            players.add(new PlayerResponse(player));
        }
        return players;
    }

//    @ApiMethod(name = "kill", httpMethod = "DELETE")
//    public BooleanResponse kill(@Named("killerId") String killerId) throws NotFoundException {
//        HashMap<UUID, Player> players = game.getPlayers();
//        UUID id = UUID.fromString(killerId);
//        if (!players.containsKey(id)) {
//            throw new NotFoundException("player not found");
//        }
//
//        System.out.println(players.get(id).getName() + " to kill " + players.get(id).getTarget().getName());
//        BooleanResponse response = new BooleanResponse();
//        response.setResponse(game.executeKill(players.get(id)));
//        return response;
//    }

    @ApiMethod(name = "getTargetFor", httpMethod = "GET")
    public PlayerResponse getTarget(@Named("playerId") String playerId) throws NotFoundException{
        UUID id = UUID.fromString(playerId);
        if (!game.getPlayers().containsKey(id)) {
            throw new NotFoundException("player not found");
        }

        return new PlayerResponse(game.getPlayers().get(id));
    }

    @ApiMethod(name = "restartGame", httpMethod = "POST")
    public Game restartGame() {
        game = new Game();
        return game;
    }



    @ApiMethod(name = "addPlayer", httpMethod = "POST")
    public Player addPlayer(@Named("name") String name, @Named("byteString") String byteString) {
        Player player = new Player(name, byteString);
        game.addPlayer(player);
        return player;
    }

}
