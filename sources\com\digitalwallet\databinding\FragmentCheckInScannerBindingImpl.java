package com.digitalwallet.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.generated.callback.OnClickListener;
import com.digitalwallet.view.util.BindingAdaptersKt;
import com.digitalwallet.viewmodel.checkIn.CheckInScannerViewModel;

public class FragmentCheckInScannerBindingImpl extends FragmentCheckInScannerBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback1;
    private final View.OnClickListener mCallback2;
    private final View.OnClickListener mCallback3;
    private final View.OnClickListener mCallback4;
    private long mDirtyFlags;
    private final ImageView mboundView1;
    private final LinearLayout mboundView4;
    private final FrameLayout mboundView5;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.camera_frame_RES_2131296362, 6);
        sparseIntArray.put(R.id.camera_guide_RES_2131296363, 7);
        sparseIntArray.put(R.id.thick_footer_RES_2131296681, 8);
        sparseIntArray.put(R.id.instruction, 9);
        sparseIntArray.put(R.id.back_button_RES_2131296339, 10);
        sparseIntArray.put(R.id.verifying_spinner_RES_2131296705, 11);
    }

    public FragmentCheckInScannerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private FragmentCheckInScannerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[10], (FrameLayout) objArr[6], (FrameLayout) objArr[7], (TextView) objArr[3], (TextView) objArr[9], (TextView) objArr[2], (ConstraintLayout) objArr[0], (ConstraintLayout) objArr[8], (ProgressBar) objArr[11]);
        this.mDirtyFlags = -1;
        this.helpBtn.setTag(null);
        this.manualButton.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[4];
        this.mboundView4 = linearLayout;
        linearLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[5];
        this.mboundView5 = frameLayout;
        frameLayout.setTag(null);
        this.outerFrame.setTag(null);
        setRootTag(view);
        this.mCallback4 = new OnClickListener(this, 4);
        this.mCallback2 = new OnClickListener(this, 2);
        this.mCallback3 = new OnClickListener(this, 3);
        this.mCallback1 = new OnClickListener(this, 1);
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
        if (8 != i) {
            return false;
        }
        setVm((CheckInScannerViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.databinding.FragmentCheckInScannerBinding
    public void setVm(CheckInScannerViewModel checkInScannerViewModel) {
        this.mVm = checkInScannerViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVmLightOn((ObservableBoolean) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeVmLoadingSpinnerVisible((ObservableField) obj, i2);
    }

    private boolean onChangeVmLightOn(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmLoadingSpinnerVisible(ObservableField<Boolean> observableField, int i) {
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
        SpannableStringBuilder spannableStringBuilder;
        Drawable drawable;
        Drawable drawable2;
        boolean z;
        int i;
        Context context;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CheckInScannerViewModel checkInScannerViewModel = this.mVm;
        boolean z2 = false;
        if ((15 & j) != 0) {
            SpannableStringBuilder manualInputButtonText = ((j & 12) == 0 || checkInScannerViewModel == null) ? null : checkInScannerViewModel.getManualInputButtonText();
            int i2 = ((j & 13) > 0 ? 1 : ((j & 13) == 0 ? 0 : -1));
            if (i2 != 0) {
                ObservableBoolean lightOn = checkInScannerViewModel != null ? checkInScannerViewModel.getLightOn() : null;
                updateRegistration(0, lightOn);
                if (lightOn != null) {
                    z = lightOn.get();
                } else {
                    z = false;
                }
                if (i2 != 0) {
                    j |= z ? 32 : 16;
                }
                if (z) {
                    context = this.mboundView1.getContext();
                    i = R.drawable.ic_check_in_torch_on;
                } else {
                    context = this.mboundView1.getContext();
                    i = R.drawable.ic_check_in_torch_off;
                }
                drawable2 = AppCompatResources.getDrawable(context, i);
            } else {
                drawable2 = null;
            }
            if ((j & 14) != 0) {
                ObservableField<Boolean> loadingSpinnerVisible = checkInScannerViewModel != null ? checkInScannerViewModel.getLoadingSpinnerVisible() : null;
                updateRegistration(1, loadingSpinnerVisible);
                z2 = ViewDataBinding.safeUnbox(loadingSpinnerVisible != null ? loadingSpinnerVisible.get() : null);
            }
            drawable = drawable2;
            spannableStringBuilder = manualInputButtonText;
        } else {
            drawable = null;
            spannableStringBuilder = null;
        }
        if ((8 & j) != 0) {
            this.helpBtn.setOnClickListener(this.mCallback3);
            this.manualButton.setOnClickListener(this.mCallback2);
            this.mboundView1.setOnClickListener(this.mCallback1);
            this.mboundView4.setOnClickListener(this.mCallback4);
        }
        if ((12 & j) != 0) {
            TextViewBindingAdapter.setText(this.manualButton, spannableStringBuilder);
        }
        if ((13 & j) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView1, drawable);
        }
        if ((j & 14) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.mboundView5, z2);
        }
    }

    @Override // com.digitalwallet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            CheckInScannerViewModel checkInScannerViewModel = this.mVm;
            if (checkInScannerViewModel != null) {
                z = true;
            }
            if (z) {
                checkInScannerViewModel.toggleTorch(getRoot().getContext());
            }
        } else if (i == 2) {
            CheckInScannerViewModel checkInScannerViewModel2 = this.mVm;
            if (checkInScannerViewModel2 != null) {
                z = true;
            }
            if (z) {
                checkInScannerViewModel2.onManualEntry();
            }
        } else if (i == 3) {
            CheckInScannerViewModel checkInScannerViewModel3 = this.mVm;
            if (checkInScannerViewModel3 != null) {
                z = true;
            }
            if (z) {
                checkInScannerViewModel3.onHelp();
            }
        } else if (i == 4) {
            CheckInScannerViewModel checkInScannerViewModel4 = this.mVm;
            if (checkInScannerViewModel4 != null) {
                z = true;
            }
            if (z) {
                checkInScannerViewModel4.onClose();
            }
        }
    }
}
