package com.google.android.gms.internal.gtm;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import java.util.HashSet;
import java.util.Set;

public final class zzbq {
    private final zzap zzrb;
    private volatile Boolean zzyo;
    private String zzyp;
    private Set<Integer> zzyq;

    protected zzbq(zzap zzap) {
        Preconditions.checkNotNull(zzap);
        this.zzrb = zzap;
    }

    public final boolean zzem() {
        if (this.zzyo == null) {
            synchronized (this) {
                if (this.zzyo == null) {
                    ApplicationInfo applicationInfo = this.zzrb.getContext().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzyo = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if ((this.zzyo == null || !this.zzyo.booleanValue()) && "com.google.android.gms.analytics".equals(myProcessName)) {
                        this.zzyo = Boolean.TRUE;
                    }
                    if (this.zzyo == null) {
                        this.zzyo = Boolean.TRUE;
                        this.zzrb.zzco().zzu("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzyo.booleanValue();
    }

    public static boolean zzen() {
        return zzby.zzza.get().booleanValue();
    }

    public static int zzeo() {
        return zzby.zzzx.get().intValue();
    }

    public static long zzep() {
        return zzby.zzzi.get().longValue();
    }

    public static long zzeq() {
        return zzby.zzzl.get().longValue();
    }

    public static int zzer() {
        return zzby.zzzn.get().intValue();
    }

    public static int zzes() {
        return zzby.zzzo.get().intValue();
    }

    public static String zzet() {
        return zzby.zzzq.get();
    }

    public static String zzeu() {
        return zzby.zzzp.get();
    }

    public static String zzev() {
        return zzby.zzzr.get();
    }

    public final Set<Integer> zzew() {
        String str;
        String str2 = zzby.zzaaa.get();
        if (this.zzyq == null || (str = this.zzyp) == null || !str.equals(str2)) {
            String[] split = TextUtils.split(str2, ",");
            HashSet hashSet = new HashSet();
            for (String str3 : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str3)));
                } catch (NumberFormatException unused) {
                }
            }
            this.zzyp = str2;
            this.zzyq = hashSet;
        }
        return this.zzyq;
    }

    public static long zzex() {
        return zzby.zzaaf.get().longValue();
    }
}
