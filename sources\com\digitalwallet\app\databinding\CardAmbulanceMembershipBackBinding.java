package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class CardAmbulanceMembershipBackBinding extends ViewDataBinding {
    protected CardAmbulanceMembershipBackBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static CardAmbulanceMembershipBackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAmbulanceMembershipBackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardAmbulanceMembershipBackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_ambulance_membership_back, viewGroup, z, obj);
    }

    public static CardAmbulanceMembershipBackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAmbulanceMembershipBackBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardAmbulanceMembershipBackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_ambulance_membership_back, null, false, obj);
    }

    public static CardAmbulanceMembershipBackBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAmbulanceMembershipBackBinding bind(View view, Object obj) {
        return (CardAmbulanceMembershipBackBinding) bind(obj, view, R.layout.card_ambulance_membership_back);
    }
}
