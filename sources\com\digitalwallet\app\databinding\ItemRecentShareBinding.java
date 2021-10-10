package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.db.shares.ShareRecord;

public abstract class ItemRecentShareBinding extends ViewDataBinding {
    public final ImageView avatar;
    public final TextView holdingTitle;
    @Bindable
    protected ShareRecord mVm;
    public final LinearLayout textContent;

    public abstract void setVm(ShareRecord shareRecord);

    protected ItemRecentShareBinding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.avatar = imageView;
        this.holdingTitle = textView;
        this.textContent = linearLayout;
    }

    public ShareRecord getVm() {
        return this.mVm;
    }

    public static ItemRecentShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRecentShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRecentShareBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_recent_share, viewGroup, z, obj);
    }

    public static ItemRecentShareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRecentShareBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRecentShareBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_recent_share, null, false, obj);
    }

    public static ItemRecentShareBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRecentShareBinding bind(View view, Object obj) {
        return (ItemRecentShareBinding) bind(obj, view, R.layout.item_recent_share);
    }
}
