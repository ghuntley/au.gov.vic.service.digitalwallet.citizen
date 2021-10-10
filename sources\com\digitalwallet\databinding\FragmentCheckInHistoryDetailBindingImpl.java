package com.digitalwallet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.generated.callback.OnClickListener;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInHistoryDetailViewModel;

public class FragmentCheckInHistoryDetailBindingImpl extends FragmentCheckInHistoryDetailBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback19;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final LayoutCheckedInDetailFavouringBinding mboundView01;
    private final ImageView mboundView1;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_checked_in_detail_favouring"}, new int[]{2}, new int[]{R.layout.layout_checked_in_detail_favouring});
    }

    public FragmentCheckInHistoryDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private FragmentCheckInHistoryDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        LayoutCheckedInDetailFavouringBinding layoutCheckedInDetailFavouringBinding = (LayoutCheckedInDetailFavouringBinding) objArr[2];
        this.mboundView01 = layoutCheckedInDetailFavouringBinding;
        setContainedBinding(layoutCheckedInDetailFavouringBinding);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        setRootTag(view);
        this.mCallback19 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
        }
        this.mboundView01.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.mboundView01.hasPendingBindings() == false) goto L_0x0016;
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
        setVm((CheckInHistoryDetailViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.databinding.FragmentCheckInHistoryDetailBinding
    public void setVm(CheckInHistoryDetailViewModel checkInHistoryDetailViewModel) {
        this.mVm = checkInHistoryDetailViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView01.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CheckInHistoryDetailViewModel checkInHistoryDetailViewModel = this.mVm;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if ((j & 2) != 0) {
            this.mboundView01.setShowDoneButton(false);
            this.mboundView1.setOnClickListener(this.mCallback19);
        }
        if (i != 0) {
            this.mboundView01.setVm(checkInHistoryDetailViewModel);
        }
        executeBindingsOn(this.mboundView01);
    }

    @Override // com.digitalwallet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        CheckInHistoryDetailViewModel checkInHistoryDetailViewModel = this.mVm;
        if (checkInHistoryDetailViewModel != null) {
            checkInHistoryDetailViewModel.onBack();
        }
    }
}
