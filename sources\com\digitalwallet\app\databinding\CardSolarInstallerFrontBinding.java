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

public abstract class CardSolarInstallerFrontBinding extends ViewDataBinding {
    public final TextView accreditationTitle;
    public final TextView expires;
    public final TextView holderName;
    public final LinearLayout leftDetails;
    public final TextView licenceNumberTitle;
    @Bindable
    protected HoldingRecordAttributes mVm;
    public final LinearLayout rightDetails;
    public final LinearLayout solarContent;
    public final ConstraintLayout solarHeader;
    public final TextView status;

    public abstract void setVm(HoldingRecordAttributes holdingRecordAttributes);

    protected CardSolarInstallerFrontBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, TextView textView4, LinearLayout linearLayout2, LinearLayout linearLayout3, ConstraintLayout constraintLayout, TextView textView5) {
        super(obj, view, i);
        this.accreditationTitle = textView;
        this.expires = textView2;
        this.holderName = textView3;
        this.leftDetails = linearLayout;
        this.licenceNumberTitle = textView4;
        this.rightDetails = linearLayout2;
        this.solarContent = linearLayout3;
        this.solarHeader = constraintLayout;
        this.status = textView5;
    }

    public HoldingRecordAttributes getVm() {
        return this.mVm;
    }

    public static CardSolarInstallerFrontBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardSolarInstallerFrontBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CardSolarInstallerFrontBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_solar_installer_front, viewGroup, z, obj);
    }

    public static CardSolarInstallerFrontBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardSolarInstallerFrontBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CardSolarInstallerFrontBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.card_solar_installer_front, null, false, obj);
    }

    public static CardSolarInstallerFrontBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CardSolarInstallerFrontBinding bind(View view, Object obj) {
        return (CardSolarInstallerFrontBinding) bind(obj, view, R.layout.card_solar_installer_front);
    }
}
