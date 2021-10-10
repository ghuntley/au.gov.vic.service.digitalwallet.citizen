package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInEditPersonInputViewModel;

public abstract class FragmentCheckInEditPersonInputBinding extends ViewDataBinding {
    public final LayoutCheckInInputBinding inputLayout;
    @Bindable
    protected CheckInEditPersonInputViewModel mVm;

    public abstract void setVm(CheckInEditPersonInputViewModel checkInEditPersonInputViewModel);

    protected FragmentCheckInEditPersonInputBinding(Object obj, View view, int i, LayoutCheckInInputBinding layoutCheckInInputBinding) {
        super(obj, view, i);
        this.inputLayout = layoutCheckInInputBinding;
    }

    public CheckInEditPersonInputViewModel getVm() {
        return this.mVm;
    }

    public static FragmentCheckInEditPersonInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInEditPersonInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCheckInEditPersonInputBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_edit_person_input, viewGroup, z, obj);
    }

    public static FragmentCheckInEditPersonInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInEditPersonInputBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCheckInEditPersonInputBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_edit_person_input, null, false, obj);
    }

    public static FragmentCheckInEditPersonInputBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInEditPersonInputBinding bind(View view, Object obj) {
        return (FragmentCheckInEditPersonInputBinding) bind(obj, view, R.layout.fragment_check_in_edit_person_input);
    }
}
