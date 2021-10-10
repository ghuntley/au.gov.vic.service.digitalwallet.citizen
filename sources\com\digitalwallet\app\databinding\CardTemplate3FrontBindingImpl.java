package com.digitalwallet.app.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
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

public class CardTemplate3FrontBindingImpl extends CardTemplate3FrontBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView10;
    private final TextView mboundView11;
    private final TextView mboundView2;
    private final ImageView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView6;
    private final TextView mboundView7;
    private final TextView mboundView8;
    private final TextView mboundView9;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.holding_title, 12);
    }

    public CardTemplate3FrontBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private CardTemplate3FrontBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ConstraintLayout) objArr[12]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[10];
        this.mboundView10 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[11];
        this.mboundView11 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[2];
        this.mboundView2 = textView4;
        textView4.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.mboundView3 = imageView;
        imageView.setTag(null);
        TextView textView5 = (TextView) objArr[4];
        this.mboundView4 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[5];
        this.mboundView5 = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[6];
        this.mboundView6 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[7];
        this.mboundView7 = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[8];
        this.mboundView8 = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) objArr[9];
        this.mboundView9 = textView10;
        textView10.setTag(null);
        setRootTag(view);
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
        if (8257537 == i) {
            setAssets((HoldingAssets) obj);
        } else if (8257539 != i) {
            return false;
        } else {
            setHolding((SecureHolding) obj);
        }
        return true;
    }

    @Override // com.digitalwallet.app.databinding.CardTemplate3FrontBinding
    public void setAssets(HoldingAssets holdingAssets) {
        this.mAssets = holdingAssets;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.assets);
        super.requestRebind();
    }

    @Override // com.digitalwallet.app.databinding.CardTemplate3FrontBinding
    public void setHolding(SecureHolding secureHolding) {
        this.mHolding = secureHolding;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.holding);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeAssetsMapAssetTypePhotoJsonName((DrawableAsset) obj, i2);
        }
        if (i == 1) {
            return onChangeAssetsMap((ObservableArrayMap) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeAssetsMapAssetTypeCardFrontJsonName((DrawableAsset) obj, i2);
    }

    private boolean onChangeAssetsMapAssetTypePhotoJsonName(DrawableAsset drawableAsset, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i != 8257538) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangeAssetsMapAssetTypeCardFrontJsonName(DrawableAsset drawableAsset, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i != 8257538) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        ObservableArrayMap<String, DrawableAsset> observableArrayMap;
        Drawable drawable;
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        int i2;
        int i3;
        Drawable drawable2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HoldingAssets holdingAssets = this.mAssets;
        SecureHolding secureHolding = this.mHolding;
        if ((239 & j) != 0) {
            observableArrayMap = holdingAssets != null ? holdingAssets.getMap() : null;
            updateRegistration(1, observableArrayMap);
        } else {
            observableArrayMap = null;
        }
        int i4 = ((171 & j) > 0 ? 1 : ((171 & j) == 0 ? 0 : -1));
        if (i4 != 0) {
            str = AssetType.Photo.getJsonName();
            DrawableAsset drawableAsset = observableArrayMap != null ? observableArrayMap.get(str) : null;
            updateRegistration(0, drawableAsset);
            if (drawableAsset != null) {
                drawable = drawableAsset.getDrawable();
                i = ((144 & j) > 0 ? 1 : ((144 & j) == 0 ? 0 : -1));
                if (i != 0) {
                    DynamicHoldingDisplay dynamicDisplay = secureHolding != null ? secureHolding.getDynamicDisplay() : null;
                    DynamicHoldingCardTemplate cardTemplate = dynamicDisplay != null ? dynamicDisplay.getCardTemplate() : null;
                    if (cardTemplate != null) {
                        str9 = cardTemplate.getTitle();
                        str8 = cardTemplate.getValue4();
                        str7 = cardTemplate.getValue2();
                        String value3 = cardTemplate.getValue3();
                        String value1 = cardTemplate.getValue1();
                        String main = cardTemplate.getMain();
                        String label3 = cardTemplate.getLabel3();
                        String label4 = cardTemplate.getLabel4();
                        String label1 = cardTemplate.getLabel1();
                        String label2 = cardTemplate.getLabel2();
                        i2 = cardTemplate.getTextColor();
                        str10 = value3;
                        str11 = value1;
                        str6 = main;
                        str5 = label3;
                        str4 = label4;
                        str3 = label1;
                        str2 = label2;
                        i3 = ((j & 206) > 0 ? 1 : ((j & 206) == 0 ? 0 : -1));
                        if (i3 != 0) {
                            DrawableAsset drawableAsset2 = observableArrayMap != null ? observableArrayMap.get(AssetType.CardFront.getJsonName()) : null;
                            updateRegistration(2, drawableAsset2);
                            if (drawableAsset2 != null) {
                                drawable2 = drawableAsset2.getDrawable();
                                if (i3 != 0) {
                                    ViewBindingAdapter.setBackground(this.mboundView0, drawable2);
                                }
                                if (i != 0) {
                                    TextViewBindingAdapter.setText(this.mboundView1, str9);
                                    this.mboundView1.setTextColor(i2);
                                    TextViewBindingAdapter.setText(this.mboundView10, str7);
                                    this.mboundView10.setTextColor(i2);
                                    TextViewBindingAdapter.setText(this.mboundView11, str8);
                                    this.mboundView11.setTextColor(i2);
                                    TextViewBindingAdapter.setText(this.mboundView2, str6);
                                    this.mboundView2.setTextColor(i2);
                                    TextViewBindingAdapter.setText(this.mboundView4, str3);
                                    this.mboundView4.setTextColor(i2);
                                    TextViewBindingAdapter.setText(this.mboundView5, str5);
                                    this.mboundView5.setTextColor(i2);
                                    TextViewBindingAdapter.setText(this.mboundView6, str11);
                                    this.mboundView6.setTextColor(i2);
                                    TextViewBindingAdapter.setText(this.mboundView7, str10);
                                    this.mboundView7.setTextColor(i2);
                                    TextViewBindingAdapter.setText(this.mboundView8, str2);
                                    this.mboundView8.setTextColor(i2);
                                    TextViewBindingAdapter.setText(this.mboundView9, str4);
                                    this.mboundView9.setTextColor(i2);
                                }
                                if ((j & 128) != 0) {
                                    BindingAdaptersKt.goneWhenEmpty(this.mboundView10, true);
                                    BindingAdaptersKt.goneWhenEmpty(this.mboundView11, true);
                                    BindingAdaptersKt.goneWhenEmpty(this.mboundView4, true);
                                    BindingAdaptersKt.goneWhenEmpty(this.mboundView5, true);
                                    BindingAdaptersKt.goneWhenEmpty(this.mboundView6, true);
                                    BindingAdaptersKt.goneWhenEmpty(this.mboundView7, true);
                                    BindingAdaptersKt.goneWhenEmpty(this.mboundView8, true);
                                    BindingAdaptersKt.goneWhenEmpty(this.mboundView9, true);
                                    if (getBuildSdkInt() >= 4) {
                                        this.mboundView3.setContentDescription(str);
                                    }
                                }
                                if (i4 == 0) {
                                    ImageViewBindingAdapter.setImageDrawable(this.mboundView3, drawable);
                                    return;
                                }
                                return;
                            }
                        }
                        drawable2 = null;
                        if (i3 != 0) {
                        }
                        if (i != 0) {
                        }
                        if ((j & 128) != 0) {
                        }
                        if (i4 == 0) {
                        }
                    }
                }
                i2 = 0;
                str11 = null;
                str10 = null;
                str9 = null;
                str8 = null;
                str7 = null;
                str6 = null;
                str5 = null;
                str4 = null;
                str3 = null;
                str2 = null;
                i3 = ((j & 206) > 0 ? 1 : ((j & 206) == 0 ? 0 : -1));
                if (i3 != 0) {
                }
                drawable2 = null;
                if (i3 != 0) {
                }
                if (i != 0) {
                }
                if ((j & 128) != 0) {
                }
                if (i4 == 0) {
                }
            }
        } else {
            str = null;
        }
        drawable = null;
        i = ((144 & j) > 0 ? 1 : ((144 & j) == 0 ? 0 : -1));
        if (i != 0) {
        }
        i2 = 0;
        str11 = null;
        str10 = null;
        str9 = null;
        str8 = null;
        str7 = null;
        str6 = null;
        str5 = null;
        str4 = null;
        str3 = null;
        str2 = null;
        i3 = ((j & 206) > 0 ? 1 : ((j & 206) == 0 ? 0 : -1));
        if (i3 != 0) {
        }
        drawable2 = null;
        if (i3 != 0) {
        }
        if (i != 0) {
        }
        if ((j & 128) != 0) {
        }
        if (i4 == 0) {
        }
    }
}
