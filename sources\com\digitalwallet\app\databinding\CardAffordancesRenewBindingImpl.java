package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.model.SecureHolding;

public class CardAffordancesRenewBindingImpl extends CardAffordancesRenewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final CardView mboundView1;
    private final TextView mboundView2;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public CardAffordancesRenewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private CardAffordancesRenewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        CardView cardView = (CardView) objArr[1];
        this.mboundView1 = cardView;
        cardView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
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
        if (8257539 != i) {
            return false;
        }
        setHolding((SecureHolding) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.CardAffordancesRenewBinding
    public void setHolding(SecureHolding secureHolding) {
        this.mHolding = secureHolding;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.holding);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String str;
        boolean z2;
        HoldingRecordAttributes holdingRecordAttributes;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        SecureHolding secureHolding = this.mHolding;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        HoldingRecordAttributes holdingRecordAttributes2 = null;
        String str2 = null;
        int i2 = 0;
        if (i != 0) {
            if (secureHolding != null) {
                z = secureHolding.getShowExpiryWarning();
                holdingRecordAttributes = secureHolding.getAttributes();
            } else {
                holdingRecordAttributes = null;
                z = false;
            }
            if (i != 0) {
                j = z ? j | 32 : j | 16;
            }
            if (holdingRecordAttributes != null) {
                str2 = holdingRecordAttributes.getExpiryText();
            }
            holdingRecordAttributes2 = holdingRecordAttributes;
            str = str2;
        } else {
            str = null;
            z = false;
        }
        if ((j & 16) == 0 || holdingRecordAttributes2 == null) {
            z2 = false;
        } else {
            z2 = holdingRecordAttributes2.isHoldingExpired();
        }
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (z) {
                z2 = true;
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(Boolean.valueOf(z2));
            if (i3 != 0) {
                j |= safeUnbox ? 8 : 4;
            }
            if (!safeUnbox) {
                i2 = 4;
            }
        }
        if ((j & 3) != 0) {
            this.mboundView1.setVisibility(i2);
            TextViewBindingAdapter.setText(this.mboundView2, str);
        }
    }
}
