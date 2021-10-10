package com.digitalwallet.app.model.db;

import com.digitalwallet.utilities.DateFormattingHelper;
import java.util.Date;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/model/db/RoomDateConverters;", "", "()V", "dateToTimestamp", "", "date", "Ljava/util/Date;", "fromTimestamp", "value", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: DigitalWalletDatabase.kt */
public final class RoomDateConverters {
    public final Date fromTimestamp(String str) {
        if (str == null) {
            return null;
        }
        return DateFormattingHelper.tryParse$default(DateFormattingHelper.INSTANCE, str, false, 2, null);
    }

    public final String dateToTimestamp(Date date) {
        if (date == null) {
            return null;
        }
        return DateFormattingHelper.toHoldingDate$default(DateFormattingHelper.INSTANCE, date, false, 2, null);
    }
}
