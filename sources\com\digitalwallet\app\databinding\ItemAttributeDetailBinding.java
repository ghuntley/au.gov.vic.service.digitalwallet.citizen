package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.AttributeDetailItem;

public abstract class ItemAttributeDetailBinding extends ViewDataBinding {
    public final TextView fieldName;
    public final TextView fieldValue;
    @Bindable
    protected AttributeDetailItem mVm;

    public abstract void setVm(AttributeDetailItem attributeDetailItem);

    protected ItemAttributeDetailBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.fieldName = textView;
        this.fieldValue = textView2;
    }

    public AttributeDetailItem getVm() {
        return this.mVm;
    }

    public static ItemAttributeDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAttributeDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAttributeDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_attribute_detail, viewGroup, z, obj);
    }

    public static ItemAttributeDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAttributeDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAttributeDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_attribute_detail, null, false, obj);
    }

    public static ItemAttributeDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAttributeDetailBinding bind(View view, Object obj) {
        return (ItemAttributeDetailBinding) bind(obj, view, R.layout.item_attribute_detail);
    }
}
