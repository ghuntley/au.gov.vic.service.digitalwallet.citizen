package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.HoldingRecordAttributes;

public abstract class CardWwcCheckBackBinding extends ViewDataBinding {
    @Bindable
    protected HoldingRecordAttributes mVm;

    public abstract void setVm(HoldingRecordAttributes holdingRecordAttributes);

    protected CardWwcCheckBackBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public HoldingRecordAttributes getVm() {
        return this.mVm;
    }

    public static CardWwcCheckBackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardWwcCheckBackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardWwcCheckBackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_wwc_check_back, viewGroup, z, obj);
    }

    public static CardWwcCheckBackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardWwcCheckBackBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardWwcCheckBackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_wwc_check_back, null, false, obj);
    }

    public static CardWwcCheckBackBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardWwcCheckBackBinding bind(View view, Object obj) {
        return (CardWwcCheckBackBinding) bind(obj, view, R.layout.card_wwc_check_back);
    }
}
