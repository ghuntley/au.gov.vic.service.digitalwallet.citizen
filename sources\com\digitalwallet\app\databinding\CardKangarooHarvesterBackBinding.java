package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class CardKangarooHarvesterBackBinding extends ViewDataBinding {
    public final ImageView imageView3;

    protected CardKangarooHarvesterBackBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.imageView3 = imageView;
    }

    public static CardKangarooHarvesterBackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardKangarooHarvesterBackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardKangarooHarvesterBackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_kangaroo_harvester_back, viewGroup, z, obj);
    }

    public static CardKangarooHarvesterBackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardKangarooHarvesterBackBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardKangarooHarvesterBackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_kangaroo_harvester_back, null, false, obj);
    }

    public static CardKangarooHarvesterBackBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardKangarooHarvesterBackBinding bind(View view, Object obj) {
        return (CardKangarooHarvesterBackBinding) bind(obj, view, R.layout.card_kangaroo_harvester_back);
    }
}
