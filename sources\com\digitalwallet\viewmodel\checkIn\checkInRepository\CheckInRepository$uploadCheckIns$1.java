package com.digitalwallet.viewmodel.checkIn.checkInRepository;

import com.digitalwallet.model.AttestationJwt;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/SingleSource;", "Lcom/digitalwallet/model/AttestationJwt;", "kotlin.jvm.PlatformType", "it", "", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInRepository.kt */
public final class CheckInRepository$uploadCheckIns$1<T, R> implements Function<Throwable, SingleSource<? extends AttestationJwt>> {
    public static final CheckInRepository$uploadCheckIns$1 INSTANCE = new CheckInRepository$uploadCheckIns$1();

    CheckInRepository$uploadCheckIns$1() {
    }

    public final SingleSource<? extends AttestationJwt> apply(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
        Date time = instance.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "Calendar.getInstance().time");
        return Single.just(new AttestationJwt("", time));
    }
}
