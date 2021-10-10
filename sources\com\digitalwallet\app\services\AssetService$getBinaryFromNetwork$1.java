package com.digitalwallet.app.services;

import android.os.Handler;
import androidx.core.app.NotificationCompat;
import com.digitalwallet.app.model.Asset;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/SingleEmitter;", "Lcom/digitalwallet/app/model/Asset;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: AssetService.kt */
public final class AssetService$getBinaryFromNetwork$1<T> implements SingleOnSubscribe<Asset> {
    final /* synthetic */ Asset $asset;
    final /* synthetic */ AssetService this$0;

    AssetService$getBinaryFromNetwork$1(AssetService assetService, Asset asset) {
        this.this$0 = assetService;
        this.$asset = asset;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(final SingleEmitter<Asset> singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        this.this$0.assetApi.getAsset(this.$asset.getUrl()).enqueue(new Callback<ResponseBody>(this) {
            /* class com.digitalwallet.app.services.AssetService$getBinaryFromNetwork$1.AnonymousClass1 */
            private final MessageDigest digest = MessageDigest.getInstance("SHA-1");
            final /* synthetic */ AssetService$getBinaryFromNetwork$1 this$0;

            {
                this.this$0 = r1;
            }

            public final MessageDigest getDigest() {
                return this.digest;
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ResponseBody> call, Throwable th) {
                Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkNotNullParameter(th, "t");
                singleEmitter.onError(th);
            }

            /* access modifiers changed from: private */
            public final Void error(String str) {
                throw new IllegalStateException(new Exception("Asset load failed: " + str).toString());
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkNotNullParameter(response, "response");
                new Handler();
                new AssetService$getBinaryFromNetwork$1$1$onResponse$$inlined$async$1(this, response, call).execute(new Void[0]);
            }
        });
    }
}
