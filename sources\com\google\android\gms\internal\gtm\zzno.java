package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.Map;

public final class zzno {
    private final Map<String, zznx> zzats;
    private final zznx zzatt;

    private zzno(Map<String, zznx> map, zznx zznx) {
        this.zzats = Collections.unmodifiableMap(map);
        this.zzatt = zznx;
    }

    public final Map<String, zznx> zzlu() {
        return this.zzats;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzats);
        String valueOf2 = String.valueOf(this.zzatt);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32 + String.valueOf(valueOf2).length());
        sb.append("Properties: ");
        sb.append(valueOf);
        sb.append(" pushAfterEvaluate: ");
        sb.append(valueOf2);
        return sb.toString();
    }
}
