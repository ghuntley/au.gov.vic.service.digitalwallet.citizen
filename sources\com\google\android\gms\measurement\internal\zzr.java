package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzmx;
import com.google.android.gms.internal.measurement.zznd;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzr extends zzki {
    private String zzb;
    private Set<Integer> zzc;
    private Map<Integer, zzt> zzd;
    private Long zze;
    private Long zzf;

    zzr(zzkl zzkl) {
        super(zzkl);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzki
    public final boolean zzd() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x02d4 A[SYNTHETIC] */
    public final List<zzcd.zza> zza(String str, List<zzcd.zzc> list, List<zzcd.zzk> list2, Long l, Long l2) {
        int i;
        boolean z;
        SQLiteException e;
        zzbv.zze next;
        zzam zzam;
        zzs zzs;
        int i2;
        ArrayMap arrayMap;
        List<zzbv.zzb> list3;
        boolean z2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zzb = str;
        this.zzc = new HashSet();
        this.zzd = new ArrayMap();
        this.zze = l;
        this.zzf = l2;
        Iterator<zzcd.zzc> it = list.iterator();
        while (true) {
            i = 1;
            if (it.hasNext()) {
                if ("_s".equals(it.next().zzc())) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        boolean z3 = zzmx.zzb() && zzs().zzd(this.zzb, zzas.zzbb);
        boolean z4 = zzmx.zzb() && zzs().zzd(this.zzb, zzas.zzba);
        if (z) {
            zzaf zzi = zzi();
            String str2 = this.zzb;
            zzi.zzaj();
            zzi.zzc();
            Preconditions.checkNotEmpty(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                zzi.c_().update("events", contentValues, "app_id = ?", new String[]{str2});
            } catch (SQLiteException e2) {
                zzi.zzq().zze().zza("Error resetting session-scoped event counts. appId", zzeq.zza(str2), e2);
            }
        }
        Map<Integer, List<zzbv.zzb>> emptyMap = Collections.emptyMap();
        if (z4 && z3) {
            emptyMap = zzi().zze(this.zzb);
        }
        Map<Integer, zzcd.zzi> zzg = zzi().zzg(this.zzb);
        if (((zznd.zzb() && zzs().zzd(this.zzb, zzas.zzce)) || zzg != null) && !zzg.isEmpty()) {
            HashSet<Integer> hashSet = new HashSet(zzg.keySet());
            if (z) {
                String str3 = this.zzb;
                Preconditions.checkNotEmpty(str3);
                Preconditions.checkNotNull(zzg);
                ArrayMap arrayMap2 = new ArrayMap();
                if (!zzg.isEmpty()) {
                    Map<Integer, List<Integer>> zzf2 = zzi().zzf(str3);
                    for (Integer num : zzg.keySet()) {
                        int intValue = num.intValue();
                        zzcd.zzi zzi2 = zzg.get(Integer.valueOf(intValue));
                        List<Integer> list4 = zzf2.get(Integer.valueOf(intValue));
                        if (list4 == null || list4.isEmpty()) {
                            arrayMap2.put(Integer.valueOf(intValue), zzi2);
                        } else {
                            List<Long> zza = f_().zza(zzi2.zzc(), list4);
                            if (!zza.isEmpty()) {
                                zzcd.zzi.zza zzb2 = ((zzcd.zzi.zza) zzi2.zzbo()).zzb().zzb(zza);
                                zzb2.zza().zza(f_().zza(zzi2.zza(), list4));
                                for (int i3 = 0; i3 < zzi2.zzf(); i3++) {
                                    if (list4.contains(Integer.valueOf(zzi2.zza(i3).zzb()))) {
                                        zzb2.zza(i3);
                                    }
                                }
                                for (int i4 = 0; i4 < zzi2.zzh(); i4++) {
                                    if (list4.contains(Integer.valueOf(zzi2.zzb(i4).zzb()))) {
                                        zzb2.zzb(i4);
                                    }
                                }
                                arrayMap2.put(Integer.valueOf(intValue), (zzcd.zzi) ((zzhy) zzb2.zzy()));
                            }
                        }
                    }
                }
                arrayMap = arrayMap2;
            } else {
                arrayMap = zzg;
            }
            for (Integer num2 : hashSet) {
                int intValue2 = num2.intValue();
                zzcd.zzi zzi3 = arrayMap.get(Integer.valueOf(intValue2));
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                ArrayMap arrayMap3 = new ArrayMap();
                if (!(zzi3 == null || zzi3.zzf() == 0)) {
                    for (zzcd.zzb zzb3 : zzi3.zze()) {
                        if (zzb3.zza()) {
                            arrayMap3.put(Integer.valueOf(zzb3.zzb()), zzb3.zzc() ? Long.valueOf(zzb3.zzd()) : null);
                        }
                    }
                }
                ArrayMap arrayMap4 = new ArrayMap();
                if (!(zzi3 == null || zzi3.zzh() == 0)) {
                    for (zzcd.zzj zzj : zzi3.zzg()) {
                        if (zzj.zza() && zzj.zzd() > 0) {
                            arrayMap4.put(Integer.valueOf(zzj.zzb()), Long.valueOf(zzj.zza(zzj.zzd() - i)));
                        }
                    }
                }
                if (zzi3 != null) {
                    for (int i5 = 0; i5 < (zzi3.zzb() << 6); i5++) {
                        if (zzkr.zza(zzi3.zza(), i5)) {
                            zzq().zzw().zza("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue2), Integer.valueOf(i5));
                            bitSet2.set(i5);
                            if (zzkr.zza(zzi3.zzc(), i5)) {
                                bitSet.set(i5);
                                z2 = true;
                                if (z2) {
                                    arrayMap3.remove(Integer.valueOf(i5));
                                }
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                    }
                }
                zzcd.zzi zzi4 = zzg.get(Integer.valueOf(intValue2));
                if (!(!z4 || !z3 || (list3 = emptyMap.get(Integer.valueOf(intValue2))) == null || this.zzf == null || this.zze == null)) {
                    for (zzbv.zzb zzb4 : list3) {
                        int zzb5 = zzb4.zzb();
                        long longValue = this.zzf.longValue() / 1000;
                        if (zzb4.zzi()) {
                            longValue = this.zze.longValue() / 1000;
                        }
                        if (arrayMap3.containsKey(Integer.valueOf(zzb5))) {
                            arrayMap3.put(Integer.valueOf(zzb5), Long.valueOf(longValue));
                        }
                        if (arrayMap4.containsKey(Integer.valueOf(zzb5))) {
                            arrayMap4.put(Integer.valueOf(zzb5), Long.valueOf(longValue));
                        }
                    }
                }
                this.zzd.put(Integer.valueOf(intValue2), new zzt(this, this.zzb, zzi4, bitSet, bitSet2, arrayMap3, arrayMap4, null));
                arrayMap = arrayMap;
                i = 1;
            }
        }
        if (!list.isEmpty()) {
            zzs zzs2 = new zzs(this, null);
            ArrayMap arrayMap5 = new ArrayMap();
            for (zzcd.zzc zzc2 : list) {
                zzcd.zzc zza2 = zzs2.zza(this.zzb, zzc2);
                if (zza2 != null) {
                    zzaf zzi5 = zzi();
                    String str4 = this.zzb;
                    String zzc3 = zza2.zzc();
                    zzam zza3 = zzi5.zza(str4, zzc2.zzc());
                    if (zza3 == null) {
                        zzi5.zzq().zzh().zza("Event aggregate wasn't created during raw event logging. appId, event", zzeq.zza(str4), zzi5.zzn().zza(zzc3));
                        zzam = new zzam(str4, zzc2.zzc(), 1, 1, 1, zzc2.zze(), 0, null, null, null, null);
                    } else {
                        zzam = new zzam(zza3.zza, zza3.zzb, zza3.zzc + 1, zza3.zzd + 1, zza3.zze + 1, zza3.zzf, zza3.zzg, zza3.zzh, zza3.zzi, zza3.zzj, zza3.zzk);
                    }
                    zzi().zza(zzam);
                    long j = zzam.zzc;
                    String zzc4 = zza2.zzc();
                    Map<Integer, List<zzbv.zzb>> map = (Map) arrayMap5.get(zzc4);
                    if (map == null) {
                        map = zzi().zzf(this.zzb, zzc4);
                        if ((!zznd.zzb() || !zzs().zzd(this.zzb, zzas.zzce)) && map == null) {
                            map = new ArrayMap<>();
                        }
                        arrayMap5.put(zzc4, map);
                    }
                    for (Integer num3 : map.keySet()) {
                        int intValue3 = num3.intValue();
                        if (this.zzc.contains(Integer.valueOf(intValue3))) {
                            zzq().zzw().zza("Skipping failed audience ID", Integer.valueOf(intValue3));
                        } else {
                            Iterator<zzbv.zzb> it2 = map.get(Integer.valueOf(intValue3)).iterator();
                            boolean z5 = true;
                            while (true) {
                                if (!it2.hasNext()) {
                                    zzs = zzs2;
                                    i2 = intValue3;
                                    break;
                                }
                                zzbv.zzb next2 = it2.next();
                                zzv zzv = new zzv(this, this.zzb, intValue3, next2);
                                zzs = zzs2;
                                i2 = intValue3;
                                z5 = zzv.zza(this.zze, this.zzf, zza2, j, zzam, zza(intValue3, next2.zzb()));
                                if (!z5) {
                                    this.zzc.add(Integer.valueOf(i2));
                                    break;
                                }
                                zza(i2).zza(zzv);
                                intValue3 = i2;
                                zzs2 = zzs;
                            }
                            if (!z5) {
                                this.zzc.add(Integer.valueOf(i2));
                            }
                            zzs2 = zzs;
                        }
                    }
                }
            }
        }
        if (!list2.isEmpty()) {
            ArrayMap arrayMap6 = new ArrayMap();
            for (zzcd.zzk zzk : list2) {
                String zzc5 = zzk.zzc();
                Map<Integer, List<zzbv.zze>> map2 = (Map) arrayMap6.get(zzc5);
                if (map2 == null) {
                    map2 = zzi().zzg(this.zzb, zzc5);
                    if ((!zznd.zzb() || !zzs().zzd(this.zzb, zzas.zzce)) && map2 == null) {
                        map2 = new ArrayMap<>();
                    }
                    arrayMap6.put(zzc5, map2);
                }
                Iterator<Integer> it3 = map2.keySet().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    int intValue4 = it3.next().intValue();
                    if (this.zzc.contains(Integer.valueOf(intValue4))) {
                        zzq().zzw().zza("Skipping failed audience ID", Integer.valueOf(intValue4));
                        break;
                    }
                    Iterator<zzbv.zze> it4 = map2.get(Integer.valueOf(intValue4)).iterator();
                    boolean z6 = true;
                    while (true) {
                        if (!it4.hasNext()) {
                            break;
                        }
                        next = it4.next();
                        if (zzq().zza(2)) {
                            zzq().zzw().zza("Evaluating filter. audience, filter, property", Integer.valueOf(intValue4), next.zza() ? Integer.valueOf(next.zzb()) : null, zzn().zzc(next.zzc()));
                            zzq().zzw().zza("Filter definition", f_().zza(next));
                        }
                        if (next.zza() && next.zzb() <= 256) {
                            zzx zzx = new zzx(this, this.zzb, intValue4, next);
                            z6 = zzx.zza(this.zze, this.zzf, zzk, zza(intValue4, next.zzb()));
                            if (!z6) {
                                this.zzc.add(Integer.valueOf(intValue4));
                                break;
                            }
                            zza(intValue4).zza(zzx);
                        }
                    }
                    zzq().zzh().zza("Invalid property filter ID. appId, id", zzeq.zza(this.zzb), String.valueOf(next.zza() ? Integer.valueOf(next.zzb()) : null));
                    z6 = false;
                    if (!z6) {
                        this.zzc.add(Integer.valueOf(intValue4));
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Set<Integer> keySet = this.zzd.keySet();
        keySet.removeAll(this.zzc);
        for (Integer num4 : keySet) {
            int intValue5 = num4.intValue();
            zzcd.zza zza4 = this.zzd.get(Integer.valueOf(intValue5)).zza(intValue5);
            arrayList.add(zza4);
            zzaf zzi6 = zzi();
            String str5 = this.zzb;
            zzcd.zzi zzc6 = zza4.zzc();
            zzi6.zzaj();
            zzi6.zzc();
            Preconditions.checkNotEmpty(str5);
            Preconditions.checkNotNull(zzc6);
            byte[] zzbk = zzc6.zzbk();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str5);
            contentValues2.put("audience_id", Integer.valueOf(intValue5));
            contentValues2.put("current_results", zzbk);
            try {
                try {
                    if (zzi6.c_().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                        zzi6.zzq().zze().zza("Failed to insert filter results (got -1). appId", zzeq.zza(str5));
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    zzi6.zzq().zze().zza("Error storing filter results. appId", zzeq.zza(str5), e);
                }
            } catch (SQLiteException e4) {
                e = e4;
                zzi6.zzq().zze().zza("Error storing filter results. appId", zzeq.zza(str5), e);
            }
        }
        return arrayList;
    }

    private final zzt zza(int i) {
        if (this.zzd.containsKey(Integer.valueOf(i))) {
            return this.zzd.get(Integer.valueOf(i));
        }
        zzt zzt = new zzt(this, this.zzb, null);
        this.zzd.put(Integer.valueOf(i), zzt);
        return zzt;
    }

    private final boolean zza(int i, int i2) {
        if (this.zzd.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return zzt.zza(this.zzd.get(Integer.valueOf(i))).get(i2);
    }
}
