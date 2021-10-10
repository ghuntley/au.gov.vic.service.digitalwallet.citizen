package com.digitalwallet.viewmodel.checkIn;

import com.digitalwallet.viewmodel.checkIn.CheckInScannerViewModel;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.ResponseBody;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "observer", "Lio/reactivex/SingleEmitter;", "", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInScannerViewModel.kt */
public final class CheckInScannerViewModel$submitCode$1<T> implements SingleOnSubscribe<String> {
    final /* synthetic */ HttpUrl $parsedUrl;
    final /* synthetic */ CheckInScannerViewModel this$0;

    CheckInScannerViewModel$submitCode$1(CheckInScannerViewModel checkInScannerViewModel, HttpUrl httpUrl) {
        this.this$0 = checkInScannerViewModel;
        this.$parsedUrl = httpUrl;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<String> singleEmitter) {
        String string;
        Intrinsics.checkNotNullParameter(singleEmitter, "observer");
        ResponseBody body = this.this$0.okHttpClient.newCall(new Request.Builder().url(this.$parsedUrl).build()).execute().body();
        if (body == null || (string = body.string()) == null) {
            throw new CheckInScannerViewModel.InvalidRedirect();
        }
        Matcher matcher = Pattern.compile("<meta.*url=(.*)>").matcher(string);
        if (matcher.find()) {
            String group = matcher.group(1);
            if (group != null) {
                String replaceFirst$default = StringsKt.replaceFirst$default(group, "&#x3D;", "=", false, 4, (Object) null);
                if (StringsKt.endsWith$default(replaceFirst$default, "\"", false, 2, (Object) null)) {
                    Objects.requireNonNull(replaceFirst$default, "null cannot be cast to non-null type java.lang.String");
                    replaceFirst$default = replaceFirst$default.substring(0, replaceFirst$default.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(replaceFirst$default, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                singleEmitter.onSuccess(replaceFirst$default);
                return;
            }
            throw new CheckInScannerViewModel.InvalidRedirect();
        }
        throw new CheckInScannerViewModel.InvalidRedirect();
    }
}
