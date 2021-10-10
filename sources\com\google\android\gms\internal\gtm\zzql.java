package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzql implements zzum {
    private final zzqj zzawd;

    public static zzql zza(zzqj zzqj) {
        if (zzqj.zzawu != null) {
            return zzqj.zzawu;
        }
        return new zzql(zzqj);
    }

    private zzql(zzqj zzqj) {
        zzqj zzqj2 = (zzqj) zzre.zza(zzqj, "output");
        this.zzawd = zzqj2;
        zzqj2.zzawu = this;
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final int zzol() {
        return zzrc.zze.zzbbc;
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzo(int i, int i2) throws IOException {
        this.zzawd.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzi(int i, long j) throws IOException {
        this.zzawd.zza(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzj(int i, long j) throws IOException {
        this.zzawd.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zza(int i, float f) throws IOException {
        this.zzawd.zza(i, f);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zza(int i, double d) throws IOException {
        this.zzawd.zza(i, d);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzp(int i, int i2) throws IOException {
        this.zzawd.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zza(int i, long j) throws IOException {
        this.zzawd.zza(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zze(int i, int i2) throws IOException {
        this.zzawd.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzc(int i, long j) throws IOException {
        this.zzawd.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzh(int i, int i2) throws IOException {
        this.zzawd.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzb(int i, boolean z) throws IOException {
        this.zzawd.zzb(i, z);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zza(int i, String str) throws IOException {
        this.zzawd.zza(i, str);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zza(int i, zzps zzps) throws IOException {
        this.zzawd.zza(i, zzps);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzf(int i, int i2) throws IOException {
        this.zzawd.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzg(int i, int i2) throws IOException {
        this.zzawd.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzb(int i, long j) throws IOException {
        this.zzawd.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zza(int i, Object obj, zzsz zzsz) throws IOException {
        this.zzawd.zza(i, (zzsk) obj, zzsz);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzb(int i, Object obj, zzsz zzsz) throws IOException {
        zzqj zzqj = this.zzawd;
        zzqj.zzd(i, 3);
        zzsz.zza((zzsk) obj, zzqj.zzawu);
        zzqj.zzd(i, 4);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzbk(int i) throws IOException {
        this.zzawd.zzd(i, 3);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzbl(int i) throws IOException {
        this.zzawd.zzd(i, 4);
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzps) {
            this.zzawd.zzb(i, (zzps) obj);
        } else {
            this.zzawd.zzb(i, (zzsk) obj);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzawd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbc(list.get(i4).intValue());
            }
            this.zzawd.zzay(i3);
            while (i2 < list.size()) {
                this.zzawd.zzax(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzawd.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzawd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbf(list.get(i4).intValue());
            }
            this.zzawd.zzay(i3);
            while (i2 < list.size()) {
                this.zzawd.zzba(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzawd.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzawd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzs(list.get(i4).longValue());
            }
            this.zzawd.zzay(i3);
            while (i2 < list.size()) {
                this.zzawd.zzp(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzawd.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzawd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzt(list.get(i4).longValue());
            }
            this.zzawd.zzay(i3);
            while (i2 < list.size()) {
                this.zzawd.zzp(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzawd.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzawd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzv(list.get(i4).longValue());
            }
            this.zzawd.zzay(i3);
            while (i2 < list.size()) {
                this.zzawd.zzr(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzawd.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzawd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzb(list.get(i4).floatValue());
            }
            this.zzawd.zzay(i3);
            while (i2 < list.size()) {
                this.zzawd.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzawd.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzawd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzc(list.get(i4).doubleValue());
            }
            this.zzawd.zzay(i3);
            while (i2 < list.size()) {
                this.zzawd.zzb(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzawd.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzawd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbh(list.get(i4).intValue());
            }
            this.zzawd.zzay(i3);
            while (i2 < list.size()) {
                this.zzawd.zzax(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzawd.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzawd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzj(list.get(i4).booleanValue());
            }
            this.zzawd.zzay(i3);
            while (i2 < list.size()) {
                this.zzawd.zzi(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzawd.zzb(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzrt) {
            zzrt zzrt = (zzrt) list;
            while (i2 < list.size()) {
                Object zzbn = zzrt.zzbn(i2);
                if (zzbn instanceof String) {
                    this.zzawd.zza(i, (String) zzbn);
                } else {
                    this.zzawd.zza(i, (zzps) zzbn);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzawd.zza(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzb(int i, List<zzps> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzawd.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzawd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbd(list.get(i4).intValue());
            }
            this.zzawd.zzay(i3);
            while (i2 < list.size()) {
                this.zzawd.zzay(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzawd.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzawd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbg(list.get(i4).intValue());
            }
            this.zzawd.zzay(i3);
            while (i2 < list.size()) {
                this.zzawd.zzba(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzawd.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzawd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzw(list.get(i4).longValue());
            }
            this.zzawd.zzay(i3);
            while (i2 < list.size()) {
                this.zzawd.zzr(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzawd.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzawd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbe(list.get(i4).intValue());
            }
            this.zzawd.zzay(i3);
            while (i2 < list.size()) {
                this.zzawd.zzaz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzawd.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzawd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzu(list.get(i4).longValue());
            }
            this.zzawd.zzay(i3);
            while (i2 < list.size()) {
                this.zzawd.zzq(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzawd.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zza(int i, List<?> list, zzsz zzsz) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzsz);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final void zzb(int i, List<?> list, zzsz zzsz) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzsz);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzum
    public final <K, V> void zza(int i, zzsd<K, V> zzsd, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zzawd.zzd(i, 2);
            this.zzawd.zzay(zzsc.zza(zzsd, entry.getKey(), entry.getValue()));
            zzsc.zza(this.zzawd, zzsd, entry.getKey(), entry.getValue());
        }
    }
}
