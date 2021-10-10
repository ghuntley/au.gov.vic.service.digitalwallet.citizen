package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.harvester.HarvestZoneViewHolder;

public abstract class HarvesterItemZoneBinding extends ViewDataBinding {
    @Bindable
    protected HarvestZoneViewHolder mVm;

    public abstract void setVm(HarvestZoneViewHolder harvestZoneViewHolder);

    protected HarvesterItemZoneBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public HarvestZoneViewHolder getVm() {
        return this.mVm;
    }

    public static HarvesterItemZoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterItemZoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HarvesterItemZoneBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_item_zone, viewGroup, z, obj);
    }

    public static HarvesterItemZoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterItemZoneBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HarvesterItemZoneBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_item_zone, null, false, obj);
    }

    public static HarvesterItemZoneBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterItemZoneBinding bind(View view, Object obj) {
        return (HarvesterItemZoneBinding) bind(obj, view, R.layout.harvester_item_zone);
    }
}
