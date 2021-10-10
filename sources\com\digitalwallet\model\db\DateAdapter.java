package com.digitalwallet.model.db;

import com.digitalwallet.utilities.DateFormattingHelper;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/model/db/DateAdapter;", "", "locale", "Ljava/util/Locale;", "(Ljava/util/Locale;)V", "fromJson", "Ljava/util/Date;", "dateString", "", "toJson", "date", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: adapters.kt */
public final class DateAdapter {
    private final Locale locale;

    public DateAdapter(Locale locale2) {
        Intrinsics.checkNotNullParameter(locale2, "locale");
        this.locale = locale2;
    }

    @ToJson
    public final String toJson(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return DateFormattingHelper.toISO8601String$default(DateFormattingHelper.INSTANCE, date, this.locale, null, 4, null);
    }

    @FromJson
    public final Date fromJson(String str) {
        Intrinsics.checkNotNullParameter(str, "dateString");
        return DateFormattingHelper.fromISO8601String$default(DateFormattingHelper.INSTANCE, str, this.locale, null, 4, null);
    }
}
