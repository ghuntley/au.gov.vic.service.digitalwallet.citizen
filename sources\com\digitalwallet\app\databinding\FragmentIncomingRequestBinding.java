package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.sharing.IncomingRequestFragmentViewModel;

public abstract class FragmentIncomingRequestBinding extends ViewDataBinding {
    public final FrameLayout authorityInfoContainer;
    @Bindable
    protected IncomingRequestFragmentViewModel mVm;

    public abstract void setVm(IncomingRequestFragmentViewModel incomingRequestFragmentViewModel);

    protected FragmentIncomingRequestBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.authorityInfoContainer = frameLayout;
    }

    public IncomingRequestFragmentViewModel getVm() {
        return this.mVm;
    }

    public static FragmentIncomingRequestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentIncomingRequestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentIncomingRequestBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_incoming_request, viewGroup, z, obj);
    }

    public static FragmentIncomingRequestBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentIncomingRequestBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentIncomingRequestBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_incoming_request, null, false, obj);
    }

    public static FragmentIncomingRequestBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentIncomingRequestBinding bind(View view, Object obj) {
        return (FragmentIncomingRequestBinding) bind(obj, view, R.layout.fragment_incoming_request);
    }
}
