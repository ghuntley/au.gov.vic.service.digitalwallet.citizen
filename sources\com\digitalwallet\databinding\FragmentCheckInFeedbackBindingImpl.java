package com.digitalwallet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.digitalwallet.generated.callback.OnClickListener;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInFeedbackViewModel;

public class FragmentCheckInFeedbackBindingImpl extends FragmentCheckInFeedbackBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback16;
    private final View.OnClickListener mCallback17;
    private final View.OnClickListener mCallback18;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final LinearLayout mboundView1;
    private final LinearLayout mboundView2;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public FragmentCheckInFeedbackBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private FragmentCheckInFeedbackBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[3]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[2];
        this.mboundView2 = linearLayout2;
        linearLayout2.setTag(null);
        this.skipBtn.setTag(null);
        setRootTag(view);
        this.mCallback16 = new OnClickListener(this, 1);
        this.mCallback17 = new OnClickListener(this, 2);
        this.mCallback18 = new OnClickListener(this, 3);
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
        if (8 != i) {
            return false;
        }
        setVm((CheckInFeedbackViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.databinding.FragmentCheckInFeedbackBinding
    public void setVm(CheckInFeedbackViewModel checkInFeedbackViewModel) {
        this.mVm = checkInFeedbackViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(8);
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
        CheckInFeedbackViewModel checkInFeedbackViewModel = this.mVm;
        if ((j & 2) != 0) {
            this.mboundView1.setOnClickListener(this.mCallback16);
            this.mboundView2.setOnClickListener(this.mCallback17);
            this.skipBtn.setOnClickListener(this.mCallback18);
        }
    }

    @Override // com.digitalwallet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            CheckInFeedbackViewModel checkInFeedbackViewModel = this.mVm;
            if (checkInFeedbackViewModel != null) {
                z = true;
            }
            if (z) {
                checkInFeedbackViewModel.provideBadFeedback();
            }
        } else if (i == 2) {
            CheckInFeedbackViewModel checkInFeedbackViewModel2 = this.mVm;
            if (checkInFeedbackViewModel2 != null) {
                z = true;
            }
            if (z) {
                checkInFeedbackViewModel2.provideGoodFeedback();
            }
        } else if (i == 3) {
            CheckInFeedbackViewModel checkInFeedbackViewModel3 = this.mVm;
            if (checkInFeedbackViewModel3 != null) {
                z = true;
            }
            if (z) {
                checkInFeedbackViewModel3.onSkip();
            }
        }
    }
}
