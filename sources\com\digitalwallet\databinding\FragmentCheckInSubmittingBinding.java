package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSubmittingViewModel;

public abstract class FragmentCheckInSubmittingBinding extends ViewDataBinding {
    @Bindable
    protected CheckInSubmittingViewModel mVm;

    public abstract void setVm(CheckInSubmittingViewModel checkInSubmittingViewModel);

    protected FragmentCheckInSubmittingBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public CheckInSubmittingViewModel getVm() {
        return this.mVm;
    }

    public static FragmentCheckInSubmittingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInSubmittingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCheckInSubmittingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_submitting, viewGroup, z, obj);
    }

    public static FragmentCheckInSubmittingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInSubmittingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCheckInSubmittingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_submitting, null, false, obj);
    }

    public static FragmentCheckInSubmittingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInSubmittingBinding bind(View view, Object obj) {
        return (FragmentCheckInSubmittingBinding) bind(obj, view, R.layout.fragment_check_in_submitting);
    }
}
