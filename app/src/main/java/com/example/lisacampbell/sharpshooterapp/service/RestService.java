package com.example.lisacampbell.sharpshooterapp.service;

import com.example.lisacampbell.sharpshooterapp.service.HttpRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;


/**
 * Created by georgeruan on 7/26/15
 */
public class RestService {
    private static RestService instance = null;
    private static final String baseUrl = "https://sharpshooter-1017.appspot.com/_ah/api/myApi/v1/";

    private RestService() {
        /* Override default constructor */
    }

    /**
     * Public instantiator of the singleton
     * @return The single instance of the class
     */
    public static RestService generateInstance() {
        if(instance == null) {
            instance = new RestService();
        }
        return instance;
    }

    /**
     * Add a player to the server
     * @param name The name of the player
     * @return The String of the UUID
     */
    public String addPlayer(String name) {
        String id = "";

        try {
            HttpRequest request = HttpRequest.post(baseUrl + "addPlayer");
            request.trustAllCerts();
            request.trustAllHosts();

            id = new JSONObject(request.send("name=" + name).body()).getString("id");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    /**
     * Sends a request to the server to start the game
     */
    public void startGame() {
        HttpRequest request = HttpRequest.post(baseUrl + "startGame");
        request.trustAllCerts();
        request.trustAllHosts();

        int response = request.code();
        if(response != 200) {
            System.out.println("Error with code " + response);
        }
    }

    /**
     * Restarts the instance of the game.
     */
    public void restartGame() {
        HttpRequest request = HttpRequest.post(baseUrl + "startGame");
        request.trustAllCerts();
        request.trustAllHosts();

        int response = request.code();

        if(response != 200) {
            System.out.println("Error with code " + response);
        }
    }

    /**
     * Calls the server with a GET request
     * @param playerId The ID of the player
     * @return The name of the target
     */
    public String getTarget(String playerId) {
        String response = "";
        try {
            HttpRequest request = HttpRequest.get(baseUrl + "getTargetFor");
            request.trustAllCerts();
            request.trustAllHosts();

            response = new JSONObject(request.send("playerId=" + playerId).body()).getString("name");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * Gets an ArrayList of all the players names
     * @return The ArrayList of all the players names
     */
    public ArrayList<String> getPlayers() {
        ArrayList<String> response = new ArrayList<>();
        try {
            HttpRequest request = HttpRequest.get(baseUrl + "playerresponsecollection");
            request.trustAllCerts();
            request.trustAllHosts();

            JSONArray jsonArray = new JSONObject(request.body()).getJSONArray("items");
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject player = jsonArray.getJSONObject(i);
                response.add(player.getString("name"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * Sends a request to the server to attempt a kill
     * @param killerId The current player's id
     * @param killNumber The attempted number that the player entered
     * @return Whether the attempt was successful.
     */
    public Boolean attemptKill(String killerId, String killNumber) {
        Boolean success = false;
        try {
            HttpRequest request = HttpRequest.delete(baseUrl + "attemptKill");
            request.trustAllCerts();
            request.trustAllHosts();

            success = new JSONObject(request.send("killerId=" + killerId)
                    .send("killNumber=" + killNumber).body()).getBoolean("response");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return success;
    }

    /**
     * Sends a request to the server to determine if the player is alive.
     * @param playerId The id of the current player in question.
     * @return True if alive, false if dead.
     */
    public Boolean playerAlive(String playerId) {
        Boolean alive = false;
        try {
            HttpRequest request = HttpRequest.post(baseUrl + "playerAlive");
            request.trustAllCerts();
            request.trustAllHosts();

            alive = new JSONObject(request.send("playerId=" + playerId).body())
                    .getBoolean("response");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return alive;
    }
}