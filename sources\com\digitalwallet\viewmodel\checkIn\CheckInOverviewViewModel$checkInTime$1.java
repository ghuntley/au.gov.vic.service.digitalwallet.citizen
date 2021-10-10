package com.digitalwallet.viewmodel.checkIn;

import androidx.arch.core.util.Function;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.utilities.DateFormattingHelper;
import java.util.Date;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/digitalwallet/model/CheckIn;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInOverviewViewModel.kt */
public final class CheckInOverviewViewModel$checkInTime$1<I, O> implements Function<CheckIn, String> {
    public static final CheckInOverviewViewModel$checkInTime$1 INSTANCE = new CheckInOverviewViewModel$checkInTime$1();

    CheckInOverviewViewModel$checkInTime$1() {
    }

    public final String apply(CheckIn checkIn) {
        Date date;
        if (checkIn == null || (date = checkIn.getDate()) == null) {
            return null;
        }
        return DateFormattingHelper.INSTANCE.toCheckInDateTimeString(date);
    }
}
