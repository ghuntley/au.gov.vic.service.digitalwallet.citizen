package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.history.SharingHistoryFragmentViewModel;

public abstract class FragmentSharingHistoryBinding extends ViewDataBinding {
    public final View headerDivider;
    @Bindable
    protected SharingHistoryFragmentViewModel mVm;
    public final RecyclerView sharesRecyclerView;
    public final TextView sharingActivityText;
    public final ImageView sharingCaret;
    public final ConstraintLayout sharingHeader;

    public abstract void setVm(SharingHistoryFragmentViewModel sharingHistoryFragmentViewModel);

    protected FragmentSharingHistoryBinding(Object obj, View view, int i, View view2, RecyclerView recyclerView, TextView textView, ImageView imageView, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.headerDivider = view2;
        this.sharesRecyclerView = recyclerView;
        this.sharingActivityText = textView;
        this.sharingCaret = imageView;
        this.sharingHeader = constraintLayout;
    }

    public SharingHistoryFragmentViewModel getVm() {
        return this.mVm;
    }

    public static FragmentSharingHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSharingHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSharingHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_sharing_history, viewGroup, z, obj);
    }

    public static FragmentSharingHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSharingHistoryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSharingHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_sharing_history, null, false, obj);
    }

    public static FragmentSharingHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSharingHistoryBinding bind(View view, Object obj) {
        return (FragmentSharingHistoryBinding) bind(obj, view, R.layout.fragment_sharing_history);
    }
}
