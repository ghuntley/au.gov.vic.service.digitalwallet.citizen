package com.digitalwallet.view.checkIn.checkedIn;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInSuccessFragment.kt */
final class CheckInSuccessFragment$handleBack$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ CheckInSuccessFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInSuccessFragment$handleBack$1(CheckInSuccessFragment checkInSuccessFragment) {
        super(0);
        this.this$0 = checkInSuccessFragment;
    }

    /* Return type fixed from 'boolean' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        this.this$0.getViewModel().onClose(true);
        return true;
    }
}
