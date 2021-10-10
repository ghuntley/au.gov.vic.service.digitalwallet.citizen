package com.digitalwallet.app.viewmodel.main.addsync;

import android.content.Context;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.utilities.DateFormattingHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CardDetailItem.kt */
public final class CardDetailItem$expiry$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CardDetailItem this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CardDetailItem$expiry$1(CardDetailItem cardDetailItem, Context context) {
        super(0);
        this.this$0 = cardDetailItem;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        String dateWithMonthAsWord = DateFormattingHelper.INSTANCE.toDateWithMonthAsWord(this.this$0.getHolding().getAttributes().getExpiry());
        if (StringsKt.isBlank(dateWithMonthAsWord)) {
            String string = this.$context.getString(R.string.no_expiry);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.no_expiry)");
            return string;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.$context.getString(this.this$0.isHoldingExpired() ? R.string.expired : R.string.expires));
        sb.append(' ');
        sb.append(dateWithMonthAsWord);
        return sb.toString();
    }
}
