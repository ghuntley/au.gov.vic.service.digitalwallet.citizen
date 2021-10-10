package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.HoldingAssets;
import com.digitalwallet.app.model.HoldingRecordAttributes;

public abstract class CardWwcCheckFrontBinding extends ViewDataBinding {
    public final View header;
    public final ImageView identificationPhoto;
    public final LinearLayout licenceNumber;
    @Bindable
    protected HoldingAssets mAssets;
    @Bindable
    protected HoldingRecordAttributes mVm;

    public abstract void setAssets(HoldingAssets holdingAssets);

    public abstract void setVm(HoldingRecordAttributes holdingRecordAttributes);

    protected CardWwcCheckFrontBinding(Object obj, View view, int i, View view2, ImageView imageView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.header = view2;
        this.identificationPhoto = imageView;
        this.licenceNumber = linearLayout;
    }

    public HoldingRecordAttributes getVm() {
        return this.mVm;
    }

    public HoldingAssets getAssets() {
        return this.mAssets;
    }

    public static CardWwcCheckFrontBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardWwcCheckFrontBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardWwcCheckFrontBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_wwc_check_front, viewGroup, z, obj);
    }

    public static CardWwcCheckFrontBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardWwcCheckFrontBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardWwcCheckFrontBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_wwc_check_front, null, false, obj);
    }

    public static CardWwcCheckFrontBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardWwcCheckFrontBinding bind(View view, Object obj) {
        return (CardWwcCheckFrontBinding) bind(obj, view, R.layout.card_wwc_check_front);
    }
}
