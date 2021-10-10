package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckedInDetailFavouringBaseViewModel;

public abstract class LayoutCheckedInDetailFavouringBinding extends ViewDataBinding {
    public final ConstraintLayout checkInDetail;
    public final ImageView checkInTick;
    public final TextView checkInToTitle;
    public final TextView checkedIn;
    public final TextView checkedInTime;
    public final LinearLayout favouringView;
    @Bindable
    protected Boolean mShowDoneButton;
    @Bindable
    protected CheckedInDetailFavouringBaseViewModel mVm;
    public final ConstraintLayout networkConnectionIssue;
    public final TextView networkConnectionIssueErrorMessage;
    public final TextView networkConnectionIssueHeading;

    public abstract void setShowDoneButton(Boolean bool);

    public abstract void setVm(CheckedInDetailFavouringBaseViewModel checkedInDetailFavouringBaseViewModel);

    protected LayoutCheckedInDetailFavouringBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, ConstraintLayout constraintLayout2, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.checkInDetail = constraintLayout;
        this.checkInTick = imageView;
        this.checkInToTitle = textView;
        this.checkedIn = textView2;
        this.checkedInTime = textView3;
        this.favouringView = linearLayout;
        this.networkConnectionIssue = constraintLayout2;
        this.networkConnectionIssueErrorMessage = textView4;
        this.networkConnectionIssueHeading = textView5;
    }

    public CheckedInDetailFavouringBaseViewModel getVm() {
        return this.mVm;
    }

    public Boolean getShowDoneButton() {
        return this.mShowDoneButton;
    }

    public static LayoutCheckedInDetailFavouringBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckedInDetailFavouringBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutCheckedInDetailFavouringBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_checked_in_detail_favouring, viewGroup, z, obj);
    }

    public static LayoutCheckedInDetailFavouringBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckedInDetailFavouringBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutCheckedInDetailFavouringBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_checked_in_detail_favouring, null, false, obj);
    }

    public static LayoutCheckedInDetailFavouringBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckedInDetailFavouringBinding bind(View view, Object obj) {
        return (LayoutCheckedInDetailFavouringBinding) bind(obj, view, R.layout.layout_checked_in_detail_favouring);
    }
}
