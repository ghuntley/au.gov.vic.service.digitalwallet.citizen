package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class HarvesterActivityBinding extends ViewDataBinding {
    public final FrameLayout fragmentContainer;

    protected HarvesterActivityBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.fragmentContainer = frameLayout;
    }

    public static HarvesterActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HarvesterActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_activity, viewGroup, z, obj);
    }

    public static HarvesterActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterActivityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HarvesterActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_activity, null, false, obj);
    }

    public static HarvesterActivityBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterActivityBinding bind(View view, Object obj) {
        return (HarvesterActivityBinding) bind(obj, view, R.layout.harvester_activity);
    }
}
