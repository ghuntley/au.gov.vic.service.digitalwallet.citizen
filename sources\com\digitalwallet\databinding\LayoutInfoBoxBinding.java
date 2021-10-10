package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class LayoutInfoBoxBinding extends ViewDataBinding {
    @Bindable
    protected String mInfo;

    public abstract void setInfo(String str);

    protected LayoutInfoBoxBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public String getInfo() {
        return this.mInfo;
    }

    public static LayoutInfoBoxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutInfoBoxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutInfoBoxBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_info_box, viewGroup, z, obj);
    }

    public static LayoutInfoBoxBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutInfoBoxBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutInfoBoxBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_info_box, null, false, obj);
    }

    public static LayoutInfoBoxBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutInfoBoxBinding bind(View view, Object obj) {
        return (LayoutInfoBoxBinding) bind(obj, view, R.layout.layout_info_box);
    }
}
