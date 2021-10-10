package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzmx;
import java.util.HashSet;
import java.util.Iterator;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzv extends zzu {
    private zzbv.zzb zzg;
    private final /* synthetic */ zzr zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzv(zzr zzr, String str, int i, zzbv.zzb zzb) {
        super(str, i);
        this.zzh = zzr;
        this.zzg = zzb;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzu
    public final boolean zzb() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzu
    public final int zza() {
        return this.zzg.zzb();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzu
    public final boolean zzc() {
        return this.zzg.zzf();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010f, code lost:
        if (r6.booleanValue() == false) goto L_0x03a3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x03af  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03ba A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x03bb  */
    public final boolean zza(Long l, Long l2, zzcd.zzc zzc, long j, zzam zzam, boolean z) {
        Boolean bool;
        Boolean bool2 = false;
        boolean z2 = zzmx.zzb() && this.zzh.zzs().zzd(this.zza, zzas.zzbb);
        long j2 = this.zzg.zzk() ? zzam.zze : j;
        Integer num = null;
        if (this.zzh.zzq().zza(2)) {
            this.zzh.zzq().zzw().zza("Evaluating filter. audience, filter, event", Integer.valueOf(this.zzb), this.zzg.zza() ? Integer.valueOf(this.zzg.zzb()) : null, this.zzh.zzn().zza(this.zzg.zzc()));
            this.zzh.zzq().zzw().zza("Filter definition", this.zzh.f_().zza(this.zzg));
        }
        if (!this.zzg.zza() || this.zzg.zzb() > 256) {
            zzes zzh2 = this.zzh.zzq().zzh();
            Object zza = zzeq.zza(this.zza);
            if (this.zzg.zza()) {
                num = Integer.valueOf(this.zzg.zzb());
            }
            zzh2.zza("Invalid event filter ID. appId, id", zza, String.valueOf(num));
            return false;
        }
        boolean z3 = this.zzg.zzh() || this.zzg.zzi() || this.zzg.zzk();
        if (!z || z3) {
            zzbv.zzb zzb = this.zzg;
            String zzc2 = zzc.zzc();
            if (zzb.zzf()) {
                Boolean zza2 = zza(j2, zzb.zzg());
                if (zza2 != null) {
                }
                bool2 = null;
                this.zzh.zzq().zzw().zza("Event filter result", bool2 != null ? "null" : bool2);
                if (bool2 != null) {
                    return false;
                }
                this.zzc = true;
                if (!bool2.booleanValue()) {
                    return true;
                }
                this.zzd = true;
                if (z3 && zzc.zzd()) {
                    Long valueOf = Long.valueOf(zzc.zze());
                    if (this.zzg.zzi()) {
                        if (z2 && this.zzg.zzf()) {
                            valueOf = l;
                        }
                        this.zzf = valueOf;
                    } else {
                        if (z2 && this.zzg.zzf()) {
                            valueOf = l2;
                        }
                        this.zze = valueOf;
                    }
                }
                return true;
            }
            HashSet hashSet = new HashSet();
            Iterator<zzbv.zzc> it = zzb.zzd().iterator();
            while (true) {
                if (!it.hasNext()) {
                    ArrayMap arrayMap = new ArrayMap();
                    Iterator<zzcd.zze> it2 = zzc.zza().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            Iterator<zzbv.zzc> it3 = zzb.zzd().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    bool2 = true;
                                    break;
                                }
                                zzbv.zzc next = it3.next();
                                boolean z4 = next.zze() && next.zzf();
                                String zzh3 = next.zzh();
                                if (zzh3.isEmpty()) {
                                    this.zzh.zzq().zzh().zza("Event has empty param name. event", this.zzh.zzn().zza(zzc2));
                                    break;
                                }
                                Object obj = arrayMap.get(zzh3);
                                if (obj instanceof Long) {
                                    if (!next.zzc()) {
                                        this.zzh.zzq().zzh().zza("No number filter for long param. event, param", this.zzh.zzn().zza(zzc2), this.zzh.zzn().zzb(zzh3));
                                        break;
                                    }
                                    Boolean zza3 = zza(((Long) obj).longValue(), next.zzd());
                                    if (zza3 == null) {
                                        break;
                                    } else if (zza3.booleanValue() == z4) {
                                        break;
                                    }
                                } else if (obj instanceof Double) {
                                    if (!next.zzc()) {
                                        this.zzh.zzq().zzh().zza("No number filter for double param. event, param", this.zzh.zzn().zza(zzc2), this.zzh.zzn().zzb(zzh3));
                                        break;
                                    }
                                    Boolean zza4 = zza(((Double) obj).doubleValue(), next.zzd());
                                    if (zza4 == null) {
                                        break;
                                    } else if (zza4.booleanValue() == z4) {
                                        break;
                                    }
                                } else if (obj instanceof String) {
                                    if (!next.zza()) {
                                        if (!next.zzc()) {
                                            this.zzh.zzq().zzh().zza("No filter for String param. event, param", this.zzh.zzn().zza(zzc2), this.zzh.zzn().zzb(zzh3));
                                            break;
                                        }
                                        String str = (String) obj;
                                        if (!zzkr.zza(str)) {
                                            this.zzh.zzq().zzh().zza("Invalid param value for number filter. event, param", this.zzh.zzn().zza(zzc2), this.zzh.zzn().zzb(zzh3));
                                            break;
                                        }
                                        bool = zza(str, next.zzd());
                                    } else {
                                        bool = zza((String) obj, next.zzb(), this.zzh.zzq());
                                    }
                                    if (bool == null) {
                                        break;
                                    } else if (bool.booleanValue() == z4) {
                                        break;
                                    }
                                } else if (obj == null) {
                                    this.zzh.zzq().zzw().zza("Missing param for filter. event, param", this.zzh.zzn().zza(zzc2), this.zzh.zzn().zzb(zzh3));
                                } else {
                                    this.zzh.zzq().zzh().zza("Unknown param type. event, param", this.zzh.zzn().zza(zzc2), this.zzh.zzn().zzb(zzh3));
                                }
                            }
                        } else {
                            zzcd.zze next2 = it2.next();
                            if (hashSet.contains(next2.zzb())) {
                                if (!next2.zze()) {
                                    if (!next2.zzi()) {
                                        if (!next2.zzc()) {
                                            this.zzh.zzq().zzh().zza("Unknown value for param. event, param", this.zzh.zzn().zza(zzc2), this.zzh.zzn().zzb(next2.zzb()));
                                            break;
                                        }
                                        arrayMap.put(next2.zzb(), next2.zzd());
                                    } else {
                                        arrayMap.put(next2.zzb(), next2.zzi() ? Double.valueOf(next2.zzj()) : null);
                                    }
                                } else {
                                    arrayMap.put(next2.zzb(), next2.zze() ? Long.valueOf(next2.zzf()) : null);
                                }
                            }
                        }
                    }
                } else {
                    zzbv.zzc next3 = it.next();
                    if (next3.zzh().isEmpty()) {
                        this.zzh.zzq().zzh().zza("null or empty param name in filter. event", this.zzh.zzn().zza(zzc2));
                        break;
                    }
                    hashSet.add(next3.zzh());
                }
            }
            this.zzh.zzq().zzw().zza("Event filter result", bool2 != null ? "null" : bool2);
            if (bool2 != null) {
            }
        } else {
            zzes zzw = this.zzh.zzq().zzw();
            Integer valueOf2 = Integer.valueOf(this.zzb);
            if (this.zzg.zza()) {
                num = Integer.valueOf(this.zzg.zzb());
            }
            zzw.zza("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", valueOf2, num);
            return true;
        }
    }
}
