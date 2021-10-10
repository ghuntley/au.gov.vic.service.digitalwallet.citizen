package com.digitalwallet.app.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.view.util.BindingAdaptersKt;
import com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel;
import java.util.Date;

public class HarvesterTagSummaryBindingImpl extends HarvesterTagSummaryBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback66;
    private final View.OnClickListener mCallback67;
    private long mDirtyFlags;
    private final ImageView mboundView1;
    private final EditText mboundView10;
    private InverseBindingListener mboundView10androidTextAttrChanged;
    private final EditText mboundView11;
    private InverseBindingListener mboundView11androidTextAttrChanged;
    private final EditText mboundView12;
    private InverseBindingListener mboundView12androidTextAttrChanged;
    private final EditText mboundView13;
    private InverseBindingListener mboundView13androidTextAttrChanged;
    private final EditText mboundView14;
    private InverseBindingListener mboundView14androidTextAttrChanged;
    private final Button mboundView15;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView6;
    private final EditText mboundView7;
    private InverseBindingListener mboundView7androidTextAttrChanged;
    private final EditText mboundView8;
    private InverseBindingListener mboundView8androidTextAttrChanged;
    private final EditText mboundView9;
    private InverseBindingListener mboundView9androidTextAttrChanged;

    public HarvesterTagSummaryBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private HarvesterTagSummaryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 14, (GridLayout) objArr[0]);
        this.mboundView10androidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.HarvesterTagSummaryBindingImpl.AnonymousClass1 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(HarvesterTagSummaryBindingImpl.this.mboundView10);
                HarvestTagViewModel harvestTagViewModel = HarvesterTagSummaryBindingImpl.this.mVm;
                boolean z = true;
                if (harvestTagViewModel != null) {
                    ObservableField<String> numPouchYoungDestroyed = harvestTagViewModel.getNumPouchYoungDestroyed();
                    if (numPouchYoungDestroyed == null) {
                        z = false;
                    }
                    if (z) {
                        numPouchYoungDestroyed.set(textString);
                    }
                }
            }
        };
        this.mboundView11androidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.HarvesterTagSummaryBindingImpl.AnonymousClass2 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(HarvesterTagSummaryBindingImpl.this.mboundView11);
                HarvestTagViewModel harvestTagViewModel = HarvesterTagSummaryBindingImpl.this.mVm;
                boolean z = true;
                if (harvestTagViewModel != null) {
                    ObservableField<String> numYoungAtFootDestroyed = harvestTagViewModel.getNumYoungAtFootDestroyed();
                    if (numYoungAtFootDestroyed == null) {
                        z = false;
                    }
                    if (z) {
                        numYoungAtFootDestroyed.set(textString);
                    }
                }
            }
        };
        this.mboundView12androidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.HarvesterTagSummaryBindingImpl.AnonymousClass3 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(HarvesterTagSummaryBindingImpl.this.mboundView12);
                HarvestTagViewModel harvestTagViewModel = HarvesterTagSummaryBindingImpl.this.mVm;
                boolean z = true;
                if (harvestTagViewModel != null) {
                    ObservableField<String> numTaggedCarcassesLeftOnProperty = harvestTagViewModel.getNumTaggedCarcassesLeftOnProperty();
                    if (numTaggedCarcassesLeftOnProperty == null) {
                        z = false;
                    }
                    if (z) {
                        numTaggedCarcassesLeftOnProperty.set(textString);
                    }
                }
            }
        };
        this.mboundView13androidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.HarvesterTagSummaryBindingImpl.AnonymousClass4 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(HarvesterTagSummaryBindingImpl.this.mboundView13);
                HarvestTagViewModel harvestTagViewModel = HarvesterTagSummaryBindingImpl.this.mVm;
                boolean z = true;
                if (harvestTagViewModel != null) {
                    ObservableField<String> numTaggedCarcassesStoredForProcessor = harvestTagViewModel.getNumTaggedCarcassesStoredForProcessor();
                    if (numTaggedCarcassesStoredForProcessor == null) {
                        z = false;
                    }
                    if (z) {
                        numTaggedCarcassesStoredForProcessor.set(textString);
                    }
                }
            }
        };
        this.mboundView14androidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.HarvesterTagSummaryBindingImpl.AnonymousClass5 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(HarvesterTagSummaryBindingImpl.this.mboundView14);
                HarvestTagViewModel harvestTagViewModel = HarvesterTagSummaryBindingImpl.this.mVm;
                boolean z = true;
                if (harvestTagViewModel != null) {
                    ObservableField<String> comments = harvestTagViewModel.getComments();
                    if (comments == null) {
                        z = false;
                    }
                    if (z) {
                        comments.set(textString);
                    }
                }
            }
        };
        this.mboundView7androidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.HarvesterTagSummaryBindingImpl.AnonymousClass6 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(HarvesterTagSummaryBindingImpl.this.mboundView7);
                HarvestTagViewModel harvestTagViewModel = HarvesterTagSummaryBindingImpl.this.mVm;
                boolean z = true;
                if (harvestTagViewModel != null) {
                    ObservableField<String> numOfWesternGreys = harvestTagViewModel.getNumOfWesternGreys();
                    if (numOfWesternGreys == null) {
                        z = false;
                    }
                    if (z) {
                        numOfWesternGreys.set(textString);
                    }
                }
            }
        };
        this.mboundView8androidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.HarvesterTagSummaryBindingImpl.AnonymousClass7 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(HarvesterTagSummaryBindingImpl.this.mboundView8);
                HarvestTagViewModel harvestTagViewModel = HarvesterTagSummaryBindingImpl.this.mVm;
                boolean z = true;
                if (harvestTagViewModel != null) {
                    ObservableField<String> numOfEasternGreys = harvestTagViewModel.getNumOfEasternGreys();
                    if (numOfEasternGreys == null) {
                        z = false;
                    }
                    if (z) {
                        numOfEasternGreys.set(textString);
                    }
                }
            }
        };
        this.mboundView9androidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.HarvesterTagSummaryBindingImpl.AnonymousClass8 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(HarvesterTagSummaryBindingImpl.this.mboundView9);
                HarvestTagViewModel harvestTagViewModel = HarvesterTagSummaryBindingImpl.this.mVm;
                boolean z = true;
                if (harvestTagViewModel != null) {
                    ObservableField<String> numOfFemales = harvestTagViewModel.getNumOfFemales();
                    if (numOfFemales == null) {
                        z = false;
                    }
                    if (z) {
                        numOfFemales.set(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1;
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        EditText editText = (EditText) objArr[10];
        this.mboundView10 = editText;
        editText.setTag(null);
        EditText editText2 = (EditText) objArr[11];
        this.mboundView11 = editText2;
        editText2.setTag(null);
        EditText editText3 = (EditText) objArr[12];
        this.mboundView12 = editText3;
        editText3.setTag(null);
        EditText editText4 = (EditText) objArr[13];
        this.mboundView13 = editText4;
        editText4.setTag(null);
        EditText editText5 = (EditText) objArr[14];
        this.mboundView14 = editText5;
        editText5.setTag(null);
        Button button = (Button) objArr[15];
        this.mboundView15 = button;
        button.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.mboundView4 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[5];
        this.mboundView5 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[6];
        this.mboundView6 = textView5;
        textView5.setTag(null);
        EditText editText6 = (EditText) objArr[7];
        this.mboundView7 = editText6;
        editText6.setTag(null);
        EditText editText7 = (EditText) objArr[8];
        this.mboundView8 = editText7;
        editText7.setTag(null);
        EditText editText8 = (EditText) objArr[9];
        this.mboundView9 = editText8;
        editText8.setTag(null);
        this.summaryScreen.setTag(null);
        setRootTag(view);
        this.mCallback67 = new OnClickListener(this, 2);
        this.mCallback66 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
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
        setVm((HarvestTagViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.HarvesterTagSummaryBinding
    public void setVm(HarvestTagViewModel harvestTagViewModel) {
        this.mVm = harvestTagViewModel;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeVmSummaryFilled((ObservableField) obj, i2);
            case 1:
                return onChangeVmNumYoungAtFootDestroyed((ObservableField) obj, i2);
            case 2:
                return onChangeVmNumPouchYoungDestroyed((ObservableField) obj, i2);
            case 3:
                return onChangeVmNumOfWesternGreys((ObservableField) obj, i2);
            case 4:
                return onChangeVmLandholderName((ObservableField) obj, i2);
            case 5:
                return onChangeVmNumOfFemales((ObservableField) obj, i2);
            case 6:
                return onChangeVmComments((ObservableField) obj, i2);
            case 7:
                return onChangeVmLandholderContactNumber((ObservableField) obj, i2);
            case 8:
                return onChangeVmNumTaggedCarcassesStoredForProcessor((ObservableField) obj, i2);
            case 9:
                return onChangeVmNumTaggedCarcassesLeftOnProperty((ObservableField) obj, i2);
            case 10:
                return onChangeVmTagCount((ObservableField) obj, i2);
            case 11:
                return onChangeVmNumOfEasternGreys((ObservableField) obj, i2);
            case 12:
                return onChangeVmDateOfHarvest((ObservableField) obj, i2);
            case 13:
                return onChangeVmAddress((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeVmSummaryFilled(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmNumYoungAtFootDestroyed(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmNumPouchYoungDestroyed(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmNumOfWesternGreys(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmLandholderName(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeVmNumOfFemales(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeVmComments(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeVmLandholderContactNumber(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeVmNumTaggedCarcassesStoredForProcessor(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeVmNumTaggedCarcassesLeftOnProperty(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeVmTagCount(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean onChangeVmNumOfEasternGreys(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean onChangeVmDateOfHarvest(ObservableField<Date> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean onChangeVmAddress(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x013d  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        String str5;
        String str6;
        String str7;
        String str8;
        Date date;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        Date date2;
        String str16;
        boolean z2;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        boolean z3;
        String str26;
        String str27;
        String str28;
        String str29;
        Date date3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HarvestTagViewModel harvestTagViewModel = this.mVm;
        if ((65535 & j) != 0) {
            if ((j & 49153) != 0) {
                ObservableField<Boolean> summaryFilled = harvestTagViewModel != null ? harvestTagViewModel.getSummaryFilled() : null;
                updateRegistration(0, summaryFilled);
                z2 = ViewDataBinding.safeUnbox(summaryFilled != null ? summaryFilled.get() : null);
            } else {
                z2 = false;
            }
            if ((j & 49154) != 0) {
                ObservableField<String> numYoungAtFootDestroyed = harvestTagViewModel != null ? harvestTagViewModel.getNumYoungAtFootDestroyed() : null;
                updateRegistration(1, numYoungAtFootDestroyed);
                if (numYoungAtFootDestroyed != null) {
                    str17 = numYoungAtFootDestroyed.get();
                    if ((j & 49156) != 0) {
                        ObservableField<String> numPouchYoungDestroyed = harvestTagViewModel != null ? harvestTagViewModel.getNumPouchYoungDestroyed() : null;
                        updateRegistration(2, numPouchYoungDestroyed);
                        if (numPouchYoungDestroyed != null) {
                            str18 = numPouchYoungDestroyed.get();
                            if ((j & 49160) != 0) {
                                ObservableField<String> numOfWesternGreys = harvestTagViewModel != null ? harvestTagViewModel.getNumOfWesternGreys() : null;
                                updateRegistration(3, numOfWesternGreys);
                                if (numOfWesternGreys != null) {
                                    str19 = numOfWesternGreys.get();
                                    if ((j & 49168) != 0) {
                                        ObservableField<String> landholderName = harvestTagViewModel != null ? harvestTagViewModel.getLandholderName() : null;
                                        updateRegistration(4, landholderName);
                                        if (landholderName != null) {
                                            str20 = landholderName.get();
                                            if ((j & 49184) != 0) {
                                                ObservableField<String> numOfFemales = harvestTagViewModel != null ? harvestTagViewModel.getNumOfFemales() : null;
                                                updateRegistration(5, numOfFemales);
                                                if (numOfFemales != null) {
                                                    str21 = numOfFemales.get();
                                                    if ((j & 49216) != 0) {
                                                        ObservableField<String> comments = harvestTagViewModel != null ? harvestTagViewModel.getComments() : null;
                                                        updateRegistration(6, comments);
                                                        if (comments != null) {
                                                            str22 = comments.get();
                                                            if ((j & 49280) != 0) {
                                                                ObservableField<String> landholderContactNumber = harvestTagViewModel != null ? harvestTagViewModel.getLandholderContactNumber() : null;
                                                                updateRegistration(7, landholderContactNumber);
                                                                if (landholderContactNumber != null) {
                                                                    str23 = landholderContactNumber.get();
                                                                    if ((j & 49408) != 0) {
                                                                        ObservableField<String> numTaggedCarcassesStoredForProcessor = harvestTagViewModel != null ? harvestTagViewModel.getNumTaggedCarcassesStoredForProcessor() : null;
                                                                        updateRegistration(8, numTaggedCarcassesStoredForProcessor);
                                                                        if (numTaggedCarcassesStoredForProcessor != null) {
                                                                            str24 = numTaggedCarcassesStoredForProcessor.get();
                                                                            if ((j & 49664) != 0) {
                                                                                ObservableField<String> numTaggedCarcassesLeftOnProperty = harvestTagViewModel != null ? harvestTagViewModel.getNumTaggedCarcassesLeftOnProperty() : null;
                                                                                updateRegistration(9, numTaggedCarcassesLeftOnProperty);
                                                                                if (numTaggedCarcassesLeftOnProperty != null) {
                                                                                    str25 = numTaggedCarcassesLeftOnProperty.get();
                                                                                    if ((j & 50176) == 0) {
                                                                                        ObservableField<Integer> tagCount = harvestTagViewModel != null ? harvestTagViewModel.getTagCount() : null;
                                                                                        updateRegistration(10, tagCount);
                                                                                        Integer num = tagCount != null ? tagCount.get() : null;
                                                                                        str27 = str25;
                                                                                        z3 = z2;
                                                                                        str26 = str18;
                                                                                        this.mboundView2.getResources().getQuantityString(R.plurals.harvest_tag_summary_count, num.intValue(), num);
                                                                                        str28 = this.mboundView2.getResources().getQuantityString(R.plurals.harvest_tag_summary_count, num.intValue(), num);
                                                                                    } else {
                                                                                        str27 = str25;
                                                                                        z3 = z2;
                                                                                        str26 = str18;
                                                                                        str28 = null;
                                                                                    }
                                                                                    if ((j & 51200) != 0) {
                                                                                        ObservableField<String> numOfEasternGreys = harvestTagViewModel != null ? harvestTagViewModel.getNumOfEasternGreys() : null;
                                                                                        updateRegistration(11, numOfEasternGreys);
                                                                                        if (numOfEasternGreys != null) {
                                                                                            str29 = numOfEasternGreys.get();
                                                                                            if ((j & 53248) != 0) {
                                                                                                ObservableField<Date> dateOfHarvest = harvestTagViewModel != null ? harvestTagViewModel.getDateOfHarvest() : null;
                                                                                                updateRegistration(12, dateOfHarvest);
                                                                                                if (dateOfHarvest != null) {
                                                                                                    date3 = dateOfHarvest.get();
                                                                                                    if ((j & 57344) != 0) {
                                                                                                        ObservableField<String> address = harvestTagViewModel != null ? harvestTagViewModel.getAddress() : null;
                                                                                                        updateRegistration(13, address);
                                                                                                        if (address != null) {
                                                                                                            str12 = address.get();
                                                                                                            date = date3;
                                                                                                            str2 = str23;
                                                                                                            str4 = str24;
                                                                                                            str9 = str29;
                                                                                                            str3 = str22;
                                                                                                            z = z3;
                                                                                                            str10 = str28;
                                                                                                            str11 = str27;
                                                                                                            str = str21;
                                                                                                            str5 = str20;
                                                                                                            str6 = str17;
                                                                                                            str7 = str19;
                                                                                                            str8 = str26;
                                                                                                        }
                                                                                                    }
                                                                                                    date = date3;
                                                                                                    str2 = str23;
                                                                                                    str4 = str24;
                                                                                                    str12 = null;
                                                                                                    str9 = str29;
                                                                                                    str3 = str22;
                                                                                                    z = z3;
                                                                                                    str10 = str28;
                                                                                                    str11 = str27;
                                                                                                    str = str21;
                                                                                                    str5 = str20;
                                                                                                    str6 = str17;
                                                                                                    str7 = str19;
                                                                                                    str8 = str26;
                                                                                                }
                                                                                            }
                                                                                            date3 = null;
                                                                                            if ((j & 57344) != 0) {
                                                                                            }
                                                                                            date = date3;
                                                                                            str2 = str23;
                                                                                            str4 = str24;
                                                                                            str12 = null;
                                                                                            str9 = str29;
                                                                                            str3 = str22;
                                                                                            z = z3;
                                                                                            str10 = str28;
                                                                                            str11 = str27;
                                                                                            str = str21;
                                                                                            str5 = str20;
                                                                                            str6 = str17;
                                                                                            str7 = str19;
                                                                                            str8 = str26;
                                                                                        }
                                                                                    }
                                                                                    str29 = null;
                                                                                    if ((j & 53248) != 0) {
                                                                                    }
                                                                                    date3 = null;
                                                                                    if ((j & 57344) != 0) {
                                                                                    }
                                                                                    date = date3;
                                                                                    str2 = str23;
                                                                                    str4 = str24;
                                                                                    str12 = null;
                                                                                    str9 = str29;
                                                                                    str3 = str22;
                                                                                    z = z3;
                                                                                    str10 = str28;
                                                                                    str11 = str27;
                                                                                    str = str21;
                                                                                    str5 = str20;
                                                                                    str6 = str17;
                                                                                    str7 = str19;
                                                                                    str8 = str26;
                                                                                }
                                                                            }
                                                                            str25 = null;
                                                                            if ((j & 50176) == 0) {
                                                                            }
                                                                            if ((j & 51200) != 0) {
                                                                            }
                                                                            str29 = null;
                                                                            if ((j & 53248) != 0) {
                                                                            }
                                                                            date3 = null;
                                                                            if ((j & 57344) != 0) {
                                                                            }
                                                                            date = date3;
                                                                            str2 = str23;
                                                                            str4 = str24;
                                                                            str12 = null;
                                                                            str9 = str29;
                                                                            str3 = str22;
                                                                            z = z3;
                                                                            str10 = str28;
                                                                            str11 = str27;
                                                                            str = str21;
                                                                            str5 = str20;
                                                                            str6 = str17;
                                                                            str7 = str19;
                                                                            str8 = str26;
                                                                        }
                                                                    }
                                                                    str24 = null;
                                                                    if ((j & 49664) != 0) {
                                                                    }
                                                                    str25 = null;
                                                                    if ((j & 50176) == 0) {
                                                                    }
                                                                    if ((j & 51200) != 0) {
                                                                    }
                                                                    str29 = null;
                                                                    if ((j & 53248) != 0) {
                                                                    }
                                                                    date3 = null;
                                                                    if ((j & 57344) != 0) {
                                                                    }
                                                                    date = date3;
                                                                    str2 = str23;
                                                                    str4 = str24;
                                                                    str12 = null;
                                                                    str9 = str29;
                                                                    str3 = str22;
                                                                    z = z3;
                                                                    str10 = str28;
                                                                    str11 = str27;
                                                                    str = str21;
                                                                    str5 = str20;
                                                                    str6 = str17;
                                                                    str7 = str19;
                                                                    str8 = str26;
                                                                }
                                                            }
                                                            str23 = null;
                                                            if ((j & 49408) != 0) {
                                                            }
                                                            str24 = null;
                                                            if ((j & 49664) != 0) {
                                                            }
                                                            str25 = null;
                                                            if ((j & 50176) == 0) {
                                                            }
                                                            if ((j & 51200) != 0) {
                                                            }
                                                            str29 = null;
                                                            if ((j & 53248) != 0) {
                                                            }
                                                            date3 = null;
                                                            if ((j & 57344) != 0) {
                                                            }
                                                            date = date3;
                                                            str2 = str23;
                                                            str4 = str24;
                                                            str12 = null;
                                                            str9 = str29;
                                                            str3 = str22;
                                                            z = z3;
                                                            str10 = str28;
                                                            str11 = str27;
                                                            str = str21;
                                                            str5 = str20;
                                                            str6 = str17;
                                                            str7 = str19;
                                                            str8 = str26;
                                                        }
                                                    }
                                                    str22 = null;
                                                    if ((j & 49280) != 0) {
                                                    }
                                                    str23 = null;
                                                    if ((j & 49408) != 0) {
                                                    }
                                                    str24 = null;
                                                    if ((j & 49664) != 0) {
                                                    }
                                                    str25 = null;
                                                    if ((j & 50176) == 0) {
                                                    }
                                                    if ((j & 51200) != 0) {
                                                    }
                                                    str29 = null;
                                                    if ((j & 53248) != 0) {
                                                    }
                                                    date3 = null;
                                                    if ((j & 57344) != 0) {
                                                    }
                                                    date = date3;
                                                    str2 = str23;
                                                    str4 = str24;
                                                    str12 = null;
                                                    str9 = str29;
                                                    str3 = str22;
                                                    z = z3;
                                                    str10 = str28;
                                                    str11 = str27;
                                                    str = str21;
                                                    str5 = str20;
                                                    str6 = str17;
                                                    str7 = str19;
                                                    str8 = str26;
                                                }
                                            }
                                            str21 = null;
                                            if ((j & 49216) != 0) {
                                            }
                                            str22 = null;
                                            if ((j & 49280) != 0) {
                                            }
                                            str23 = null;
                                            if ((j & 49408) != 0) {
                                            }
                                            str24 = null;
                                            if ((j & 49664) != 0) {
                                            }
                                            str25 = null;
                                            if ((j & 50176) == 0) {
                                            }
                                            if ((j & 51200) != 0) {
                                            }
                                            str29 = null;
                                            if ((j & 53248) != 0) {
                                            }
                                            date3 = null;
                                            if ((j & 57344) != 0) {
                                            }
                                            date = date3;
                                            str2 = str23;
                                            str4 = str24;
                                            str12 = null;
                                            str9 = str29;
                                            str3 = str22;
                                            z = z3;
                                            str10 = str28;
                                            str11 = str27;
                                            str = str21;
                                            str5 = str20;
                                            str6 = str17;
                                            str7 = str19;
                                            str8 = str26;
                                        }
                                    }
                                    str20 = null;
                                    if ((j & 49184) != 0) {
                                    }
                                    str21 = null;
                                    if ((j & 49216) != 0) {
                                    }
                                    str22 = null;
                                    if ((j & 49280) != 0) {
                                    }
                                    str23 = null;
                                    if ((j & 49408) != 0) {
                                    }
                                    str24 = null;
                                    if ((j & 49664) != 0) {
                                    }
                                    str25 = null;
                                    if ((j & 50176) == 0) {
                                    }
                                    if ((j & 51200) != 0) {
                                    }
                                    str29 = null;
                                    if ((j & 53248) != 0) {
                                    }
                                    date3 = null;
                                    if ((j & 57344) != 0) {
                                    }
                                    date = date3;
                                    str2 = str23;
                                    str4 = str24;
                                    str12 = null;
                                    str9 = str29;
                                    str3 = str22;
                                    z = z3;
                                    str10 = str28;
                                    str11 = str27;
                                    str = str21;
                                    str5 = str20;
                                    str6 = str17;
                                    str7 = str19;
                                    str8 = str26;
                                }
                            }
                            str19 = null;
                            if ((j & 49168) != 0) {
                            }
                            str20 = null;
                            if ((j & 49184) != 0) {
                            }
                            str21 = null;
                            if ((j & 49216) != 0) {
                            }
                            str22 = null;
                            if ((j & 49280) != 0) {
                            }
                            str23 = null;
                            if ((j & 49408) != 0) {
                            }
                            str24 = null;
                            if ((j & 49664) != 0) {
                            }
                            str25 = null;
                            if ((j & 50176) == 0) {
                            }
                            if ((j & 51200) != 0) {
                            }
                            str29 = null;
                            if ((j & 53248) != 0) {
                            }
                            date3 = null;
                            if ((j & 57344) != 0) {
                            }
                            date = date3;
                            str2 = str23;
                            str4 = str24;
                            str12 = null;
                            str9 = str29;
                            str3 = str22;
                            z = z3;
                            str10 = str28;
                            str11 = str27;
                            str = str21;
                            str5 = str20;
                            str6 = str17;
                            str7 = str19;
                            str8 = str26;
                        }
                    }
                    str18 = null;
                    if ((j & 49160) != 0) {
                    }
                    str19 = null;
                    if ((j & 49168) != 0) {
                    }
                    str20 = null;
                    if ((j & 49184) != 0) {
                    }
                    str21 = null;
                    if ((j & 49216) != 0) {
                    }
                    str22 = null;
                    if ((j & 49280) != 0) {
                    }
                    str23 = null;
                    if ((j & 49408) != 0) {
                    }
                    str24 = null;
                    if ((j & 49664) != 0) {
                    }
                    str25 = null;
                    if ((j & 50176) == 0) {
                    }
                    if ((j & 51200) != 0) {
                    }
                    str29 = null;
                    if ((j & 53248) != 0) {
                    }
                    date3 = null;
                    if ((j & 57344) != 0) {
                    }
                    date = date3;
                    str2 = str23;
                    str4 = str24;
                    str12 = null;
                    str9 = str29;
                    str3 = str22;
                    z = z3;
                    str10 = str28;
                    str11 = str27;
                    str = str21;
                    str5 = str20;
                    str6 = str17;
                    str7 = str19;
                    str8 = str26;
                }
            }
            str17 = null;
            if ((j & 49156) != 0) {
            }
            str18 = null;
            if ((j & 49160) != 0) {
            }
            str19 = null;
            if ((j & 49168) != 0) {
            }
            str20 = null;
            if ((j & 49184) != 0) {
            }
            str21 = null;
            if ((j & 49216) != 0) {
            }
            str22 = null;
            if ((j & 49280) != 0) {
            }
            str23 = null;
            if ((j & 49408) != 0) {
            }
            str24 = null;
            if ((j & 49664) != 0) {
            }
            str25 = null;
            if ((j & 50176) == 0) {
            }
            if ((j & 51200) != 0) {
            }
            str29 = null;
            if ((j & 53248) != 0) {
            }
            date3 = null;
            if ((j & 57344) != 0) {
            }
            date = date3;
            str2 = str23;
            str4 = str24;
            str12 = null;
            str9 = str29;
            str3 = str22;
            z = z3;
            str10 = str28;
            str11 = str27;
            str = str21;
            str5 = str20;
            str6 = str17;
            str7 = str19;
            str8 = str26;
        } else {
            z = false;
            str12 = null;
            str11 = null;
            str10 = null;
            str9 = null;
            date = null;
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) != 0) {
            str16 = str9;
            str15 = str7;
            this.mboundView1.setOnClickListener(this.mCallback66);
            date2 = date;
            TextViewBindingAdapter.BeforeTextChanged beforeTextChanged = null;
            str14 = str12;
            TextViewBindingAdapter.OnTextChanged onTextChanged = null;
            TextViewBindingAdapter.AfterTextChanged afterTextChanged = null;
            str13 = str2;
            TextViewBindingAdapter.setTextWatcher(this.mboundView10, beforeTextChanged, onTextChanged, afterTextChanged, this.mboundView10androidTextAttrChanged);
            TextViewBindingAdapter.setTextWatcher(this.mboundView11, beforeTextChanged, onTextChanged, afterTextChanged, this.mboundView11androidTextAttrChanged);
            TextViewBindingAdapter.setTextWatcher(this.mboundView12, beforeTextChanged, onTextChanged, afterTextChanged, this.mboundView12androidTextAttrChanged);
            TextViewBindingAdapter.setTextWatcher(this.mboundView13, beforeTextChanged, onTextChanged, afterTextChanged, this.mboundView13androidTextAttrChanged);
            TextViewBindingAdapter.setTextWatcher(this.mboundView14, beforeTextChanged, onTextChanged, afterTextChanged, this.mboundView14androidTextAttrChanged);
            this.mboundView15.setOnClickListener(this.mCallback67);
            TextViewBindingAdapter.setTextWatcher(this.mboundView7, beforeTextChanged, onTextChanged, afterTextChanged, this.mboundView7androidTextAttrChanged);
            TextViewBindingAdapter.setTextWatcher(this.mboundView8, beforeTextChanged, onTextChanged, afterTextChanged, this.mboundView8androidTextAttrChanged);
            TextViewBindingAdapter.setTextWatcher(this.mboundView9, beforeTextChanged, onTextChanged, afterTextChanged, this.mboundView9androidTextAttrChanged);
        } else {
            str14 = str12;
            str16 = str9;
            date2 = date;
            str15 = str7;
            str13 = str2;
        }
        if ((j & 49156) != 0) {
            TextViewBindingAdapter.setText(this.mboundView10, str8);
        }
        if ((j & 49154) != 0) {
            TextViewBindingAdapter.setText(this.mboundView11, str6);
        }
        if ((j & 49664) != 0) {
            TextViewBindingAdapter.setText(this.mboundView12, str11);
        }
        if ((j & 49408) != 0) {
            TextViewBindingAdapter.setText(this.mboundView13, str4);
        }
        if ((j & 49216) != 0) {
            TextViewBindingAdapter.setText(this.mboundView14, str3);
        }
        if ((j & 49153) != 0) {
            this.mboundView15.setEnabled(z);
        }
        if ((50176 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, str10);
        }
        if ((j & 49168) != 0) {
            TextViewBindingAdapter.setText(this.mboundView3, str5);
        }
        if ((49280 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str13);
        }
        if ((57344 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView5, str14);
        }
        if ((53248 & j) != 0) {
            BindingAdaptersKt.bindServerDate(this.mboundView6, date2);
        }
        if ((j & 49160) != 0) {
            TextViewBindingAdapter.setText(this.mboundView7, str15);
        }
        if ((51200 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView8, str16);
        }
        if ((j & 49184) != 0) {
            TextViewBindingAdapter.setText(this.mboundView9, str);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            HarvestTagViewModel harvestTagViewModel = this.mVm;
            if (harvestTagViewModel != null) {
                z = true;
            }
            if (z) {
                harvestTagViewModel.backToScanner();
            }
        } else if (i == 2) {
            HarvestTagViewModel harvestTagViewModel2 = this.mVm;
            if (harvestTagViewModel2 != null) {
                z = true;
            }
            if (z) {
                harvestTagViewModel2.submitSummary();
            }
        }
    }
}
