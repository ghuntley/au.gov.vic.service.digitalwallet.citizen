package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.ServiceTypeItem;

public abstract class ServiceTypeCardBinding extends ViewDataBinding {
    public final CardView cardView;
    @Bindable
    protected ServiceTypeItem mVm;
    public final ImageView serviceTypeImageView;
    public final TextView serviceTypeNameTextView;

    public abstract void setVm(ServiceTypeItem serviceTypeItem);

    protected ServiceTypeCardBinding(Object obj, View view, int i, CardView cardView2, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.serviceTypeImageView = imageView;
        this.serviceTypeNameTextView = textView;
    }

    public ServiceTypeItem getVm() {
        return this.mVm;
    }

    public static ServiceTypeCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ServiceTypeCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ServiceTypeCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.service_type_card, viewGroup, z, obj);
    }

    public static ServiceTypeCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ServiceTypeCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ServiceTypeCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.service_type_card, null, false, obj);
    }

    public static ServiceTypeCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ServiceTypeCardBinding bind(View view, Object obj) {
        return (ServiceTypeCardBinding) bind(obj, view, R.layout.service_type_card);
    }
}
