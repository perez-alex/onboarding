package com.example.aperez.retrofittest.mvp.view;

import android.app.Activity;
import android.widget.TextView;

import com.example.aperez.retrofittest.R;
import com.example.aperez.retrofittest.mvp.model.Image;
import com.example.aperez.retrofittest.mvp.model.LatestResponse;
import com.squareup.otto.Bus;

import java.util.List;

import butterknife.BindView;

/**
 * Created by aperez on 24/01/17.
 */

public class ResponseView extends ActivityView {


    private final Bus bus;
    @BindView(R.id.response)
    TextView response;

    public ResponseView(Activity activity, Bus bus) {
        super(activity);
        this.bus = bus;
    }

    public void setText(LatestResponse images) {
        String response = "";
        for (Image image : images.getImages()) {
            response += "ID: " + image.getId() + "\n";
            response += "Url: " + image.getUrl() + "\n";
        }
        this.response.setText(response);
    }
}
