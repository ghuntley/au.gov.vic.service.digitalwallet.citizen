package com.google.android.gms.internal.instantapps;

import com.google.android.gms.internal.instantapps.zzcs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzcq<FieldDescriptorType extends zzcs<FieldDescriptorType>> {
    private static final zzcq zzamh = new zzcq(true);
    final zzez<FieldDescriptorType, Object> zzame = zzez.zzau(16);
    private boolean zzamf;
    private boolean zzamg = false;

    private zzcq() {
    }

    private zzcq(boolean z) {
        zzs();
    }

    public static <T extends zzcs<T>> zzcq<T> zzbl() {
        return zzamh;
    }

    public final void zzs() {
        if (!this.zzamf) {
            this.zzame.zzs();
            this.zzamf = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzamf;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcq)) {
            return false;
        }
        return this.zzame.equals(((zzcq) obj).zzame);
    }

    public final int hashCode() {
        return this.zzame.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzamg) {
            return new zzdl(this.zzame.entrySet().iterator());
        }
        return this.zzame.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzamg) {
            return new zzdl(this.zzame.zzdt().iterator());
        }
        return this.zzame.zzdt().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzame.get(fielddescriptortype);
        return obj instanceof zzdg ? zzdg.zzcn() : obj;
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzbp()) {
            zza(fielddescriptortype.zzbn(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zzbn(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzdg) {
            this.zzamg = true;
        }
        this.zzame.put(fielddescriptortype, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if ((r3 instanceof com.google.android.gms.internal.instantapps.zzdb) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.instantapps.zzdg) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        r0 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0047  */
    private static void zza(zzgd zzgd, Object obj) {
        zzcy.checkNotNull(obj);
        boolean z = true;
        boolean z2 = false;
        switch (zzcp.zzamd[zzgd.zzej().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                z2 = z;
                if (z2) {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                return;
            case 2:
                z = obj instanceof Long;
                z2 = z;
                if (z2) {
                }
                break;
            case 3:
                z = obj instanceof Float;
                z2 = z;
                if (z2) {
                }
                break;
            case 4:
                z = obj instanceof Double;
                z2 = z;
                if (z2) {
                }
                break;
            case 5:
                z = obj instanceof Boolean;
                z2 = z;
                if (z2) {
                }
                break;
            case 6:
                z = obj instanceof String;
                z2 = z;
                if (z2) {
                }
                break;
            case 7:
                if (!(obj instanceof zzbp)) {
                    break;
                }
                z2 = z;
                if (z2) {
                }
                break;
            case 8:
                if (!(obj instanceof Integer)) {
                    break;
                }
                z2 = z;
                if (z2) {
                }
                break;
            case 9:
                if (!(obj instanceof zzef)) {
                    break;
                }
                z2 = z;
                if (z2) {
                }
                break;
            default:
                if (z2) {
                }
                break;
        }
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzame.zzdr(); i++) {
            if (!zzb(this.zzame.zzav(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzame.zzds()) {
            if (!zzb(entry)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzb(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzbo() == zzgg.MESSAGE) {
            if (key.zzbp()) {
                for (zzef zzef : (List) entry.getValue()) {
                    if (!zzef.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzef) {
                    if (!((zzef) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzdg) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzcq<FieldDescriptorType> zzcq) {
        for (int i = 0; i < zzcq.zzame.zzdr(); i++) {
            zzc(zzcq.zzame.zzav(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : zzcq.zzame.zzds()) {
            zzc(entry);
        }
    }

    private static Object zzd(Object obj) {
        if (obj instanceof zzek) {
            return ((zzek) obj).zzde();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        zzef zzef;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzdg) {
            value = zzdg.zzcn();
        }
        if (key.zzbp()) {
            Object zza = zza(key);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza).add(zzd(obj));
            }
            this.zzame.put(key, zza);
        } else if (key.zzbo() == zzgg.MESSAGE) {
            Object zza2 = zza(key);
            if (zza2 == null) {
                this.zzame.put(key, zzd(value));
                return;
            }
            if (zza2 instanceof zzek) {
                zzef = key.zza((zzek) zza2, (zzek) value);
            } else {
                zzef = key.zza(((zzef) zza2).zzcb(), (zzef) value).zzbw();
            }
            this.zzame.put(key, zzef);
        } else {
            this.zzame.put(key, zzd(value));
        }
    }

    static void zza(zzce zzce, zzgd zzgd, int i, Object obj) throws IOException {
        if (zzgd == zzgd.GROUP) {
            zzef zzef = (zzef) obj;
            zzcy.zzf(zzef);
            zzce.zzb(i, 3);
            zzef.zzb(zzce);
            zzce.zzb(i, 4);
            return;
        }
        zzce.zzb(i, zzgd.zzek());
        switch (zzcp.zzals[zzgd.ordinal()]) {
            case 1:
                zzce.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzce.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzce.zzd(((Long) obj).longValue());
                return;
            case 4:
                zzce.zzd(((Long) obj).longValue());
                return;
            case 5:
                zzce.zzw(((Integer) obj).intValue());
                return;
            case 6:
                zzce.zzf(((Long) obj).longValue());
                return;
            case 7:
                zzce.zzz(((Integer) obj).intValue());
                return;
            case 8:
                zzce.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzef) obj).zzb(zzce);
                return;
            case 10:
                zzce.zzb((zzef) obj);
                return;
            case 11:
                if (obj instanceof zzbp) {
                    zzce.zza((zzbp) obj);
                    return;
                } else {
                    zzce.zzf((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzbp) {
                    zzce.zza((zzbp) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzce.zzd(bArr, 0, bArr.length);
                return;
            case 13:
                zzce.zzx(((Integer) obj).intValue());
                return;
            case 14:
                zzce.zzz(((Integer) obj).intValue());
                return;
            case 15:
                zzce.zzf(((Long) obj).longValue());
                return;
            case 16:
                zzce.zzy(((Integer) obj).intValue());
                return;
            case 17:
                zzce.zze(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzdb) {
                    zzce.zzw(((zzdb) obj).zzk());
                    return;
                } else {
                    zzce.zzw(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzbm() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzame.zzdr(); i2++) {
            i += zzd((Map.Entry) this.zzame.zzav(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzame.zzds()) {
            i += zzd((Map.Entry) entry);
        }
        return i;
    }

    private static int zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzbo() != zzgg.MESSAGE || key.zzbp() || key.zzbq()) {
            return zzb((zzcs<?>) key, value);
        }
        if (value instanceof zzdg) {
            return zzce.zzb(entry.getKey().zzk(), (zzdg) value);
        }
        return zzce.zzb(entry.getKey().zzk(), (zzef) value);
    }

    static int zza(zzgd zzgd, int i, Object obj) {
        int zzaa = zzce.zzaa(i);
        if (zzgd == zzgd.GROUP) {
            zzcy.zzf((zzef) obj);
            zzaa <<= 1;
        }
        return zzaa + zzb(zzgd, obj);
    }

    private static int zzb(zzgd zzgd, Object obj) {
        switch (zzcp.zzals[zzgd.ordinal()]) {
            case 1:
                return zzce.zzb(((Double) obj).doubleValue());
            case 2:
                return zzce.zzb(((Float) obj).floatValue());
            case 3:
                return zzce.zzg(((Long) obj).longValue());
            case 4:
                return zzce.zzh(((Long) obj).longValue());
            case 5:
                return zzce.zzab(((Integer) obj).intValue());
            case 6:
                return zzce.zzj(((Long) obj).longValue());
            case 7:
                return zzce.zzae(((Integer) obj).intValue());
            case 8:
                return zzce.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzce.zzd((zzef) obj);
            case 10:
                if (obj instanceof zzdg) {
                    return zzce.zza((zzdg) obj);
                }
                return zzce.zzc((zzef) obj);
            case 11:
                if (obj instanceof zzbp) {
                    return zzce.zzb((zzbp) obj);
                }
                return zzce.zzg((String) obj);
            case 12:
                if (obj instanceof zzbp) {
                    return zzce.zzb((zzbp) obj);
                }
                return zzce.zzc((byte[]) obj);
            case 13:
                return zzce.zzac(((Integer) obj).intValue());
            case 14:
                return zzce.zzaf(((Integer) obj).intValue());
            case 15:
                return zzce.zzk(((Long) obj).longValue());
            case 16:
                return zzce.zzad(((Integer) obj).intValue());
            case 17:
                return zzce.zzi(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzdb) {
                    return zzce.zzag(((zzdb) obj).zzk());
                }
                return zzce.zzag(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzcs<?> zzcs, Object obj) {
        zzgd zzbn = zzcs.zzbn();
        int zzk = zzcs.zzk();
        if (!zzcs.zzbp()) {
            return zza(zzbn, zzk, obj);
        }
        int i = 0;
        if (zzcs.zzbq()) {
            for (Object obj2 : (List) obj) {
                i += zzb(zzbn, obj2);
            }
            return zzce.zzaa(zzk) + i + zzce.zzai(i);
        }
        for (Object obj3 : (List) obj) {
            i += zza(zzbn, zzk, obj3);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzcq zzcq = new zzcq();
        for (int i = 0; i < this.zzame.zzdr(); i++) {
            Map.Entry<FieldDescriptorType, Object> zzav = this.zzame.zzav(i);
            zzcq.zza(zzav.getKey(), zzav.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzame.zzds()) {
            zzcq.zza(entry.getKey(), entry.getValue());
        }
        zzcq.zzamg = this.zzamg;
        return zzcq;
    }
}
