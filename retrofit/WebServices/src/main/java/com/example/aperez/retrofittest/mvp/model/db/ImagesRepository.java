package com.example.aperez.retrofittest.mvp.model.db;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;
import com.example.aperez.retrofittest.mvp.model.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aperez on 26/01/17.
 */

public class ImagesRepository {

    public static List<Image> getAllImages() {
        ArrayList<Image> result = new ArrayList<>();
        for (StoredImage storedImage : getAll()) {
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

    private static List<StoredImage> getAll() {
        return new Select()
                .from(StoredImage.class)
                .execute();
    }
}
