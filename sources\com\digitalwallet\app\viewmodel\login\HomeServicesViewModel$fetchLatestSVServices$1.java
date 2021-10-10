package com.digitalwallet.app.viewmodel.login;

import com.digitalwallet.app.model.login.SVServices;
import com.digitalwallet.app.services.SimpleAssetService;
import com.squareup.moshi.JsonAdapter;
import io.reactivex.functions.Consumer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/model/login/SVServices;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: HomeServicesViewModel.kt */
public final class HomeServicesViewModel$fetchLatestSVServices$1<T> implements Consumer<SVServices> {
    final /* synthetic */ HomeServicesViewModel this$0;

    HomeServicesViewModel$fetchLatestSVServices$1(HomeServicesViewModel homeServicesViewModel) {
        this.this$0 = homeServicesViewModel;
    }

    public final void accept(SVServices sVServices) {
        SimpleAssetService simpleAssetService = this.this$0.simpleAssetService;
        String str = this.this$0.cachedSVServicesFilename;
        try {
            JsonAdapter<T> adapter = simpleAssetService.moshi.adapter((Class) SVServices.class);
            Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
            String json = adapter.toJson(sVServices);
            Intrinsics.checkNotNullExpressionValue(json, "json");
            Charset charset = Charsets.UTF_8;
            if (json != null) {
                byte[] bytes = json.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                simpleAssetService.overwriteContentToFile(bytes, str);
                HomeServicesViewModel homeServicesViewModel = this.this$0;
                SVServices fallbackSVServices = homeServicesViewModel.getFallbackSVServices();
                Intrinsics.checkNotNullExpressionValue(sVServices, "it");
                homeServicesViewModel.cleanupOldSVServicesImageCaches(fallbackSVServices, sVServices);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Exception e) {
            Timber.e(e);
        }
    }
}
