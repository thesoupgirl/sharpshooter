package com.example.lisacampbell.sharpshooterapp.service;

import android.os.Environment;
import android.util.Base64;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Singleton service
 *
 * Created by georgeruan on 7/25/15.
 */
public class ImageService {
    private static ImageService instance = null;
    private static ArrayList<File> photos = new ArrayList<>();


    private ImageService() {
        // Exists only to override default constructor
    }

    public static ImageService getInstance() {
        if(instance == null){
            instance = new ImageService();
        }
        return instance;
    }

    public File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";

        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);

        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );

        photos.add(image);

        return image;
    }

    public byte[] imageToByteArray(File image) {
        FileInputStream fileInputStream = null;

        byte[] byteFile = new byte[(int) image.length()];

        try {
            // Convert file into array of bytes
            fileInputStream = new FileInputStream(image);
            fileInputStream.read(byteFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return byteFile;
    }

    public String byteArrayToString(byte[] byteArray) {
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    public byte[] stringToByteArray(String str) {
        return Base64.decode(str, Base64.DEFAULT);
    }


    public void deleteImages() throws IOException {
        for(File file : photos) {
            file.delete();
        }
    }


    /*
    public void takePictureIntent() {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // Ensure that there's a camera activity to handle the intent
        if(takePicture.resolveActivity(getPackageManager()) != null) {
            File photo = null;
            try {
                photo = createImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Continue only if the File was successfully created
            if (photo != null) {
                takePicture.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photo));
                startActivityForResult(takePicture, 1);
            }
        }
    }
    */
}
