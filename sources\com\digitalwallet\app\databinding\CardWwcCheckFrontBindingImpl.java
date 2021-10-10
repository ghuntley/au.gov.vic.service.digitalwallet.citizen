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

public class CardWwcCheckFrontBindingImpl extends CardWwcCheckFrontBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.header, 6);
        sparseIntArray.put(R.id.licence_number, 7);
    }

    public CardWwcCheckFrontBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private CardWwcCheckFrontBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (View) objArr[6], (ImageView) objArr[5], (LinearLayout) objArr[7]);
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

    @Override // com.digitalwallet.app.databinding.CardWwcCheckFrontBinding
    public void setAssets(HoldingAssets holdingAssets) {
        this.mAssets = holdingAssets;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.assets);
        super.requestRebind();
    }

    @Override // com.digitalwallet.app.databinding.CardWwcCheckFrontBinding
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
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HoldingAssets holdingAssets = this.mAssets;
        HoldingRecordAttributes holdingRecordAttributes = this.mVm;
        int i2 = ((55 & j) > 0 ? 1 : ((55 & j) == 0 ? 0 : -1));
        String str7 = null;
        if (i2 != 0) {
            ObservableArrayMap<String, DrawableAsset> map = holdingAssets != null ? holdingAssets.getMap() : null;
            updateRegistration(1, map);
            DrawableAsset drawableAsset = map != null ? map.get("photo") : null;
            updateRegistration(0, drawableAsset);
            if (drawableAsset != null) {
                drawable = drawableAsset.getDrawable();
                i = ((j & 40) > 0 ? 1 : ((j & 40) == 0 ? 0 : -1));
                if (i == 0) {
                    if (holdingRecordAttributes != null) {
                        str6 = holdingRecordAttributes.getExpiryDateFormatted();
                        str5 = holdingRecordAttributes.getSubtypeDisplayName();
                        str4 = holdingRecordAttributes.getNameLastCapitalized();
                        str = holdingRecordAttributes.getIdentifier();
                    } else {
                        str6 = null;
                        str5 = null;
                        str4 = null;
                        str = null;
                    }
                    str3 = str6 != null ? str6.replace("/", "-") : null;
                    if (str5 != null) {
                        str7 = str5.toUpperCase();
                    }
                    str2 = str7;
                    str7 = str4;
                } else {
                    str3 = null;
                    str2 = null;
                    str = null;
                }
                if (i2 != 0) {
                    ImageViewBindingAdapter.setImageDrawable(this.identificationPhoto, drawable);
                }
                if (i == 0) {
                    TextViewBindingAdapter.setText(this.mboundView1, str7);
                    TextViewBindingAdapter.setText(this.mboundView2, str3);
                    TextViewBindingAdapter.setText(this.mboundView3, str2);
                    TextViewBindingAdapter.setText(this.mboundView4, str);
                    return;
                }
                return;
            }
        }
        drawable = null;
        i = ((j & 40) > 0 ? 1 : ((j & 40) == 0 ? 0 : -1));
        if (i == 0) {
        }
        if (i2 != 0) {
        }
        if (i == 0) {
        }
    }
}
