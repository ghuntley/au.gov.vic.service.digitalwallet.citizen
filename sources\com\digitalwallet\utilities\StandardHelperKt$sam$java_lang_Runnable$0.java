package com.digitalwallet.utilities;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
/* compiled from: StandardHelper.kt */
public final class StandardHelperKt$sam$java_lang_Runnable$0 implements Runnable {
    private final /* synthetic */ Function0 function;

    StandardHelperKt$sam$java_lang_Runnable$0(Function0 function0) {
        this.function = function0;
    }

    public final /* synthetic */ void run() {
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(), "invoke(...)");
    }
}
