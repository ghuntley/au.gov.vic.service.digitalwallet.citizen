package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.view.hologram.HologramView;
import com.digitalwallet.app.view.main.CardSwipeViewGroup;

public abstract class CardBinding extends ViewDataBinding {
    public final FrameLayout backCardContainer;
    public final FrameLayout cardContainer;
    public final CardSwipeViewGroup cardFrame;
    public final CardView cardView;
    public final HologramView serviceVicHoloView;

    protected CardBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, CardSwipeViewGroup cardSwipeViewGroup, CardView cardView2, HologramView hologramView) {
        super(obj, view, i);
        this.backCardContainer = frameLayout;
        this.cardContainer = frameLayout2;
        this.cardFrame = cardSwipeViewGroup;
        this.cardView = cardView2;
        this.serviceVicHoloView = hologramView;
    }

    public static CardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card, viewGroup, z, obj);
    }

    public static CardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card, null, false, obj);
    }

    public static CardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardBinding bind(View view, Object obj) {
        return (CardBinding) bind(obj, view, R.layout.card);
    }
}
