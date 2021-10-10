package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.model.HoldingState;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.view.util.BindingAdaptersKt;

public class CardAffordancesEligibilityBindingImpl extends CardAffordancesEligibilityBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback22;
    private long mDirtyFlags;
    private final CardView mboundView1;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.eligibility_scanner, 2);
    }

    public CardAffordancesEligibilityBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private CardAffordancesEligibilityBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (FrameLayout) objArr[0]);
        this.mDirtyFlags = -1;
        this.frameLayout.setTag(null);
        CardView cardView = (CardView) objArr[1];
        this.mboundView1 = cardView;
        cardView.setTag(null);
        setRootTag(view);
        this.mCallback22 = new OnClickListener(this, 1);
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

    @Override // com.digitalwallet.app.databinding.CardAffordancesEligibilityBinding
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        SecureHolding secureHolding = this.mHolding;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        boolean z = false;
        if (i != 0) {
            HoldingState holdingState = null;
            HoldingRecordAttributes attributes = secureHolding != null ? secureHolding.getAttributes() : null;
            if (attributes != null) {
                holdingState = attributes.getHoldingStateType();
            }
            if (holdingState == HoldingState.ACTIVE) {
                z = true;
            }
        }
        if ((j & 2) != 0) {
            this.mboundView1.setOnClickListener(this.mCallback22);
        }
        if (i != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.mboundView1, z);
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
