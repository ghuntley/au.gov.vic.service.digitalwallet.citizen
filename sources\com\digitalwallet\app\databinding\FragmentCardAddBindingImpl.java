package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.main.addsync.CardAddViewModel;

public class FragmentCardAddBindingImpl extends FragmentCardAddBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback38;
    private final View.OnClickListener mCallback39;
    private final View.OnClickListener mCallback40;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ConstraintLayout mboundView1;
    private final LayoutTitleBarBinding mboundView11;
    private final TextView mboundView2;
    private final ConstraintLayout mboundView3;
    private final ConstraintLayout mboundView4;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_title_bar"}, new int[]{5}, new int[]{R.layout.layout_title_bar_RES_2114388042});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.fishing_card, 6);
        sparseIntArray.put(R.id.sync_card, 7);
        sparseIntArray.put(R.id.next_button, 8);
    }

    public FragmentCardAddBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private FragmentCardAddBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[6], (ImageView) objArr[8], (ImageView) objArr[7]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        LayoutTitleBarBinding layoutTitleBarBinding = (LayoutTitleBarBinding) objArr[5];
        this.mboundView11 = layoutTitleBarBinding;
        setContainedBinding(layoutTitleBarBinding);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[3];
        this.mboundView3 = constraintLayout2;
        constraintLayout2.setTag(null);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) objArr[4];
        this.mboundView4 = constraintLayout3;
        constraintLayout3.setTag(null);
        setRootTag(view);
        this.mCallback38 = new OnClickListener(this, 1);
        this.mCallback39 = new OnClickListener(this, 2);
        this.mCallback40 = new OnClickListener(this, 3);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
        }
        this.mboundView11.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.mboundView11.hasPendingBindings() == false) goto L_0x0016;
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
        setVm((CardAddViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentCardAddBinding
    public void setVm(CardAddViewModel cardAddViewModel) {
        this.mVm = cardAddViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView11.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CardAddViewModel cardAddViewModel = this.mVm;
        if ((j & 2) != 0) {
            this.mboundView11.setTitle(getRoot().getResources().getString(R.string.plus_new_card));
            this.mboundView2.setOnClickListener(this.mCallback38);
            this.mboundView3.setOnClickListener(this.mCallback39);
            this.mboundView4.setOnClickListener(this.mCallback40);
        }
        executeBindingsOn(this.mboundView11);
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            CardAddViewModel cardAddViewModel = this.mVm;
            if (cardAddViewModel != null) {
                z = true;
            }
            if (z) {
                cardAddViewModel.cancel();
            }
        } else if (i == 2) {
            CardAddViewModel cardAddViewModel2 = this.mVm;
            if (cardAddViewModel2 != null) {
                z = true;
            }
            if (z) {
                cardAddViewModel2.openFishingLicenceUrl();
            }
        } else if (i == 3) {
            CardAddViewModel cardAddViewModel3 = this.mVm;
            if (cardAddViewModel3 != null) {
                z = true;
            }
            if (z) {
                cardAddViewModel3.openCardSyncView();
            }
        }
    }
}
