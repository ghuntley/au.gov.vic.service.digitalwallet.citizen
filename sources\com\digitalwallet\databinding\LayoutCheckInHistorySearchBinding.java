package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class LayoutCheckInHistorySearchBinding extends ViewDataBinding {
    public final SearchView searchView;

    protected LayoutCheckInHistorySearchBinding(Object obj, View view, int i, SearchView searchView2) {
        super(obj, view, i);
        this.searchView = searchView2;
    }

    public static LayoutCheckInHistorySearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckInHistorySearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutCheckInHistorySearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_check_in_history_search, viewGroup, z, obj);
    }

    public static LayoutCheckInHistorySearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckInHistorySearchBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutCheckInHistorySearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_check_in_history_search, null, false, obj);
    }

    public static LayoutCheckInHistorySearchBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckInHistorySearchBinding bind(View view, Object obj) {
        return (LayoutCheckInHistorySearchBinding) bind(obj, view, R.layout.layout_check_in_history_search);
    }
}
