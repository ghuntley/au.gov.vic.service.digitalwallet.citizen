package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.HoldingRecordAttributes;

public abstract class CardFishingLicenceFrontBinding extends ViewDataBinding {
    public final LinearLayout bottomContent;
    @Bindable
    protected HoldingRecordAttributes mVm;

    public abstract void setVm(HoldingRecordAttributes holdingRecordAttributes);

    protected CardFishingLicenceFrontBinding(Object obj, View view, int i, LinearLayout linearLayout) {
        super(obj, view, i);
        this.bottomContent = linearLayout;
    }

    public HoldingRecordAttributes getVm() {
        return this.mVm;
    }

    public static CardFishingLicenceFrontBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardFishingLicenceFrontBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardFishingLicenceFrontBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_fishing_licence_front, viewGroup, z, obj);
    }

    public static CardFishingLicenceFrontBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardFishingLicenceFrontBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardFishingLicenceFrontBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_fishing_licence_front, null, false, obj);
    }

    public static CardFishingLicenceFrontBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardFishingLicenceFrontBinding bind(View view, Object obj) {
        return (CardFishingLicenceFrontBinding) bind(obj, view, R.layout.card_fishing_licence_front);
    }
}
