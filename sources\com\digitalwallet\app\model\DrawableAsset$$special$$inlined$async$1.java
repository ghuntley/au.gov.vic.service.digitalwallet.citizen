package com.digitalwallet.app.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.bumptech.glide.RequestBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001J'\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"com/digitalwallet/utilities/StandardHelperKt$async$1", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Void;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: StandardHelper.kt */
public final class DrawableAsset$$special$$inlined$async$1 extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ RequestBuilder $request$inlined;
    final /* synthetic */ DrawableAsset this$0;

    public DrawableAsset$$special$$inlined$async$1(DrawableAsset drawableAsset, RequestBuilder requestBuilder, Context context) {
        this.this$0 = drawableAsset;
        this.$request$inlined = requestBuilder;
        this.$context$inlined = context;
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(Void... voidArr) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(voidArr, "params");
        try {
            drawable = (Drawable) ((RequestBuilder) ((RequestBuilder) this.$request$inlined.fallback(R.drawable.ic_red_cross)).error(R.drawable.ic_red_cross)).submit(this.this$0.width, this.this$0.height).get();
        } catch (Exception e) {
            Timber.e(e);
            drawable = this.$context$inlined.getDrawable(R.drawable.ic_red_cross);
        }
        new Handler(Looper.getMainLooper()).post(new DrawableAsset$$special$$inlined$async$1$lambda$1(drawable, this));
        return null;
    }
}
