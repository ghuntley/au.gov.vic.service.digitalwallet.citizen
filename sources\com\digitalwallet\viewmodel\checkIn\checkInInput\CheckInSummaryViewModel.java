package com.digitalwallet.viewmodel.checkIn.checkInInput;

import android.content.Context;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.model.CheckInGuest;
import com.digitalwallet.model.DependantCheckIn;
import com.digitalwallet.model.PrimaryPersonCheckIn;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020<J\u001e\u0010=\u001a\u00020\n2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010;\u001a\u00020<H\u0002J\u000e\u0010?\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u0018J\u000e\u0010@\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u0018J\u000e\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020.J\u0012\u0010C\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010\u0018H\u0002J\u0006\u0010E\u001a\u00020\nJ\u0006\u0010F\u001a\u00020\nJ\b\u0010G\u001a\u00020\nH\u0002J \u0010H\u001a\u00020\n2\u0006\u00104\u001a\u00020.2\b\u0010D\u001a\u0004\u0018\u00010\u00182\u0006\u00107\u001a\u00020<R\u0016\u0010\t\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u0012\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u0012\u0004\b\u000f\u0010\fR\u001f\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aXD¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00170\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u001f\u0010\"\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R?\u0010$\u001a0\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'0&0%j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'`*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R'\u0010-\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0&0%j\b\u0012\u0004\u0012\u00020.`*¢\u0006\b\n\u0000\u001a\u0004\b/\u0010,R'\u00100\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180&0%j\b\u0012\u0004\u0012\u00020\u0018`*¢\u0006\b\n\u0000\u001a\u0004\b1\u0010,R'\u00102\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0&0%j\b\u0012\u0004\u0012\u00020.`*¢\u0006\b\n\u0000\u001a\u0004\b3\u0010,R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020.0\u0011X\u0004¢\u0006\u0002\n\u0000R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020 0\u0011¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0015R\u0011\u00107\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001e¨\u0006I"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInSummaryViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "context", "Landroid/content/Context;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Landroid/content/Context;Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "_dependantsChanged", "", "get_dependantsChanged$annotations", "()V", "Lkotlin/Unit;", "_primaryPersonChanged", "get_primaryPersonChanged$annotations", "addDependantHeader", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getAddDependantHeader", "()Landroidx/databinding/ObservableField;", "dependantCheckIns", "", "Lcom/digitalwallet/model/DependantCheckIn;", "dependantCountLimit", "", "dependantCountLimitReached", "Landroidx/databinding/ObservableBoolean;", "getDependantCountLimitReached", "()Landroidx/databinding/ObservableBoolean;", "dependantRowVMs", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/PersonRowViewModel;", "getDependantRowVMs", "locationName", "getLocationName", "navigateToSubmitting", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "Lkotlin/Pair;", "Lcom/digitalwallet/model/CheckIn;", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getNavigateToSubmitting", "()Landroidx/lifecycle/MutableLiveData;", "presentAddDependant", "Lcom/digitalwallet/model/PrimaryPersonCheckIn;", "getPresentAddDependant", "presentEditDependant", "getPresentEditDependant", "presentEditPrimary", "getPresentEditPrimary", "primaryPersonCheckIn", "primaryPersonRowVM", "getPrimaryPersonRowVM", "showBack", "getShowBack", "appendADependant", "dependant", "initiallyChecked", "", "appendDependants", "dependants", "deleteADependant", "editADependant", "editThePrimaryPerson", "primaryPerson", "initDependants", "firstDependantCheckIn", "onAddADependantClicked", "onCheckIn", "onDependantSelectionsChanged", "setup", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInSummaryViewModel.kt */
public final class CheckInSummaryViewModel extends BaseViewModel {
    private final Unit _dependantsChanged;
    private final Unit _primaryPersonChanged;
    private final ObservableField<String> addDependantHeader = new ObservableField<>("");
    private final AnalyticsHelper analytics;
    private final CheckInRepository checkInRepository;
    private final Context context;
    private final ObservableField<List<DependantCheckIn>> dependantCheckIns;
    private final int dependantCountLimit = 10;
    private final ObservableBoolean dependantCountLimitReached = new ObservableBoolean(false);
    private final ObservableField<List<PersonRowViewModel>> dependantRowVMs;
    private final ObservableField<String> locationName = new ObservableField<>("");
    private final MutableLiveData<ActionEvent<Pair<CheckIn, CheckInUtils.CheckInCode>>> navigateToSubmitting;
    private final MutableLiveData<ActionEvent<PrimaryPersonCheckIn>> presentAddDependant;
    private final MutableLiveData<ActionEvent<DependantCheckIn>> presentEditDependant;
    private final MutableLiveData<ActionEvent<PrimaryPersonCheckIn>> presentEditPrimary;
    private final ObservableField<PrimaryPersonCheckIn> primaryPersonCheckIn;
    private final ObservableField<PersonRowViewModel> primaryPersonRowVM;
    private final ObservableBoolean showBack = new ObservableBoolean(false);

