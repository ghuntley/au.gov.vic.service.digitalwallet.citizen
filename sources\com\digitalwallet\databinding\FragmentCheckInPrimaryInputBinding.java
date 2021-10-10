package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInPrimaryInputViewModel;

public abstract class FragmentCheckInPrimaryInputBinding extends ViewDataBinding {
    public final LayoutCheckInPrivacyBinding checkInPrivacyLayout;
    public final LayoutCheckInInputBinding inputLayout;
    @Bindable
    protected CheckInPrimaryInputViewModel mVm;
    public final LayoutCheckInTitleBarBinding titleBar;

    public abstract void setVm(CheckInPrimaryInputViewModel checkInPrimaryInputViewModel);

    protected FragmentCheckInPrimaryInputBinding(Object obj, View view, int i, LayoutCheckInPrivacyBinding layoutCheckInPrivacyBinding, LayoutCheckInInputBinding layoutCheckInInputBinding, LayoutCheckInTitleBarBinding layoutCheckInTitleBarBinding) {
        super(obj, view, i);
        this.checkInPrivacyLayout = layoutCheckInPrivacyBinding;
        this.inputLayout = layoutCheckInInputBinding;
        this.titleBar = layoutCheckInTitleBarBinding;
    }

    public CheckInPrimaryInputViewModel getVm() {
        return this.mVm;
    }

    public static FragmentCheckInPrimaryInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInPrimaryInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCheckInPrimaryInputBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_primary_input, viewGroup, z, obj);
    }

    public static FragmentCheckInPrimaryInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInPrimaryInputBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCheckInPrimaryInputBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_primary_input, null, false, obj);
    }

    public static FragmentCheckInPrimaryInputBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInPrimaryInputBinding bind(View view, Object obj) {
        return (FragmentCheckInPrimaryInputBinding) bind(obj, view, R.layout.fragment_check_in_primary_input);
    }
}
