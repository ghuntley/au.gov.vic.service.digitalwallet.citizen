package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.addsync.CardAddViewModel;

public abstract class FragmentCardAddBinding extends ViewDataBinding {
    public final ImageView fishingCard;
    @Bindable
    protected CardAddViewModel mVm;
    public final ImageView nextButton;
    public final ImageView syncCard;

    public abstract void setVm(CardAddViewModel cardAddViewModel);

    protected FragmentCardAddBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        super(obj, view, i);
        this.fishingCard = imageView;
        this.nextButton = imageView2;
        this.syncCard = imageView3;
    }

    public CardAddViewModel getVm() {
        return this.mVm;
    }

    public static FragmentCardAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCardAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCardAddBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_card_add, viewGroup, z, obj);
    }

    public static FragmentCardAddBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCardAddBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCardAddBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_card_add, null, false, obj);
    }

    public static FragmentCardAddBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCardAddBinding bind(View view, Object obj) {
        return (FragmentCardAddBinding) bind(obj, view, R.layout.fragment_card_add);
    }
}
