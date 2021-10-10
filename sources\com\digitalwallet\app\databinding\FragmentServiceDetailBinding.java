package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.ServiceDetailFragmentViewModel;

public abstract class FragmentServiceDetailBinding extends ViewDataBinding {
    public final ImageButton backBtn;
    @Bindable
    protected ServiceDetailFragmentViewModel mVm;
    public final RecyclerView serviceDetailRecyclerView;
    public final ImageView serviceTypeImageView;
    public final TextView serviceTypeName;

    public abstract void setVm(ServiceDetailFragmentViewModel serviceDetailFragmentViewModel);

    protected FragmentServiceDetailBinding(Object obj, View view, int i, ImageButton imageButton, RecyclerView recyclerView, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.backBtn = imageButton;
        this.serviceDetailRecyclerView = recyclerView;
        this.serviceTypeImageView = imageView;
        this.serviceTypeName = textView;
    }

    public ServiceDetailFragmentViewModel getVm() {
        return this.mVm;
    }

    public static FragmentServiceDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentServiceDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_service_detail, viewGroup, z, obj);
    }

    public static FragmentServiceDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentServiceDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_service_detail, null, false, obj);
    }

    public static FragmentServiceDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServiceDetailBinding bind(View view, Object obj) {
        return (FragmentServiceDetailBinding) bind(obj, view, R.layout.fragment_service_detail);
    }
}
