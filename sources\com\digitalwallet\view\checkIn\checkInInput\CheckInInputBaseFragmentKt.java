package com.digitalwallet.view.checkIn.checkInInput;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.utilities.SpecialURLs;
import com.digitalwallet.view.base.BasicFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006\u001a$\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006¨\u0006\n"}, d2 = {"formatDescriptionText", "", "Lcom/digitalwallet/view/base/BasicFragment;", "dataDescTextView", "Landroid/widget/TextView;", "extraCallbackOnClick", "Lkotlin/Function0;", "formatPrivacySecurityText", "privacyTextView", "clickHandler", "base_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: CheckInInputBaseFragment.kt */
public final class CheckInInputBaseFragmentKt {
    public static /* synthetic */ void formatDescriptionText$default(BasicFragment basicFragment, TextView textView, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        formatDescriptionText(basicFragment, textView, function0);
    }

    public static final void formatDescriptionText(BasicFragment basicFragment, TextView textView, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(basicFragment, "$this$formatDescriptionText");
        Intrinsics.checkNotNullParameter(textView, "dataDescTextView");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String string = basicFragment.requireContext().getString(R.string.check_in_data_desc);
        Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri…tring.check_in_data_desc)");
        String string2 = basicFragment.requireContext().getString(R.string.check_in_learn_more);
        Intrinsics.checkNotNullExpressionValue(string2, "requireContext().getStri…ring.check_in_learn_more)");
        int color = basicFragment.requireContext().getColor(R.color.dw_slate_RES_2131034238);
        String str = string;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, string2, 0, false, 6, (Object) null);
        spannableStringBuilder.setSpan(new CheckInInputBaseFragmentKt$formatDescriptionText$$inlined$apply$lambda$1(basicFragment, string, string2, function0, color), indexOf$default, indexOf$default + string2.length(), 0);
        textView.setText(spannableStringBuilder);
    }

    public static /* synthetic */ void formatPrivacySecurityText$default(BasicFragment basicFragment, TextView textView, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        formatPrivacySecurityText(basicFragment, textView, function0);
    }

    public static final void formatPrivacySecurityText(BasicFragment basicFragment, TextView textView, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(basicFragment, "$this$formatPrivacySecurityText");
        Intrinsics.checkNotNullParameter(textView, "privacyTextView");
        SpecialURLs.Companion companion = SpecialURLs.Companion;
        Context requireContext = basicFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        companion.setPrivacySecurityText(requireContext, R.string.check_in_privacy, textView, ContextCompat.getColor(basicFragment.requireContext(), R.color.dw_battleship_grey_RES_2131034233), function0);
    }
}
