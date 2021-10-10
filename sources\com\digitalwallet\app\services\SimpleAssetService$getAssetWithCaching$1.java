package com.digitalwallet.app.services;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.RequestBuilder;
import com.digitalwallet.app.services.SimpleAssetService;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012 \u0010\u0002\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005 \u0006*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/SingleEmitter;", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: SimpleAssetService.kt */
public final class SimpleAssetService$getAssetWithCaching$1<T> implements SingleOnSubscribe<RequestBuilder<Drawable>> {
    final /* synthetic */ String $fromUrl;
    final /* synthetic */ String $toFile;
    final /* synthetic */ SimpleAssetService this$0;

    SimpleAssetService$getAssetWithCaching$1(SimpleAssetService simpleAssetService, String str, String str2) {
        this.this$0 = simpleAssetService;
        this.$fromUrl = str;
        this.$toFile = str2;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(final SingleEmitter<RequestBuilder<Drawable>> singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        this.this$0.getAssetApi().getAsset(this.$fromUrl).enqueue(new SimpleAssetService.ResponseBodyCallback(this.this$0, singleEmitter, new Function1<ResponseBody, Unit>(this) {
            /* class com.digitalwallet.app.services.SimpleAssetService$getAssetWithCaching$1.AnonymousClass1 */
            final /* synthetic */ SimpleAssetService$getAssetWithCaching$1 this$0;

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

            /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: io.reactivex.SingleEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(ResponseBody responseBody) {
                Intrinsics.checkNotNullParameter(responseBody, "it");
                SimpleAssetService simpleAssetService = this.this$0.this$0;
                byte[] bytes = responseBody.bytes();
                Intrinsics.checkNotNullExpressionValue(bytes, "it.bytes()");
                simpleAssetService.overwriteContentToFile(bytes, this.this$0.$toFile);
                singleEmitter.onSuccess(this.this$0.this$0.requestDrawableFile(this.this$0.this$0.getContext(), this.this$0.$toFile));
            }
        }));
    }
}
