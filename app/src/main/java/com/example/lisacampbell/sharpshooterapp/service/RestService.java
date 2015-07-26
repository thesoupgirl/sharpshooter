package com.example.lisacampbell.sharpshooterapp.service;

import com.example.lisacampbell.backend.myApi.model.BooleanResponse;
import com.example.lisacampbell.backend.myApi.model.PlayerResponse;

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
    private static final String baseUrl = "sharpshooter-1017.appspot.com/_ah/api/myApi/v1/";

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
     * @param regId ???
     * @param byteString ??? placeholder of image
     * @return The String of the UUID
     */
    public String addPlayer(String name, String regId, String byteString) {
        String id = "";

        try {
            id = new JSONObject(HttpRequest.post(baseUrl + "addPlayer")
                    .send("name=" + name).send("regId="+regId).send("byteString="+byteString).
                            body()).getString("id");
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
        int response = HttpRequest.post(baseUrl + "startGame").send("").code();

        if(response != 200) {
            System.out.println("Error with code " + response);
        }
    }

    /**
     * Restarts the instance of the game.
     */
    public void restartGame() {
        int response = HttpRequest.post(baseUrl + "startGame").send("").code();

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
            response = new JSONObject(HttpRequest.get(baseUrl + "getTargetFor")
                    .send("playerId="+playerId).body()).getString("name");
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
            JSONArray jsonArray = new JSONObject(HttpRequest.get(baseUrl + "playerresponsecollection").body())
                    .getJSONArray("items");
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
            success = new JSONObject(HttpRequest.delete(baseUrl + "attemptKill")
                    .send("killerId="+killerId).send("killNumber="+killNumber).body())
                    .getBoolean("response");
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
            alive = new JSONObject(HttpRequest.post(baseUrl + "playerAlive")
                    .send("playerId="+playerId).body()).getBoolean("response");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return alive;
    }
}