package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.view.onboarding.OnboardingViewModel;

public abstract class OnboardingBinding extends ViewDataBinding {
    public final ImageView dot1;
    public final ImageView dot2;
    public final ImageView dot3;
    public final LinearLayout dots;
    public final LinearLayout footer;
    public final FrameLayout fragmentContainer;
    @Bindable
    protected OnboardingViewModel mViewModel;
    public final Button next;
    public final ViewPager pager;
    public final TextView skip;

    public abstract void setViewModel(OnboardingViewModel onboardingViewModel);

    protected OnboardingBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout, Button button, ViewPager viewPager, TextView textView) {
        super(obj, view, i);
        this.dot1 = imageView;
        this.dot2 = imageView2;
        this.dot3 = imageView3;
        this.dots = linearLayout;
        this.footer = linearLayout2;
        this.fragmentContainer = frameLayout;
        this.next = button;
        this.pager = viewPager;
        this.skip = textView;
    }

    public OnboardingViewModel getViewModel() {
        return this.mViewModel;
    }

    public static OnboardingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OnboardingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (OnboardingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.onboarding, viewGroup, z, obj);
    }

    public static OnboardingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OnboardingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (OnboardingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.onboarding, null, false, obj);
    }

    public static OnboardingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OnboardingBinding bind(View view, Object obj) {
        return (OnboardingBinding) bind(obj, view, R.layout.onboarding);
    }
}
