package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.view.util.AlertFragment;

public class AlertBindingImpl extends AlertBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback35;
    private final View.OnClickListener mCallback36;
    private final View.OnClickListener mCallback37;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.image_RES_2114322545, 4);
        sparseIntArray.put(R.id.title_RES_2114322634, 5);
        sparseIntArray.put(R.id.message_RES_2114322565, 6);
        sparseIntArray.put(R.id.detailed_message, 7);
        sparseIntArray.put(R.id.action_layout, 8);
    }

    public AlertBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private AlertBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[2], (Button) objArr[1], (GridLayout) objArr[8], (TextView) objArr[7], (Button) objArr[3], (ImageView) objArr[4], (TextView) objArr[6], (TextView) objArr[5]);
        this.mDirtyFlags = -1;
        this.action1.setTag(null);
        this.action2.setTag(null);
        this.dismiss.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        this.mCallback36 = new OnClickListener(this, 2);
        this.mCallback37 = new OnClickListener(this, 3);
        this.mCallback35 = new OnClickListener(this, 1);
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
        setVm((AlertFragment) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.AlertBinding
    public void setVm(AlertFragment alertFragment) {
        this.mVm = alertFragment;
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AlertFragment alertFragment = this.mVm;
        if ((j & 2) != 0) {
            this.action1.setOnClickListener(this.mCallback36);
            this.action2.setOnClickListener(this.mCallback35);
            this.dismiss.setOnClickListener(this.mCallback37);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        boolean z2 = true;
        if (i == 1) {
            AlertFragment alertFragment = this.mVm;
            if (alertFragment != null) {
                z = true;
            }
            if (z) {
                alertFragment.onAction(1);
            }
        } else if (i == 2) {
            AlertFragment alertFragment2 = this.mVm;
            if (alertFragment2 == null) {
                z2 = false;
            }
            if (z2) {
                alertFragment2.onAction(0);
            }
        } else if (i == 3) {
            AlertFragment alertFragment3 = this.mVm;
            if (alertFragment3 != null) {
                z = true;
            }
            if (z) {
                alertFragment3.onDismiss();
            }
        }
    }
}
