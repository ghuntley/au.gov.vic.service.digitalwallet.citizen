package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.NicknameViewModel;
import com.google.android.material.textfield.TextInputEditText;

public abstract class NicknameEditBinding extends ViewDataBinding {
    public final LinearLayout header;
    @Bindable
    protected NicknameViewModel mVm;
    public final TextInputEditText nickname;
    public final Button save;

    public abstract void setVm(NicknameViewModel nicknameViewModel);

    protected NicknameEditBinding(Object obj, View view, int i, LinearLayout linearLayout, TextInputEditText textInputEditText, Button button) {
        super(obj, view, i);
        this.header = linearLayout;
        this.nickname = textInputEditText;
        this.save = button;
    }

    public NicknameViewModel getVm() {
        return this.mVm;
    }

    public static NicknameEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NicknameEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NicknameEditBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nickname_edit, viewGroup, z, obj);
    }

    public static NicknameEditBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NicknameEditBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NicknameEditBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nickname_edit, null, false, obj);
    }

    public static NicknameEditBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NicknameEditBinding bind(View view, Object obj) {
        return (NicknameEditBinding) bind(obj, view, R.layout.nickname_edit);
    }
}
