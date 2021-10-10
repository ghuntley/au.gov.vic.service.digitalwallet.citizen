package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.NotificationBannerViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class NotificationBannerBindingImpl extends NotificationBannerBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback54;
    private long mDirtyFlags;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.notificationView, 4);
    }

    public NotificationBannerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private NotificationBannerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (ConstraintLayout) objArr[0], (Button) objArr[3], (TextView) objArr[2], (ConstraintLayout) objArr[4]);
        this.mDirtyFlags = -1;
        this.alertImageView.setTag(null);
        this.notificationBaseView.setTag(null);
        this.notificationButton.setTag(null);
        this.notificationText.setTag(null);
        setRootTag(view);
        this.mCallback54 = new OnClickListener(this, 1);
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
        setVm((NotificationBannerViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.NotificationBannerBinding
    public void setVm(NotificationBannerViewModel notificationBannerViewModel) {
        this.mVm = notificationBannerViewModel;
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
        String str;
        int i;
        int i2;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        NotificationBannerViewModel notificationBannerViewModel = this.mVm;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        String str2 = null;
        int i4 = 0;
        if (i3 != 0) {
            if (notificationBannerViewModel != null) {
                i2 = notificationBannerViewModel.getButtonText();
                i = notificationBannerViewModel.getTitleText();
                z = notificationBannerViewModel.getShowNoticeIcon();
            } else {
                z = false;
                i2 = 0;
                i = 0;
            }
            if (i3 != 0) {
                j |= z ? 8 : 4;
            }
            str2 = getRoot().getContext().getString(i2);
            str = getRoot().getContext().getString(i);
            if (!z) {
                i4 = 8;
            }
        } else {
            str = null;
        }
        if ((j & 3) != 0) {
            this.alertImageView.setVisibility(i4);
            TextViewBindingAdapter.setText(this.notificationButton, str2);
            TextViewBindingAdapter.setText(this.notificationText, str);
        }
        if ((j & 2) != 0) {
            this.notificationButton.setOnClickListener(this.mCallback54);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        NotificationBannerViewModel notificationBannerViewModel = this.mVm;
        boolean z = true;
        if (notificationBannerViewModel != null) {
            Function0<Unit> visitUrl = notificationBannerViewModel.getVisitUrl();
            if (visitUrl == null) {
                z = false;
            }
            if (z) {
                visitUrl.invoke();
            }
        }
    }
}
