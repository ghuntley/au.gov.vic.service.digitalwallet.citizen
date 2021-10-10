package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.main.HoldingDetailFragmentViewModel;

public class FragmentHoldingDetailBindingLandImpl extends FragmentHoldingDetailBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback46;
    private final View.OnClickListener mCallback47;
    private final View.OnClickListener mCallback48;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(8);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(4, new String[]{"card"}, new int[]{5}, new int[]{R.layout.card});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.holdingDetailConstraintLayout, 6);
        sparseIntArray.put(R.id.rotate_message, 7);
    }

    public FragmentHoldingDetailBindingLandImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private FragmentHoldingDetailBindingLandImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, null, (CardBinding) objArr[5], (ImageButton) objArr[1], null, null, null, null, (ImageButton) objArr[3], null, (ImageButton) objArr[2], null, (ConstraintLayout) objArr[6], (FrameLayout) objArr[4], null, null, null, null, (TextView) objArr[7]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.cardLayout);
        this.closeButton.setTag(null);
        this.disclaimerButton.setTag(null);
        this.flipCardButton.setTag(null);
        this.holdingDetailLayoutView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        this.mCallback47 = new OnClickListener(this, 2);
        this.mCallback48 = new OnClickListener(this, 3);
        this.mCallback46 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
        }
        this.cardLayout.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.cardLayout.hasPendingBindings() == false) goto L_0x0016;
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
        if (8257543 != i) {
            return false;
        }
        setVm((HoldingDetailFragmentViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentHoldingDetailBinding
    public void setVm(HoldingDetailFragmentViewModel holdingDetailFragmentViewModel) {
        this.mVm = holdingDetailFragmentViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.cardLayout.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeCardLayout((CardBinding) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeVmKeepLandscapeOrientation((ObservableField) obj, i2);
    }

    private boolean onChangeCardLayout(CardBinding cardBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmKeepLandscapeOrientation(ObservableField<Boolean> observableField, int i) {
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HoldingDetailFragmentViewModel holdingDetailFragmentViewModel = this.mVm;
        int i = ((j & 14) > 0 ? 1 : ((j & 14) == 0 ? 0 : -1));
        int i2 = 0;
        if (i != 0) {
            Boolean bool = null;
            ObservableField<Boolean> keepLandscapeOrientation = holdingDetailFragmentViewModel != null ? holdingDetailFragmentViewModel.getKeepLandscapeOrientation() : null;
            updateRegistration(1, keepLandscapeOrientation);
            if (keepLandscapeOrientation != null) {
                bool = keepLandscapeOrientation.get();
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i != 0) {
                j |= safeUnbox ? 32 : 16;
            }
            if (!safeUnbox) {
                i2 = 8;
            }
        }
        if ((8 & j) != 0) {
            this.closeButton.setOnClickListener(this.mCallback46);
            this.disclaimerButton.setOnClickListener(this.mCallback48);
            this.flipCardButton.setOnClickListener(this.mCallback47);
        }
        if ((j & 14) != 0) {
            this.closeButton.setVisibility(i2);
        }
        executeBindingsOn(this.cardLayout);
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            HoldingDetailFragmentViewModel holdingDetailFragmentViewModel = this.mVm;
            if (holdingDetailFragmentViewModel != null) {
                z = true;
            }
            if (z) {
                holdingDetailFragmentViewModel.changeToPortraitOrientation();
            }
        } else if (i == 2) {
            HoldingDetailFragmentViewModel holdingDetailFragmentViewModel2 = this.mVm;
            if (holdingDetailFragmentViewModel2 != null) {
                z = true;
            }
            if (z) {
                holdingDetailFragmentViewModel2.flipCard(true);
            }
        } else if (i == 3) {
            HoldingDetailFragmentViewModel holdingDetailFragmentViewModel3 = this.mVm;
            if (holdingDetailFragmentViewModel3 != null) {
                z = true;
            }
            if (z) {
                holdingDetailFragmentViewModel3.startHoldingDisclaimerFragment();
            }
        }
    }
}
