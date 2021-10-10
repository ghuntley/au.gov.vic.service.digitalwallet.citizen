package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.harvester.HarvestJobWizardViewModel;

public class HarvesterJobsBindingImpl extends HarvesterJobsBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback7;
    private final View.OnClickListener mCallback8;
    private long mDirtyFlags;
    private final GridLayout mboundView0;
    private final ImageView mboundView1;
    private final LinearLayout mboundView2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.job_table, 4);
    }

    public HarvesterJobsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private HarvesterJobsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Button) objArr[3], (RecyclerView) objArr[4]);
        this.mDirtyFlags = -1;
        this.addCardBtn.setTag(null);
        GridLayout gridLayout = (GridLayout) objArr[0];
        this.mboundView0 = gridLayout;
        gridLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[2];
        this.mboundView2 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        this.mCallback7 = new OnClickListener(this, 1);
        this.mCallback8 = new OnClickListener(this, 2);
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
        setVm((HarvestJobWizardViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.HarvesterJobsBinding
    public void setVm(HarvestJobWizardViewModel harvestJobWizardViewModel) {
        this.mVm = harvestJobWizardViewModel;
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
        return onChangeVmHasJobs((ObservableField) obj, i2);
    }

    private boolean onChangeVmHasJobs(ObservableField<Boolean> observableField, int i) {
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
        HarvestJobWizardViewModel harvestJobWizardViewModel = this.mVm;
        int i = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        int i2 = 0;
        if (i != 0) {
            Boolean bool = null;
            ObservableField<Boolean> hasJobs = harvestJobWizardViewModel != null ? harvestJobWizardViewModel.getHasJobs() : null;
            updateRegistration(0, hasJobs);
            if (hasJobs != null) {
                bool = hasJobs.get();
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i != 0) {
                j |= safeUnbox ? 16 : 8;
            }
            if (safeUnbox) {
                i2 = 8;
            }
        }
        if ((4 & j) != 0) {
            this.addCardBtn.setOnClickListener(this.mCallback8);
            this.mboundView1.setOnClickListener(this.mCallback7);
        }
        if ((j & 7) != 0) {
            this.mboundView2.setVisibility(i2);
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
                harvestJobWizardViewModel2.goToWizardConsent();
            }
        }
    }
}
