package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.view.util.BindingAdaptersKt;
import com.digitalwallet.app.viewmodel.login.HomeServicesViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.FavouriteCellViewModel;
import java.util.List;

public class FragmentHomeServicesBindingImpl extends FragmentHomeServicesBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback23;
    private final View.OnClickListener mCallback24;
    private final View.OnClickListener mCallback25;
    private long mDirtyFlags;
    private final ImageView mboundView11;
    private final LinearLayout mboundView12;
    private final TextView mboundView13;
    private final TextView mboundView5;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.service_vic_logo, 14);
        sparseIntArray.put(R.id.favourite_carousel, 15);
        sparseIntArray.put(R.id.guideline, 16);
        sparseIntArray.put(R.id.guideline2, 17);
        sparseIntArray.put(R.id.v_login_privacy, 18);
        sparseIntArray.put(R.id.check_in_content_view, 19);
    }

    public FragmentHomeServicesBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private FragmentHomeServicesBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (LinearLayout) objArr[3], (LinearLayout) objArr[19], (ConstraintLayout) objArr[10], (TextView) objArr[8], (RecyclerView) objArr[15], (LinearLayout) objArr[4], (Guideline) objArr[16], (Guideline) objArr[17], (TextView) objArr[9], (ViewPager) objArr[2], (ConstraintLayout) objArr[0], (ImageView) objArr[14], (LinearLayout) objArr[7], (LinearLayout) objArr[6], (ImageView) objArr[1], (TextView) objArr[18]);
        this.mDirtyFlags = -1;
        this.carouselPagingDots.setTag(null);
        this.checkInView.setTag(null);
        this.citizenLoginHeading.setTag(null);
        this.favouriteCarouselContainer.setTag(null);
        this.loginCopy.setTag(null);
        this.loginTopCarousel.setTag(null);
        this.mainLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[11];
        this.mboundView11 = imageView;
        imageView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[12];
        this.mboundView12 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[13];
        this.mboundView13 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.mboundView5 = textView2;
        textView2.setTag(null);
        this.svServiceGroups.setTag(null);
        this.svServicesDivider.setTag(null);
        this.vAccount.setTag(null);
        setRootTag(view);
        this.mCallback25 = new OnClickListener(this, 3);
        this.mCallback23 = new OnClickListener(this, 1);
        this.mCallback24 = new OnClickListener(this, 2);
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
        setVm((HomeServicesViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentHomeServicesBinding
    public void setVm(HomeServicesViewModel homeServicesViewModel) {
        this.mVm = homeServicesViewModel;
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
            return onChangeVmShowLogin((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeVmFavouriteCellVMs((ObservableField) obj, i2);
    }

    private boolean onChangeVmShowLogin(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmFavouriteCellVMs(ObservableField<List<FavouriteCellViewModel>> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HomeServicesViewModel homeServicesViewModel = this.mVm;
        boolean z6 = false;
        if ((15 & j) != 0) {
            if ((j & 13) != 0) {
                ObservableField<Boolean> showLogin = homeServicesViewModel != null ? homeServicesViewModel.getShowLogin() : null;
                updateRegistration(0, showLogin);
                z2 = ViewDataBinding.safeUnbox(showLogin != null ? showLogin.get() : null);
            } else {
                z2 = false;
            }
            int i = ((j & 14) > 0 ? 1 : ((j & 14) == 0 ? 0 : -1));
            if (i != 0) {
                if (homeServicesViewModel != null) {
                    z5 = homeServicesViewModel.isCitizen();
                } else {
                    z5 = false;
                }
                if (i != 0) {
                    j = z5 ? j | 32 : j | 16;
                }
                if ((j & 12) != 0) {
                    z6 = !z5;
                }
                z = z5;
            } else {
                z = false;
            }
        } else {
            z2 = false;
            z = false;
        }
        if ((j & 32) != 0) {
            ObservableField<List<FavouriteCellViewModel>> favouriteCellVMs = homeServicesViewModel != null ? homeServicesViewModel.getFavouriteCellVMs() : null;
            updateRegistration(1, favouriteCellVMs);
            List<FavouriteCellViewModel> list = favouriteCellVMs != null ? favouriteCellVMs.get() : null;
            if (list != null) {
                z4 = list.isEmpty();
            } else {
                z4 = false;
            }
            z3 = !z4;
        } else {
            z3 = false;
        }
        int i2 = ((14 & j) > 0 ? 1 : ((14 & j) == 0 ? 0 : -1));
        if (i2 == 0 || !z) {
            z3 = false;
        }
        if ((12 & j) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.carouselPagingDots, z);
            BindingAdaptersKt.setVisibleOrGone(this.checkInView, z);
            BindingAdaptersKt.setVisibleOrGone(this.citizenLoginHeading, z6);
            BindingAdaptersKt.setVisibleOrGone(this.loginCopy, z6);
            BindingAdaptersKt.setVisibleOrGone(this.loginTopCarousel, z);
            BindingAdaptersKt.setVisibleOrGone(this.svServiceGroups, z);
            BindingAdaptersKt.setVisibleOrGone(this.svServicesDivider, z);
        }
        if (i2 != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.favouriteCarouselContainer, z3);
        }
        if ((8 & j) != 0) {
            this.mboundView11.setOnClickListener(this.mCallback24);
            this.mboundView12.setOnClickListener(this.mCallback25);
            this.mboundView5.setOnClickListener(this.mCallback23);
        }
        if ((j & 13) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.mboundView13, z2);
            BindingAdaptersKt.setVisibleOrGone(this.vAccount, z2);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            HomeServicesViewModel homeServicesViewModel = this.mVm;
            if (homeServicesViewModel != null) {
                z = true;
            }
            if (z) {
                homeServicesViewModel.toCheckInFavourites();
            }
        } else if (i == 2) {
            HomeServicesViewModel homeServicesViewModel2 = this.mVm;
            if (homeServicesViewModel2 != null) {
                z = true;
            }
            if (z) {
                homeServicesViewModel2.toCheckInHistory();
            }
        } else if (i == 3) {
            HomeServicesViewModel homeServicesViewModel3 = this.mVm;
            if (homeServicesViewModel3 != null) {
                z = true;
            }
            if (z) {
                homeServicesViewModel3.onCheckIn();
            }
        }
    }
}
