package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.main.ServiceDetailFragmentViewModel;

public class FragmentServiceDetailBindingImpl extends FragmentServiceDetailBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback15;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.serviceDetailRecyclerView, 4);
    }

    public FragmentServiceDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private FragmentServiceDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageButton) objArr[3], (RecyclerView) objArr[4], (ImageView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.backBtn.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.serviceTypeImageView.setTag(null);
        this.serviceTypeName.setTag(null);
        setRootTag(view);
        this.mCallback15 = new OnClickListener(this, 1);
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
        setVm((ServiceDetailFragmentViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentServiceDetailBinding
    public void setVm(ServiceDetailFragmentViewModel serviceDetailFragmentViewModel) {
        this.mVm = serviceDetailFragmentViewModel;
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
            return onChangeVmImage((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeVmTitle((ObservableField) obj, i2);
    }

    private boolean onChangeVmImage(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmTitle(ObservableField<String> observableField, int i) {
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
        ServiceDetailFragmentViewModel serviceDetailFragmentViewModel = this.mVm;
        int i = 0;
        String str = null;
        if ((15 & j) != 0) {
            if ((j & 13) != 0) {
                ObservableField<Integer> image = serviceDetailFragmentViewModel != null ? serviceDetailFragmentViewModel.getImage() : null;
                updateRegistration(0, image);
                i = ViewDataBinding.safeUnbox(image != null ? image.get() : null);
            }
            if ((j & 14) != 0) {
                ObservableField<String> title = serviceDetailFragmentViewModel != null ? serviceDetailFragmentViewModel.getTitle() : null;
                updateRegistration(1, title);
                if (title != null) {
                    str = title.get();
                }
            }
        }
        if ((8 & j) != 0) {
            this.backBtn.setOnClickListener(this.mCallback15);
        }
        if ((j & 13) != 0) {
            this.serviceTypeImageView.setImageResource(i);
        }
        if ((j & 14) != 0) {
            TextViewBindingAdapter.setText(this.serviceTypeName, str);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        ServiceDetailFragmentViewModel serviceDetailFragmentViewModel = this.mVm;
        if (serviceDetailFragmentViewModel != null) {
            serviceDetailFragmentViewModel.backToMainActivity();
        }
    }
}
