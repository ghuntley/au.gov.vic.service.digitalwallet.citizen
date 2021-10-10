package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.HoldingRecordAttributes;

public abstract class CardWorksafeLicenceBackBinding extends ViewDataBinding {
    @Bindable
    protected HoldingRecordAttributes mVm;

    public abstract void setVm(HoldingRecordAttributes holdingRecordAttributes);

    protected CardWorksafeLicenceBackBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public HoldingRecordAttributes getVm() {
        return this.mVm;
    }

    public static CardWorksafeLicenceBackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardWorksafeLicenceBackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardWorksafeLicenceBackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_worksafe_licence_back, viewGroup, z, obj);
    }

    public static CardWorksafeLicenceBackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardWorksafeLicenceBackBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardWorksafeLicenceBackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_worksafe_licence_back, null, false, obj);
    }

    public static CardWorksafeLicenceBackBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardWorksafeLicenceBackBinding bind(View view, Object obj) {
        return (CardWorksafeLicenceBackBinding) bind(obj, view, R.layout.card_worksafe_licence_back);
    }
}
