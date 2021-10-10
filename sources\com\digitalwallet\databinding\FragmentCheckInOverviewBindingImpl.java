package com.digitalwallet.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.generated.callback.OnClickListener;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.viewmodel.checkIn.CheckInOverviewViewModel;

public class FragmentCheckInOverviewBindingImpl extends FragmentCheckInOverviewBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback6;
    private final View.OnClickListener mCallback7;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.description, 10);
        sparseIntArray.put(R.id.title_RES_2131296683, 11);
        sparseIntArray.put(R.id.check_in_input, 12);
        sparseIntArray.put(R.id.check_in_tick, 13);
        sparseIntArray.put(R.id.no_check_in_title, 14);
        sparseIntArray.put(R.id.no_check_in_desc, 15);
    }

    public FragmentCheckInOverviewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private FragmentCheckInOverviewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (Button) objArr[9], (ConstraintLayout) objArr[4], (ConstraintLayout) objArr[12], (ImageView) objArr[13], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[2], (ConstraintLayout) objArr[10], (TextView) objArr[1], (TextView) objArr[3], (TextView) objArr[15], (TextView) objArr[14], (ConstraintLayout) objArr[8], (TextView) objArr[11]);
        this.mDirtyFlags = -1;
        this.checkInBtn.setTag(null);
        this.checkInInfoView.setTag(null);
        this.checkInToTitle.setTag(null);
        this.checkedIn.setTag(null);
        this.checkedInTime.setTag(null);
        this.desc.setTag(null);
        this.infoBtn.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.networkConnectionIssueErrorMessage.setTag(null);
        this.noCheckInView.setTag(null);
        setRootTag(view);
        this.mCallback6 = new OnClickListener(this, 1);
        this.mCallback7 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
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
        if (8 != i) {
            return false;
        }
        setVm((CheckInOverviewViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.databinding.FragmentCheckInOverviewBinding
    public void setVm(CheckInOverviewViewModel checkInOverviewViewModel) {
        this.mVm = checkInOverviewViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVmIsCheckInInfoVisible((LiveData) obj, i2);
        }
        if (i == 1) {
            return onChangeVmCheckInItem((LiveData) obj, i2);
        }
        if (i == 2) {
            return onChangeVmCheckInTime((LiveData) obj, i2);
        }
        if (i == 3) {
            return onChangeVmCheckedInText((LiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return onChangeVmNoInternetConnectionBanner((LiveData) obj, i2);
    }

    private boolean onChangeVmIsCheckInInfoVisible(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmCheckInItem(LiveData<CheckIn> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmCheckInTime(LiveData<String> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmCheckedInText(LiveData<String> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmNoInternetConnectionBanner(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0102  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        int i2;
        int i3;
        String str3;
        int i4;
        int i5;
        String str4;
        int i6;
        long j2;
        long j3;
        long j4;
        long j5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CheckInOverviewViewModel checkInOverviewViewModel = this.mVm;
        if ((127 & j) != 0) {
            int i7 = ((j & 97) > 0 ? 1 : ((j & 97) == 0 ? 0 : -1));
            int i8 = 8;
            if (i7 != 0) {
                LiveData<Boolean> isCheckInInfoVisible = checkInOverviewViewModel != null ? checkInOverviewViewModel.isCheckInInfoVisible() : null;
                updateLiveDataRegistration(0, isCheckInInfoVisible);
                boolean safeUnbox = ViewDataBinding.safeUnbox(isCheckInInfoVisible != null ? isCheckInInfoVisible.getValue() : null);
                if (i7 != 0) {
                    if (safeUnbox) {
                        j5 = j | 256;
                        j4 = PlaybackStateCompat.ACTION_PREPARE;
                    } else {
                        j5 = j | 128;
                        j4 = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    }
                    j = j5 | j4;
                }
                i5 = safeUnbox ? 0 : 8;
                i2 = safeUnbox ? 8 : 0;
            } else {
                i5 = 0;
                i2 = 0;
            }
            if ((j & 98) != 0) {
                LiveData<CheckIn> checkInItem = checkInOverviewViewModel != null ? checkInOverviewViewModel.getCheckInItem() : null;
                updateLiveDataRegistration(1, checkInItem);
                CheckIn value = checkInItem != null ? checkInItem.getValue() : null;
                if (value != null) {
                    str4 = value.getLocationName();
                    if ((j & 100) != 0) {
                        LiveData<String> checkInTime = checkInOverviewViewModel != null ? checkInOverviewViewModel.getCheckInTime() : null;
                        updateLiveDataRegistration(2, checkInTime);
                        if (checkInTime != null) {
                            str = checkInTime.getValue();
                            if ((j & 104) != 0) {
                                LiveData<String> checkedInText = checkInOverviewViewModel != null ? checkInOverviewViewModel.getCheckedInText() : null;
                                updateLiveDataRegistration(3, checkedInText);
                                if (checkedInText != null) {
                                    str2 = checkedInText.getValue();
                                    i6 = ((j & 112) > 0 ? 1 : ((j & 112) == 0 ? 0 : -1));
                                    if (i6 == 0) {
                                        LiveData<Boolean> noInternetConnectionBanner = checkInOverviewViewModel != null ? checkInOverviewViewModel.getNoInternetConnectionBanner() : null;
                                        updateLiveDataRegistration(4, noInternetConnectionBanner);
                                        boolean safeUnbox2 = ViewDataBinding.safeUnbox(noInternetConnectionBanner != null ? noInternetConnectionBanner.getValue() : null);
                                        if (i6 != 0) {
                                            if (safeUnbox2) {
                                                j3 = j | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                                                j2 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                                            } else {
                                                j3 = j | 512;
                                                j2 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                                            }
                                            j = j3 | j2;
                                        }
                                        i = safeUnbox2 ? 0 : 8;
                                        if (!safeUnbox2) {
                                            i8 = 0;
                                        }
                                        i4 = i8;
                                    } else {
                                        i4 = 0;
                                        i = 0;
                                    }
                                    i3 = i5;
                                    str3 = str4;
                                }
                            }
                            str2 = null;
                            i6 = ((j & 112) > 0 ? 1 : ((j & 112) == 0 ? 0 : -1));
                            if (i6 == 0) {
                            }
                            i3 = i5;
                            str3 = str4;
                        }
                    }
                    str = null;
                    if ((j & 104) != 0) {
                    }
                    str2 = null;
                    i6 = ((j & 112) > 0 ? 1 : ((j & 112) == 0 ? 0 : -1));
                    if (i6 == 0) {
                    }
                    i3 = i5;
                    str3 = str4;
                }
            }
            str4 = null;
            if ((j & 100) != 0) {
            }
            str = null;
            if ((j & 104) != 0) {
            }
            str2 = null;
            i6 = ((j & 112) > 0 ? 1 : ((j & 112) == 0 ? 0 : -1));
            if (i6 == 0) {
            }
            i3 = i5;
            str3 = str4;
        } else {
            i4 = 0;
            str3 = null;
            i3 = 0;
            i2 = 0;
            str2 = null;
            i = 0;
            str = null;
        }
        if ((j & 64) != 0) {
            this.checkInBtn.setOnClickListener(this.mCallback7);
            this.infoBtn.setOnClickListener(this.mCallback6);
        }
        if ((j & 97) != 0) {
            this.checkInInfoView.setVisibility(i3);
            this.noCheckInView.setVisibility(i2);
        }
        if ((98 & j) != 0) {
            TextViewBindingAdapter.setText(this.checkInToTitle, str3);
        }
        if ((104 & j) != 0) {
            TextViewBindingAdapter.setText(this.checkedIn, str2);
        }
        if ((100 & j) != 0) {
            TextViewBindingAdapter.setText(this.checkedInTime, str);
        }
        if ((j & 112) != 0) {
            this.desc.setVisibility(i4);
            this.networkConnectionIssueErrorMessage.setVisibility(i);
        }
    }

    @Override // com.digitalwallet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            CheckInOverviewViewModel checkInOverviewViewModel = this.mVm;
            if (checkInOverviewViewModel != null) {
                z = true;
            }
            if (z) {
                checkInOverviewViewModel.onInfo();
            }
        } else if (i == 2) {
            CheckInOverviewViewModel checkInOverviewViewModel2 = this.mVm;
            if (checkInOverviewViewModel2 != null) {
                z = true;
            }
            if (z) {
                checkInOverviewViewModel2.onCheckIn();
            }
        }
    }
}
