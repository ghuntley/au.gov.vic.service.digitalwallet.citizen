package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.svservices.ServiceGroupCategoriesViewModel;

public abstract class FragmentServiceGroupCategoriesBinding extends ViewDataBinding {
    public final RecyclerView groupCategoryList;
    public final ImageView groupImage;
    public final TextView groupName;
    @Bindable
    protected ServiceGroupCategoriesViewModel mVm;

    public abstract void setVm(ServiceGroupCategoriesViewModel serviceGroupCategoriesViewModel);

    protected FragmentServiceGroupCategoriesBinding(Object obj, View view, int i, RecyclerView recyclerView, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.groupCategoryList = recyclerView;
        this.groupImage = imageView;
        this.groupName = textView;
    }

    public ServiceGroupCategoriesViewModel getVm() {
        return this.mVm;
    }

    public static FragmentServiceGroupCategoriesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceGroupCategoriesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentServiceGroupCategoriesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_service_group_categories, viewGroup, z, obj);
    }

    public static FragmentServiceGroupCategoriesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceGroupCategoriesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentServiceGroupCategoriesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_service_group_categories, null, false, obj);
    }

    public static FragmentServiceGroupCategoriesBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceGroupCategoriesBinding bind(View view, Object obj) {
        return (FragmentServiceGroupCategoriesBinding) bind(obj, view, R.layout.fragment_service_group_categories);
    }
}
