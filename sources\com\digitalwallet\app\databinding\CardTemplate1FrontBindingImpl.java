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

public class CardTemplate1FrontBindingImpl extends CardTemplate1FrontBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView10;
    private final TextView mboundView11;
    private final TextView mboundView12;
    private final TextView mboundView13;
    private final TextView mboundView14;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView6;
    private final TextView mboundView7;
    private final TextView mboundView8;
    private final TextView mboundView9;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.holding_title, 15);
    }

    public CardTemplate1FrontBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private CardTemplate1FrontBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ConstraintLayout) objArr[15]);
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
        TextView textView4 = (TextView) objArr[12];
        this.mboundView12 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[13];
        this.mboundView13 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[14];
        this.mboundView14 = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[2];
        this.mboundView2 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[3];
        this.mboundView3 = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[4];
        this.mboundView4 = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) objArr[5];
        this.mboundView5 = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[6];
        this.mboundView6 = textView11;
        textView11.setTag(null);
        TextView textView12 = (TextView) objArr[7];
        this.mboundView7 = textView12;
        textView12.setTag(null);
        TextView textView13 = (TextView) objArr[8];
        this.mboundView8 = textView13;
        textView13.setTag(null);
        TextView textView14 = (TextView) objArr[9];
        this.mboundView9 = textView14;
        textView14.setTag(null);
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
        } else if (8257539 != i) {
            return false;
        } else {
            setHolding((SecureHolding) obj);
        }
        return true;
    }

    @Override // com.digitalwallet.app.databinding.CardTemplate1FrontBinding
    public void setAssets(HoldingAssets holdingAssets) {
        this.mAssets = holdingAssets;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.assets);
        super.requestRebind();
    }

    @Override // com.digitalwallet.app.databinding.CardTemplate1FrontBinding
    public void setHolding(SecureHolding secureHolding) {
        this.mHolding = secureHolding;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.holding);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeAssetsMap((ObservableArrayMap) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeAssetsMapAssetTypeCardFrontJsonName((DrawableAsset) obj, i2);
    }

    private boolean onChangeAssetsMap(ObservableArrayMap<String, DrawableAsset> observableArrayMap, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeAssetsMapAssetTypeCardFrontJsonName(DrawableAsset drawableAsset, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        int i;
        String str;
        String str2;
        String str3;
        long j2;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HoldingAssets holdingAssets = this.mAssets;
        SecureHolding secureHolding = this.mHolding;
        int i2 = ((55 & j) > 0 ? 1 : ((55 & j) == 0 ? 0 : -1));
        int i3 = 0;
        String str14 = null;
        if (i2 != 0) {
            String jsonName = AssetType.CardFront.getJsonName();
            ObservableArrayMap<String, DrawableAsset> map = holdingAssets != null ? holdingAssets.getMap() : null;
            updateRegistration(0, map);
            DrawableAsset drawableAsset = map != null ? map.get(jsonName) : null;
            updateRegistration(1, drawableAsset);
            if (drawableAsset != null) {
                drawable = drawableAsset.getDrawable();
                i = ((40 & j) > 0 ? 1 : ((40 & j) == 0 ? 0 : -1));
                if (i != 0) {
                    DynamicHoldingDisplay dynamicDisplay = secureHolding != null ? secureHolding.getDynamicDisplay() : null;
                    DynamicHoldingCardTemplate cardTemplate = dynamicDisplay != null ? dynamicDisplay.getCardTemplate() : null;
                    if (cardTemplate != null) {
                        str14 = cardTemplate.getTitle();
                        String value6 = cardTemplate.getValue6();
                        String value4 = cardTemplate.getValue4();
                        str6 = cardTemplate.getValue5();
                        String value2 = cardTemplate.getValue2();
                        str4 = cardTemplate.getValue3();
                        String value1 = cardTemplate.getValue1();
                        String main = cardTemplate.getMain();
                        String label3 = cardTemplate.getLabel3();
                        String label4 = cardTemplate.getLabel4();
                        String label5 = cardTemplate.getLabel5();
                        String label6 = cardTemplate.getLabel6();
                        str2 = value2;
                        str10 = value1;
                        str8 = main;
                        str = label5;
                        str11 = cardTemplate.getLabel1();
                        str3 = cardTemplate.getLabel2();
                        str5 = value6;
                        i3 = cardTemplate.getTextColor();
                        str9 = label3;
                        str12 = value4;
                        str13 = label4;
                        str7 = label6;
                        j2 = j;
                        if (i2 != 0) {
                            ViewBindingAdapter.setBackground(this.mboundView0, drawable);
                        }
                        if (i != 0) {
                            TextViewBindingAdapter.setText(this.mboundView1, str14);
                            this.mboundView1.setTextColor(i3);
                            TextViewBindingAdapter.setText(this.mboundView10, str6);
                            this.mboundView10.setTextColor(i3);
                            TextViewBindingAdapter.setText(this.mboundView11, str9);
                            this.mboundView11.setTextColor(i3);
                            TextViewBindingAdapter.setText(this.mboundView12, str4);
                            this.mboundView12.setTextColor(i3);
                            TextViewBindingAdapter.setText(this.mboundView13, str7);
                            this.mboundView13.setTextColor(i3);
                            TextViewBindingAdapter.setText(this.mboundView14, str5);
                            this.mboundView14.setTextColor(i3);
                            TextViewBindingAdapter.setText(this.mboundView2, str8);
                            this.mboundView2.setTextColor(i3);
                            TextViewBindingAdapter.setText(this.mboundView3, str11);
                            this.mboundView3.setTextColor(i3);
                            TextViewBindingAdapter.setText(this.mboundView4, str10);
                            this.mboundView4.setTextColor(i3);
                            TextViewBindingAdapter.setText(this.mboundView5, str13);
                            this.mboundView5.setTextColor(i3);
                            TextViewBindingAdapter.setText(this.mboundView6, str12);
                            this.mboundView6.setTextColor(i3);
                            TextViewBindingAdapter.setText(this.mboundView7, str3);
                            this.mboundView7.setTextColor(i3);
                            TextViewBindingAdapter.setText(this.mboundView8, str2);
                            this.mboundView8.setTextColor(i3);
                            TextViewBindingAdapter.setText(this.mboundView9, str);
                            this.mboundView9.setTextColor(i3);
                        }
                        if ((j2 & 32) != 0) {
                            BindingAdaptersKt.goneWhenEmpty(this.mboundView10, true);
                            BindingAdaptersKt.goneWhenEmpty(this.mboundView11, true);
                            BindingAdaptersKt.goneWhenEmpty(this.mboundView12, true);
                            BindingAdaptersKt.goneWhenEmpty(this.mboundView13, true);
                            BindingAdaptersKt.goneWhenEmpty(this.mboundView14, true);
                            BindingAdaptersKt.goneWhenEmpty(this.mboundView3, true);
                            BindingAdaptersKt.goneWhenEmpty(this.mboundView4, true);
                            BindingAdaptersKt.goneWhenEmpty(this.mboundView5, true);
                            BindingAdaptersKt.goneWhenEmpty(this.mboundView6, true);
                            BindingAdaptersKt.goneWhenEmpty(this.mboundView7, true);
                            BindingAdaptersKt.goneWhenEmpty(this.mboundView8, true);
                            BindingAdaptersKt.goneWhenEmpty(this.mboundView9, true);
                            return;
                        }
                        return;
                    }
                }
                j2 = j;
                str13 = null;
                str12 = null;
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
                str = null;
                if (i2 != 0) {
                }
                if (i != 0) {
                }
                if ((j2 & 32) != 0) {
                }
            }
        }
        drawable = null;
        i = ((40 & j) > 0 ? 1 : ((40 & j) == 0 ? 0 : -1));
        if (i != 0) {
        }
        j2 = j;
        str13 = null;
        str12 = null;
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
        str = null;
        if (i2 != 0) {
        }
        if (i != 0) {
        }
        if ((j2 & 32) != 0) {
        }
    }
}
