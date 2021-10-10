package com.digitalwallet.app.viewmodel.login;

import com.digitalwallet.app.model.login.SVServices;
import com.digitalwallet.app.services.SimpleAssetService;
import com.squareup.moshi.JsonAdapter;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u0001H\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "emitter", "Lio/reactivex/SingleEmitter;", "kotlin.jvm.PlatformType", "subscribe", "com/digitalwallet/app/services/SimpleAssetService$getModelFromUrl$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: SimpleAssetService.kt */
public final class HomeServicesViewModel$$special$$inlined$getModelFromUrl$app_citizenProdRelease$1<T> implements SingleOnSubscribe<T> {
    final /* synthetic */ String $fullUrl;
    final /* synthetic */ SimpleAssetService this$0;

    public HomeServicesViewModel$$special$$inlined$getModelFromUrl$app_citizenProdRelease$1(SimpleAssetService simpleAssetService, String str) {
        this.this$0 = simpleAssetService;
        this.$fullUrl = str;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(final SingleEmitter<T> singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        this.this$0.getAssetApi().getAsset(this.$fullUrl).enqueue(new SimpleAssetService.ResponseBodyCallback(this.this$0, singleEmitter, new Function1<ResponseBody, Unit>(this) {
            /* class com.digitalwallet.app.viewmodel.login.HomeServicesViewModel$$special$$inlined$getModelFromUrl$app_citizenProdRelease$1.AnonymousClass1 */
            final /* synthetic */ HomeServicesViewModel$$special$$inlined$getModelFromUrl$app_citizenProdRelease$1 this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ResponseBody responseBody) {
                invoke(responseBody);
                return Unit.INSTANCE;
            }

            public final void invoke(ResponseBody responseBody) {
                Intrinsics.checkNotNullParameter(responseBody, "it");
                JsonAdapter<T> adapter = this.this$0.this$0.moshi.adapter((Class) SVServices.class);
                Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
                T fromJson = adapter.fromJson(responseBody.string());
                SingleEmitter singleEmitter = singleEmitter;
                Intrinsics.checkNotNull(fromJson);
                singleEmitter.onSuccess(fromJson);
            }
        }));
    }
}
