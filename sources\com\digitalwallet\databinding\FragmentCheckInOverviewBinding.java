package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.CheckInOverviewViewModel;

public abstract class FragmentCheckInOverviewBinding extends ViewDataBinding {
    public final Button checkInBtn;
    public final ConstraintLayout checkInInfoView;
    public final ConstraintLayout checkInInput;
    public final ImageView checkInTick;
    public final TextView checkInToTitle;
    public final TextView checkedIn;
    public final TextView checkedInTime;
    public final TextView desc;
    public final ConstraintLayout description;
    public final TextView infoBtn;
    @Bindable
    protected CheckInOverviewViewModel mVm;
    public final TextView networkConnectionIssueErrorMessage;
    public final TextView noCheckInDesc;
    public final TextView noCheckInTitle;
    public final ConstraintLayout noCheckInView;
    public final TextView title;

    public abstract void setVm(CheckInOverviewViewModel checkInOverviewViewModel);

    protected FragmentCheckInOverviewBinding(Object obj, View view, int i, Button button, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout3, TextView textView5, TextView textView6, TextView textView7, TextView textView8, ConstraintLayout constraintLayout4, TextView textView9) {
        super(obj, view, i);
        this.checkInBtn = button;
        this.checkInInfoView = constraintLayout;
        this.checkInInput = constraintLayout2;
        this.checkInTick = imageView;
        this.checkInToTitle = textView;
        this.checkedIn = textView2;
        this.checkedInTime = textView3;
        this.desc = textView4;
        this.description = constraintLayout3;
        this.infoBtn = textView5;
        this.networkConnectionIssueErrorMessage = textView6;
        this.noCheckInDesc = textView7;
        this.noCheckInTitle = textView8;
        this.noCheckInView = constraintLayout4;
        this.title = textView9;
    }

    public CheckInOverviewViewModel getVm() {
        return this.mVm;
    }

    public static FragmentCheckInOverviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInOverviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCheckInOverviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_overview, viewGroup, z, obj);
    }

    public static FragmentCheckInOverviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInOverviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCheckInOverviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_check_in_overview, null, false, obj);
    }

    public static FragmentCheckInOverviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCheckInOverviewBinding bind(View view, Object obj) {
        return (FragmentCheckInOverviewBinding) bind(obj, view, R.layout.fragment_check_in_overview);
    }
}
