package com.digitalwallet.app.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.model.AssetType;
import com.digitalwallet.app.model.DrawableAsset;
import com.digitalwallet.app.model.DynamicHoldingCardTemplate;
import com.digitalwallet.app.model.DynamicHoldingDisplay;
import com.digitalwallet.app.model.HoldingAssets;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.view.util.BindingAdaptersKt;

public class CardTemplate4FrontBindingImpl extends CardTemplate4FrontBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView2;
    private final TextView mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.holding_title, 4);
    }

    public CardTemplate4FrontBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private CardTemplate4FrontBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ConstraintLayout) objArr[4]);
        this.mDirtyFlags = -1;
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
        if (8257539 == i) {
            setHolding((SecureHolding) obj);
        } else if (8257537 != i) {
            return false;
        } else {
            setAssets((HoldingAssets) obj);
        }
        return true;
    }

    @Override // com.digitalwallet.app.databinding.CardTemplate4FrontBinding
    public void setHolding(SecureHolding secureHolding) {
        this.mHolding = secureHolding;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.holding);
        super.requestRebind();
    }

    @Override // com.digitalwallet.app.databinding.CardTemplate4FrontBinding
    public void setAssets(HoldingAssets holdingAssets) {
        this.mAssets = holdingAssets;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.assets);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeAssetsMapAssetTypeCardFrontJsonName((DrawableAsset) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeAssetsMap((ObservableArrayMap) obj, i2);
    }

    private boolean onChangeAssetsMapAssetTypeCardFrontJsonName(DrawableAsset drawableAsset, int i) {
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
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        String str;
        String str2;
        String str3;
        int i2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        SecureHolding secureHolding = this.mHolding;
        HoldingAssets holdingAssets = this.mAssets;
        int i3 = ((36 & j) > 0 ? 1 : ((36 & j) == 0 ? 0 : -1));
        Drawable drawable = null;
        if (i3 != 0) {
            DynamicHoldingDisplay dynamicDisplay = secureHolding != null ? secureHolding.getDynamicDisplay() : null;
            DynamicHoldingCardTemplate cardTemplate = dynamicDisplay != null ? dynamicDisplay.getCardTemplate() : null;
            if (cardTemplate != null) {
                str2 = cardTemplate.getTitle();
                str = cardTemplate.getLabel1();
                i = cardTemplate.getTextColor();
                str3 = cardTemplate.getValue1();
                i2 = ((59 & j) > 0 ? 1 : ((59 & j) == 0 ? 0 : -1));
                if (i2 != 0) {
                    String jsonName = AssetType.CardFront.getJsonName();
                    ObservableArrayMap<String, DrawableAsset> map = holdingAssets != null ? holdingAssets.getMap() : null;
                    updateRegistration(1, map);
                    DrawableAsset drawableAsset = map != null ? map.get(jsonName) : null;
                    updateRegistration(0, drawableAsset);
                    if (drawableAsset != null) {
                        drawable = drawableAsset.getDrawable();
                    }
                }
                if (i2 != 0) {
                    ViewBindingAdapter.setBackground(this.mboundView0, drawable);
                }
                if (i3 != 0) {
                    TextViewBindingAdapter.setText(this.mboundView1, str2);
                    this.mboundView1.setTextColor(i);
                    TextViewBindingAdapter.setText(this.mboundView2, str);
                    this.mboundView2.setTextColor(i);
                    TextViewBindingAdapter.setText(this.mboundView3, str3);
                    this.mboundView3.setTextColor(i);
                }
                if ((j & 32) == 0) {
                    BindingAdaptersKt.goneWhenEmpty(this.mboundView2, true);
                    BindingAdaptersKt.goneWhenEmpty(this.mboundView3, true);
                    return;
                }
                return;
            }
        }
        i = 0;
        str3 = null;
        str2 = null;
        str = null;
        i2 = ((59 & j) > 0 ? 1 : ((59 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
        }
        if (i2 != 0) {
        }
        if (i3 != 0) {
        }
        if ((j & 32) == 0) {
        }
    }
}
