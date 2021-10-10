package com.digitalwallet.app.services;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.digitalwallet.app.api.AssetApi;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public final class SimpleAssetService {
    private final AssetApi assetApi;
    private final Context context;
    private final File directory;
    private final Moshi moshi;

    public SimpleAssetService(Context context2, AssetApi assetApi2, Moshi moshi2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(assetApi2, "assetApi");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.context = context2;
        this.assetApi = assetApi2;
        this.moshi = moshi2;
        this.directory = context2.getFilesDir();
    }

    public final AssetApi getAssetApi() {
        return this.assetApi;
    }

    public final Context getContext() {
        return this.context;
    }

    public final /* synthetic */ <T> Single<T> getModelFromUrl$app_citizenProdRelease(String str) {
        Intrinsics.checkNotNullParameter(str, "fullUrl");
        Intrinsics.needClassReification();
        Single<T> create = Single.create(new SimpleAssetService$getModelFromUrl$1(this, str));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create { emitter …vices!!)\n        })\n    }");
        return create;
    }

    public final /* synthetic */ <T> void cacheModelToFile$app_citizenProdRelease(T t, String str) {
        Intrinsics.checkNotNullParameter(str, "filename");
        try {
            Moshi moshi2 = this.moshi;
            Intrinsics.reifiedOperationMarker(4, "T");
            JsonAdapter<T> adapter = moshi2.adapter((Class) Object.class);
            Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
            String json = adapter.toJson(t);
            Intrinsics.checkNotNullExpressionValue(json, "json");
            Charset charset = Charsets.UTF_8;
            if (json != null) {
                byte[] bytes = json.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                overwriteContentToFile(bytes, str);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    public final /* synthetic */ <T> T getModelFromCache$app_citizenProdRelease(String str) {
        Intrinsics.checkNotNullParameter(str, "filename");
        try {
            String readText$default = FilesKt.readText$default(getFile(str), null, 1, null);
            Moshi moshi2 = this.moshi;
            Intrinsics.reifiedOperationMarker(4, "T");
            JsonAdapter<T> adapter = moshi2.adapter((Class) Object.class);
            Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
            return adapter.fromJson(readText$default);
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ Single getAssetWithCaching$default(SimpleAssetService simpleAssetService, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return simpleAssetService.getAssetWithCaching(str, str2, z);
    }

    public final Single<RequestBuilder<Drawable>> getAssetWithCaching(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "fromUrl");
        Intrinsics.checkNotNullParameter(str2, "toFile");
        if (!getFile(str2).exists() || z) {
            Single<RequestBuilder<Drawable>> create = Single.create(new SimpleAssetService$getAssetWithCaching$1(this, str, str2));
            Intrinsics.checkNotNullExpressionValue(create, "Single.create { emitter …     })\n                }");
            return create;
        }
        Single<RequestBuilder<Drawable>> just = Single.just(requestDrawableFile(this.context, str2));
        Intrinsics.checkNotNullExpressionValue(just, "Single.just(requestDrawableFile(context, toFile))");
        return just;
    }

    /* access modifiers changed from: public */
    private final RequestBuilder<Drawable> requestDrawableFile(Context context2, String str) {
        RequestBuilder<Drawable> load = Glide.with(context2).load(getFile(str));
        Intrinsics.checkNotNullExpressionValue(load, "Glide.with(context).load(getFile(filename))");
        return load;
    }

    private final File getFile(String str) {
        List listOf = CollectionsKt.listOf(this.directory, str);
        String str2 = File.separator;
        Intrinsics.checkNotNullExpressionValue(str2, "File.separator");
        return new File(CollectionsKt.joinToString$default(listOf, str2, null, null, 0, null, null, 62, null));
    }

    public final boolean deleteFile(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "Looper.getMainLooper()");
        if (!mainLooper.isCurrentThread()) {
            return getFile(str).delete();
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final void overwriteContentToFile(byte[] bArr, String str) {
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "Looper.getMainLooper()");
        boolean z = true;
        if (!mainLooper.isCurrentThread()) {
            File file = getFile(str);
            FilesKt.writeBytes(file, bArr);
            if (file.length() != ((long) bArr.length)) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final class ResponseBodyCallback<T> implements Callback<ResponseBody> {
        private final Function1<ResponseBody, Unit> doOnResponseBody;
        private final SingleEmitter<T> emitter;
        final /* synthetic */ SimpleAssetService this$0;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super okhttp3.ResponseBody, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public ResponseBodyCallback(SimpleAssetService simpleAssetService, SingleEmitter<T> singleEmitter, Function1<? super ResponseBody, Unit> function1) {
            Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
            Intrinsics.checkNotNullParameter(function1, "doOnResponseBody");
            this.this$0 = simpleAssetService;
            this.emitter = singleEmitter;
            this.doOnResponseBody = function1;
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(response, "response");
            if (!response.isSuccessful() || response.body() == null) {
                this.emitter.onError(new Exception("Response not succeeded or null body"));
                return;
            }
            new Handler();
            new SimpleAssetService$ResponseBodyCallback$onResponse$$inlined$async$1(this, response).execute(new Void[0]);
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ResponseBody> call, Throwable th) {
            Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(th, "t");
            this.emitter.onError(th);
        }
    }
}
