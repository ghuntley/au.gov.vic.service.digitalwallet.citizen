package com.digitalwallet.utilities;

import android.content.Context;
import au.gov.vic.service.digitalwallet.citizen.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

public final class DateFormattingHelper {
    private static final String CHECK_IN_DATETIME_FORMAT;
    public static final long DAY_IN_MS;
    private static final String DOB_FORMAT;
    private static final String HOLDING_DATETIME_FORMAT;
    public static final DateFormattingHelper INSTANCE = new DateFormattingHelper();
    private static final String ISO_8601;
    private static final String MOCK_DATETIME_FORMAT;
    private static final String MONTH_AS_WORD_FORMAT;
    private static final List<String> formatStrings = CollectionsKt.listOf((Object[]) new String[]{HOLDING_DATETIME_FORMAT, MOCK_DATETIME_FORMAT, ISO_8601, DOB_FORMAT});

    private DateFormattingHelper() {
    }

    public static /* synthetic */ String toISO8601String$default(DateFormattingHelper dateFormattingHelper, Date date, Locale locale, TimeZone timeZone, int i, Object obj) {
        if ((i & 2) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        }
        if ((i & 4) != 0) {
            timeZone = TimeZone.getDefault();
            Intrinsics.checkNotNullExpressionValue(timeZone, "TimeZone.getDefault()");
        }
        return dateFormattingHelper.toISO8601String(date, locale, timeZone);
    }

