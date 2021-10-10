package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.HistoryRowViewModel;

public abstract class ItemCheckInHistoryRowBinding extends ViewDataBinding {
    @Bindable
    protected HistoryRowViewModel mVm;

    public abstract void setVm(HistoryRowViewModel historyRowViewModel);

    protected ItemCheckInHistoryRowBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public HistoryRowViewModel getVm() {
        return this.mVm;
    }

    public static ItemCheckInHistoryRowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckInHistoryRowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCheckInHistoryRowBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_check_in_history_row, viewGroup, z, obj);
    }

    public static ItemCheckInHistoryRowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckInHistoryRowBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCheckInHistoryRowBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_check_in_history_row, null, false, obj);
    }

    public static ItemCheckInHistoryRowBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckInHistoryRowBinding bind(View view, Object obj) {
        return (ItemCheckInHistoryRowBinding) bind(obj, view, R.layout.item_check_in_history_row);
    }
}
