package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.harvester.HarvestJobWizardViewModel;
import com.google.android.material.textfield.TextInputEditText;

public abstract class HarvesterAddressBinding extends ViewDataBinding {
    public final TextInputEditText address;
    public final TextInputEditText contactNumber;
    @Bindable
    protected HarvestJobWizardViewModel mVm;
    public final GridLayout summaryScreen;

    public abstract void setVm(HarvestJobWizardViewModel harvestJobWizardViewModel);

    protected HarvesterAddressBinding(Object obj, View view, int i, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, GridLayout gridLayout) {
        super(obj, view, i);
        this.address = textInputEditText;
        this.contactNumber = textInputEditText2;
        this.summaryScreen = gridLayout;
    }

    public HarvestJobWizardViewModel getVm() {
        return this.mVm;
    }

    public static HarvesterAddressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterAddressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HarvesterAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_address, viewGroup, z, obj);
    }

    public static HarvesterAddressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterAddressBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HarvesterAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_address, null, false, obj);
    }

    public static HarvesterAddressBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterAddressBinding bind(View view, Object obj) {
        return (HarvesterAddressBinding) bind(obj, view, R.layout.harvester_address);
    }
}
