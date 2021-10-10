package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckedInBaseViewModel;

public abstract class BannerCheckInSuccessBinding extends ViewDataBinding {
    @Bindable
    protected CheckedInBaseViewModel mVm;

    public abstract void setVm(CheckedInBaseViewModel checkedInBaseViewModel);

    protected BannerCheckInSuccessBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public CheckedInBaseViewModel getVm() {
        return this.mVm;
    }

    public static BannerCheckInSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BannerCheckInSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BannerCheckInSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.banner_check_in_success, viewGroup, z, obj);
    }

    public static BannerCheckInSuccessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BannerCheckInSuccessBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BannerCheckInSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.banner_check_in_success, null, false, obj);
    }

    public static BannerCheckInSuccessBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BannerCheckInSuccessBinding bind(View view, Object obj) {
        return (BannerCheckInSuccessBinding) bind(obj, view, R.layout.banner_check_in_success);
    }
}
