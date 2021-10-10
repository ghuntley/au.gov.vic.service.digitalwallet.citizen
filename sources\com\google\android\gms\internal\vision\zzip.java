package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzip extends zziq<zzjb.zzf> {
    zzip() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zziq
    public final boolean zza(zzkk zzkk) {
        return zzkk instanceof zzjb.zzc;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zziq
    public final zziu<zzjb.zzf> zza(Object obj) {
        return ((zzjb.zzc) obj).zzc;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zziq
    public final zziu<zzjb.zzf> zzb(Object obj) {
        return ((zzjb.zzc) obj).zza();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zziq
    public final void zzc(Object obj) {
        zza(obj).zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.android.gms.internal.vision.zzjh] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f8, code lost:
        if (r5 != 18) goto L_0x0107;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.vision.zziq
    public final <UT, UB> UB zza(zzld zzld, Object obj, zzio zzio, zziu<zzjb.zzf> zziu, UB ub, zzlu<UT, UB> zzlu) throws IOException {
        Object obj2;
        zzjb.zze zze = (zzjb.zze) obj;
        int i = zze.zzd.zzb;
        boolean z = zze.zzd.zzd;
        ?? r3 = 0;
        if (zze.zzd.zzc != zzml.ENUM) {
            switch (zzis.zza[zze.zzd.zzc.ordinal()]) {
                case 1:
                    r3 = Double.valueOf(zzld.zzd());
                    break;
                case 2:
                    r3 = Float.valueOf(zzld.zze());
                    break;
                case 3:
                    r3 = Long.valueOf(zzld.zzg());
                    break;
                case 4:
                    r3 = Long.valueOf(zzld.zzf());
                    break;
                case 5:
                    r3 = Integer.valueOf(zzld.zzh());
                    break;
                case 6:
                    r3 = Long.valueOf(zzld.zzi());
                    break;
                case 7:
                    r3 = Integer.valueOf(zzld.zzj());
                    break;
                case 8:
                    r3 = Boolean.valueOf(zzld.zzk());
                    break;
                case 9:
                    r3 = Integer.valueOf(zzld.zzo());
                    break;
                case 10:
                    r3 = Integer.valueOf(zzld.zzq());
                    break;
                case 11:
                    r3 = Long.valueOf(zzld.zzr());
                    break;
                case 12:
                    r3 = Integer.valueOf(zzld.zzs());
                    break;
                case 13:
                    r3 = Long.valueOf(zzld.zzt());
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    r3 = zzld.zzn();
                    break;
                case 16:
                    r3 = zzld.zzl();
                    break;
                case 17:
                    r3 = zzld.zzb(zze.zzc.getClass(), zzio);
                    break;
                case 18:
                    r3 = zzld.zza(zze.zzc.getClass(), zzio);
                    break;
            }
        } else {
            int zzh = zzld.zzh();
            if (r3.zza(zzh) == null) {
                return (UB) zzle.zza(i, zzh, ub, zzlu);
            }
            r3 = Integer.valueOf(zzh);
        }
        if (zze.zzd.zzd) {
            zziu.zzb(zze.zzd, r3);
        } else {
            int i2 = zzis.zza[zze.zzd.zzc.ordinal()];
            if (i2 != 17) {
                obj2 = r3;
            }
            Object zza = zziu.zza(zze.zzd);
            obj2 = r3;
            if (zza != null) {
                obj2 = zzjf.zza(zza, (Object) r3);
            }
            zziu.zza(zze.zzd, obj2);
        }
        return ub;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zziq
    public final int zza(Map.Entry<?, ?> entry) {
        return ((zzjb.zzf) entry.getKey()).zzb;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zziq
    public final void zza(zzmr zzmr, Map.Entry<?, ?> entry) throws IOException {
        zzjb.zzf zzf = (zzjb.zzf) entry.getKey();
        if (zzf.zzd) {
            switch (zzis.zza[zzf.zzc.ordinal()]) {
                case 1:
                    zzle.zza(zzf.zzb, (List<Double>) ((List) entry.getValue()), zzmr, false);
                    return;
                case 2:
                    zzle.zzb(zzf.zzb, (List<Float>) ((List) entry.getValue()), zzmr, false);
                    return;
                case 3:
                    zzle.zzc(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 4:
                    zzle.zzd(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 5:
                    zzle.zzh(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 6:
                    zzle.zzf(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 7:
                    zzle.zzk(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 8:
                    zzle.zzn(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 9:
                    zzle.zzi(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 10:
                    zzle.zzl(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 11:
                    zzle.zzg(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 12:
                    zzle.zzj(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 13:
                    zzle.zze(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 14:
                    zzle.zzh(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 15:
                    zzle.zzb(zzf.zzb, (List) entry.getValue(), zzmr);
                    return;
                case 16:
                    zzle.zza(zzf.zzb, (List) entry.getValue(), zzmr);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        zzle.zzb(zzf.zzb, (List) entry.getValue(), zzmr, zzky.zza().zza((Class) list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        zzle.zza(zzf.zzb, (List) entry.getValue(), zzmr, zzky.zza().zza((Class) list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (zzis.zza[zzf.zzc.ordinal()]) {
                case 1:
                    zzmr.zza(zzf.zzb, ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    zzmr.zza(zzf.zzb, ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    zzmr.zza(zzf.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    zzmr.zzc(zzf.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    zzmr.zzc(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    zzmr.zzd(zzf.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    zzmr.zzd(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    zzmr.zza(zzf.zzb, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    zzmr.zze(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    zzmr.zza(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    zzmr.zzb(zzf.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    zzmr.zzf(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    zzmr.zze(zzf.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    zzmr.zzc(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    zzmr.zza(zzf.zzb, (zzht) entry.getValue());
                    return;
                case 16:
                    zzmr.zza(zzf.zzb, (String) entry.getValue());
                    return;
                case 17:
                    zzmr.zzb(zzf.zzb, entry.getValue(), zzky.zza().zza((Class) entry.getValue().getClass()));
                    return;
                case 18:
                    zzmr.zza(zzf.zzb, entry.getValue(), zzky.zza().zza((Class) entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zziq
    public final Object zza(zzio zzio, zzkk zzkk, int i) {
        return zzio.zza(zzkk, i);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zziq
    public final void zza(zzld zzld, Object obj, zzio zzio, zziu<zzjb.zzf> zziu) throws IOException {
        zzjb.zze zze = (zzjb.zze) obj;
        zziu.zza(zze.zzd, zzld.zza(zze.zzc.getClass(), zzio));
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zziq
    public final void zza(zzht zzht, Object obj, zzio zzio, zziu<zzjb.zzf> zziu) throws IOException {
        byte[] bArr;
        zzjb.zze zze = (zzjb.zze) obj;
        zzkk zze2 = zze.zzc.zzq().zze();
        int zza = zzht.zza();
        if (zza == 0) {
            bArr = zzjf.zzb;
        } else {
            byte[] bArr2 = new byte[zza];
            zzht.zza(bArr2, 0, 0, zza);
            bArr = bArr2;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.hasArray()) {
            zzho zzho = new zzho(wrap, true);
            zzky.zza().zza(zze2).zza(zze2, zzho, zzio);
            zziu.zza(zze.zzd, zze2);
            if (zzho.zza() != Integer.MAX_VALUE) {
                throw zzjk.zze();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
