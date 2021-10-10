package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInInputBaseViewModel;
import com.google.android.material.textfield.TextInputEditText;

public abstract class LayoutCheckInInputBinding extends ViewDataBinding {
    public final TextInputEditText firstNameEditText;
    public final TextInputEditText lastNameEditText;
    @Bindable
    protected CheckInInputBaseViewModel mVm;
    public final TextInputEditText phoneNumberEditText;

    public abstract void setVm(CheckInInputBaseViewModel checkInInputBaseViewModel);

    protected LayoutCheckInInputBinding(Object obj, View view, int i, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextInputEditText textInputEditText3) {
        super(obj, view, i);
        this.firstNameEditText = textInputEditText;
        this.lastNameEditText = textInputEditText2;
        this.phoneNumberEditText = textInputEditText3;
    }

    public CheckInInputBaseViewModel getVm() {
        return this.mVm;
    }

    public static LayoutCheckInInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckInInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutCheckInInputBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_check_in_input, viewGroup, z, obj);
    }

    public static LayoutCheckInInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckInInputBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutCheckInInputBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_check_in_input, null, false, obj);
    }

    public static LayoutCheckInInputBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckInInputBinding bind(View view, Object obj) {
        return (LayoutCheckInInputBinding) bind(obj, view, R.layout.layout_check_in_input);
    }
}
