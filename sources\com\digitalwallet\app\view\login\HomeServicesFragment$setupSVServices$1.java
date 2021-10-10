package com.digitalwallet.app.view.login;

import com.digitalwallet.app.model.login.SVItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/model/login/SVItem;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: HomeServicesFragment.kt */
public final class HomeServicesFragment$setupSVServices$1 extends Lambda implements Function1<SVItem, Unit> {
    final /* synthetic */ HomeServicesFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeServicesFragment$setupSVServices$1(HomeServicesFragment homeServicesFragment) {
        super(1);
        this.this$0 = homeServicesFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SVItem sVItem) {
        invoke(sVItem);
        return Unit.INSTANCE;
    }

    public final void invoke(SVItem sVItem) {
        Intrinsics.checkNotNullParameter(sVItem, "it");
        this.this$0.startChrome(sVItem.getUrl(), sVItem.getId());
    }
}
