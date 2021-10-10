package com.google.android.gms.internal.gtm;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.util.UUID;
import kotlin.jvm.internal.LongCompanionObject;

public final class zzco {
    private final String name;
    private final long zzabz;
    private final /* synthetic */ zzcm zzaca;

    private zzco(zzcm zzcm, String str, long j) {
        this.zzaca = zzcm;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j > 0);
        this.name = str;
        this.zzabz = j;
    }

    private final void zzgb() {
        long currentTimeMillis = this.zzaca.zzcn().currentTimeMillis();
        SharedPreferences.Editor edit = this.zzaca.zzabv.edit();
        edit.remove(zzgf());
        edit.remove(zzgg());
        edit.putLong(zzge(), currentTimeMillis);
        edit.commit();
    }

    public final void zzae(String str) {
        if (zzgd() == 0) {
            zzgb();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            long j = this.zzaca.zzabv.getLong(zzgf(), 0);
            if (j <= 0) {
                SharedPreferences.Editor edit = this.zzaca.zzabv.edit();
                edit.putString(zzgg(), str);
                edit.putLong(zzgf(), 1);
                edit.apply();
                return;
            }
            long j2 = j + 1;
            boolean z = (UUID.randomUUID().getLeastSignificantBits() & LongCompanionObject.MAX_VALUE) < LongCompanionObject.MAX_VALUE / j2;
            SharedPreferences.Editor edit2 = this.zzaca.zzabv.edit();
            if (z) {
                edit2.putString(zzgg(), str);
            }
            edit2.putLong(zzgf(), j2);
            edit2.apply();
        }
    }

    public final Pair<String, Long> zzgc() {
        long j;
        long zzgd = zzgd();
        if (zzgd == 0) {
            j = 0;
        } else {
            j = Math.abs(zzgd - this.zzaca.zzcn().currentTimeMillis());
        }
        long j2 = this.zzabz;
        if (j < j2) {
            return null;
        }
        if (j > (j2 << 1)) {
            zzgb();
            return null;
        }
        String string = this.zzaca.zzabv.getString(zzgg(), null);
        long j3 = this.zzaca.zzabv.getLong(zzgf(), 0);
        zzgb();
        if (string == null || j3 <= 0) {
            return null;
        }
        return new Pair<>(string, Long.valueOf(j3));
    }

    private final long zzgd() {
        return this.zzaca.zzabv.getLong(zzge(), 0);
    }

    private final String zzge() {
        return String.valueOf(this.name).concat(":start");
    }

    private final String zzgf() {
        return String.valueOf(this.name).concat(":count");
    }

    private final String zzgg() {
        return String.valueOf(this.name).concat(":value");
    }
}
