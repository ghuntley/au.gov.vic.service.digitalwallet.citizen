package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.svservices.SVItemViewModel;

public abstract class ItemLoginTopCarouselBinding extends ViewDataBinding {
    @Bindable
    protected SVItemViewModel mVm;

    public abstract void setVm(SVItemViewModel sVItemViewModel);

    protected ItemLoginTopCarouselBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public SVItemViewModel getVm() {
        return this.mVm;
    }

    public static ItemLoginTopCarouselBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLoginTopCarouselBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLoginTopCarouselBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_login_top_carousel, viewGroup, z, obj);
    }

    public static ItemLoginTopCarouselBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLoginTopCarouselBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLoginTopCarouselBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_login_top_carousel, null, false, obj);
    }

    public static ItemLoginTopCarouselBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLoginTopCarouselBinding bind(View view, Object obj) {
        return (ItemLoginTopCarouselBinding) bind(obj, view, R.layout.item_login_top_carousel);
    }
}
