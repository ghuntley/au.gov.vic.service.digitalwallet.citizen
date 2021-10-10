package com.digitalwallet.app.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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
import com.digitalwallet.app.model.transaction.TransactionHistoryItem;
import com.digitalwallet.app.view.util.AccountDetailsScreenState;
import com.digitalwallet.app.view.util.BindingAdaptersKt;
import com.digitalwallet.app.viewmodel.main.AccountDetailsFragmentViewModel;
import java.util.List;

public class FragmentAccountDetailsBindingImpl extends FragmentAccountDetailsBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback70;
    private final View.OnClickListener mCallback71;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final LinearLayout mboundView1;
    private final LinearLayout mboundView2;
    private final Button mboundView3;
    private final ProgressBar mboundView4;
    private final TextView mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.account_details_recycler_view, 11);
        sparseIntArray.put(R.id.error_text, 12);
    }

    public FragmentAccountDetailsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private FragmentAccountDetailsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (RecyclerView) objArr[11], (ConstraintLayout) objArr[8], (TextView) objArr[12], (TextView) objArr[5], (LinearLayout) objArr[7], (ProgressBar) objArr[10], (Button) objArr[9]);
        this.mDirtyFlags = -1;
        this.errorMsgView.setTag(null);
        this.historyErrorText.setTag(null);
        this.historyItems.setTag(null);
        this.loadingHud.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[2];
        this.mboundView2 = linearLayout2;
        linearLayout2.setTag(null);
        Button button = (Button) objArr[3];
        this.mboundView3 = button;
        button.setTag(null);
        ProgressBar progressBar = (ProgressBar) objArr[4];
        this.mboundView4 = progressBar;
        progressBar.setTag(null);
        TextView textView = (TextView) objArr[6];
        this.mboundView6 = textView;
        textView.setTag(null);
        this.tryAgainButton.setTag(null);
        setRootTag(view);
        this.mCallback70 = new OnClickListener(this, 1);
        this.mCallback71 = new OnClickListener(this, 2);
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
        setVm((AccountDetailsFragmentViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentAccountDetailsBinding
    public void setVm(AccountDetailsFragmentViewModel accountDetailsFragmentViewModel) {
        this.mVm = accountDetailsFragmentViewModel;
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
            return onChangeVmErrorTransHistory((ObservableBoolean) obj, i2);
        }
        if (i == 1) {
            return onChangeVmTransHistoryItems((ObservableField) obj, i2);
        }
        if (i == 2) {
            return onChangeVmScreenState((ObservableField) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return onChangeVmLoadingTransHistory((ObservableBoolean) obj, i2);
    }

    private boolean onChangeVmErrorTransHistory(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmTransHistoryItems(ObservableField<List<TransactionHistoryItem>> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmScreenState(ObservableField<AccountDetailsScreenState> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmLoadingTransHistory(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r31v0, types: [com.digitalwallet.app.databinding.FragmentAccountDetailsBindingImpl] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0125  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        SpannableStringBuilder spannableStringBuilder;
        boolean z;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i3;
        boolean z8;
        boolean z9;
        int i4;
        int i5;
        SpannableStringBuilder spannableStringBuilder2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AccountDetailsFragmentViewModel accountDetailsFragmentViewModel = ((FragmentAccountDetailsBindingImpl) this).mVm;
        List<TransactionHistoryItem> list = null;
        if ((63 & j) != 0) {
            if ((j & 48) == 0 || accountDetailsFragmentViewModel == null) {
                spannableStringBuilder2 = null;
                z4 = false;
            } else {
                z4 = accountDetailsFragmentViewModel.isCitizen();
                spannableStringBuilder2 = accountDetailsFragmentViewModel.getTransHistoryErrorDescription();
            }
            int i6 = ((j & 52) > 0 ? 1 : ((j & 52) == 0 ? 0 : -1));
            if (i6 != 0) {
                ObservableField<AccountDetailsScreenState> screenState = accountDetailsFragmentViewModel != null ? accountDetailsFragmentViewModel.getScreenState() : null;
                updateRegistration(2, screenState);
                AccountDetailsScreenState accountDetailsScreenState = screenState != null ? screenState.get() : null;
                boolean z10 = accountDetailsScreenState == AccountDetailsScreenState.ERROR;
                boolean z11 = accountDetailsScreenState == AccountDetailsScreenState.LOADING;
                z2 = accountDetailsScreenState == AccountDetailsScreenState.SHOW_ATTRIBUTES;
                if (i6 != 0) {
                    j |= z10 ? 128 : 64;
                }
                if ((j & 52) != 0) {
                    j |= z11 ? 512 : 256;
                }
                i2 = 8;
                i = z10 ? 0 : 8;
                if (z11) {
                    i2 = 0;
                }
            } else {
                z2 = false;
                i2 = 0;
                i = 0;
            }
            if ((j & 59) != 0) {
                ObservableBoolean loadingTransHistory = accountDetailsFragmentViewModel != null ? accountDetailsFragmentViewModel.getLoadingTransHistory() : null;
                updateRegistration(3, loadingTransHistory);
                if (loadingTransHistory != null) {
                    z3 = loadingTransHistory.get();
                } else {
                    z3 = false;
                }
                z = !z3;
                if ((j & 57) != 0) {
                    j |= z ? PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : PlaybackStateCompat.ACTION_PREPARE;
                }
                if ((j & 59) != 0) {
                    j = z ? j | PlaybackStateCompat.ACTION_PREPARE_FROM_URI : j | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                }
                spannableStringBuilder = spannableStringBuilder2;
                if ((j & 163840) == 0) {
                    ObservableBoolean errorTransHistory = accountDetailsFragmentViewModel != null ? accountDetailsFragmentViewModel.getErrorTransHistory() : null;
                    z7 = false;
                    updateRegistration(0, errorTransHistory);
                    if (errorTransHistory != null) {
                        z6 = errorTransHistory.get();
                    } else {
                        z6 = false;
                    }
                    z5 = (PlaybackStateCompat.ACTION_PREPARE_FROM_URI & j) != 0 ? !z6 : false;
                } else {
                    z7 = false;
                    z6 = false;
                    z5 = false;
                }
                if ((j & 57) == 0 || !z) {
                    z6 = z7;
                }
                i3 = ((j & 59) > 0 ? 1 : ((j & 59) == 0 ? 0 : -1));
                if (i3 == 0) {
                    if (!z) {
                        z5 = z7;
                    }
                    if (i3 != 0) {
                        j = z5 ? j | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH | PlaybackStateCompat.ACTION_PLAY_FROM_URI : j | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    }
                } else {
                    z5 = z7;
                }
                if ((j & 10240) == 0) {
                    ObservableField<List<TransactionHistoryItem>> transHistoryItems = accountDetailsFragmentViewModel != null ? accountDetailsFragmentViewModel.getTransHistoryItems() : null;
                    z9 = true;
                    updateRegistration(1, transHistoryItems);
                    if (transHistoryItems != null) {
                        list = transHistoryItems.get();
                    }
                    if (list != null) {
                        i5 = list.size();
                    } else {
                        i5 = z7;
                    }
                    z8 = ((j & PlaybackStateCompat.ACTION_PLAY_FROM_URI) == 0 || i5 != 0) ? z7 : true;
                    if ((j & PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == 0 || i5 <= 0) {
                        z9 = z7;
                    }
                } else {
                    z9 = z7;
                    z8 = z9;
                }
                i4 = ((j & 59) > 0 ? 1 : ((j & 59) == 0 ? 0 : -1));
                if (i4 == 0) {
                    if (!z5) {
                        z9 = z7;
                    }
                    if (!z5) {
                        z8 = z7;
                    }
                    z7 = z8;
                } else {
                    z9 = z7;
                }
                if ((52 & j) != 0) {
                    ((FragmentAccountDetailsBindingImpl) this).errorMsgView.setVisibility(i);
                    ((FragmentAccountDetailsBindingImpl) this).loadingHud.setVisibility(i2);
                    BindingAdaptersKt.setVisibleOrGone(this.mboundView1, z2);
                }
                if ((48 & j) != 0) {
                    TextViewBindingAdapter.setText(((FragmentAccountDetailsBindingImpl) this).historyErrorText, spannableStringBuilder);
                    BindingAdaptersKt.setVisibleOrGone(this.mboundView2, z4);
                }
                if ((57 & j) != 0) {
                    BindingAdaptersKt.setVisibleOrGone(((FragmentAccountDetailsBindingImpl) this).historyErrorText, z6);
                }
                if (i4 != 0) {
                    BindingAdaptersKt.setVisibleOrGone(((FragmentAccountDetailsBindingImpl) this).historyItems, z9);
                    BindingAdaptersKt.setVisibleOrGone(this.mboundView6, z7);
                }
                if ((32 & j) != 0) {
                    this.mboundView3.setOnClickListener(this.mCallback70);
                    ((FragmentAccountDetailsBindingImpl) this).tryAgainButton.setOnClickListener(this.mCallback71);
                }
                if ((j & 56) == 0) {
                    BindingAdaptersKt.setVisibleOrGone(this.mboundView4, z3);
                    return;
                }
                return;
            }
            spannableStringBuilder = spannableStringBuilder2;
            z3 = false;
        } else {
            spannableStringBuilder = null;
            z4 = false;
            z3 = false;
            z2 = false;
            i2 = 0;
            i = 0;
        }
        z = false;
        if ((j & 163840) == 0) {
        }
        z6 = z7;
        i3 = ((j & 59) > 0 ? 1 : ((j & 59) == 0 ? 0 : -1));
        if (i3 == 0) {
        }
        if ((j & 10240) == 0) {
        }
        i4 = ((j & 59) > 0 ? 1 : ((j & 59) == 0 ? 0 : -1));
        if (i4 == 0) {
        }
        if ((52 & j) != 0) {
        }
        if ((48 & j) != 0) {
        }
        if ((57 & j) != 0) {
        }
        if (i4 != 0) {
        }
        if ((32 & j) != 0) {
        }
        if ((j & 56) == 0) {
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            AccountDetailsFragmentViewModel accountDetailsFragmentViewModel = this.mVm;
            if (accountDetailsFragmentViewModel != null) {
                z = true;
            }
            if (z) {
                accountDetailsFragmentViewModel.edit();
            }
        } else if (i == 2) {
            AccountDetailsFragmentViewModel accountDetailsFragmentViewModel2 = this.mVm;
            if (accountDetailsFragmentViewModel2 != null) {
                z = true;
            }
            if (z) {
                accountDetailsFragmentViewModel2.reload();
            }
        }
    }
}
