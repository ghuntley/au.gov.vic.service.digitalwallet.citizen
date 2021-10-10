package com.digitalwallet.check_in.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class ActivityCheckInBinding extends ViewDataBinding {
    public final FrameLayout fragmentContainer;

    protected ActivityCheckInBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.fragmentContainer = frameLayout;
    }

    public static ActivityCheckInBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCheckInBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityCheckInBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_check_in, viewGroup, z, obj);
    }

    public static ActivityCheckInBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCheckInBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityCheckInBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_check_in, null, false, obj);
    }

    public static ActivityCheckInBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCheckInBinding bind(View view, Object obj) {
        return (ActivityCheckInBinding) bind(obj, view, R.layout.activity_check_in);
    }
}
