package com.digitalwallet.viewmodel.checkIn;

import android.content.Context;
import androidx.arch.core.util.Function;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.model.CheckInGuest;
import java.util.List;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/digitalwallet/model/CheckIn;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInOverviewViewModel.kt */
public final class CheckInOverviewViewModel$checkedInText$1<I, O> implements Function<CheckIn, String> {
    final /* synthetic */ Context $context;

    CheckInOverviewViewModel$checkedInText$1(Context context) {
        this.$context = context;
    }

    public final String apply(CheckIn checkIn) {
        List<CheckInGuest> guests;
        int size = (checkIn == null || (guests = checkIn.getGuests()) == null) ? 0 : guests.size();
        if (size == 0) {
            return this.$context.getString(R.string.checked_in);
        }
        if (size != 1) {
            return this.$context.getString(R.string.checked_in_with_n_dependants, Integer.valueOf(size));
        }
        return this.$context.getString(R.string.checked_in_with_1_dependant);
    }
}
