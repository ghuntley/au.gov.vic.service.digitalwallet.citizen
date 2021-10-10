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
import com.digitalwallet.app.viewmodel.main.ServiceDetailItem;

public abstract class ServiceDetailRowBinding extends ViewDataBinding {
    @Bindable
    protected ServiceDetailItem mVm;
    public final TextView serviceDetailDescTextView;
    public final ImageView serviceDetailImageView;
    public final TextView serviceDetailNameTextView;

    public abstract void setVm(ServiceDetailItem serviceDetailItem);

    protected ServiceDetailRowBinding(Object obj, View view, int i, TextView textView, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.serviceDetailDescTextView = textView;
        this.serviceDetailImageView = imageView;
        this.serviceDetailNameTextView = textView2;
    }

    public ServiceDetailItem getVm() {
        return this.mVm;
    }

    public static ServiceDetailRowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ServiceDetailRowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ServiceDetailRowBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.service_detail_row, viewGroup, z, obj);
    }

    public static ServiceDetailRowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ServiceDetailRowBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ServiceDetailRowBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.service_detail_row, null, false, obj);
    }

    public static ServiceDetailRowBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ServiceDetailRowBinding bind(View view, Object obj) {
        return (ServiceDetailRowBinding) bind(obj, view, R.layout.service_detail_row);
    }
}
