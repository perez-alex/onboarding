package com.example.aperez.retrofittest.mvp.view;

import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aperez.retrofittest.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aperez on 25/01/17.
 */

public class ImageDialogView extends DialogView {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.copyright)
    TextView copyrightTv;
    @BindView(R.id.site)
    TextView siteTv;

    public ImageDialogView(DialogFragment dialog, View view) {
        super(dialog);

        ButterKnife.bind(this, view);
    }

    public void setImageDetails(String url, String site, String copyright) {
        Picasso.with(getActivity())
                .load(url)
                .into(image);
        siteTv.setText(String.format(getActivity().getString(R.string.site), site));
        copyrightTv.setText(String.format(getActivity().getString(R.string.copyright), copyright));
    }
}
