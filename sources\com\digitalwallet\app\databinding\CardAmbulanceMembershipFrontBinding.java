package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.HoldingRecordAttributes;

public abstract class CardAmbulanceMembershipFrontBinding extends ViewDataBinding {
    @Bindable
    protected HoldingRecordAttributes mVm;

    public abstract void setVm(HoldingRecordAttributes holdingRecordAttributes);

    protected CardAmbulanceMembershipFrontBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public HoldingRecordAttributes getVm() {
        return this.mVm;
    }

    public static CardAmbulanceMembershipFrontBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAmbulanceMembershipFrontBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardAmbulanceMembershipFrontBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_ambulance_membership_front, viewGroup, z, obj);
    }

    public static CardAmbulanceMembershipFrontBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAmbulanceMembershipFrontBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardAmbulanceMembershipFrontBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_ambulance_membership_front, null, false, obj);
    }

    public static CardAmbulanceMembershipFrontBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAmbulanceMembershipFrontBinding bind(View view, Object obj) {
        return (CardAmbulanceMembershipFrontBinding) bind(obj, view, R.layout.card_ambulance_membership_front);
    }
}
