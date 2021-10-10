package com.digitalwallet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.view.util.BindingAdaptersKt;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInSuccessViewModel;

public class FragmentCheckInSuccessBindingImpl extends FragmentCheckInSuccessBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LayoutCheckedInDetailFavouringBinding mboundView0;
    private final ConstraintLayout mboundView01;
    private final LayoutCheckInSuccessConversionBinding mboundView02;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_checked_in_detail_favouring", "layout_check_in_success_conversion"}, new int[]{1, 2}, new int[]{R.layout.layout_checked_in_detail_favouring, R.layout.layout_check_in_success_conversion});
    }

    public FragmentCheckInSuccessBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private FragmentCheckInSuccessBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.mDirtyFlags = -1;
        LayoutCheckedInDetailFavouringBinding layoutCheckedInDetailFavouringBinding = (LayoutCheckedInDetailFavouringBinding) objArr[1];
        this.mboundView0 = layoutCheckedInDetailFavouringBinding;
        setContainedBinding(layoutCheckedInDetailFavouringBinding);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView01 = constraintLayout;
        constraintLayout.setTag(null);
        LayoutCheckInSuccessConversionBinding layoutCheckInSuccessConversionBinding = (LayoutCheckInSuccessConversionBinding) objArr[2];
        this.mboundView02 = layoutCheckInSuccessConversionBinding;
        setContainedBinding(layoutCheckInSuccessConversionBinding);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        this.mboundView0.invalidateAll();
        this.mboundView02.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r4.mboundView02.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
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
        setVm((CheckInSuccessViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.databinding.FragmentCheckInSuccessBinding
    public void setVm(CheckInSuccessViewModel checkInSuccessViewModel) {
        this.mVm = checkInSuccessViewModel;
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
        this.mboundView02.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeVmIsInstantApp((ObservableField) obj, i2);
    }

    private boolean onChangeVmIsInstantApp(ObservableField<Boolean> observableField, int i) {
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
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CheckInSuccessViewModel checkInSuccessViewModel = this.mVm;
        int i = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        boolean z2 = false;
        if (i != 0) {
            Boolean bool = null;
            ObservableField<Boolean> isInstantApp = checkInSuccessViewModel != null ? checkInSuccessViewModel.isInstantApp() : null;
            updateRegistration(0, isInstantApp);
            if (isInstantApp != null) {
                bool = isInstantApp.get();
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            z = safeUnbox;
            z2 = ViewDataBinding.safeUnbox(Boolean.valueOf(!safeUnbox));
        } else {
            z = false;
        }
        if ((4 & j) != 0) {
            this.mboundView0.setShowDoneButton(true);
        }
        if (i != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.mboundView0.getRoot(), z2);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView02.getRoot(), z);
        }
        if ((j & 6) != 0) {
            this.mboundView0.setVm(checkInSuccessViewModel);
            this.mboundView02.setVm(checkInSuccessViewModel);
        }
        executeBindingsOn(this.mboundView0);
        executeBindingsOn(this.mboundView02);
    }
}
