package com.example.aperez.retrofittest.mvp.view;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aperez.retrofittest.R;
import com.example.aperez.retrofittest.mvp.model.Image;
import com.example.aperez.retrofittest.mvp.view.event.ImageClickedEvent;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aperez on 24/01/17.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImageViewHolder> {

    private final List<Image> imagesList;
    private final Context context;
    private final Bus bus;

    public ImagesAdapter(Bus bus, Context context, List<Image> images) {
        imagesList = images;
        this.context = context;
        this.bus = bus;
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
        holder.id.setText(String.valueOf(image.getId()));
        Picasso.with(context)
                .load(image.getUrl())
//                .placeholder(R.drawable.placeholder)
//                .error(R.drawable.error)
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
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
            bus.post(new ImageClickedEvent(String.valueOf(image.getId())));
        }
    }
}
