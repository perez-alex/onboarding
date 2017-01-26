package com.example.aperez.retrofittest.mvp.model.db;

import com.activeandroid.ActiveAndroid;
import com.example.aperez.retrofittest.mvp.model.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aperez on 26/01/17.
 */

public class ImagesRepository {

    public static List<Image> getAllImages() {
        ArrayList<Image> result = new ArrayList<>();
        for (StoredImage storedImage : StoredImage.getAll()) {
            result.add(new Image(storedImage));
        }
        return result;
    }

    public static void saveImages(List<Image> images) {
        ActiveAndroid.beginTransaction();
        try {
            for (Image image : images) {
                new StoredImage(image).save();
            }
            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
    }
}
