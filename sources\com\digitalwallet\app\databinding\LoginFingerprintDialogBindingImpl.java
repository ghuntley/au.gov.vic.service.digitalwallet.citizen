package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.view.util.BindingAdaptersKt;
import com.digitalwallet.app.viewmodel.pin.FingerprintDialogFragmentViewModel;
import com.digitalwallet.app.viewmodel.pin.FingerprintState;

public class LoginFingerprintDialogBindingImpl extends LoginFingerprintDialogBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback60;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.titleTextView, 4);
        sparseIntArray.put(R.id.subtitleTextView, 5);
        sparseIntArray.put(R.id.buttons, 6);
    }

    public LoginFingerprintDialogBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private LoginFingerprintDialogBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[6], (Button) objArr[3], (TextView) objArr[2], (ImageView) objArr[1], (TextView) objArr[5], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.cancelButton.setTag(null);
        this.errorTextView.setTag(null);
        this.fingerprintImageView.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        this.mCallback60 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        setVm((FingerprintDialogFragmentViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.LoginFingerprintDialogBinding
    public void setVm(FingerprintDialogFragmentViewModel fingerprintDialogFragmentViewModel) {
        this.mVm = fingerprintDialogFragmentViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeVmViewState((ObservableField) obj, i2);
    }

    private boolean onChangeVmViewState(ObservableField<FingerprintState> observableField, int i) {
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
        FingerprintDialogFragmentViewModel fingerprintDialogFragmentViewModel = this.mVm;
        int i = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        FingerprintState fingerprintState = null;
        if (i != 0) {
            ObservableField<FingerprintState> viewState = fingerprintDialogFragmentViewModel != null ? fingerprintDialogFragmentViewModel.getViewState() : null;
            updateRegistration(0, viewState);
            if (viewState != null) {
                fingerprintState = viewState.get();
            }
        }
        if ((j & 4) != 0) {
            this.cancelButton.setOnClickListener(this.mCallback60);
        }
        if (i != 0) {
            BindingAdaptersKt.updateFingerprintText(this.errorTextView, fingerprintState);
            BindingAdaptersKt.updateFingerprintIcon(this.fingerprintImageView, fingerprintState);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        FingerprintDialogFragmentViewModel fingerprintDialogFragmentViewModel = this.mVm;
        if (fingerprintDialogFragmentViewModel != null) {
            fingerprintDialogFragmentViewModel.dismissFingerprintDialog();
        }
    }
}
