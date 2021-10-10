package com.google.android.gms.internal.instantapps;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.firebase.messaging.Constants;

public final class zzah {
    private static zzah zzbk;
    private final Context zzbl;

    private static synchronized void reset() {
        synchronized (zzah.class) {
            zzbk = null;
        }
    }

    public static synchronized zzah zzb(Context context) {
        zzah zzah;
        synchronized (zzah.class) {
            Context zza = zzo.zza(context);
            zzah zzah2 = zzbk;
            if (zzah2 == null || zzah2.zzbl != zza) {
                zzah zzah3 = null;
                if (Build.VERSION.SDK_INT >= 21) {
                    if (zzav.zzg(zza)) {
                        ProviderInfo resolveContentProvider = zza.getPackageManager().resolveContentProvider(zzak.zzbq.getAuthority(), 0);
                        if (resolveContentProvider != null) {
                            if (!resolveContentProvider.packageName.equals("com.google.android.gms")) {
                                String str = resolveContentProvider.packageName;
                                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 85);
                                sb.append("Package ");
                                sb.append(str);
                                sb.append(" is invalid for instant apps content provider; instant apps will be disabled.");
                                Log.e("IAMetadataClient", sb.toString());
                            } else {
                                zzah3 = new zzah(zza);
                            }
                        }
                    }
                }
                zzbk = zzah3;
            }
            zzah = zzbk;
        }
        return zzah;
    }

    private zzah(Context context) {
        this.zzbl = context;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001f */
    private final Bundle zza(String str, Bundle bundle) throws RemoteException {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            Bundle call = this.zzbl.getContentResolver().call(zzak.zzbq, str, (String) null, bundle);
            Binder.restoreCallingIdentity(clearCallingIdentity);
            if (call != null) {
                return call;
            }
            throw new RemoteException();
        } catch (IllegalArgumentException unused) {
            reset();
            throw new RemoteException("IAE: Content provider unavailable. Likely GmsCore down.");
        } catch (SecurityException unknown) {
            reset();
            throw new RemoteException("SecurityException: Content provider unavailable. Likely framework issue.");
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    public final String zzb(int i) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putInt("uid", i);
        return zza("getAppPackageForUid", bundle).getString("result");
    }

    public final int zza(String str) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, str);
        return zza("getUidForPackage", bundle).getInt("result");
    }

    public final ApplicationInfo getApplicationInfo(String str, int i) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, str);
        bundle.putInt("flags", i);
        return (ApplicationInfo) zza("getWHApplicationInfo", bundle).getParcelable("result");
    }

    public final PackageInfo getPackageInfo(String str, int i) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, str);
        bundle.putInt("flags", i);
        return (PackageInfo) zza("getWHPackageInfo", bundle).getParcelable("result");
    }

    public final String zzb(String str) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, str);
        return zza("getApplicationLabel", bundle).getString("result");
    }

    public final ComponentName zzc(String str) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("shadowActivity", str);
        return (ComponentName) zza("getCallingActivity", bundle).getParcelable("result");
    }

    public final boolean isInstantApp(String str) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, str);
        return zza("isInstantApp", bundle).getBoolean("result");
    }

    public final int getInstantAppCookieMaxSize() throws RemoteException {
        return zza("getInstantAppCookieMaxSize", new Bundle()).getInt("result");
    }

    public final boolean zza(int i, byte[] bArr) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putInt("uid", i);
        bundle.putByteArray("cookie", bArr);
        return zza("setInstantAppCookie", bundle).getBoolean("result");
    }

    public final byte[] zzc(int i) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putInt("uid", i);
        return zza("getInstantAppCookie", bundle).getByteArray("result");
    }
}
