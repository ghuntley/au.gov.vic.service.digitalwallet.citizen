package com.digitalwallet.app.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.harvester.HarvestZoneViewHolder;

public class HarvesterItemZoneBindingImpl extends HarvesterItemZoneBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback61;
    private long mDirtyFlags;
    private final GridLayout mboundView0;
    private final TextView mboundView1;
    private final ImageView mboundView2;

    public HarvesterItemZoneBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private HarvesterItemZoneBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2);
        this.mDirtyFlags = -1;
        GridLayout gridLayout = (GridLayout) objArr[0];
        this.mboundView0 = gridLayout;
        gridLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        setRootTag(view);
        this.mCallback61 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
        setVm((HarvestZoneViewHolder) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.HarvesterItemZoneBinding
    public void setVm(HarvestZoneViewHolder harvestZoneViewHolder) {
        this.mVm = harvestZoneViewHolder;
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
            return onChangeVmName((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeVmSelected((ObservableField) obj, i2);
    }

    private boolean onChangeVmName(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmSelected(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        String str;
        int i;
        int i2;
        Context context;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HarvestZoneViewHolder harvestZoneViewHolder = this.mVm;
        String str2 = null;
        Boolean bool = null;
        Drawable drawable2 = null;
        if ((15 & j) != 0) {
            if ((j & 13) != 0) {
                ObservableField<String> name = harvestZoneViewHolder != null ? harvestZoneViewHolder.getName() : null;
                updateRegistration(0, name);
                if (name != null) {
                    str = name.get();
                    i = ((j & 14) > 0 ? 1 : ((j & 14) == 0 ? 0 : -1));
                    if (i != 0) {
                        ObservableField<Boolean> selected = harvestZoneViewHolder != null ? harvestZoneViewHolder.getSelected() : null;
                        updateRegistration(1, selected);
                        if (selected != null) {
                            bool = selected.get();
                        }
                        boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
                        if (i != 0) {
                            j |= safeUnbox ? 32 : 16;
                        }
                        if (safeUnbox) {
                            context = this.mboundView2.getContext();
                            i2 = R.drawable.ic_radio_active;
                        } else {
                            context = this.mboundView2.getContext();
                            i2 = R.drawable.ic_radio_inactive;
                        }
                        drawable2 = AppCompatResources.getDrawable(context, i2);
                    }
                    drawable = drawable2;
                    str2 = str;
                }
            }
            str = null;
            i = ((j & 14) > 0 ? 1 : ((j & 14) == 0 ? 0 : -1));
            if (i != 0) {
            }
            drawable = drawable2;
            str2 = str;
        } else {
            drawable = null;
        }
        if ((8 & j) != 0) {
            this.mboundView0.setOnClickListener(this.mCallback61);
        }
        if ((13 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str2);
        }
        if ((j & 14) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView2, drawable);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        HarvestZoneViewHolder harvestZoneViewHolder = this.mVm;
        if (harvestZoneViewHolder != null) {
            harvestZoneViewHolder.select();
        }
    }
}
