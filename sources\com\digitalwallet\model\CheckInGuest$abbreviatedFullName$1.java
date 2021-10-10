package com.digitalwallet.model;

import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckIn.kt */
public final class CheckInGuest$abbreviatedFullName$1 extends Lambda implements Function0<String> {
    final /* synthetic */ CheckInGuest this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInGuest$abbreviatedFullName$1(CheckInGuest checkInGuest) {
        super(0);
        this.this$0 = checkInGuest;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        String firstName = this.this$0.getFirstName();
        String str = "";
        if (firstName == null) {
            firstName = str;
        }
        Objects.requireNonNull(firstName, "null cannot be cast to non-null type kotlin.CharSequence");
        String obj = StringsKt.trim((CharSequence) firstName).toString();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        String capitalize = StringsKt.capitalize(obj, locale);
        String lastName = this.this$0.getLastName();
        if (lastName != null) {
            str = lastName;
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        String obj2 = StringsKt.trim((CharSequence) str).toString();
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "Locale.getDefault()");
        Object capitalize2 = StringsKt.capitalize(obj2, locale2);
        Object firstOrNull = StringsKt.firstOrNull((CharSequence) capitalize2);
        if (firstOrNull != null) {
            capitalize2 = firstOrNull;
        }
        return capitalize + ' ' + capitalize2;
    }
}
