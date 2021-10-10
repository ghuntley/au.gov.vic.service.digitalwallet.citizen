package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.login.HomeServicesViewModel;

public abstract class FragmentHomeServicesBinding extends ViewDataBinding {
    public final LinearLayout carouselPagingDots;
    public final LinearLayout checkInContentView;
    public final ConstraintLayout checkInView;
    public final TextView citizenLoginHeading;
    public final RecyclerView favouriteCarousel;
    public final LinearLayout favouriteCarouselContainer;
    public final Guideline guideline;
    public final Guideline guideline2;
    public final TextView loginCopy;
    public final ViewPager loginTopCarousel;
    @Bindable
    protected HomeServicesViewModel mVm;
    public final ConstraintLayout mainLayout;
    public final ImageView serviceVicLogo;
    public final LinearLayout svServiceGroups;
    public final LinearLayout svServicesDivider;
    public final ImageView vAccount;
    public final TextView vLoginPrivacy;

    public abstract void setVm(HomeServicesViewModel homeServicesViewModel);

    protected FragmentHomeServicesBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout, TextView textView, RecyclerView recyclerView, LinearLayout linearLayout3, Guideline guideline3, Guideline guideline4, TextView textView2, ViewPager viewPager, ConstraintLayout constraintLayout2, ImageView imageView, LinearLayout linearLayout4, LinearLayout linearLayout5, ImageView imageView2, TextView textView3) {
        super(obj, view, i);
        this.carouselPagingDots = linearLayout;
        this.checkInContentView = linearLayout2;
        this.checkInView = constraintLayout;
        this.citizenLoginHeading = textView;
        this.favouriteCarousel = recyclerView;
        this.favouriteCarouselContainer = linearLayout3;
        this.guideline = guideline3;
        this.guideline2 = guideline4;
        this.loginCopy = textView2;
        this.loginTopCarousel = viewPager;
        this.mainLayout = constraintLayout2;
        this.serviceVicLogo = imageView;
        this.svServiceGroups = linearLayout4;
        this.svServicesDivider = linearLayout5;
        this.vAccount = imageView2;
        this.vLoginPrivacy = textView3;
    }

    public HomeServicesViewModel getVm() {
        return this.mVm;
    }

    public static FragmentHomeServicesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeServicesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentHomeServicesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_services, viewGroup, z, obj);
    }

    public static FragmentHomeServicesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeServicesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentHomeServicesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_services, null, false, obj);
    }

    public static FragmentHomeServicesBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeServicesBinding bind(View view, Object obj) {
        return (FragmentHomeServicesBinding) bind(obj, view, R.layout.fragment_home_services);
    }
}
