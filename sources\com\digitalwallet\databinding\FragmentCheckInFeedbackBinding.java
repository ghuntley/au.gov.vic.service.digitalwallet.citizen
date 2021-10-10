package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInFeedbackViewModel;

public abstract class FragmentCheckInFeedbackBinding extends ViewDataBinding {
    @Bindable
    protected CheckInFeedbackViewModel mVm;
    public final Button skipBtn;

    public abstract void setVm(CheckInFeedbackViewModel checkInFeedbackViewModel);

    protected FragmentCheckInFeedbackBinding(Object obj, View view, int i, Button button) {
        super(obj, view, i);
        this.skipBtn = button;
    }

    public CheckInFeedbackViewModel getVm() {
        return this.mVm;
    }

    public static FragmentCheckInFeedbackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInFeedbackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCheckInFeedbackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_feedback, viewGroup, z, obj);
    }

    public static FragmentCheckInFeedbackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInFeedbackBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCheckInFeedbackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_feedback, null, false, obj);
    }

    public static FragmentCheckInFeedbackBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInFeedbackBinding bind(View view, Object obj) {
        return (FragmentCheckInFeedbackBinding) bind(obj, view, R.layout.fragment_check_in_feedback);
    }
}
