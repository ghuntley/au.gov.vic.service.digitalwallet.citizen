package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class ItemCheckInHistoryHeaderBinding extends ViewDataBinding {
    @Bindable
    protected String mMediumDate;
    @Bindable
    protected String mRelativeDay;

    public abstract void setMediumDate(String str);

    public abstract void setRelativeDay(String str);

    protected ItemCheckInHistoryHeaderBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public String getMediumDate() {
        return this.mMediumDate;
    }

    public String getRelativeDay() {
        return this.mRelativeDay;
    }

    public static ItemCheckInHistoryHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckInHistoryHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCheckInHistoryHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_check_in_history_header, viewGroup, z, obj);
    }

    public static ItemCheckInHistoryHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckInHistoryHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCheckInHistoryHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_check_in_history_header, null, false, obj);
    }

    public static ItemCheckInHistoryHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckInHistoryHeaderBinding bind(View view, Object obj) {
        return (ItemCheckInHistoryHeaderBinding) bind(obj, view, R.layout.item_check_in_history_header);
    }
}
