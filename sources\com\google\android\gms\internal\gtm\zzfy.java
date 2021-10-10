package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcm;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzfy {
    private static final Pattern zzapq = Pattern.compile("(gtm-[a-z0-9]{1,10})\\.json", 2);
    private static volatile zzfy zzapr;
    private static zzc zzaqa = new zzfz();
    private String zzaec;
    private final ExecutorService zzamv;
    private final ScheduledExecutorService zzamw;
    private final zzcm zzamx;
    private final zzcd zzanh;
    private final zzgt zzaps;
    private final zzfd zzapt;
    private final zza zzapu;
    private final Object zzapv = new Object();
    private String zzapw;
    private int zzapx = 1;
    private final Queue<Runnable> zzapy = new LinkedList();
    private volatile boolean zzapz = false;
    private final Context zzrm;
    private volatile boolean zzrq = false;

    class zzb extends zzep {
        private zzb() {
        }

        @Override // com.google.android.gms.internal.gtm.zzeo
        public final void zza(boolean z, String str) throws RemoteException {
            zzfy.this.zzamv.execute(new zzgk(this, z, str));
        }

        /* synthetic */ zzb(zzfy zzfy, zzfz zzfz) {
            this();
        }
    }

    public interface zzc {
        zzfy zzb(Context context, zzcm zzcm, zzcd zzcd);
    }

    public static zzfy zza(Context context, zzcm zzcm, zzcd zzcd) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context);
        zzfy zzfy = zzapr;
        if (zzfy == null) {
            synchronized (zzfy.class) {
                zzfy = zzapr;
                if (zzfy == null) {
                    zzfy zzb2 = zzaqa.zzb(context, zzcm, zzcd);
                    zzapr = zzb2;
                    zzfy = zzb2;
                }
            }
        }
        return zzfy;
    }

    public static class zza {
        private final Context zzrm;

        public zza(Context context) {
            this.zzrm = context;
        }

        public final String[] zzcb(String str) throws IOException {
            return this.zzrm.getAssets().list(str);
        }

        public final String[] zzkx() throws IOException {
            return this.zzrm.getAssets().list("");
        }
    }

    zzfy(Context context, zzcm zzcm, zzcd zzcd, zzgt zzgt, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, zzfd zzfd, zza zza2) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(zzcm);
        this.zzrm = context;
        this.zzamx = zzcm;
        this.zzanh = zzcd;
        this.zzaps = zzgt;
        this.zzamv = executorService;
        this.zzamw = scheduledExecutorService;
        this.zzapt = zzfd;
        this.zzapu = zza2;
    }

    public final void zzag() {
        zzev.zzab("Initializing Tag Manager.");
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.zzapv) {
            if (!this.zzrq) {
                try {
                    if (!zzc(this.zzrm, "com.google.android.gms.tagmanager.TagManagerService")) {
                        zzev.zzac("Tag Manager fails to initialize (TagManagerService not enabled in the manifest)");
                        return;
                    }
                    Pair<String, String> zzc2 = zzc((String[]) null);
                    String str = (String) zzc2.first;
                    String str2 = (String) zzc2.second;
                    if (str == null || str2 == null) {
                        zzev.zzac("Tag Manager's event handler WILL NOT be installed (no container loaded)");
                    } else {
                        String valueOf = String.valueOf(str);
                        zzev.zzaw(valueOf.length() != 0 ? "Loading container ".concat(valueOf) : new String("Loading container "));
                        this.zzamv.execute(new zzge(this, str, str2, null));
                        this.zzamw.schedule(new zzgf(this), 5000, TimeUnit.MILLISECONDS);
                        if (!this.zzapz) {
                            zzev.zzaw("Installing Tag Manager event handler.");
                            this.zzapz = true;
                            try {
                                this.zzamx.zza(new zzga(this));
                            } catch (RemoteException e) {
                                zzea.zza("Error communicating with measurement proxy: ", e, this.zzrm);
                            }
                            try {
                                this.zzamx.zza(new zzgc(this));
                            } catch (RemoteException e2) {
                                zzea.zza("Error communicating with measurement proxy: ", e2, this.zzrm);
                            }
                            this.zzrm.registerComponentCallbacks(new zzgh(this));
                            zzev.zzaw("Tag Manager event handler installed.");
                        }
                    }
                    this.zzrq = true;
                    StringBuilder sb = new StringBuilder(53);
                    sb.append("Tag Manager initilization took ");
                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                    sb.append("ms");
                    zzev.zzaw(sb.toString());
                } finally {
                    this.zzrq = true;
                }
            }
        }
    }

    public final void zzb(String[] strArr) {
        zzev.zzab("Initializing Tag Manager.");
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.zzapv) {
            if (!this.zzrq) {
                try {
                    if (!zzc(this.zzrm, "com.google.android.gms.tagmanager.TagManagerService")) {
                        zzev.zzac("Tag Manager fails to initialize (TagManagerService not enabled in the manifest)");
                        return;
                    }
                    Pair<String, String> zzc2 = zzc((String[]) null);
                    String str = (String) zzc2.first;
                    String str2 = (String) zzc2.second;
                    if (str == null || str2 == null) {
                        zzev.zzac("Tag Manager's event handler WILL NOT be installed (no container loaded)");
                    } else {
                        String valueOf = String.valueOf(str);
                        zzev.zzaw(valueOf.length() != 0 ? "Loading container ".concat(valueOf) : new String("Loading container "));
                        this.zzamv.execute(new zzge(this, str, str2, null));
                        this.zzamw.schedule(new zzgf(this), 5000, TimeUnit.MILLISECONDS);
                        if (!this.zzapz) {
                            zzev.zzaw("Installing Tag Manager event handler.");
                            this.zzapz = true;
                            try {
                                this.zzamx.zza(new zzga(this));
                            } catch (RemoteException e) {
                                zzea.zza("Error communicating with measurement proxy: ", e, this.zzrm);
                            }
                            try {
                                this.zzamx.zza(new zzgc(this));
                            } catch (RemoteException e2) {
                                zzea.zza("Error communicating with measurement proxy: ", e2, this.zzrm);
                            }
                            this.zzrm.registerComponentCallbacks(new zzgh(this));
                            zzev.zzaw("Tag Manager event handler installed.");
                        }
                    }
                    this.zzrq = true;
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    StringBuilder sb = new StringBuilder(53);
                    sb.append("Tag Manager initilization took ");
                    sb.append(currentTimeMillis2);
                    sb.append("ms");
                    zzev.zzaw(sb.toString());
                } finally {
                    this.zzrq = true;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final Pair<String, String> zzc(String[] strArr) {
        String str;
        zzev.zzab("Looking up container asset.");
        String str2 = this.zzaec;
        if (!(str2 == null || (str = this.zzapw) == null)) {
            return Pair.create(str2, str);
        }
        try {
            String[] zzcb = this.zzapu.zzcb("containers");
            boolean z = false;
            for (int i = 0; i < zzcb.length; i++) {
                Pattern pattern = zzapq;
                Matcher matcher = pattern.matcher(zzcb[i]);
                if (!matcher.matches()) {
                    zzev.zzac(String.format("Ignoring container asset %s (does not match %s)", zzcb[i], pattern.pattern()));
                } else if (!z) {
                    this.zzaec = matcher.group(1);
                    String str3 = File.separator;
                    String str4 = zzcb[i];
                    StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 10 + String.valueOf(str4).length());
                    sb.append("containers");
                    sb.append(str3);
                    sb.append(str4);
                    this.zzapw = sb.toString();
                    String valueOf = String.valueOf(this.zzaec);
                    zzev.zzab(valueOf.length() != 0 ? "Asset found for container ".concat(valueOf) : new String("Asset found for container "));
                    z = true;
                } else {
                    String valueOf2 = String.valueOf(zzcb[i]);
                    zzev.zzac(valueOf2.length() != 0 ? "Extra container asset found, will not be loaded: ".concat(valueOf2) : new String("Extra container asset found, will not be loaded: "));
                }
            }
            if (!z) {
                zzev.zzac("No container asset found in /assets/containers. Checking top level /assets directory for container assets.");
                try {
                    String[] zzkx = this.zzapu.zzkx();
                    for (int i2 = 0; i2 < zzkx.length; i2++) {
                        Matcher matcher2 = zzapq.matcher(zzkx[i2]);
                        if (matcher2.matches()) {
                            if (!z) {
                                String group = matcher2.group(1);
                                this.zzaec = group;
                                this.zzapw = zzkx[i2];
                                String valueOf3 = String.valueOf(group);
                                zzev.zzab(valueOf3.length() != 0 ? "Asset found for container ".concat(valueOf3) : new String("Asset found for container "));
                                zzev.zzac("Loading container assets from top level /assets directory. Please move the container asset to /assets/containers");
                                z = true;
                            } else {
                                String valueOf4 = String.valueOf(zzkx[i2]);
                                zzev.zzac(valueOf4.length() != 0 ? "Extra container asset found, will not be loaded: ".concat(valueOf4) : new String("Extra container asset found, will not be loaded: "));
                            }
                        }
                    }
                } catch (IOException e) {
                    zzev.zza("Failed to enumerate assets.", e);
                    return Pair.create(null, null);
                }
            }
            return Pair.create(this.zzaec, this.zzapw);
        } catch (IOException e2) {
            zzev.zza(String.format("Failed to enumerate assets in folder %s", "containers"), e2);
            return Pair.create(null, null);
        }
    }

    private static boolean zzc(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 0);
            if (serviceInfo == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Uri uri) {
        this.zzamv.execute(new zzgj(this, uri));
    }
}
