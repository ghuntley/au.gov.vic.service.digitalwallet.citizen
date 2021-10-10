package com.digitalwallet.view.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import au.gov.vic.service.digitalwallet.citizen.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a,\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u000e"}, d2 = {"getDWStyleClickableSpan", "Landroid/text/style/ClickableSpan;", "context", "Landroid/content/Context;", "onClicked", "Lkotlin/Function0;", "", "colorId", "", "getDWStyleSpannableStringBuilder", "Landroid/text/SpannableStringBuilder;", "fullTextId", "highlightedTextId", "onHighlightClicked", "base_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: SpannableText.kt */
public final class SpannableTextKt {
    public static final SpannableStringBuilder getDWStyleSpannableStringBuilder(Context context, int i, int i2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "onHighlightClicked");
        String string = context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(fullTextId)");
        String string2 = context.getString(i2);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(highlightedTextId)");
        String str = string;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, string2, 0, false, 6, (Object) null);
        spannableStringBuilder.setSpan(getDWStyleClickableSpan$default(context, function0, 0, 4, null), indexOf$default, string2.length() + indexOf$default, 33);
        return spannableStringBuilder;
    }

    public static final ClickableSpan getDWStyleClickableSpan(Context context, Function0<Unit> function0, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "onClicked");
        return new SpannableTextKt$getDWStyleClickableSpan$1(function0, context, i);
    }

    public static /* synthetic */ ClickableSpan getDWStyleClickableSpan$default(Context context, Function0 function0, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = R.color.dw_orange_RES_2131034234;
        }
        return getDWStyleClickableSpan(context, function0, i);
    }
}
