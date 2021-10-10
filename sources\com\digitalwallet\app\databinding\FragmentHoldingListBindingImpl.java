package com.digitalwallet.app.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.view.util.BindingAdaptersKt;
import com.digitalwallet.app.viewmodel.main.HoldingListFragmentViewModel;
import io.reactivex.subjects.PublishSubject;

public class FragmentHoldingListBindingImpl extends FragmentHoldingListBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback12;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.sharing_caret, 10);
    }

    public FragmentHoldingListBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private FragmentHoldingListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (TextView) objArr[2], (ImageView) objArr[3], (RecyclerView) objArr[5], (TextView) objArr[4], (ProgressBar) objArr[7], (TextView) objArr[6], (TextView) objArr[9], (ConstraintLayout) objArr[8], (ImageView) objArr[10], (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        this.addCardBtn.setTag(null);
        this.bluetoothIndicator.setTag(null);
        this.cardListRecyclerView.setTag(null);
        this.downloadExistingView.setTag(null);
        this.loadingHud.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.moreInfoView.setTag(null);
        this.sharingActivityText.setTag(null);
        this.sharingActivityView.setTag(null);
        this.title.setTag(null);
        setRootTag(view);
        this.mCallback12 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
        setVm((HoldingListFragmentViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentHoldingListBinding
    public void setVm(HoldingListFragmentViewModel holdingListFragmentViewModel) {
        this.mVm = holdingListFragmentViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVmShowLoadingHUD((ObservableField) obj, i2);
        }
        if (i == 1) {
            return onChangeVmShowRecyclerView((ObservableField) obj, i2);
        }
        if (i == 2) {
            return onChangeVmBluetoothServiceRunning((ObservableBoolean) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return onChangeVmHasHoldings((ObservableField) obj, i2);
    }

    private boolean onChangeVmShowLoadingHUD(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmShowRecyclerView(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmBluetoothServiceRunning(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmHasHoldings(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d3, code lost:
        if (r14 != false) goto L_0x00d5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        SpannableStringBuilder spannableStringBuilder;
        boolean z;
        String str;
        SpannableStringBuilder spannableStringBuilder2;
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        int i2;
        int i3;
        boolean z5;
        SpannableStringBuilder spannableStringBuilder3;
        boolean z6;
        int i4;
        SpannableStringBuilder spannableStringBuilder4;
        String str2;
        boolean z7;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HoldingListFragmentViewModel holdingListFragmentViewModel = this.mVm;
        Boolean bool = null;
        if ((63 & j) != 0) {
            if ((j & 49) != 0) {
                ObservableField<Boolean> showLoadingHUD = holdingListFragmentViewModel != null ? holdingListFragmentViewModel.getShowLoadingHUD() : null;
                updateRegistration(0, showLoadingHUD);
                z5 = ViewDataBinding.safeUnbox(showLoadingHUD != null ? showLoadingHUD.get() : null);
            } else {
                z5 = false;
            }
            int i5 = ((j & 48) > 0 ? 1 : ((j & 48) == 0 ? 0 : -1));
            int i6 = 4;
            if (i5 != 0) {
                if (holdingListFragmentViewModel != null) {
                    spannableStringBuilder4 = holdingListFragmentViewModel.getMoreInfoAboutCardsDescription();
                    i4 = holdingListFragmentViewModel.getSharingTitle();
                    z6 = holdingListFragmentViewModel.isCitizen();
                    spannableStringBuilder3 = holdingListFragmentViewModel.getDownloadExistingHoldingsDescription();
                } else {
                    i4 = 0;
                    z6 = false;
                    spannableStringBuilder4 = null;
                    spannableStringBuilder3 = null;
                }
                if (i5 != 0) {
                    if (z6) {
                        j3 = j | 128;
                        j2 = 512;
                    } else {
                        j3 = j | 64;
                        j2 = 256;
                    }
                    j = j3 | j2;
                }
                str2 = z6 ? this.title.getResources().getString(R.string.title_my_cards) : this.title.getResources().getString(R.string.title_requests);
                i = z6 ? 0 : 4;
            } else {
                str2 = null;
                spannableStringBuilder4 = null;
                spannableStringBuilder3 = null;
                i = 0;
                i4 = 0;
                z6 = false;
            }
            int i7 = ((j & 50) > 0 ? 1 : ((j & 50) == 0 ? 0 : -1));
            if (i7 != 0) {
                ObservableField<Boolean> showRecyclerView = holdingListFragmentViewModel != null ? holdingListFragmentViewModel.getShowRecyclerView() : null;
                updateRegistration(1, showRecyclerView);
                boolean safeUnbox = ViewDataBinding.safeUnbox(showRecyclerView != null ? showRecyclerView.get() : null);
                if (i7 != 0) {
                    j |= safeUnbox ? PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                }
            }
            i6 = 0;
            if ((j & 52) != 0) {
                ObservableBoolean bluetoothServiceRunning = holdingListFragmentViewModel != null ? holdingListFragmentViewModel.getBluetoothServiceRunning() : null;
                updateRegistration(2, bluetoothServiceRunning);
                if (bluetoothServiceRunning != null) {
                    z7 = bluetoothServiceRunning.get();
                } else {
                    z7 = false;
                }
                z3 = !z7;
            } else {
                z3 = false;
            }
            if ((j & 56) != 0) {
                ObservableField<Boolean> hasHoldings = holdingListFragmentViewModel != null ? holdingListFragmentViewModel.getHasHoldings() : null;
                updateRegistration(3, hasHoldings);
                if (hasHoldings != null) {
                    bool = hasHoldings.get();
                }
                z = ViewDataBinding.safeUnbox(bool);
                z2 = z5;
                str = str2;
                i2 = i6;
                spannableStringBuilder2 = spannableStringBuilder4;
                i3 = i4;
                z4 = z6;
                spannableStringBuilder = spannableStringBuilder3;
                if ((48 & j) != 0) {
                    BindingAdaptersKt.setVisibleOrGone(this.addCardBtn, z4);
                    TextViewBindingAdapter.setText(this.downloadExistingView, spannableStringBuilder);
                    this.downloadExistingView.setVisibility(i);
                    TextViewBindingAdapter.setText(this.moreInfoView, spannableStringBuilder2);
                    this.moreInfoView.setVisibility(i);
                    this.sharingActivityText.setText(i3);
                    TextViewBindingAdapter.setText(this.title, str);
                }
                if ((52 & j) != 0) {
                    BindingAdaptersKt.setVisibleOrGone(this.bluetoothIndicator, z3);
                }
                if ((50 & j) != 0) {
                    this.cardListRecyclerView.setVisibility(i2);
                }
                if ((49 & j) != 0) {
                    BindingAdaptersKt.setVisibleOrGone(this.loadingHud, z2);
                }
                if ((56 & j) != 0) {
                    BindingAdaptersKt.setVisibleOrGone(this.sharingActivityView, z);
                }
                if ((j & 32) == 0) {
                    this.sharingActivityView.setOnClickListener(this.mCallback12);
                    return;
                }
                return;
            }
            z2 = z5;
            str = str2;
            i2 = i6;
            spannableStringBuilder2 = spannableStringBuilder4;
            i3 = i4;
            z4 = z6;
            spannableStringBuilder = spannableStringBuilder3;
        } else {
            spannableStringBuilder2 = null;
            str = null;
            spannableStringBuilder = null;
            i3 = 0;
            i2 = 0;
            z4 = false;
            i = 0;
            z3 = false;
            z2 = false;
        }
        z = false;
        if ((48 & j) != 0) {
        }
        if ((52 & j) != 0) {
        }
        if ((50 & j) != 0) {
        }
        if ((49 & j) != 0) {
        }
        if ((56 & j) != 0) {
        }
        if ((j & 32) == 0) {
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        HoldingListFragmentViewModel holdingListFragmentViewModel = this.mVm;
        boolean z = false;
        if (holdingListFragmentViewModel != null) {
            PublishSubject<Boolean> sharesRequest = holdingListFragmentViewModel.getSharesRequest();
            if (sharesRequest != null) {
                z = true;
            }
            if (z) {
                sharesRequest.onNext(true);
            }
        }
    }
}
