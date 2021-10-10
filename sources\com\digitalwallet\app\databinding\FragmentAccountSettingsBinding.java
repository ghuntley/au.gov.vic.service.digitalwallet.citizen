package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.AccountSettingsFragmentViewModel;

public abstract class FragmentAccountSettingsBinding extends ViewDataBinding {
    @Bindable
    protected AccountSettingsFragmentViewModel mVm;
    public final RecyclerView settingItemsRecyclerView;

    public abstract void setVm(AccountSettingsFragmentViewModel accountSettingsFragmentViewModel);

    protected FragmentAccountSettingsBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.settingItemsRecyclerView = recyclerView;
    }

    public AccountSettingsFragmentViewModel getVm() {
        return this.mVm;
    }

    public static FragmentAccountSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAccountSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentAccountSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_account_settings, viewGroup, z, obj);
    }

    public static FragmentAccountSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAccountSettingsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentAccountSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_account_settings, null, false, obj);
    }

    public static FragmentAccountSettingsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAccountSettingsBinding bind(View view, Object obj) {
        return (FragmentAccountSettingsBinding) bind(obj, view, R.layout.fragment_account_settings);
    }
}
