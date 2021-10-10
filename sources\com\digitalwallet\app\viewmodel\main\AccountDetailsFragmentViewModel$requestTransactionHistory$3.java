package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.utilities.AnalyticsHelper;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: AccountDetailsFragmentViewModel.kt */
public final class AccountDetailsFragmentViewModel$requestTransactionHistory$3<T> implements Consumer<Throwable> {
    final /* synthetic */ AccountDetailsFragmentViewModel this$0;

    AccountDetailsFragmentViewModel$requestTransactionHistory$3(AccountDetailsFragmentViewModel accountDetailsFragmentViewModel) {
        this.this$0 = accountDetailsFragmentViewModel;
    }

    public final void accept(Throwable th) {
        AnalyticsHelper analyticsHelper = this.this$0.analytics;
        String message = th.getMessage();
        if (message == null) {
            message = th.toString();
        }
        analyticsHelper.diagnosisLog("Error getTransactionHistory", message);
        Timber.e(th);
        this.this$0.getErrorTransHistory().set(true);
        this.this$0.getLoadingTransHistory().set(false);
    }
}
