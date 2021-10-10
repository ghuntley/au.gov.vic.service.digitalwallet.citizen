package com.google.android.gms.internal.instantapps;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.instantapps.InstantAppIntentData;
import com.google.android.gms.internal.instantapps.zzba;
import com.google.android.gms.internal.instantapps.zzbc;

public final class zzai {
    private static Boolean zzbm;
    private static ContentProviderClient zzbn;

    private static InstantAppIntentData zza(Context context, String str, Parcelable parcelable, boolean z, zzar zzar, Bundle bundle) {
        InstantAppIntentData instantAppIntentData;
        while (context != null && str != null) {
            zzba.zzb zza = zzp.zza(zzbc.zza.zzb.GET_IA_INTENT_DATA_START);
            if (!zzd(context)) {
                return InstantAppIntentData.zzj;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("key_preferParcelableIntentData", true);
            if (parcelable != null) {
                bundle2.putParcelable("key_fallbackIntent", parcelable);
            }
            if (zzar != null) {
                bundle2.putByteArray("key_routingOptions", SafeParcelableSerializer.serializeToBytes(zzar));
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            try {
                Bundle zza2 = zza(context, "method_getInstantAppIntentData", str, bundle2);
                if (zza2 == null) {
                    return InstantAppIntentData.zzj;
                }
                zza2.setClassLoader(InstantAppIntentData.class.getClassLoader());
                zzba.zza.C0008zza zza3 = null;
                try {
                    instantAppIntentData = (InstantAppIntentData) zza2.getParcelable("key_instantAppIntentDataParcelable");
                } catch (Exception unused) {
                    instantAppIntentData = null;
                }
                if (instantAppIntentData == null) {
                    byte[] byteArray = zza2.getByteArray("key_instantAppIntentData");
                    if (byteArray == null) {
                        return InstantAppIntentData.zzj;
                    }
                    instantAppIntentData = (InstantAppIntentData) SafeParcelableSerializer.deserializeFromBytes(byteArray, InstantAppIntentData.CREATOR);
                }
                if (!(instantAppIntentData == null || instantAppIntentData.getIntent() == null || !instantAppIntentData.getIntent().hasExtra("key_eventListProtoBytes"))) {
                    Intent intent = instantAppIntentData.getIntent();
                    zzba.zzb zza4 = zzp.zza(zzbc.zza.zzb.GET_IA_INTENT_DATA_END);
                    byte[] byteArrayExtra = intent.getByteArrayExtra("key_eventListProtoBytes");
                    if (byteArrayExtra != null) {
                        try {
                            zza3 = (zzba.zza.C0008zza) zzba.zza.zzf().zza(byteArrayExtra, 0, byteArrayExtra.length, zzck.zzbf());
                        } catch (zzdf e) {
                            Log.e("EventLogHelper", "Could not read event list proto", e);
                        }
                    }
                    if (zza3 == null) {
                        zza3 = zzba.zza.zzf();
                        zza3.zza(zza).zza(zza4);
                    } else {
                        zza3.zza(0, zza);
                        zza3.zza(zza3.zzd(), zza4);
                    }
                    intent.putExtra("key_eventListProtoBytes", ((zzba.zza) ((zzcx) zza3.zzbw())).toByteArray());
                }
                return instantAppIntentData;
            } catch (DeadObjectException e2) {
                Log.e("InstantAppsApi", String.format("While calling %s %s:\n", zzj.zzak, "method_getInstantAppIntentData"), e2);
                reset();
                if (!z) {
                    return InstantAppIntentData.zzj;
                }
                z = false;
            } catch (RemoteException | IllegalArgumentException e3) {
                Log.e("InstantAppsApi", String.format("While calling %s %s:\n", zzj.zzak, "method_getInstantAppIntentData"), e3);
                return InstantAppIntentData.zzj;
            }
        }
        throw new IllegalArgumentException("Parameter is null");
    }

    private static synchronized boolean zzc(Context context) {
        boolean z;
        synchronized (zzai.class) {
            if (zzbn == null) {
                zzbn = context.getApplicationContext().getContentResolver().acquireUnstableContentProviderClient(zzj.zzak);
            }
            z = zzbn != null;
        }
        return z;
    }

    private static synchronized Bundle zza(String str, String str2, Bundle bundle) throws RemoteException {
        Bundle call;
        synchronized (zzai.class) {
            call = zzbn.call(str, str2, bundle);
        }
        return call;
    }

    private static synchronized Bundle zza(Context context, String str, String str2, Bundle bundle) throws RemoteException {
        synchronized (zzai.class) {
            if (zzbn == null) {
                return context.getContentResolver().call(zzj.zzak, str, str2, bundle);
            }
            return zza(str, str2, bundle);
        }
    }

    static InstantAppIntentData zza(Context context, String str, Intent intent, zzar zzar, Bundle bundle) {
        return zza(context, str, intent, true, zzar, bundle);
    }

    static synchronized boolean zzd(Context context) {
        synchronized (zzai.class) {
            if (context != null) {
                Boolean bool = zzbm;
                if (bool != null) {
                    return bool.booleanValue();
                }
                Boolean valueOf = Boolean.valueOf(zze(context));
                zzbm = valueOf;
                return valueOf.booleanValue();
            }
            throw new IllegalArgumentException("Parameter is null");
        }
    }

    private static synchronized boolean zze(Context context) {
        synchronized (zzai.class) {
            if (!zzav.zzg(context)) {
                return false;
            }
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(zzj.zzak.getAuthority(), 0);
            if (resolveContentProvider == null) {
                return false;
            }
            if (!resolveContentProvider.packageName.equals("com.google.android.gms")) {
                String valueOf = String.valueOf(resolveContentProvider.packageName);
                Log.e("InstantAppsApi", valueOf.length() != 0 ? "Incorrect package name for instant apps content provider: ".concat(valueOf) : new String("Incorrect package name for instant apps content provider: "));
                return false;
            } else if (Build.VERSION.SDK_INT < 17 || zzc(context)) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static synchronized void reset() {
        synchronized (zzai.class) {
            ContentProviderClient contentProviderClient = zzbn;
            if (contentProviderClient != null) {
                contentProviderClient.release();
                zzbn = null;
            }
            zzbm = null;
        }
    }
}
