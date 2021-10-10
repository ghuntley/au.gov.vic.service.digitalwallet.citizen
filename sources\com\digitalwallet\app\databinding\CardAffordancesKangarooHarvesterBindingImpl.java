package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.model.HoldingState;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.view.util.BindingAdaptersKt;

public class CardAffordancesKangarooHarvesterBindingImpl extends CardAffordancesKangarooHarvesterBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback30;
    private long mDirtyFlags;
    private final CardView mboundView1;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public CardAffordancesKangarooHarvesterBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, sIncludes, sViewsWithIds));
    }

    private CardAffordancesKangarooHarvesterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[0]);
        this.mDirtyFlags = -1;
        this.frameLayout.setTag(null);
        CardView cardView = (CardView) objArr[1];
        this.mboundView1 = cardView;
        cardView.setTag(null);
        setRootTag(view);
        this.mCallback30 = new OnClickListener(this, 1);
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

    @Override // com.digitalwallet.app.databinding.CardAffordancesKangarooHarvesterBinding
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
        boolean z2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        SecureHolding secureHolding = this.mHolding;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        HoldingRecordAttributes holdingRecordAttributes = null;
        HoldingState holdingState = null;
        boolean z3 = false;
        if (i != 0) {
            HoldingRecordAttributes attributes = secureHolding != null ? secureHolding.getAttributes() : null;
            if (attributes != null) {
                holdingState = attributes.getHoldingStateType();
            }
            boolean z4 = holdingState == HoldingState.AUTHORISED;
            if (i != 0) {
                j = z4 ? j | 8 : j | 4;
            }
            holdingRecordAttributes = attributes;
            z = z4;
        } else {
            z = false;
        }
        if ((j & 8) == 0 || holdingRecordAttributes == null) {
            z2 = false;
        } else {
            z2 = holdingRecordAttributes.getValidForDate();
        }
        int i2 = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i2 != 0 && z) {
            z3 = z2;
        }
        if ((j & 2) != 0) {
            this.mboundView1.setOnClickListener(this.mCallback30);
        }
        if (i2 != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.mboundView1, z3);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        SecureHolding secureHolding = this.mHolding;
        if (secureHolding != null) {
            secureHolding.performAction();
        }
    }
}
