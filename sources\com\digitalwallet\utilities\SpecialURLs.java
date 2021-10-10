package com.digitalwallet.utilities;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.widget.TextView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.view.util.ColorUnderlineSpan;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class SpecialURLs {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.digitalwallet.utilities.SpecialURLs$Companion */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void setPrivacySecurityText$default(Companion companion, Context context, int i, TextView textView, int i2, Function0 function0, int i3, Object obj) {
            if ((i3 & 16) != 0) {
                function0 = null;
            }
            companion.setPrivacySecurityText(context, i, textView, i2, function0);
        }

        public final void setPrivacySecurityText(Context context, int i, TextView textView, int i2, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(textView, "textView");
            List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{"Privacy/Security", "Terms of use"});
            String string = context.getString(i, "https://service.vic.gov.au/");
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(string…ce, BuildConfig.API_HOST)");
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(htmlToSpannable(context, string, listOf, i2, function0));
        }

        private final Spanned spannedFromHtml(String str) {
            if (Build.VERSION.SDK_INT >= 24) {
                Spanned fromHtml = Html.fromHtml(str, 0);
                Intrinsics.checkNotNullExpressionValue(fromHtml, "Html.fromHtml(html, 0)");
                return fromHtml;
            }
            Spanned fromHtml2 = Html.fromHtml(str);
            Intrinsics.checkNotNullExpressionValue(fromHtml2, "Html.fromHtml(html)");
            return fromHtml2;
        }

        private final SpannableString htmlToSpannable(Context context, String str, List<String> list, int i, Function0<Unit> function0) {
            SpannableString spannableString = new SpannableString(spannedFromHtml(str));
            AnalyticsHelper analyticsHelper = new AnalyticsHelper(context);
            URLSpan[] uRLSpanArr = (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class);
            Intrinsics.checkNotNullExpressionValue(uRLSpanArr, "spans");
            int length = uRLSpanArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i3 < length) {
                URLSpan uRLSpan = uRLSpanArr[i3];
                int i4 = i2 + 1;
                if (i2 < list.size()) {
                    Companion companion = SpecialURLs.Companion;
                    Intrinsics.checkNotNullExpressionValue(uRLSpan, "span");
                    SpecialURLs.Companion.instrumentAndStyleSpan(context, uRLSpan, spannableString, companion.trackUrlSpanWithoutUnderline(analyticsHelper, uRLSpan, list.get(i2), function0), i);
                    i3++;
                    i2 = i4;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
            return spannableString;
        }

        private final void instrumentAndStyleSpan(Context context, Object obj, SpannableString spannableString, ClickableSpan clickableSpan, int i) {
            int spanStart = spannableString.getSpanStart(obj);
            int spanEnd = spannableString.getSpanEnd(obj);
            int spanFlags = spannableString.getSpanFlags(obj);
            ColorUnderlineSpan colorUnderlineSpan = new ColorUnderlineSpan(i, spanStart, spanEnd, context.getResources().getDimension(R.dimen.login_link_underline_offset));
            spannableString.removeSpan(obj);
            spannableString.setSpan(colorUnderlineSpan, spanStart, spanEnd, spanFlags);
            spannableString.setSpan(clickableSpan, spanStart, spanEnd, spanFlags);
        }

        private final SpecialURLs$Companion$trackUrlSpanWithoutUnderline$1 trackUrlSpanWithoutUnderline(AnalyticsHelper analyticsHelper, URLSpan uRLSpan, String str, Function0<Unit> function0) {
            return new SpecialURLs$Companion$trackUrlSpanWithoutUnderline$1(function0, analyticsHelper, str, uRLSpan, uRLSpan.getURL());
        }
    }
}
