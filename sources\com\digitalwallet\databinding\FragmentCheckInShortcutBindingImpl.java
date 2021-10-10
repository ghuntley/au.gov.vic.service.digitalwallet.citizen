package com.digitalwallet.databinding;

import android.content.res.Resources;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.generated.callback.OnClickListener;
import com.digitalwallet.view.util.BindingAdaptersKt;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.CheckInShortcutViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.FavouriteRowViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.HistoryRowViewModel;
import java.util.List;

public class FragmentCheckInShortcutBindingImpl extends FragmentCheckInShortcutBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback20;
    private final View.OnClickListener mCallback21;
    private final View.OnClickListener mCallback22;
    private final View.OnClickListener mCallback23;
    private final View.OnClickListener mCallback24;
    private final View.OnClickListener mCallback25;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView10;
    private final View mboundView11;
    private final View mboundView12;
    private final NestedScrollView mboundView13;
    private final LinearLayout mboundView14;
    private final LayoutInfoBoxBinding mboundView141;
    private final TextView mboundView17;
    private final TextView mboundView18;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final LinearLayout mboundView5;
    private final TextView mboundView6;
    private final View mboundView7;
    private final View mboundView8;
    private final LinearLayout mboundView9;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(25);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(14, new String[]{"layout_info_box"}, new int[]{20}, new int[]{R.layout.layout_info_box});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_bar_RES_2131296685, 21);
        sparseIntArray.put(R.id.title_text, 22);
        sparseIntArray.put(R.id.feature_tabs, 23);
        sparseIntArray.put(R.id.history_list, 24);
    }

    public FragmentCheckInShortcutBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 25, sIncludes, sViewsWithIds));
    }

    private FragmentCheckInShortcutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (ImageView) objArr[1], (TextView) objArr[19], (TextView) objArr[4], (RecyclerView) objArr[15], (LinearLayout) objArr[23], (RecyclerView) objArr[24], (LinearLayout) objArr[16], (ConstraintLayout) objArr[21], (TextView) objArr[22]);
        this.mDirtyFlags = -1;
        this.backButton.setTag(null);
        this.deleteButton.setTag(null);
        this.editButton.setTag(null);
        this.favouriteList.setTag(null);
        this.historyListContainer.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.mboundView10 = textView;
        textView.setTag(null);
        View view2 = (View) objArr[11];
        this.mboundView11 = view2;
        view2.setTag(null);
        View view3 = (View) objArr[12];
        this.mboundView12 = view3;
        view3.setTag(null);
        NestedScrollView nestedScrollView = (NestedScrollView) objArr[13];
        this.mboundView13 = nestedScrollView;
        nestedScrollView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[14];
        this.mboundView14 = linearLayout;
        linearLayout.setTag(null);
        LayoutInfoBoxBinding layoutInfoBoxBinding = (LayoutInfoBoxBinding) objArr[20];
        this.mboundView141 = layoutInfoBoxBinding;
        setContainedBinding(layoutInfoBoxBinding);
        TextView textView2 = (TextView) objArr[17];
        this.mboundView17 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[18];
        this.mboundView18 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[2];
        this.mboundView2 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[3];
        this.mboundView3 = textView5;
        textView5.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[5];
        this.mboundView5 = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView6 = (TextView) objArr[6];
        this.mboundView6 = textView6;
        textView6.setTag(null);
        View view4 = (View) objArr[7];
        this.mboundView7 = view4;
        view4.setTag(null);
        View view5 = (View) objArr[8];
        this.mboundView8 = view5;
        view5.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[9];
        this.mboundView9 = linearLayout3;
        linearLayout3.setTag(null);
        setRootTag(view);
        this.mCallback23 = new OnClickListener(this, 4);
        this.mCallback24 = new OnClickListener(this, 5);
        this.mCallback25 = new OnClickListener(this, 6);
        this.mCallback21 = new OnClickListener(this, 2);
        this.mCallback20 = new OnClickListener(this, 1);
        this.mCallback22 = new OnClickListener(this, 3);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256;
        }
        this.mboundView141.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.mboundView141.hasPendingBindings() == false) goto L_0x0016;
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
        setVm((CheckInShortcutViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.databinding.FragmentCheckInShortcutBinding
    public void setVm(CheckInShortcutViewModel checkInShortcutViewModel) {
        this.mVm = checkInShortcutViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView141.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeVmHistoryRowVMs((ObservableField) obj, i2);
            case 1:
                return onChangeVmAreAllRowsSelected((ObservableBoolean) obj, i2);
            case 2:
                return onChangeVmFavouriteRowVMs((ObservableField) obj, i2);
            case 3:
                return onChangeVmSelectedRowsCount((ObservableInt) obj, i2);
            case 4:
                return onChangeVmHistoryLocationQuery((ObservableField) obj, i2);
            case 5:
                return onChangeVmIsHistoryView((ObservableBoolean) obj, i2);
            case 6:
                return onChangeVmIsEditMode((ObservableBoolean) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeVmHistoryRowVMs(ObservableField<List<HistoryRowViewModel>> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmAreAllRowsSelected(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmFavouriteRowVMs(ObservableField<List<FavouriteRowViewModel>> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmSelectedRowsCount(ObservableInt observableInt, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmHistoryLocationQuery(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeVmIsHistoryView(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeVmIsEditMode(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0158  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        List<FavouriteRowViewModel> list;
        boolean z3;
        List<HistoryRowViewModel> list2;
        ObservableField<List<FavouriteRowViewModel>> observableField;
        String str;
        boolean z4;
        boolean z5;
        ObservableBoolean observableBoolean;
        String str2;
        String str3;
        int i;
        boolean z6;
        ObservableField<List<HistoryRowViewModel>> observableField2;
        boolean z7;
        int i2;
        boolean z8;
        ObservableField<List<HistoryRowViewModel>> observableField3;
        String str4;
        boolean z9;
        boolean z10;
        long j2;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        String str5;
        String str6;
        ObservableField<List<HistoryRowViewModel>> observableField4;
        ObservableBoolean observableBoolean2;
        String str7;
        ObservableBoolean observableBoolean3;
        long j3;
        long j4;
        long j5;
        String str8;
        boolean z16;
        List<HistoryRowViewModel> list3;
        ObservableField<List<HistoryRowViewModel>> observableField5;
        String str9;
        boolean z17;
        boolean z18;
        List<FavouriteRowViewModel> list4;
        ObservableField<List<FavouriteRowViewModel>> observableField6;
        boolean z19;
        int i3;
        String str10;
        boolean z20;
        boolean z21;
        ObservableBoolean observableBoolean4;
        String str11;
        int i4;
        int i5;
        int i6;
        ObservableBoolean observableBoolean5;
        long j6;
        long j7;
        boolean z22;
        int i7;
        Resources resources;
        int i8;
        boolean z23;
        int i9;
        Resources resources2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CheckInShortcutViewModel checkInShortcutViewModel = this.mVm;
        if ((511 & j) != 0) {
            if ((j & 385) != 0) {
                observableField5 = checkInShortcutViewModel != null ? checkInShortcutViewModel.getHistoryRowVMs() : null;
                updateRegistration(0, observableField5);
                list3 = observableField5 != null ? observableField5.get() : null;
                z16 = list3 != null ? list3.isEmpty() : false;
            } else {
                z16 = false;
                observableField5 = null;
                list3 = null;
            }
            int i10 = ((j & 386) > 0 ? 1 : ((j & 386) == 0 ? 0 : -1));
            if (i10 != 0) {
                ObservableBoolean areAllRowsSelected = checkInShortcutViewModel != null ? checkInShortcutViewModel.getAreAllRowsSelected() : null;
                updateRegistration(1, areAllRowsSelected);
                if (areAllRowsSelected != null) {
                    z23 = areAllRowsSelected.get();
                } else {
                    z23 = false;
                }
                if (i10 != 0) {
                    j |= z23 ? 4294967296L : 2147483648L;
                }
                if (z23) {
                    resources2 = this.mboundView2.getResources();
                    i9 = R.string.deselect_all;
                } else {
                    resources2 = this.mboundView2.getResources();
                    i9 = R.string.select_all;
                }
                str9 = resources2.getString(i9);
            } else {
                str9 = null;
            }
            if ((j & 388) != 0) {
                observableField6 = checkInShortcutViewModel != null ? checkInShortcutViewModel.getFavouriteRowVMs() : null;
                updateRegistration(2, observableField6);
                list4 = observableField6 != null ? observableField6.get() : null;
                if (list4 != null) {
                    z18 = list4.isEmpty();
                } else {
                    z18 = false;
                }
                if ((j & 512) != 0) {
                    j = z18 ? j | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : j | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                }
                z17 = !z18;
            } else {
                z18 = false;
                z17 = false;
                observableField6 = null;
                list4 = null;
            }
            if ((j & 392) != 0) {
                ObservableInt selectedRowsCount = checkInShortcutViewModel != null ? checkInShortcutViewModel.getSelectedRowsCount() : null;
                updateRegistration(3, selectedRowsCount);
                if (selectedRowsCount != null) {
                    i8 = selectedRowsCount.get();
                } else {
                    i8 = 0;
                }
                if (i8 > 0) {
                    z19 = true;
                    i3 = ((j & 400) > 0 ? 1 : ((j & 400) == 0 ? 0 : -1));
                    if (i3 == 0) {
                        ObservableField<String> historyLocationQuery = checkInShortcutViewModel != null ? checkInShortcutViewModel.getHistoryLocationQuery() : null;
                        updateRegistration(4, historyLocationQuery);
                        String str12 = historyLocationQuery != null ? historyLocationQuery.get() : null;
                        if (str12 != null) {
                            z22 = str12.isEmpty();
                        } else {
                            z22 = false;
                        }
                        if (i3 != 0) {
                            j |= z22 ? PlaybackStateCompat.ACTION_PREPARE : PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                        }
                        if (z22) {
                            resources = this.mboundView17.getResources();
                            i7 = R.string.check_in_no_history;
                        } else {
                            resources = this.mboundView17.getResources();
                            i7 = R.string.check_in_no_search_results;
                        }
                        str10 = resources.getString(i7);
                    } else {
                        str10 = null;
                    }
                    if ((j & 420) == 0) {
                        observableBoolean4 = checkInShortcutViewModel != null ? checkInShortcutViewModel.isHistoryView() : null;
                        updateRegistration(5, observableBoolean4);
                        if (observableBoolean4 != null) {
                            z21 = observableBoolean4.get();
                        } else {
                            z21 = false;
                        }
                        if ((j & 416) != 0) {
                            if (z21) {
                                j7 = j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                                j6 = 67108864;
                            } else {
                                j7 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                                j6 = 33554432;
                            }
                            j = j7 | j6;
                        }
                        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
                            j = z21 ? j | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                        }
                        if ((j & 416) != 0) {
                            i4 = z21 ? getColorFromResource(this.mboundView10, R.color.dw_slate_RES_2131034238) : getColorFromResource(this.mboundView10, R.color.dw_battleship_grey_RES_2131034233);
                            str11 = z21 ? this.mboundView3.getResources().getString(R.string.cancel_RES_2131689505) : this.mboundView3.getResources().getString(R.string.done);
                        } else {
                            i4 = 0;
                            str11 = null;
                        }
                        z20 = !z21;
                        if ((j & 134217728) != 0) {
                            j = z20 ? j | 4194304 : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                        }
                        if ((j & 420) != 0) {
                            j |= z20 ? 16777216 : 8388608;
                        }
                        if ((j & 416) != 0) {
                            j |= z20 ? 1073741824 : 536870912;
                        }
                        if ((j & 416) != 0) {
                            i5 = getColorFromResource(this.mboundView6, z20 ? R.color.dw_slate_RES_2131034238 : R.color.dw_battleship_grey_RES_2131034233);
                        } else {
                            i5 = 0;
                        }
                    } else {
                        i5 = 0;
                        i4 = 0;
                        str11 = null;
                        observableBoolean4 = null;
                        z21 = false;
                        z20 = false;
                    }
                    if ((j & 485) == 0) {
                        if (checkInShortcutViewModel != null) {
                            observableBoolean5 = checkInShortcutViewModel.isEditMode();
                            i6 = i5;
                        } else {
                            i6 = i5;
                            observableBoolean5 = null;
                        }
                        updateRegistration(6, observableBoolean5);
                        if (observableBoolean5 != null) {
                            z8 = observableBoolean5.get();
                        } else {
                            z8 = false;
                        }
                        if ((j & 452) != 0) {
                            j = z8 ? j | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID : j | 512;
                        }
                        boolean z24 = !z8;
                        if ((j & 485) != 0) {
                            j = z24 ? j | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                        }
                        z7 = z24;
                        i2 = i6;
                        z = z17;
                        z2 = z18;
                        list = list4;
                        z3 = z16;
                        list2 = list3;
                        observableField = observableField6;
                        str = str9;
                        z4 = z20;
                        z5 = z21;
                        observableBoolean = observableBoolean4;
                        str2 = str10;
                        str3 = str11;
                        i = i4;
                        z6 = z19;
                        observableField2 = observableField5;
                    } else {
                        i2 = i5;
                        z8 = false;
                        z = z17;
                        z2 = z18;
                        list = list4;
                        z3 = z16;
                        list2 = list3;
                        observableField = observableField6;
                        str = str9;
                        z4 = z20;
                        z5 = z21;
                        observableBoolean = observableBoolean4;
                        str2 = str10;
                        str3 = str11;
                        i = i4;
                        z6 = z19;
                        observableField2 = observableField5;
                        z7 = false;
                    }
                }
            }
            z19 = false;
            i3 = ((j & 400) > 0 ? 1 : ((j & 400) == 0 ? 0 : -1));
            if (i3 == 0) {
            }
            if ((j & 420) == 0) {
            }
            if ((j & 485) == 0) {
            }
        } else {
            z8 = false;
            i2 = 0;
            z7 = false;
            observableField2 = null;
            z6 = false;
            i = 0;
            str3 = null;
            str2 = null;
            observableBoolean = null;
            z5 = false;
            z4 = false;
            str = null;
            observableField = null;
            list2 = null;
            z3 = false;
            list = null;
            z2 = false;
            z = false;
        }
        if ((j & 66048) != 0) {
            int i11 = ((j & 512) > 0 ? 1 : ((j & 512) == 0 ? 0 : -1));
            if (i11 != 0) {
                if (checkInShortcutViewModel != null) {
                    observableField = checkInShortcutViewModel.getFavouriteRowVMs();
                }
                observableField3 = observableField2;
                observableBoolean2 = observableBoolean;
                updateRegistration(2, observableField);
                if (observableField != null) {
                    list = observableField.get();
                }
                if (list != null) {
                    z2 = list.isEmpty();
                }
                if (i11 != 0) {
                    j = z2 ? j | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : j | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                }
                if (z2) {
                    j5 = j;
                    str8 = getRoot().getResources().getString(R.string.check_in_fav_empty_hint);
                } else {
                    j5 = j;
                    str8 = getRoot().getResources().getString(R.string.check_in_fav_view_hint);
                }
                observableField = observableField;
                str4 = str8;
                j = j5;
            } else {
                observableField3 = observableField2;
                observableBoolean2 = observableBoolean;
                str4 = null;
            }
            if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
                if (checkInShortcutViewModel != null) {
                    observableBoolean3 = checkInShortcutViewModel.isHistoryView();
                    str7 = str4;
                } else {
                    str7 = str4;
                    observableBoolean3 = observableBoolean2;
                }
                updateRegistration(5, observableBoolean3);
                if (observableBoolean3 != null) {
                    z5 = observableBoolean3.get();
                }
                if ((j & 416) != 0) {
                    if (z5) {
                        j4 = j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                        j3 = 67108864;
                    } else {
                        j4 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                        j3 = 33554432;
                    }
                    j = j4 | j3;
                }
                if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
                    j = z5 ? j | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                }
                str4 = str7;
            }
        } else {
            observableField3 = observableField2;
            str4 = null;
        }
        if ((j & 452) == 0) {
            str4 = null;
        } else if (z8) {
            str4 = getRoot().getResources().getString(R.string.check_in_fav_edit_hint);
        }
        if ((j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
            if (checkInShortcutViewModel != null) {
                observableField4 = checkInShortcutViewModel.getHistoryRowVMs();
                z9 = z4;
            } else {
                z9 = z4;
                observableField4 = observableField3;
            }
            updateRegistration(0, observableField4);
            if (observableField4 != null) {
                list2 = observableField4.get();
            }
            if (list2 != null) {
                z3 = list2.isEmpty();
            }
            z10 = !z3;
        } else {
            z9 = z4;
            z10 = false;
        }
        int i12 = ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) > 0 ? 1 : ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) == 0 ? 0 : -1));
        if (i12 != 0) {
            if (!z5) {
                z10 = false;
            }
            if (i12 != 0) {
                j = z10 ? j | 268435456 : j | 134217728;
            }
        } else {
            z10 = false;
        }
        int i13 = ((j & 134217728) > 0 ? 1 : ((j & 134217728) == 0 ? 0 : -1));
        if (i13 != 0) {
            z9 = !z5;
            if (i13 != 0) {
                j = z9 ? j | 4194304 : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            if ((j & 420) != 0) {
                j |= z9 ? 16777216 : 8388608;
            }
            if ((j & 416) != 0) {
                j |= z9 ? 1073741824 : 536870912;
            }
        }
        if ((j & 20971520) != 0) {
            if (checkInShortcutViewModel != null) {
                observableField = checkInShortcutViewModel.getFavouriteRowVMs();
            }
            z11 = z3;
            updateRegistration(2, observableField);
            if (observableField != null) {
                list = observableField.get();
            }
            if (list != null) {
                z2 = list.isEmpty();
            }
            j2 = 0;
            if ((j & 512) != 0) {
                j = z2 ? j | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : j | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            if ((j & 4194304) != 0) {
                z = !z2;
            }
        } else {
            z11 = z3;
            j2 = 0;
        }
        boolean z25 = ((j & 134217728) == j2 || !z9) ? false : z;
        int i14 = ((j & 420) > j2 ? 1 : ((j & 420) == j2 ? 0 : -1));
        if (i14 != 0) {
            if (!z9) {
                z2 = false;
            }
            z12 = z25;
            z13 = z2;
        } else {
            z12 = z25;
            z13 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) == j2) {
            z12 = false;
        } else if (z10) {
            z12 = true;
        }
        int i15 = ((j & 485) > j2 ? 1 : ((j & 485) == j2 ? 0 : -1));
        if (i15 != 0) {
            if (!z7) {
                z12 = false;
            }
            z14 = z13;
            z15 = z12;
        } else {
            z14 = z13;
            z15 = false;
        }
        if ((j & 256) != j2) {
            str6 = str2;
            str5 = str4;
            this.backButton.setOnClickListener(this.mCallback20);
            this.editButton.setOnClickListener(this.mCallback23);
            this.mboundView2.setOnClickListener(this.mCallback21);
            this.mboundView3.setOnClickListener(this.mCallback22);
            this.mboundView5.setOnClickListener(this.mCallback24);
            this.mboundView9.setOnClickListener(this.mCallback25);
        } else {
            str5 = str4;
            str6 = str2;
        }
        if ((j & 448) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.backButton, z7);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView2, z8);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView3, z8);
        }
        if ((392 & j) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.deleteButton, z6);
        }
        if (i15 != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.editButton, z15);
        }
        if ((388 & j) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.favouriteList, z);
        }
        if ((j & 416) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.historyListContainer, z5);
            this.mboundView10.setTextColor(i);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView11, z5);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView12, z9);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView13, z9);
            TextViewBindingAdapter.setText(this.mboundView3, str3);
            this.mboundView6.setTextColor(i2);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView7, z9);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView8, z5);
        }
        if ((j & 452) != 0) {
            this.mboundView141.setInfo(str5);
        }
        if ((400 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView17, str6);
        }
        if ((j & 385) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.mboundView17, z11);
        }
        if (i14 != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.mboundView18, z14);
        }
        if ((j & 386) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, str);
        }
        executeBindingsOn(this.mboundView141);
    }

    @Override // com.digitalwallet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = true;
        switch (i) {
            case 1:
                CheckInShortcutViewModel checkInShortcutViewModel = this.mVm;
                if (checkInShortcutViewModel == null) {
                    z = false;
                }
                if (z) {
                    checkInShortcutViewModel.goBack();
                    return;
                }
                return;
            case 2:
                CheckInShortcutViewModel checkInShortcutViewModel2 = this.mVm;
                if (checkInShortcutViewModel2 == null) {
                    z = false;
                }
                if (z) {
                    checkInShortcutViewModel2.selectOrDeselectAllEdits();
                    return;
                }
                return;
            case 3:
                CheckInShortcutViewModel checkInShortcutViewModel3 = this.mVm;
                if (checkInShortcutViewModel3 == null) {
                    z = false;
                }
                if (z) {
                    checkInShortcutViewModel3.cancelEditing();
                    return;
                }
                return;
            case 4:
                CheckInShortcutViewModel checkInShortcutViewModel4 = this.mVm;
                if (checkInShortcutViewModel4 == null) {
                    z = false;
                }
                if (z) {
                    checkInShortcutViewModel4.startEditing();
                    return;
                }
                return;
            case 5:
                CheckInShortcutViewModel checkInShortcutViewModel5 = this.mVm;
                if (checkInShortcutViewModel5 == null) {
                    z = false;
                }
                if (z) {
                    checkInShortcutViewModel5.selectFavouritesTab();
                    return;
                }
                return;
            case 6:
                CheckInShortcutViewModel checkInShortcutViewModel6 = this.mVm;
                if (checkInShortcutViewModel6 == null) {
                    z = false;
                }
                if (z) {
                    checkInShortcutViewModel6.selectHistoryTab();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
