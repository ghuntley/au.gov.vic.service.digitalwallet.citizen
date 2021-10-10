package com.digitalwallet.app.view.login;

import com.digitalwallet.app.model.login.SVServices;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/model/login/SVServices;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: HomeServicesFragment.kt */
final class HomeServicesFragment$onViewCreated$1<T> implements Consumer<SVServices> {
    final /* synthetic */ HomeServicesFragment this$0;

    HomeServicesFragment$onViewCreated$1(HomeServicesFragment homeServicesFragment) {
        this.this$0 = homeServicesFragment;
    }

    public final void accept(SVServices sVServices) {
        if (!Intrinsics.areEqual(sVServices, this.this$0.getViewModel().getFallbackSVServices())) {
            this.this$0.setupSVServices(sVServices);
        }
    }
}
