package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzfb implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zzez zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzex zzf;

    public zzfb(zzex zzex, String str, URL url, byte[] bArr, Map<String, String> map, zzez zzez) {
        this.zzf = zzex;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzez);
        this.zza = url;
        this.zzb = bArr;
        this.zzc = zzez;
        this.zzd = str;
        this.zze = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d0 A[SYNTHETIC, Splitter:B:44:0x00d0] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010b A[SYNTHETIC, Splitter:B:57:0x010b] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0125  */
    public final void run() {
        Map<String, List<String>> map;
        IOException iOException;
        int i;
        HttpURLConnection httpURLConnection;
        IOException e;
        Map<String, List<String>> map2;
        int i2;
        Throwable th;
        Throwable th2;
        int responseCode;
        Map<String, List<String>> headerFields;
        this.zzf.zzb();
        OutputStream outputStream = null;
        try {
            httpURLConnection = this.zzf.zza(this.zza);
            try {
                Map<String, String> map3 = this.zze;
                if (map3 != null) {
                    for (Map.Entry<String, String> entry : map3.entrySet()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                if (this.zzb != null) {
                    byte[] zzc2 = this.zzf.f_().zzc(this.zzb);
                    this.zzf.zzq().zzw().zza("Uploading data. size", Integer.valueOf(zzc2.length));
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                    httpURLConnection.setFixedLengthStreamingMode(zzc2.length);
                    httpURLConnection.connect();
                    OutputStream outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(zzc2);
                        outputStream2.close();
                    } catch (IOException e2) {
                        map = null;
                        i = 0;
                        iOException = e2;
                        outputStream = outputStream2;
                    } catch (Throwable th3) {
                        map2 = null;
                        i2 = 0;
                        th = th3;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                this.zzf.zzq().zze().zza("Error closing HTTP compressed POST connection output stream. appId", zzeq.zza(this.zzd), e3);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.zzf.zzp().zza(new zzey(this.zzd, this.zzc, i2, null, null, map2));
                        throw th;
                    }
                }
                responseCode = httpURLConnection.getResponseCode();
                try {
                    headerFields = httpURLConnection.getHeaderFields();
                } catch (IOException e4) {
                    e = e4;
                    map = null;
                    i = responseCode;
                    iOException = e;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    this.zzf.zzp().zza(new zzey(this.zzd, this.zzc, i, iOException, null, map));
                } catch (Throwable th4) {
                    map2 = null;
                    th = th4;
                    i2 = responseCode;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    this.zzf.zzp().zza(new zzey(this.zzd, this.zzc, i2, null, null, map2));
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                map = null;
                i = 0;
                iOException = e;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                this.zzf.zzp().zza(new zzey(this.zzd, this.zzc, i, iOException, null, map));
            } catch (Throwable th5) {
                th2 = th5;
                map2 = null;
                i2 = 0;
                th = th2;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                this.zzf.zzp().zza(new zzey(this.zzd, this.zzc, i2, null, null, map2));
                throw th;
            }
            try {
                zzex zzex = this.zzf;
                byte[] bArr = zzex.zza(httpURLConnection);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                this.zzf.zzp().zza(new zzey(this.zzd, this.zzc, responseCode, null, bArr, headerFields));
            } catch (IOException e6) {
                e = e6;
                i = responseCode;
                map = headerFields;
                iOException = e;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                this.zzf.zzp().zza(new zzey(this.zzd, this.zzc, i, iOException, null, map));
            } catch (Throwable th6) {
                th = th6;
                i2 = responseCode;
                map2 = headerFields;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                this.zzf.zzp().zza(new zzey(this.zzd, this.zzc, i2, null, null, map2));
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            httpURLConnection = null;
            map = null;
            i = 0;
            iOException = e;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e8) {
                    this.zzf.zzq().zze().zza("Error closing HTTP compressed POST connection output stream. appId", zzeq.zza(this.zzd), e8);
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.zzf.zzp().zza(new zzey(this.zzd, this.zzc, i, iOException, null, map));
        } catch (Throwable th7) {
            th2 = th7;
            httpURLConnection = null;
            map2 = null;
            i2 = 0;
            th = th2;
            if (outputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            this.zzf.zzp().zza(new zzey(this.zzd, this.zzc, i2, null, null, map2));
            throw th;
        }
    }
}
