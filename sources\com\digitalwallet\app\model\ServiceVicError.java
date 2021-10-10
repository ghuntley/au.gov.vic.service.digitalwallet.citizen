package com.digitalwallet.app.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.Moshi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.bouncycastle.i18n.ErrorBundle;
import retrofit2.HttpException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00060\u0001j\u0002`\u0002:\u0001\rB)\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/digitalwallet/app/model/ServiceVicError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "errorDescription", ErrorBundle.DETAIL_ENTRY, "", "Lcom/digitalwallet/app/model/ServiceVicErrorDetail;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "message", "getMessage", "()Ljava/lang/String;", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ServiceVicError.kt */
public final class ServiceVicError extends Exception {
    public static final Companion Companion = new Companion(null);
    private final List<ServiceVicErrorDetail> details;
    private final String errorCode;
    private final String errorDescription;

    public ServiceVicError() {
        this(null, null, null, 7, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ServiceVicError(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public ServiceVicError(@Json(name = "errorCode") String str, @Json(name = "errorDescription") String str2, @Json(name = "details") List<ServiceVicErrorDetail> list) {
        Intrinsics.checkNotNullParameter(str, "errorCode");
        Intrinsics.checkNotNullParameter(str2, "errorDescription");
        Intrinsics.checkNotNullParameter(list, ErrorBundle.DETAIL_ENTRY);
        this.errorCode = str;
        this.errorDescription = str2;
        this.details = list;
    }

    public String getMessage() {
        String displayMessage$app_citizenProdRelease;
        ServiceVicErrorDetail serviceVicErrorDetail = (ServiceVicErrorDetail) CollectionsKt.firstOrNull((List) this.details);
        return (serviceVicErrorDetail == null || (displayMessage$app_citizenProdRelease = serviceVicErrorDetail.getDisplayMessage$app_citizenProdRelease()) == null) ? this.errorDescription : displayMessage$app_citizenProdRelease;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/model/ServiceVicError$Companion;", "", "()V", "attemptConversion", "Lcom/digitalwallet/app/model/ServiceVicError;", "moshi", "Lcom/squareup/moshi/Moshi;", "error", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ServiceVicError.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ServiceVicError attemptConversion(Moshi moshi, Throwable th) {
            ResponseBody errorBody;
            String string;
            Intrinsics.checkNotNullParameter(moshi, "moshi");
            Intrinsics.checkNotNullParameter(th, "error");
            if (!(th instanceof HttpException)) {
                th = null;
            }
            HttpException httpException = (HttpException) th;
            if (httpException == null || (errorBody = httpException.response().errorBody()) == null || (string = errorBody.string()) == null) {
                return null;
            }
            return (ServiceVicError) moshi.adapter(ServiceVicError.class).fromJson(string);
        }
    }
}
