package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.view.util.BindingAdaptersKt;
import com.digitalwallet.app.view.util.ScannerViewState;
import com.digitalwallet.app.viewmodel.main.EligibilityScannerFragmentViewModel;

public class FragmentEligibilityScannerBindingImpl extends FragmentEligibilityScannerBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback50;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final Button mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.camera_frame_RES_2114322455, 9);
        sparseIntArray.put(R.id.camera_guide_RES_2114322456, 10);
        sparseIntArray.put(R.id.thick_footer_RES_2114322633, 11);
        sparseIntArray.put(R.id.verifying_spinner_RES_2114322642, 12);
        sparseIntArray.put(R.id.verifying_text, 13);
        sparseIntArray.put(R.id.eligibility_scanner_title, 14);
        sparseIntArray.put(R.id.eligibility_scanner_subtitle, 15);
        sparseIntArray.put(R.id.complete_footer, 16);
    }

    public FragmentEligibilityScannerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private FragmentEligibilityScannerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (FrameLayout) objArr[9], (ConstraintLayout) objArr[10], (ConstraintLayout) objArr[4], (TextView) objArr[7], (ConstraintLayout) objArr[16], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[15], (TextView) objArr[14], (ConstraintLayout) objArr[1], (ConstraintLayout) objArr[3], (ConstraintLayout) objArr[11], (ConstraintLayout) objArr[2], (ProgressBar) objArr[12], (TextView) objArr[13]);
        this.mDirtyFlags = -1;
        this.complete.setTag(null);
        this.completeCustomErrorText.setTag(null);
        this.completeSubtitle.setTag(null);
        this.completeTitle.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        Button button = (Button) objArr[8];
        this.mboundView8 = button;
        button.setTag(null);
        this.pending.setTag(null);
        this.scanning.setTag(null);
        this.verifying.setTag(null);
        setRootTag(view);
        this.mCallback50 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
        setVm((EligibilityScannerFragmentViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentEligibilityScannerBinding
    public void setVm(EligibilityScannerFragmentViewModel eligibilityScannerFragmentViewModel) {
        this.mVm = eligibilityScannerFragmentViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVmViewState((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeVmCustomErrorText((MutableLiveData) obj, i2);
    }

    private boolean onChangeVmViewState(ObservableField<ScannerViewState> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmCustomErrorText(MutableLiveData<String> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        MutableLiveData<String> mutableLiveData;
        boolean z2;
        ScannerViewState scannerViewState;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        EligibilityScannerFragmentViewModel eligibilityScannerFragmentViewModel = this.mVm;
        ScannerViewState scannerViewState2 = null;
        r11 = null;
        MutableLiveData<String> mutableLiveData2 = null;
        boolean z3 = false;
        if ((15 & j) != 0) {
            if ((j & 13) != 0) {
                ObservableField<ScannerViewState> viewState = eligibilityScannerFragmentViewModel != null ? eligibilityScannerFragmentViewModel.getViewState() : null;
                updateRegistration(0, viewState);
                scannerViewState = viewState != null ? viewState.get() : null;
                boolean z4 = scannerViewState == ScannerViewState.VERIFYING;
                if (scannerViewState == ScannerViewState.SCANNING) {
                    z3 = true;
                }
                z2 = z3;
                z3 = z4;
            } else {
                scannerViewState = null;
                z2 = false;
            }
            if ((j & 14) != 0) {
                if (eligibilityScannerFragmentViewModel != null) {
                    mutableLiveData2 = eligibilityScannerFragmentViewModel.getCustomErrorText();
                }
                updateLiveDataRegistration(1, mutableLiveData2);
                if (mutableLiveData2 != null) {
                    mutableLiveData2.getValue();
                }
            }
            mutableLiveData = mutableLiveData2;
            scannerViewState2 = scannerViewState;
            z = z3;
            z3 = z2;
        } else {
            mutableLiveData = null;
            z = false;
        }
        if ((13 & j) != 0) {
            BindingAdaptersKt.setEligibilityCompleteVisibility(this.complete, scannerViewState2);
            BindingAdaptersKt.setEligibilityCompleteSubtitle(this.completeSubtitle, scannerViewState2);
            BindingAdaptersKt.setEligibilityCompleteTitleResources(this.completeTitle, scannerViewState2);
            BindingAdaptersKt.setEligibilityCompleteButtonText(this.mboundView8, scannerViewState2);
            BindingAdaptersKt.setScannerPendingVisibility(this.pending, scannerViewState2);
            BindingAdaptersKt.setVisibleOrGone(this.scanning, z3);
            BindingAdaptersKt.setVisibleOrGone(this.verifying, z);
        }
        if ((j & 14) != 0) {
            BindingAdaptersKt.setEligibilityCustomError(this.completeCustomErrorText, mutableLiveData);
        }
        if ((j & 8) != 0) {
            this.mboundView8.setOnClickListener(this.mCallback50);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        EligibilityScannerFragmentViewModel eligibilityScannerFragmentViewModel = this.mVm;
        if (eligibilityScannerFragmentViewModel != null) {
            eligibilityScannerFragmentViewModel.performAction();
        }
    }
}
