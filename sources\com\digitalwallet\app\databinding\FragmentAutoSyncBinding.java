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
import com.digitalwallet.app.viewmodel.main.addsync.AutoSyncViewModel;

public abstract class FragmentAutoSyncBinding extends ViewDataBinding {
    public final TextView autoSyncTitle;
    public final Button btnPrimary;
    public final Button btnSecondary;
    @Bindable
    protected AutoSyncViewModel mVm;

    public abstract void setVm(AutoSyncViewModel autoSyncViewModel);

    protected FragmentAutoSyncBinding(Object obj, View view, int i, TextView textView, Button button, Button button2) {
        super(obj, view, i);
        this.autoSyncTitle = textView;
        this.btnPrimary = button;
        this.btnSecondary = button2;
    }

    public AutoSyncViewModel getVm() {
        return this.mVm;
    }

    public static FragmentAutoSyncBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAutoSyncBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentAutoSyncBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_auto_sync, viewGroup, z, obj);
    }

    public static FragmentAutoSyncBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAutoSyncBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentAutoSyncBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_auto_sync, null, false, obj);
    }

    public static FragmentAutoSyncBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAutoSyncBinding bind(View view, Object obj) {
        return (FragmentAutoSyncBinding) bind(obj, view, R.layout.fragment_auto_sync);
    }
}
