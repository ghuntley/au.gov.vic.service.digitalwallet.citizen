package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.SecureHolding;

public abstract class CardAffordancesKangarooHarvesterBinding extends ViewDataBinding {
    public final FrameLayout frameLayout;
    @Bindable
    protected SecureHolding mHolding;

    public abstract void setHolding(SecureHolding secureHolding);

    protected CardAffordancesKangarooHarvesterBinding(Object obj, View view, int i, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.frameLayout = frameLayout2;
    }

    public SecureHolding getHolding() {
        return this.mHolding;
    }

    public static CardAffordancesKangarooHarvesterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAffordancesKangarooHarvesterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardAffordancesKangarooHarvesterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_affordances_kangaroo_harvester, viewGroup, z, obj);
    }

    public static CardAffordancesKangarooHarvesterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAffordancesKangarooHarvesterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardAffordancesKangarooHarvesterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_affordances_kangaroo_harvester, null, false, obj);
    }

    public static CardAffordancesKangarooHarvesterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAffordancesKangarooHarvesterBinding bind(View view, Object obj) {
        return (CardAffordancesKangarooHarvesterBinding) bind(obj, view, R.layout.card_affordances_kangaroo_harvester);
    }
}
