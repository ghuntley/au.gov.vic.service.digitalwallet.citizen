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

public abstract class CardWorksafeLicenceFrontBinding extends ViewDataBinding {
    public final LinearLayout header;
    public final ImageView identificationPhoto;
    @Bindable
    protected HoldingAssets mAssets;
    @Bindable
    protected HoldingRecordAttributes mVm;
    public final LinearLayout rightDetails;

    public abstract void setAssets(HoldingAssets holdingAssets);

    public abstract void setVm(HoldingRecordAttributes holdingRecordAttributes);

    protected CardWorksafeLicenceFrontBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.header = linearLayout;
        this.identificationPhoto = imageView;
        this.rightDetails = linearLayout2;
    }

    public HoldingRecordAttributes getVm() {
        return this.mVm;
    }

    public HoldingAssets getAssets() {
        return this.mAssets;
    }

    public static CardWorksafeLicenceFrontBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardWorksafeLicenceFrontBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardWorksafeLicenceFrontBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_worksafe_licence_front, viewGroup, z, obj);
    }

    public static CardWorksafeLicenceFrontBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardWorksafeLicenceFrontBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardWorksafeLicenceFrontBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_worksafe_licence_front, null, false, obj);
    }

    public static CardWorksafeLicenceFrontBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardWorksafeLicenceFrontBinding bind(View view, Object obj) {
        return (CardWorksafeLicenceFrontBinding) bind(obj, view, R.layout.card_worksafe_licence_front);
    }
}
