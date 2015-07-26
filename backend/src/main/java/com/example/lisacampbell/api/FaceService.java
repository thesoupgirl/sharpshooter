package com.example.lisacampbell.api;
/**
 * Created by georgeruan on 7/25/15.
 */

import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;

import org.json.JSONObject;

public class FaceService {
    private static final HttpRequests httpRequests = new HttpRequests("c0f25c4a3284aa6bffbeaeee4b1047b9", "YwB89qNNLBza9BDQvj_8nJSbrFkaCALv", true, true);

    public FaceService() {
        // Do nothing
    }


    /**
     * Creates a person object on the server
     * @param name The name of the person
     * @return personId
     */
    public static String createPerson(String name) {
        String personId = "";

        try {
            JSONObject response = httpRequests.personCreate(new PostParameters().setPersonName(name));
            personId = response.getString("person_id");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return personId;
    }

    /**
     * Uploads a face to a server via an image
     * @param data Image represented by a byte array
     * @return faceId
     */
    public static String uploadFace(byte[] data) {
        String faceId = "";

        try {
            JSONObject response = httpRequests.detectionDetect(new PostParameters().setImg(data));
            faceId = response.getJSONArray("face").getJSONObject(0).getString("face_id");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            return faceId;
        }
    }

    /**
     * Associates a face to a person object.
     * @param personId the personId of the person.
     * @param faceId The faceId of the Face.
     */
    public static void personAddFace(String personId, String faceId) {
        try {
            httpRequests.personAddFace(new PostParameters().setPersonId(personId).setFaceId(faceId));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Determines whether the face belongs to the person
     * @param faceId The id of the face image
     * @param personId The id of the person to compare the face with
     * @return Whether the face belongs to the person
     */
    public static Boolean compareFace(String faceId, String personId) {
        boolean match = false;

        try {
            JSONObject response = httpRequests.recognitionVerify(new PostParameters().setPersonId(personId).setFaceId(faceId));
            match = response.getBoolean("is_same_person");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return match;
    }
}
