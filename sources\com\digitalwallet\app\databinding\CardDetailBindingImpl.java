package com.digitalwallet.app.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.model.DrawableAsset;
import com.digitalwallet.app.viewmodel.main.addsync.CardDetailItem;

public class CardDetailBindingImpl extends CardDetailBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback51;
    private final View.OnClickListener mCallback52;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public CardDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private CardDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (CheckBox) objArr[2], (ImageView) objArr[1], (TextView) objArr[4], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.cardCheckBox.setTag(null);
        this.cardIcon.setTag(null);
        this.expiryText.setTag(null);
        this.licenceName.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        this.mCallback52 = new OnClickListener(this, 2);
        this.mCallback51 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        setVm((CardDetailItem) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.CardDetailBinding
    public void setVm(CardDetailItem cardDetailItem) {
        this.mVm = cardDetailItem;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVmShouldUpdate((ObservableBoolean) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeVmDynamicAsset((DrawableAsset) obj, i2);
    }

    private boolean onChangeVmShouldUpdate(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmDynamicAsset(DrawableAsset drawableAsset, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i != 8257538) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String str;
        boolean z2;
        Drawable drawable;
        String str2;
        int i;
        Drawable drawable2;
        int i2;
        String str3;
        String str4;
        int i3;
        boolean z3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CardDetailItem cardDetailItem = this.mVm;
        Drawable drawable3 = null;
        if ((31 & j) != 0) {
            int i4 = ((j & 20) > 0 ? 1 : ((j & 20) == 0 ? 0 : -1));
            if (i4 != 0) {
                if (cardDetailItem != null) {
                    str4 = cardDetailItem.getTitle();
                    z3 = cardDetailItem.isHoldingExpired();
                    str3 = cardDetailItem.getExpiry();
                } else {
                    z3 = false;
                    str4 = null;
                    str3 = null;
                }
                if (i4 != 0) {
                    j |= z3 ? 256 : 128;
                }
                i = getColorFromResource(this.expiryText, z3 ? R.color.darkRed_RES_2114060290 : R.color.dw_battleship_grey_RES_2114060291);
            } else {
                i = 0;
                str4 = null;
                str3 = null;
            }
            if ((j & 21) != 0) {
                ObservableBoolean shouldUpdate = cardDetailItem != null ? cardDetailItem.getShouldUpdate() : null;
                updateRegistration(0, shouldUpdate);
                if (shouldUpdate != null) {
                    z2 = shouldUpdate.get();
                    i3 = ((j & 30) > 0 ? 1 : ((j & 30) == 0 ? 0 : -1));
                    if (i3 == 0) {
                        DrawableAsset dynamicAsset = cardDetailItem != null ? cardDetailItem.getDynamicAsset() : null;
                        updateRegistration(1, dynamicAsset);
                        if (dynamicAsset != null) {
                            drawable = dynamicAsset.getDrawable();
                        } else {
                            drawable = null;
                        }
                        z = drawable == null;
                        if (i3 != 0) {
                            j = z ? j | 64 : j | 32;
                        }
                        str2 = str4;
                        str = str3;
                        if ((64 & j) != 0 || cardDetailItem == null) {
                            drawable2 = null;
                        } else {
                            drawable2 = cardDetailItem.getEmbeddedIcon();
                        }
                        i2 = ((30 & j) > 0 ? 1 : ((30 & j) == 0 ? 0 : -1));
                        if (i2 != 0) {
                            drawable3 = z ? drawable2 : drawable;
                        }
                        if ((16 & j) != 0) {
                            this.cardCheckBox.setOnClickListener(this.mCallback52);
                            this.mboundView0.setOnClickListener(this.mCallback51);
                        }
                        if ((21 & j) != 0) {
                            CompoundButtonBindingAdapter.setChecked(this.cardCheckBox, z2);
                        }
                        if (i2 != 0) {
                            ImageViewBindingAdapter.setImageDrawable(this.cardIcon, drawable3);
                        }
                        if ((j & 20) == 0) {
                            this.expiryText.setTextColor(i);
                            TextViewBindingAdapter.setText(this.expiryText, str);
                            TextViewBindingAdapter.setText(this.licenceName, str2);
                            return;
                        }
                        return;
                    }
                    drawable = null;
                    str2 = str4;
                    str = str3;
                }
            }
            z2 = false;
            i3 = ((j & 30) > 0 ? 1 : ((j & 30) == 0 ? 0 : -1));
            if (i3 == 0) {
            }
        } else {
            str2 = null;
            drawable = null;
            str = null;
            i = 0;
            z2 = false;
        }
        z = false;
        if ((64 & j) != 0) {
        }
        drawable2 = null;
        i2 = ((30 & j) > 0 ? 1 : ((30 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
        }
        if ((16 & j) != 0) {
        }
        if ((21 & j) != 0) {
        }
        if (i2 != 0) {
        }
        if ((j & 20) == 0) {
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            CardDetailItem cardDetailItem = this.mVm;
            if (cardDetailItem != null) {
                z = true;
            }
            if (z) {
                cardDetailItem.toggleSelected();
            }
        } else if (i == 2) {
            CardDetailItem cardDetailItem2 = this.mVm;
            if (cardDetailItem2 != null) {
                z = true;
            }
            if (z) {
                cardDetailItem2.toggleSelected();
            }
        }
    }
}
