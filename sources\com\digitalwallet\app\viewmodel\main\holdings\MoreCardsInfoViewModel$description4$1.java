package com.digitalwallet.app.viewmodel.main.holdings;

import android.content.Context;
import android.text.SpannableStringBuilder;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.view.util.SpannableTextKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/text/SpannableStringBuilder;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: MoreCardsInfoViewModel.kt */
public final class MoreCardsInfoViewModel$description4$1 extends Lambda implements Function0<SpannableStringBuilder> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MoreCardsInfoViewModel$description4$1(Context context) {
        super(0);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public final SpannableStringBuilder invoke() {
        final String string = this.$context.getString(R.string.my_cards_info_description_4);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…cards_info_description_4)");
        String string2 = this.$context.getString(R.string.my_cards_info_account);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.my_cards_info_account)");
        String string3 = this.$context.getString(R.string.my_cards_info_auto_sync);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri….my_cards_info_auto_sync)");
        AnonymousClass1 r3 = new Function2<SpannableStringBuilder, String, Unit>(this) {
            /* class com.digitalwallet.app.viewmodel.main.holdings.MoreCardsInfoViewModel$description4$1.AnonymousClass1 */
            final /* synthetic */ MoreCardsInfoViewModel$description4$1 this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(SpannableStringBuilder spannableStringBuilder, String str) {
                invoke(spannableStringBuilder, str);
                return Unit.INSTANCE;
            }

            public final void invoke(SpannableStringBuilder spannableStringBuilder, String str) {
                Intrinsics.checkNotNullParameter(spannableStringBuilder, "$this$setCustomSpan");
                Intrinsics.checkNotNullParameter(str, "highlightedText");
                int indexOf$default = StringsKt.indexOf$default((CharSequence) string, str, 0, false, 6, (Object) null);
                spannableStringBuilder.setSpan(SpannableTextKt.getDWStyleClickableSpan(this.this$0.$context, MoreCardsInfoViewModel$description4$1$1$span$1.INSTANCE, R.color.dw_slate_RES_2114060294), indexOf$default, str.length() + indexOf$default, 33);
            }
        };
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        r3.invoke(spannableStringBuilder, string2);
        r3.invoke(spannableStringBuilder, string3);
        return spannableStringBuilder;
    }
}
