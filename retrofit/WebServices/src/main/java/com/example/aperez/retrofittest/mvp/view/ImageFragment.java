package com.example.aperez.retrofittest.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aperez.retrofittest.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aperez on 25/01/17.
 */

public class ImageFragment extends DialogFragment {

    private final static String URL = "url";
    private final static String COPYRIGHT = "copyright";
    private final static String SITE = "site";

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.copyright)
    TextView copyright;
    @BindView(R.id.site)
    TextView site;

    public ImageFragment() {

    }

    public static ImageFragment newInstance(String url, String copyright, String site) {

        Bundle args = new Bundle();
        args.putString(URL, url);
        args.putString(COPYRIGHT, copyright);
        args.putString(SITE, site);
        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_dialog, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Picasso.with(getActivity())
                .load(getArguments().getString(URL))
                .into(image);
        String siteString = getArguments().getString(SITE);
        site.setText(String.format(getString(R.string.site), siteString));
        String copyrightString = getArguments().getString(COPYRIGHT);
        copyright.setText(String.format(getString(R.string.copyright), copyrightString));
    }
}
