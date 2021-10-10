package com.digitalwallet.utilities;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/digitalwallet/utilities/SpecialURLs$Companion$trackUrlSpanWithoutUnderline$1", "Landroid/text/style/URLSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SpecialURLs.kt */
public final class SpecialURLs$Companion$trackUrlSpanWithoutUnderline$1 extends URLSpan {
    final /* synthetic */ AnalyticsHelper $analytics;
    final /* synthetic */ String $analyticsName;
    final /* synthetic */ Function0 $clickHandler;
    final /* synthetic */ URLSpan $span;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpecialURLs$Companion$trackUrlSpanWithoutUnderline$1(Function0 function0, AnalyticsHelper analyticsHelper, String str, URLSpan uRLSpan, String str2) {
        super(str2);
        this.$clickHandler = function0;
        this.$analytics = analyticsHelper;
        this.$analyticsName = str;
        this.$span = uRLSpan;
    }

    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        Function0 function0 = this.$clickHandler;
        if (function0 != null) {
            Unit unit = (Unit) function0.invoke();
        }
        AnalyticsHelper.selectContent$default(this.$analytics, this.$analyticsName, null, 2, null);
        super.onClick(view);
    }
}
