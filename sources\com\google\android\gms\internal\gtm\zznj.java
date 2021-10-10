package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class zznj implements Runnable {
    private final zzmn zzatm;
    private final zzni zzatn;
    private final zzmw zzato;
    private final zznf zzatp;
    private final Context zzrm;

    public zznj(Context context, zzmw zzmw, zzmn zzmn) {
        this(context, zzmw, zzmn, new zzni(), new zznf());
    }

    private zznj(Context context, zzmw zzmw, zzmn zzmn, zzni zzni, zznf zznf) {
        this.zzrm = (Context) Preconditions.checkNotNull(context);
        this.zzatm = (zzmn) Preconditions.checkNotNull(zzmn);
        this.zzato = zzmw;
        this.zzatn = zzni;
        this.zzatp = zznf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    public final void run() {
        boolean z;
        if (!zzx("android.permission.INTERNET")) {
            zzev.zzav("Missing android.permission.INTERNET. Please add the following declaration to your AndroidManifest.xml: <uses-permission android:name=\"android.permission.INTERNET\" />");
        } else if (!zzx("android.permission.ACCESS_NETWORK_STATE")) {
            zzev.zzav("Missing android.permission.ACCESS_NETWORK_STATE. Please add the following declaration to your AndroidManifest.xml: <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />");
        } else {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzrm.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                zzev.zzac("No network connectivity - Offline");
            } else {
                z = true;
                if (z) {
                    this.zzatm.zzb(0, 0);
                    return;
                }
                zzev.zzab("Starting to load resource from Network.");
                zzng zzng = new zzng();
                InputStream inputStream = null;
                try {
                    String zzb = this.zzatp.zzb(this.zzato.zzlk());
                    String valueOf = String.valueOf(zzb);
                    zzev.zzab(valueOf.length() != 0 ? "Loading resource from ".concat(valueOf) : new String("Loading resource from "));
                    try {
                        inputStream = zzng.zzcj(zzb);
                    } catch (FileNotFoundException unused) {
                        String valueOf2 = String.valueOf(zzb);
                        zzev.zzav(valueOf2.length() != 0 ? "NetworkLoader: No data was retrieved from the given url: ".concat(valueOf2) : new String("NetworkLoader: No data was retrieved from the given url: "));
                        this.zzatm.zzb(2, 0);
                        return;
                    } catch (zznl unused2) {
                        String valueOf3 = String.valueOf(zzb);
                        zzev.zzav(valueOf3.length() != 0 ? "NetworkLoader: Error when loading resource for url: ".concat(valueOf3) : new String("NetworkLoader: Error when loading resource for url: "));
                        this.zzatm.zzb(3, 0);
                    } catch (IOException e) {
                        String message = e.getMessage();
                        StringBuilder sb = new StringBuilder(String.valueOf(zzb).length() + 54 + String.valueOf(message).length());
                        sb.append("NetworkLoader: Error when loading resource from url: ");
                        sb.append(zzb);
                        sb.append(" ");
                        sb.append(message);
                        zzev.zza(sb.toString(), e);
                        this.zzatm.zzb(1, 0);
                        zzng.close();
                        return;
                    }
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        IOUtils.copyStream(inputStream, byteArrayOutputStream);
                        this.zzatm.zzc(byteArrayOutputStream.toByteArray());
                        zzng.close();
                        return;
                    } catch (IOException e2) {
                        String message2 = e2.getMessage();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(zzb).length() + 66 + String.valueOf(message2).length());
                        sb2.append("NetworkLoader: Error when parsing downloaded resources from url: ");
                        sb2.append(zzb);
                        sb2.append(" ");
                        sb2.append(message2);
                        zzev.zza(sb2.toString(), e2);
                        this.zzatm.zzb(2, 0);
                        zzng.close();
                        return;
                    }
                } finally {
                    zzng.close();
                }
            }
        }
        z = false;
        if (z) {
        }
    }

    private final boolean zzx(String str) {
        return this.zzrm.getPackageManager().checkPermission(str, this.zzrm.getPackageName()) == 0;
    }
}
