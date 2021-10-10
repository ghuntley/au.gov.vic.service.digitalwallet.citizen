package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInAddDependantInputViewModel;

public abstract class FragmentCheckInAddDependantInputBinding extends ViewDataBinding {
    public final LayoutCheckInPrivacyBinding checkInPrivacyLayout;
    public final LayoutCheckInTitleBarBinding fullScreenTitleBar;
    public final LayoutCheckInInputBinding inputLayout;
    @Bindable
    protected CheckInAddDependantInputViewModel mVm;

    public abstract void setVm(CheckInAddDependantInputViewModel checkInAddDependantInputViewModel);

    protected FragmentCheckInAddDependantInputBinding(Object obj, View view, int i, LayoutCheckInPrivacyBinding layoutCheckInPrivacyBinding, LayoutCheckInTitleBarBinding layoutCheckInTitleBarBinding, LayoutCheckInInputBinding layoutCheckInInputBinding) {
        super(obj, view, i);
        this.checkInPrivacyLayout = layoutCheckInPrivacyBinding;
        this.fullScreenTitleBar = layoutCheckInTitleBarBinding;
        this.inputLayout = layoutCheckInInputBinding;
    }

    public CheckInAddDependantInputViewModel getVm() {
        return this.mVm;
    }

    public static FragmentCheckInAddDependantInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInAddDependantInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCheckInAddDependantInputBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_add_dependant_input, viewGroup, z, obj);
    }

    public static FragmentCheckInAddDependantInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInAddDependantInputBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCheckInAddDependantInputBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_add_dependant_input, null, false, obj);
    }

    public static FragmentCheckInAddDependantInputBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInAddDependantInputBinding bind(View view, Object obj) {
        return (FragmentCheckInAddDependantInputBinding) bind(obj, view, R.layout.fragment_check_in_add_dependant_input);
    }
}
