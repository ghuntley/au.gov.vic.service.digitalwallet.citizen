package com.google.android.play.core.ktx;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/google/android/play/core/ktx/AppUpdatePassthroughListener;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: AppUpdateManagerKtx.kt */
public final class AppUpdateManagerKtxKt$requestUpdateFlow$1$globalUpdateListener$2 extends Lambda implements Function1<AppUpdatePassthroughListener, Unit> {
    final /* synthetic */ ProducerScope $this_callbackFlow;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppUpdateManagerKtxKt$requestUpdateFlow$1$globalUpdateListener$2(ProducerScope producerScope) {
        super(1);
        this.$this_callbackFlow = producerScope;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppUpdatePassthroughListener appUpdatePassthroughListener) {
        invoke(appUpdatePassthroughListener);
        return Unit.INSTANCE;
    }

    public final void invoke(AppUpdatePassthroughListener appUpdatePassthroughListener) {
        Intrinsics.checkParameterIsNotNull(appUpdatePassthroughListener, "$receiver");
        SendChannel.DefaultImpls.close$default(this.$this_callbackFlow, null, 1, null);
    }
}
