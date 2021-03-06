package com.example.aperez.retrofittest.mvp.view;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aperez.retrofittest.R;
import com.example.aperez.retrofittest.mvp.model.Image;
import com.example.aperez.retrofittest.mvp.view.event.ImageClickedEvent;
import com.example.aperez.retrofittest.utils.BusProvider;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aperez on 24/01/17.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImageViewHolder> {

    private List<Image> imagesList;
    private final Context context;

    public ImagesAdapter(Context context, List<Image> images) {
        imagesList = images;
        this.context = context;
    }

    public ImagesAdapter(Context context, Cursor data) {
        this.context = context;
        if (data != null) {
            try {
                imagesList = new ArrayList<>();
                while (data.moveToNext()) {
                    Image image = new Image(data);
                    imagesList.add(image);
                }
            } finally {
                data.close();
            }
        }
    }

    @Override
    public ImagesAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_card, parent, false);

        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ImagesAdapter.ImageViewHolder holder, int position) {
        Image image = imagesList.get(position);
        holder.image = image;
        holder.id.setText(String.valueOf(image.getImageId()));
        Picasso.with(context)
                .load(image.getUrl())
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.id)
        TextView id;
        @BindView(R.id.thumbnail)
        ImageView thumbnail;
        Image image;

        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.thumbnail)
        public void openDetail() {
            Bus bus = BusProvider.getInstance();
            bus.post(new ImageClickedEvent(String.valueOf(image.getImageId())));
        }
    }
}
