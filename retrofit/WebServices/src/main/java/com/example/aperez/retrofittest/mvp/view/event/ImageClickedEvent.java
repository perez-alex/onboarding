package com.example.aperez.retrofittest.mvp.view.event;

/**
 * Created by aperez on 25/01/17.
 */

public class ImageClickedEvent {

    String id;

    public ImageClickedEvent(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
