package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.content.SharedPreferences;
import com.digitalwallet.utilities.DateFormattingHelper;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Random;

public final class zzdz {
    private final String zzaec;
    private final Random zzafj;
    private final Context zzrm;

    public zzdz(Context context, String str) {
        this(context, str, new Random());
    }

    private zzdz(Context context, String str, Random random) {
        this.zzrm = (Context) Preconditions.checkNotNull(context);
        this.zzaec = (String) Preconditions.checkNotNull(str);
        this.zzafj = random;
    }

    public final long zzhl() {
        return zza(7200000, 259200000) + 43200000;
    }

    public final long zzhm() {
        return zza(600000, DateFormattingHelper.DAY_IN_MS) + 3600000;
    }

    public final long zzkd() {
        if (Math.max(0L, zzhp().getLong("FORBIDDEN_COUNT", 0)) == 0) {
            return 0;
        }
        return zza(10000, 600000) + 10000;
    }

    public final boolean zzke() {
        return Math.max(0, zzhp().getLong("FORBIDDEN_COUNT", 0)) > 0;
    }

    private final long zza(long j, long j2) {
        SharedPreferences zzhp = zzhp();
        long max = Math.max(0L, zzhp.getLong("FORBIDDEN_COUNT", 0));
        return (long) (this.zzafj.nextFloat() * ((float) (j + ((long) ((((float) max) / ((float) ((max + Math.max(0L, zzhp.getLong("SUCCESSFUL_COUNT", 0))) + 1))) * ((float) (j2 - j)))))));
    }

    public final void zzhn() {
        long j;
        SharedPreferences zzhp = zzhp();
        long j2 = zzhp.getLong("FORBIDDEN_COUNT", 0);
        long j3 = zzhp.getLong("SUCCESSFUL_COUNT", 0);
        SharedPreferences.Editor edit = zzhp.edit();
        if (j2 == 0) {
            j = 3;
        } else {
            j = Math.min(10L, j2 + 1);
        }
        long max = Math.max(0L, Math.min(j3, 10 - j));
        edit.putLong("FORBIDDEN_COUNT", j);
        edit.putLong("SUCCESSFUL_COUNT", max);
        edit.apply();
    }

    public final void zzho() {
        SharedPreferences zzhp = zzhp();
        long j = zzhp.getLong("SUCCESSFUL_COUNT", 0);
        long j2 = zzhp.getLong("FORBIDDEN_COUNT", 0);
        long min = Math.min(10L, j + 1);
        long max = Math.max(0L, Math.min(j2, 10 - min));
        SharedPreferences.Editor edit = zzhp.edit();
        edit.putLong("SUCCESSFUL_COUNT", min);
        edit.putLong("FORBIDDEN_COUNT", max);
        edit.apply();
    }

    private final SharedPreferences zzhp() {
        Context context = this.zzrm;
        String valueOf = String.valueOf(this.zzaec);
        return context.getSharedPreferences(valueOf.length() != 0 ? "v5_gtmContainerRefreshPolicy_".concat(valueOf) : new String("v5_gtmContainerRefreshPolicy_"), 0);
    }
}
