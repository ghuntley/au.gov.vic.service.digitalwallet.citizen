package com.digitalwallet.app.viewmodel.svservices;

import android.content.Context;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.app.model.login.SVCategory;
import com.digitalwallet.app.model.login.SVTransaction;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u000eJ\u0016\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dR\u001f\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R'\u0010\u000b\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0012\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR'\u0010\u0014\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\r0\fj\b\u0012\u0004\u0012\u00020\u0015`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R'\u0010\u0017\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\r0\fj\b\u0012\u0004\u0012\u00020\u0015`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006 "}, d2 = {"Lcom/digitalwallet/app/viewmodel/svservices/ServiceCategoryTransactionsViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "categoryName", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getCategoryName", "()Landroidx/databinding/ObservableField;", "goBackEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getGoBackEvent", "()Landroidx/lifecycle/MutableLiveData;", "groupName", "getGroupName", "openURLEvent", "Lcom/digitalwallet/app/model/login/SVTransaction;", "getOpenURLEvent", "startChromeEvent", "getStartChromeEvent", "getSVTransactionVMs", "", "Lcom/digitalwallet/app/viewmodel/svservices/TitleActionVM;", "category", "Lcom/digitalwallet/app/model/login/SVCategory;", "onBack", "updateServiceCategory", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ServiceCategoryTransactionsViewModel.kt */
public final class ServiceCategoryTransactionsViewModel extends BaseViewModel {
    private final ObservableField<String> categoryName = new ObservableField<>("");
    private final Context context;
    private final MutableLiveData<ActionEvent<Unit>> goBackEvent = new MutableLiveData<>();
    private final ObservableField<String> groupName = new ObservableField<>("");
    private final MutableLiveData<ActionEvent<SVTransaction>> openURLEvent = new MutableLiveData<>();
    private final MutableLiveData<ActionEvent<SVTransaction>> startChromeEvent = new MutableLiveData<>();

    @Inject
    public ServiceCategoryTransactionsViewModel(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final ObservableField<String> getGroupName() {
        return this.groupName;
    }

    public final ObservableField<String> getCategoryName() {
        return this.categoryName;
    }

    public final void updateServiceCategory(String str, SVCategory sVCategory) {
        Intrinsics.checkNotNullParameter(str, "groupName");
        Intrinsics.checkNotNullParameter(sVCategory, "category");
        this.groupName.set(str);
        this.categoryName.set(sVCategory.getTitle());
    }

    public final MutableLiveData<ActionEvent<SVTransaction>> getStartChromeEvent() {
        return this.startChromeEvent;
    }

    public final MutableLiveData<ActionEvent<SVTransaction>> getOpenURLEvent() {
        return this.openURLEvent;
    }

    public final List<TitleActionVM> getSVTransactionVMs(SVCategory sVCategory) {
        Intrinsics.checkNotNullParameter(sVCategory, "category");
        List<SVTransaction> sortedTransactions = sVCategory.getSortedTransactions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedTransactions, 10));
        for (T t : sortedTransactions) {
            arrayList.add(new TitleActionVM(t.getTitle(), t.getOpenExternally(), new ServiceCategoryTransactionsViewModel$getSVTransactionVMs$$inlined$map$lambda$1(t, this)));
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
