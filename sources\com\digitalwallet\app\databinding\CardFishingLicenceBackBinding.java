package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class CardFishingLicenceBackBinding extends ViewDataBinding {
    protected CardFishingLicenceBackBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static CardFishingLicenceBackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardFishingLicenceBackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardFishingLicenceBackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_fishing_licence_back, viewGroup, z, obj);
    }

    public static CardFishingLicenceBackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardFishingLicenceBackBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardFishingLicenceBackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_fishing_licence_back, null, false, obj);
    }

    public static CardFishingLicenceBackBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardFishingLicenceBackBinding bind(View view, Object obj) {
        return (CardFishingLicenceBackBinding) bind(obj, view, R.layout.card_fishing_licence_back);
    }
}
