package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.pin.PinActivityViewModel;
import com.mukesh.OtpView;

public abstract class PinBinding extends ViewDataBinding {
    @Bindable
    protected PinActivityViewModel mVm;
    public final Button nextButton;
    public final TextView pinError;
    public final TextView pinHeader;
    public final TextView pinSubHeader;
    public final OtpView pinText;

    public abstract void setVm(PinActivityViewModel pinActivityViewModel);

    protected PinBinding(Object obj, View view, int i, Button button, TextView textView, TextView textView2, TextView textView3, OtpView otpView) {
        super(obj, view, i);
        this.nextButton = button;
        this.pinError = textView;
        this.pinHeader = textView2;
        this.pinSubHeader = textView3;
        this.pinText = otpView;
    }

    public PinActivityViewModel getVm() {
        return this.mVm;
    }

    public static PinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pin, viewGroup, z, obj);
    }

    public static PinBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PinBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pin, null, false, obj);
    }

    public static PinBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PinBinding bind(View view, Object obj) {
        return (PinBinding) bind(obj, view, R.layout.pin);
    }
}
