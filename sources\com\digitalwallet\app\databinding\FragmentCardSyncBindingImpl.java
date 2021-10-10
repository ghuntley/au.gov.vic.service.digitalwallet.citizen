package com.digitalwallet.app.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.view.util.BindingAdaptersKt;
import com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel;
import com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewState;

public class FragmentCardSyncBindingImpl extends FragmentCardSyncBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback44;
    private final View.OnClickListener mCallback45;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final LayoutTitleBarBinding mboundView1;
    private final LinearLayout mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final LinearLayout mboundView6;
    private final TextView mboundView7;
    private final View mboundView8;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(15);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_title_bar"}, new int[]{12}, new int[]{R.layout.layout_title_bar_RES_2114388042});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cancel_button_RES_2114322458, 13);
        sparseIntArray.put(R.id.footer, 14);
    }

    public FragmentCardSyncBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private FragmentCardSyncBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (Button) objArr[10], (Button) objArr[11], (TextView) objArr[13], (RecyclerView) objArr[9], (ConstraintLayout) objArr[14], (TextView) objArr[2], (ConstraintLayout) objArr[1]);
        this.mDirtyFlags = -1;
        this.btnPrimary.setTag(null);
        this.btnSecondary.setTag(null);
        this.cardRecyclerView.setTag(null);
        this.header.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        LayoutTitleBarBinding layoutTitleBarBinding = (LayoutTitleBarBinding) objArr[12];
        this.mboundView1 = layoutTitleBarBinding;
        setContainedBinding(layoutTitleBarBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[3];
        this.mboundView3 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.mboundView5 = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[6];
        this.mboundView6 = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView3 = (TextView) objArr[7];
        this.mboundView7 = textView3;
        textView3.setTag(null);
        View view2 = (View) objArr[8];
        this.mboundView8 = view2;
        view2.setTag(null);
        this.titleBar.setTag(null);
        setRootTag(view);
        this.mCallback45 = new OnClickListener(this, 2);
        this.mCallback44 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
        }
        this.mboundView1.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.mboundView1.hasPendingBindings() == false) goto L_0x0016;
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
        if (8257543 == i) {
            setVm((CardSyncViewModel) obj);
        } else if (8257536 != i) {
            return false;
        } else {
            setViewState((CardSyncViewState) obj);
        }
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentCardSyncBinding
    public void setVm(CardSyncViewModel cardSyncViewModel) {
        this.mVm = cardSyncViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    @Override // com.digitalwallet.app.databinding.FragmentCardSyncBinding
    public void setViewState(CardSyncViewState cardSyncViewState) {
        this.mViewState = cardSyncViewState;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView1.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVmViewState((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeVmHasAnyCardSelected((ObservableBoolean) obj, i2);
    }

    private boolean onChangeVmViewState(MutableLiveData<CardSyncViewState> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmHasAnyCardSelected(ObservableBoolean observableBoolean, int i) {
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
        boolean z;
        String str;
        boolean z2;
        CardSyncViewState cardSyncViewState;
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        MutableLiveData<CardSyncViewState> mutableLiveData;
        boolean z6;
        boolean z7;
        CardSyncViewState cardSyncViewState2;
        MutableLiveData<CardSyncViewState> mutableLiveData2;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CardSyncViewModel cardSyncViewModel = this.mVm;
        if ((23 & j) != 0) {
            int i2 = ((j & 21) > 0 ? 1 : ((j & 21) == 0 ? 0 : -1));
            if (i2 != 0) {
                mutableLiveData2 = cardSyncViewModel != null ? cardSyncViewModel.getViewState() : null;
                updateLiveDataRegistration(0, mutableLiveData2);
                cardSyncViewState2 = mutableLiveData2 != null ? mutableLiveData2.getValue() : null;
                z = cardSyncViewState2 == CardSyncViewState.NO_HOLDINGS;
                z5 = cardSyncViewState2 == CardSyncViewState.ERROR;
                z4 = cardSyncViewState2 == CardSyncViewState.LOADING;
                z3 = cardSyncViewState2 == CardSyncViewState.HOLDINGS;
                if (i2 != 0) {
                    j |= z ? PlaybackStateCompat.ACTION_PREPARE : PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                }
                if ((j & 21) != 0) {
                    j = z4 ? j | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : j | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                }
                if ((j & 21) != 0) {
                    j |= z3 ? 256 : 128;
                }
                str2 = this.header.getResources().getString(z3 ? R.string.add_card_selected_will_show : R.string.empty_string_RES_2114650224);
            } else {
                str2 = null;
                z5 = false;
                z4 = false;
                z3 = false;
                mutableLiveData2 = null;
                z = false;
                cardSyncViewState2 = null;
            }
            int i3 = ((j & 22) > 0 ? 1 : ((j & 22) == 0 ? 0 : -1));
            if (i3 != 0) {
                ObservableBoolean hasAnyCardSelected = cardSyncViewModel != null ? cardSyncViewModel.getHasAnyCardSelected() : null;
                z2 = true;
                updateRegistration(1, hasAnyCardSelected);
                if (hasAnyCardSelected != null) {
                    z6 = hasAnyCardSelected.get();
                } else {
                    z6 = false;
                }
                if (i3 != 0) {
                    j |= z6 ? PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID : 512;
                }
                i = getColorFromResource(this.btnPrimary, z6 ? R.color.dw_orange_RES_2114060292 : R.color.dw_orange_disabled_RES_2114060293);
                str = str2;
                mutableLiveData = mutableLiveData2;
                cardSyncViewState = cardSyncViewState2;
            } else {
                z2 = true;
                str = str2;
                mutableLiveData = mutableLiveData2;
                cardSyncViewState = cardSyncViewState2;
                z6 = false;
                i = 0;
            }
        } else {
            z2 = true;
            z6 = false;
            mutableLiveData = null;
            z5 = false;
            z4 = false;
            z3 = false;
            i = 0;
            cardSyncViewState = null;
            str = null;
            z = false;
        }
        boolean z8 = ((PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH & j) == 0 || cardSyncViewState != CardSyncViewState.STORING) ? false : z2;
        int i4 = ((j & 21) > 0 ? 1 : ((j & 21) == 0 ? 0 : -1));
        if (i4 != 0) {
            z7 = z ? z2 : z3;
            if (i4 != 0) {
                j |= z7 ? 64 : 32;
            }
        } else {
            z7 = false;
        }
        int i5 = ((j & 21) > 0 ? 1 : ((j & 21) == 0 ? 0 : -1));
        if (i5 == 0) {
            z8 = false;
        } else if (z4) {
            z8 = z2;
        }
        if (i5 == 0) {
            z2 = false;
        } else if (!z7) {
            z2 = z5;
        }
        if ((j & 22) != 0) {
            this.btnPrimary.setEnabled(z6);
            ViewBindingAdapter.setBackground(this.btnPrimary, Converters.convertColorToDrawable(i));
        }
        if ((j & 16) != 0) {
            this.btnPrimary.setOnClickListener(this.mCallback44);
            this.btnSecondary.setOnClickListener(this.mCallback45);
            this.mboundView1.setTitle(getRoot().getResources().getString(R.string.existing_cards));
        }
        if (i5 != 0) {
            BindingAdaptersKt.updateCardSyncPrimaryBtn(this.btnPrimary, mutableLiveData);
            BindingAdaptersKt.setVisibleOrGone(this.btnSecondary, z5);
            BindingAdaptersKt.setVisibleOrGone(this.cardRecyclerView, z3);
            TextViewBindingAdapter.setText(this.header, str);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView3, z8);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView4, z4);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView5, z4);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView6, z);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView7, z5);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView8, z3);
            BindingAdaptersKt.setVisibleOrGone(this.titleBar, z2);
        }
        executeBindingsOn(this.mboundView1);
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            CardSyncViewModel cardSyncViewModel = this.mVm;
            if (cardSyncViewModel != null) {
                z = true;
            }
            if (z) {
                cardSyncViewModel.performPrimaryBtnAction();
            }
        } else if (i == 2) {
            CardSyncViewModel cardSyncViewModel2 = this.mVm;
            if (cardSyncViewModel2 != null) {
                z = true;
            }
            if (z) {
                cardSyncViewModel2.performSecondaryBtnAction();
            }
        }
    }
}
