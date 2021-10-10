package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInFeedbackSuccessViewModel;

public abstract class FragmentCheckInFeedbackSuccessBinding extends ViewDataBinding {
    @Bindable
    protected CheckInFeedbackSuccessViewModel mVm;

    public abstract void setVm(CheckInFeedbackSuccessViewModel checkInFeedbackSuccessViewModel);

    protected FragmentCheckInFeedbackSuccessBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public CheckInFeedbackSuccessViewModel getVm() {
        return this.mVm;
    }

    public static FragmentCheckInFeedbackSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInFeedbackSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCheckInFeedbackSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_feedback_success, viewGroup, z, obj);
    }

    public static FragmentCheckInFeedbackSuccessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInFeedbackSuccessBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCheckInFeedbackSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_feedback_success, null, false, obj);
    }

    public static FragmentCheckInFeedbackSuccessBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInFeedbackSuccessBinding bind(View view, Object obj) {
        return (FragmentCheckInFeedbackSuccessBinding) bind(obj, view, R.layout.fragment_check_in_feedback_success);
    }
}
