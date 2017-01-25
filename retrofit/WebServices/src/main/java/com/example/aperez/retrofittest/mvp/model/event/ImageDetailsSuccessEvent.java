package com.example.aperez.retrofittest.mvp.model.event;

import com.example.aperez.retrofittest.mvp.model.Image;

/**
 * Created by aperez on 25/01/17.
 */

public class ImageDetailsSuccessEvent {

    Image image;

    public ImageDetailsSuccessEvent(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }
}
