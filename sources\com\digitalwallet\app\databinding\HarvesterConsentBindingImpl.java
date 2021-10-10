package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.harvester.HarvestJobWizardViewModel;

public class HarvesterConsentBindingImpl extends HarvesterConsentBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback62;
    private final View.OnClickListener mCallback63;
    private long mDirtyFlags;
    private final GridLayout mboundView0;
    private final ImageView mboundView1;
    private final Button mboundView2;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public HarvesterConsentBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private HarvesterConsentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.mDirtyFlags = -1;
        GridLayout gridLayout = (GridLayout) objArr[0];
        this.mboundView0 = gridLayout;
        gridLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        Button button = (Button) objArr[2];
        this.mboundView2 = button;
        button.setTag(null);
        setRootTag(view);
        this.mCallback63 = new OnClickListener(this, 2);
        this.mCallback62 = new OnClickListener(this, 1);
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
        setVm((HarvestJobWizardViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.HarvesterConsentBinding
    public void setVm(HarvestJobWizardViewModel harvestJobWizardViewModel) {
        this.mVm = harvestJobWizardViewModel;
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
        HarvestJobWizardViewModel harvestJobWizardViewModel = this.mVm;
        if ((j & 2) != 0) {
            this.mboundView1.setOnClickListener(this.mCallback62);
            this.mboundView2.setOnClickListener(this.mCallback63);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            HarvestJobWizardViewModel harvestJobWizardViewModel = this.mVm;
            if (harvestJobWizardViewModel != null) {
                z = true;
            }
            if (z) {
                harvestJobWizardViewModel.goBack();
            }
        } else if (i == 2) {
            HarvestJobWizardViewModel harvestJobWizardViewModel2 = this.mVm;
            if (harvestJobWizardViewModel2 != null) {
                z = true;
            }
            if (z) {
                harvestJobWizardViewModel2.consent();
            }
        }
    }
}
