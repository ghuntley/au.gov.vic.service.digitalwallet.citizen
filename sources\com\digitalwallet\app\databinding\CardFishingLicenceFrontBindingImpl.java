package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.model.HoldingAddress;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import java.util.List;

public class CardFishingLicenceFrontBindingImpl extends CardFishingLicenceFrontBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView6;
    private final TextView mboundView7;
    private final TextView mboundView8;
    private final TextView mboundView9;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bottom_content, 10);
    }

    public CardFishingLicenceFrontBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private CardFishingLicenceFrontBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[10]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.mboundView2 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.mboundView3 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[4];
        this.mboundView4 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[5];
        this.mboundView5 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[6];
        this.mboundView6 = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[7];
        this.mboundView7 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[8];
        this.mboundView8 = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[9];
        this.mboundView9 = textView9;
        textView9.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (8257543 != i) {
            return false;
        }
        setVm((HoldingRecordAttributes) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.CardFishingLicenceFrontBinding
    public void setVm(HoldingRecordAttributes holdingRecordAttributes) {
        this.mVm = holdingRecordAttributes;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        List<HoldingAddress> list;
        String str10;
        String str11;
        String str12;
        String str13;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HoldingRecordAttributes holdingRecordAttributes = this.mVm;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        String str14 = null;
        if (i != 0) {
            if (holdingRecordAttributes != null) {
                str10 = holdingRecordAttributes.getStartDateFormatted();
                str7 = holdingRecordAttributes.getDobFormatted();
                str5 = holdingRecordAttributes.getLicenceKind();
                list = holdingRecordAttributes.getAddresses();
                str3 = holdingRecordAttributes.getExpiryDateFormatted();
                str9 = holdingRecordAttributes.getFullName();
                str6 = holdingRecordAttributes.getIdentifier();
            } else {
                str10 = null;
                str7 = null;
                str6 = null;
                str5 = null;
                list = null;
                str3 = null;
                str9 = null;
            }
            HoldingAddress holdingAddress = list != null ? list.get(0) : null;
            String upperCase = str9 != null ? str9.toUpperCase() : null;
            if (holdingAddress != null) {
                str12 = holdingAddress.getSuburbStateAndPostcode();
                str11 = holdingAddress.getHouseNumber();
                str13 = holdingAddress.getStreetName();
            } else {
                str13 = null;
                str12 = null;
                str11 = null;
            }
            str2 = str12 != null ? str12.toUpperCase() : null;
            str = str11 != null ? str11.toUpperCase() : null;
            if (str13 != null) {
                str14 = str13.toUpperCase();
            }
            str4 = str10;
            str8 = str14;
            str14 = upperCase;
        } else {
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str14);
            TextViewBindingAdapter.setText(this.mboundView2, str);
            TextViewBindingAdapter.setText(this.mboundView3, str8);
            TextViewBindingAdapter.setText(this.mboundView4, str2);
            TextViewBindingAdapter.setText(this.mboundView5, str7);
            TextViewBindingAdapter.setText(this.mboundView6, str6);
            TextViewBindingAdapter.setText(this.mboundView7, str5);
            TextViewBindingAdapter.setText(this.mboundView8, str4);
            TextViewBindingAdapter.setText(this.mboundView9, str3);
        }
    }
}
