package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.digitalwallet.app.viewmodel.main.MainActivityViewModel;

public abstract class ActivityMainBinding extends ViewDataBinding {
    public final AHBottomNavigation bottomNavigation;
    public final FrameLayout fragmentContainer;
    @Bindable
    protected MainActivityViewModel mVm;

    public abstract void setVm(MainActivityViewModel mainActivityViewModel);

    protected ActivityMainBinding(Object obj, View view, int i, AHBottomNavigation aHBottomNavigation, FrameLayout frameLayout) {
        super(obj, view, i);
        this.bottomNavigation = aHBottomNavigation;
        this.fragmentContainer = frameLayout;
    }

    public MainActivityViewModel getVm() {
        return this.mVm;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_main, viewGroup, z, obj);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_main, null, false, obj);
    }

    public static ActivityMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding bind(View view, Object obj) {
        return (ActivityMainBinding) bind(obj, view, R.layout.activity_main);
    }
}
