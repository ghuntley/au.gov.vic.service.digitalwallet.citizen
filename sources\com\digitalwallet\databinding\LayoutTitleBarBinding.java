package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class LayoutTitleBarBinding extends ViewDataBinding {
    @Bindable
    protected String mTitle;

    public abstract void setTitle(String str);

    protected LayoutTitleBarBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public String getTitle() {
        return this.mTitle;
    }

    public static LayoutTitleBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutTitleBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutTitleBarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_title_bar_RES_2131492940, viewGroup, z, obj);
    }

    public static LayoutTitleBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutTitleBarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutTitleBarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_title_bar_RES_2131492940, null, false, obj);
    }

    public static LayoutTitleBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutTitleBarBinding bind(View view, Object obj) {
        return (LayoutTitleBarBinding) bind(obj, view, R.layout.layout_title_bar_RES_2131492940);
    }
}