    private static /* synthetic */ void get_dependantsChanged$annotations() {
    }

    private static /* synthetic */ void get_primaryPersonChanged$annotations() {
    }

    @Inject
    public CheckInSummaryViewModel(Context context2, CheckInRepository checkInRepository2, AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(checkInRepository2, "checkInRepository");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.context = context2;
        this.checkInRepository = checkInRepository2;
        this.analytics = analyticsHelper;
        ObservableField<PrimaryPersonCheckIn> observableField = new ObservableField<>();
        this.primaryPersonCheckIn = observableField;
        this.primaryPersonRowVM = new ObservableField<>();
        ObservableField<List<DependantCheckIn>> observableField2 = new ObservableField<>();
        this.dependantCheckIns = observableField2;
        this.dependantRowVMs = new ObservableField<>();
        observableField.addOnPropertyChangedCallback(new CheckInSummaryViewModel$_primaryPersonChanged$1(this));
        this._primaryPersonChanged = Unit.INSTANCE;
        observableField2.addOnPropertyChangedCallback(new CheckInSummaryViewModel$_dependantsChanged$1(this));
        this._dependantsChanged = Unit.INSTANCE;
        this.presentAddDependant = new MutableLiveData<>();
        this.presentEditPrimary = new MutableLiveData<>();
        this.presentEditDependant = new MutableLiveData<>();
        this.navigateToSubmitting = new MutableLiveData<>();
    }

    public final ObservableBoolean getShowBack() {
        return this.showBack;
    }

    public final ObservableField<String> getLocationName() {
        return this.locationName;
    }

    public final ObservableField<String> getAddDependantHeader() {
        return this.addDependantHeader;
    }

    public final ObservableBoolean getDependantCountLimitReached() {
        return this.dependantCountLimitReached;
    }

    public final ObservableField<PersonRowViewModel> getPrimaryPersonRowVM() {
        return this.primaryPersonRowVM;
    }

    public final ObservableField<List<PersonRowViewModel>> getDependantRowVMs() {
        return this.dependantRowVMs;
    }

    public final MutableLiveData<ActionEvent<PrimaryPersonCheckIn>> getPresentAddDependant() {
        return this.presentAddDependant;
    }

    public final MutableLiveData<ActionEvent<PrimaryPersonCheckIn>> getPresentEditPrimary() {
        return this.presentEditPrimary;
    }

    public final MutableLiveData<ActionEvent<DependantCheckIn>> getPresentEditDependant() {
        return this.presentEditDependant;
    }

    public final MutableLiveData<ActionEvent<Pair<CheckIn, CheckInUtils.CheckInCode>>> getNavigateToSubmitting() {
        return this.navigateToSubmitting;
    }

    public final void setup(PrimaryPersonCheckIn primaryPersonCheckIn2, DependantCheckIn dependantCheckIn, boolean z) {
        Intrinsics.checkNotNullParameter(primaryPersonCheckIn2, "primaryPersonCheckIn");
        this.primaryPersonCheckIn.set(primaryPersonCheckIn2);
        this.showBack.set(z);
        this.locationName.set(primaryPersonCheckIn2.getCheckInCode().getLocation());
        initDependants(dependantCheckIn);
    }

