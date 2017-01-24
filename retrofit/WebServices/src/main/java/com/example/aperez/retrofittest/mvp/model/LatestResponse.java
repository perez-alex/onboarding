package com.example.aperez.retrofittest.mvp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aperez on 24/01/17.
 */

public class LatestResponse {

    List<Image> images;

    public LatestResponse() {
        images = new ArrayList<>();
    }

    public List<Image> getImages() {
        return images;
    }
}
