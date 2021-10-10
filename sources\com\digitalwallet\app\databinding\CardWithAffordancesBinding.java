package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class CardWithAffordancesBinding extends ViewDataBinding {
    public final CardBinding card;
    public final FrameLayout cardAffordances;
    public final View extraAffordanceGuideline;
    public final LinearLayout layoutGuidanceContainer;

    protected CardWithAffordancesBinding(Object obj, View view, int i, CardBinding cardBinding, FrameLayout frameLayout, View view2, LinearLayout linearLayout) {
        super(obj, view, i);
        this.card = cardBinding;
        this.cardAffordances = frameLayout;
        this.extraAffordanceGuideline = view2;
        this.layoutGuidanceContainer = linearLayout;
    }

    public static CardWithAffordancesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardWithAffordancesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardWithAffordancesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_with_affordances, viewGroup, z, obj);
    }

    public static CardWithAffordancesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardWithAffordancesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardWithAffordancesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_with_affordances, null, false, obj);
    }

    public static CardWithAffordancesBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardWithAffordancesBinding bind(View view, Object obj) {
        return (CardWithAffordancesBinding) bind(obj, view, R.layout.card_with_affordances);
    }
}
