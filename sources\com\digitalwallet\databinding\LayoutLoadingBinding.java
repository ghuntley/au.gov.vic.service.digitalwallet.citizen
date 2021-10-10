package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class LayoutLoadingBinding extends ViewDataBinding {
    @Bindable
    protected Boolean mShowLoading;

    public abstract void setShowLoading(Boolean bool);

    protected LayoutLoadingBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public Boolean getShowLoading() {
        return this.mShowLoading;
    }

    public static LayoutLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutLoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_loading_RES_2131492939, viewGroup, z, obj);
    }

    public static LayoutLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutLoadingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutLoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_loading_RES_2131492939, null, false, obj);
    }

    public static LayoutLoadingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutLoadingBinding bind(View view, Object obj) {
        return (LayoutLoadingBinding) bind(obj, view, R.layout.layout_loading_RES_2131492939);
    }
}
