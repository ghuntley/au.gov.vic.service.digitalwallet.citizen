package com.digitalwallet.utilities;

import android.os.AsyncTask;
import com.digitalwallet.utilities.AsyncHelper;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u0001H\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "it", "Lio/reactivex/SingleEmitter;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: StandardHelper.kt */
public final class StandardHelperKt$databaseOp$1<T> implements SingleOnSubscribe<T> {
    final /* synthetic */ Function0 $execute;

    public StandardHelperKt$databaseOp$1(Function0 function0) {
        this.$execute = function0;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<T> singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "it");
        AsyncHelper.Companion companion = AsyncHelper.Companion;
        new StandardHelperKt$databaseOp$1$$special$$inlined$backgroundSerial$1(this, singleEmitter).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }
}
