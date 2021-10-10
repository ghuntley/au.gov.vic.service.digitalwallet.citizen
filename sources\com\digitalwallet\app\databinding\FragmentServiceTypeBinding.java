package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class FragmentServiceTypeBinding extends ViewDataBinding {
    public final RecyclerView serviceTypeRecyclerView;

    protected FragmentServiceTypeBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.serviceTypeRecyclerView = recyclerView;
    }

    public static FragmentServiceTypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceTypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentServiceTypeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_service_type, viewGroup, z, obj);
    }

    public static FragmentServiceTypeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceTypeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentServiceTypeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_service_type, null, false, obj);
    }

    public static FragmentServiceTypeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceTypeBinding bind(View view, Object obj) {
        return (FragmentServiceTypeBinding) bind(obj, view, R.layout.fragment_service_type);
    }
}
