package com.digitalwallet.app.view.util;

import androidx.appcompat.app.AppCompatActivity;
import com.digitalwallet.utilities.ActivityHelperKt;
import com.digitalwallet.utilities.AnalyticsHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/digitalwallet/app/view/util/RemoteConfigKt$handleRemoteConfig$1$fragment$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: RemoteConfig.kt */
public final class RemoteConfigKt$handleRemoteConfig$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AnalyticsHelper $analytics$inlined;
    final /* synthetic */ AppCompatActivity $this_handleRemoteConfig$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteConfigKt$handleRemoteConfig$$inlined$let$lambda$1(AppCompatActivity appCompatActivity, AnalyticsHelper analyticsHelper) {
        super(0);
        this.$this_handleRemoteConfig$inlined = appCompatActivity;
        this.$analytics$inlined = analyticsHelper;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ActivityHelperKt.viewAppInStore(this.$this_handleRemoteConfig$inlined);
        this.$this_handleRemoteConfig$inlined.finish();
    }
}
