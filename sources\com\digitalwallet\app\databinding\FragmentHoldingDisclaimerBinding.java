package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.view.main.HoldingDisclaimerFragmentViewModel;

public abstract class FragmentHoldingDisclaimerBinding extends ViewDataBinding {
    public final TextView back;
    public final TextView disclaimerFeatures;
    public final TextView disclaimerRotate;
    public final TextView disclaimerShare;
    public final TextView disclaimerSwipe;
    public final TextView disclaimerTilt;
    @Bindable
    protected HoldingDisclaimerFragmentViewModel mVm;

    public abstract void setVm(HoldingDisclaimerFragmentViewModel holdingDisclaimerFragmentViewModel);

    protected FragmentHoldingDisclaimerBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.back = textView;
        this.disclaimerFeatures = textView2;
        this.disclaimerRotate = textView3;
        this.disclaimerShare = textView4;
        this.disclaimerSwipe = textView5;
        this.disclaimerTilt = textView6;
    }

    public HoldingDisclaimerFragmentViewModel getVm() {
        return this.mVm;
    }

    public static FragmentHoldingDisclaimerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHoldingDisclaimerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentHoldingDisclaimerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_holding_disclaimer, viewGroup, z, obj);
    }

    public static FragmentHoldingDisclaimerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHoldingDisclaimerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentHoldingDisclaimerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_holding_disclaimer, null, false, obj);
    }

    public static FragmentHoldingDisclaimerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHoldingDisclaimerBinding bind(View view, Object obj) {
        return (FragmentHoldingDisclaimerBinding) bind(obj, view, R.layout.fragment_holding_disclaimer);
    }
}
