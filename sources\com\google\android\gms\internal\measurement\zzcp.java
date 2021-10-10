package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public class zzcp {
    public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Pattern zzb = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzc = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final Uri zzd = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static final AtomicBoolean zze = new AtomicBoolean();
    private static HashMap<String, String> zzf;
    private static final HashMap<String, Boolean> zzg = new HashMap<>();
    private static final HashMap<String, Integer> zzh = new HashMap<>();
    private static final HashMap<String, Long> zzi = new HashMap<>();
    private static final HashMap<String, Float> zzj = new HashMap<>();
    private static Object zzk;
    private static boolean zzl;
    private static String[] zzm = new String[0];

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ad, code lost:
        r10 = r10.query(com.google.android.gms.internal.measurement.zzcp.zza, null, null, new java.lang.String[]{r11}, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bb, code lost:
        if (r10 != null) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bd, code lost:
        if (r10 == null) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bf, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c2, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c7, code lost:
        if (r10.moveToFirst() != false) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c9, code lost:
        zza(r0, r11, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d1, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d2, code lost:
        r12 = r10.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d6, code lost:
        if (r12 == null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00dc, code lost:
        if (r12.equals(null) == false) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00de, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00df, code lost:
        zza(r0, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e2, code lost:
        if (r12 == null) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e4, code lost:
        r3 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e5, code lost:
        if (r10 == null) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e7, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ea, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00eb, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ec, code lost:
        if (r10 != null) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ee, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f1, code lost:
        throw r11;
     */
    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzcp.class) {
            String str3 = null;
            if (zzf == null) {
                zze.set(false);
                zzf = new HashMap<>();
                zzk = new Object();
                zzl = false;
                contentResolver.registerContentObserver(zza, true, new zzco(null));
            } else if (zze.getAndSet(false)) {
                zzf.clear();
                zzg.clear();
                zzh.clear();
                zzi.clear();
                zzj.clear();
                zzk = new Object();
                zzl = false;
            }
            Object obj = zzk;
            if (zzf.containsKey(str)) {
                String str4 = zzf.get(str);
                if (str4 != null) {
                    str3 = str4;
                }
                return str3;
            }
            for (String str5 : zzm) {
                if (str.startsWith(str5)) {
                    if (!zzl || zzf.isEmpty()) {
                        zzf.putAll(zza(contentResolver, zzm));
                        zzl = true;
                        if (zzf.containsKey(str)) {
                            String str6 = zzf.get(str);
                            if (str6 != null) {
                                str3 = str6;
                            }
                            return str3;
                        }
                    }
                    return null;
                }
            }
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzcp.class) {
            if (obj == zzk) {
                zzf.put(str, str2);
            }
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzd, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }
}
