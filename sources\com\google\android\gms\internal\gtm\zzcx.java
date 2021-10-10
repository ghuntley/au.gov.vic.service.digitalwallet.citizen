package com.google.android.gms.internal.gtm;

/* access modifiers changed from: package-private */
public final class zzcx extends zzam implements zzbp<zzcy> {
    private final zzcy zzacl = new zzcy();

    public zzcx(zzap zzap) {
        super(zzap);
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzb(String str, String str2) {
        this.zzacl.zzacs.put(str, str2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzc(String str, String str2) {
        if ("ga_trackingId".equals(str)) {
            this.zzacl.zzacm = str2;
        } else if ("ga_sampleFrequency".equals(str)) {
            try {
                this.zzacl.zzacn = Double.parseDouble(str2);
            } catch (NumberFormatException e) {
                zzc("Error parsing ga_sampleFrequency value", str2, e);
            }
        } else {
            zzd("string configuration name not recognized", str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zza(String str, boolean z) {
        if ("ga_autoActivityTracking".equals(str)) {
            this.zzacl.zzacp = z;
        } else if ("ga_anonymizeIp".equals(str)) {
            this.zzacl.zzacq = z;
        } else if ("ga_reportUncaughtExceptions".equals(str)) {
            this.zzacl.zzacr = z ? 1 : 0;
        } else {
            zzd("bool configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzb(String str, int i) {
        if ("ga_sessionTimeout".equals(str)) {
            this.zzacl.zzaco = i;
        } else {
            zzd("int configuration name not recognized", str);
        }
    }

    /* Return type fixed from 'com.google.android.gms.internal.gtm.zzbn' to match base method */
    @Override // com.google.android.gms.internal.gtm.zzbp
    public final /* synthetic */ zzcy zzel() {
        return this.zzacl;
    }
}
