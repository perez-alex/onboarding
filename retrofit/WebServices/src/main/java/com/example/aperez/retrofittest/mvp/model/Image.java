package com.example.aperez.retrofittest.mvp.model;

import android.database.Cursor;

import com.example.aperez.retrofittest.mvp.model.db.StoredImage;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aperez on 24/01/17.
 */

public class Image {

    @SerializedName("id")
    Long imageId;
    String url;
    @SerializedName("large_url")
    String largeUrl;
    String copyright;
    String site;

    public Image(Cursor cursor){
        imageId = cursor.getLong(cursor.getColumnIndex("imageId"));
        url = cursor.getString(cursor.getColumnIndex("url"));
        largeUrl = cursor.getString(cursor.getColumnIndex("largeUrl"));
    }

    public Image(StoredImage image) {
        imageId = image.getImageId();
        url = image.getUrl();
        largeUrl = image.getLargeUrl();
    }

    public Long getImageId() {
        return imageId;
    }

    public String getUrl() {
        return url;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getSite() {
        return site;
    }
}
