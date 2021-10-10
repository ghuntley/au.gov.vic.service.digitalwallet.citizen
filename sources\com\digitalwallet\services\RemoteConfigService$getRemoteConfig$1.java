package com.digitalwallet.services;

import androidx.core.app.NotificationCompat;
import com.digitalwallet.BuildConfig;
import com.digitalwallet.model.RemoteConfig;
import com.squareup.moshi.JsonAdapter;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/SingleEmitter;", "Lcom/digitalwallet/model/RemoteConfig;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: RemoteConfigService.kt */
public final class RemoteConfigService$getRemoteConfig$1<T> implements SingleOnSubscribe<RemoteConfig> {
    final /* synthetic */ RemoteConfigService this$0;

    RemoteConfigService$getRemoteConfig$1(RemoteConfigService remoteConfigService) {
        this.this$0 = remoteConfigService;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(final SingleEmitter<RemoteConfig> singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        this.this$0.httpClient.newCall(new Request.Builder().url(BuildConfig.STATUS_CONFIG_FILE).build()).enqueue(new Callback(this) {
            /* class com.digitalwallet.services.RemoteConfigService$getRemoteConfig$1.AnonymousClass1 */
            final /* synthetic */ RemoteConfigService$getRemoteConfig$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkNotNullParameter(iOException, "e");
                singleEmitter.onError(iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    JsonAdapter<T> adapter = this.this$0.this$0.moshi.adapter((Class) RemoteConfig.class);
                    ResponseBody body = response.body();
                    Intrinsics.checkNotNull(body);
                    T fromJson = adapter.fromJson(body.string());
                    this.this$0.this$0.cached = fromJson;
                    SingleEmitter singleEmitter = singleEmitter;
                    Intrinsics.checkNotNull(fromJson);
                    singleEmitter.onSuccess(fromJson);
                } catch (Exception e) {
                    singleEmitter.onError(e);
                }
            }
        });
    }
}
