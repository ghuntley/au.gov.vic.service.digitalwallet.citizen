package com.digitalwallet.utilities;

import android.util.Patterns;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0010\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0003¨\u0006\t"}, d2 = {"containsALowerCaseLetter", "", "input", "", "containsAnUpperCaseLetter", "isEmailValid", "email", "isNameValid", "name", "base_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: ValidationHelper.kt */
public final class ValidationHelperKt {
    public static final boolean isNameValid(String str) {
        Character ch;
        Intrinsics.checkNotNullParameter(str, "name");
        String obj = StringsKt.trim((CharSequence) str).toString();
        int i = 0;
        while (true) {
            ch = null;
            if (i >= obj.length()) {
                break;
            }
            char charAt = obj.charAt(i);
            if (!Character.isLetter(charAt) && !CharsKt.isWhitespace(charAt) && !StringsKt.contains$default("'`´‘’", charAt, false, 2, null) && !StringsKt.contains$default("-‒–—―−‐", charAt, false, 2, null)) {
                ch = Character.valueOf(charAt);
                break;
            }
            i++;
        }
        if (ch == null) {
            return true;
        }
        return false;
    }

    public static final boolean isEmailValid(String str) {
        String str2;
        if (str != null) {
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
            str2 = StringsKt.trim((CharSequence) str).toString();
        } else {
            str2 = null;
        }
        String str3 = str2;
        if (str3 == null || StringsKt.isBlank(str3)) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(str3).matches();
    }

    public static final boolean containsAnUpperCaseLetter(String str) {
        Regex regex = new Regex("[A-Z]+");
        if (str == null || !regex.containsMatchIn(str)) {
            return false;
        }
        return true;
    }

    public static final boolean containsALowerCaseLetter(String str) {
        Regex regex = new Regex("[a-z]+");
        if (str == null || !regex.containsMatchIn(str)) {
            return false;
        }
        return true;
    }
}
