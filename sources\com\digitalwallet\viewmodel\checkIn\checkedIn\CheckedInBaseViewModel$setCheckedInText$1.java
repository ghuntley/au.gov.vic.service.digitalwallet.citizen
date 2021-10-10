package com.digitalwallet.viewmodel.checkIn.checkedIn;

import com.digitalwallet.model.CheckInGuest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/model/CheckInGuest;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckedInBaseViewModels.kt */
public final class CheckedInBaseViewModel$setCheckedInText$1 extends Lambda implements Function1<CheckInGuest, CharSequence> {
    public static final CheckedInBaseViewModel$setCheckedInText$1 INSTANCE = new CheckedInBaseViewModel$setCheckedInText$1();

    CheckedInBaseViewModel$setCheckedInText$1() {
        super(1);
    }

    public final CharSequence invoke(CheckInGuest checkInGuest) {
        Intrinsics.checkNotNullParameter(checkInGuest, "it");
        return checkInGuest.getAbbreviatedFullName();
    }
}
