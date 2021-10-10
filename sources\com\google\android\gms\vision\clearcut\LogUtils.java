package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.vision.zzfi;
import com.google.android.gms.internal.vision.zzjb;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.vision.L;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public class LogUtils {
    public static zzfi.zzo zza(long j, int i, String str, String str2, List<zzfi.zzn> list, zzs zzs) {
        zzfi.zzi.zza zza = zzfi.zzi.zza();
        zzfi.zzf.zzb zzb = zzfi.zzf.zza().zza(str2).zza(j).zzb((long) i);
        zzb.zza(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add((zzfi.zzf) ((zzjb) zzb.zzf()));
        return (zzfi.zzo) ((zzjb) zzfi.zzo.zza().zza((zzfi.zzi) ((zzjb) zza.zza(arrayList).zza((zzfi.zzj) ((zzjb) zzfi.zzj.zza().zzb((long) zzs.zzb).zza((long) zzs.zza).zzc((long) zzs.zzc).zzd(zzs.zzd).zzf())).zzf())).zzf());
    }

    public static zzfi.zza zza(Context context) {
        zzfi.zza.C0014zza zza = zzfi.zza.zza().zza(context.getPackageName());
        String zzb = zzb(context);
        if (zzb != null) {
            zza.zzb(zzb);
        }
        return (zzfi.zza) ((zzjb) zza.zzf());
    }

    private static String zzb(Context context) {
        try {
            return Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            L.e(e, "Unable to find calling package info for %s", context.getPackageName());
            return null;
        }
    }
}
