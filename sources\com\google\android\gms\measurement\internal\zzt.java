package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzmx;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zzt {
    private String zza;
    private boolean zzb;
    private zzcd.zzi zzc;
    private BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzr zzh;

    private zzt(zzr zzr, String str) {
        this.zzh = zzr;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzt(zzr zzr, String str, zzcd.zzi zzi, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zzr;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.zzg.put(num, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zzi;
    }

    public final void zza(zzu zzu) {
        int zza2 = zzu.zza();
        if (zzu.zzc != null) {
            this.zze.set(zza2, zzu.zzc.booleanValue());
        }
        if (zzu.zzd != null) {
            this.zzd.set(zza2, zzu.zzd.booleanValue());
        }
        if (zzu.zze != null) {
            Long l = this.zzf.get(Integer.valueOf(zza2));
            long longValue = zzu.zze.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.zzf.put(Integer.valueOf(zza2), Long.valueOf(longValue));
            }
        }
        if (zzu.zzf != null) {
            List<Long> list = this.zzg.get(Integer.valueOf(zza2));
            if (list == null) {
                list = new ArrayList<>();
                this.zzg.put(Integer.valueOf(zza2), list);
            }
            if (zzu.zzb()) {
                list.clear();
            }
            if (zzmx.zzb() && this.zzh.zzs().zzd(this.zza, zzas.zzbb) && zzu.zzc()) {
                list.clear();
            }
            if (!zzmx.zzb() || !this.zzh.zzs().zzd(this.zza, zzas.zzbb)) {
                list.add(Long.valueOf(zzu.zzf.longValue() / 1000));
                return;
            }
            long longValue2 = zzu.zzf.longValue() / 1000;
            if (!list.contains(Long.valueOf(longValue2))) {
                list.add(Long.valueOf(longValue2));
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x00d3 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.List] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final zzcd.zza zza(int i) {
        ArrayList arrayList;
        ?? r1;
        zzcd.zza.C0012zza zzh2 = zzcd.zza.zzh();
        zzh2.zza(i);
        zzh2.zza(this.zzb);
        zzcd.zzi zzi = this.zzc;
        if (zzi != null) {
            zzh2.zza(zzi);
        }
        zzcd.zzi.zza zza2 = zzcd.zzi.zzi().zzb(zzkr.zza(this.zzd)).zza(zzkr.zza(this.zze));
        if (this.zzf == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.zzf.size());
            for (Integer num : this.zzf.keySet()) {
                int intValue = num.intValue();
                arrayList.add((zzcd.zzb) ((zzhy) zzcd.zzb.zze().zza(intValue).zza(this.zzf.get(Integer.valueOf(intValue)).longValue()).zzy()));
            }
        }
        zza2.zzc(arrayList);
        if (this.zzg == null) {
            r1 = Collections.emptyList();
        } else {
            r1 = new ArrayList(this.zzg.size());
            for (Integer num2 : this.zzg.keySet()) {
                zzcd.zzj.zza zza3 = zzcd.zzj.zze().zza(num2.intValue());
                List<Long> list = this.zzg.get(num2);
                if (list != null) {
                    Collections.sort(list);
                    zza3.zza(list);
                }
                r1.add((zzcd.zzj) ((zzhy) zza3.zzy()));
            }
        }
        zza2.zzd(r1);
        zzh2.zza(zza2);
        return (zzcd.zza) ((zzhy) zzh2.zzy());
    }

    /* synthetic */ zzt(zzr zzr, String str, zzcd.zzi zzi, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzq zzq) {
        this(zzr, str, zzi, bitSet, bitSet2, map, map2);
    }

    /* synthetic */ zzt(zzr zzr, String str, zzq zzq) {
        this(zzr, str);
    }
}
