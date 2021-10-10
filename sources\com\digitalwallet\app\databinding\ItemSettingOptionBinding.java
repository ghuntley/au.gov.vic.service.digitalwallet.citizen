package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.SettingOptionItem;

public abstract class ItemSettingOptionBinding extends ViewDataBinding {
    @Bindable
    protected SettingOptionItem mVm;
    public final TextView name;

    public abstract void setVm(SettingOptionItem settingOptionItem);

    protected ItemSettingOptionBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.name = textView;
    }

    public SettingOptionItem getVm() {
        return this.mVm;
    }

    public static ItemSettingOptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSettingOptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSettingOptionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_setting_option, viewGroup, z, obj);
    }

    public static ItemSettingOptionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSettingOptionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSettingOptionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_setting_option, null, false, obj);
    }

    public static ItemSettingOptionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSettingOptionBinding bind(View view, Object obj) {
        return (ItemSettingOptionBinding) bind(obj, view, R.layout.item_setting_option);
    }
}
