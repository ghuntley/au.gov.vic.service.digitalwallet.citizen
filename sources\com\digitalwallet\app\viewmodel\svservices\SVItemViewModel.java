package com.digitalwallet.app.viewmodel.svservices;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.ObservableField;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.bumptech.glide.RequestBuilder;
import com.digitalwallet.app.model.login.SVItem;
import com.digitalwallet.app.services.SimpleAssetService;
import com.digitalwallet.utilities.StandardHelperKt;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ$\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0002J\u0006\u0010!\u001a\u00020\bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/digitalwallet/app/viewmodel/svservices/SVItemViewModel;", "", "svItem", "Lcom/digitalwallet/app/model/login/SVItem;", "simpleAssetService", "Lcom/digitalwallet/app/services/SimpleAssetService;", "clickAction", "Lkotlin/Function0;", "", "(Lcom/digitalwallet/app/model/login/SVItem;Lcom/digitalwallet/app/services/SimpleAssetService;Lkotlin/jvm/functions/Function0;)V", "cacheNameForImageUrl", "", "context", "Landroid/content/Context;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "errorIndicator", "Landroid/graphics/drawable/Drawable;", "imageDrawable", "Landroidx/databinding/ObservableField;", "getImageDrawable", "()Landroidx/databinding/ObservableField;", "imageUrl", "itemId", "getItemId", "()Ljava/lang/String;", "loadingIndicator", "Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;", "getAsset", "Lio/reactivex/Single;", "Lcom/bumptech/glide/RequestBuilder;", "fromUrl", "toCache", "onClicked", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ServiceActionViewModels.kt */
public final class SVItemViewModel {
    private final String cacheNameForImageUrl;
    private final Function0<Unit> clickAction;
    private final Context context;
    private final CompositeDisposable disposables;
    private final Drawable errorIndicator;
    private final ObservableField<Drawable> imageDrawable;
    private final String imageUrl;
    private final String itemId;
    private final CircularProgressDrawable loadingIndicator;
    private final SimpleAssetService simpleAssetService;

    public SVItemViewModel(SVItem sVItem, SimpleAssetService simpleAssetService2, Function0<Unit> function0) {
        CircularProgressDrawable circularProgressDrawable;
        Intrinsics.checkNotNullParameter(sVItem, "svItem");
        Intrinsics.checkNotNullParameter(simpleAssetService2, "simpleAssetService");
        Intrinsics.checkNotNullParameter(function0, "clickAction");
        this.simpleAssetService = simpleAssetService2;
        this.clickAction = function0;
        Context context2 = simpleAssetService2.getContext();
        this.context = context2;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.disposables = compositeDisposable;
        this.itemId = sVItem.getId();
        String imageUrl2 = sVItem.getImageUrl();
        this.imageUrl = imageUrl2;
        String cacheNameForImageUrl2 = sVItem.getCacheNameForImageUrl();
        this.cacheNameForImageUrl = cacheNameForImageUrl2;
        CircularProgressDrawable circularProgressDrawable2 = new CircularProgressDrawable(context2);
        circularProgressDrawable2.setStrokeWidth(StandardHelperKt.getDevicePixels(6));
        circularProgressDrawable2.setCenterRadius(StandardHelperKt.getDevicePixels(16));
        circularProgressDrawable2.setAlpha(64);
        circularProgressDrawable2.start();
        Unit unit = Unit.INSTANCE;
        this.loadingIndicator = circularProgressDrawable2;
        this.errorIndicator = context2.getDrawable(R.drawable.img_login_carousel_error_state);
        if (imageUrl2 != null) {
            if (cacheNameForImageUrl2 != null) {
                compositeDisposable.add(getAsset(imageUrl2, cacheNameForImageUrl2).subscribe());
                if (circularProgressDrawable2 != null) {
                    circularProgressDrawable = circularProgressDrawable2;
                    this.imageDrawable = new ObservableField<>((Drawable) circularProgressDrawable);
                }
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        circularProgressDrawable = (Drawable) new SVItemViewModel$imageDrawable$2(this, sVItem).invoke();
        this.imageDrawable = new ObservableField<>((Drawable) circularProgressDrawable);
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final ObservableField<Drawable> getImageDrawable() {
        return this.imageDrawable;
    }

    private final Single<RequestBuilder<Drawable>> getAsset(String str, String str2) {
        Single<RequestBuilder<Drawable>> doOnSuccess = SimpleAssetService.getAssetWithCaching$default(this.simpleAssetService, str, str2, false, 4, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnError(new SVItemViewModel$getAsset$1(this)).doOnSuccess(new SVItemViewModel$getAsset$2(this));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "simpleAssetService\n     …          }\n            }");
        return doOnSuccess;
    }

    public final void onClicked() {
        if (!Intrinsics.areEqual(this.imageDrawable.get(), this.errorIndicator) || this.imageUrl == null) {
            this.clickAction.invoke();
            return;
        }
        this.imageDrawable.set(this.loadingIndicator);
        String str = this.cacheNameForImageUrl;
        if (str != null) {
            this.disposables.add(getAsset(this.imageUrl, str).subscribe());
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
