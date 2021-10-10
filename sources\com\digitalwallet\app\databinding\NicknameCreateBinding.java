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
import com.digitalwallet.app.viewmodel.main.NicknameViewModel;
import com.google.android.material.textfield.TextInputEditText;

public abstract class NicknameCreateBinding extends ViewDataBinding {
    public final LinearLayout header;
    public final ImageView imageView;
    @Bindable
    protected NicknameViewModel mVm;
    public final TextInputEditText nickname;
    public final Button save;
    public final TextView vLoginPrivacy;

    public abstract void setVm(NicknameViewModel nicknameViewModel);

    protected NicknameCreateBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView2, TextInputEditText textInputEditText, Button button, TextView textView) {
        super(obj, view, i);
        this.header = linearLayout;
        this.imageView = imageView2;
        this.nickname = textInputEditText;
        this.save = button;
        this.vLoginPrivacy = textView;
    }

    public NicknameViewModel getVm() {
        return this.mVm;
    }

    public static NicknameCreateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NicknameCreateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NicknameCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nickname_create, viewGroup, z, obj);
    }

    public static NicknameCreateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NicknameCreateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NicknameCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nickname_create, null, false, obj);
    }

    public static NicknameCreateBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NicknameCreateBinding bind(View view, Object obj) {
        return (NicknameCreateBinding) bind(obj, view, R.layout.nickname_create);
    }
}
