package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.HoldingAssets;

public abstract class CardTemplateBackBinding extends ViewDataBinding {
    @Bindable
    protected HoldingAssets mAssets;

    public abstract void setAssets(HoldingAssets holdingAssets);

    protected CardTemplateBackBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public HoldingAssets getAssets() {
        return this.mAssets;
    }

    public static CardTemplateBackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardTemplateBackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardTemplateBackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_template_back, viewGroup, z, obj);
    }

    public static CardTemplateBackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardTemplateBackBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardTemplateBackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_template_back, null, false, obj);
    }

    public static CardTemplateBackBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardTemplateBackBinding bind(View view, Object obj) {
        return (CardTemplateBackBinding) bind(obj, view, R.layout.card_template_back);
    }
}
