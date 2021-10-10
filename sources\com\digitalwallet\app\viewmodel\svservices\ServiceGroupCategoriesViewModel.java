package com.digitalwallet.app.viewmodel.svservices;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.app.model.login.SVCategory;
import com.digitalwallet.app.model.login.SVService;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017R'\u0010\u0003\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR'\u0010\u0010\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0011`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/digitalwallet/app/viewmodel/svservices/ServiceGroupCategoriesViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "()V", "goBackEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getGoBackEvent", "()Landroidx/lifecycle/MutableLiveData;", "groupName", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getGroupName", "()Landroidx/databinding/ObservableField;", "navigateToCategoryTransactionsEvent", "Lcom/digitalwallet/app/model/login/SVCategory;", "getNavigateToCategoryTransactionsEvent", "getSVCategoryVMs", "", "Lcom/digitalwallet/app/viewmodel/svservices/SVCategoryViewModel;", SVService.TYPE_GROUP, "Lcom/digitalwallet/app/model/login/SVService;", "onBack", "updateServiceGroup", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ServiceGroupCategoriesViewModel.kt */
public final class ServiceGroupCategoriesViewModel extends BaseViewModel {
    private final MutableLiveData<ActionEvent<Unit>> goBackEvent = new MutableLiveData<>();
    private final ObservableField<String> groupName = new ObservableField<>("");
    private final MutableLiveData<ActionEvent<SVCategory>> navigateToCategoryTransactionsEvent = new MutableLiveData<>();

    public final ObservableField<String> getGroupName() {
        return this.groupName;
    }

    public final void updateServiceGroup(SVService sVService) {
        Intrinsics.checkNotNullParameter(sVService, SVService.TYPE_GROUP);
        this.groupName.set(sVService.getTitle());
    }

    public final MutableLiveData<ActionEvent<SVCategory>> getNavigateToCategoryTransactionsEvent() {
        return this.navigateToCategoryTransactionsEvent;
    }

    public final List<SVCategoryViewModel> getSVCategoryVMs(SVService sVService) {
        Intrinsics.checkNotNullParameter(sVService, SVService.TYPE_GROUP);
        List<SVCategory> sortedCategories = sVService.getSortedCategories();
        if (sortedCategories == null) {
            return CollectionsKt.emptyList();
        }
        List<SVCategory> list = sortedCategories;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(new SVCategoryViewModel(t, new ServiceGroupCategoriesViewModel$getSVCategoryVMs$$inlined$map$lambda$1(t, this)));
        }
        return arrayList;
    }

    public final MutableLiveData<ActionEvent<Unit>> getGoBackEvent() {
        return this.goBackEvent;
    }

    public final void onBack() {
        ActionEventKt.post(this.goBackEvent);
    }
}
