package com.digitalwallet.viewmodel.checkIn.checkInRepository;

import com.digitalwallet.model.CheckIn;
import com.digitalwallet.model.CheckInCookie;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "cookie", "Lcom/digitalwallet/model/CheckInCookie;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInRepository.kt */
public final class CheckInRepository$addPendingCheckIn$1 extends Lambda implements Function1<CheckInCookie, Unit> {
    final /* synthetic */ CheckIn $details;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInRepository$addPendingCheckIn$1(CheckIn checkIn) {
        super(1);
        this.$details = checkIn;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CheckInCookie checkInCookie) {
        invoke(checkInCookie);
        return Unit.INSTANCE;
    }

    public final void invoke(CheckInCookie checkInCookie) {
        Intrinsics.checkNotNullParameter(checkInCookie, "cookie");
        checkInCookie.setPendingCheckIns(CollectionsKt.plus((Collection) checkInCookie.getPendingCheckIns(), (Object) this.$details));
    }
}
