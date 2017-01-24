package com.example.aperez.retrofittest.mvp.model.event;

import com.example.aperez.retrofittest.mvp.model.LatestResponse;

/**
 * Created by aperez on 24/01/17.
 */

public class LatestSuccessEvent {

    LatestResponse latestResponse;

    public LatestSuccessEvent(LatestResponse latestResponse) {
        this.latestResponse = latestResponse;
    }

    public LatestResponse getLatestResponse() {
        return latestResponse;
    }
}
