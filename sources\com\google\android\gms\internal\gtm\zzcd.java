package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzcd {
    private final List<zzbk> zzaaz;
    private final long zzaba;
    private final long zzabb;
    private final int zzabc;
    private final boolean zzabd;
    private final String zzabe;
    private final Map<String, String> zztc;

    public zzcd(zzam zzam, Map<String, String> map, long j, boolean z) {
        this(zzam, map, j, z, 0, 0, null);
    }

    public zzcd(zzam zzam, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(zzam, map, j, z, j2, i, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bf  */
    public zzcd(zzam zzam, Map<String, String> map, long j, boolean z, long j2, int i, List<zzbk> list) {
        List<zzbk> list2;
        String str;
        String zza;
        String zza2;
        Preconditions.checkNotNull(zzam);
        Preconditions.checkNotNull(map);
        this.zzabb = j;
        this.zzabd = z;
        this.zzaba = j2;
        this.zzabc = i;
        if (list != null) {
            list2 = list;
        } else {
            list2 = Collections.emptyList();
        }
        this.zzaaz = list2;
        String str2 = null;
        if (list != null) {
            Iterator<zzbk> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                zzbk next = it.next();
                if ("appendVersion".equals(next.getId())) {
                    str = next.getValue();
                    break;
                }
            }
            this.zzabe = !TextUtils.isEmpty(str) ? str : str2;
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (zzc(entry.getKey()) && (zza2 = zza(zzam, entry.getKey())) != null) {
                    hashMap.put(zza2, zzb(zzam, entry.getValue()));
                }
            }
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                if (!zzc(entry2.getKey()) && (zza = zza(zzam, entry2.getKey())) != null) {
                    hashMap.put(zza, zzb(zzam, entry2.getValue()));
                }
            }
            if (!TextUtils.isEmpty(this.zzabe)) {
                zzcz.zzb(hashMap, "_v", this.zzabe);
                if (this.zzabe.equals("ma4.0.0") || this.zzabe.equals("ma4.0.1")) {
                    hashMap.remove("adid");
                }
            }
            this.zztc = Collections.unmodifiableMap(hashMap);
        }
        str = null;
        this.zzabe = !TextUtils.isEmpty(str) ? str : str2;
        HashMap hashMap2 = new HashMap();
        while (r4.hasNext()) {
        }
        while (r2.hasNext()) {
        }
        if (!TextUtils.isEmpty(this.zzabe)) {
        }
        this.zztc = Collections.unmodifiableMap(hashMap2);
    }

    private static boolean zzc(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith("&");
    }

    private static String zza(zzam zzam, Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            zzam.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        if (TextUtils.isEmpty(obj2)) {
            return null;
        }
        return obj2;
    }

    private static String zzb(zzam zzam, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        String substring = obj2.substring(0, 8192);
        zzam.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(length), substring);
        return substring;
    }

    public final int zzff() {
        return this.zzabc;
    }

    public final Map<String, String> zzdm() {
        return this.zztc;
    }

    public final long zzfg() {
        return this.zzaba;
    }

    public final long zzfh() {
        return this.zzabb;
    }

    public final List<zzbk> zzfi() {
        return this.zzaaz;
    }

    public final boolean zzfj() {
        return this.zzabd;
    }

    public final long zzfk() {
        return zzcz.zzag(zzd("_s", "0"));
    }

    public final String zzfl() {
        return zzd("_m", "");
    }

    private final String zzd(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(!str.startsWith("&"), "Short param name required");
        String str3 = this.zztc.get(str);
        return str3 != null ? str3 : str2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ht=");
        sb.append(this.zzabb);
        if (this.zzaba != 0) {
            sb.append(", dbId=");
            sb.append(this.zzaba);
        }
        if (this.zzabc != 0) {
            sb.append(", appUID=");
            sb.append(this.zzabc);
        }
        ArrayList arrayList = new ArrayList(this.zztc.keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            String str = (String) obj;
            sb.append(", ");
            sb.append(str);
            sb.append("=");
            sb.append(this.zztc.get(str));
        }
        return sb.toString();
    }
}
