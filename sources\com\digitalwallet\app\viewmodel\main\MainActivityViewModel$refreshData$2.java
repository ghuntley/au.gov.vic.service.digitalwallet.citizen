package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.model.RemoteConfig;
import io.reactivex.functions.BiConsumer;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "config", "Lcom/digitalwallet/model/RemoteConfig;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: MainActivityViewModel.kt */
public final class MainActivityViewModel$refreshData$2<T1, T2> implements BiConsumer<RemoteConfig, Throwable> {
    final /* synthetic */ MainActivityViewModel this$0;

    MainActivityViewModel$refreshData$2(MainActivityViewModel mainActivityViewModel) {
        this.this$0 = mainActivityViewModel;
    }

    public final void accept(RemoteConfig remoteConfig, Throwable th) {
        this.this$0.getRemoteConfig().set(remoteConfig);
    }
}
