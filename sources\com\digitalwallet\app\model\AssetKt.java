package com.digitalwallet.app.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, d2 = {"urlSafeEscaping", "", "app_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: Asset.kt */
public final class AssetKt {
    public static final String urlSafeEscaping(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$urlSafeEscaping");
        return StringsKt.removeSuffix(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, "/", "_", false, 4, (Object) null), "+", "-", false, 4, (Object) null), "\n", "", false, 4, (Object) null), (CharSequence) "=");
    }
}
