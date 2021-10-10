package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.CheckInScannerViewModel;

public abstract class FragmentCheckInScannerBinding extends ViewDataBinding {
    public final ImageView backButton;
    public final FrameLayout cameraFrame;
    public final FrameLayout cameraGuide;
    public final TextView helpBtn;
    public final TextView instruction;
    @Bindable
    protected CheckInScannerViewModel mVm;
    public final TextView manualButton;
    public final ConstraintLayout outerFrame;
    public final ConstraintLayout thickFooter;
    public final ProgressBar verifyingSpinner;

    public abstract void setVm(CheckInScannerViewModel checkInScannerViewModel);

    protected FragmentCheckInScannerBinding(Object obj, View view, int i, ImageView imageView, FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ProgressBar progressBar) {
        super(obj, view, i);
        this.backButton = imageView;
        this.cameraFrame = frameLayout;
        this.cameraGuide = frameLayout2;
        this.helpBtn = textView;
        this.instruction = textView2;
        this.manualButton = textView3;
        this.outerFrame = constraintLayout;
        this.thickFooter = constraintLayout2;
        this.verifyingSpinner = progressBar;
    }

    public CheckInScannerViewModel getVm() {
        return this.mVm;
    }

    public static FragmentCheckInScannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInScannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCheckInScannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_scanner, viewGroup, z, obj);
    }

    public static FragmentCheckInScannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInScannerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCheckInScannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_scanner, null, false, obj);
    }

    public static FragmentCheckInScannerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInScannerBinding bind(View view, Object obj) {
        return (FragmentCheckInScannerBinding) bind(obj, view, R.layout.fragment_check_in_scanner);
    }
}
