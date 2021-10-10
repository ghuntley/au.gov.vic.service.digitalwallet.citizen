package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class CardSolarInstallerBackBinding extends ViewDataBinding {
    protected CardSolarInstallerBackBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static CardSolarInstallerBackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardSolarInstallerBackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardSolarInstallerBackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_solar_installer_back, viewGroup, z, obj);
    }

    public static CardSolarInstallerBackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardSolarInstallerBackBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardSolarInstallerBackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_solar_installer_back, null, false, obj);
    }

    public static CardSolarInstallerBackBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardSolarInstallerBackBinding bind(View view, Object obj) {
        return (CardSolarInstallerBackBinding) bind(obj, view, R.layout.card_solar_installer_back);
    }
}
