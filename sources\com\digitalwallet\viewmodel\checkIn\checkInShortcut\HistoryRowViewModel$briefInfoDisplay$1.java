package com.digitalwallet.viewmodel.checkIn.checkInShortcut;

import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.utilities.DateFormattingHelper;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: ShortcutItemViewModels.kt */
public final class HistoryRowViewModel$briefInfoDisplay$1 extends Lambda implements Function0<String> {
    final /* synthetic */ HistoryRowViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HistoryRowViewModel$briefInfoDisplay$1(HistoryRowViewModel historyRowViewModel) {
        super(0);
        this.this$0 = historyRowViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        String str;
        Date date = this.this$0.getHistory().getDate();
        String str2 = "";
        if (date == null || (str = DateFormattingHelper.INSTANCE.toStringAsShortHourTime(date)) == null) {
            str = str2;
        }
        int guestCount = this.this$0.getGuestCount();
        if (guestCount != 0) {
            if (guestCount != 1) {
                str2 = this.this$0.resources.getString(R.string.plus_n_others, Integer.valueOf(this.this$0.getGuestCount()));
                Intrinsics.checkNotNullExpressionValue(str2, "resources.getString(R.st…lus_n_others, guestCount)");
            } else {
                str2 = this.this$0.resources.getString(R.string.plus_1_other);
                Intrinsics.checkNotNullExpressionValue(str2, "resources.getString(R.string.plus_1_other)");
            }
        }
        return str + ' ' + str2;
    }
}
