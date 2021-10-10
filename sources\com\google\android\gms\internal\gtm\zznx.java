package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.List;

public final class zznx {
    private static final String zzals = new String("");
    private static final Integer zzatz = 0;
    private final int type;
    private final Object value;
    private final List<Integer> zzaua;
    private final boolean zzaub;

    private zznx(Integer num, Object obj, List<Integer> list, boolean z) {
        this.type = num.intValue();
        this.value = obj;
        this.zzaua = Collections.unmodifiableList(list);
        this.zzaub = z;
    }

    public final int getType() {
        return this.type;
    }

    public final Object getValue() {
        return this.value;
    }

    public final List<Integer> zzmd() {
        return this.zzaua;
    }

    public final String toString() {
        Object obj = this.value;
        if (obj != null) {
            return obj.toString();
        }
        zzev.zzav("Fail to convert a null object to string");
        return zzals;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zznx) && ((zznx) obj).value.equals(this.value);
    }

    public final int hashCode() {
        return this.value.hashCode();
    }
}
