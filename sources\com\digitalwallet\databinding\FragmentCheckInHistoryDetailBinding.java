package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInHistoryDetailViewModel;

public abstract class FragmentCheckInHistoryDetailBinding extends ViewDataBinding {
    @Bindable
    protected CheckInHistoryDetailViewModel mVm;

    public abstract void setVm(CheckInHistoryDetailViewModel checkInHistoryDetailViewModel);

    protected FragmentCheckInHistoryDetailBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public CheckInHistoryDetailViewModel getVm() {
        return this.mVm;
    }

    public static FragmentCheckInHistoryDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInHistoryDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCheckInHistoryDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_history_detail, viewGroup, z, obj);
    }

    public static FragmentCheckInHistoryDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInHistoryDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCheckInHistoryDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_history_detail, null, false, obj);
    }

    public static FragmentCheckInHistoryDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInHistoryDetailBinding bind(View view, Object obj) {
        return (FragmentCheckInHistoryDetailBinding) bind(obj, view, R.layout.fragment_check_in_history_detail);
    }
}
