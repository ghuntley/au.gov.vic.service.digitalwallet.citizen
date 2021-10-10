package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;

public abstract class LoginHelloBinding extends ViewDataBinding {
    public final FrameLayout fragmentContainer;

    protected LoginHelloBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.fragmentContainer = frameLayout;
    }

    public static LoginHelloBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginHelloBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LoginHelloBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_hello, viewGroup, z, obj);
    }

    public static LoginHelloBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginHelloBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LoginHelloBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_hello, null, false, obj);
    }

    public static LoginHelloBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginHelloBinding bind(View view, Object obj) {
        return (LoginHelloBinding) bind(obj, view, R.layout.login_hello);
    }
}
