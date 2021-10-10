package com.digitalwallet.app.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.main.HoldingDetailFragmentViewModel;

public class FragmentHoldingDetailBindingImpl extends FragmentHoldingDetailBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback10;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(15);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(2, new String[]{"card"}, new int[]{7}, new int[]{R.layout.card});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.holdingDetailConstraintLayout, 8);
        sparseIntArray.put(R.id.content_scroll_view, 9);
        sparseIntArray.put(R.id.days_to_expire, 10);
        sparseIntArray.put(R.id.alert_image_view, 11);
        sparseIntArray.put(R.id.holding_detail_recycler_view, 12);
        sparseIntArray.put(R.id.coming_soon_text, 13);
        sparseIntArray.put(R.id.notice_image_view, 14);
    }

    public FragmentHoldingDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private FragmentHoldingDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (ImageView) objArr[11], (CardBinding) objArr[7], null, (TextView) objArr[13], (ConstraintLayout) objArr[5], (ScrollView) objArr[9], (TextView) objArr[10], null, (ConstraintLayout) objArr[3], null, (RelativeLayout) objArr[4], (ConstraintLayout) objArr[8], (FrameLayout) objArr[2], (RecyclerView) objArr[12], (ImageView) objArr[14], (FrameLayout) objArr[6], (ImageButton) objArr[1], null);
        this.mDirtyFlags = -1;
        setContainedBinding(this.cardLayout);
        this.comingSoonTextContainer.setTag(null);
        this.expiryLayout.setTag(null);
        this.holdingDetailAttributeView.setTag(null);
        this.holdingDetailLayoutView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        this.notificationBannerView.setTag(null);
        this.rotateHoldingButton.setTag(null);
        setRootTag(view);
        this.mCallback10 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
            this.mDirtyFlags |= 16;
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
            return onChangeVmShowNotificationBanner((ObservableField) obj, i2);
        }
        if (i == 1) {
            return onChangeVmShowHoldingDetailAttributeView((ObservableField) obj, i2);
        }
        if (i == 2) {
            return onChangeCardLayout((CardBinding) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return onChangeVmShowExpiryView((ObservableField) obj, i2);
    }

    private boolean onChangeVmShowNotificationBanner(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmShowHoldingDetailAttributeView(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeCardLayout(CardBinding cardBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmShowExpiryView(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d2  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HoldingDetailFragmentViewModel holdingDetailFragmentViewModel = this.mVm;
        if ((59 & j) != 0) {
            int i11 = ((j & 49) > 0 ? 1 : ((j & 49) == 0 ? 0 : -1));
            if (i11 != 0) {
                ObservableField<Boolean> showNotificationBanner = holdingDetailFragmentViewModel != null ? holdingDetailFragmentViewModel.getShowNotificationBanner() : null;
                updateRegistration(0, showNotificationBanner);
                boolean safeUnbox = ViewDataBinding.safeUnbox(showNotificationBanner != null ? showNotificationBanner.get() : null);
                if (i11 != 0) {
                    j |= safeUnbox ? PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : PlaybackStateCompat.ACTION_PREPARE;
                }
                if (!safeUnbox) {
                    i6 = 8;
                    i7 = ((j & 50) > 0 ? 1 : ((j & 50) == 0 ? 0 : -1));
                    if (i7 == 0) {
                        ObservableField<Boolean> showHoldingDetailAttributeView = holdingDetailFragmentViewModel != null ? holdingDetailFragmentViewModel.getShowHoldingDetailAttributeView() : null;
                        updateRegistration(1, showHoldingDetailAttributeView);
                        boolean safeUnbox2 = ViewDataBinding.safeUnbox(showHoldingDetailAttributeView != null ? showHoldingDetailAttributeView.get() : null);
                        if (i7 != 0) {
                            if (safeUnbox2) {
                                j3 = j | 512 | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                                j2 = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                            } else {
                                j3 = j | 256 | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                                j2 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                            }
                            j = j3 | j2;
                        }
                        i8 = safeUnbox2 ? 8 : 0;
                        i = safeUnbox2 ? 0 : 4;
                        i9 = safeUnbox2 ? 0 : 8;
                    } else {
                        i9 = 0;
                        i8 = 0;
                        i = 0;
                    }
                    i10 = ((j & 56) > 0 ? 1 : ((j & 56) == 0 ? 0 : -1));
                    if (i10 == 0) {
                        ObservableField<Boolean> showExpiryView = holdingDetailFragmentViewModel != null ? holdingDetailFragmentViewModel.getShowExpiryView() : null;
                        updateRegistration(3, showExpiryView);
                        boolean safeUnbox3 = ViewDataBinding.safeUnbox(showExpiryView != null ? showExpiryView.get() : null);
                        if (i10 != 0) {
                            j |= safeUnbox3 ? 128 : 64;
                        }
                        int i12 = safeUnbox3 ? 0 : 8;
                        i3 = i6;
                        i5 = i9;
                        i2 = i8;
                        i4 = i12;
                    } else {
                        i3 = i6;
                        i5 = i9;
                        i2 = i8;
                        i4 = 0;
                    }
                }
            }
            i6 = 0;
            i7 = ((j & 50) > 0 ? 1 : ((j & 50) == 0 ? 0 : -1));
            if (i7 == 0) {
            }
            i10 = ((j & 56) > 0 ? 1 : ((j & 56) == 0 ? 0 : -1));
            if (i10 == 0) {
            }
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((j & 50) != 0) {
            this.comingSoonTextContainer.setVisibility(i2);
            this.holdingDetailAttributeView.setVisibility(i5);
            this.rotateHoldingButton.setVisibility(i);
        }
        if ((56 & j) != 0) {
            this.expiryLayout.setVisibility(i4);
        }
        if ((49 & j) != 0) {
            this.notificationBannerView.setVisibility(i3);
        }
        if ((j & 32) != 0) {
            this.rotateHoldingButton.setOnClickListener(this.mCallback10);
        }
        executeBindingsOn(this.cardLayout);
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        HoldingDetailFragmentViewModel holdingDetailFragmentViewModel = this.mVm;
        if (holdingDetailFragmentViewModel != null) {
            holdingDetailFragmentViewModel.viewCard();
        }
    }
}
