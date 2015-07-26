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

    private static RestService generateAppId() {
        if(instance == null) {
            instance = new RestService();
        }
        return instance;
    }

    public UUID addPlayer(String name) {
        UUID id = null;

        try {
            String strId = new JSONObject(HttpRequest.post(baseUrl + "addPlayer").send("name=" + name).body())
                    .getString("id");
            id = UUID.fromString(strId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public void startGame() {
        int response = HttpRequest.post(baseUrl + "startGame").send("").code();

        if(response != 200) {
            System.out.println("Error with code " + response);
        }
    }

    public void restartGame() {
        int response = HttpRequest.post(baseUrl + "startGame").send("").code();

        if(response != 200) {
            System.out.println("Error with code " + response);
        }
    }

    public String getTarget() {
        String response = "";
        try {
            response = new JSONObject(HttpRequest.get(baseUrl + "getTargetFor").body())
                    .getString("name");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

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

    public Boolean attemptKill() {
        Boolean success = false;
        try {
            success = new JSONObject(HttpRequest.delete(baseUrl + "attemptKill").body())
                    .getBoolean("response");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return success;
    }

    public Boolean checkStatus() {
        Boolean success = false;
        try {
            success = new JSONObject(HttpRequest.delete(baseUrl + "checkStatus").body())
                    .getBoolean("response");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return success;
    }
}