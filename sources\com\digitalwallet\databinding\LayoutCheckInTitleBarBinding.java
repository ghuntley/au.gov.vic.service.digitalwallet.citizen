package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class LayoutCheckInTitleBarBinding extends ViewDataBinding {
    public final ImageView backButton;
    public final ImageView helpButton;
    @Bindable
    protected Boolean mShowBack;
    @Bindable
    protected String mTitle;

    public abstract void setShowBack(Boolean bool);

    public abstract void setTitle(String str);

    protected LayoutCheckInTitleBarBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.backButton = imageView;
        this.helpButton = imageView2;
    }

    public Boolean getShowBack() {
        return this.mShowBack;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public static LayoutCheckInTitleBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckInTitleBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutCheckInTitleBarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_check_in_title_bar, viewGroup, z, obj);
    }

    public static LayoutCheckInTitleBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckInTitleBarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutCheckInTitleBarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_check_in_title_bar, null, false, obj);
    }

    public static LayoutCheckInTitleBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckInTitleBarBinding bind(View view, Object obj) {
        return (LayoutCheckInTitleBarBinding) bind(obj, view, R.layout.layout_check_in_title_bar);
    }
}
