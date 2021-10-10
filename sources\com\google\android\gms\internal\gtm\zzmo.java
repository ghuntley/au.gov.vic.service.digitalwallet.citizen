package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzmo {
    private String zzafk;
    private final zzmz zzaso;
    private final Map<String, zzmr<zznm>> zzasp;
    private final Map<String, zznk> zzasq;
    private final Context zzrm;
    private final Clock zzsd;

    public zzmo(Context context) {
        this(context, new HashMap(), new zzmz(context), DefaultClock.getInstance());
    }

    private zzmo(Context context, Map<String, zznk> map, zzmz zzmz, Clock clock) {
        this.zzafk = null;
        this.zzasp = new HashMap();
        this.zzrm = context.getApplicationContext();
        this.zzsd = clock;
        this.zzaso = zzmz;
        this.zzasq = map;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0024, code lost:
        if (r16.equals(r2.getContainerId()) != false) goto L_0x002a;
     */
    public final void zza(String str, String str2, String str3, List<Integer> list, zzmp zzmp, zzdz zzdz) {
        boolean z = true;
        Preconditions.checkArgument(!list.isEmpty());
        zzmw zzmw = new zzmw();
        zzfd zzkr = zzfd.zzkr();
        if (zzkr.isPreview()) {
        }
        z = false;
        zza(zzmw.zza(new zzmk(str, str2, str3, z, zzfd.zzkr().zzks())), Collections.unmodifiableList(list), 0, zzmp, zzdz);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzmw zzmw, List<Integer> list, int i, zzmp zzmp, zzdz zzdz) {
        long j;
        int i2 = i;
        while (true) {
            if (i2 == 0) {
                zzev.zzab("Starting to fetch a new resource");
            }
            boolean z = true;
            if (i2 >= list.size()) {
                String valueOf = String.valueOf(zzmw.zzlk().getContainerId());
                String concat = valueOf.length() != 0 ? "There is no valid resource for the container: ".concat(valueOf) : new String("There is no valid resource for the container: ");
                zzev.zzab(concat);
                zzmp.zza(new zzmx(new Status(16, concat), list.get(i2 - 1).intValue()));
                return;
            }
            int intValue = list.get(i2).intValue();
            if (intValue == 0) {
                zzmk zzlk = zzmw.zzlk();
                zzmr<zznm> zzmr = this.zzasp.get(zzlk.getContainerId());
                if (!zzmw.zzlk().zzlg()) {
                    if (zzmr != null) {
                        j = zzmr.zzlj();
                    } else {
                        j = this.zzaso.zzcg(zzlk.getContainerId());
                    }
                    if (j + 900000 >= this.zzsd.currentTimeMillis()) {
                        z = false;
                    }
                }
                if (z) {
                    zznk zznk = this.zzasq.get(zzmw.getId());
                    if (zznk == null) {
                        zznk = new zznk();
                        this.zzasq.put(zzmw.getId(), zznk);
                    }
                    String containerId = zzlk.getContainerId();
                    StringBuilder sb = new StringBuilder(String.valueOf(containerId).length() + 43);
                    sb.append("Attempting to fetch container ");
                    sb.append(containerId);
                    sb.append(" from network");
                    zzev.zzab(sb.toString());
                    zznk.zza(this.zzrm, zzmw, 0, new zzmq(this, 0, zzmw, zzmt.zzasw, list, i2, zzmp, zzdz));
                    return;
                }
                i2++;
            } else if (intValue == 1) {
                zzmk zzlk2 = zzmw.zzlk();
                String containerId2 = zzlk2.getContainerId();
                StringBuilder sb2 = new StringBuilder(String.valueOf(containerId2).length() + 52);
                sb2.append("Attempting to fetch container ");
                sb2.append(containerId2);
                sb2.append(" from a saved resource");
                zzev.zzab(sb2.toString());
                this.zzaso.zza(zzlk2.zzlf(), new zzmq(this, 1, zzmw, zzmt.zzasw, list, i2, zzmp, null));
                return;
            } else if (intValue == 2) {
                zzmk zzlk3 = zzmw.zzlk();
                String containerId3 = zzlk3.getContainerId();
                StringBuilder sb3 = new StringBuilder(String.valueOf(containerId3).length() + 56);
                sb3.append("Attempting to fetch container ");
                sb3.append(containerId3);
                sb3.append(" from the default resource");
                zzev.zzab(sb3.toString());
                this.zzaso.zza(zzlk3.zzlf(), zzlk3.zzld(), new zzmq(this, 2, zzmw, zzmt.zzasw, list, i2, zzmp, null));
                return;
            } else {
                StringBuilder sb4 = new StringBuilder(36);
                sb4.append("Unknown fetching source: ");
                sb4.append(i2);
                throw new UnsupportedOperationException(sb4.toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Status status, zzmy zzmy) {
        String containerId = zzmy.zzlp().getContainerId();
        zznm zzlq = zzmy.zzlq();
        if (this.zzasp.containsKey(containerId)) {
            zzmr<zznm> zzmr = this.zzasp.get(containerId);
            zzmr.zzo(this.zzsd.currentTimeMillis());
            if (status == Status.RESULT_SUCCESS) {
                zzmr.zzb(status);
                zzmr.zzp(zzlq);
                return;
            }
            return;
        }
        this.zzasp.put(containerId, new zzmr<>(status, zzlq, this.zzsd.currentTimeMillis()));
    }
}
