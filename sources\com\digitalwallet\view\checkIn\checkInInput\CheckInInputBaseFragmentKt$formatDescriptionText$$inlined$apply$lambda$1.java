package com.digitalwallet.view.checkIn.checkInInput;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.utilities.FragmentHelperKt;
import com.digitalwallet.view.base.BasicFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/digitalwallet/view/checkIn/checkInInput/CheckInInputBaseFragmentKt$formatDescriptionText$1$clickable$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "p0", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInInputBaseFragment.kt */
public final class CheckInInputBaseFragmentKt$formatDescriptionText$$inlined$apply$lambda$1 extends ClickableSpan {
    final /* synthetic */ Function0 $extraCallbackOnClick$inlined;
    final /* synthetic */ int $highlightColor$inlined;
    final /* synthetic */ String $learnMoreText$inlined;
    final /* synthetic */ String $text$inlined;
    final /* synthetic */ BasicFragment $this_formatDescriptionText$inlined;

    CheckInInputBaseFragmentKt$formatDescriptionText$$inlined$apply$lambda$1(BasicFragment basicFragment, String str, String str2, Function0 function0, int i) {
        this.$this_formatDescriptionText$inlined = basicFragment;
        this.$text$inlined = str;
        this.$learnMoreText$inlined = str2;
        this.$extraCallbackOnClick$inlined = function0;
        this.$highlightColor$inlined = i;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "p0");
        BasicFragment basicFragment = this.$this_formatDescriptionText$inlined;
        BasicFragment basicFragment2 = basicFragment;
        String string = basicFragment.getResources().getString(R.string.check_in_learn_more_url);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st….check_in_learn_more_url)");
        FragmentHelperKt.openURL(basicFragment2, string);
        Function0 function0 = this.$extraCallbackOnClick$inlined;
        if (function0 != null) {
            Unit unit = (Unit) function0.invoke();
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setColor(this.$highlightColor$inlined);
        textPaint.setUnderlineText(true);
    }
}
