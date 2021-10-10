package com.digitalwallet.app.viewmodel.main.history;

import androidx.databinding.ObservableField;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.db.shares.ShareRecord;
import com.digitalwallet.app.services.TransactionSharesService;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00050\u00050\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/history/SharingHistoryFragmentViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "()V", "closeViewPublisher", "Lio/reactivex/subjects/PublishSubject;", "", "getCloseViewPublisher", "()Lio/reactivex/subjects/PublishSubject;", "emptyStateText", "", "getEmptyStateText", "()I", "sharesArePresent", "Landroidx/databinding/ObservableField;", "kotlin.jvm.PlatformType", "getSharesArePresent", "()Landroidx/databinding/ObservableField;", "sharesService", "Lcom/digitalwallet/app/services/TransactionSharesService;", "getSharesService", "()Lcom/digitalwallet/app/services/TransactionSharesService;", "setSharesService", "(Lcom/digitalwallet/app/services/TransactionSharesService;)V", MessageBundle.TITLE_ENTRY, "getTitle", "getShares", "Lio/reactivex/Single;", "", "Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SharingHistoryFragmentViewModel.kt */
public final class SharingHistoryFragmentViewModel extends BaseViewModel {
    private final PublishSubject<Boolean> closeViewPublisher;
    private final int emptyStateText;
    private final ObservableField<Boolean> sharesArePresent = new ObservableField<>((Boolean) false);
    @Inject
    public TransactionSharesService sharesService;
    private final int title;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AppType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AppType.CITIZEN.ordinal()] = 1;
            iArr[AppType.AUTHORITY.ordinal()] = 2;
            int[] iArr2 = new int[AppType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[AppType.CITIZEN.ordinal()] = 1;
            iArr2[AppType.AUTHORITY.ordinal()] = 2;
        }
    }

    @Inject
    public SharingHistoryFragmentViewModel() {
        int i;
        int i2;
        PublishSubject<Boolean> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.closeViewPublisher = create;
        int i3 = WhenMappings.$EnumSwitchMapping$0[ServerTypeKt.getAppType().ordinal()];
        if (i3 == 1) {
            i = R.string.list_drawer_title_citizen;
        } else if (i3 == 2) {
            i = R.string.list_drawer_title_authority;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.title = i;
        int i4 = WhenMappings.$EnumSwitchMapping$1[ServerTypeKt.getAppType().ordinal()];
        if (i4 == 1) {
            i2 = R.string.share_empty_citizen;
        } else if (i4 == 2) {
            i2 = R.string.share_empty_authority;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.emptyStateText = i2;
    }

    public final ObservableField<Boolean> getSharesArePresent() {
        return this.sharesArePresent;
    }

    public final PublishSubject<Boolean> getCloseViewPublisher() {
        return this.closeViewPublisher;
    }

    public final int getTitle() {
        return this.title;
    }

    public final int getEmptyStateText() {
        return this.emptyStateText;
    }

    public final Single<List<ShareRecord>> getShares() {
        TransactionSharesService transactionSharesService = this.sharesService;
        if (transactionSharesService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharesService");
        }
        Single<R> map = transactionSharesService.getShares().doOnSuccess(new SharingHistoryFragmentViewModel$getShares$1(this)).map(SharingHistoryFragmentViewModel$getShares$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "sharesService.getShares(…e\n            }\n        }");
        return map;
    }

    public final TransactionSharesService getSharesService() {
        TransactionSharesService transactionSharesService = this.sharesService;
        if (transactionSharesService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharesService");
        }
        return transactionSharesService;
    }

    public final void setSharesService(TransactionSharesService transactionSharesService) {
        Intrinsics.checkNotNullParameter(transactionSharesService, "<set-?>");
        this.sharesService = transactionSharesService;
    }
}