    private final void initDependants(DependantCheckIn dependantCheckIn) {
        ArrayList arrayList = new ArrayList();
        for (T t : this.checkInRepository.getSavedDependants()) {
            if (true ^ Intrinsics.areEqual(t.getInternalId(), dependantCheckIn != null ? dependantCheckIn.getInternalId() : null)) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (dependantCheckIn != null) {
            appendADependant(dependantCheckIn, true);
        }
        appendDependants(arrayList2, false);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062  */
    public final void onDependantSelectionsChanged() {
        int i;
        String str;
        List<PersonRowViewModel> list = this.dependantRowVMs.get();
        if (list != null) {
            List<PersonRowViewModel> list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (it.next().getChecked().get() && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
                ObservableField<String> observableField = this.addDependantHeader;
                if (i != 0) {
                    str = this.context.getString(R.string.check_in_dependant_header_0_selected);
                } else if (i != 1) {
                    str = this.context.getString(R.string.check_in_dependant_header_n_selected, Integer.valueOf(i));
                } else {
                    str = this.context.getString(R.string.check_in_dependant_header_1_selected);
                }
                observableField.set(str);
            }
        }
        i = 0;
        ObservableField<String> observableField2 = this.addDependantHeader;
        if (i != 0) {
        }
        observableField2.set(str);
    }

    public final void onAddADependantClicked() {
        PrimaryPersonCheckIn primaryPersonCheckIn2 = this.primaryPersonCheckIn.get();
        if (primaryPersonCheckIn2 != null) {
            ActionEventKt.postEvent(this.presentAddDependant, primaryPersonCheckIn2);
        }
    }

    public final void onCheckIn() {
        CheckIn checkInPayload;
        PrimaryPersonCheckIn primaryPersonCheckIn2;
        CheckInUtils.CheckInCode checkInCode;
        ArrayList arrayList = null;
        AnalyticsHelper.selectContent$default(this.analytics, "Button click - Check in to this location", null, 2, null);
        PrimaryPersonCheckIn primaryPersonCheckIn3 = this.primaryPersonCheckIn.get();
        if (!(primaryPersonCheckIn3 == null || (checkInPayload = primaryPersonCheckIn3.getCheckInPayload()) == null || (primaryPersonCheckIn2 = this.primaryPersonCheckIn.get()) == null || (checkInCode = primaryPersonCheckIn2.getCheckInCode()) == null)) {
            Calendar instance = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
            Date time = instance.getTime();
            List<PersonRowViewModel> list = this.dependantRowVMs.get();
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                for (T t : list) {
                    if (t.getChecked().get()) {
                        arrayList2.add(t);
                    }
                }
                ArrayList<PersonRowViewModel> arrayList3 = arrayList2;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                for (PersonRowViewModel personRowViewModel : arrayList3) {
                    String firstName = personRowViewModel.getFirstName();
                    String lastName = personRowViewModel.getLastName();
                    String phoneNumber = personRowViewModel.getPhoneNumber();
                    arrayList4.add(new CheckInGuest(firstName, lastName, phoneNumber == null || StringsKt.isBlank(phoneNumber) ? null : personRowViewModel.getPhoneNumber()));
                }
                arrayList = arrayList4;
            }
            checkInPayload.setDate(time);
            checkInPayload.setGuests(arrayList);
            ActionEventKt.postEvent(this.navigateToSubmitting, TuplesKt.to(checkInPayload, checkInCode));
        }
    }

    public final void appendADependant(DependantCheckIn dependantCheckIn, boolean z) {
        Intrinsics.checkNotNullParameter(dependantCheckIn, "dependant");
        appendDependants(CollectionsKt.listOf(dependantCheckIn), z);
    }

    private final void appendDependants(List<DependantCheckIn> list, boolean z) {
        ObservableField<List<DependantCheckIn>> observableField = this.dependantCheckIns;
        List<DependantCheckIn> list2 = observableField.get();
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        List<DependantCheckIn> list3 = list;
        observableField.set(CollectionsKt.plus((Collection) list2, (Iterable) list3));
        ObservableField<List<PersonRowViewModel>> observableField2 = this.dependantRowVMs;
        List<PersonRowViewModel> list4 = observableField2.get();
        if (list4 == null) {
            list4 = CollectionsKt.emptyList();
        }
        List<PersonRowViewModel> list5 = list4;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (T t : list3) {
            arrayList.add(new PersonRowViewModel(true, z, t.getGuestPayload().getFirstName(), t.getGuestPayload().getLastName(), t.getGuestPayload().getPhoneNumber(), new CheckInSummaryViewModel$appendDependants$1$1(this), new CheckInSummaryViewModel$appendDependants$$inlined$map$lambda$1(t, this, z)));
        }
        observableField2.set(CollectionsKt.plus((Collection) list5, (Iterable) arrayList));
        onDependantSelectionsChanged();
    }

    public final void editThePrimaryPerson(PrimaryPersonCheckIn primaryPersonCheckIn2) {
        Intrinsics.checkNotNullParameter(primaryPersonCheckIn2, "primaryPerson");
        this.primaryPersonCheckIn.set(primaryPersonCheckIn2);
        this.locationName.set(primaryPersonCheckIn2.getCheckInCode().getLocation());
    }

    public final void editADependant(DependantCheckIn dependantCheckIn) {
        Intrinsics.checkNotNullParameter(dependantCheckIn, "dependant");
        List<DependantCheckIn> list = this.dependantCheckIns.get();
        int i = -1;
        if (list != null) {
            int i2 = 0;
            Iterator<DependantCheckIn> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(it.next().getInternalId(), dependantCheckIn.getInternalId())) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
        }
        if (i >= 0) {
            List<DependantCheckIn> list2 = this.dependantCheckIns.get();
            Intrinsics.checkNotNull(list2);
            Intrinsics.checkNotNullExpressionValue(list2, "dependantCheckIns.get()!!");
            List<DependantCheckIn> mutableList = CollectionsKt.toMutableList((Collection) list2);
            mutableList.set(i, dependantCheckIn);
            this.dependantCheckIns.set(mutableList);
            List<PersonRowViewModel> list3 = this.dependantRowVMs.get();
            Intrinsics.checkNotNull(list3);
            PersonRowViewModel personRowViewModel = list3.get(i);
            List<PersonRowViewModel> list4 = this.dependantRowVMs.get();
            Intrinsics.checkNotNull(list4);
            Intrinsics.checkNotNullExpressionValue(list4, "dependantRowVMs.get()!!");
            List<PersonRowViewModel> mutableList2 = CollectionsKt.toMutableList((Collection) list4);
            mutableList2.set(i, new PersonRowViewModel(true, personRowViewModel.getChecked().get(), dependantCheckIn.getGuestPayload().getFirstName(), dependantCheckIn.getGuestPayload().getLastName(), dependantCheckIn.getGuestPayload().getPhoneNumber(), new CheckInSummaryViewModel$editADependant$newVMs$1$1(this), new CheckInSummaryViewModel$editADependant$$inlined$apply$lambda$1(this, i, personRowViewModel, dependantCheckIn)));
            this.dependantRowVMs.set(mutableList2);
        }
        onDependantSelectionsChanged();
    }

