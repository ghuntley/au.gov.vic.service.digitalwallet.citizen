package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.MainPagerFragmentViewModel;
import com.google.android.material.tabs.TabLayout;

public abstract class FragmentMainPagerBinding extends ViewDataBinding {
    public final TextView logoutBtn;
    @Bindable
    protected MainPagerFragmentViewModel mVm;
    public final ConstraintLayout serviceMainContainer;
    public final TabLayout tabLayout;
    public final TextView title;
    public final ViewPager viewPager;

    public abstract void setVm(MainPagerFragmentViewModel mainPagerFragmentViewModel);

    protected FragmentMainPagerBinding(Object obj, View view, int i, TextView textView, ConstraintLayout constraintLayout, TabLayout tabLayout2, TextView textView2, ViewPager viewPager2) {
        super(obj, view, i);
        this.logoutBtn = textView;
        this.serviceMainContainer = constraintLayout;
        this.tabLayout = tabLayout2;
        this.title = textView2;
        this.viewPager = viewPager2;
    }

    public MainPagerFragmentViewModel getVm() {
        return this.mVm;
    }

    public static FragmentMainPagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMainPagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentMainPagerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_main_pager, viewGroup, z, obj);
    }

    public static FragmentMainPagerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMainPagerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentMainPagerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_main_pager, null, false, obj);
    }

    public static FragmentMainPagerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMainPagerBinding bind(View view, Object obj) {
        return (FragmentMainPagerBinding) bind(obj, view, R.layout.fragment_main_pager);
    }
}
