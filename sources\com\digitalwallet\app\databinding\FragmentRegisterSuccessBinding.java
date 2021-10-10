package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.login.RegisterSuccessViewModel;

public abstract class FragmentRegisterSuccessBinding extends ViewDataBinding {
    public final Button createPasscodeButton;
    public final TextView instructionsText;
    @Bindable
    protected RegisterSuccessViewModel mVm;
    public final ImageView successIcon;
    public final TextView thankYouText;

    public abstract void setVm(RegisterSuccessViewModel registerSuccessViewModel);

    protected FragmentRegisterSuccessBinding(Object obj, View view, int i, Button button, TextView textView, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.createPasscodeButton = button;
        this.instructionsText = textView;
        this.successIcon = imageView;
        this.thankYouText = textView2;
    }

    public RegisterSuccessViewModel getVm() {
        return this.mVm;
    }

    public static FragmentRegisterSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRegisterSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentRegisterSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_register_success, viewGroup, z, obj);
    }

    public static FragmentRegisterSuccessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRegisterSuccessBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentRegisterSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_register_success, null, false, obj);
    }

    public static FragmentRegisterSuccessBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRegisterSuccessBinding bind(View view, Object obj) {
        return (FragmentRegisterSuccessBinding) bind(obj, view, R.layout.fragment_register_success);
    }
}
