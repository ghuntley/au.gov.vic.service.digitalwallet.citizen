package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSummaryViewModel;

public abstract class FragmentCheckInSummaryBinding extends ViewDataBinding {
    public final LayoutCheckInPrivacyBinding checkInPrivacyLayout;
    public final LinearLayout dependantList;
    @Bindable
    protected CheckInSummaryViewModel mVm;
    public final LayoutCheckInTitleBarBinding titleBar;

    public abstract void setVm(CheckInSummaryViewModel checkInSummaryViewModel);

    protected FragmentCheckInSummaryBinding(Object obj, View view, int i, LayoutCheckInPrivacyBinding layoutCheckInPrivacyBinding, LinearLayout linearLayout, LayoutCheckInTitleBarBinding layoutCheckInTitleBarBinding) {
        super(obj, view, i);
        this.checkInPrivacyLayout = layoutCheckInPrivacyBinding;
        this.dependantList = linearLayout;
        this.titleBar = layoutCheckInTitleBarBinding;
    }

    public CheckInSummaryViewModel getVm() {
        return this.mVm;
    }

    public static FragmentCheckInSummaryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInSummaryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCheckInSummaryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_summary, viewGroup, z, obj);
    }

    public static FragmentCheckInSummaryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInSummaryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCheckInSummaryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_summary, null, false, obj);
    }

    public static FragmentCheckInSummaryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInSummaryBinding bind(View view, Object obj) {
        return (FragmentCheckInSummaryBinding) bind(obj, view, R.layout.fragment_check_in_summary);
    }
}
