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

public class CardKangarooHarvesterFrontBindingImpl extends CardKangarooHarvesterFrontBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.solar_header, 6);
        sparseIntArray.put(R.id.solar_content, 7);
        sparseIntArray.put(R.id.number, 8);
    }

    public CardKangarooHarvesterFrontBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private CardKangarooHarvesterFrontBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[8], (LinearLayout) objArr[7], (ConstraintLayout) objArr[6]);
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

    @Override // com.digitalwallet.app.databinding.CardKangarooHarvesterFrontBinding
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
        List<HoldingAddress> list;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HoldingRecordAttributes holdingRecordAttributes = this.mVm;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        String str6 = null;
        if (i != 0) {
            if (holdingRecordAttributes != null) {
                str4 = holdingRecordAttributes.getStartDateFormatted();
                list = holdingRecordAttributes.getAddresses();
                str3 = holdingRecordAttributes.getExpiryDateFormatted();
                str2 = holdingRecordAttributes.getIdentifier();
                str = holdingRecordAttributes.getHoldingStateToDisplay();
                str5 = holdingRecordAttributes.getFullNameCapitalized();
            } else {
                str4 = null;
                list = null;
                str5 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            HoldingAddress holdingAddress = list != null ? list.get(0) : null;
            String str7 = str5 + '\n';
            String standardFormatAddress = holdingAddress != null ? holdingAddress.getStandardFormatAddress() : null;
            if (standardFormatAddress != null) {
                str6 = standardFormatAddress.toUpperCase();
            }
            str6 = str7 + str6;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str6);
            TextViewBindingAdapter.setText(this.mboundView2, str2);
            TextViewBindingAdapter.setText(this.mboundView3, str);
            TextViewBindingAdapter.setText(this.mboundView4, str4);
            TextViewBindingAdapter.setText(this.mboundView5, str3);
        }
    }
}
