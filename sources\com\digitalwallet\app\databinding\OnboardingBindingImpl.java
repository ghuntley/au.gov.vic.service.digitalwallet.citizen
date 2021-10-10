package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.view.onboarding.OnboardingViewModel;

public class OnboardingBindingImpl extends OnboardingBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback5;
    private final View.OnClickListener mCallback6;
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
        sparseIntArray.put(R.id.pager, 3);
        sparseIntArray.put(R.id.footer, 4);
        sparseIntArray.put(R.id.dots, 5);
        sparseIntArray.put(R.id.dot1, 6);
        sparseIntArray.put(R.id.dot2, 7);
        sparseIntArray.put(R.id.dot3, 8);
        sparseIntArray.put(R.id.fragment_container_RES_2114322527, 9);
    }

    public OnboardingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private OnboardingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[6], (ImageView) objArr[7], (ImageView) objArr[8], (LinearLayout) objArr[5], (LinearLayout) objArr[4], (FrameLayout) objArr[9], (Button) objArr[2], (ViewPager) objArr[3], (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.next.setTag(null);
        this.skip.setTag(null);
        setRootTag(view);
        this.mCallback5 = new OnClickListener(this, 1);
        this.mCallback6 = new OnClickListener(this, 2);
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
        if (8257542 != i) {
            return false;
        }
        setViewModel((OnboardingViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.OnboardingBinding
    public void setViewModel(OnboardingViewModel onboardingViewModel) {
        this.mViewModel = onboardingViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.viewModel);
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
        OnboardingViewModel onboardingViewModel = this.mViewModel;
        if ((j & 2) != 0) {
            this.next.setOnClickListener(this.mCallback6);
            this.skip.setOnClickListener(this.mCallback5);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            OnboardingViewModel onboardingViewModel = this.mViewModel;
            if (onboardingViewModel != null) {
                z = true;
            }
            if (z) {
                onboardingViewModel.done(true);
            }
        } else if (i == 2) {
            OnboardingViewModel onboardingViewModel2 = this.mViewModel;
            if (onboardingViewModel2 != null) {
                z = true;
            }
            if (z) {
                onboardingViewModel2.next();
            }
        }
    }
}
