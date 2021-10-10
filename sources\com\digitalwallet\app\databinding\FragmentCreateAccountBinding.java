package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.login.CreateAccountViewModel;
import com.google.android.material.textfield.TextInputEditText;

public abstract class FragmentCreateAccountBinding extends ViewDataBinding {
    public final ImageView backButton;
    public final TextInputEditText emailEditText;
    public final LinearLayout loginButton;
    @Bindable
    protected CreateAccountViewModel mVm;
    public final ConstraintLayout titleBar;

    public abstract void setVm(CreateAccountViewModel createAccountViewModel);

    protected FragmentCreateAccountBinding(Object obj, View view, int i, ImageView imageView, TextInputEditText textInputEditText, LinearLayout linearLayout, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.backButton = imageView;
        this.emailEditText = textInputEditText;
        this.loginButton = linearLayout;
        this.titleBar = constraintLayout;
    }

    public CreateAccountViewModel getVm() {
        return this.mVm;
    }

    public static FragmentCreateAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCreateAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCreateAccountBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_create_account, viewGroup, z, obj);
    }

    public static FragmentCreateAccountBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCreateAccountBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCreateAccountBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_create_account, null, false, obj);
    }

    public static FragmentCreateAccountBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCreateAccountBinding bind(View view, Object obj) {
        return (FragmentCreateAccountBinding) bind(obj, view, R.layout.fragment_create_account);
    }
}
