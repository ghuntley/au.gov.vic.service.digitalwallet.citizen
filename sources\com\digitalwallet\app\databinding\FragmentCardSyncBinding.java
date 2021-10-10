package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel;
import com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewState;

public abstract class FragmentCardSyncBinding extends ViewDataBinding {
    public final Button btnPrimary;
    public final Button btnSecondary;
    public final TextView cancelButton;
    public final RecyclerView cardRecyclerView;
    public final ConstraintLayout footer;
    public final TextView header;
    @Bindable
    protected CardSyncViewState mViewState;
    @Bindable
    protected CardSyncViewModel mVm;
    public final ConstraintLayout titleBar;

    public abstract void setViewState(CardSyncViewState cardSyncViewState);

    public abstract void setVm(CardSyncViewModel cardSyncViewModel);

    protected FragmentCardSyncBinding(Object obj, View view, int i, Button button, Button button2, TextView textView, RecyclerView recyclerView, ConstraintLayout constraintLayout, TextView textView2, ConstraintLayout constraintLayout2) {
        super(obj, view, i);
        this.btnPrimary = button;
        this.btnSecondary = button2;
        this.cancelButton = textView;
        this.cardRecyclerView = recyclerView;
        this.footer = constraintLayout;
        this.header = textView2;
        this.titleBar = constraintLayout2;
    }

    public CardSyncViewModel getVm() {
        return this.mVm;
    }

    public CardSyncViewState getViewState() {
        return this.mViewState;
    }

    public static FragmentCardSyncBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCardSyncBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCardSyncBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_card_sync, viewGroup, z, obj);
    }

    public static FragmentCardSyncBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCardSyncBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCardSyncBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_card_sync, null, false, obj);
    }

    public static FragmentCardSyncBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCardSyncBinding bind(View view, Object obj) {
        return (FragmentCardSyncBinding) bind(obj, view, R.layout.fragment_card_sync);
    }
}
