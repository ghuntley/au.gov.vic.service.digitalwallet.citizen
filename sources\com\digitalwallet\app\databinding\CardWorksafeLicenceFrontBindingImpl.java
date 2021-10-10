package com.digitalwallet.app.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.model.DrawableAsset;
import com.digitalwallet.app.model.HoldingAssets;
import com.digitalwallet.app.model.HoldingRecordAttributes;

public class CardWorksafeLicenceFrontBindingImpl extends CardWorksafeLicenceFrontBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView6;
    private final TextView mboundView7;
    private final TextView mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.header, 10);
        sparseIntArray.put(R.id.right_details, 11);
    }

    public CardWorksafeLicenceFrontBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private CardWorksafeLicenceFrontBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (LinearLayout) objArr[10], (ImageView) objArr[9], (LinearLayout) objArr[11]);
        this.mDirtyFlags = -1;
        this.identificationPhoto.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.mboundView2 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.mboundView3 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[4];
        this.mboundView4 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[5];
        this.mboundView5 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[6];
        this.mboundView6 = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[7];
        this.mboundView7 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[8];
        this.mboundView8 = textView8;
        textView8.setTag(null);
        setRootTag(view);
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
        if (8257537 == i) {
            setAssets((HoldingAssets) obj);
        } else if (8257543 != i) {
            return false;
        } else {
            setVm((HoldingRecordAttributes) obj);
        }
        return true;
    }

    @Override // com.digitalwallet.app.databinding.CardWorksafeLicenceFrontBinding
    public void setAssets(HoldingAssets holdingAssets) {
        this.mAssets = holdingAssets;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.assets);
        super.requestRebind();
    }

    @Override // com.digitalwallet.app.databinding.CardWorksafeLicenceFrontBinding
    public void setVm(HoldingRecordAttributes holdingRecordAttributes) {
        this.mVm = holdingRecordAttributes;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeAssetsMapPhoto((DrawableAsset) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeAssetsMap((ObservableArrayMap) obj, i2);
    }

    private boolean onChangeAssetsMapPhoto(DrawableAsset drawableAsset, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i != 8257538) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
    }

    private boolean onChangeAssetsMap(ObservableArrayMap<String, DrawableAsset> observableArrayMap, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HoldingAssets holdingAssets = this.mAssets;
        HoldingRecordAttributes holdingRecordAttributes = this.mVm;
        int i2 = ((55 & j) > 0 ? 1 : ((55 & j) == 0 ? 0 : -1));
        String str8 = null;
        if (i2 != 0) {
            ObservableArrayMap<String, DrawableAsset> map = holdingAssets != null ? holdingAssets.getMap() : null;
            updateRegistration(1, map);
            DrawableAsset drawableAsset = map != null ? map.get("photo") : null;
            updateRegistration(0, drawableAsset);
            if (drawableAsset != null) {
                drawable = drawableAsset.getDrawable();
                i = ((j & 40) > 0 ? 1 : ((j & 40) == 0 ? 0 : -1));
                if (i != 0 || holdingRecordAttributes == null) {
                    str7 = null;
                    str6 = null;
                    str5 = null;
                    str4 = null;
                    str3 = null;
                    str2 = null;
                    str = null;
                } else {
                    String dobFormatted = holdingRecordAttributes.getDobFormatted();
                    String holdingState = holdingRecordAttributes.getHoldingState();
                    str6 = holdingRecordAttributes.getExpiryDateFormatted();
                    String subtypeDisplayName = holdingRecordAttributes.getSubtypeDisplayName();
                    str3 = holdingRecordAttributes.getStartTimeFormatted();
                    str2 = holdingRecordAttributes.getIdentifier();
                    str = holdingRecordAttributes.getLicenceClass();
                    str4 = holdingRecordAttributes.getFullNameCapitalized();
                    str5 = holdingState;
                    str7 = dobFormatted;
                    str8 = subtypeDisplayName;
                }
                if (i2 != 0) {
                    ImageViewBindingAdapter.setImageDrawable(this.identificationPhoto, drawable);
                }
                if (i == 0) {
                    TextViewBindingAdapter.setText(this.mboundView1, str8);
                    TextViewBindingAdapter.setText(this.mboundView2, str4);
                    TextViewBindingAdapter.setText(this.mboundView3, str7);
                    TextViewBindingAdapter.setText(this.mboundView4, str2);
                    TextViewBindingAdapter.setText(this.mboundView5, str);
                    TextViewBindingAdapter.setText(this.mboundView6, str3);
                    TextViewBindingAdapter.setText(this.mboundView7, str6);
                    TextViewBindingAdapter.setText(this.mboundView8, str5);
                    return;
                }
                return;
            }
        }
        drawable = null;
        i = ((j & 40) > 0 ? 1 : ((j & 40) == 0 ? 0 : -1));
        if (i != 0) {
        }
        str7 = null;
        str6 = null;
        str5 = null;
        str4 = null;
        str3 = null;
        str2 = null;
        str = null;
        if (i2 != 0) {
        }
        if (i == 0) {
        }
    }
}
