package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.splash.SplashViewModel;

public abstract class ActivitySplashBinding extends ViewDataBinding {
    @Bindable
    protected SplashViewModel mVm;
    public final ImageView serviceVicLogo;

    public abstract void setVm(SplashViewModel splashViewModel);

    protected ActivitySplashBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.serviceVicLogo = imageView;
    }

    public SplashViewModel getVm() {
        return this.mVm;
    }

    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivitySplashBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_splash, viewGroup, z, obj);
    }

    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivitySplashBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_splash, null, false, obj);
    }

    public static ActivitySplashBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySplashBinding bind(View view, Object obj) {
        return (ActivitySplashBinding) bind(obj, view, R.layout.activity_splash);
    }
}
