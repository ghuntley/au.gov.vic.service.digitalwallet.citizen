package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel;
import com.google.android.material.textfield.TextInputEditText;

public abstract class HarvesterTagManualEntryBinding extends ViewDataBinding {
    public final TextInputEditText barcodeNumber;
    @Bindable
    protected HarvestTagViewModel mVm;

    public abstract void setVm(HarvestTagViewModel harvestTagViewModel);

    protected HarvesterTagManualEntryBinding(Object obj, View view, int i, TextInputEditText textInputEditText) {
        super(obj, view, i);
        this.barcodeNumber = textInputEditText;
    }

    public HarvestTagViewModel getVm() {
        return this.mVm;
    }

    public static HarvesterTagManualEntryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterTagManualEntryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HarvesterTagManualEntryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_tag_manual_entry, viewGroup, z, obj);
    }

    public static HarvesterTagManualEntryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterTagManualEntryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HarvesterTagManualEntryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_tag_manual_entry, null, false, obj);
    }

    public static HarvesterTagManualEntryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterTagManualEntryBinding bind(View view, Object obj) {
        return (HarvesterTagManualEntryBinding) bind(obj, view, R.layout.harvester_tag_manual_entry);
    }
}
