package com.digitalwallet.viewmodel.checkIn.checkInRepository;

import android.content.Context;
import android.content.SharedPreferences;
import com.digitalwallet.model.CheckInCookie;
import com.digitalwallet.model.CheckInShortcuts;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInSharedPreferences;", "", "context", "Landroid/content/Context;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Landroid/content/Context;Lcom/squareup/moshi/Moshi;)V", "preferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "clearCheckInCookie", "", "clearCheckInShortcuts", "getCheckInCookie", "Lcom/digitalwallet/model/CheckInCookie;", "getCheckInShortcuts", "Lcom/digitalwallet/model/CheckInShortcuts;", "setCheckInCookie", "cookie", "setCheckInShortcuts", "shortcuts", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Singleton
/* compiled from: CheckInSharedPreferences.kt */
public final class CheckInSharedPreferences {
    private static final String CHECK_IN_COOKIE_KEY = "CHECK_IN_COOKIE_KEY";
    private static final String CHECK_IN_SHORTCUTS_KEY = "CHECK_IN_SHORTCUTS_KEY";
    public static final Companion Companion = new Companion(null);
    private final Moshi moshi;
    private final SharedPreferences preferences;

    public CheckInSharedPreferences(Context context, Moshi moshi2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.moshi = moshi2;
        this.preferences = context.getSharedPreferences("SV_CHECK_IN_PREFERENCES", 0);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInSharedPreferences$Companion;", "", "()V", CheckInSharedPreferences.CHECK_IN_COOKIE_KEY, "", CheckInSharedPreferences.CHECK_IN_SHORTCUTS_KEY, "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInSharedPreferences.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final CheckInCookie getCheckInCookie() {
        CheckInCookie checkInCookie;
        CheckInCookie checkInCookie2 = new CheckInCookie(null, null, false, null, null, null, null, 127, null);
        String string = this.preferences.getString(CHECK_IN_COOKIE_KEY, null);
        if (string == null) {
            return checkInCookie2;
        }
        try {
            JsonAdapter adapter = this.moshi.adapter(CheckInCookie.class);
            Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
            Object fromJson = adapter.fromJson(string);
            Intrinsics.checkNotNull(fromJson);
            checkInCookie = (CheckInCookie) fromJson;
        } catch (Exception e) {
            Timber.e(e);
            clearCheckInCookie();
            checkInCookie = checkInCookie2;
        }
        return checkInCookie != null ? checkInCookie : checkInCookie2;
    }

    public final void setCheckInCookie(CheckInCookie checkInCookie) {
        Intrinsics.checkNotNullParameter(checkInCookie, "cookie");
        JsonAdapter adapter = this.moshi.adapter(CheckInCookie.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
        this.preferences.edit().putString(CHECK_IN_COOKIE_KEY, adapter.toJson(checkInCookie)).apply();
    }

    public final void clearCheckInCookie() {
        this.preferences.edit().remove(CHECK_IN_COOKIE_KEY).apply();
    }

    public final CheckInShortcuts getCheckInShortcuts() {
        CheckInShortcuts checkInShortcuts;
        CheckInShortcuts checkInShortcuts2 = new CheckInShortcuts(null, null, null, null, null, 31, null);
        String string = this.preferences.getString(CHECK_IN_SHORTCUTS_KEY, null);
        if (string == null) {
            return checkInShortcuts2;
        }
        try {
            JsonAdapter adapter = this.moshi.adapter(CheckInShortcuts.class);
            Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
            Object fromJson = adapter.fromJson(string);
            Intrinsics.checkNotNull(fromJson);
            checkInShortcuts = (CheckInShortcuts) fromJson;
        } catch (Exception e) {
            Timber.e(e);
            clearCheckInShortcuts();
            checkInShortcuts = checkInShortcuts2;
        }
        return checkInShortcuts != null ? checkInShortcuts : checkInShortcuts2;
    }

    public final void setCheckInShortcuts(CheckInShortcuts checkInShortcuts) {
        Intrinsics.checkNotNullParameter(checkInShortcuts, "shortcuts");
        JsonAdapter adapter = this.moshi.adapter(CheckInShortcuts.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
        this.preferences.edit().putString(CHECK_IN_SHORTCUTS_KEY, adapter.toJson(checkInShortcuts)).apply();
    }

    public final void clearCheckInShortcuts() {
        this.preferences.edit().remove(CHECK_IN_SHORTCUTS_KEY).apply();
    }
}
