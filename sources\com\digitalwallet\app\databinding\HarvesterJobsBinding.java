package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.harvester.HarvestJobWizardViewModel;

public abstract class HarvesterJobsBinding extends ViewDataBinding {
    public final Button addCardBtn;
    public final RecyclerView jobTable;
    @Bindable
    protected HarvestJobWizardViewModel mVm;

    public abstract void setVm(HarvestJobWizardViewModel harvestJobWizardViewModel);

    protected HarvesterJobsBinding(Object obj, View view, int i, Button button, RecyclerView recyclerView) {
        super(obj, view, i);
        this.addCardBtn = button;
        this.jobTable = recyclerView;
    }

    public HarvestJobWizardViewModel getVm() {
        return this.mVm;
    }

    public static HarvesterJobsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterJobsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HarvesterJobsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_jobs, viewGroup, z, obj);
    }

    public static HarvesterJobsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterJobsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HarvesterJobsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_jobs, null, false, obj);
    }

    public static HarvesterJobsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterJobsBinding bind(View view, Object obj) {
        return (HarvesterJobsBinding) bind(obj, view, R.layout.harvester_jobs);
    }
}
