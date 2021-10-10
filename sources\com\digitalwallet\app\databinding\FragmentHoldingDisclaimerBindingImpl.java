package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.view.main.HoldingDisclaimerFragmentViewModel;

public class FragmentHoldingDisclaimerBindingImpl extends FragmentHoldingDisclaimerBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback59;
    private long mDirtyFlags;
    private final ScrollView mboundView0;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.disclaimer_features, 2);
        sparseIntArray.put(R.id.disclaimer_rotate, 3);
        sparseIntArray.put(R.id.disclaimer_swipe, 4);
        sparseIntArray.put(R.id.disclaimer_tilt, 5);
        sparseIntArray.put(R.id.disclaimer_share, 6);
    }

    public FragmentHoldingDisclaimerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private FragmentHoldingDisclaimerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[6], (TextView) objArr[4], (TextView) objArr[5]);
        this.mDirtyFlags = -1;
        this.back.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        setRootTag(view);
        this.mCallback59 = new OnClickListener(this, 1);
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
        setVm((HoldingDisclaimerFragmentViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentHoldingDisclaimerBinding
    public void setVm(HoldingDisclaimerFragmentViewModel holdingDisclaimerFragmentViewModel) {
        this.mVm = holdingDisclaimerFragmentViewModel;
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
        HoldingDisclaimerFragmentViewModel holdingDisclaimerFragmentViewModel = this.mVm;
        if ((j & 2) != 0) {
            this.back.setOnClickListener(this.mCallback59);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        HoldingDisclaimerFragmentViewModel holdingDisclaimerFragmentViewModel = this.mVm;
        if (holdingDisclaimerFragmentViewModel != null) {
            holdingDisclaimerFragmentViewModel.backToHoldingDetailFragment();
        }
    }
}
