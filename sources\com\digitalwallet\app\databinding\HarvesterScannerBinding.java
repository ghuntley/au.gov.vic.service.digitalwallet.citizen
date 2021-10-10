package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel;

public abstract class HarvesterScannerBinding extends ViewDataBinding {
    public final ImageView backButton;
    public final FrameLayout cameraFrame;
    public final FrameLayout cameraGuide;
    public final TextView eligibilityScannerSubtitle;
    @Bindable
    protected HarvestTagViewModel mVm;
    public final ConstraintLayout outerFrame;
    public final LinearLayout thickFooter;

    public abstract void setVm(HarvestTagViewModel harvestTagViewModel);

    protected HarvesterScannerBinding(Object obj, View view, int i, ImageView imageView, FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView, ConstraintLayout constraintLayout, LinearLayout linearLayout) {
        super(obj, view, i);
        this.backButton = imageView;
        this.cameraFrame = frameLayout;
        this.cameraGuide = frameLayout2;
        this.eligibilityScannerSubtitle = textView;
        this.outerFrame = constraintLayout;
        this.thickFooter = linearLayout;
    }

    public HarvestTagViewModel getVm() {
        return this.mVm;
    }

    public static HarvesterScannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterScannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HarvesterScannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_scanner, viewGroup, z, obj);
    }

    public static HarvesterScannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterScannerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HarvesterScannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.harvester_scanner, null, false, obj);
    }

    public static HarvesterScannerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HarvesterScannerBinding bind(View view, Object obj) {
        return (HarvesterScannerBinding) bind(obj, view, R.layout.harvester_scanner);
    }
}
