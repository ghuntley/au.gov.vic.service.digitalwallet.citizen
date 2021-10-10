package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel;

public abstract class HarvesterTagSummaryBinding extends ViewDataBinding {
    @Bindable
    protected HarvestTagViewModel mVm;
    public final GridLayout summaryScreen;

    public abstract void setVm(HarvestTagViewModel harvestTagViewModel);

    protected HarvesterTagSummaryBinding(Object obj, View view, int i, GridLayout gridLayout) {
        super(obj, view, i);
        this.summaryScreen = gridLayout;
    }

    public HarvestTagViewModel getVm() {
        return this.mVm;
    }

    public static HarvesterTagSummaryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterTagSummaryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HarvesterTagSummaryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_tag_summary, viewGroup, z, obj);
    }

    public static HarvesterTagSummaryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterTagSummaryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HarvesterTagSummaryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_tag_summary, null, false, obj);
    }

    public static HarvesterTagSummaryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterTagSummaryBinding bind(View view, Object obj) {
        return (HarvesterTagSummaryBinding) bind(obj, view, R.layout.harvester_tag_summary);
    }
}
