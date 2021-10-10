package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInSuccessViewModel;

public abstract class FragmentCheckInSuccessBinding extends ViewDataBinding {
    @Bindable
    protected CheckInSuccessViewModel mVm;

    public abstract void setVm(CheckInSuccessViewModel checkInSuccessViewModel);

    protected FragmentCheckInSuccessBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public CheckInSuccessViewModel getVm() {
        return this.mVm;
    }

    public static FragmentCheckInSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCheckInSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_success, viewGroup, z, obj);
    }

    public static FragmentCheckInSuccessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInSuccessBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCheckInSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_success, null, false, obj);
    }

    public static FragmentCheckInSuccessBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInSuccessBinding bind(View view, Object obj) {
        return (FragmentCheckInSuccessBinding) bind(obj, view, R.layout.fragment_check_in_success);
    }
}
