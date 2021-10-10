package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.HoldingRecordAttributes;

public abstract class CardKangarooHarvesterFrontBinding extends ViewDataBinding {
    @Bindable
    protected HoldingRecordAttributes mVm;
    public final TextView number;
    public final LinearLayout solarContent;
    public final ConstraintLayout solarHeader;

    public abstract void setVm(HoldingRecordAttributes holdingRecordAttributes);

    protected CardKangarooHarvesterFrontBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.number = textView;
        this.solarContent = linearLayout;
        this.solarHeader = constraintLayout;
    }

    public HoldingRecordAttributes getVm() {
        return this.mVm;
    }

    public static CardKangarooHarvesterFrontBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardKangarooHarvesterFrontBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardKangarooHarvesterFrontBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_kangaroo_harvester_front, viewGroup, z, obj);
    }

    public static CardKangarooHarvesterFrontBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardKangarooHarvesterFrontBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardKangarooHarvesterFrontBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_kangaroo_harvester_front, null, false, obj);
    }

    public static CardKangarooHarvesterFrontBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardKangarooHarvesterFrontBinding bind(View view, Object obj) {
        return (CardKangarooHarvesterFrontBinding) bind(obj, view, R.layout.card_kangaroo_harvester_front);
    }
}
