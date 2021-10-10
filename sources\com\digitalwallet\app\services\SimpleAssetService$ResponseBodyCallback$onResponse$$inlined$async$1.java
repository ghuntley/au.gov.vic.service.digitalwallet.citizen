package com.digitalwallet.app.services;

import android.os.AsyncTask;
import com.digitalwallet.app.services.SimpleAssetService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001J'\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"com/digitalwallet/utilities/StandardHelperKt$async$1", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Void;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: StandardHelper.kt */
public final class SimpleAssetService$ResponseBodyCallback$onResponse$$inlined$async$1 extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ Response $response$inlined;
    final /* synthetic */ SimpleAssetService.ResponseBodyCallback this$0;

    public SimpleAssetService$ResponseBodyCallback$onResponse$$inlined$async$1(SimpleAssetService.ResponseBodyCallback responseBodyCallback, Response response) {
        this.this$0 = responseBodyCallback;
        this.$response$inlined = response;
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(Void... voidArr) {
        Intrinsics.checkNotNullParameter(voidArr, "params");
        try {
            Function1 function1 = this.this$0.doOnResponseBody;
            Object body = this.$response$inlined.body();
            Intrinsics.checkNotNull(body);
            Intrinsics.checkNotNullExpressionValue(body, "response.body()!!");
            function1.invoke(body);
            return null;
        } catch (Exception e) {
            this.this$0.emitter.onError(e);
            return null;
        }
    }
}
