package com.example.aperez.retrofittest.mvp.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import java.lang.ref.WeakReference;

public class DialogView {
    private WeakReference<DialogFragment> dialogRef;

    public DialogView(DialogFragment dialog) {
        dialogRef = new WeakReference<>(dialog);
    }

    @Nullable
    public Activity getActivity() {
        return dialogRef.get().getActivity();
    }

    @Nullable
    public Context getContext() {
        return getActivity();
    }

    @Nullable
    public DialogFragment getDialog() {
        return dialogRef.get();
    }

    @Nullable
    public FragmentManager getFragmentManager() {
        Activity activity = getActivity();
        return (activity != null) ? activity.getFragmentManager() : null;
    }
}
