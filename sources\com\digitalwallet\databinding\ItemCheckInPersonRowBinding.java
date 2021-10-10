package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkInInput.PersonRowViewModel;

public abstract class ItemCheckInPersonRowBinding extends ViewDataBinding {
    @Bindable
    protected PersonRowViewModel mVm;

    public abstract void setVm(PersonRowViewModel personRowViewModel);

    protected ItemCheckInPersonRowBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public PersonRowViewModel getVm() {
        return this.mVm;
    }

    public static ItemCheckInPersonRowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckInPersonRowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCheckInPersonRowBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_check_in_person_row, viewGroup, z, obj);
    }

    public static ItemCheckInPersonRowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckInPersonRowBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCheckInPersonRowBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_check_in_person_row, null, false, obj);
    }

    public static ItemCheckInPersonRowBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckInPersonRowBinding bind(View view, Object obj) {
        return (ItemCheckInPersonRowBinding) bind(obj, view, R.layout.item_check_in_person_row);
    }
}
