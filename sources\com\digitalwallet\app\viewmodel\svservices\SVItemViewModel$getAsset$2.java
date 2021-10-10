package com.digitalwallet.app.viewmodel.svservices;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.bumptech.glide.RequestBuilder;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: ServiceActionViewModels.kt */
public final class SVItemViewModel$getAsset$2<T> implements Consumer<RequestBuilder<Drawable>> {
    final /* synthetic */ SVItemViewModel this$0;

    SVItemViewModel$getAsset$2(SVItemViewModel sVItemViewModel) {
        this.this$0 = sVItemViewModel;
    }

    public final void accept(RequestBuilder<Drawable> requestBuilder) {
        new Handler();
        new SVItemViewModel$getAsset$2$$special$$inlined$async$1(this, requestBuilder).execute(new Void[0]);
    }
}
