package com.digitalwallet.viewmodel.checkIn.checkInShortcut;

import android.content.Context;
import android.content.res.Resources;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.model.CheckInHistoryCombo;
import com.digitalwallet.model.CheckInShortcuts;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.openid.appauth.ResponseTypeValues;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010;\u001a\u00020\bJ\u0010\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020>H\u0002J\u0006\u0010?\u001a\u00020\bJ\u000e\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020)J\u0006\u0010B\u001a\u00020\bJ\b\u0010C\u001a\u00020\bH\u0002J\u0006\u0010D\u001a\u00020\bJ\u0018\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020HH\u0002J\u0006\u0010I\u001a\u00020\bJ\u0006\u0010J\u001a\u00020\bJ\u0006\u0010K\u001a\u00020\bJ\u0016\u0010L\u001a\u00020\b2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020%0 H\u0002J\u0016\u0010N\u001a\u00020\b2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020'0 H\u0002J\u0006\u0010P\u001a\u00020\bR\u0016\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\bX\u0004¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\r\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R'\u0010\u0012\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00140\u0013j\b\u0012\u0004\u0012\u00020\b`\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0 0\u001fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0 0\u001fX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010(\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010)0)0\u001f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u001d\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0 0\u001f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0011\u0010/\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0011R\u0011\u00100\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0011R\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R'\u00105\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00140\u0013j\b\u0012\u0004\u0012\u00020%`\u0015¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0017RC\u00107\u001a4\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000209\u0012\u0006\u0012\u0004\u0018\u00010%080\u00140\u0013j\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000209\u0012\u0006\u0012\u0004\u0018\u00010%08`\u0015¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0017¨\u0006Q"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/CheckInShortcutViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "context", "Landroid/content/Context;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "(Landroid/content/Context;Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;)V", "_favouritesChanged", "", "get_favouritesChanged$annotations", "()V", "Lkotlin/Unit;", "_historyChanged", "get_historyChanged$annotations", "areAllRowsSelected", "Landroidx/databinding/ObservableBoolean;", "getAreAllRowsSelected", "()Landroidx/databinding/ObservableBoolean;", "backEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getBackEvent", "()Landroidx/lifecycle/MutableLiveData;", "getCheckInRepository", "()Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "favouriteItemsTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "getFavouriteItemsTouchHelper", "()Landroidx/recyclerview/widget/ItemTouchHelper;", "favouriteRowVMs", "Landroidx/databinding/ObservableField;", "", "Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/FavouriteRowViewModel;", "getFavouriteRowVMs", "()Landroidx/databinding/ObservableField;", "favourites", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "history", "Lcom/digitalwallet/model/CheckInHistoryCombo;", "historyLocationQuery", "", "kotlin.jvm.PlatformType", "getHistoryLocationQuery", "historyRowVMs", "Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/HistoryRowViewModel;", "getHistoryRowVMs", "isEditMode", "isHistoryView", "selectedRowsCount", "Landroidx/databinding/ObservableInt;", "getSelectedRowsCount", "()Landroidx/databinding/ObservableInt;", "toFavouriteCheckInEvent", "getToFavouriteCheckInEvent", "toHistoryDetailEvent", "Lkotlin/Pair;", "Lcom/digitalwallet/model/CheckIn;", "getToHistoryDetailEvent", "cancelEditing", "changeEditingStatus", "isEditing", "", "confirmedToDelete", "filterHistoryItems", "locationQuery", "goBack", "onRowSelectionsChanged", "refreshData", "reorderAFavourite", ResponseTypeValues.CODE, "toIndex", "", "selectFavouritesTab", "selectHistoryTab", "selectOrDeselectAllEdits", "setFavouritesToRowVMs", "favouritesData", "setHistoryToRowVMs", "historyData", "startEditing", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInShortcutViewModel.kt */
public final class CheckInShortcutViewModel extends BaseViewModel {
    private final Unit _favouritesChanged;
    private final Unit _historyChanged;
    private final ObservableBoolean areAllRowsSelected = new ObservableBoolean(false);
    private final MutableLiveData<ActionEvent<Unit>> backEvent;
    private final CheckInRepository checkInRepository;
    private final Context context;
    private final ItemTouchHelper favouriteItemsTouchHelper;
    private final ObservableField<List<FavouriteRowViewModel>> favouriteRowVMs;
    private final ObservableField<List<CheckInUtils.CheckInCode>> favourites;
    private final ObservableField<List<CheckInHistoryCombo>> history;
    private final ObservableField<String> historyLocationQuery = new ObservableField<>("");
    private final ObservableField<List<HistoryRowViewModel>> historyRowVMs;
    private final ObservableBoolean isEditMode = new ObservableBoolean(false);
    private final ObservableBoolean isHistoryView = new ObservableBoolean(true);
    private final ObservableInt selectedRowsCount = new ObservableInt(0);
    private final MutableLiveData<ActionEvent<CheckInUtils.CheckInCode>> toFavouriteCheckInEvent;
    private final MutableLiveData<ActionEvent<Pair<CheckIn, CheckInUtils.CheckInCode>>> toHistoryDetailEvent;

    private static /* synthetic */ void get_favouritesChanged$annotations() {
    }

    private static /* synthetic */ void get_historyChanged$annotations() {
    }

    public final CheckInRepository getCheckInRepository() {
        return this.checkInRepository;
    }

    @Inject
    public CheckInShortcutViewModel(Context context2, CheckInRepository checkInRepository2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(checkInRepository2, "checkInRepository");
        this.context = context2;
        this.checkInRepository = checkInRepository2;
        ObservableField<List<CheckInHistoryCombo>> observableField = new ObservableField<>(CollectionsKt.emptyList());
        this.history = observableField;
        ObservableField<List<CheckInUtils.CheckInCode>> observableField2 = new ObservableField<>(CollectionsKt.emptyList());
        this.favourites = observableField2;
        this.historyRowVMs = new ObservableField<>(CollectionsKt.emptyList());
        this.favouriteRowVMs = new ObservableField<>(CollectionsKt.emptyList());
        observableField.addOnPropertyChangedCallback(new CheckInShortcutViewModel$_historyChanged$1(this));
        this._historyChanged = Unit.INSTANCE;
        observableField2.addOnPropertyChangedCallback(new CheckInShortcutViewModel$_favouritesChanged$1(this));
        this._favouritesChanged = Unit.INSTANCE;
        this.backEvent = new MutableLiveData<>();
        this.toHistoryDetailEvent = new MutableLiveData<>();
        this.toFavouriteCheckInEvent = new MutableLiveData<>();
        this.favouriteItemsTouchHelper = (ItemTouchHelper) new CheckInShortcutViewModel$favouriteItemsTouchHelper$1(this).invoke();
    }

    public final ObservableBoolean isHistoryView() {
        return this.isHistoryView;
    }

    public final ObservableBoolean isEditMode() {
        return this.isEditMode;
    }

    public final ObservableInt getSelectedRowsCount() {
        return this.selectedRowsCount;
    }

    public final ObservableBoolean getAreAllRowsSelected() {
        return this.areAllRowsSelected;
    }

    public final ObservableField<String> getHistoryLocationQuery() {
        return this.historyLocationQuery;
    }

    public final ObservableField<List<HistoryRowViewModel>> getHistoryRowVMs() {
        return this.historyRowVMs;
    }

    public final ObservableField<List<FavouriteRowViewModel>> getFavouriteRowVMs() {
        return this.favouriteRowVMs;
    }

    /* access modifiers changed from: private */
    public final void setHistoryToRowVMs(List<CheckInHistoryCombo> list) {
        T t;
        ObservableBoolean checked;
        List<HistoryRowViewModel> list2 = this.historyRowVMs.get();
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        boolean z = this.isEditMode.get() && this.isHistoryView.get();
        List<CheckInHistoryCombo> list3 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (T t2 : list3) {
            CheckIn component1 = t2.component1();
            CheckInUtils.CheckInCode component2 = t2.component2();
            Resources resources = this.context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            Iterator<T> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (Intrinsics.areEqual(t.getHistory(), component1)) {
                    break;
                }
            }
            T t3 = t;
            arrayList.add(new HistoryRowViewModel(component1, resources, z, (t3 == null || (checked = t3.getChecked()) == null || !checked.get()) ? false : true, new CheckInShortcutViewModel$setHistoryToRowVMs$$inlined$map$lambda$1(component1, component2, this, z, list2), new CheckInShortcutViewModel$setHistoryToRowVMs$rowVMs$1$3(this)));
            arrayList = arrayList;
        }
        ArrayList arrayList2 = arrayList;
        HistoryRowViewModel historyRowViewModel = (HistoryRowViewModel) CollectionsKt.firstOrNull((List) arrayList2);
        if (historyRowViewModel != null) {
            historyRowViewModel.isActiveCheckIn().set(this.checkInRepository.isActiveCheckIn(historyRowViewModel.getHistory()));
        }
        this.historyRowVMs.set(arrayList2);
        onRowSelectionsChanged();
    }

    /* access modifiers changed from: private */
    public final void setFavouritesToRowVMs(List<CheckInUtils.CheckInCode> list) {
        T t;
        ObservableBoolean checked;
        List<FavouriteRowViewModel> list2 = this.favouriteRowVMs.get();
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        boolean z = this.isEditMode.get() && !this.isHistoryView.get();
        List<CheckInUtils.CheckInCode> list3 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (T t2 : list3) {
            Iterator<T> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (Intrinsics.areEqual(t.getFavourite(), t2)) {
                    break;
                }
            }
            T t3 = t;
            arrayList.add(new FavouriteRowViewModel(t2, z, (t3 == null || (checked = t3.getChecked()) == null || !checked.get()) ? false : true, new CheckInShortcutViewModel$setFavouritesToRowVMs$$inlined$map$lambda$1(t2, this, z, list2), new CheckInShortcutViewModel$setFavouritesToRowVMs$rowVMs$1$3(this)));
        }
        this.favouriteRowVMs.set(arrayList);
        onRowSelectionsChanged();
    }

    public final MutableLiveData<ActionEvent<Unit>> getBackEvent() {
        return this.backEvent;
    }

    public final MutableLiveData<ActionEvent<Pair<CheckIn, CheckInUtils.CheckInCode>>> getToHistoryDetailEvent() {
        return this.toHistoryDetailEvent;
    }

    public final MutableLiveData<ActionEvent<CheckInUtils.CheckInCode>> getToFavouriteCheckInEvent() {
        return this.toFavouriteCheckInEvent;
    }

    public final void refreshData() {
        HistoryRowViewModel historyRowViewModel;
        CheckInShortcuts checkInShortcuts = this.checkInRepository.getCheckInShortcuts();
        ArrayList arrayList = new ArrayList();
        for (T t : checkInShortcuts.getHistoryItems()) {
            if (!t.isHidden()) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!Intrinsics.areEqual(this.history.get(), arrayList2)) {
            this.history.set(arrayList2);
            String str = this.historyLocationQuery.get();
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                filterHistoryItems(str);
            }
        } else {
            List<HistoryRowViewModel> list = this.historyRowVMs.get();
            if (!(list == null || (historyRowViewModel = (HistoryRowViewModel) CollectionsKt.firstOrNull((List) list)) == null)) {
                historyRowViewModel.isActiveCheckIn().set(this.checkInRepository.isActiveCheckIn(historyRowViewModel.getHistory()));
            }
        }
        List<CheckInUtils.CheckInCode> favourites2 = checkInShortcuts.getFavourites();
        if (!Intrinsics.areEqual(this.favourites.get(), favourites2)) {
            this.favourites.set(favourites2);
        }
    }

    public final void goBack() {
        ActionEventKt.post(this.backEvent);
    }

    public final void startEditing() {
        changeEditingStatus(true);
    }

    public final void cancelEditing() {
        changeEditingStatus(false);
    }

    public final void selectOrDeselectAllEdits() {
        List<FavouriteRowViewModel> list;
        boolean z = !this.areAllRowsSelected.get();
        if (this.isHistoryView.get()) {
            list = this.historyRowVMs.get();
        } else {
            list = this.favouriteRowVMs.get();
        }
        if (list != null) {
            for (ShortcutRowBaseViewModel shortcutRowBaseViewModel : list) {
                shortcutRowBaseViewModel.getChecked().set(z);
            }
        }
    }

    public final void selectFavouritesTab() {
        if (this.isHistoryView.get()) {
            cancelEditing();
            refreshData();
            this.isHistoryView.set(false);
        }
    }

    public final void selectHistoryTab() {
        if (!this.isHistoryView.get()) {
            cancelEditing();
            refreshData();
            this.isHistoryView.set(true);
        }
    }

    public final void confirmedToDelete() {
        if (this.isHistoryView.get()) {
            List<HistoryRowViewModel> list = this.historyRowVMs.get();
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (T t : list) {
                    if (t.getChecked().get()) {
                        arrayList.add(t);
                    }
                }
                ArrayList<HistoryRowViewModel> arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                for (HistoryRowViewModel historyRowViewModel : arrayList2) {
                    arrayList3.add(historyRowViewModel.getHistory());
                }
                this.checkInRepository.hideSomeCheckInHistory(arrayList3);
            }
        } else {
            List<FavouriteRowViewModel> list2 = this.favouriteRowVMs.get();
            if (list2 != null) {
                ArrayList arrayList4 = new ArrayList();
                for (T t2 : list2) {
                    if (t2.getChecked().get()) {
                        arrayList4.add(t2);
                    }
                }
                ArrayList<FavouriteRowViewModel> arrayList5 = arrayList4;
                ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
                for (FavouriteRowViewModel favouriteRowViewModel : arrayList5) {
                    arrayList6.add(favouriteRowViewModel.getFavourite());
                }
                this.checkInRepository.removeSomeCheckInFavourites(arrayList6);
            }
        }
        refreshData();
        cancelEditing();
    }

    public final void filterHistoryItems(String str) {
        Intrinsics.checkNotNullParameter(str, "locationQuery");
        this.historyLocationQuery.set(str);
        ArrayList arrayList = this.history.get();
        if (arrayList == null) {
            arrayList = CollectionsKt.emptyList();
        }
        String str2 = str;
        if (!(str2.length() == 0)) {
            ArrayList arrayList2 = new ArrayList();
            for (T t : arrayList) {
                String locationName = t.getCheckInItem().getLocationName();
                if (locationName != null && StringsKt.contains(locationName, str2, true)) {
                    arrayList2.add(t);
                }
            }
            arrayList = arrayList2;
        }
        setHistoryToRowVMs(arrayList);
    }

    public final ItemTouchHelper getFavouriteItemsTouchHelper() {
        return this.favouriteItemsTouchHelper;
    }

    /* access modifiers changed from: private */
    public final void reorderAFavourite(CheckInUtils.CheckInCode checkInCode, int i) {
        this.checkInRepository.removeSomeCheckInFavourites(CollectionsKt.listOf(checkInCode));
        this.checkInRepository.addACheckInFavouriteIfNotExists(checkInCode, Integer.valueOf(i));
    }

    private final void changeEditingStatus(boolean z) {
        this.isEditMode.set(z);
        if (this.isHistoryView.get()) {
            List<HistoryRowViewModel> list = this.historyRowVMs.get();
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    it.next().getEditing().set(z);
                }
                return;
            }
            return;
        }
        List<FavouriteRowViewModel> list2 = this.favouriteRowVMs.get();
        if (list2 != null) {
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().getEditing().set(z);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void onRowSelectionsChanged() {
        List<FavouriteRowViewModel> list;
        int i;
        if (this.isHistoryView.get()) {
            list = this.historyRowVMs.get();
        } else {
            list = this.favouriteRowVMs.get();
        }
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<FavouriteRowViewModel> list2 = list;
        boolean z = false;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            i = 0;
            for (ShortcutRowBaseViewModel shortcutRowBaseViewModel : list2) {
                if (shortcutRowBaseViewModel.getChecked().get() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        } else {
            i = 0;
        }
        this.selectedRowsCount.set(i);
        ObservableBoolean observableBoolean = this.areAllRowsSelected;
        if (i > 0 && i == list.size()) {
            z = true;
        }
        observableBoolean.set(z);
    }
}
