package com.digitalwallet.view.util;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import au.gov.vic.service.digitalwallet.citizen.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/digitalwallet/view/util/SpannableTextKt$getDWStyleClickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SpannableText.kt */
public final class SpannableTextKt$getDWStyleClickableSpan$1 extends ClickableSpan {
    final /* synthetic */ int $colorId;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0 $onClicked;

    SpannableTextKt$getDWStyleClickableSpan$1(Function0 function0, Context context, int i) {
        this.$onClicked = function0;
        this.$context = context;
        this.$colorId = i;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        this.$onClicked.invoke();
    }

    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setColor(this.$context.getColor(this.$colorId));
        textPaint.setTypeface(ResourcesCompat.getFont(this.$context, R.font.vic_bold));
        textPaint.setUnderlineText(false);
    }
}
