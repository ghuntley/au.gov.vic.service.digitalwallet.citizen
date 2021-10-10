package com.digitalwallet.utilities;

import android.os.AsyncTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/digitalwallet/utilities/AsyncHelper;", "", "()V", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: StandardHelper.kt */
public final class AsyncHelper {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/utilities/AsyncHelper$Companion;", "", "()V", "backgroundSerial", "", "execute", "Lkotlin/Function0;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: StandardHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void backgroundSerial(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "execute");
            new AsyncHelper$Companion$backgroundSerial$1(function0).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }
}
