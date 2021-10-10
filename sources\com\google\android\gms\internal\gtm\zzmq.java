package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.api.Status;
import java.util.List;

/* access modifiers changed from: package-private */
public final class zzmq extends zzmn {
    private final zzmp zzasr;
    private final List<Integer> zzass;
    private final int zzast;
    private final /* synthetic */ zzmo zzasu;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzmq(zzmo zzmo, int i, zzmw zzmw, zzms zzms, List<Integer> list, int i2, zzmp zzmp, zzdz zzdz) {
        super(i, zzmw, zzms, zzdz);
        this.zzasu = zzmo;
        this.zzasr = zzmp;
        this.zzass = list;
        this.zzast = i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzmn
    public final void zza(zzmx zzmx) {
        boolean z = false;
        if (zzmx.getStatus() == Status.RESULT_SUCCESS) {
            String valueOf = String.valueOf(zzmx.zzln());
            zzev.zzab(valueOf.length() != 0 ? "Container resource successfully loaded from ".concat(valueOf) : new String("Container resource successfully loaded from "));
            if (zzmx.getSource() == 0) {
                zzmy zzll = zzmx.zzll();
                if (!zzll.zzlp().zzlg()) {
                    this.zzasu.zza(zzmx.getStatus(), zzll);
                    if (zzll.zzlo() != null && zzll.zzlo().length > 0) {
                        this.zzasu.zzaso.zza(zzll.zzlp().zzlf(), zzll.zzlo());
                    }
                }
            }
            z = true;
        }
        if (z) {
            this.zzasr.zza(zzmx);
            return;
        }
        String zzln = zzmx.zzln();
        String str = zzmx.getStatus().isSuccess() ? "SUCCESS" : "FAILURE";
        StringBuilder sb = new StringBuilder(String.valueOf(zzln).length() + 54 + String.valueOf(str).length());
        sb.append("Cannot fetch a valid resource from ");
        sb.append(zzln);
        sb.append(". Response status: ");
        sb.append(str);
        zzev.zzab(sb.toString());
        if (zzmx.getStatus().isSuccess()) {
            String valueOf2 = String.valueOf(zzmx.zzln());
            zzev.zzab(valueOf2.length() != 0 ? "Response source: ".concat(valueOf2) : new String("Response source: "));
            int length = zzmx.zzll().zzlo().length;
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("Response size: ");
            sb2.append(length);
            zzev.zzab(sb2.toString());
        }
        this.zzasu.zza(this.zzask, this.zzass, this.zzast + 1, this.zzasr, this.zzasn);
    }
}
