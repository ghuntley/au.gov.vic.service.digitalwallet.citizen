package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.HoldingRecordAttributes;

public abstract class CardAddACardBinding extends ViewDataBinding {
    @Bindable
    protected HoldingRecordAttributes mVm;

    public abstract void setVm(HoldingRecordAttributes holdingRecordAttributes);

    protected CardAddACardBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public HoldingRecordAttributes getVm() {
        return this.mVm;
    }

    public static CardAddACardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAddACardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardAddACardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_add_a_card, viewGroup, z, obj);
    }

    public static CardAddACardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAddACardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardAddACardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_add_a_card, null, false, obj);
    }

    public static CardAddACardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAddACardBinding bind(View view, Object obj) {
        return (CardAddACardBinding) bind(obj, view, R.layout.card_add_a_card);
    }
}
