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
import com.digitalwallet.app.viewmodel.svservices.ServiceCategoryTransactionsViewModel;

public abstract class FragmentServiceCategoryTransactionsBinding extends ViewDataBinding {
    public final ImageView categoryImage;
    public final TextView categoryName;
    public final RecyclerView categoryTransactionList;
    public final TextView groupName;
    @Bindable
    protected ServiceCategoryTransactionsViewModel mVm;

    public abstract void setVm(ServiceCategoryTransactionsViewModel serviceCategoryTransactionsViewModel);

    protected FragmentServiceCategoryTransactionsBinding(Object obj, View view, int i, ImageView imageView, TextView textView, RecyclerView recyclerView, TextView textView2) {
        super(obj, view, i);
        this.categoryImage = imageView;
        this.categoryName = textView;
        this.categoryTransactionList = recyclerView;
        this.groupName = textView2;
    }

    public ServiceCategoryTransactionsViewModel getVm() {
        return this.mVm;
    }

    public static FragmentServiceCategoryTransactionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceCategoryTransactionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentServiceCategoryTransactionsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_service_category_transactions, viewGroup, z, obj);
    }

    public static FragmentServiceCategoryTransactionsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceCategoryTransactionsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentServiceCategoryTransactionsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_service_category_transactions, null, false, obj);
    }

    public static FragmentServiceCategoryTransactionsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceCategoryTransactionsBinding bind(View view, Object obj) {
        return (FragmentServiceCategoryTransactionsBinding) bind(obj, view, R.layout.fragment_service_category_transactions);
    }
}