    public final String toISO8601String(Date date, Locale locale, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(locale, "toLocale");
        Intrinsics.checkNotNullParameter(timeZone, "toTimeZone");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ISO_8601, locale);
        simpleDateFormat.setTimeZone(timeZone);
        String format = simpleDateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(ISO_860…toTimeZone }.format(date)");
        return format;
    }

    public static /* synthetic */ Date fromISO8601String$default(DateFormattingHelper dateFormattingHelper, String str, Locale locale, TimeZone timeZone, int i, Object obj) {
        if ((i & 2) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        }
        if ((i & 4) != 0) {
            timeZone = TimeZone.getDefault();
            Intrinsics.checkNotNullExpressionValue(timeZone, "TimeZone.getDefault()");
        }
        return dateFormattingHelper.fromISO8601String(str, locale, timeZone);
    }

    public final Date fromISO8601String(String str, Locale locale, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(str, "dateString");
        Intrinsics.checkNotNullParameter(locale, "toLocale");
        Intrinsics.checkNotNullParameter(timeZone, "toTimeZone");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ISO_8601, locale);
            simpleDateFormat.setTimeZone(timeZone);
            return simpleDateFormat.parse(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public final String toStringMonthAsWord(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        String format = SimpleDateFormat.getDateInstance(2).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat.getDate…rmat.MEDIUM).format(date)");
        return format;
    }

    public final String toStringAsShortWeekdayDayMonth(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        String format = new SimpleDateFormat("EEE dd MMM", Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"EEE dd…etDefault()).format(date)");
        return format;
    }

    public final String toStringAsShortHourTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        String format = new SimpleDateFormat("h:mma", Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"h:mma\"…etDefault()).format(date)");
        return format;
    }

    public final String toDateWithMonthAsWord(String str) {
        Intrinsics.checkNotNullParameter(str, "dateString");
        return tryParseWithFormatString$default(this, str, MONTH_AS_WORD_FORMAT, false, 4, null);
    }

    public final String toDateWithMonthAsWordFromUTC(String str) {
        Intrinsics.checkNotNullParameter(str, "dateString");
        return tryParseWithFormatString(str, MONTH_AS_WORD_FORMAT, true);
    }

    public final String toDate(String str) {
        Intrinsics.checkNotNullParameter(str, "dateString");
        return tryParseWithFormatString$default(this, str, "dd/MM/yyyy", false, 4, null);
    }

    public final String toCheckInDateTimeString(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        String format = new SimpleDateFormat(CHECK_IN_DATETIME_FORMAT, Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(CHECK_I…etDefault()).format(date)");
        return format;
    }

    public final String tryParseToShowTime(String str) {
        Intrinsics.checkNotNullParameter(str, "dateString");
        return tryParseWithFormatString$default(this, str, "hh:mma", false, 4, null);
    }

    public final String tryParseToShowDateTime(String str) {
        Intrinsics.checkNotNullParameter(str, "dateString");
        return tryParseWithFormatString$default(this, str, "dd/MM/yyyy'\nat 'hh:mma", false, 4, null);
    }

    public final String getCurrentTimeInISO8601() {
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
        Date time = instance.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "Calendar.getInstance().time");
        return toISO8601String$default(this, time, null, null, 6, null);
    }

    public final String getCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy", Locale.getDefault());
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
        String format = simpleDateFormat.format(instance.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"ddMMyy…endar.getInstance().time)");
        return format;
    }

    public final String getCurrentDateWithMonthAsWord() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(MONTH_AS_WORD_FORMAT, Locale.getDefault());
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
        String format = simpleDateFormat.format(instance.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(MONTH_A…endar.getInstance().time)");
        return format;
    }

    public static /* synthetic */ Date tryParse$default(DateFormattingHelper dateFormattingHelper, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return dateFormattingHelper.tryParse(str, z);
    }

    public final Date tryParse(String str, boolean z) {
        Date date;
        Intrinsics.checkNotNullParameter(str, "dateString");
        TimeZone timeZone = z ? TimeZone.getTimeZone("utc") : TimeZone.getDefault();
        Iterator<T> it = formatStrings.iterator();
        do {
            date = null;
            if (!it.hasNext()) {
                break;
            }
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(it.next(), Locale.getDefault());
                simpleDateFormat.setTimeZone(timeZone);
                date = simpleDateFormat.parse(str);
                continue;
            } catch (Throwable unused) {
            }
        } while (date == null);
        return date;
    }

    public static /* synthetic */ String toHoldingDate$default(DateFormattingHelper dateFormattingHelper, Date date, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return dateFormattingHelper.toHoldingDate(date, z);
    }

    public final String toHoldingDate(Date date, boolean z) {
        TimeZone timeZone;
        Intrinsics.checkNotNullParameter(date, "date");
        if (z) {
            try {
                timeZone = TimeZone.getTimeZone("utc");
            } catch (Exception unused) {
                return null;
            }
        } else {
            timeZone = TimeZone.getDefault();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(HOLDING_DATETIME_FORMAT, Locale.getDefault());
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }

    static /* synthetic */ String tryParseWithFormatString$default(DateFormattingHelper dateFormattingHelper, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return dateFormattingHelper.tryParseWithFormatString(str, str2, z);
    }

    private final String tryParseWithFormatString(String str, String str2, boolean z) {
        String str3;
        TimeZone timeZone = z ? TimeZone.getTimeZone("utc") : TimeZone.getDefault();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = formatStrings.iterator();
        while (it.hasNext()) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(it.next(), Locale.getDefault());
                simpleDateFormat.setTimeZone(timeZone);
                Date parse = simpleDateFormat.parse(str);
                if (parse != null) {
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str2, Locale.getDefault());
                    simpleDateFormat2.setTimeZone(timeZone);
                    str3 = simpleDateFormat2.format(parse);
                    if (str3 != null) {
                        arrayList.add(str3);
                    }
                } else {
                    throw new ParseException("", 0);
                }
            } catch (ParseException unused) {
                str3 = null;
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            if (str.length() > 0) {
                Timber.w("No valid date formatter style provided for " + str + " to " + str2, new Object[0]);
            }
        }
        String str4 = (String) CollectionsKt.maxOrNull((Iterable) arrayList2);
        return str4 != null ? str4 : str;
    }

    public static /* synthetic */ Long getTimeDifference$default(DateFormattingHelper dateFormattingHelper, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ISO_8601, Locale.getDefault());
            Calendar instance = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
            str = simpleDateFormat.format(instance.getTime());
            Intrinsics.checkNotNullExpressionValue(str, "SimpleDateFormat(ISO_860…endar.getInstance().time)");
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return dateFormattingHelper.getTimeDifference(str, str2, z);
    }

    public final Long getTimeDifference(String str, String str2, boolean z) {
        Long l;
        Intrinsics.checkNotNullParameter(str, "startDateString");
        Intrinsics.checkNotNullParameter(str2, "endDateString");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = formatStrings.iterator();
        while (it.hasNext()) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(it.next(), Locale.getDefault());
                simpleDateFormat.setTimeZone(TimeZone.getDefault());
                Date parse = simpleDateFormat.parse(str2);
                if (parse != null) {
                    Date parse2 = simpleDateFormat.parse(str);
                    if (parse2 != null) {
                        long time = parse.getTime() - parse2.getTime();
                        if (z) {
                            time = TimeUnit.DAYS.convert(time, TimeUnit.MILLISECONDS);
                        }
                        l = Long.valueOf(time);
                        if (l != null) {
                            arrayList.add(l);
                        }
                    } else {
                        throw new ParseException("", 0);
                    }
                } else {
                    throw new ParseException("", 0);
                }
            } catch (ParseException unused) {
                l = null;
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            boolean z2 = true;
            if (str.length() > 0) {
                if (str2.length() <= 0) {
                    z2 = false;
                }
                if (z2) {
                    Timber.w("No valid date formatter provided for comparing " + str + " to " + str2, new Object[0]);
                }
            }
        }
        return (Long) CollectionsKt.firstOrNull(CollectionsKt.sortedDescending(arrayList2));
    }

    public final boolean isSameDay(Date date, Date date2) {
        Intrinsics.checkNotNullParameter(date, "dateA");
        Intrinsics.checkNotNullParameter(date2, "dateB");
        return Intrinsics.areEqual(toStringMonthAsWord(date), toStringMonthAsWord(date2));
    }

    public final String getRelativeDay(Date date, Context context) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(context, "context");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
        Date time = instance.getTime();
        Date date2 = new Date(date.getTime());
        long j = (long) 86400000;
        date2.setTime((date2.getTime() / j) * j);
        Intrinsics.checkNotNullExpressionValue(time, "now");
        Date date3 = new Date(time.getTime());
        date3.setTime((date3.getTime() / j) * j);
        long convert = TimeUnit.DAYS.convert(date2.getTime() - date3.getTime(), TimeUnit.MILLISECONDS);
        int i = (convert > -1 ? 1 : (convert == -1 ? 0 : -1));
        if (i < 0) {
            String string = context.getString(R.string.n_days_ago, Long.valueOf(-convert));
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…n_days_ago, -daysFromNow)");
            return string;
        } else if (i == 0) {
            String string2 = context.getString(R.string.yesterday);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.yesterday)");
            return string2;
        } else if (convert == 0) {
            String string3 = context.getString(R.string.today);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.today)");
            return string3;
        } else if (convert == 1) {
            String string4 = context.getString(R.string.tomorrow);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.string.tomorrow)");
            return string4;
        } else {
            String string5 = context.getString(R.string.in_n_days, Long.valueOf(convert));
            Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.string.in_n_days, daysFromNow)");
            return string5;
        }
    }
}
