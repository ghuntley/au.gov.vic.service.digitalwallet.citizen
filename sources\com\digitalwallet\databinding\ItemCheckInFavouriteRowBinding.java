package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.FavouriteRowViewModel;

public abstract class ItemCheckInFavouriteRowBinding extends ViewDataBinding {
    public final ImageView endIcon;
    @Bindable
    protected FavouriteRowViewModel mVm;

    public abstract void setVm(FavouriteRowViewModel favouriteRowViewModel);

    protected ItemCheckInFavouriteRowBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.endIcon = imageView;
    }

    public FavouriteRowViewModel getVm() {
        return this.mVm;
    }

    public static ItemCheckInFavouriteRowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckInFavouriteRowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCheckInFavouriteRowBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_check_in_favourite_row, viewGroup, z, obj);
    }

    public static ItemCheckInFavouriteRowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckInFavouriteRowBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCheckInFavouriteRowBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_check_in_favourite_row, null, false, obj);
    }

    public static ItemCheckInFavouriteRowBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCheckInFavouriteRowBinding bind(View view, Object obj) {
        return (ItemCheckInFavouriteRowBinding) bind(obj, view, R.layout.item_check_in_favourite_row);
    }
}
