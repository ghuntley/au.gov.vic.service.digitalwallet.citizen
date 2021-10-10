package com.digitalwallet.app.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.view.util.BindingAdaptersKt;
import com.digitalwallet.app.viewmodel.main.sharing.IncomingRequestFragmentViewModel;

public class FragmentIncomingRequestBindingImpl extends FragmentIncomingRequestBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback33;
    private final View.OnClickListener mCallback34;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView2;
    private final LinearLayout mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final LinearLayout mboundView6;
    private final TextView mboundView7;
    private final Button mboundView8;
    private final Button mboundView9;

    public FragmentIncomingRequestBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private FragmentIncomingRequestBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (FrameLayout) objArr[1]);
        this.mDirtyFlags = -1;
        this.authorityInfoContainer.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[3];
        this.mboundView3 = linearLayout;
        linearLayout.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.mboundView4 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[5];
        this.mboundView5 = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[6];
        this.mboundView6 = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView4 = (TextView) objArr[7];
        this.mboundView7 = textView4;
        textView4.setTag(null);
        Button button = (Button) objArr[8];
        this.mboundView8 = button;
        button.setTag(null);
        Button button2 = (Button) objArr[9];
        this.mboundView9 = button2;
        button2.setTag(null);
        setRootTag(view);
        this.mCallback33 = new OnClickListener(this, 1);
        this.mCallback34 = new OnClickListener(this, 2);
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
        setVm((IncomingRequestFragmentViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentIncomingRequestBinding
    public void setVm(IncomingRequestFragmentViewModel incomingRequestFragmentViewModel) {
        this.mVm = incomingRequestFragmentViewModel;
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
            return onChangeVmInTransition((ObservableField) obj, i2);
        }
        if (i == 1) {
            return onChangeVmCenterText((ObservableField) obj, i2);
        }
        if (i == 2) {
            return onChangeVmCenterImg((ObservableField) obj, i2);
        }
        if (i == 3) {
            return onChangeVmAuthorityName((ObservableField) obj, i2);
        }
        if (i == 4) {
            return onChangeVmSharingHint((ObservableField) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return onChangeVmAuthorityIdentifier((ObservableField) obj, i2);
    }

    private boolean onChangeVmInTransition(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmCenterText(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmCenterImg(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmAuthorityName(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmSharingHint(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeVmAuthorityIdentifier(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ea  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        String str4;
        String str5;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        IncomingRequestFragmentViewModel incomingRequestFragmentViewModel = this.mVm;
        if ((255 & j) != 0) {
            int i9 = ((j & 193) > 0 ? 1 : ((j & 193) == 0 ? 0 : -1));
            if (i9 != 0) {
                ObservableField<Boolean> inTransition = incomingRequestFragmentViewModel != null ? incomingRequestFragmentViewModel.getInTransition() : null;
                updateRegistration(0, inTransition);
                boolean safeUnbox = ViewDataBinding.safeUnbox(inTransition != null ? inTransition.get() : null);
                if (i9 != 0) {
                    if (safeUnbox) {
                        j3 = j | 512;
                        j2 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    } else {
                        j3 = j | 256;
                        j2 = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    }
                    j = j3 | j2;
                }
                i6 = 8;
                i5 = safeUnbox ? 0 : 8;
                if (!safeUnbox) {
                    i6 = 0;
                }
            } else {
                i6 = 0;
                i5 = 0;
            }
            if ((j & 194) != 0) {
                ObservableField<Integer> centerText = incomingRequestFragmentViewModel != null ? incomingRequestFragmentViewModel.getCenterText() : null;
                updateRegistration(1, centerText);
                i7 = ViewDataBinding.safeUnbox(centerText != null ? centerText.get() : null);
            } else {
                i7 = 0;
            }
            if ((j & 196) != 0) {
                ObservableField<Integer> centerImg = incomingRequestFragmentViewModel != null ? incomingRequestFragmentViewModel.getCenterImg() : null;
                updateRegistration(2, centerImg);
                i8 = ViewDataBinding.safeUnbox(centerImg != null ? centerImg.get() : null);
            } else {
                i8 = 0;
            }
            if ((j & 200) != 0) {
                ObservableField<String> authorityName = incomingRequestFragmentViewModel != null ? incomingRequestFragmentViewModel.getAuthorityName() : null;
                updateRegistration(3, authorityName);
                if (authorityName != null) {
                    str4 = authorityName.get();
                    if ((j & 208) != 0) {
                        ObservableField<String> sharingHint = incomingRequestFragmentViewModel != null ? incomingRequestFragmentViewModel.getSharingHint() : null;
                        updateRegistration(4, sharingHint);
                        if (sharingHint != null) {
                            str5 = sharingHint.get();
                            if ((j & 224) != 0) {
                                ObservableField<String> authorityIdentifier = incomingRequestFragmentViewModel != null ? incomingRequestFragmentViewModel.getAuthorityIdentifier() : null;
                                updateRegistration(5, authorityIdentifier);
                                if (authorityIdentifier != null) {
                                    str2 = authorityIdentifier.get();
                                    str = str5;
                                    i4 = i5;
                                    str3 = str4;
                                    i = i7;
                                    i2 = i6;
                                    i3 = i8;
                                }
                            }
                            str = str5;
                            i4 = i5;
                            str2 = null;
                            str3 = str4;
                            i = i7;
                            i2 = i6;
                            i3 = i8;
                        }
                    }
                    str5 = null;
                    if ((j & 224) != 0) {
                    }
                    str = str5;
                    i4 = i5;
                    str2 = null;
                    str3 = str4;
                    i = i7;
                    i2 = i6;
                    i3 = i8;
                }
            }
            str4 = null;
            if ((j & 208) != 0) {
            }
            str5 = null;
            if ((j & 224) != 0) {
            }
            str = str5;
            i4 = i5;
            str2 = null;
            str3 = str4;
            i = i7;
            i2 = i6;
            i3 = i8;
        } else {
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((j & 193) != 0) {
            this.authorityInfoContainer.setVisibility(i2);
            this.mboundView2.setVisibility(i4);
            this.mboundView3.setVisibility(i2);
            this.mboundView6.setVisibility(i2);
        }
        if ((j & 196) != 0) {
            BindingAdaptersKt.setDrawableTop(this.mboundView2, i3);
        }
        if ((194 & j) != 0) {
            this.mboundView2.setText(i);
        }
        if ((j & 200) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str3);
        }
        if ((224 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView5, str2);
        }
        if ((208 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView7, str);
        }
        if ((j & 128) != 0) {
            this.mboundView8.setOnClickListener(this.mCallback33);
            this.mboundView9.setOnClickListener(this.mCallback34);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            IncomingRequestFragmentViewModel incomingRequestFragmentViewModel = this.mVm;
            if (incomingRequestFragmentViewModel != null) {
                z = true;
            }
            if (z) {
                incomingRequestFragmentViewModel.dismiss();
            }
        } else if (i == 2) {
            IncomingRequestFragmentViewModel incomingRequestFragmentViewModel2 = this.mVm;
            if (incomingRequestFragmentViewModel2 != null) {
                z = true;
            }
            if (z) {
                incomingRequestFragmentViewModel2.share();
            }
        }
    }
}
