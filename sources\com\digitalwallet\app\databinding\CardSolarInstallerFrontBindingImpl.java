package com.digitalwallet.app.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.model.HoldingRecordAttributes;

public class CardSolarInstallerFrontBindingImpl extends CardSolarInstallerFrontBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView6;
    private final TextView mboundView7;
    private final TextView mboundView8;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.solar_header, 9);
        sparseIntArray.put(R.id.solar_content, 10);
        sparseIntArray.put(R.id.left_details, 11);
        sparseIntArray.put(R.id.licence_number_title, 12);
        sparseIntArray.put(R.id.expires, 13);
        sparseIntArray.put(R.id.right_details, 14);
        sparseIntArray.put(R.id.accreditation_title, 15);
        sparseIntArray.put(R.id.status, 16);
    }

    public CardSolarInstallerFrontBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private CardSolarInstallerFrontBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[15], (TextView) objArr[13], (TextView) objArr[1], (LinearLayout) objArr[11], (TextView) objArr[12], (LinearLayout) objArr[14], (LinearLayout) objArr[10], (ConstraintLayout) objArr[9], (TextView) objArr[16]);
        this.mDirtyFlags = -1;
        this.holderName.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.mboundView4 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[5];
        this.mboundView5 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[6];
        this.mboundView6 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[7];
        this.mboundView7 = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[8];
        this.mboundView8 = textView7;
        textView7.setTag(null);
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

    @Override // com.digitalwallet.app.databinding.CardSolarInstallerFrontBinding
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
        Drawable drawable;
        String str2;
        Drawable drawable2;
        String str3;
        String str4;
        Drawable drawable3;
        Drawable drawable4;
        boolean z;
        String str5;
        boolean z2;
        String str6;
        String str7;
        boolean z3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HoldingRecordAttributes holdingRecordAttributes = this.mVm;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            boolean z4 = false;
            if (holdingRecordAttributes != null) {
                z4 = holdingRecordAttributes.getGridConnect();
                str7 = holdingRecordAttributes.getIdentifier();
                str2 = holdingRecordAttributes.getHoldingStateToDisplay();
                str6 = holdingRecordAttributes.getLastName();
                z2 = holdingRecordAttributes.getSolarHotWater();
                str = holdingRecordAttributes.getExpiryDateFormatted();
                str5 = holdingRecordAttributes.getFirstName();
                z = holdingRecordAttributes.getBattery();
                z3 = holdingRecordAttributes.getStandAlone();
            } else {
                z3 = false;
                z2 = false;
                z = false;
                str7 = null;
                str2 = null;
                str6 = null;
                str = null;
                str5 = null;
            }
            if (i != 0) {
                j |= z4 ? 128 : 64;
            }
            if ((j & 3) != 0) {
                j |= z2 ? 32 : 16;
            }
            if ((j & 3) != 0) {
                j |= z ? 8 : 4;
            }
            if ((j & 3) != 0) {
                j |= z3 ? 512 : 256;
            }
            drawable2 = z4 ? AppCompatResources.getDrawable(this.mboundView4.getContext(), R.drawable.ic_tick) : AppCompatResources.getDrawable(this.mboundView4.getContext(), R.drawable.ic_cross_black);
            drawable = z2 ? AppCompatResources.getDrawable(this.mboundView6.getContext(), R.drawable.ic_tick) : AppCompatResources.getDrawable(this.mboundView6.getContext(), R.drawable.ic_cross_black);
            Context context = this.mboundView7.getContext();
            drawable3 = z ? AppCompatResources.getDrawable(context, R.drawable.ic_tick) : AppCompatResources.getDrawable(context, R.drawable.ic_cross_black);
            drawable4 = z3 ? AppCompatResources.getDrawable(this.mboundView5.getContext(), R.drawable.ic_tick) : AppCompatResources.getDrawable(this.mboundView5.getContext(), R.drawable.ic_cross_black);
            str4 = str7 != null ? str7.toUpperCase() : null;
            String upperCase = str6 != null ? str6.toUpperCase() : null;
            str3 = ((str5 != null ? str5.toUpperCase() : null) + " ") + upperCase;
        } else {
            drawable4 = null;
            drawable3 = null;
            str4 = null;
            str3 = null;
            drawable2 = null;
            str2 = null;
            drawable = null;
            str = null;
        }
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.holderName, str3);
            TextViewBindingAdapter.setText(this.mboundView2, str4);
            TextViewBindingAdapter.setText(this.mboundView3, str);
            TextViewBindingAdapter.setDrawableStart(this.mboundView4, drawable2);
            TextViewBindingAdapter.setDrawableStart(this.mboundView5, drawable4);
            TextViewBindingAdapter.setDrawableStart(this.mboundView6, drawable);
            TextViewBindingAdapter.setDrawableStart(this.mboundView7, drawable3);
            TextViewBindingAdapter.setText(this.mboundView8, str2);
        }
    }
}
