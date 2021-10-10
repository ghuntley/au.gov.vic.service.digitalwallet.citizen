package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.FavouriteCellViewModel;

public abstract class ItemCheckInFavouriteCellBinding extends ViewDataBinding {
    @Bindable
    protected FavouriteCellViewModel mVm;

    public abstract void setVm(FavouriteCellViewModel favouriteCellViewModel);

    protected ItemCheckInFavouriteCellBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public FavouriteCellViewModel getVm() {
        return this.mVm;
    }

    public static ItemCheckInFavouriteCellBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckInFavouriteCellBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCheckInFavouriteCellBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_check_in_favourite_cell, viewGroup, z, obj);
    }

    public static ItemCheckInFavouriteCellBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckInFavouriteCellBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCheckInFavouriteCellBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_check_in_favourite_cell, null, false, obj);
    }

    public static ItemCheckInFavouriteCellBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckInFavouriteCellBinding bind(View view, Object obj) {
        return (ItemCheckInFavouriteCellBinding) bind(obj, view, R.layout.item_check_in_favourite_cell);
    }
}
