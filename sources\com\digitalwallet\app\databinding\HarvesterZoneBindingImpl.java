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

public class HarvesterZoneBindingImpl extends HarvesterZoneBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback3;
    private final View.OnClickListener mCallback4;
    private long mDirtyFlags;
    private final GridLayout mboundView0;
    private final ImageView mboundView1;
    private final LinearLayout mboundView2;
    private final Button mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.zone_table, 4);
    }

    public HarvesterZoneBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private HarvesterZoneBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (RecyclerView) objArr[4]);
        this.mDirtyFlags = -1;
        GridLayout gridLayout = (GridLayout) objArr[0];
        this.mboundView0 = gridLayout;
        gridLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[2];
        this.mboundView2 = linearLayout;
        linearLayout.setTag(null);
        Button button = (Button) objArr[3];
        this.mboundView3 = button;
        button.setTag(null);
        setRootTag(view);
        this.mCallback3 = new OnClickListener(this, 1);
        this.mCallback4 = new OnClickListener(this, 2);
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
        setVm((HarvestJobWizardViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.HarvesterZoneBinding
    public void setVm(HarvestJobWizardViewModel harvestJobWizardViewModel) {
        this.mVm = harvestJobWizardViewModel;
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
            return onChangeVmQuotaId((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeVmHasZones((ObservableField) obj, i2);
    }

    private boolean onChangeVmQuotaId(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmHasZones(ObservableField<Boolean> observableField, int i) {
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
        boolean z2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HarvestJobWizardViewModel harvestJobWizardViewModel = this.mVm;
        int i = 0;
        if ((15 & j) != 0) {
            Boolean bool = null;
            if ((j & 13) != 0) {
                ObservableField<String> quotaId = harvestJobWizardViewModel != null ? harvestJobWizardViewModel.getQuotaId() : null;
                updateRegistration(0, quotaId);
                String str = quotaId != null ? quotaId.get() : null;
                if (str != null) {
                    z2 = str.isEmpty();
                } else {
                    z2 = false;
                }
                z = !z2;
            } else {
                z = false;
            }
            int i2 = ((j & 14) > 0 ? 1 : ((j & 14) == 0 ? 0 : -1));
            if (i2 != 0) {
                ObservableField<Boolean> hasZones = harvestJobWizardViewModel != null ? harvestJobWizardViewModel.getHasZones() : null;
                updateRegistration(1, hasZones);
                if (hasZones != null) {
                    bool = hasZones.get();
                }
                boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
                if (i2 != 0) {
                    j |= safeUnbox ? 32 : 16;
                }
                if (safeUnbox) {
                    i = 8;
                }
            }
        } else {
            z = false;
        }
        if ((8 & j) != 0) {
            this.mboundView1.setOnClickListener(this.mCallback3);
            this.mboundView3.setOnClickListener(this.mCallback4);
        }
        if ((14 & j) != 0) {
            this.mboundView2.setVisibility(i);
        }
        if ((j & 13) != 0) {
            this.mboundView3.setEnabled(z);
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
                harvestJobWizardViewModel2.saveJob();
            }
        }
    }
}
