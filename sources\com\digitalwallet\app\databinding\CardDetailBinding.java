package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.addsync.CardDetailItem;

public abstract class CardDetailBinding extends ViewDataBinding {
    public final CheckBox cardCheckBox;
    public final ImageView cardIcon;
    public final TextView expiryText;
    public final TextView licenceName;
    @Bindable
    protected CardDetailItem mVm;

    public abstract void setVm(CardDetailItem cardDetailItem);

    protected CardDetailBinding(Object obj, View view, int i, CheckBox checkBox, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.cardCheckBox = checkBox;
        this.cardIcon = imageView;
        this.expiryText = textView;
        this.licenceName = textView2;
    }

    public CardDetailItem getVm() {
        return this.mVm;
    }

    public static CardDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_detail, viewGroup, z, obj);
    }

    public static CardDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_detail, null, false, obj);
    }

    public static CardDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardDetailBinding bind(View view, Object obj) {
        return (CardDetailBinding) bind(obj, view, R.layout.card_detail);
    }
}
