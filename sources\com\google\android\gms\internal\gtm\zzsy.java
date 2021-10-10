package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public interface zzsy {
    int getTag();

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> list) throws IOException;

    <T> T zza(zzsz<T> zzsz, zzqp zzqp) throws IOException;

    <T> void zza(List<T> list, zzsz<T> zzsz, zzqp zzqp) throws IOException;

    <K, V> void zza(Map<K, V> map, zzsd<K, V> zzsd, zzqp zzqp) throws IOException;

    @Deprecated
    <T> T zzb(zzsz<T> zzsz, zzqp zzqp) throws IOException;

    @Deprecated
    <T> void zzb(List<T> list, zzsz<T> zzsz, zzqp zzqp) throws IOException;

    void zzg(List<Double> list) throws IOException;

    void zzh(List<Float> list) throws IOException;

    void zzi(List<Long> list) throws IOException;

    void zzj(List<Long> list) throws IOException;

    void zzk(List<Integer> list) throws IOException;

    void zzl(List<Long> list) throws IOException;

    void zzm(List<Integer> list) throws IOException;

    void zzn(List<Boolean> list) throws IOException;

    long zznj() throws IOException;

    long zznk() throws IOException;

    int zznl() throws IOException;

    long zznm() throws IOException;

    int zznn() throws IOException;

    boolean zzno() throws IOException;

    String zznp() throws IOException;

    zzps zznq() throws IOException;

    int zznr() throws IOException;

    int zzns() throws IOException;

    int zznt() throws IOException;

    long zznu() throws IOException;

    int zznv() throws IOException;

    long zznw() throws IOException;

    void zzo(List<String> list) throws IOException;

    int zzog() throws IOException;

    boolean zzoh() throws IOException;

    void zzp(List<zzps> list) throws IOException;

    void zzq(List<Integer> list) throws IOException;

    void zzr(List<Integer> list) throws IOException;

    void zzs(List<Integer> list) throws IOException;

    void zzt(List<Long> list) throws IOException;

    void zzu(List<Integer> list) throws IOException;

    void zzv(List<Long> list) throws IOException;
}
