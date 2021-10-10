package com.google.android.gms.internal.instantapps;

import com.google.android.gms.internal.instantapps.zzcx;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzch implements zzgi {
    private final zzce zzalb;

    public static zzch zza(zzce zzce) {
        if (zzce.zzalr != null) {
            return zzce.zzalr;
        }
        return new zzch(zzce);
    }

    private zzch(zzce zzce) {
        zzce zzce2 = (zzce) zzcy.zza((Object) zzce, "output");
        this.zzalb = zzce2;
        zzce2.zzalr = this;
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final int zzbd() {
        return zzcx.zzd.zzapr;
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzm(int i, int i2) throws IOException {
        this.zzalb.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzi(int i, long j) throws IOException {
        this.zzalb.zza(i, j);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzj(int i, long j) throws IOException {
        this.zzalb.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zza(int i, float f) throws IOException {
        this.zzalb.zza(i, f);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zza(int i, double d) throws IOException {
        this.zzalb.zza(i, d);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzn(int i, int i2) throws IOException {
        this.zzalb.zzc(i, i2);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zza(int i, long j) throws IOException {
        this.zzalb.zza(i, j);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzc(int i, int i2) throws IOException {
        this.zzalb.zzc(i, i2);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzc(int i, long j) throws IOException {
        this.zzalb.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzf(int i, int i2) throws IOException {
        this.zzalb.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzb(int i, boolean z) throws IOException {
        this.zzalb.zzb(i, z);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zza(int i, String str) throws IOException {
        this.zzalb.zza(i, str);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zza(int i, zzbp zzbp) throws IOException {
        this.zzalb.zza(i, zzbp);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzd(int i, int i2) throws IOException {
        this.zzalb.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zze(int i, int i2) throws IOException {
        this.zzalb.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzb(int i, long j) throws IOException {
        this.zzalb.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zza(int i, Object obj, zzeu zzeu) throws IOException {
        this.zzalb.zza(i, (zzef) obj, zzeu);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzb(int i, Object obj, zzeu zzeu) throws IOException {
        zzce zzce = this.zzalb;
        zzce.zzb(i, 3);
        zzeu.zza((zzef) obj, zzce.zzalr);
        zzce.zzb(i, 4);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzaj(int i) throws IOException {
        this.zzalb.zzb(i, 3);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzak(int i) throws IOException {
        this.zzalb.zzb(i, 4);
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzbp) {
            this.zzalb.zzb(i, (zzbp) obj);
        } else {
            this.zzalb.zza(i, (zzef) obj);
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzalb.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzce.zzab(list.get(i4).intValue());
            }
            this.zzalb.zzx(i3);
            while (i2 < list.size()) {
                this.zzalb.zzw(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzalb.zzc(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzalb.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzce.zzae(list.get(i4).intValue());
            }
            this.zzalb.zzx(i3);
            while (i2 < list.size()) {
                this.zzalb.zzz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzalb.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzalb.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzce.zzg(list.get(i4).longValue());
            }
            this.zzalb.zzx(i3);
            while (i2 < list.size()) {
                this.zzalb.zzd(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzalb.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzalb.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzce.zzh(list.get(i4).longValue());
            }
            this.zzalb.zzx(i3);
            while (i2 < list.size()) {
                this.zzalb.zzd(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzalb.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzalb.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzce.zzj(list.get(i4).longValue());
            }
            this.zzalb.zzx(i3);
            while (i2 < list.size()) {
                this.zzalb.zzf(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzalb.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzalb.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzce.zzb(list.get(i4).floatValue());
            }
            this.zzalb.zzx(i3);
            while (i2 < list.size()) {
                this.zzalb.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzalb.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzalb.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzce.zzb(list.get(i4).doubleValue());
            }
            this.zzalb.zzx(i3);
            while (i2 < list.size()) {
                this.zzalb.zza(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzalb.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzalb.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzce.zzag(list.get(i4).intValue());
            }
            this.zzalb.zzx(i3);
            while (i2 < list.size()) {
                this.zzalb.zzw(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzalb.zzc(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzalb.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzce.zzb(list.get(i4).booleanValue());
            }
            this.zzalb.zzx(i3);
            while (i2 < list.size()) {
                this.zzalb.zza(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzalb.zzb(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzdm) {
            zzdm zzdm = (zzdm) list;
            while (i2 < list.size()) {
                Object zzam = zzdm.zzam(i2);
                if (zzam instanceof String) {
                    this.zzalb.zza(i, (String) zzam);
                } else {
                    this.zzalb.zza(i, (zzbp) zzam);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzalb.zza(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzb(int i, List<zzbp> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzalb.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzalb.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzce.zzac(list.get(i4).intValue());
            }
            this.zzalb.zzx(i3);
            while (i2 < list.size()) {
                this.zzalb.zzx(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzalb.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzalb.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzce.zzaf(list.get(i4).intValue());
            }
            this.zzalb.zzx(i3);
            while (i2 < list.size()) {
                this.zzalb.zzz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzalb.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzalb.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzce.zzk(list.get(i4).longValue());
            }
            this.zzalb.zzx(i3);
            while (i2 < list.size()) {
                this.zzalb.zzf(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzalb.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzalb.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzce.zzad(list.get(i4).intValue());
            }
            this.zzalb.zzx(i3);
            while (i2 < list.size()) {
                this.zzalb.zzy(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzalb.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzalb.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzce.zzi(list.get(i4).longValue());
            }
            this.zzalb.zzx(i3);
            while (i2 < list.size()) {
                this.zzalb.zze(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzalb.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zza(int i, List<?> list, zzeu zzeu) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzeu);
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final void zzb(int i, List<?> list, zzeu zzeu) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzeu);
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzgi
    public final <K, V> void zza(int i, zzdw<K, V> zzdw, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zzalb.zzb(i, 2);
            this.zzalb.zzx(zzdx.zza(zzdw, entry.getKey(), entry.getValue()));
            zzdx.zza(this.zzalb, zzdw, entry.getKey(), entry.getValue());
        }
    }
}
