package com.example.aperez.retrofittest.mvp.view;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.aperez.retrofittest.R;
import com.example.aperez.retrofittest.mvp.model.Image;
import com.example.aperez.retrofittest.mvp.model.MyContentProvider;
import com.example.aperez.retrofittest.mvp.model.db.StoredImage;
import com.example.aperez.retrofittest.mvp.view.event.RefreshEvent;
import com.example.aperez.retrofittest.utils.BusProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aperez on 24/01/17.
 */

public class ResponseView extends ActivityView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    public ResponseView(AppCompatActivity activity) {
        super(activity);

        ButterKnife.bind(this, activity);
    }

    public void setCards(List<Image> images) {
        ImagesAdapter adapter = new ImagesAdapter(getActivity(), images);
        recyclerView.setAdapter(adapter);
    }

    public void showErrorToast() {
        Toast.makeText(getActivity(), R.string.response_error, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.refresh_button)
    public void refreshButtonClicked() {
        BusProvider.getInstance().post(new RefreshEvent());
    }

    public void loadResults(Cursor data) {
        ImagesAdapter adapter = new ImagesAdapter(getActivity(), data);
        recyclerView.setAdapter(adapter);
    }
}
