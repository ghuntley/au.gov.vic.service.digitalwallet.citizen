package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.pin.FingerprintDialogFragmentViewModel;

public abstract class LoginFingerprintDialogBinding extends ViewDataBinding {
    public final LinearLayout buttons;
    public final Button cancelButton;
    public final TextView errorTextView;
    public final ImageView fingerprintImageView;
    @Bindable
    protected FingerprintDialogFragmentViewModel mVm;
    public final TextView subtitleTextView;
    public final TextView titleTextView;

    public abstract void setVm(FingerprintDialogFragmentViewModel fingerprintDialogFragmentViewModel);

    protected LoginFingerprintDialogBinding(Object obj, View view, int i, LinearLayout linearLayout, Button button, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.buttons = linearLayout;
        this.cancelButton = button;
        this.errorTextView = textView;
        this.fingerprintImageView = imageView;
        this.subtitleTextView = textView2;
        this.titleTextView = textView3;
    }

    public FingerprintDialogFragmentViewModel getVm() {
        return this.mVm;
    }

    public static LoginFingerprintDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginFingerprintDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LoginFingerprintDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_fingerprint_dialog, viewGroup, z, obj);
    }

    public static LoginFingerprintDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginFingerprintDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LoginFingerprintDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_fingerprint_dialog, null, false, obj);
    }

    public static LoginFingerprintDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginFingerprintDialogBinding bind(View view, Object obj) {
        return (LoginFingerprintDialogBinding) bind(obj, view, R.layout.login_fingerprint_dialog);
    }
}
