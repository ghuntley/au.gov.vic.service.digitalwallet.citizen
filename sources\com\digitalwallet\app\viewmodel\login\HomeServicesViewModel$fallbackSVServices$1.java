package com.digitalwallet.app.viewmodel.login;

import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.login.SVServices;
import com.squareup.moshi.JsonAdapter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/digitalwallet/app/model/login/SVServices;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: HomeServicesViewModel.kt */
public final class HomeServicesViewModel$fallbackSVServices$1 extends Lambda implements Function0<SVServices> {
    final /* synthetic */ HomeServicesViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeServicesViewModel$fallbackSVServices$1(HomeServicesViewModel homeServicesViewModel) {
        super(0);
        this.this$0 = homeServicesViewModel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005b, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        throw r1;
     */
    @Override // kotlin.jvm.functions.Function0
    public final SVServices invoke() {
        InputStream openRawResource = this.this$0.context.getResources().openRawResource(R.raw.config_services);
        Intrinsics.checkNotNullExpressionValue(openRawResource, "context.resources.openRa…ce(R.raw.config_services)");
        InputStreamReader inputStreamReader = new InputStreamReader(openRawResource, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        Throwable th = null;
        String readText = TextStreamsKt.readText(bufferedReader);
        CloseableKt.closeFinally(bufferedReader, th);
        try {
            JsonAdapter adapter = this.this$0.moshi.adapter(SVServices.class);
            Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
            return (SVServices) adapter.fromJson(readText);
        } catch (Exception unused) {
            return null;
        }
    }
}
