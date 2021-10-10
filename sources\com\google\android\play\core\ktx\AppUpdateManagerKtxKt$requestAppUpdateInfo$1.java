package com.google.android.play.core.ktx;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.objectweb.asm.Opcodes;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H@"}, d2 = {"requestAppUpdateInfo", "", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.google.android.play.core.ktx.AppUpdateManagerKtxKt", f = "AppUpdateManagerKtx.kt", i = {0}, l = {Opcodes.IFNONNULL}, m = "requestAppUpdateInfo", n = {"$this$requestAppUpdateInfo"}, s = {"L$0"})
/* compiled from: AppUpdateManagerKtx.kt */
public final class AppUpdateManagerKtxKt$requestAppUpdateInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    AppUpdateManagerKtxKt$requestAppUpdateInfo$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AppUpdateManagerKtxKt.requestAppUpdateInfo(null, this);
    }
}
