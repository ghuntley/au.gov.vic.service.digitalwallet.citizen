package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.svservices.SVCategoryViewModel;

public abstract class ItemServiceGroupCategoryBinding extends ViewDataBinding {
    public final TextView categoryDescription;
    public final TextView categoryTitle;
    @Bindable
    protected SVCategoryViewModel mVm;
    public final ImageView nextIcon;

    public abstract void setVm(SVCategoryViewModel sVCategoryViewModel);

    protected ItemServiceGroupCategoryBinding(Object obj, View view, int i, TextView textView, TextView textView2, ImageView imageView) {
        super(obj, view, i);
        this.categoryDescription = textView;
        this.categoryTitle = textView2;
        this.nextIcon = imageView;
    }

    public SVCategoryViewModel getVm() {
        return this.mVm;
    }

    public static ItemServiceGroupCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemServiceGroupCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemServiceGroupCategoryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_service_group_category, viewGroup, z, obj);
    }

    public static ItemServiceGroupCategoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemServiceGroupCategoryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemServiceGroupCategoryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_service_group_category, null, false, obj);
    }

    public static ItemServiceGroupCategoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemServiceGroupCategoryBinding bind(View view, Object obj) {
        return (ItemServiceGroupCategoryBinding) bind(obj, view, R.layout.item_service_group_category);
    }
}
