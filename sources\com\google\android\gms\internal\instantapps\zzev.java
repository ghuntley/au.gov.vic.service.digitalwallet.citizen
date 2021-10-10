package com.google.android.gms.internal.instantapps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public interface zzev {
    int getTag();

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> list) throws IOException;

    <T> T zza(zzeu<T> zzeu, zzck zzck) throws IOException;

    void zza(List<Double> list) throws IOException;

    <T> void zza(List<T> list, zzeu<T> zzeu, zzck zzck) throws IOException;

    <K, V> void zza(Map<K, V> map, zzdw<K, V> zzdw, zzck zzck) throws IOException;

    long zzab() throws IOException;

    long zzac() throws IOException;

    int zzad() throws IOException;

    long zzae() throws IOException;

    int zzaf() throws IOException;

    boolean zzag() throws IOException;

    String zzah() throws IOException;

    zzbp zzai() throws IOException;

    int zzaj() throws IOException;

    int zzak() throws IOException;

    int zzal() throws IOException;

    long zzam() throws IOException;

    int zzan() throws IOException;

    long zzao() throws IOException;

    int zzas() throws IOException;

    boolean zzat() throws IOException;

    @Deprecated
    <T> T zzb(zzeu<T> zzeu, zzck zzck) throws IOException;

    void zzb(List<Float> list) throws IOException;

    @Deprecated
    <T> void zzb(List<T> list, zzeu<T> zzeu, zzck zzck) throws IOException;

    void zzc(List<Long> list) throws IOException;

    void zzd(List<Long> list) throws IOException;

    void zze(List<Integer> list) throws IOException;

    void zzf(List<Long> list) throws IOException;

    void zzg(List<Integer> list) throws IOException;

    void zzh(List<Boolean> list) throws IOException;

    void zzi(List<String> list) throws IOException;

    void zzj(List<zzbp> list) throws IOException;

    void zzk(List<Integer> list) throws IOException;

    void zzl(List<Integer> list) throws IOException;

    void zzm(List<Integer> list) throws IOException;

    void zzn(List<Long> list) throws IOException;

    void zzo(List<Integer> list) throws IOException;

    void zzp(List<Long> list) throws IOException;
}
