package com.digitalwallet.app.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bumptech.glide.RequestBuilder;
import com.digitalwallet.utilities.StandardHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/digitalwallet/app/model/DrawableAsset;", "Landroidx/databinding/BaseObservable;", "context", "Landroid/content/Context;", "request", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "(Landroid/content/Context;Lcom/bumptech/glide/RequestBuilder;II)V", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class DrawableAsset extends BaseObservable {
    @Bindable
    private Drawable drawable;
    private int height;
    private int width;

    public DrawableAsset(Context context, RequestBuilder<Drawable> requestBuilder, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestBuilder, "request");
        this.width = i;
        this.height = i2;
        new Handler();
        new DrawableAsset$$special$$inlined$async$1(this, requestBuilder, context).execute(new Void[0]);
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(StandardHelperKt.getDevicePixels(6));
        circularProgressDrawable.setCenterRadius(StandardHelperKt.getDevicePixels(16));
        circularProgressDrawable.setAlpha(64);
        circularProgressDrawable.start();
        Unit unit = Unit.INSTANCE;
        this.drawable = circularProgressDrawable;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public final void setDrawable(Drawable drawable2) {
        Intrinsics.checkNotNullParameter(drawable2, "<set-?>");
        this.drawable = drawable2;
    }
}