    public final void deleteADependant(DependantCheckIn dependantCheckIn) {
        Intrinsics.checkNotNullParameter(dependantCheckIn, "dependant");
        List<DependantCheckIn> list = this.dependantCheckIns.get();
        int i = -1;
        if (list != null) {
            int i2 = 0;
            Iterator<DependantCheckIn> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(it.next().getInternalId(), dependantCheckIn.getInternalId())) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
        }
        if (i >= 0) {
            List<DependantCheckIn> list2 = this.dependantCheckIns.get();
            Intrinsics.checkNotNull(list2);
            Intrinsics.checkNotNullExpressionValue(list2, "dependantCheckIns.get()!!");
            List<DependantCheckIn> mutableList = CollectionsKt.toMutableList((Collection) list2);
            mutableList.remove(i);
            this.dependantCheckIns.set(mutableList);
            List<PersonRowViewModel> list3 = this.dependantRowVMs.get();
            Intrinsics.checkNotNull(list3);
            Intrinsics.checkNotNullExpressionValue(list3, "dependantRowVMs.get()!!");
            List<PersonRowViewModel> mutableList2 = CollectionsKt.toMutableList((Collection) list3);
            mutableList2.remove(i);
            this.dependantRowVMs.set(mutableList2);
        }
        onDependantSelectionsChanged();
    }
}
