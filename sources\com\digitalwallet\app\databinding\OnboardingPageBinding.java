package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class OnboardingPageBinding extends ViewDataBinding {
    public final TextView copy1;
    public final TextView copy2;
    public final ImageView image;

    protected OnboardingPageBinding(Object obj, View view, int i, TextView textView, TextView textView2, ImageView imageView) {
        super(obj, view, i);
        this.copy1 = textView;
        this.copy2 = textView2;
        this.image = imageView;
    }

    public static OnboardingPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OnboardingPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (OnboardingPageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.onboarding_page, viewGroup, z, obj);
    }

    public static OnboardingPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OnboardingPageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (OnboardingPageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.onboarding_page, null, false, obj);
    }

    public static OnboardingPageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OnboardingPageBinding bind(View view, Object obj) {
        return (OnboardingPageBinding) bind(obj, view, R.layout.onboarding_page);
    }
}
