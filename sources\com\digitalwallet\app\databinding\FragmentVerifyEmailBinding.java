package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.login.VerifyEmailViewModel;
import com.mukesh.OtpView;

public abstract class FragmentVerifyEmailBinding extends ViewDataBinding {
    public final TextView checkEmailDescription;
    @Bindable
    protected VerifyEmailViewModel mVm;
    public final OtpView otpView;
    public final LayoutTitleBarBinding titleBar;

    public abstract void setVm(VerifyEmailViewModel verifyEmailViewModel);

    protected FragmentVerifyEmailBinding(Object obj, View view, int i, TextView textView, OtpView otpView2, LayoutTitleBarBinding layoutTitleBarBinding) {
        super(obj, view, i);
        this.checkEmailDescription = textView;
        this.otpView = otpView2;
        this.titleBar = layoutTitleBarBinding;
    }

    public VerifyEmailViewModel getVm() {
        return this.mVm;
    }

    public static FragmentVerifyEmailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentVerifyEmailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentVerifyEmailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_verify_email, viewGroup, z, obj);
    }

    public static FragmentVerifyEmailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentVerifyEmailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentVerifyEmailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_verify_email, null, false, obj);
    }

    public static FragmentVerifyEmailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentVerifyEmailBinding bind(View view, Object obj) {
        return (FragmentVerifyEmailBinding) bind(obj, view, R.layout.fragment_verify_email);
    }
}
