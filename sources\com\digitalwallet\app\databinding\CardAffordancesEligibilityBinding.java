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
import com.digitalwallet.app.model.SecureHolding;

public abstract class CardAffordancesEligibilityBinding extends ViewDataBinding {
    public final TextView eligibilityScanner;
    public final FrameLayout frameLayout;
    @Bindable
    protected SecureHolding mHolding;

    public abstract void setHolding(SecureHolding secureHolding);

    protected CardAffordancesEligibilityBinding(Object obj, View view, int i, TextView textView, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.eligibilityScanner = textView;
        this.frameLayout = frameLayout2;
    }

    public SecureHolding getHolding() {
        return this.mHolding;
    }

    public static CardAffordancesEligibilityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAffordancesEligibilityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardAffordancesEligibilityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_affordances_eligibility, viewGroup, z, obj);
    }

    public static CardAffordancesEligibilityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAffordancesEligibilityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardAffordancesEligibilityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_affordances_eligibility, null, false, obj);
    }

    public static CardAffordancesEligibilityBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardAffordancesEligibilityBinding bind(View view, Object obj) {
        return (CardAffordancesEligibilityBinding) bind(obj, view, R.layout.card_affordances_eligibility);
    }
}
