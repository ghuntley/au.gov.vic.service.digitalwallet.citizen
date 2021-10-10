package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzif implements Runnable {
    private final URL zza;
    private final byte[] zzb = null;
    private final zzic zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzid zzf;

    public zzif(zzid zzid, String str, URL url, byte[] bArr, Map<String, String> map, zzic zzic) {
        this.zzf = zzid;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzic);
        this.zza = url;
        this.zzc = zzic;
        this.zzd = str;
        this.zze = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0041  */
    public final void run() {
        IOException e;
        Map<String, List<String>> map;
        HttpURLConnection httpURLConnection;
        Throwable th;
        this.zzf.zzb();
        int i = 0;
        try {
            httpURLConnection = this.zzf.zza(this.zza);
            try {
                i = httpURLConnection.getResponseCode();
                map = httpURLConnection.getHeaderFields();
            } catch (IOException e2) {
                e = e2;
                map = null;
                if (httpURLConnection != null) {
                }
                zzb(i, e, null, map);
            } catch (Throwable th2) {
                th = th2;
                map = null;
                if (httpURLConnection != null) {
                }
                zzb(i, null, null, map);
                throw th;
            }
            try {
                zzid zzid = this.zzf;
                byte[] bArr = zzid.zza(httpURLConnection);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                zzb(i, null, bArr, map);
            } catch (IOException e3) {
                e = e3;
                if (httpURLConnection != null) {
                }
                zzb(i, e, null, map);
            } catch (Throwable th3) {
                th = th3;
                if (httpURLConnection != null) {
                }
                zzb(i, null, null, map);
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            httpURLConnection = null;
            map = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            zzb(i, e, null, map);
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            map = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            zzb(i, null, null, map);
            throw th;
        }
    }

    private final void zzb(int i, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        this.zzf.zzp().zza(new zzie(this, i, exc, bArr, map));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzc.zza(this.zzd, i, exc, bArr, map);
    }
}
