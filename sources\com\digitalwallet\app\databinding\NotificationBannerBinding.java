package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.NotificationBannerViewModel;

public abstract class NotificationBannerBinding extends ViewDataBinding {
    public final ImageView alertImageView;
    @Bindable
    protected NotificationBannerViewModel mVm;
    public final ConstraintLayout notificationBaseView;
    public final Button notificationButton;
    public final TextView notificationText;
    public final ConstraintLayout notificationView;

    public abstract void setVm(NotificationBannerViewModel notificationBannerViewModel);

    protected NotificationBannerBinding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, Button button, TextView textView, ConstraintLayout constraintLayout2) {
        super(obj, view, i);
        this.alertImageView = imageView;
        this.notificationBaseView = constraintLayout;
        this.notificationButton = button;
        this.notificationText = textView;
        this.notificationView = constraintLayout2;
    }

    public NotificationBannerViewModel getVm() {
        return this.mVm;
    }

    public static NotificationBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NotificationBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NotificationBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.notification_banner, viewGroup, z, obj);
    }

    public static NotificationBannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NotificationBannerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NotificationBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.notification_banner, null, false, obj);
    }

    public static NotificationBannerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NotificationBannerBinding bind(View view, Object obj) {
        return (NotificationBannerBinding) bind(obj, view, R.layout.notification_banner);
    }
}
