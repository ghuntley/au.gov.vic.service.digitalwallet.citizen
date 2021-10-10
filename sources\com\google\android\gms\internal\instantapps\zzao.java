package com.google.android.gms.internal.instantapps;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.instantapps.PackageManagerCompat;

public final class zzao implements PackageManagerCompat {
    private static zzao zzbw;
    private final Context zzbl;
    private final boolean zzbx = true;

    public static synchronized zzao zza(Context context, boolean z) {
        zzao zzao;
        synchronized (zzao.class) {
            Context zza = zzo.zza(context);
            zzao zzao2 = zzbw;
            if (!(zzao2 != null && zzao2.zzbl == zza && zzao2.zzbx)) {
                zzbw = new zzao(zza, true);
            }
            zzao = zzbw;
        }
        return zzao;
    }

    private zzao(Context context, boolean z) {
        this.zzbl = context;
    }

    @Override // com.google.android.gms.instantapps.PackageManagerCompat
    public final String[] getPackagesForUid(int i) {
        String[] packagesForUid;
        if (this.zzbx && (packagesForUid = this.zzbl.getPackageManager().getPackagesForUid(i)) != null) {
            return packagesForUid;
        }
        zzah zzb = zzah.zzb(this.zzbl);
        if (zzb != null) {
            try {
                String zzb2 = zzb.zzb(i);
                if (zzb2 == null) {
                    return null;
                }
                return new String[]{zzb2};
            } catch (RemoteException e) {
                Log.e("InstantAppsPMW", "Error getting app package for UID", e);
            }
        }
        return null;
    }

    @Override // com.google.android.gms.instantapps.PackageManagerCompat
    public final PackageInfo getPackageInfo(String str, int i) throws PackageManager.NameNotFoundException {
        if (this.zzbx) {
            try {
                return this.zzbl.getPackageManager().getPackageInfo(str, i);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        zzah zzb = zzah.zzb(this.zzbl);
        if (zzb != null) {
            try {
                PackageInfo packageInfo = zzb.getPackageInfo(str, i);
                if (packageInfo != null) {
                    return packageInfo;
                }
            } catch (RemoteException e) {
                Log.e("InstantAppsPMW", "Error getting package info", e);
            }
        }
        throw new PackageManager.NameNotFoundException();
    }

    @Override // com.google.android.gms.instantapps.PackageManagerCompat
    public final ApplicationInfo getApplicationInfo(String str, int i) throws PackageManager.NameNotFoundException {
        if (this.zzbx) {
            try {
                return this.zzbl.getPackageManager().getApplicationInfo(str, i);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        zzah zzb = zzah.zzb(this.zzbl);
        if (zzb != null) {
            try {
                ApplicationInfo applicationInfo = zzb.getApplicationInfo(str, i);
                if (applicationInfo != null) {
                    return applicationInfo;
                }
            } catch (RemoteException e) {
                Log.e("InstantAppsPMW", "Error getting application info", e);
            }
        }
        throw new PackageManager.NameNotFoundException();
    }

    @Override // com.google.android.gms.instantapps.PackageManagerCompat
    public final CharSequence getApplicationLabel(ApplicationInfo applicationInfo) {
        if (this.zzbx && this.zzbl.getPackageManager().getPackagesForUid(applicationInfo.uid) != null) {
            return this.zzbl.getPackageManager().getApplicationLabel(applicationInfo);
        }
        zzah zzb = zzah.zzb(this.zzbl);
        if (zzb == null) {
            return null;
        }
        try {
            return zzb.zzb(applicationInfo.packageName);
        } catch (RemoteException e) {
            Log.e("InstantAppsPMW", "Error getting application label", e);
            return null;
        }
    }

    @Override // com.google.android.gms.instantapps.PackageManagerCompat
    public final String getInstallerPackageName(String str) {
        IllegalArgumentException e;
        if (this.zzbx) {
            try {
                return this.zzbl.getPackageManager().getInstallerPackageName(str);
            } catch (IllegalArgumentException e2) {
                e = e2;
            }
        } else {
            e = null;
            zzah zzb = zzah.zzb(this.zzbl);
            if (zzb != null) {
                try {
                    if (zzb.zza(str) != 0) {
                        return "com.android.vending";
                    }
                } catch (RemoteException e3) {
                    Log.e("InstantAppsPMW", "Error getting UID for app package", e3);
                }
            }
            if (e == null) {
                throw new IllegalArgumentException();
            }
            throw e;
        }
    }

    @Override // com.google.android.gms.instantapps.PackageManagerCompat
    public final boolean isInstantApp() {
        return isInstantApp(this.zzbl.getPackageName());
    }

    @Override // com.google.android.gms.instantapps.PackageManagerCompat
    public final boolean isInstantApp(String str) {
        zzah zzb = zzah.zzb(this.zzbl);
        if (zzb == null) {
            return false;
        }
        try {
            return zzb.isInstantApp(str);
        } catch (RemoteException e) {
            Log.e("InstantAppsPMW", "Error checking if app is instant app", e);
            return false;
        }
    }

    @Override // com.google.android.gms.instantapps.PackageManagerCompat
    public final int getInstantAppCookieMaxSize() {
        zzah zzb = zzah.zzb(this.zzbl);
        if (zzb == null) {
            return 0;
        }
        try {
            return zzb.getInstantAppCookieMaxSize();
        } catch (RemoteException e) {
            Log.e("InstantAppsPMW", "Error fetching max cookie size", e);
            return 0;
        }
    }

    @Override // com.google.android.gms.instantapps.PackageManagerCompat
    public final boolean setInstantAppCookie(byte[] bArr) {
        zzah zzb = zzah.zzb(this.zzbl);
        if (zzb == null) {
            return false;
        }
        try {
            return zzb.zza(Process.myUid(), bArr);
        } catch (RemoteException e) {
            Log.e("InstantAppsPMW", "Error setting cookie", e);
            return false;
        }
    }

    @Override // com.google.android.gms.instantapps.PackageManagerCompat
    public final byte[] getInstantAppCookie() {
        zzah zzb = zzah.zzb(this.zzbl);
        if (zzb == null) {
            return null;
        }
        try {
            return zzb.zzc(Process.myUid());
        } catch (RemoteException e) {
            Log.e("InstantAppsPMW", "Error setting cookie", e);
            return null;
        }
    }
}
