package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.view.util.AlertFragment;

public abstract class AlertBinding extends ViewDataBinding {
    public final Button action1;
    public final Button action2;
    public final GridLayout actionLayout;
    public final TextView detailedMessage;
    public final Button dismiss;
    public final ImageView image;
    @Bindable
    protected AlertFragment mVm;
    public final TextView message;
    public final TextView title;

    public abstract void setVm(AlertFragment alertFragment);

    protected AlertBinding(Object obj, View view, int i, Button button, Button button2, GridLayout gridLayout, TextView textView, Button button3, ImageView imageView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.action1 = button;
        this.action2 = button2;
        this.actionLayout = gridLayout;
        this.detailedMessage = textView;
        this.dismiss = button3;
        this.image = imageView;
        this.message = textView2;
        this.title = textView3;
    }

    public AlertFragment getVm() {
        return this.mVm;
    }

    public static AlertBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlertBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AlertBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.alert, viewGroup, z, obj);
    }

    public static AlertBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlertBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AlertBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.alert, null, false, obj);
    }

    public static AlertBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlertBinding bind(View view, Object obj) {
        return (AlertBinding) bind(obj, view, R.layout.alert);
    }
}
