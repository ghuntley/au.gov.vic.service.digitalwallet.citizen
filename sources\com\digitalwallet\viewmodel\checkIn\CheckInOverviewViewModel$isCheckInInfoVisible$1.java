package com.digitalwallet.viewmodel.checkIn;

import androidx.arch.core.util.Function;
import com.digitalwallet.model.CheckIn;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/digitalwallet/model/CheckIn;", "apply", "(Lcom/digitalwallet/model/CheckIn;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInOverviewViewModel.kt */
public final class CheckInOverviewViewModel$isCheckInInfoVisible$1<I, O> implements Function<CheckIn, Boolean> {
    public static final CheckInOverviewViewModel$isCheckInInfoVisible$1 INSTANCE = new CheckInOverviewViewModel$isCheckInInfoVisible$1();

    CheckInOverviewViewModel$isCheckInInfoVisible$1() {
    }

    public final Boolean apply(CheckIn checkIn) {
        return Boolean.valueOf(checkIn != null);
    }
}
