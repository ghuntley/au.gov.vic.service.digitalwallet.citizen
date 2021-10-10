package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.transaction.TransactionHistoryItem;

public abstract class ItemTransactionHistoryBinding extends ViewDataBinding {
    public final TextView date;
    @Bindable
    protected TransactionHistoryItem mVm;
    public final TextView name;
    public final TextView refNum;
    public final TextView status;

    public abstract void setVm(TransactionHistoryItem transactionHistoryItem);

    protected ItemTransactionHistoryBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.date = textView;
        this.name = textView2;
        this.refNum = textView3;
        this.status = textView4;
    }

    public TransactionHistoryItem getVm() {
        return this.mVm;
    }

    public static ItemTransactionHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTransactionHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTransactionHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_transaction_history, viewGroup, z, obj);
    }

    public static ItemTransactionHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTransactionHistoryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTransactionHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_transaction_history, null, false, obj);
    }

    public static ItemTransactionHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTransactionHistoryBinding bind(View view, Object obj) {
        return (ItemTransactionHistoryBinding) bind(obj, view, R.layout.item_transaction_history);
    }
}
