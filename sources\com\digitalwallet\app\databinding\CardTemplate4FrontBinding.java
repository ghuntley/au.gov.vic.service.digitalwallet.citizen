package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.HoldingAssets;
import com.digitalwallet.app.model.SecureHolding;

public abstract class CardTemplate4FrontBinding extends ViewDataBinding {
    public final ConstraintLayout holdingTitle;
    @Bindable
    protected HoldingAssets mAssets;
    @Bindable
    protected SecureHolding mHolding;

    public abstract void setAssets(HoldingAssets holdingAssets);

    public abstract void setHolding(SecureHolding secureHolding);

    protected CardTemplate4FrontBinding(Object obj, View view, int i, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.holdingTitle = constraintLayout;
    }

    public SecureHolding getHolding() {
        return this.mHolding;
    }

    public HoldingAssets getAssets() {
        return this.mAssets;
    }

    public static CardTemplate4FrontBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardTemplate4FrontBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardTemplate4FrontBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_template_4_front, viewGroup, z, obj);
    }

    public static CardTemplate4FrontBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardTemplate4FrontBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardTemplate4FrontBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_template_4_front, null, false, obj);
    }

    public static CardTemplate4FrontBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardTemplate4FrontBinding bind(View view, Object obj) {
        return (CardTemplate4FrontBinding) bind(obj, view, R.layout.card_template_4_front);
    }
}
