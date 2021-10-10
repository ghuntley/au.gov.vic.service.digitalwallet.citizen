package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class FragmentSharingDetailsBinding extends ViewDataBinding {
    public final RecyclerView recipientDetailsRecyclerView;
    public final LinearLayout sharedWithContainer;
    public final RecyclerView sharingDetailsRecyclerView;

    protected FragmentSharingDetailsBinding(Object obj, View view, int i, RecyclerView recyclerView, LinearLayout linearLayout, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.recipientDetailsRecyclerView = recyclerView;
        this.sharedWithContainer = linearLayout;
        this.sharingDetailsRecyclerView = recyclerView2;
    }

    public static FragmentSharingDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSharingDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSharingDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_sharing_details, viewGroup, z, obj);
    }

    public static FragmentSharingDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSharingDetailsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSharingDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_sharing_details, null, false, obj);
    }

    public static FragmentSharingDetailsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSharingDetailsBinding bind(View view, Object obj) {
        return (FragmentSharingDetailsBinding) bind(obj, view, R.layout.fragment_sharing_details);
    }
}
