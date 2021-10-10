package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.svservices.TitleActionVM;

public abstract class ItemSvServiceTitleActionBinding extends ViewDataBinding {
    public final ImageView actionIcon;
    @Bindable
    protected TitleActionVM mVm;
    public final TextView svServiceTitle;

    public abstract void setVm(TitleActionVM titleActionVM);

    protected ItemSvServiceTitleActionBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.actionIcon = imageView;
        this.svServiceTitle = textView;
    }

    public TitleActionVM getVm() {
        return this.mVm;
    }

    public static ItemSvServiceTitleActionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSvServiceTitleActionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSvServiceTitleActionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sv_service_title_action, viewGroup, z, obj);
    }

    public static ItemSvServiceTitleActionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSvServiceTitleActionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSvServiceTitleActionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sv_service_title_action, null, false, obj);
    }

    public static ItemSvServiceTitleActionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSvServiceTitleActionBinding bind(View view, Object obj) {
        return (ItemSvServiceTitleActionBinding) bind(obj, view, R.layout.item_sv_service_title_action);
    }
}
