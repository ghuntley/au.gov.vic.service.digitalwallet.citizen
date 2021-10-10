package com.digitalwallet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class LayoutCheckInPrivacyBinding extends ViewDataBinding {
    public final TextView checkInPrivacy;
    public final TextView dataDesc;

    protected LayoutCheckInPrivacyBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.checkInPrivacy = textView;
        this.dataDesc = textView2;
    }

    public static LayoutCheckInPrivacyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckInPrivacyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutCheckInPrivacyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_check_in_privacy, viewGroup, z, obj);
    }

    public static LayoutCheckInPrivacyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckInPrivacyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutCheckInPrivacyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_check_in_privacy, null, false, obj);
    }

    public static LayoutCheckInPrivacyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCheckInPrivacyBinding bind(View view, Object obj) {
        return (LayoutCheckInPrivacyBinding) bind(obj, view, R.layout.layout_check_in_privacy);
    }
}
