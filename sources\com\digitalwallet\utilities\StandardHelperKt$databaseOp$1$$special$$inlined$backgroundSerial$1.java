package com.digitalwallet.utilities;

import android.os.AsyncTask;
import io.reactivex.SingleEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J'\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"com/digitalwallet/utilities/AsyncHelper$Companion$backgroundSerial$1", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Void;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: StandardHelper.kt */
public final class StandardHelperKt$databaseOp$1$$special$$inlined$backgroundSerial$1 extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ SingleEmitter $it$inlined;
    final /* synthetic */ StandardHelperKt$databaseOp$1 this$0;

    public StandardHelperKt$databaseOp$1$$special$$inlined$backgroundSerial$1(StandardHelperKt$databaseOp$1 standardHelperKt$databaseOp$1, SingleEmitter singleEmitter) {
        this.this$0 = standardHelperKt$databaseOp$1;
        this.$it$inlined = singleEmitter;
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(Void... voidArr) {
        Intrinsics.checkNotNullParameter(voidArr, "params");
        try {
            this.$it$inlined.onSuccess(this.this$0.$execute.invoke());
            return null;
        } catch (Throwable th) {
            this.$it$inlined.onError(th);
            return null;
        }
    }
}
