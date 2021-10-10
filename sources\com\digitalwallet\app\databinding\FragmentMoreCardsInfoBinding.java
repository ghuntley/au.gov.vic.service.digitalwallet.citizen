package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.holdings.MoreCardsInfoViewModel;

public abstract class FragmentMoreCardsInfoBinding extends ViewDataBinding {
    @Bindable
    protected MoreCardsInfoViewModel mVm;

    public abstract void setVm(MoreCardsInfoViewModel moreCardsInfoViewModel);

    protected FragmentMoreCardsInfoBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public MoreCardsInfoViewModel getVm() {
        return this.mVm;
    }

    public static FragmentMoreCardsInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMoreCardsInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentMoreCardsInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_more_cards_info, viewGroup, z, obj);
    }

    public static FragmentMoreCardsInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMoreCardsInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentMoreCardsInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_more_cards_info, null, false, obj);
    }

    public static FragmentMoreCardsInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMoreCardsInfoBinding bind(View view, Object obj) {
        return (FragmentMoreCardsInfoBinding) bind(obj, view, R.layout.fragment_more_cards_info);
    }
}
