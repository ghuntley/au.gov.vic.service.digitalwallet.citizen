package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class CardAffordancesAddACardBinding extends ViewDataBinding {
    protected CardAffordancesAddACardBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static CardAffordancesAddACardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAffordancesAddACardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardAffordancesAddACardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_affordances_add_a_card, viewGroup, z, obj);
    }

    public static CardAffordancesAddACardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAffordancesAddACardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardAffordancesAddACardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_affordances_add_a_card, null, false, obj);
    }

    public static CardAffordancesAddACardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAffordancesAddACardBinding bind(View view, Object obj) {
        return (CardAffordancesAddACardBinding) bind(obj, view, R.layout.card_affordances_add_a_card);
    }
}
