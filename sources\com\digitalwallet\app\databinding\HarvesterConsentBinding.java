package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.harvester.HarvestJobWizardViewModel;

public abstract class HarvesterConsentBinding extends ViewDataBinding {
    @Bindable
    protected HarvestJobWizardViewModel mVm;

    public abstract void setVm(HarvestJobWizardViewModel harvestJobWizardViewModel);

    protected HarvesterConsentBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public HarvestJobWizardViewModel getVm() {
        return this.mVm;
    }

    public static HarvesterConsentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterConsentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HarvesterConsentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_consent, viewGroup, z, obj);
    }

    public static HarvesterConsentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterConsentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HarvesterConsentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_consent, null, false, obj);
    }

    public static HarvesterConsentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterConsentBinding bind(View view, Object obj) {
        return (HarvesterConsentBinding) bind(obj, view, R.layout.harvester_consent);
    }
}
