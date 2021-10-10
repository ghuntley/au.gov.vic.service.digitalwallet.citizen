package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class ActivitySetupBinding extends ViewDataBinding {
    public final ConstraintLayout fragmentContainer;

    protected ActivitySetupBinding(Object obj, View view, int i, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.fragmentContainer = constraintLayout;
    }

    public static ActivitySetupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySetupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivitySetupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_setup, viewGroup, z, obj);
    }

    public static ActivitySetupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySetupBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivitySetupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_setup, null, false, obj);
    }

    public static ActivitySetupBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySetupBinding bind(View view, Object obj) {
        return (ActivitySetupBinding) bind(obj, view, R.layout.activity_setup);
    }
}
