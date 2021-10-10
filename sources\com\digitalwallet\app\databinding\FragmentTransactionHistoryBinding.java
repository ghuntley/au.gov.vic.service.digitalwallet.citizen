package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.history.TransactionHistoryFragmentViewModel;

public abstract class FragmentTransactionHistoryBinding extends ViewDataBinding {
    public final ConstraintLayout errorMsgView;
    public final ImageView imageView2;
    public final ProgressBar loadingHud;
    @Bindable
    protected TransactionHistoryFragmentViewModel mVm;
    public final ConstraintLayout noTransactionView;
    public final Button notificationButton;
    public final TextView textView5;
    public final TextView textView6;
    public final RecyclerView transactionHistoryRecyclerView;

    public abstract void setVm(TransactionHistoryFragmentViewModel transactionHistoryFragmentViewModel);

    protected FragmentTransactionHistoryBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, ProgressBar progressBar, ConstraintLayout constraintLayout2, Button button, TextView textView, TextView textView2, RecyclerView recyclerView) {
        super(obj, view, i);
        this.errorMsgView = constraintLayout;
        this.imageView2 = imageView;
        this.loadingHud = progressBar;
        this.noTransactionView = constraintLayout2;
        this.notificationButton = button;
        this.textView5 = textView;
        this.textView6 = textView2;
        this.transactionHistoryRecyclerView = recyclerView;
    }

    public TransactionHistoryFragmentViewModel getVm() {
        return this.mVm;
    }

    public static FragmentTransactionHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransactionHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTransactionHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_transaction_history, viewGroup, z, obj);
    }

    public static FragmentTransactionHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransactionHistoryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTransactionHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_transaction_history, null, false, obj);
    }

    public static FragmentTransactionHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransactionHistoryBinding bind(View view, Object obj) {
        return (FragmentTransactionHistoryBinding) bind(obj, view, R.layout.fragment_transaction_history);
    }
}
