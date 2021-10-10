package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
final class zzaj extends zzag.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Context zze;
    private final /* synthetic */ Bundle zzf;
    private final /* synthetic */ zzag zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaj(zzag zzag, String str, String str2, Context context, Bundle bundle) {
        super(zzag);
        this.zzg = zzag;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048 A[Catch:{ Exception -> 0x0095 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054 A[Catch:{ Exception -> 0x0095 }] */
    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zza() {
        String str;
        String str2;
        String str3;
        boolean z;
        boolean z2;
        int i;
        try {
            if (zzag.zza(this.zzg, this.zzc, this.zzd)) {
                String str4 = this.zzd;
                str2 = this.zzc;
                str = str4;
                str3 = zzag.zzb(this.zzg);
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            zzag.zzb(this.zze);
            if (!zzag.zzj().booleanValue()) {
                if (str2 == null) {
                    z = false;
                    zzag zzag = this.zzg;
                    zzag.zza(zzag, zzag.zza(this.zze, z));
                    if (zzag.zzc(this.zzg) != null) {
                        Log.w(zzag.zzb(this.zzg), "Failed to connect to measurement client.");
                        return;
                    }
                    int zzc2 = zzag.zzc(this.zze);
                    int zzd2 = zzag.zzd(this.zze);
                    if (z) {
                        i = Math.max(zzc2, zzd2);
                        z2 = zzd2 < zzc2;
                    } else {
                        if (zzc2 > 0) {
                            zzd2 = zzc2;
                        }
                        z2 = zzc2 > 0;
                        i = zzd2;
                    }
                    zzag.zzc(this.zzg).initialize(ObjectWrapper.wrap(this.zze), new zzae(33025, (long) i, z2, str3, str2, str, this.zzf), this.zza);
                    return;
                }
            }
            z = true;
            zzag zzag2 = this.zzg;
            zzag.zza(zzag2, zzag2.zza(this.zze, z));
            if (zzag.zzc(this.zzg) != null) {
            }
        } catch (Exception e) {
            zzag.zza(this.zzg, e, true, false);
        }
    }
}
