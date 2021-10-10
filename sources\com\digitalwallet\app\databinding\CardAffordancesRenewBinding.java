package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.SecureHolding;

public abstract class CardAffordancesRenewBinding extends ViewDataBinding {
    @Bindable
    protected SecureHolding mHolding;

    public abstract void setHolding(SecureHolding secureHolding);

    protected CardAffordancesRenewBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public SecureHolding getHolding() {
        return this.mHolding;
    }

    public static CardAffordancesRenewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAffordancesRenewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardAffordancesRenewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_affordances_renew, viewGroup, z, obj);
    }

    public static CardAffordancesRenewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAffordancesRenewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardAffordancesRenewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_affordances_renew, null, false, obj);
    }

    public static CardAffordancesRenewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAffordancesRenewBinding bind(View view, Object obj) {
        return (CardAffordancesRenewBinding) bind(obj, view, R.layout.card_affordances_renew);
    }
}
