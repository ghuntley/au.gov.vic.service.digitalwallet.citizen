package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.harvester.HarvestJobViewHolder;

public abstract class HarvesterItemJobBinding extends ViewDataBinding {
    @Bindable
    protected HarvestJobViewHolder mVm;

    public abstract void setVm(HarvestJobViewHolder harvestJobViewHolder);

    protected HarvesterItemJobBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public HarvestJobViewHolder getVm() {
        return this.mVm;
    }

    public static HarvesterItemJobBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterItemJobBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HarvesterItemJobBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_item_job, viewGroup, z, obj);
    }

    public static HarvesterItemJobBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterItemJobBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HarvesterItemJobBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_item_job, null, false, obj);
    }

    public static HarvesterItemJobBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterItemJobBinding bind(View view, Object obj) {
        return (HarvesterItemJobBinding) bind(obj, view, R.layout.harvester_item_job);
    }
}
