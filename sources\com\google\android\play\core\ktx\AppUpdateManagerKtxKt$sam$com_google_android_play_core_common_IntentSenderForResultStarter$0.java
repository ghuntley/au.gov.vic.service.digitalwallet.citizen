package com.google.android.play.core.ktx;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* compiled from: AppUpdateManagerKtx.kt */
public final class AppUpdateManagerKtxKt$sam$com_google_android_play_core_common_IntentSenderForResultStarter$0 implements IntentSenderForResultStarter {
    private final /* synthetic */ Function7 function;

    AppUpdateManagerKtxKt$sam$com_google_android_play_core_common_IntentSenderForResultStarter$0(Function7 function7) {
        this.function = function7;
    }

    @Override // com.google.android.play.core.common.IntentSenderForResultStarter
    public final /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(intentSender, "p0");
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bundle), "invoke(...)");
    }
}
