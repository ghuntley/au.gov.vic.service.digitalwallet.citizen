package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class zzgw {
    private static final Map<String, zzgx> zzarc;

    public static zzol zza(String str, Map<String, zzoa<?>> map, zzfl zzfl) {
        Map<String, zzgx> map2 = zzarc;
        if (map2.containsKey(str)) {
            zzgx zzgx = map2.get(str);
            String[] zzlc = zzgx.zzlc();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < zzlc.length; i++) {
                if (!map.containsKey(zzlc[i])) {
                    arrayList.add(zzog.zzaum);
                } else {
                    arrayList.add(map.get(zzlc[i]));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new zzom("gtmUtils"));
            zzol zzol = new zzol("15", arrayList2);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(zzol);
            arrayList3.add(new zzom("mobile"));
            zzol zzol2 = new zzol("17", arrayList3);
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(zzol2);
            arrayList4.add(new zzom(zzgx.zzlb()));
            arrayList4.add(new zzoh(arrayList));
            return new zzol("2", arrayList4);
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 47);
        sb.append("Fail to convert ");
        sb.append(str);
        sb.append(" to the internal representation");
        throw new RuntimeException(sb.toString());
    }

    public static String zzcc(String str) {
        Map<String, zzgx> map = zzarc;
        if (map.containsKey(str)) {
            return map.get(str).zzlb();
        }
        return null;
    }

    public static String zza(zza zza) {
        return zzcc(zza.toString());
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(zza.CONTAINS.toString(), new zzgx("contains"));
        hashMap.put(zza.ENDS_WITH.toString(), new zzgx("endsWith"));
        hashMap.put(zza.EQUALS.toString(), new zzgx("equals"));
        hashMap.put(zza.GREATER_EQUALS.toString(), new zzgx("greaterEquals"));
        hashMap.put(zza.GREATER_THAN.toString(), new zzgx("greaterThan"));
        hashMap.put(zza.LESS_EQUALS.toString(), new zzgx("lessEquals"));
        hashMap.put(zza.LESS_THAN.toString(), new zzgx("lessThan"));
        hashMap.put(zza.REGEX.toString(), new zzgx("regex", new String[]{zzb.ARG0.toString(), zzb.ARG1.toString(), zzb.IGNORE_CASE.toString()}));
        hashMap.put(zza.STARTS_WITH.toString(), new zzgx("startsWith"));
        zzarc = hashMap;
    }
}
