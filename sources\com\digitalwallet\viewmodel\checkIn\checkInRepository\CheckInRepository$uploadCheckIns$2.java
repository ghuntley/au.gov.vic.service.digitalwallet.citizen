package com.digitalwallet.viewmodel.checkIn.checkInRepository;

import com.digitalwallet.model.AttestationJwt;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "it", "Lcom/digitalwallet/model/AttestationJwt;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInRepository.kt */
public final class CheckInRepository$uploadCheckIns$2<T, R> implements Function<AttestationJwt, CompletableSource> {
    final /* synthetic */ CheckInRepository this$0;

    CheckInRepository$uploadCheckIns$2(CheckInRepository checkInRepository) {
        this.this$0 = checkInRepository;
    }

    public final CompletableSource apply(AttestationJwt attestationJwt) {
        Intrinsics.checkNotNullParameter(attestationJwt, "it");
        return this.this$0.postCheckIns(attestationJwt.getJwt());
    }
}
