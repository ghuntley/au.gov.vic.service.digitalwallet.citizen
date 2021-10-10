package com.digitalwallet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSubmittingViewModel;

public class FragmentCheckInSubmittingBindingImpl extends FragmentCheckInSubmittingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LayoutLoadingBinding mboundView0;
    private final LinearLayout mboundView01;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(2);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_loading"}, new int[]{1}, new int[]{R.layout.layout_loading_RES_2131492939});
    }

    public FragmentCheckInSubmittingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, sIncludes, sViewsWithIds));
    }

    private FragmentCheckInSubmittingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.mDirtyFlags = -1;
        LayoutLoadingBinding layoutLoadingBinding = (LayoutLoadingBinding) objArr[1];
        this.mboundView0 = layoutLoadingBinding;
        setContainedBinding(layoutLoadingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView01 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        this.mboundView0.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.mboundView0.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (8 != i) {
            return false;
        }
        setVm((CheckInSubmittingViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.databinding.FragmentCheckInSubmittingBinding
    public void setVm(CheckInSubmittingViewModel checkInSubmittingViewModel) {
        this.mVm = checkInSubmittingViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView0.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeVmLoadingSpinnerVisible((ObservableBoolean) obj, i2);
    }

    private boolean onChangeVmLoadingSpinnerVisible(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CheckInSubmittingViewModel checkInSubmittingViewModel = this.mVm;
        ObservableBoolean observableBoolean = null;
        int i = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        boolean z = false;
        if (i != 0) {
            if (checkInSubmittingViewModel != null) {
                observableBoolean = checkInSubmittingViewModel.getLoadingSpinnerVisible();
            }
            updateRegistration(0, observableBoolean);
            if (observableBoolean != null) {
                z = observableBoolean.get();
            }
        }
        if (i != 0) {
            this.mboundView0.setShowLoading(Boolean.valueOf(z));
        }
        executeBindingsOn(this.mboundView0);
    }
}
