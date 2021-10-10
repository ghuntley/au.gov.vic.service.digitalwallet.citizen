package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.main.history.SharingHistoryFragmentViewModel;
import io.reactivex.subjects.PublishSubject;

public class FragmentSharingHistoryBindingImpl extends FragmentSharingHistoryBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback14;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView5;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.sharing_caret, 6);
    }

    public FragmentSharingHistoryBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private FragmentSharingHistoryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (View) objArr[3], (RecyclerView) objArr[4], (TextView) objArr[2], (ImageView) objArr[6], (ConstraintLayout) objArr[1]);
        this.mDirtyFlags = -1;
        this.headerDivider.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.mboundView5 = textView;
        textView.setTag(null);
        this.sharesRecyclerView.setTag(null);
        this.sharingActivityText.setTag(null);
        this.sharingHeader.setTag(null);
        setRootTag(view);
        this.mCallback14 = new OnClickListener(this, 1);
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
        setVm((SharingHistoryFragmentViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentSharingHistoryBinding
    public void setVm(SharingHistoryFragmentViewModel sharingHistoryFragmentViewModel) {
        this.mVm = sharingHistoryFragmentViewModel;
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
        return onChangeVmSharesArePresent((ObservableField) obj, i2);
    }

    private boolean onChangeVmSharesArePresent(ObservableField<Boolean> observableField, int i) {
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
        int i;
        int i2;
        int i3;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        SharingHistoryFragmentViewModel sharingHistoryFragmentViewModel = this.mVm;
        int i4 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        int i5 = 0;
        if (i4 != 0) {
            if ((j & 6) == 0 || sharingHistoryFragmentViewModel == null) {
                i2 = 0;
                i = 0;
            } else {
                i2 = sharingHistoryFragmentViewModel.getTitle();
                i = sharingHistoryFragmentViewModel.getEmptyStateText();
            }
            Boolean bool = null;
            ObservableField<Boolean> sharesArePresent = sharingHistoryFragmentViewModel != null ? sharingHistoryFragmentViewModel.getSharesArePresent() : null;
            updateRegistration(0, sharesArePresent);
            if (sharesArePresent != null) {
                bool = sharesArePresent.get();
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i4 != 0) {
                if (safeUnbox) {
                    j3 = j | 16;
                    j2 = 64;
                } else {
                    j3 = j | 8;
                    j2 = 32;
                }
                j = j3 | j2;
            }
            int i6 = safeUnbox ? 0 : 8;
            if (safeUnbox) {
                i5 = 8;
            }
            i3 = i5;
            i5 = i6;
        } else {
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((7 & j) != 0) {
            this.headerDivider.setVisibility(i5);
            this.mboundView5.setVisibility(i3);
            this.sharesRecyclerView.setVisibility(i5);
        }
        if ((j & 6) != 0) {
            this.mboundView5.setText(i);
            this.sharingActivityText.setText(i2);
        }
        if ((j & 4) != 0) {
            this.sharingHeader.setOnClickListener(this.mCallback14);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        SharingHistoryFragmentViewModel sharingHistoryFragmentViewModel = this.mVm;
        boolean z = false;
        if (sharingHistoryFragmentViewModel != null) {
            PublishSubject<Boolean> closeViewPublisher = sharingHistoryFragmentViewModel.getCloseViewPublisher();
            if (closeViewPublisher != null) {
                z = true;
            }
            if (z) {
                closeViewPublisher.onNext(true);
            }
        }
    }
}
