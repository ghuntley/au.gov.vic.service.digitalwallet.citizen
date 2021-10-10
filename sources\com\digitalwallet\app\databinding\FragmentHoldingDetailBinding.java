package com.digitalwallet.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.viewmodel.main.HoldingDetailFragmentViewModel;

public abstract class FragmentHoldingDetailBinding extends ViewDataBinding {
    public final ImageView alertImageView;
    public final CardBinding cardLayout;
    public final ImageButton closeButton;
    public final TextView comingSoonText;
    public final ConstraintLayout comingSoonTextContainer;
    public final ScrollView contentScrollView;
    public final TextView daysToExpire;
    public final ImageButton disclaimerButton;
    public final ConstraintLayout expiryLayout;
    public final ImageButton flipCardButton;
    public final RelativeLayout holdingDetailAttributeView;
    public final ConstraintLayout holdingDetailConstraintLayout;
    public final FrameLayout holdingDetailLayoutView;
    public final RecyclerView holdingDetailRecyclerView;
    @Bindable
    protected HoldingDetailFragmentViewModel mVm;
    public final ImageView noticeImageView;
    public final FrameLayout notificationBannerView;
    public final ImageButton rotateHoldingButton;
    public final TextView rotateMessage;

    public abstract void setVm(HoldingDetailFragmentViewModel holdingDetailFragmentViewModel);

    protected FragmentHoldingDetailBinding(Object obj, View view, int i, ImageView imageView, CardBinding cardBinding, ImageButton imageButton, TextView textView, ConstraintLayout constraintLayout, ScrollView scrollView, TextView textView2, ImageButton imageButton2, ConstraintLayout constraintLayout2, ImageButton imageButton3, RelativeLayout relativeLayout, ConstraintLayout constraintLayout3, FrameLayout frameLayout, RecyclerView recyclerView, ImageView imageView2, FrameLayout frameLayout2, ImageButton imageButton4, TextView textView3) {
        super(obj, view, i);
        this.alertImageView = imageView;
        this.cardLayout = cardBinding;
        this.closeButton = imageButton;
        this.comingSoonText = textView;
        this.comingSoonTextContainer = constraintLayout;
        this.contentScrollView = scrollView;
        this.daysToExpire = textView2;
        this.disclaimerButton = imageButton2;
        this.expiryLayout = constraintLayout2;
        this.flipCardButton = imageButton3;
        this.holdingDetailAttributeView = relativeLayout;
        this.holdingDetailConstraintLayout = constraintLayout3;
        this.holdingDetailLayoutView = frameLayout;
        this.holdingDetailRecyclerView = recyclerView;
        this.noticeImageView = imageView2;
        this.notificationBannerView = frameLayout2;
        this.rotateHoldingButton = imageButton4;
        this.rotateMessage = textView3;
    }

    public HoldingDetailFragmentViewModel getVm() {
        return this.mVm;
    }

    public static FragmentHoldingDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHoldingDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentHoldingDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_holding_detail, viewGroup, z, obj);
    }

    public static FragmentHoldingDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHoldingDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentHoldingDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_holding_detail, null, false, obj);
    }

    public static FragmentHoldingDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHoldingDetailBinding bind(View view, Object obj) {
        return (FragmentHoldingDetailBinding) bind(obj, view, R.layout.fragment_holding_detail);
    }
}
