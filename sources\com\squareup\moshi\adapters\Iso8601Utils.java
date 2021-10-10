package com.squareup.moshi.adapters;

import com.squareup.moshi.JsonDataException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.objectweb.asm.signature.SignatureVisitor;

/* access modifiers changed from: package-private */
public final class Iso8601Utils {
    static final String GMT_ID = "GMT";
    static final TimeZone TIMEZONE_Z = TimeZone.getTimeZone(GMT_ID);

    Iso8601Utils() {
    }

    public static String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TIMEZONE_Z, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(24);
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append(SignatureVisitor.SUPER);
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append(SignatureVisitor.SUPER);
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        sb.append('.');
        padInt(sb, gregorianCalendar.get(14), 3);
        sb.append('Z');
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d0 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0199 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException -> 0x01a1 }] */
    public static Date parse(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        TimeZone timeZone;
        char charAt;
        int i7 = 4;
        try {
            int parseInt = parseInt(str, 0, 4);
            if (checkOffset(str, 4, SignatureVisitor.SUPER)) {
                i7 = 5;
            }
            int i8 = i7 + 2;
            int parseInt2 = parseInt(str, i7, i8);
            if (checkOffset(str, i8, SignatureVisitor.SUPER)) {
                i8++;
            }
            int i9 = i8 + 2;
            int parseInt3 = parseInt(str, i8, i9);
            boolean checkOffset = checkOffset(str, i9, 'T');
            if (!checkOffset && str.length() <= i9) {
                return new GregorianCalendar(parseInt, parseInt2 - 1, parseInt3).getTime();
            }
            if (checkOffset) {
                int i10 = i9 + 1;
                int i11 = i10 + 2;
                int parseInt4 = parseInt(str, i10, i11);
                if (checkOffset(str, i11, ':')) {
                    i11++;
                }
                int i12 = i11 + 2;
                i4 = parseInt(str, i11, i12);
                if (checkOffset(str, i12, ':')) {
                    i12++;
                }
                if (str.length() <= i12 || (charAt = str.charAt(i12)) == 'Z' || charAt == '+' || charAt == '-') {
                    i2 = parseInt;
                    i = parseInt3;
                    i5 = parseInt4;
                    i9 = i12;
                    i6 = 0;
                } else {
                    int i13 = i12 + 2;
                    i3 = parseInt(str, i12, i13);
                    if (i3 > 59 && i3 < 63) {
                        i3 = 59;
                    }
                    if (checkOffset(str, i13, '.')) {
                        int i14 = i13 + 1;
                        int indexOfNonDigit = indexOfNonDigit(str, i14 + 1);
                        int min = Math.min(indexOfNonDigit, i14 + 3);
                        i2 = parseInt;
                        i = parseInt3;
                        i6 = (int) (Math.pow(10.0d, (double) (3 - (min - i14))) * ((double) parseInt(str, i14, min)));
                        i5 = parseInt4;
                        i9 = indexOfNonDigit;
                    } else {
                        i2 = parseInt;
                        i = parseInt3;
                        i5 = parseInt4;
                        i9 = i13;
                        i6 = 0;
                    }
                    if (str.length() <= i9) {
                        char charAt2 = str.charAt(i9);
                        if (charAt2 == 'Z') {
                            timeZone = TIMEZONE_Z;
                        } else {
                            if (charAt2 != '+') {
                                if (charAt2 != '-') {
                                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
                                }
                            }
                            String substring = str.substring(i9);
                            if (!"+0000".equals(substring)) {
                                if (!"+00:00".equals(substring)) {
                                    String str2 = GMT_ID + substring;
                                    TimeZone timeZone2 = TimeZone.getTimeZone(str2);
                                    String id = timeZone2.getID();
                                    if (!id.equals(str2)) {
                                        if (!id.replace(":", "").equals(str2)) {
                                            throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str2 + " given, resolves to " + timeZone2.getID());
                                        }
                                    }
                                    timeZone = timeZone2;
                                }
                            }
                            timeZone = TIMEZONE_Z;
                        }
                        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
                        gregorianCalendar.setLenient(false);
                        gregorianCalendar.set(1, i2);
                        gregorianCalendar.set(2, parseInt2 - 1);
                        gregorianCalendar.set(5, i);
                        gregorianCalendar.set(11, i5);
                        gregorianCalendar.set(12, i4);
                        gregorianCalendar.set(13, i3);
                        gregorianCalendar.set(14, i6);
                        return gregorianCalendar.getTime();
                    }
                    throw new IllegalArgumentException("No time zone indicator");
                }
            } else {
                i2 = parseInt;
                i = parseInt3;
                i6 = 0;
                i5 = 0;
                i4 = 0;
            }
            i3 = 0;
            if (str.length() <= i9) {
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            throw new JsonDataException("Not an RFC 3339 date: " + str, e);
        }
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i4 = i5;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        }
        return -i3;
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
