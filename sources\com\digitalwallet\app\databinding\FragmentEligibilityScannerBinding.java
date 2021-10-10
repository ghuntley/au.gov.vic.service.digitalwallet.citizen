package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.EligibilityScannerFragmentViewModel;

public abstract class FragmentEligibilityScannerBinding extends ViewDataBinding {
    public final FrameLayout cameraFrame;
    public final ConstraintLayout cameraGuide;
    public final ConstraintLayout complete;
    public final TextView completeCustomErrorText;
    public final ConstraintLayout completeFooter;
    public final TextView completeSubtitle;
    public final TextView completeTitle;
    public final TextView eligibilityScannerSubtitle;
    public final TextView eligibilityScannerTitle;
    @Bindable
    protected EligibilityScannerFragmentViewModel mVm;
    public final ConstraintLayout pending;
    public final ConstraintLayout scanning;
    public final ConstraintLayout thickFooter;
    public final ConstraintLayout verifying;
    public final ProgressBar verifyingSpinner;
    public final TextView verifyingText;

    public abstract void setVm(EligibilityScannerFragmentViewModel eligibilityScannerFragmentViewModel);

    protected FragmentEligibilityScannerBinding(Object obj, View view, int i, FrameLayout frameLayout, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ConstraintLayout constraintLayout3, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, ProgressBar progressBar, TextView textView6) {
        super(obj, view, i);
        this.cameraFrame = frameLayout;
        this.cameraGuide = constraintLayout;
        this.complete = constraintLayout2;
        this.completeCustomErrorText = textView;
        this.completeFooter = constraintLayout3;
        this.completeSubtitle = textView2;
        this.completeTitle = textView3;
        this.eligibilityScannerSubtitle = textView4;
        this.eligibilityScannerTitle = textView5;
        this.pending = constraintLayout4;
        this.scanning = constraintLayout5;
        this.thickFooter = constraintLayout6;
        this.verifying = constraintLayout7;
        this.verifyingSpinner = progressBar;
        this.verifyingText = textView6;
    }

    public EligibilityScannerFragmentViewModel getVm() {
        return this.mVm;
    }

    public static FragmentEligibilityScannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEligibilityScannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentEligibilityScannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_eligibility_scanner, viewGroup, z, obj);
    }

    public static FragmentEligibilityScannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEligibilityScannerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentEligibilityScannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_eligibility_scanner, null, false, obj);
    }

    public static FragmentEligibilityScannerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEligibilityScannerBinding bind(View view, Object obj) {
        return (FragmentEligibilityScannerBinding) bind(obj, view, R.layout.fragment_eligibility_scanner);
    }
}
