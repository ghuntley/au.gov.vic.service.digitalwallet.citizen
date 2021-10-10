package com.digitalwallet.app.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
import com.digitalwallet.app.viewmodel.main.history.TransactionHistoryFragmentViewModel;

public class FragmentTransactionHistoryBindingImpl extends FragmentTransactionHistoryBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback49;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.imageView2, 8);
    }

    public FragmentTransactionHistoryBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private FragmentTransactionHistoryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (ConstraintLayout) objArr[1], (ImageView) objArr[8], (ProgressBar) objArr[4], (ConstraintLayout) objArr[5], (Button) objArr[3], (TextView) objArr[6], (TextView) objArr[2], (RecyclerView) objArr[7]);
        this.mDirtyFlags = -1;
        this.errorMsgView.setTag(null);
        this.loadingHud.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.noTransactionView.setTag(null);
        this.notificationButton.setTag(null);
        this.textView5.setTag(null);
        this.textView6.setTag(null);
        this.transactionHistoryRecyclerView.setTag(null);
        setRootTag(view);
        this.mCallback49 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256;
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
        setVm((TransactionHistoryFragmentViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentTransactionHistoryBinding
    public void setVm(TransactionHistoryFragmentViewModel transactionHistoryFragmentViewModel) {
        this.mVm = transactionHistoryFragmentViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeVmNoTransactionText((ObservableField) obj, i2);
            case 1:
                return onChangeVmShowLoadingHUD((ObservableField) obj, i2);
            case 2:
                return onChangeVmShowHistoryList((ObservableField) obj, i2);
            case 3:
                return onChangeVmErrorText((ObservableField) obj, i2);
            case 4:
                return onChangeVmRetryButtonText((ObservableField) obj, i2);
            case 5:
                return onChangeVmShowErrorMsgView((ObservableField) obj, i2);
            case 6:
                return onChangeVmShowNoTransactionView((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeVmNoTransactionText(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmShowLoadingHUD(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmShowHistoryList(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmErrorText(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmRetryButtonText(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeVmShowErrorMsgView(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeVmShowNoTransactionView(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x014c  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        int i2;
        String str3;
        int i3;
        int i4;
        String str4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        TransactionHistoryFragmentViewModel transactionHistoryFragmentViewModel = this.mVm;
        if ((511 & j) != 0) {
            if ((j & 385) != 0) {
                ObservableField<Integer> noTransactionText = transactionHistoryFragmentViewModel != null ? transactionHistoryFragmentViewModel.getNoTransactionText() : null;
                updateRegistration(0, noTransactionText);
                str4 = getRoot().getContext().getString(ViewDataBinding.safeUnbox(noTransactionText != null ? noTransactionText.get() : null));
            } else {
                str4 = null;
            }
            int i10 = ((j & 386) > 0 ? 1 : ((j & 386) == 0 ? 0 : -1));
            int i11 = 8;
            if (i10 != 0) {
                ObservableField<Boolean> showLoadingHUD = transactionHistoryFragmentViewModel != null ? transactionHistoryFragmentViewModel.getShowLoadingHUD() : null;
                updateRegistration(1, showLoadingHUD);
                boolean safeUnbox = ViewDataBinding.safeUnbox(showLoadingHUD != null ? showLoadingHUD.get() : null);
                if (i10 != 0) {
                    j |= safeUnbox ? PlaybackStateCompat.ACTION_PREPARE : PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                }
                if (!safeUnbox) {
                    i5 = 8;
                    i6 = ((j & 388) > 0 ? 1 : ((j & 388) == 0 ? 0 : -1));
                    if (i6 != 0) {
                        ObservableField<Boolean> showHistoryList = transactionHistoryFragmentViewModel != null ? transactionHistoryFragmentViewModel.getShowHistoryList() : null;
                        updateRegistration(2, showHistoryList);
                        boolean safeUnbox2 = ViewDataBinding.safeUnbox(showHistoryList != null ? showHistoryList.get() : null);
                        if (i6 != 0) {
                            j |= safeUnbox2 ? PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID : 512;
                        }
                        if (!safeUnbox2) {
                            i2 = 8;
                            if ((j & 392) != 0) {
                                ObservableField<Integer> errorText = transactionHistoryFragmentViewModel != null ? transactionHistoryFragmentViewModel.getErrorText() : null;
                                updateRegistration(3, errorText);
                                str2 = getRoot().getContext().getString(ViewDataBinding.safeUnbox(errorText != null ? errorText.get() : null));
                            } else {
                                str2 = null;
                            }
                            if ((j & 400) != 0) {
                                ObservableField<Integer> retryButtonText = transactionHistoryFragmentViewModel != null ? transactionHistoryFragmentViewModel.getRetryButtonText() : null;
                                updateRegistration(4, retryButtonText);
                                str = getRoot().getContext().getString(ViewDataBinding.safeUnbox(retryButtonText != null ? retryButtonText.get() : null));
                            } else {
                                str = null;
                            }
                            i7 = ((j & 416) > 0 ? 1 : ((j & 416) == 0 ? 0 : -1));
                            if (i7 != 0) {
                                ObservableField<Boolean> showErrorMsgView = transactionHistoryFragmentViewModel != null ? transactionHistoryFragmentViewModel.getShowErrorMsgView() : null;
                                updateRegistration(5, showErrorMsgView);
                                boolean safeUnbox3 = ViewDataBinding.safeUnbox(showErrorMsgView != null ? showErrorMsgView.get() : null);
                                if (i7 != 0) {
                                    j |= safeUnbox3 ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                                }
                                if (!safeUnbox3) {
                                    i8 = 8;
                                    i9 = ((j & 448) > 0 ? 1 : ((j & 448) == 0 ? 0 : -1));
                                    if (i9 == 0) {
                                        ObservableField<Boolean> showNoTransactionView = transactionHistoryFragmentViewModel != null ? transactionHistoryFragmentViewModel.getShowNoTransactionView() : null;
                                        updateRegistration(6, showNoTransactionView);
                                        boolean safeUnbox4 = ViewDataBinding.safeUnbox(showNoTransactionView != null ? showNoTransactionView.get() : null);
                                        if (i9 != 0) {
                                            j |= safeUnbox4 ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                                        }
                                        if (safeUnbox4) {
                                            i11 = 0;
                                        }
                                        i4 = i5;
                                        i = i8;
                                        str3 = str4;
                                        i3 = i11;
                                    } else {
                                        i4 = i5;
                                        i = i8;
                                        str3 = str4;
                                        i3 = 0;
                                    }
                                }
                            }
                            i8 = 0;
                            i9 = ((j & 448) > 0 ? 1 : ((j & 448) == 0 ? 0 : -1));
                            if (i9 == 0) {
                            }
                        }
                    }
                    i2 = 0;
                    if ((j & 392) != 0) {
                    }
                    if ((j & 400) != 0) {
                    }
                    i7 = ((j & 416) > 0 ? 1 : ((j & 416) == 0 ? 0 : -1));
                    if (i7 != 0) {
                    }
                    i8 = 0;
                    i9 = ((j & 448) > 0 ? 1 : ((j & 448) == 0 ? 0 : -1));
                    if (i9 == 0) {
                    }
                }
            }
            i5 = 0;
            i6 = ((j & 388) > 0 ? 1 : ((j & 388) == 0 ? 0 : -1));
            if (i6 != 0) {
            }
            i2 = 0;
            if ((j & 392) != 0) {
            }
            if ((j & 400) != 0) {
            }
            i7 = ((j & 416) > 0 ? 1 : ((j & 416) == 0 ? 0 : -1));
            if (i7 != 0) {
            }
            i8 = 0;
            i9 = ((j & 448) > 0 ? 1 : ((j & 448) == 0 ? 0 : -1));
            if (i9 == 0) {
            }
        } else {
            i4 = 0;
            i3 = 0;
            str3 = null;
            i2 = 0;
            str2 = null;
            i = 0;
            str = null;
        }
        if ((j & 416) != 0) {
            this.errorMsgView.setVisibility(i);
        }
        if ((386 & j) != 0) {
            this.loadingHud.setVisibility(i4);
        }
        if ((448 & j) != 0) {
            this.noTransactionView.setVisibility(i3);
        }
        if ((256 & j) != 0) {
            this.notificationButton.setOnClickListener(this.mCallback49);
        }
        if ((j & 400) != 0) {
            TextViewBindingAdapter.setText(this.notificationButton, str);
        }
        if ((j & 385) != 0) {
            TextViewBindingAdapter.setText(this.textView5, str3);
        }
        if ((392 & j) != 0) {
            TextViewBindingAdapter.setText(this.textView6, str2);
        }
        if ((j & 388) != 0) {
            this.transactionHistoryRecyclerView.setVisibility(i2);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        TransactionHistoryFragmentViewModel transactionHistoryFragmentViewModel = this.mVm;
        if (transactionHistoryFragmentViewModel != null) {
            transactionHistoryFragmentViewModel.requestTransactionHistory();
        }
    }
}
