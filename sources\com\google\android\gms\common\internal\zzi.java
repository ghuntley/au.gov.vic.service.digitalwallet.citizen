package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zzi implements ServiceConnection, zzk {
    private final Map<ServiceConnection, ServiceConnection> zza = new HashMap();
    private int zzb = 2;
    private boolean zzc;
    private IBinder zzd;
    private final GmsClientSupervisor.zza zze;
    private ComponentName zzf;
    private final /* synthetic */ zzg zzg;

    public zzi(zzg zzg2, GmsClientSupervisor.zza zza2) {
        this.zzg = zzg2;
        this.zze = zza2;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zzg.zza) {
            this.zzg.zzc.removeMessages(1, this.zze);
            this.zzd = iBinder;
            this.zzf = componentName;
            for (ServiceConnection serviceConnection : this.zza.values()) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.zzb = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zzg.zza) {
            this.zzg.zzc.removeMessages(1, this.zze);
            this.zzd = null;
            this.zzf = componentName;
            for (ServiceConnection serviceConnection : this.zza.values()) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.zzb = 2;
        }
    }

    public final void zza(String str) {
        this.zzb = 3;
        boolean zza2 = this.zzg.zzd.zza(this.zzg.zzb, str, this.zze.zza(this.zzg.zzb), this, this.zze.zzc());
        this.zzc = zza2;
        if (zza2) {
            this.zzg.zzc.sendMessageDelayed(this.zzg.zzc.obtainMessage(1, this.zze), this.zzg.zzf);
            return;
        }
        this.zzb = 2;
        try {
            this.zzg.zzd.unbindService(this.zzg.zzb, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void zzb(String str) {
        this.zzg.zzc.removeMessages(1, this.zze);
        this.zzg.zzd.unbindService(this.zzg.zzb, this);
        this.zzc = false;
        this.zzb = 2;
    }

    public final void zza(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.zza.put(serviceConnection, serviceConnection2);
    }

    public final void zza(ServiceConnection serviceConnection, String str) {
        this.zza.remove(serviceConnection);
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final boolean zza(ServiceConnection serviceConnection) {
        return this.zza.containsKey(serviceConnection);
    }

    public final boolean zzc() {
        return this.zza.isEmpty();
    }

    public final IBinder zzd() {
        return this.zzd;
    }

    public final ComponentName zze() {
        return this.zzf;
    }
}
