package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import org.objectweb.asm.Opcodes;

public final class zzav implements ServiceConnection {
    final /* synthetic */ zzat zzxe;
    private volatile zzce zzxf;
    private volatile boolean zzxg;

    protected zzav(zzat zzat) {
        this.zzxe = zzat;
    }

    public final zzce zzdq() {
        zzk.zzav();
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        Context context = this.zzxe.getContext();
        intent.putExtra("app_package_name", context.getPackageName());
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            this.zzxf = null;
            this.zzxg = true;
            boolean bindService = instance.bindService(context, intent, zzat.zza(this.zzxe), Opcodes.LOR);
            this.zzxe.zza("Bind to service requested", Boolean.valueOf(bindService));
            if (!bindService) {
                this.zzxg = false;
                return null;
            }
            try {
                wait(zzby.zzaak.get().longValue());
            } catch (InterruptedException unused) {
                this.zzxe.zzt("Wait for service connect was interrupted");
            }
            this.zzxg = false;
            zzce zzce = this.zzxf;
            this.zzxf = null;
            if (zzce == null) {
                this.zzxe.zzu("Successfully bound to service but never got onServiceConnected callback");
            }
            return zzce;
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzce zzce;
        Preconditions.checkMainThread("AnalyticsServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                try {
                    this.zzxe.zzu("Service connected with null binder");
                } finally {
                    notifyAll();
                }
            } else {
                zzce zzce2 = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(interfaceDescriptor)) {
                        if (iBinder != null) {
                            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                            if (queryLocalInterface instanceof zzce) {
                                zzce = (zzce) queryLocalInterface;
                            } else {
                                zzce = new zzcf(iBinder);
                            }
                            zzce2 = zzce;
                        }
                        this.zzxe.zzq("Bound to IAnalyticsService interface");
                    } else {
                        this.zzxe.zze("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException unused) {
                    this.zzxe.zzu("Service connect failed to get IAnalyticsService");
                }
                if (zzce2 == null) {
                    try {
                        ConnectionTracker.getInstance().unbindService(this.zzxe.getContext(), zzat.zza(this.zzxe));
                    } catch (IllegalArgumentException unused2) {
                    }
                } else if (!this.zzxg) {
                    this.zzxe.zzt("onServiceConnected received after the timeout limit");
                    this.zzxe.zzcq().zza(new zzaw(this, zzce2));
                } else {
                    this.zzxf = zzce2;
                }
                notifyAll();
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("AnalyticsServiceConnection.onServiceDisconnected");
        this.zzxe.zzcq().zza(new zzax(this, componentName));
    }
}
