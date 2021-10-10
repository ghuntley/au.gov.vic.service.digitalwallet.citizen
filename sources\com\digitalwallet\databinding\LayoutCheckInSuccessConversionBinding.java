package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckedInBaseViewModel;

public abstract class LayoutCheckInSuccessConversionBinding extends ViewDataBinding {
    @Bindable
    protected CheckedInBaseViewModel mVm;

    public abstract void setVm(CheckedInBaseViewModel checkedInBaseViewModel);

    protected LayoutCheckInSuccessConversionBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public CheckedInBaseViewModel getVm() {
        return this.mVm;
    }

    public static LayoutCheckInSuccessConversionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckInSuccessConversionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutCheckInSuccessConversionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_check_in_success_conversion, viewGroup, z, obj);
    }

    public static LayoutCheckInSuccessConversionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckInSuccessConversionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutCheckInSuccessConversionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_check_in_success_conversion, null, false, obj);
    }

    public static LayoutCheckInSuccessConversionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckInSuccessConversionBinding bind(View view, Object obj) {
        return (LayoutCheckInSuccessConversionBinding) bind(obj, view, R.layout.layout_check_in_success_conversion);
    }
}
