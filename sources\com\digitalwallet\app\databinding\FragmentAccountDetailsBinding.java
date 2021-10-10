package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.AccountDetailsFragmentViewModel;

public abstract class FragmentAccountDetailsBinding extends ViewDataBinding {
    public final RecyclerView accountDetailsRecyclerView;
    public final ConstraintLayout errorMsgView;
    public final TextView errorText;
    public final TextView historyErrorText;
    public final LinearLayout historyItems;
    public final ProgressBar loadingHud;
    @Bindable
    protected AccountDetailsFragmentViewModel mVm;
    public final Button tryAgainButton;

    public abstract void setVm(AccountDetailsFragmentViewModel accountDetailsFragmentViewModel);

    protected FragmentAccountDetailsBinding(Object obj, View view, int i, RecyclerView recyclerView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, LinearLayout linearLayout, ProgressBar progressBar, Button button) {
        super(obj, view, i);
        this.accountDetailsRecyclerView = recyclerView;
        this.errorMsgView = constraintLayout;
        this.errorText = textView;
        this.historyErrorText = textView2;
        this.historyItems = linearLayout;
        this.loadingHud = progressBar;
        this.tryAgainButton = button;
    }

    public AccountDetailsFragmentViewModel getVm() {
        return this.mVm;
    }

    public static FragmentAccountDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAccountDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentAccountDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_account_details, viewGroup, z, obj);
    }

    public static FragmentAccountDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAccountDetailsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentAccountDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_account_details, null, false, obj);
    }

    public static FragmentAccountDetailsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAccountDetailsBinding bind(View view, Object obj) {
        return (FragmentAccountDetailsBinding) bind(obj, view, R.layout.fragment_account_details);
    }
}
