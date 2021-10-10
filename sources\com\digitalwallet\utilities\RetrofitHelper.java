package com.digitalwallet.utilities;

import java.io.Reader;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/digitalwallet/utilities/RetrofitHelper;", "", "()V", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RetrofitHelper.kt */
public final class RetrofitHelper {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/utilities/RetrofitHelper$Companion;", "", "()V", "filterHttpException", "", "t", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: RetrofitHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void filterHttpException(Throwable th) {
            Reader charStream;
            Intrinsics.checkNotNullParameter(th, "t");
            if (th instanceof HttpException) {
                StringBuilder sb = new StringBuilder();
                sb.append("Http error: ");
                HttpException httpException = (HttpException) th;
                sb.append(httpException.code());
                sb.append(' ');
                sb.append(httpException.message());
                Timber.d(sb.toString(), new Object[0]);
                ResponseBody errorBody = httpException.response().errorBody();
                Timber.d((errorBody == null || (charStream = errorBody.charStream()) == null) ? null : TextStreamsKt.readText(charStream), new Object[0]);
            }
            Timber.e(th);
        }
    }
}
