package com.example.lisacampbell.server.backend;

import com.example.lisacampbell.server.faceplusplus.FaceService;
import com.google.appengine.repackaged.com.google.api.client.util.Base64;

import java.util.Random;
import java.util.UUID;

/**
 * Created by kieran on 7/25/15.
 */
public class Player {
    private UUID id;
    private String name;
    private Player target;
    private int killCount;
    private String killNumber;
    private String pictureByteString;

    public Player(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.killCount = 0;
        this.killNumber = getRandomKillNumber();
        this.target = null;
        this.pictureByteString = "no picture";
    }

    public Player(String name, String pictureByteString) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.killCount = 0;
        this.killNumber = getRandomKillNumber();
        this.target = null;
        this.pictureByteString = pictureByteString;
    }


    private static String getRandomKillNumber() {
        Random random = new Random();
        Integer num = random.nextInt(89999) + 10000;
        return num.toString();
    }

    private String createPerson(String[] byteStrings) {
        String personId = FaceService.createPerson(this.name);
        for (int i = 0; i < byteStrings.length; i++) {
            byte[] bytes = Base64.decodeBase64(byteStrings[i]);
            String faceId = FaceService.uploadFace(bytes);
            FaceService.personAddFace(personId, faceId);
        }

        return personId;
    }

    public String getName() {
        return name;
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

    public String getKillNumber() {
        return killNumber;
    }

    public String getPictureByteString() {
        return pictureByteString;
    }

    public void killTarget() {
        this.target = this.target.getTarget();
        killCount++;
    }
}
