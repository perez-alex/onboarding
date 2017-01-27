package com.example.aperez.retrofittest.mvp.model;

import com.activeandroid.content.ContentProvider;
import com.example.aperez.retrofittest.BuildConfig;

/**
 * Created by aperez on 27/01/17.
 */

public class MyContentProvider extends ContentProvider {
    private static final String AUTHORITY = BuildConfig.APPLICATION_ID;

    @Override
    protected String getAuthority() {
        return AUTHORITY;
    }
}
