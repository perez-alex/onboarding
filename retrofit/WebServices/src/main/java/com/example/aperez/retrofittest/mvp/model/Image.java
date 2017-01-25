package com.example.aperez.retrofittest.mvp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aperez on 24/01/17.
 */

public class Image {

    Long id;
    String url;
    @SerializedName("large_url")
    String largeUrl;
    @SerializedName("source_id")
    String sourceId;
    String copyright;
    String site;

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public String getCopyright(){
        return copyright;
    }

    public String getSite(){
        return site;
    }
}
