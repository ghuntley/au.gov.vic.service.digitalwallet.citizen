package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.Locale;

public final class zzda extends zzan {
    private String zzaau;
    private String zzaav;
    protected int zzaax;
    private int zzacu;
    protected boolean zzacv;
    private boolean zzacw;
    private boolean zzacx;

    public zzda(zzap zzap) {
        super(zzap);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzan
    public final void zzaw() {
        ApplicationInfo applicationInfo;
        int i;
        zzcc zzcc;
        int i2;
        Context context = getContext();
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            zzd("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            zzt("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && (i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) > 0 && (zzcc = (zzcc) new zzca(zzcm()).zzq(i)) != null) {
            zzq("Loading global XML config values");
            boolean z = false;
            if (zzcc.zzaau != null) {
                String str = zzcc.zzaau;
                this.zzaau = str;
                zzb("XML config - app name", str);
            }
            if (zzcc.zzaav != null) {
                String str2 = zzcc.zzaav;
                this.zzaav = str2;
                zzb("XML config - app version", str2);
            }
            if (zzcc.zzaaw != null) {
                String lowerCase = zzcc.zzaaw.toLowerCase(Locale.US);
                if ("verbose".equals(lowerCase)) {
                    i2 = 0;
                } else if ("info".equals(lowerCase)) {
                    i2 = 1;
                } else if ("warning".equals(lowerCase)) {
                    i2 = 2;
                } else {
                    i2 = "error".equals(lowerCase) ? 3 : -1;
                }
                if (i2 >= 0) {
                    this.zzacu = i2;
                    zza("XML config - log level", Integer.valueOf(i2));
                }
            }
            if (zzcc.zzaax >= 0) {
                int i3 = zzcc.zzaax;
                this.zzaax = i3;
                this.zzacv = true;
                zzb("XML config - dispatch period (sec)", Integer.valueOf(i3));
            }
            if (zzcc.zzaay != -1) {
                if (zzcc.zzaay == 1) {
                    z = true;
                }
                this.zzacx = z;
                this.zzacw = true;
                zzb("XML config - dry run", Boolean.valueOf(z));
            }
        }
    }

    public final String zzba() {
        zzdb();
        return this.zzaav;
    }

    public final String zzaz() {
        zzdb();
        return this.zzaau;
    }

    public final boolean zzgh() {
        zzdb();
        return false;
    }

    public final boolean zzgi() {
        zzdb();
        return this.zzacw;
    }

    public final boolean zzgj() {
        zzdb();
        return this.zzacx;
    }
}
