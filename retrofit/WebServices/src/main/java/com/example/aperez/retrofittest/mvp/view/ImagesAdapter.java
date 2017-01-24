package com.example.aperez.retrofittest.mvp.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aperez.retrofittest.R;
import com.example.aperez.retrofittest.mvp.model.Image;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by aperez on 24/01/17.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>{

    private final List<Image> imagesList;
    private final Context context;

    public ImagesAdapter(Context context, List<Image> images){
        imagesList = images;
        this.context = context;
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
        holder.id.setText(String.valueOf(image.getId()));
        Picasso.with(context)
                .load(image.getUrl())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder{
        TextView id;
        ImageView thumbnail;

        public ImageViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.id);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }
}
