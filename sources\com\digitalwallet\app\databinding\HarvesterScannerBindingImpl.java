package com.digitalwallet.app.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.view.util.BindingAdaptersKt;
import com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel;

public class HarvesterScannerBindingImpl extends HarvesterScannerBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback18;
    private final View.OnClickListener mCallback19;
    private final View.OnClickListener mCallback20;
    private final View.OnClickListener mCallback21;
    private long mDirtyFlags;
    private final Button mboundView1;
    private final TextView mboundView2;
    private final ImageView mboundView3;
    private final LinearLayout mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.camera_frame_RES_2114322455, 5);
        sparseIntArray.put(R.id.camera_guide_RES_2114322456, 6);
        sparseIntArray.put(R.id.thick_footer_RES_2114322633, 7);
        sparseIntArray.put(R.id.eligibility_scanner_subtitle, 8);
        sparseIntArray.put(R.id.back_button_RES_2114322446, 9);
    }

    public HarvesterScannerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private HarvesterScannerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[9], (FrameLayout) objArr[5], (FrameLayout) objArr[6], (TextView) objArr[8], (ConstraintLayout) objArr[0], (LinearLayout) objArr[7]);
        this.mDirtyFlags = -1;
        Button button = (Button) objArr[1];
        this.mboundView1 = button;
        button.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.mboundView3 = imageView;
        imageView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[4];
        this.mboundView4 = linearLayout;
        linearLayout.setTag(null);
        this.outerFrame.setTag(null);
        setRootTag(view);
        this.mCallback21 = new OnClickListener(this, 4);
        this.mCallback18 = new OnClickListener(this, 1);
        this.mCallback19 = new OnClickListener(this, 2);
        this.mCallback20 = new OnClickListener(this, 3);
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
        setVm((HarvestTagViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.HarvesterScannerBinding
    public void setVm(HarvestTagViewModel harvestTagViewModel) {
        this.mVm = harvestTagViewModel;
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
            return onChangeVmTagCount((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeVmLightOn((ObservableBoolean) obj, i2);
    }

    private boolean onChangeVmTagCount(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmLightOn(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0042  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HarvestTagViewModel harvestTagViewModel = this.mVm;
        boolean z2 = false;
        Drawable drawable = null;
        ObservableBoolean observableBoolean = null;
        drawable = null;
        if ((15 & j) != 0) {
            if ((j & 13) != 0) {
                ObservableField<Integer> tagCount = harvestTagViewModel != null ? harvestTagViewModel.getTagCount() : null;
                updateRegistration(0, tagCount);
                if (ViewDataBinding.safeUnbox(tagCount != null ? tagCount.get() : null) > 0) {
                    z = true;
                    i = ((j & 14) > 0 ? 1 : ((j & 14) == 0 ? 0 : -1));
                    if (i != 0) {
                        if (harvestTagViewModel != null) {
                            observableBoolean = harvestTagViewModel.getLightOn();
                        }
                        updateRegistration(1, observableBoolean);
                        if (observableBoolean != null) {
                            z2 = observableBoolean.get();
                        }
                        if (i != 0) {
                            j |= z2 ? 32 : 16;
                        }
                        drawable = AppCompatResources.getDrawable(this.mboundView3.getContext(), z2 ? R.drawable.ic_torch_on : R.drawable.ic_torch_off);
                    }
                    z2 = z;
                }
            }
            z = false;
            i = ((j & 14) > 0 ? 1 : ((j & 14) == 0 ? 0 : -1));
            if (i != 0) {
            }
            z2 = z;
        }
        if ((8 & j) != 0) {
            this.mboundView1.setOnClickListener(this.mCallback18);
            this.mboundView2.setOnClickListener(this.mCallback19);
            this.mboundView3.setOnClickListener(this.mCallback20);
            this.mboundView4.setOnClickListener(this.mCallback21);
        }
        if ((j & 13) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.mboundView2, z2);
        }
        if ((j & 14) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView3, drawable);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            HarvestTagViewModel harvestTagViewModel = this.mVm;
            if (harvestTagViewModel != null) {
                z = true;
            }
            if (z) {
                harvestTagViewModel.manualEntry();
            }
        } else if (i == 2) {
            HarvestTagViewModel harvestTagViewModel2 = this.mVm;
            if (harvestTagViewModel2 != null) {
                z = true;
            }
            if (z) {
                harvestTagViewModel2.goBackFromScanner();
            }
        } else if (i == 3) {
            HarvestTagViewModel harvestTagViewModel3 = this.mVm;
            if (harvestTagViewModel3 != null) {
                z = true;
            }
            if (z) {
                harvestTagViewModel3.toggleTorch();
            }
        } else if (i == 4) {
            HarvestTagViewModel harvestTagViewModel4 = this.mVm;
            if (harvestTagViewModel4 != null) {
                z = true;
            }
            if (z) {
                harvestTagViewModel4.closeScanner();
            }
        }
    }
}
