package com.digitalwallet.app.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.view.util.BindingAdaptersKt;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyViewState;

public class FragmentLobbyBindingImpl extends FragmentLobbyBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback68;
    private final View.OnClickListener mCallback69;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final RelativeLayout mboundView1;
    private final TextView mboundView2;
    private final LinearLayout mboundView3;
    private final ProgressBar mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView6;
    private final Button mboundView7;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.header, 8);
        sparseIntArray.put(R.id.lobby_members, 9);
        sparseIntArray.put(R.id.footer, 10);
    }

    public FragmentLobbyBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private FragmentLobbyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (LinearLayout) objArr[10], (TextView) objArr[8], (RecyclerView) objArr[9]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        RelativeLayout relativeLayout2 = (RelativeLayout) objArr[1];
        this.mboundView1 = relativeLayout2;
        relativeLayout2.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[3];
        this.mboundView3 = linearLayout;
        linearLayout.setTag(null);
        ProgressBar progressBar = (ProgressBar) objArr[4];
        this.mboundView4 = progressBar;
        progressBar.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.mboundView5 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[6];
        this.mboundView6 = textView3;
        textView3.setTag(null);
        Button button = (Button) objArr[7];
        this.mboundView7 = button;
        button.setTag(null);
        setRootTag(view);
        this.mCallback69 = new OnClickListener(this, 2);
        this.mCallback68 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
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
        setVm((LobbyFragmentViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentLobbyBinding
    public void setVm(LobbyFragmentViewModel lobbyFragmentViewModel) {
        this.mVm = lobbyFragmentViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVmBtnText((ObservableField) obj, i2);
        }
        if (i == 1) {
            return onChangeVmShowBtn((ObservableBoolean) obj, i2);
        }
        if (i == 2) {
            return onChangeVmTitleImg((ObservableField) obj, i2);
        }
        if (i == 3) {
            return onChangeVmViewState((ObservableField) obj, i2);
        }
        if (i == 4) {
            return onChangeVmTitleText((ObservableField) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return onChangeVmSubtitleText((ObservableField) obj, i2);
    }

    private boolean onChangeVmBtnText(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmShowBtn(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmTitleImg(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmViewState(ObservableField<LobbyViewState> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmTitleText(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeVmSubtitleText(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00f2, code lost:
        if (r13 != false) goto L_0x00f7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0123  */
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
        int i11;
        int i12;
        boolean z;
        boolean z2;
        boolean z3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        LobbyFragmentViewModel lobbyFragmentViewModel = this.mVm;
        if ((255 & j) != 0) {
            if ((j & 193) != 0) {
                ObservableField<Integer> btnText = lobbyFragmentViewModel != null ? lobbyFragmentViewModel.getBtnText() : null;
                updateRegistration(0, btnText);
                i9 = ViewDataBinding.safeUnbox(btnText != null ? btnText.get() : null);
            } else {
                i9 = 0;
            }
            int i13 = ((j & 194) > 0 ? 1 : ((j & 194) == 0 ? 0 : -1));
            int i14 = 8;
            if (i13 != 0) {
                ObservableBoolean showBtn = lobbyFragmentViewModel != null ? lobbyFragmentViewModel.getShowBtn() : null;
                updateRegistration(1, showBtn);
                if (showBtn != null) {
                    z3 = showBtn.get();
                } else {
                    z3 = false;
                }
                if (i13 != 0) {
                    j |= z3 ? PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : PlaybackStateCompat.ACTION_PREPARE;
                }
                if (!z3) {
                    i10 = 8;
                    if ((j & 196) == 0) {
                        ObservableField<Integer> titleImg = lobbyFragmentViewModel != null ? lobbyFragmentViewModel.getTitleImg() : null;
                        updateRegistration(2, titleImg);
                        i5 = ViewDataBinding.safeUnbox(titleImg != null ? titleImg.get() : null);
                    } else {
                        i5 = 0;
                    }
                    i11 = ((j & 200) > 0 ? 1 : ((j & 200) == 0 ? 0 : -1));
                    if (i11 == 0) {
                        ObservableField<LobbyViewState> viewState = lobbyFragmentViewModel != null ? lobbyFragmentViewModel.getViewState() : null;
                        updateRegistration(3, viewState);
                        LobbyViewState lobbyViewState = viewState != null ? viewState.get() : null;
                        if (lobbyFragmentViewModel != null) {
                            z = lobbyFragmentViewModel.showUsers(lobbyViewState);
                            z2 = lobbyFragmentViewModel.isLoading(lobbyViewState);
                        } else {
                            z2 = false;
                            z = false;
                        }
                        if (i11 != 0) {
                            j |= z ? PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                        }
                        if ((j & 200) != 0) {
                            j |= z2 ? 512 : 256;
                        }
                        boolean z4 = !z;
                        i12 = z ? 0 : 8;
                        i = z2 ? 0 : 8;
                        if ((j & 200) != 0) {
                            j |= z4 ? PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                        }
                    } else {
                        i = 0;
                        i12 = 0;
                    }
                    i14 = 0;
                    if ((j & 208) == 0) {
                        ObservableField<Integer> titleText = lobbyFragmentViewModel != null ? lobbyFragmentViewModel.getTitleText() : null;
                        updateRegistration(4, titleText);
                        i4 = ViewDataBinding.safeUnbox(titleText != null ? titleText.get() : null);
                    } else {
                        i4 = 0;
                    }
                    if ((j & 224) == 0) {
                        ObservableField<Integer> subtitleText = lobbyFragmentViewModel != null ? lobbyFragmentViewModel.getSubtitleText() : null;
                        updateRegistration(5, subtitleText);
                        i3 = i9;
                        i2 = i10;
                        i6 = i12;
                        i7 = ViewDataBinding.safeUnbox(subtitleText != null ? subtitleText.get() : null);
                        i8 = i14;
                    } else {
                        i3 = i9;
                        i2 = i10;
                        i6 = i12;
                        i8 = i14;
                        i7 = 0;
                    }
                }
            }
            i10 = 0;
            if ((j & 196) == 0) {
            }
            i11 = ((j & 200) > 0 ? 1 : ((j & 200) == 0 ? 0 : -1));
            if (i11 == 0) {
            }
            i14 = 0;
            if ((j & 208) == 0) {
            }
            if ((j & 224) == 0) {
            }
        } else {
            i8 = 0;
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((j & 200) != 0) {
            this.mboundView1.setVisibility(i6);
            this.mboundView3.setVisibility(i8);
            this.mboundView4.setVisibility(i);
        }
        if ((128 & j) != 0) {
            this.mboundView2.setOnClickListener(this.mCallback68);
            this.mboundView7.setOnClickListener(this.mCallback69);
        }
        if ((196 & j) != 0) {
            BindingAdaptersKt.setDrawableTop(this.mboundView5, i5);
        }
        if ((208 & j) != 0) {
            this.mboundView5.setText(i4);
        }
        if ((224 & j) != 0) {
            this.mboundView6.setText(i7);
        }
        if ((193 & j) != 0) {
            this.mboundView7.setText(i3);
        }
        if ((j & 194) != 0) {
            this.mboundView7.setVisibility(i2);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            LobbyFragmentViewModel lobbyFragmentViewModel = this.mVm;
            if (lobbyFragmentViewModel != null) {
                z = true;
            }
            if (z) {
                lobbyFragmentViewModel.scan();
            }
        } else if (i == 2) {
            LobbyFragmentViewModel lobbyFragmentViewModel2 = this.mVm;
            if (lobbyFragmentViewModel2 != null) {
                z = true;
            }
            if (z) {
                lobbyFragmentViewModel2.handleBtnPress();
            }
        }
    }
}
