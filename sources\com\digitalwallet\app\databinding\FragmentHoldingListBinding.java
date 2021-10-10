package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.HoldingListFragmentViewModel;

public abstract class FragmentHoldingListBinding extends ViewDataBinding {
    public final TextView addCardBtn;
    public final ImageView bluetoothIndicator;
    public final RecyclerView cardListRecyclerView;
    public final TextView downloadExistingView;
    public final ProgressBar loadingHud;
    @Bindable
    protected HoldingListFragmentViewModel mVm;
    public final TextView moreInfoView;
    public final TextView sharingActivityText;
    public final ConstraintLayout sharingActivityView;
    public final ImageView sharingCaret;
    public final TextView title;

    public abstract void setVm(HoldingListFragmentViewModel holdingListFragmentViewModel);

    protected FragmentHoldingListBinding(Object obj, View view, int i, TextView textView, ImageView imageView, RecyclerView recyclerView, TextView textView2, ProgressBar progressBar, TextView textView3, TextView textView4, ConstraintLayout constraintLayout, ImageView imageView2, TextView textView5) {
        super(obj, view, i);
        this.addCardBtn = textView;
        this.bluetoothIndicator = imageView;
        this.cardListRecyclerView = recyclerView;
        this.downloadExistingView = textView2;
        this.loadingHud = progressBar;
        this.moreInfoView = textView3;
        this.sharingActivityText = textView4;
        this.sharingActivityView = constraintLayout;
        this.sharingCaret = imageView2;
        this.title = textView5;
    }

    public HoldingListFragmentViewModel getVm() {
        return this.mVm;
    }

    public static FragmentHoldingListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHoldingListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentHoldingListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_holding_list, viewGroup, z, obj);
    }

    public static FragmentHoldingListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHoldingListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentHoldingListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_holding_list, null, false, obj);
    }

    public static FragmentHoldingListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHoldingListBinding bind(View view, Object obj) {
        return (FragmentHoldingListBinding) bind(obj, view, R.layout.fragment_holding_list);
    }
}
