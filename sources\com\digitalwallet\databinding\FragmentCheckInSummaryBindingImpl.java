package com.digitalwallet.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.generated.callback.OnClickListener;
import com.digitalwallet.view.util.BindingAdaptersKt;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSummaryViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInInput.PersonRowViewModel;

public class FragmentCheckInSummaryBindingImpl extends FragmentCheckInSummaryBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback27;
    private final View.OnClickListener mCallback28;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final LinearLayout mboundView1;
    private final ItemCheckInPersonRowBinding mboundView11;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final Button mboundView4;
    private final TextView mboundView5;
    private final LinearLayout mboundView6;
    private final Button mboundView7;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(12);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_check_in_title_bar"}, new int[]{8}, new int[]{R.layout.layout_check_in_title_bar});
        includedLayouts.setIncludes(1, new String[]{"item_check_in_person_row"}, new int[]{9}, new int[]{R.layout.item_check_in_person_row});
        includedLayouts.setIncludes(6, new String[]{"layout_check_in_privacy"}, new int[]{10}, new int[]{R.layout.layout_check_in_privacy});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.dependant_list, 11);
    }

    public FragmentCheckInSummaryBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private FragmentCheckInSummaryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (LayoutCheckInPrivacyBinding) objArr[10], (LinearLayout) objArr[11], (LayoutCheckInTitleBarBinding) objArr[8]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.checkInPrivacyLayout);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout2;
        linearLayout2.setTag(null);
        ItemCheckInPersonRowBinding itemCheckInPersonRowBinding = (ItemCheckInPersonRowBinding) objArr[9];
        this.mboundView11 = itemCheckInPersonRowBinding;
        setContainedBinding(itemCheckInPersonRowBinding);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
        Button button = (Button) objArr[4];
        this.mboundView4 = button;
        button.setTag(null);
        TextView textView3 = (TextView) objArr[5];
        this.mboundView5 = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[6];
        this.mboundView6 = linearLayout3;
        linearLayout3.setTag(null);
        Button button2 = (Button) objArr[7];
        this.mboundView7 = button2;
        button2.setTag(null);
        setContainedBinding(this.titleBar);
        setRootTag(view);
        this.mCallback27 = new OnClickListener(this, 1);
        this.mCallback28 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256;
        }
        this.titleBar.invalidateAll();
        this.mboundView11.invalidateAll();
        this.checkInPrivacyLayout.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r4.mboundView11.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r4.checkInPrivacyLayout.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.titleBar.hasPendingBindings() == false) goto L_0x0016;
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
        if (8 != i) {
            return false;
        }
        setVm((CheckInSummaryViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.databinding.FragmentCheckInSummaryBinding
    public void setVm(CheckInSummaryViewModel checkInSummaryViewModel) {
        this.mVm = checkInSummaryViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleBar.setLifecycleOwner(lifecycleOwner);
        this.mboundView11.setLifecycleOwner(lifecycleOwner);
        this.checkInPrivacyLayout.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeCheckInPrivacyLayout((LayoutCheckInPrivacyBinding) obj, i2);
            case 1:
                return onChangeVmLocationName((ObservableField) obj, i2);
            case 2:
                return onChangeVmPrimaryPersonRowVM((ObservableField) obj, i2);
            case 3:
                return onChangeTitleBar((LayoutCheckInTitleBarBinding) obj, i2);
            case 4:
                return onChangeVmDependantCountLimitReached((ObservableBoolean) obj, i2);
            case 5:
                return onChangeVmAddDependantHeader((ObservableField) obj, i2);
            case 6:
                return onChangeVmShowBack((ObservableBoolean) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeCheckInPrivacyLayout(LayoutCheckInPrivacyBinding layoutCheckInPrivacyBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmLocationName(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmPrimaryPersonRowVM(ObservableField<PersonRowViewModel> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeTitleBar(LayoutCheckInTitleBarBinding layoutCheckInTitleBarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmDependantCountLimitReached(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeVmAddDependantHeader(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeVmShowBack(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b9  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        boolean z;
        boolean z2;
        PersonRowViewModel personRowViewModel;
        float f;
        String str2;
        String str3;
        int i;
        float f2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CheckInSummaryViewModel checkInSummaryViewModel = this.mVm;
        boolean z3 = false;
        ObservableBoolean observableBoolean = null;
        if ((502 & j) != 0) {
            if ((j & 386) != 0) {
                ObservableField<String> locationName = checkInSummaryViewModel != null ? checkInSummaryViewModel.getLocationName() : null;
                updateRegistration(1, locationName);
                if (locationName != null) {
                    str3 = locationName.get();
                    if ((j & 388) != 0) {
                        ObservableField<PersonRowViewModel> primaryPersonRowVM = checkInSummaryViewModel != null ? checkInSummaryViewModel.getPrimaryPersonRowVM() : null;
                        updateRegistration(2, primaryPersonRowVM);
                        if (primaryPersonRowVM != null) {
                            personRowViewModel = primaryPersonRowVM.get();
                            i = ((j & 400) > 0 ? 1 : ((j & 400) == 0 ? 0 : -1));
                            if (i != 0) {
                                ObservableBoolean dependantCountLimitReached = checkInSummaryViewModel != null ? checkInSummaryViewModel.getDependantCountLimitReached() : null;
                                updateRegistration(4, dependantCountLimitReached);
                                if (dependantCountLimitReached != null) {
                                    z2 = dependantCountLimitReached.get();
                                } else {
                                    z2 = false;
                                }
                                z = !z2;
                                if (i != 0) {
                                    j |= z ? PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID : 512;
                                }
                                f2 = z ? 1.0f : 0.4f;
                            } else {
                                z2 = false;
                                z = false;
                                f2 = 0.0f;
                            }
                            if ((j & 416) != 0) {
                                ObservableField<String> addDependantHeader = checkInSummaryViewModel != null ? checkInSummaryViewModel.getAddDependantHeader() : null;
                                updateRegistration(5, addDependantHeader);
                                if (addDependantHeader != null) {
                                    str = addDependantHeader.get();
                                    if ((j & 448) != 0) {
                                        if (checkInSummaryViewModel != null) {
                                            observableBoolean = checkInSummaryViewModel.getShowBack();
                                        }
                                        updateRegistration(6, observableBoolean);
                                        if (observableBoolean != null) {
                                            z3 = observableBoolean.get();
                                        }
                                    }
                                    str2 = str3;
                                    f = f2;
                                }
                            }
                            str = null;
                            if ((j & 448) != 0) {
                            }
                            str2 = str3;
                            f = f2;
                        }
                    }
                    personRowViewModel = null;
                    i = ((j & 400) > 0 ? 1 : ((j & 400) == 0 ? 0 : -1));
                    if (i != 0) {
                    }
                    if ((j & 416) != 0) {
                    }
                    str = null;
                    if ((j & 448) != 0) {
                    }
                    str2 = str3;
                    f = f2;
                }
            }
            str3 = null;
            if ((j & 388) != 0) {
            }
            personRowViewModel = null;
            i = ((j & 400) > 0 ? 1 : ((j & 400) == 0 ? 0 : -1));
            if (i != 0) {
            }
            if ((j & 416) != 0) {
            }
            str = null;
            if ((j & 448) != 0) {
            }
            str2 = str3;
            f = f2;
        } else {
            z2 = false;
            z = false;
            str2 = null;
            personRowViewModel = null;
            str = null;
            f = 0.0f;
        }
        if ((j & 388) != 0) {
            this.mboundView11.setVm(personRowViewModel);
        }
        if ((386 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, str2);
        }
        if ((416 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView3, str);
        }
        if ((400 & j) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.mboundView4.setAlpha(f);
            }
            this.mboundView4.setEnabled(z);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView5, z2);
        }
        if ((256 & j) != 0) {
            this.mboundView4.setOnClickListener(this.mCallback27);
            this.mboundView7.setOnClickListener(this.mCallback28);
            this.titleBar.setTitle(getRoot().getResources().getString(R.string.check_in_title));
        }
        if ((j & 448) != 0) {
            this.titleBar.setShowBack(Boolean.valueOf(z3));
        }
        executeBindingsOn(this.titleBar);
        executeBindingsOn(this.mboundView11);
        executeBindingsOn(this.checkInPrivacyLayout);
    }

    @Override // com.digitalwallet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            CheckInSummaryViewModel checkInSummaryViewModel = this.mVm;
            if (checkInSummaryViewModel != null) {
                z = true;
            }
            if (z) {
                checkInSummaryViewModel.onAddADependantClicked();
            }
        } else if (i == 2) {
            CheckInSummaryViewModel checkInSummaryViewModel2 = this.mVm;
            if (checkInSummaryViewModel2 != null) {
                z = true;
            }
            if (z) {
                checkInSummaryViewModel2.onCheckIn();
            }
        }
    }
}
