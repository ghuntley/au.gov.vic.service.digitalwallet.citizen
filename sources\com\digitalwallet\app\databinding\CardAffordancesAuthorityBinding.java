package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.HoldingRecordAttributes;

public abstract class CardAffordancesAuthorityBinding extends ViewDataBinding {
    public final TextView daysToExpire;
    public final FrameLayout frameLayout;
    @Bindable
    protected HoldingRecordAttributes mVm;

    public abstract void setVm(HoldingRecordAttributes holdingRecordAttributes);

    protected CardAffordancesAuthorityBinding(Object obj, View view, int i, TextView textView, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.daysToExpire = textView;
        this.frameLayout = frameLayout2;
    }

    public HoldingRecordAttributes getVm() {
        return this.mVm;
    }

    public static CardAffordancesAuthorityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAffordancesAuthorityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardAffordancesAuthorityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_affordances_authority, viewGroup, z, obj);
    }

    public static CardAffordancesAuthorityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAffordancesAuthorityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardAffordancesAuthorityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_affordances_authority, null, false, obj);
    }

    public static CardAffordancesAuthorityBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAffordancesAuthorityBinding bind(View view, Object obj) {
        return (CardAffordancesAuthorityBinding) bind(obj, view, R.layout.card_affordances_authority);
    }
}
