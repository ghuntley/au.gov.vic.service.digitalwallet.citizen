package com.digitalwallet.app.viewmodel.login;

import com.digitalwallet.app.model.login.SVItem;
import com.digitalwallet.utilities.ActionEventKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/digitalwallet/app/viewmodel/login/HomeServicesViewModel$topCarouselVMs$1$onClick$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: HomeServicesViewModel.kt */
public final class HomeServicesViewModel$topCarouselVMs$$inlined$map$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SVItem $it;
    final /* synthetic */ HomeServicesViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeServicesViewModel$topCarouselVMs$$inlined$map$lambda$1(SVItem sVItem, HomeServicesViewModel homeServicesViewModel) {
        super(0);
        this.$it = sVItem;
        this.this$0 = homeServicesViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ActionEventKt.postEvent(this.$it.getOpenExternally() ? this.this$0.getOpenURLEvent() : this.this$0.getStartChromeEvent(), this.$it);
    }
}
