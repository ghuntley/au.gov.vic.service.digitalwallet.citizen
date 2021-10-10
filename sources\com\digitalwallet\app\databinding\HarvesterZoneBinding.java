package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.harvester.HarvestJobWizardViewModel;

public abstract class HarvesterZoneBinding extends ViewDataBinding {
    @Bindable
    protected HarvestJobWizardViewModel mVm;
    public final RecyclerView zoneTable;

    public abstract void setVm(HarvestJobWizardViewModel harvestJobWizardViewModel);

    protected HarvesterZoneBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.zoneTable = recyclerView;
    }

    public HarvestJobWizardViewModel getVm() {
        return this.mVm;
    }

    public static HarvesterZoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterZoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HarvesterZoneBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_zone, viewGroup, z, obj);
    }

    public static HarvesterZoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterZoneBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HarvesterZoneBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_zone, null, false, obj);
    }

    public static HarvesterZoneBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterZoneBinding bind(View view, Object obj) {
        return (HarvesterZoneBinding) bind(obj, view, R.layout.harvester_zone);
    }
}
