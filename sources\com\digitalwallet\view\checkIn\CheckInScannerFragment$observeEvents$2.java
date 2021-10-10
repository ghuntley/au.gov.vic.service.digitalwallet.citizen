package com.digitalwallet.view.checkIn;

import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.utilities.FragmentHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInScannerFragment.kt */
public final class CheckInScannerFragment$observeEvents$2 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ CheckInScannerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInScannerFragment$observeEvents$2(CheckInScannerFragment checkInScannerFragment) {
        super(1);
        this.this$0 = checkInScannerFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke(unit);
        return Unit.INSTANCE;
    }

    public final void invoke(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        CheckInScannerFragment checkInScannerFragment = this.this$0;
        String string = checkInScannerFragment.getResources().getString(R.string.check_in_collection_notice_url);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…in_collection_notice_url)");
        FragmentHelperKt.openURL(checkInScannerFragment, string);
    }
}
