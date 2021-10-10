package com.digitalwallet.viewmodel.checkIn.checkInRepository;

import com.digitalwallet.model.CheckInCookie;
import com.digitalwallet.model.DependantCheckIn;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "cookie", "Lcom/digitalwallet/model/CheckInCookie;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInRepository.kt */
public final class CheckInRepository$deleteACheckInDependantIfExists$1 extends Lambda implements Function1<CheckInCookie, Unit> {
    final /* synthetic */ DependantCheckIn $dependantCheckIn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInRepository$deleteACheckInDependantIfExists$1(DependantCheckIn dependantCheckIn) {
        super(1);
        this.$dependantCheckIn = dependantCheckIn;
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
        List<DependantCheckIn> mutableList = CollectionsKt.toMutableList((Collection) checkInCookie.getCheckInDependants());
        CollectionsKt.removeAll((List) mutableList, (Function1) new Function1<DependantCheckIn, Boolean>(this) {
            /* class com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository$deleteACheckInDependantIfExists$1.AnonymousClass1 */
            final /* synthetic */ CheckInRepository$deleteACheckInDependantIfExists$1 this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(DependantCheckIn dependantCheckIn) {
                return Boolean.valueOf(invoke(dependantCheckIn));
            }

            public final boolean invoke(DependantCheckIn dependantCheckIn) {
                Intrinsics.checkNotNullParameter(dependantCheckIn, "it");
                return Intrinsics.areEqual(dependantCheckIn.getInternalId(), this.this$0.$dependantCheckIn.getInternalId());
            }
        });
        checkInCookie.setCheckInDependants(mutableList);
    }
}
